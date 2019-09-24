package com.gildosiqueira.cursomc.services;

import org.springframework.mail.SimpleMailMessage;

import com.gildosiqueira.cursomc.domain.Pedido;

public interface EmailService {
	
	void sendOrderConfirmationEmail(Pedido obj);
	
	void sendEmail(SimpleMailMessage msg);

}
