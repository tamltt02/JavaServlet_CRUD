package Service;

import javax.servlet.ServletContext;

import Entitty.User;

public interface EmailSerVice {
void sendEmail(ServletContext context, User recipient, String type);
}
