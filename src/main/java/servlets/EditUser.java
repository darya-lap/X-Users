package servlets;

import DAO.Factory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EditUser extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Object attr = session.getAttribute("user_role");
        if ((attr != null) && (attr.toString().equals("admin"))){
            try {
                String str = req.getParameter("firstname");
                if (str == null) {
                    resp.sendRedirect("/editUser.html?correctInput=false");
                }
                str = req.getParameter("lastname");
                if (str == null) {
                    resp.sendRedirect("/editUser.html?correctInput=false");
                }
                str = req.getParameter("username");
                if (str == null) {
                    resp.sendRedirect("/editUser.html?correctInput=false");
                }
                str = req.getParameter("password");
                if (str == null) {
                    resp.sendRedirect("/editUser.html?correctInput=false");
                }
                str = req.getParameter("email");
                if (str == null) {
                    resp.sendRedirect("/editUser.html?correctInput=false");
                }
                String birth = req.getParameter("birthday");

                Date result = null;
                if (str == null) {
                    resp.sendRedirect("/editUser.html?correctInput=false");
                }
                else{
                    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                    try {
                        result = df.parse(birth);
                    }
                    catch(ParseException e){
                        resp.sendRedirect("/editUser.html?correctInput=false");
                    }
                }
                str = req.getParameter("activity");
                int act = 1;
                if (str == null) {
                    resp.sendRedirect("/editUser.html?correctInput=false");
                }
                else{
                    if (str.equals("active")){
                        act = 1;
                    }
                    else{
                        act = 0;
                    }
                }
                str = req.getParameter("role");
                if (str == null) {
                    resp.sendRedirect("/editUser.html?correctInput=false");
                }
                str = req.getParameter("zip");
                Integer zip_int = null;
                if (str == null) {
                    resp.sendRedirect("/editUser.html?correctInput=false");
                } else {
                    try {
                        zip_int = Integer.parseInt(str);
                    } catch (NumberFormatException e) {
                        resp.sendRedirect("/editUser.html?correctInput=false");
                    }
                }
                str = req.getParameter("country");
                if (str == null) {
                    resp.sendRedirect("/editUser.html?correctInput=false");
                }
                str = req.getParameter("city");
                if (str == null) {
                    resp.sendRedirect("/editUser.html?correctInput=false");
                }
                str = req.getParameter("district");
                if (str == null) {
                    resp.sendRedirect("/editUser.html?correctInput=false");
                }
                str = req.getParameter("street");
                if (str == null) {
                    resp.sendRedirect("/editUser.html?correctInput=false");
                }

                String idd = req.getParameter("id");
                Integer id = Integer.parseInt(idd);

                boolean isSuccess = Factory.getInstance().getUserDAO().updateUsersName(id,req.getParameter("username"));
                if (isSuccess){
                    isSuccess = Factory.getInstance().getUserDAO().updateUsersLastname(id,req.getParameter("lastname"));
                    if (isSuccess){
                        isSuccess = Factory.getInstance().getUserDAO().updateUsersName(id,req.getParameter("firstname"));
                        if (isSuccess){
                            isSuccess =Factory.getInstance().getUserDAO().updateUsersPassword(id,req.getParameter("password"));
                            if (isSuccess){
                                isSuccess =Factory.getInstance().getUserDAO().updateUsersEmail(id,req.getParameter("email"));
                                if (isSuccess){
                                    isSuccess = Factory.getInstance().getUserDAO().updateUsersBirthday(id,result);
                                    if (isSuccess){
                                        isSuccess = Factory.getInstance().getUserDAO().updateUsersActivity(id,act);
                                        if (isSuccess){
                                            isSuccess = Factory.getInstance().getUserDAO().updateUsersRole(id,req.getParameter("role"));
                                            if (isSuccess){
                                                isSuccess = Factory.getInstance().getAddressDAO().updateZip(id,zip_int);
                                                if (isSuccess){
                                                    isSuccess = Factory.getInstance().getAddressDAO().updateCountry(id,req.getParameter("country"));
                                                    if (isSuccess){
                                                        isSuccess = Factory.getInstance().getAddressDAO().updateCity(id, req.getParameter("city"));
                                                        if (isSuccess){
                                                            isSuccess = Factory.getInstance().getAddressDAO().updateDistrict(id, req.getParameter("district"));
                                                            if (isSuccess){
                                                                isSuccess = Factory.getInstance().getAddressDAO().updateStreet(id, req.getParameter("street"));
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

                if (isSuccess) {
                    resp.sendRedirect("/editUser.html?isSuccessUpd=true");
                }
                else{
                    resp.sendRedirect("/editUser.html?isSuccessUpd=false");
                }

            } catch ( SQLException e) {
                e.printStackTrace();
            }
        }
        else{
            resp.sendRedirect("/user.html");
        }
    }
}

