package servlets;

import DAO.Factory;
import entity.Users;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

public class AuthServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        HttpSession session = req.getSession();

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        try {
            Users user = Factory.getInstance().getUserDAO().getUsersByUsername(username);
            if (user != null){
                String db_password = user.getPassword();
                if (password.equals(db_password)){
                    session.setAttribute("user_name",user.getFirstname());
                    session.setAttribute("user_surname", user.getLastname());
                    session.setAttribute("user_role", user.getRole());
                    if (user.getRole().equals("admin")) {
                        resp.sendRedirect("/admin.html?role=admin&name=" + user.getFirstname() + "&surname=" + user.getLastname());
                    }
                    else{
                        resp.sendRedirect("/user.html?role=user&name=" + user.getFirstname() + "&surname=" + user.getLastname());
                    }
                }
                else{
                    resp.sendRedirect("/errorAuth.html");
                }
            }
            else{
                resp.sendRedirect("/errorAuth.html");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
