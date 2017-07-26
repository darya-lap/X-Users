package servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class UpdateServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //resp.setHeader("Access-Control-Allow-Origin", "*");
        //resp.setStatus(HttpServletResponse.SC_OK);



        PrintWriter pw = resp.getWriter();
        pw.write("hi from servlet");
        pw.flush();
        pw.close();
    }
}
