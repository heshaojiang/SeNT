<%@page import="com.grgbanking.platform.core.springsecurity.SpringSecurityUtils"%>
<%@page import="java.util.Map"%>
<%@page import="com.grgbanking.platform.core.utils.AppCoreConstants"%>
<%@page import="com.grgbanking.platform.core.security.vo.Loginer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%!
    	public enum LoginStatus {
    		Normal,LockedWithIP;
		}
    %>
<%
	response.setHeader("Cache-Control","no-store");           
	response.setHeader("Pragrma","no-cache");           
	response.setDateHeader("Expires",0);   
	
	String userName = SpringSecurityUtils.getCurrentUserName();
	LoginStatus loginStatus = LoginStatus.Normal;
	
	Loginer loginer = SpringSecurityUtils.getCurrentUser();
	Map userInfo = loginer.getUserInfo();
	Boolean locked = (Boolean)(userInfo.get(AppCoreConstants.LOCKED_WITH_IP));
	if (locked){
		loginStatus = LoginStatus.LockedWithIP;
	}

%>
userName=<%= userName %>,loginStatus=<%= loginStatus %>