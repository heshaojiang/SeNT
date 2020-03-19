package com.grgbanking.platform.core.security.service;

import java.util.Properties;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanInitializationException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;



public class EncryptablePropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer {
    private static final String KEY = "123456789012345612345678";
    private static final String Algorithm = "DESede"; //定义 加密算法,可用 DES,DESede,Blowfish 
    
    private static final String PROPERTY_ISENCRYPT = "isEncrypt";
    private static final String PROPERTY_USERNAME = "jdbc.username";
    private static final String PROPERTY_PASSWORD = "jdbc.password";
    private static final String PROPERTY_URL = "jdbc.url";
    
    private boolean encrypt = false;
    

    public void setEncrypt(boolean isEncrypt) {
		this.encrypt = isEncrypt;
	}

	protected void processProperties(ConfigurableListableBeanFactory beanFactory, Properties props)
        throws BeansException {
            try {
            	
            	//String isEncrypt = props.getProperty(PROPERTY_ISENCRYPT);
            	
            	if(encrypt){
                String username = props.getProperty(PROPERTY_USERNAME);
                if (username != null) {
                    props.setProperty(PROPERTY_USERNAME,  new String(subByteForNoPadding(decryptMode(KEY.getBytes(),hex2byte(username)))));
                }
                
                String password = props.getProperty(PROPERTY_PASSWORD);
                if (password != null) {
                    props.setProperty(PROPERTY_PASSWORD,  new String(subByteForNoPadding(decryptMode(KEY.getBytes(),hex2byte(password)))));
                   
                }
                String url = props.getProperty(PROPERTY_URL);
                if (url != null) {
                	if(url.indexOf("jdbc:oracle")>-1){
                  		url = url.split("@")[0]+"@"+ new String(subByteForNoPadding(decryptMode(KEY.getBytes(),hex2byte(url.split("@")[1]))));
                  	}else if(url.indexOf("jdbc:mysql")>-1){
                  		String[] urls =  url.split("[?]");
                  		url = urls[0].split("//")[0]+"//"+new String(subByteForNoPadding(decryptMode(KEY.getBytes(),hex2byte(urls[0].split("//")[1]))))+"?"+urls[1];
                  	}
                    props.setProperty(PROPERTY_URL,  url);
                   
                }
               }

                super.processProperties(beanFactory, props);
            } catch (Exception e) {
                e.printStackTrace();
                throw new BeanInitializationException(e.getMessage());
            }
        }
    
    // keybyte为加密密钥，长度为24字节
	// src为被加密的数据缓冲区（源）
	public byte[] encryptMode(byte[] keybyte, byte[] src) {
		try {
			// 生成密钥
			SecretKey deskey = new SecretKeySpec(keybyte, Algorithm);
			// 加密
			Cipher c1 = Cipher.getInstance("DESede/ECB/NoPadding");
			c1.init(Cipher.ENCRYPT_MODE, deskey);
			return c1.doFinal(src);// 在单一方面的加密或解密
		} catch (java.security.NoSuchAlgorithmException e1) {
			// TODO: handle exception
			e1.printStackTrace();
		} catch (javax.crypto.NoSuchPaddingException e2) {
			e2.printStackTrace();
		} catch (java.lang.Exception e3) {
			e3.printStackTrace();
		}
		return null;
	}

	// keybyte为加密密钥，长度为24字节
	// src为加密后的缓冲区
	public byte[] decryptMode(byte[] keybyte, byte[] src) {
		try {
			// 生成密钥
			SecretKey deskey = new SecretKeySpec(keybyte, Algorithm);
			// 解密
			Cipher c1 = Cipher.getInstance("DESede/ECB/NoPadding");
			c1.init(Cipher.DECRYPT_MODE, deskey);
			return c1.doFinal(src);
		} catch (java.security.NoSuchAlgorithmException e1) {
			// TODO: handle exception
			e1.printStackTrace();
		} catch (javax.crypto.NoSuchPaddingException e2) {
			e2.printStackTrace();
		} catch (java.lang.Exception e3) {
			e3.printStackTrace();
		}
		return null;
	}

	// 转换成十六进制字符串
	  public  String byte2HexStr(byte[] b) {

		  String hs = "";
		  String stmp = "";
		  for (int n = 0; n < b.length; n++) {
		  stmp = (Integer.toHexString(b[n] & 0XFF));
		  if (stmp.length() == 1)
		  hs = hs + "0" + stmp;
		  else
		  hs = hs + stmp;
		  }
		  return hs.toUpperCase();

		  }
	  
	  public static byte[] string2ByteForNoPadding(String src) {
		  
		  int mod = src.length()%8;
		  if(mod==0) mod=8;
		  byte[] b = new byte[src.length()+8-mod];
		  
		  byte[] srcBytes  = src.getBytes();
		  for(int i=0;i<b.length;i++){
			  if(i<src.length()){
				  b[i] =  srcBytes[i];  
			  }else{
				  b[i] =(byte)0x00;
			  }
			  
		  }
		  return b;

		}
	  
		public static byte[] subByteForNoPadding(byte[] b) {
			  
			  String hs = "";
			  String stmp = "";
			  
			  int length = 0;
			  for (int n = b.length-1; n>=0; n--) {
				  if(b[n]!=(byte)0x00){
					  length = n+1;  
					  break;
				  }
			  }
			  byte[] t = new byte[length];
			  
			  for (int n = 0; n<length; n++) {
				  t[n] = b[n];
			  }
			  return t;
		}
		
		//16 进制 转 2 进制
		public byte[] hex2byte(String hex) throws IllegalArgumentException {     
		    if (hex.length() % 2 != 0) {     
		        throw new IllegalArgumentException();     
		    }     
		    char[] arr = hex.toCharArray();     
		    byte[] b = new byte[hex.length() / 2];     
		    for (int i = 0, j = 0, l = hex.length(); i < l; i++, j++) {     
		        String swap = "" + arr[i++] + arr[i];     
		        int byteint = Integer.parseInt(swap, 16) & 0xFF;     
		        b[j] = new Integer(byteint).byteValue();     
		    }     
		    return b;     
		} 

    }