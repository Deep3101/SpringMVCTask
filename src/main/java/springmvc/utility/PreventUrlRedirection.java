package springmvc.utility;


import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;


@WebFilter({"/","/welcome","/login","/register","/forgotPassword"})
public class PreventUrlRedirection implements Filter {

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse res = (HttpServletResponse) response;
        HttpServletRequest req = (HttpServletRequest) request;

        HttpSession session=req.getSession(false);
        Object obj = null;
        if (session!=null){
            obj = session.getAttribute("loggedIn");
        }
        if (obj != null){
            String loggedIn = (String) obj;
            if (loggedIn.equals("ADMIN")){
                res.sendRedirect("admin");
            }else {
                res.sendRedirect("userDetails");
            }
        }
        else
        {
            res.setHeader("Cache-Control","no-chache,no-store,must-revalidate");
            res.setHeader("Pragma", "no-chache");
            res.setDateHeader("Expires", 0);
            chain.doFilter(request, response);
        }
    }
}
