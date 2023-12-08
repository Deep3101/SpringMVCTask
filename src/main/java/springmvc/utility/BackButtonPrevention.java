package springmvc.utility;


import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = {"/admin","/userDetails"})
public class BackButtonPrevention implements Filter {
    public void destroy() {	}

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse res = (HttpServletResponse) response;
        HttpServletRequest req = (HttpServletRequest) request;

        HttpSession session=req.getSession(false);
        if(session==null)
        {
            res.sendRedirect("welcome");
        }
        else
        {
            res.setHeader("Cache-Control","no-chache,no-store,must-revalidate");
            res.setHeader("Pragma", "no-chache");
            res.setDateHeader("Expires", 0);
            chain.doFilter(request, response);
        }
    }
    public void init(FilterConfig fConfig) throws ServletException {	}

}
