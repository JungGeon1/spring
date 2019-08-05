package guestbook.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface GuestBookService {
	
	String getViewName(HttpServletRequest request, HttpServletResponse response);

}
