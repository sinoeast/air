package info.sinoeast.lt.filter;

import info.sinoeast.lt.bean.Manager;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
public class ManagerFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("mangerFilter init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpSession httpSession = httpRequest.getSession();
        Manager user = (Manager) httpSession.getAttribute("manAccount");
        if(user == null){
            System.out.println("当前用户未登录");
            httpRequest.getRequestDispatcher("/Manager.jsp")
                    .forward(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }

}