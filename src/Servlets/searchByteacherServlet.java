package Servlets;

import JDBC.SqlControl;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class searchByteacherServlet extends HttpServlet {
    SqlControl sqlControl=new SqlControl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uname = (String) this.getServletContext().getAttribute("uname");
        String order = (String) req.getParameter("tname");
        System.out.println(order);
        try {
            ArrayList data = sqlControl.searchByTname(order);
            req.setAttribute("optionalCources",data);
            req.getRequestDispatcher("/ifTeacherOptionalCources.jsp").forward(req, resp);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
