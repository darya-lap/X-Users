package servlets;

import DAO.Factory;
import entity.Address;
import entity.Users;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


public class UpdateServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Object attr = session.getAttribute("user_role");

            resp.setContentType("text/x-json;charset=UTF-8");
            resp.setHeader("Cache-Control", "no-cache");
            resp.setHeader("Access-Control-Allow-Origin", "*");

            JSONArray jsonArray = new JSONArray();
            if ((attr != null) && (attr.toString().equals("admin"))) {
                try {
                    List<Users> usersList = (List<Users>) DAO.Factory.getInstance().getUserDAO().getAllUsers();
                    for (Users listElement : usersList) {
                        Address address = Factory.getInstance().getAddressDAO().getAddressById(listElement.getId());
                        JSONObject jsonObject = new JSONObject();
                        jsonObject.put("id", listElement.getId());
                        jsonObject.put("firstname", listElement.getFirstname());
                        jsonObject.put("lastname", listElement.getLastname());
                        jsonObject.put("username", listElement.getUsername());
                        jsonObject.put("password", listElement.getPassword());
                        jsonObject.put("email", listElement.getEmail());
                        jsonObject.put("birthday", listElement.getBirthday().toString());
                        jsonObject.put("createdTimestamp", listElement.getCreatedTimestamp().toString());
                        jsonObject.put("lastUpdatedTimeStamp", listElement.getLastUpdatedTimeStamp().toString());
                        jsonObject.put("isActive", listElement.getIsActive());
                        jsonObject.put("role", listElement.getRole());
                        jsonObject.put("zip", address.getZip());
                        jsonObject.put("country", address.getCountry());
                        jsonObject.put("city", address.getCity());
                        jsonObject.put("district", address.getDistrict());
                        jsonObject.put("street", address.getStreet());
                        jsonArray.add(jsonObject);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
            }
        }
        resp.getWriter().write(jsonArray.toJSONString());
        resp.getWriter().flush();
        resp.setStatus(HttpServletResponse.SC_OK);
    }
}
