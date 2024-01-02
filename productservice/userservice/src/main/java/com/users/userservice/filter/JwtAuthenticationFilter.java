package com.users.userservice.filter;

import java.io.IOException;

import org.springframework.web.filter.GenericFilterBean;

import com.users.userservice.entity.UserLogin;
import com.users.userservice.util.JwtUtility;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class JwtAuthenticationFilter extends GenericFilterBean {
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain filterChain)
			throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		try {
			// for handle cross origin 
			  //response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
			 // response.setHeader("Access-Control-Allow-Credentials", "true");
			 // response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
			 // response.setHeader("Access-Control-Max-Age", "3600");
			 // response.setHeader("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With, remember-me");
			String authHeader = request.getHeader("Authorization");
			System.out.println("Header Auth Data: " + authHeader);
			if (authHeader == null || !authHeader.startsWith("Bearer ")) {
				throw new ServletException("Missing or invalid Authorization header");
			}
			final String token = authHeader.substring(7);
			System.out.println("Token value is ::" + token);
			if (token != null && JwtUtility.verifyToken(token)) {
				UserLogin user = JwtUtility.getUserDtoFromToken(token);
				System.out.println("user value is ::" + user);
				request.setAttribute("user", user);
			} else {
				throw new ServletException("Token is invalid!!!");
			}
			filterChain.doFilter(req, res);
		} catch (Exception e) {
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
			response.sendError(HttpServletResponse.SC_FORBIDDEN, e.getMessage());
		}
	}
}
