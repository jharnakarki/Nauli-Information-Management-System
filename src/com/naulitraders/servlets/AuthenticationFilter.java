package com.naulitraders.servlets;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/*")
public class AuthenticationFilter implements Filter {

   
	public void destroy() {
		// TODO Auto-generated method stub
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest requests=(HttpServletRequest)request;
		HttpServletResponse res=(HttpServletResponse)response;
		if(!requests.getRequestURI().startsWith("/JavaProject/login")) {
			HttpSession session=requests.getSession();
			if(session.getAttribute("username")==null) {
				res.sendRedirect("/JavaProject/login");
				return;
			}
			
		}
		chain.doFilter(requests,response);
	}

	

}
