package filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "LogFilter")
public class AdminFilter implements Filter {

    private ServletContext conteхt;

    public AdminFilter() {}
    public void destroy() {}

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpReq = (HttpServletRequest) request;
        String ip = httpReq.getRemoteAddr();
        String uri = httpReq.getRequestURI();
        HttpSession session = ((HttpServletRequest) request).getSession();

        String role = session.getAttribute("user_role").toString();
        System.out.println(role);

        chain.doFilter(request, response);
    }
    public void init(FilterConfig config) throws ServletException {
        //conteхt = config.getServletContext();
    }
}
