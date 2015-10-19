package com.bruce.action;  
  
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bruce.util.WXTokenThread;
  
/** 
 * 初始化servlet 
 *  
 * @author liuyq 
 * @date 2013-05-02 
 */  
public class InitServlet extends HttpServlet {  
    private static final long serialVersionUID = 1L;  
    private static Logger log = LoggerFactory.getLogger(WXTokenThread.class);  
  
    public void init(ServletRequest rq, ServletResponse rs) throws ServletException {  
        // 获取web.xml中配置的参数  
        WXTokenThread.appid = getInitParameter("appid");  
        WXTokenThread.appsecret = getInitParameter("appsecret");  
  
        log.info("weixin api appid:{}", WXTokenThread.appid);  
        log.info("weixin api appsecret:{}", WXTokenThread.appsecret);  
  
        // 未配置appid、appsecret时给出提示  
        if ("".equals(WXTokenThread.appid) || "".equals(WXTokenThread.appsecret)) {  
            log.error("appid and appsecret configuration error, please check carefully.");  
        } else {  
            // 启动定时获取access_token的线程  
            new Thread(new WXTokenThread()).start();  
        }  
    }  
}  