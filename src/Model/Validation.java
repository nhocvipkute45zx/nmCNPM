package Model;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Validation {

	public boolean isEmpty(String text) {

		return text.length() == 0;
		
	}

	public boolean equa(String pass, String repass) {
		return pass.equalsIgnoreCase(repass);
	}

	public boolean isValidDate(String date) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date testDate = null;
		try {
			testDate = (Date) sdf.parse(date);
		} catch (ParseException e) {
			return false;
		}
		if (!sdf.format(testDate).equals(date)) {
			return false;
		}
		return true;

	}

	public boolean sendMail(String to, String subject, String text) {
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

	public String convertStringToDate(Date indate) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

		String dateFormat = formatter.format(indate);

		return dateFormat;
	}

}