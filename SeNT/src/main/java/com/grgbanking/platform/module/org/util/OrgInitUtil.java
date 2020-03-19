package com.grgbanking.platform.module.org.util;

import java.io.IOException;
import java.io.StringReader;
import java.util.List;

import javax.servlet.ServletContext;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.xml.sax.InputSource;

import com.grgbanking.platform.core.spring.SpringContextHolder;
import com.grgbanking.platform.core.utils.XmlUtil;
import com.grgbanking.platform.module.org.service.OrgInfoService;

public class OrgInitUtil implements Runnable{
	
	public static String getTreeXmlStrById(String id,String orgInfos){
		StringReader read = new StringReader(orgInfos);
		InputSource source = new InputSource(read);  
		SAXBuilder saxbBuilder = new SAXBuilder();
		String treeXmlStr = "";
		try {  
            //通过输入源构造一个Document  
            Document doc = saxbBuilder.build(source);
            //取的根元素  
            Element root = doc.getRootElement();
            Element tmp = getNodeById(root,id);
            long t1 = System.currentTimeMillis();
            StringBuffer sbu = new StringBuffer();
            getXmlStr(tmp,sbu);
            long t2 = System.currentTimeMillis();
            System.out.println(t2-t1);
            treeXmlStr = XmlUtil.formatXml(sbu);
        } catch (JDOMException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }
        return treeXmlStr;
	}
	
	public static void getXmlStr(Element node,StringBuffer sbu){
		List<?> nodeArr = node.getChildren();
		sbu.append(getNodeStr(node));
        for (int i = 0; i < nodeArr.size(); i++) {
        	getXmlStr((Element)nodeArr.get(i),sbu);
        }
        sbu.append("</node>"); 
	}
	
	public static Element getNodeById(Element root,String orgId){
		long t1 = System.currentTimeMillis();
		if(root.getAttributeValue("id").equals(orgId)){
        	return root;
        }
		List<?> node = root.getChildren();
		Element result = null;
		for (int i = 0; i < node.size(); i++) {
			Element element=(Element)node.get(i);
			if(orgId.equals(element.getAttributeValue("id"))){
				return element;
			}else{
				if(element.getChildren().size()>0){
					result = getNodeById(element,orgId);
					if(result!=null){
						return result;
					}
				}else{
					continue;
				}
			}
		}
		long t2 = System.currentTimeMillis();
		System.out.println(t2-t1);
		return result;
	}
	
	public static String getNodeStr(Element element){
		String nodeStr = "<node id=\""+element.getAttributeValue("id")+
		"\" label=\""+element.getAttributeValue("label")+
		"\" orgName=\""+element.getAttributeValue("orgName")+
		"\" orgFullName=\""+element.getAttributeValue("orgFullName")+
		"\" contact=\""+element.getAttributeValue("contact")+
		"\" tel=\""+element.getAttributeValue("tel")+
		"\" address=\""+element.getAttributeValue("address")+
		"\" status=\""+element.getAttributeValue("status")+
		"\" level=\""+element.getAttributeValue("level")+
		"\" orgCode=\""+element.getAttributeValue("orgCode")+
		"\" order=\""+element.getAttributeValue("order")+
		"\" pathCode=\""+element.getAttributeValue("pathCode")+"\" >";
		return nodeStr;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		WebApplicationContext webApplicationContext 
			= ContextLoader.getCurrentWebApplicationContext();
		ServletContext servletContext = webApplicationContext.getServletContext();
		OrgInfoService orgInfoService = SpringContextHolder.getBean("orgInfoService");
		String orgInfoEnableTreeXmlStr = orgInfoService.initEnabledOrgTree("0000100001");
		servletContext.setAttribute("orgInfoEnableTreeXmlStr", orgInfoEnableTreeXmlStr);
	}
	
	
	
}
