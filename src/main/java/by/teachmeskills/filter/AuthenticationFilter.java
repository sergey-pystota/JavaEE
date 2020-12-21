package by.teachmeskills.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebFilter(urlPatterns = "/*")
public class AuthenticationFilter implements Filter {

    private static final List<String> PUBLIC_PAGES = List.of("/registration", "/login", "/startpage", "/profile");

    @Override
    public void init(FilterConfig filterConfig) {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        var req = (HttpServletRequest) request;
        var resp = (HttpServletResponse) response;

        if (PUBLIC_PAGES.contains(req.getServletPath())) {
            chain.doFilter(request, response);
            return;
        }

        if ("true".equals(req.getSession().getAttribute("authorized"))) {
            chain.doFilter(request, response);
        }

        req.getRequestDispatcher("/login.jsp").forward(req, resp);
    }

    @Override
    public void destroy() {

    }

}
