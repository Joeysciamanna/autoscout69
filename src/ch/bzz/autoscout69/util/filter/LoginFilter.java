package ch.bzz.autoscout69.util.filter;


import ch.bzz.autoscout69.bean.HelperBean;
import ch.bzz.autoscout69.util.message.MessageArray;
import ch.bzz.autoscout69.util.message.MessageStyle;
import ch.bzz.autoscout69.util.message.Message;


import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginFilter implements Filter {

	@Inject
	private HelperBean helperBean;

	@Inject
	private MessageArray msgArray;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
//		HttpServletRequest req = (HttpServletRequest) request;

		String contextPath = ((HttpServletRequest) request).getContextPath();

		if (!helperBean.isLogedIn()) {
			msgArray.addMessage(new Message(MessageStyle.error, "Du hast keine Berechtigung für diese Seite!"));
			((HttpServletResponse) response).sendRedirect(contextPath + "/login.xhtml");
		} else {
			chain.doFilter(request, response);
		}

	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void destroy() {
	}

}
