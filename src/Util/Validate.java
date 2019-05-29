package Util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.Session;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Validate {
	public boolean equa(String pass, String repass) {
		return pass.equalsIgnoreCase(repass);
	}

	public static boolean checkmail(String s) {
		String reg = "^[\\w-_\\.]+\\@[\\w&&[^0-9]]+\\.com$";
		Pattern pattern = Pattern.compile(reg);
		Matcher matcher = pattern.matcher(s);

		if (matcher.matches())
			return true;
		else
			return false;

	}

	public static boolean checkSdt(String sdt) {
		if (!sdt.matches("\\d{8,11}")) {
			return false;

		} else
			return true;
	}

	public int convertStringToInt(String sdt) {
		int con = Integer.parseInt(sdt);
		return con;
	}

	public boolean sendMail(String to, String subject, String text) {
		//cấu hình thuộc tính 
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("shopphoneltw@gmail.com", "abcdabcd");
			}
		});
		try {
			Message message = new MimeMessage(session);
			message.setHeader("Content-Type", "text/plain; charset=UTF-8");
			message.setFrom(new InternetAddress("shopphoneltw@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
			message.setSubject(subject);
			message.setText(text);
			Transport.send(message);
		} catch (MessagingException e) {
			return false;
		}
		return true;
	}

	public String md5(String str) {
		String result = "";
		MessageDigest digest;
		try {
			digest = MessageDigest.getInstance("MD5");
			digest.update(str.getBytes());
			BigInteger bigInteger = new BigInteger(1, digest.digest());
			result = bigInteger.toString(16);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return result;
	}

}
