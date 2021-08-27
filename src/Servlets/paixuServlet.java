package Servlets;

import JDBC.SqlControl;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class paixuServlet extends HttpServlet {
    SqlControl sqlControl = new SqlControl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uname = (String) this.getServletContext().getAttribute("uname");
        String order = (String) req.getParameter("courceNumber");
        System.out.println(order);
        try {
            ArrayList data = sqlControl.paixuGrade(order);
            req.removeAttribute("order");
            req.setAttribute("students",data);
            this.getServletContext().setAttribute("SelectedCno",order);
            req.getRequestDispatcher("/teacherSetGrade.jsp").forward(req, resp);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
