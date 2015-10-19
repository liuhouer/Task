/**
 * 
 */
package com.bruce.util;


import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

/**
 * @author bruce
 *
 */
public class TokenHandler {
	
	 
	        //生成一个唯一值的token
	    @SuppressWarnings("unchecked")
	    public synchronized static String generateToken(HttpSession session) {
	        String token = "";
	        token = UUID.getUUID().toString();
	        System.out.println(token);
	        session.setAttribute("token", token);
	        return token;
	    }
	 
	       //验证表单token值和session中的token值是否一致
	    @SuppressWarnings("unused")
	    public static boolean isTokenValid(HttpServletRequest request) {  
	        /*方法说明： 
	        *专门写个方法校验表单是否重复提交 
	        *1，客户端token为空（防坏人自定义表单） 
	        *2，服务器token为空（提交过了，已经清除了） 
	        *3，两者是否相等 
	        */  
	        String c_token=request.getParameter("token");  
	        if (c_token==null) {  
	           return false;  
	        }  
	        String s_token=(String) request.getSession().getAttribute("token");  
	        if (s_token==null) {  
	           return false;  
	        }  
	        if (!c_token.equals(s_token)) {  
	           return false;  
	        }  
	        //代码同struts一样，闯过前三关才为true  
	        return true;  
	     }  
	   
	    public  static void clearMvcToken(HttpSession session) {
	       
	        session.removeAttribute("token");
	        
	    }
	 
}
