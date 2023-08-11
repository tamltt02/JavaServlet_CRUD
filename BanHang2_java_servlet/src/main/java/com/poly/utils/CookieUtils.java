package com.poly.utils;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CookieUtils {
	@Autowired
	private HttpServletResponse response;

	public Cookie addCookie(String email, String password, boolean remember) {
		Cookie cookie = new Cookie(email, password);
		int hour = remember ? 60 * 60 * 24 : 0;
		cookie.setPath("/");
		cookie.setMaxAge(hour);
		response.addCookie(cookie);
		return cookie;
	}

	
}
