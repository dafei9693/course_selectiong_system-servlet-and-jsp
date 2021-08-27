package Servlets;

import JDBC.SqlControl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

public class xuankeServlet extends HttpServlet {
    SqlControl sqlControl = new SqlControl();
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uname = (String) this.getServletContext().getAttribute("uname");
        String order = (String) req.getParameter("coursesNumber");
        try {
            ArrayList data = sqlControl.Xuanke(uname,order);
            if (data.get(0).equals("Success")){
                PrintWriter out = resp.getWriter();
                req.removeAttribute("coursesNumber");
                out.print("<script>alert('Success!');</script>");
            }
            if(data.get(0).equals("AllreadyPicked")){
                PrintWriter out = resp.getWriter();
                req.removeAttribute("coursesNumber");
                out.print("<script>alert('Allready selected!');</script>");
            }
            if(data.get(0).equals("CourseEmpty")){
                PrintWriter out = resp.getWriter();
                req.removeAttribute("coursesNumber");
                out.print("<script>alert('No left!');</script>");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
