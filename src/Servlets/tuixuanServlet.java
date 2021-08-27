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

public class tuixuanServlet extends HttpServlet {
    SqlControl sqlControl = new SqlControl();
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String uname = (String) this.getServletContext().getAttribute("uname");
        String order = (String) req.getParameter("coursesNumber");
        try {
            ArrayList data = sqlControl.Tuixuan(uname,order);
            if (data.get(0).equals("Success")){
                PrintWriter out = resp.getWriter();
                req.removeAttribute("coursesNumber");
                out.print("<script>alert('Success!');</script>");
            }
            if(data.get(0).equals("error")){
                PrintWriter out = resp.getWriter();
                req.removeAttribute("coursesNumber");
                out.print("<script>alert('The result already exists. You cannot withdraw!');</script>");
            }
            if(data.get(0).equals("unselected")){
                PrintWriter out = resp.getWriter();
                req.removeAttribute("coursesNumber");
                out.print("<script>alert('unselected!');</script>");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
