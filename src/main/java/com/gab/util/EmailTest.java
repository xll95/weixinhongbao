package com.gab.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
public class EmailTest {
	
	public static void main(String[] args) throws MessagingException {
		Properties prop=new Properties();
		prop.put("mail.host","smtp.163.com" );
		prop.put("mail.transport.protocol", "smtp");
		prop.put("mail.smtp.auth", true);
		//使用java发送邮件5步骤
		//1.创建sesssion
		Session session=Session.getInstance(prop);
		//开启session的调试模式，可以查看当前邮件发送状态
		session.setDebug(true);
 
		//2.通过session获取Transport对象（发送邮件的核心API）
		Transport ts=session.getTransport();
		//3.通过邮件用户名密码链接
		//邮箱名", "授权码"
		ts.connect("dimash_diko@163.com", "diko15574708702");
		//4.创建邮件
		Message msg=createSimpleMail(session);
 
		//5.发送电子邮件
		ts.sendMessage(msg, msg.getAllRecipients());
		
	}
	
	public static MimeMessage createSimpleMail(Session session) throws AddressException,MessagingException{
		//创建邮件对象
		MimeMessage mm=new MimeMessage(session);
		//设置发件人
		mm.setFrom(new InternetAddress("dimash_diko@163.com"));
		//设置收件人
		mm.setRecipient(Message.RecipientType.TO, new InternetAddress("dimash_xll@163.com"));
		//设置抄送人
		//mm.setRecipient(Message.RecipientType.CC, new InternetAddress("dimash_xll@163.com"));
		Date d=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String day=sdf.format(d);
 
		mm.setSubject("客户订单信息！");
		String name="迪玛希";
		int num=20;
		String addr="哈萨克斯坦阿斯塔纳迪玛希家";
		String phone="13723466538";
		String con="<span style='font-size:16px;font-weight:blod;'>您好！<br/>&nbsp;&nbsp;&nbsp;&nbsp;订单信息如下,请查收：</span><br/>&nbsp;&nbsp;&nbsp;&nbsp;<table style='width:800px'  border='1px' cellpadding='15px' cellspacing='0px' >"
				+ "<tr><td>客户姓名</td><td>订单数量</td><td>配送地址</td><td>联系方式</td></tr>"
				+ "<tr ><td>"+name+"</td><td>"+num+"</td><td>"+addr+"</td><td>"+phone+"</td></tr>"
				+ "</table>";
		mm.setContent(con, "text/html;charset=utf-8");
		return mm;
	}

}

