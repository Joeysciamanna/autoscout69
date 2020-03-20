package ch.bzz.autoscout69.util.filter;


import ch.bzz.autoscout69.bean.HelperBean;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HomeRedirectionFilter implements Filter {

	 @Inject
	 private HelperBean helperBean;
	
	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		String contextPath = ((HttpServletRequest) request).getContextPath();

		if (helperBean.isLogedIn()) {
			((HttpServletResponse) response).sendRedirect(contextPath + "/home.xhtml");
		} else {
			chain.doFilter(request, response);
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

}
