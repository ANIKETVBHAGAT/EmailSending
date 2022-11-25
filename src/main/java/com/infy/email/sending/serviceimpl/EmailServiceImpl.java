package com.infy.email.sending.serviceimpl;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.infy.email.sending.model.EmailSender;
import com.infy.email.sending.service.EmailServiceI;

@Service
public class EmailServiceImpl implements EmailServiceI{

	@Autowired JavaMailSender sender;
	
	@Override
	public void sendEmail(EmailSender e) {
		
		SimpleMailMessage messege=new SimpleMailMessage();
		messege.setFrom(e.getFromEmail());
		messege.setTo(e.getToEmail());
		messege.setText(e.getTxtmsg());
		messege.setSubject(e.getSubject());
		sender.send(messege);
		System.out.println("Email Send");
		
	}

	@Override
	public void sendEmailWithAttached(EmailSender e) {
		MimeMessage msg=sender.createMimeMessage();
		try 
		{
			MimeMessageHelper helper=new MimeMessageHelper(msg,true);
			helper.setFrom(e.getFromEmail());
			helper.setTo(e.getToEmail());
			helper.setText(e.getTxtmsg());
			helper.setSubject(e.getSubject());
			
			FileSystemResource resource=new FileSystemResource("C:/Users/HP/Desktop/Notes/Angular/1_Angular Notes.pdf");
			helper.addAttachment(resource.getFilename(), resource);
			sender.send(msg);
		} 
		catch (Exception e2) 
		{
			e2.printStackTrace();
		}
		
	}

}
