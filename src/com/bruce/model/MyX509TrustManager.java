package com.bruce.model;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.X509TrustManager; 

/**
 * ֤�����ι�����������https����
*    
* ��Ŀ���ƣ�WeiXin
* �����ƣ�MyX509TrustManager   
* ��������   
* �����ˣ�bruce
* ����ʱ�䣺2015-1-13 15:28:45
* �޸ı�ע��   
* @version    
*
 */

public class MyX509TrustManager implements X509TrustManager {

	public void checkClientTrusted(X509Certificate[] chain, String authType)
			throws CertificateException {
		// TODO Auto-generated method stub
		
	}

	public void checkServerTrusted(X509Certificate[] chain, String authType)
			throws CertificateException {
		// TODO Auto-generated method stub
		
	}

	public X509Certificate[] getAcceptedIssuers() {
		// TODO Auto-generated method stub
		return null;
	}

}
