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

        Object role = session.getAttribute("user_role");
        if (role != null){
            System.out.println(role.toString());
        }
        System.out.println(ip);
        System.out.println(uri);

        chain.doFilter(request, response);
    }
    public void init(FilterConfig config) throws ServletException {
        //conteхt = config.getServletContext();
    }
}
