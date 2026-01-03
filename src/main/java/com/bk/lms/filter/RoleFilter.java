package com.bk.lms.filter;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;

import com.bk.lms.model.User;

public class RoleFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        String uri = req.getRequestURI();
        HttpSession session = req.getSession(false);

        User user = (session != null) ? (User) session.getAttribute("user") : null;

        // Only admin can POST (add course)
        if (uri.endsWith("/courses") && "POST".equalsIgnoreCase(req.getMethod())) {
            if (user == null || !"ADMIN".equalsIgnoreCase(user.getRole())) {
                resp.sendRedirect(req.getContextPath() + "/dashboard.jsp?denied=1");
                return;
            }
        }

        chain.doFilter(request, response);
    }
}
