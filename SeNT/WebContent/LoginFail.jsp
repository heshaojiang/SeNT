
<%@page import="com.grgbanking.platform.common.Constants.AppConstants"%>
<%@page import="com.grgbanking.platform.core.security.service.interfaces.IUserService"%>
<%@page import="com.grgbanking.platform.core.springsecurity.SpringSecurityUtils"%><%@page import="java.util.Map"%>
<%@page import="com.grgbanking.platform.core.utils.AppCoreConstants"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%!
    public enum LoginStatus {
    	Normal, UserNotExisted, AccountDisabled, AccountLockedWithIP, AccountExpired, PasswordExpired, WrongPassword
	}
    %>
<%

	response.setHeader("Cache-Control","no-store");           
	response.setHeader("Pragrma","no-cache");           
	response.setDateHeader("Expires",0);   
	
	String userName = (String)session.getAttribute("SPRING_SECURITY_LAST_USERNAME");
	String maxLoginFailCount = application.getAttribute(AppConstants.MAX_LOGIN_FAIL_COUNT).toString();
	Object passwordFailCount = 0;
	
	LoginStatus loginStatus = LoginStatus.Normal;
	
	Object ex = session.getAttribute("SPRING_SECURITY_LAST_EXCEPTION");
	//System.out.println(ex);
	if (ex instanceof org.springframework.security.userdetails.UsernameNotFoundException){
		loginStatus = LoginStatus.UserNotExisted;
	}else if(ex instanceof org.springframework.security.DisabledException){
		loginStatus = LoginStatus.AccountDisabled;
	}else if(ex instanceof org.springframework.security.LockedException){
		loginStatus = LoginStatus.AccountLockedWithIP;
	}else if(ex instanceof org.springframework.security.AccountExpiredException){
		loginStatus = LoginStatus.AccountExpired;
	}else if(ex instanceof org.springframework.security.CredentialsExpiredException){
		loginStatus = LoginStatus.PasswordExpired;
	}else {
		loginStatus = LoginStatus.WrongPassword;
		
		IUserService service = com.grgbanking.platform.core.spring.SpringContextHolder.getBean("userService");
		Map userInfo = service.getUserInfoByUserCode(userName);
		passwordFailCount = userInfo.get(AppConstants.LOGIN_FAIL_COUNT);
		
		if(!(ex instanceof org.springframework.security.AuthenticationException)){
			org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(getClass());
			logger.error("Unknown Error!", ex);
		}
	}
%>
userName=<%= userName %>,passwordFailCount=<%= passwordFailCount %>,maxLoginFailCount=<%= maxLoginFailCount %>,loginStatus=<%=loginStatus %>