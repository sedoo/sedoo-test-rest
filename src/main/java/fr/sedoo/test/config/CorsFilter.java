package fr.sedoo.test.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import lombok.extern.slf4j.Slf4j;


    @Slf4j
	@Component
	public class CorsFilter extends OncePerRequestFilter {
		
		public CorsFilter() {
			log.info("CorsFilter constructor");
		}
	 
	    @Override
	    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
	            throws ServletException, IOException {
	    	log.info("CORS !!!");
	        String origin = request.getHeader(HttpHeaders.ORIGIN);
	        if (origin != null) {
	            response.setHeader("Access-Control-Allow-Origin", origin);
	        }
	        response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
	        response.setHeader("Access-Control-Max-Age", "3600");
	        response.setHeader("Access-Control-Allow-Headers", "authorization, content-type, xsrf-token");
	        response.addHeader("Access-Control-Expose-Headers", "xsrf-token");
	        response.setHeader("Access-Control-Allow-Credentials", "true");
	        if ("OPTIONS".equals(request.getMethod())) {
	            response.setStatus(HttpServletResponse.SC_OK);
	        } else {
	            filterChain.doFilter(request, response);
	        }
	    }
	}

