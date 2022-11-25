package com.infy.email.sending.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.infy.email.sending.model.EmailSender;
import com.infy.email.sending.service.EmailServiceI;

import lombok.extern.slf4j.Slf4j;


@RestController
@Slf4j
public class EmailSenderController {

	@Autowired EmailServiceI es;
	
	@Value("${spring.mail.username}")
	private String username;
	
	@PostMapping(value = "/email")
	public String sendEmail(@RequestBody EmailSender e)
	{
		e.setFromEmail(username);
		try 
		{
			es.sendEmail(e);
		} 
		catch (Exception e2) 
		{
			return "Email Not Send";
		}
		log.info("Call Send To Email");
		return "email Send";
	}
	
	@PostMapping(value = "/emails")
	public String sendEmailWithAttached(@RequestBody EmailSender e)
	{
		e.setFromEmail(username);
		try 
		{
			es.sendEmailWithAttached(e);
		} 
		catch (Exception e2) 
		{
			return "Email Not Send";
		}
		log.info("call Sender");
		return "Email Send";
	}
}
