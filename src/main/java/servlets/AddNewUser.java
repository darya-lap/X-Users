package servlets;

import entity.Address;
import entity.Users;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;

public class AddNewUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String str = req.getParameter("firstname");
            if (str == null){
                resp.sendRedirect("/errorNewUser.html");
            }
            str = req.getParameter("lastname");
            if (str == null){
                resp.sendRedirect("/errorNewUser.html");
            }
            str = req.getParameter("username");
            if (str == null){
                resp.sendRedirect("/errorNewUser.html");
            }
            str = req.getParameter("password");
            if (str == null){
                resp.sendRedirect("/errorNewUser.html");
            }
            str = req.getParameter("email");
            if (str == null){
                resp.sendRedirect("/errorNewUser.html");
            }
            str = req.getParameter("birthday");
            if (str == null){
                resp.sendRedirect("/errorNewUser.html");
            }
            str = req.getParameter("activity");
            if (str == null){
                resp.sendRedirect("/errorNewUser.html");
            }
            str = req.getParameter("role");
            if (str == null){
                resp.sendRedirect("/errorNewUser.html");
            }
            str = req.getParameter("zip");
            Integer zip_int = null;
            if (str == null){
                resp.sendRedirect("/errorNewUser.html");
            }
            else{
                try{
                    zip_int = Integer.parseInt(str);
                }
                catch(NumberFormatException e){
                    resp.sendRedirect("/errorNewUser.html");
                }
            }
            str = req.getParameter("country");
            if (str == null){
                resp.sendRedirect("/errorNewUser.html");
            }
            str = req.getParameter("city");
            if (str == null){
                resp.sendRedirect("/errorNewUser.html");
            }
            str = req.getParameter("district");
            if (str == null){
                resp.sendRedirect("/errorNewUser.html");
            }
            str = req.getParameter("street");
            if (str == null){
                resp.sendRedirect("/errorNewUser.html");
            }

            Users user = new Users(req.getParameter("firstname"),
                    req.getParameter("lastname"),
                    req.getParameter("username"),
                    req.getParameter("password"),
                    req.getParameter("email"),
                    req.getParameter("birthday"),
                    req.getParameter("activity"),
                    req.getParameter("role"));
            Address address = new Address(zip_int,
                    req.getParameter("country"),
                    req.getParameter("city"),
                    req.getParameter("district"),
                    req.getParameter("street"));

            System.out.println(user.getBirthday());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}