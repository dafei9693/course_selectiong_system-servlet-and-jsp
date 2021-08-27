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

public class teacherAddCourceServlet extends HttpServlet {
    SqlControl sqlControl = new SqlControl();

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        this.getServletContext().removeAttribute("SelectedCno");
        String uname = (String) this.getServletContext().getAttribute("uname");
        String cno = req.getParameter("cno");
        String cname = req.getParameter("cname");
        String credit = req.getParameter("credit");
        String pcno = req.getParameter("pcno");
        String describe = req.getParameter("describe");
        String left = req.getParameter("left");

        try {
            ArrayList data = sqlControl.AddCource(uname,cno,cname,credit,pcno,describe,left);
            PrintWriter pw = resp.getWriter();
            pw.write("<script language='javascript'>alert('Success!');</script>");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
