package com.bruce.util;

import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.HtmlEmail;

/**
 * 使用apache mail开源项目发送邮件
 * 
 * @author bruce
 */
public class EmailUtil {
	// 程序主方法
	public static void main(String[] args) throws Exception {
		EmailUtil as = new EmailUtil();
		String host = "smtp.163.com";
		String from = "qhdlhe@163.com";
		String username = "qhdlhe@163.com";
		String password = "********";
		// 接收者邮箱
		String to = "654714226@qq.com";
		String subject = "找回密码";
		String mailConent = "找回密码";
		// 调用发送附件邮件方法
		as.sendAttachmentMail(host, from, username, password, to, subject,
				mailConent);
	}

	public boolean sendAttachmentMail(String host, String from,
			String username, String password, String to, String subject,
			String mailConent) throws Exception {
		// 创建附件对象
		 EmailAttachment attachment = new EmailAttachment();
		 /*附件的地址*/
		 attachment.setPath("D://lrc//3934-1399562620.jpg!sq.jpg");
		 //设定为附件
		 attachment.setDisposition(EmailAttachment.ATTACHMENT);
		 /*附件的描述*/
		 attachment.setDescription("图片啊");
		 /*附件的名称，必须和文件名一致*/
		 attachment.setName("image.jpg");
		/* new一个HtmlEmail发送对象 */
		HtmlEmail email = new HtmlEmail();
		email.setAuthentication(username, password);
		email.setHostName(host);
		email.addTo(to, from);
		email.setFrom(from);
		email.setSubject(subject);
		// 注意，发送内容时，后面这段会让中文正常显示，否则乱码
		email.setCharset("GB2312");
		email.setHtmlMsg("<html><body>请点击下面代码找回密码<br><a href=\"http://192.168.0.132:8181/yunlu/admin/changePwd.action?userid=c1ad9466-f4f4-49be-9ae8-34cb4412df7c&authcode=c1ad9466-f4f4-49be-9ae8-34cb4412df7c\" alt=\"c1ad9466-f4f4-49be-9ae8-34cb4412df7c86b293db-5b88-4435-a2e9-ef1fb8a6bfec\">c1ad9466-f4f4-49be-9ae8-34cb4412df7c?&86b293db-5b88-4435-a2e9-ef1fb8a6bfec</a></body></html>"); /* 邮件内容 */
		// 添加附件对象
		email.attach(attachment);
		// 发送
		email.send();
		System.out.println("带符件的邮件发送成功！");
		return true;
	}
}