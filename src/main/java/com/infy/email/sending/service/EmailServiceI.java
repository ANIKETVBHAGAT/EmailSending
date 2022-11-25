package com.infy.email.sending.service;

import com.infy.email.sending.model.EmailSender;

public interface EmailServiceI {

	public void sendEmail(EmailSender e);

	public void sendEmailWithAttached(EmailSender e);

}
