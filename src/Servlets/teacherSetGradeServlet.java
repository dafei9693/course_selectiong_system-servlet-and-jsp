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

public class teacherSetGradeServlet extends HttpServlet {
    SqlControl sqlControl = new SqlControl();

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String uname = (String) this.getServletContext().getAttribute("uname");
        this.getServletContext().removeAttribute("SelectedCources");
        String order = (String) req.getParameter("coursesNumber");
        try {
            ArrayList data = sqlControl.SelectStudents(order);
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
