package com.bruce.test;

import com.bruce.util.Base64Util;
import com.bruce.util.EmailUtil;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

public class Mails {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
		EmailUtil as = new EmailUtil();
		String host = "smtp.163.com";
		String from = "qhdlhe@163.com";
		String username = "qhdlhe@163.com";
		String password = new String(Base64.decode("MTM0ODM3MjQwNTE="));
		// 接收者邮箱
		String to = "654714226@qq.com";
		String subject = "找回密码";
		String mailConent = "找回密码";
		// 调用发送附件邮件方法
		
			as.sendAttachmentMail(host, from, username, password, to, subject,
					mailConent);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
