package com.playsafeholding.assessment.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * logs for the execution time of request
 * 
 * @author mahesh
 *
 */

@Component
@WebFilter("/*")
public class DurationFilter implements Filter {
	private static final Logger LOGGER = LoggerFactory.getLogger(DurationFilter.class);
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
        long time = System.currentTimeMillis();
        try {
            chain.doFilter(request, response);
        } finally {
            time = System.currentTimeMillis() - time;
            LOGGER.info("Execution Duration: {}: {} ms ", ((HttpServletRequest) request).getRequestURI(),  time);
        }
	}
}
