package com.poly;

import java.util.Properties;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class ResourceConfiguration {
   @Bean("messageSource")
   public MessageSource getMessage() {
	   ReloadableResourceBundleMessageSource ms = 
				new ReloadableResourceBundleMessageSource();
		ms.setBasename("classpath:message/category");
		ms.setDefaultEncoding("utf-8");
		return ms;
   }
   @Bean
   public JavaMailSender getJavaMailSender() {
       JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
       mailSender.setHost("smtp.gmail.com");
       mailSender.setPort(587);
       
       mailSender.setUsername("itachi020914@gmail.com");
       mailSender.setPassword("prercnnzouytvsdg");
       
       Properties props = mailSender.getJavaMailProperties();
       props.put("mail.transport.protocol", "smtp");
       props.put("mail.smtp.auth", "true");
       props.put("mail.smtp.starttls.enable", "true");
       props.put("mail.debug", "true");
       
       return mailSender;
   }
}
