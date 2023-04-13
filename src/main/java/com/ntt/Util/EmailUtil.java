package com.ntt.Util;

import java.io.File;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailUtil {

	@Autowired
	private JavaMailSender mailsender;
	
	public boolean sendEmail(String sub, String body, String to, File f) {
		try {
		MimeMessage  mimeMsg=mailsender.createMimeMessage();
		MimeMessageHelper helper=new MimeMessageHelper(mimeMsg,true);
		
			helper.setSubject(sub);
		helper.setText(body,true);
		helper.setTo(to);
		helper.addAttachment("Plans-info", f);
		mailsender.send(mimeMsg);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return true;
		
	}
}
