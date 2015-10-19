package com.bruce.util;  
  
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bruce.model.AccessToken;
import com.bruce.model.MyX509TrustManager;
  
/** 
 * 定时获取微信access_token的线程 
 *  
 * @author bruce
 * @date 2015-1-13 
 */  

/*
 * 正式的
 * 
AppID(应用ID)
wx823a64ccacea6d6a
AppSecret(应用密钥)
76de6e0778e2e1f3638c024c7fe1dc5c 

*/

/*
 * 测试的
 * 

开发者ID
AppID(应用ID)wxa94898ee89beb79e
AppSecret(应用密钥)b466f07d204a00d01869af8ac08355b9 隐藏 重置

*/


public class WXTokenThread implements Runnable {  
	

	// 获取access_token的接口地址（GET） 限200（次/天）   
	public final static String access_token_url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET"; 
    
	
	private static Logger log = LoggerFactory.getLogger(WXTokenThread.class);  
    // 第三方用户唯一凭证  
    public static String appid = "";  
    // 第三方用户唯一凭证密钥  
    public static String appsecret = "";  
    public static AccessToken accessToken = null;  
  
    public void run() {  
        while (true) {  
            try {  
                accessToken = getAccessToken(appid, appsecret);
                if (null != accessToken) {  
                    log.info("获取access_token成功，有效时长{}秒 token:{}", accessToken.getExpiresIn(), accessToken.getToken());  
                    // 休眠7000秒  
                    Thread.sleep((Integer.parseInt(accessToken.getExpiresIn()) - 200) * 1000);  
                } else {  
                    // 如果access_token为null，60秒后再获取  
                    Thread.sleep(60 * 1000);  
                }  
            } catch (InterruptedException e) {  
                try {  
                    Thread.sleep(60 * 1000);  
                } catch (InterruptedException e1) {  
                    log.error("{}", e1);  
                }  
                log.error("{}", e);  
            }  
        }  
    }  
    
    
    
    public static AccessToken getAccessToken(String appid,String appsecret){
		AccessToken accessToken=null;
		String requestUrl=access_token_url.replace("APPID", appid).replace("APPSECRET", appsecret);
		JSONObject jsonObject=httpsRequest(requestUrl, "GET", null);
		
		//如果请求成功
		if(jsonObject!=null){
			try{
				accessToken=new AccessToken();
				accessToken.setToken(jsonObject.getString("access_token"));
				accessToken.setExpiresIn(jsonObject.getString("expires_in"));
			}catch (Exception e) {
				// TODO: handle exception
				// TODO: handle exception
				accessToken=null;
				 // 获取token失败   
	            log.error("获取token失败 errcode:{"+jsonObject.getInt("errcode")+"} errmsg:{"+jsonObject.getString("errmsg")+"}"); 

			}
		}
		return accessToken;
	}
    
    
    /**
	 * 发起https请求
	 * @param requestUrl 请求地址
	 * @param requestMethod 请求方式（Get或者post）
	 * @param outputStr 提交数据
	 * @return
	 */
	public static JSONObject httpsRequest(String requestUrl,String requestMethod,String outputStr){
		JSONObject jsonObject=null;
		StringBuffer buffer=new StringBuffer();
		try{
			//创建SSLcontext管理器对像，使用我们指定的信任管理器初始化
			TrustManager[] tm={new MyX509TrustManager()};
			SSLContext sslContext=SSLContext.getInstance("SSL","SunJSSE");
			sslContext.init(null, tm, new java.security.SecureRandom());
			SSLSocketFactory ssf=sslContext.getSocketFactory();
			
			URL url= new URL(requestUrl);
			HttpsURLConnection httpsUrlConn=(HttpsURLConnection)url.openConnection();
		    httpsUrlConn.setSSLSocketFactory(ssf);
		    httpsUrlConn.setDoInput(true);
		    httpsUrlConn.setDoOutput(true);
		    httpsUrlConn.setUseCaches(false);
		    //设置请求方式（GET/POST）
		    httpsUrlConn.setRequestMethod(requestMethod);
		    if("GET".equalsIgnoreCase(requestMethod)){
		    	httpsUrlConn.connect();
		    }
		    
		    //当有数据需要提交时
		    if(outputStr!=null){
		    	OutputStream outputStream=httpsUrlConn.getOutputStream();
		    	//防止中文乱码
		    	outputStream.write(outputStr.getBytes("UTF-8"));
		    	outputStream.close();
		    	outputStream=null;
		    }
		    
		    //将返回的输入流转换成字符串
		    InputStream inputStream=httpsUrlConn.getInputStream();
		    InputStreamReader inputStreamReader=new InputStreamReader(inputStream,"UTF-8");
		    BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
		    
		    String str=null;
		    while((str=bufferedReader.readLine())!=null){
		    	buffer.append(str);
		    }
		    
		    bufferedReader.close();
		    inputStreamReader.close();
		    
		    inputStream.close();
		    inputStream=null;
		    
		    httpsUrlConn.disconnect();
		    jsonObject=JSONObject.fromObject(buffer.toString());
		    System.out.println(jsonObject);
		    
		}   
		catch (ConnectException ce) {
			// TODO: handle exception
			log.error("Weixin server connection timed out.");
		} 	
		catch (Exception e) {
			// TODO: handle exception
			log.error("https request error:{}", e);
		}
		
		return jsonObject;
	}
}  