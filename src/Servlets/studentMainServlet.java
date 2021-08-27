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


public class studentMainServlet extends HttpServlet{
    SqlControl sqlControl = new SqlControl();
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.getServletContext().removeAttribute("SelectedCno");
        req.setCharacterEncoding("utf-8");
        String uname = (String) this.getServletContext().getAttribute("uname");
        String order = (String) req.getParameter("order");
        if(order.equals("可选课程")){
            try {
                ArrayList data = (ArrayList) sqlControl.GetOptionalCourses(uname);
                req.removeAttribute("order");
                req.removeAttribute("infos");
                req.setAttribute("optionalCources",data);
                req.getRequestDispatcher("/studentOptionalCources.jsp").forward(req, resp);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        if(order.equals("退出登录")){
            req.removeAttribute("order");
            req.removeAttribute("infos");
            req.removeAttribute("uname");
            req.removeAttribute("pword");
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        }
        if(order.equals("已选课程")){
            try {
                ArrayList data = (ArrayList) sqlControl.GetSelectedCourses(uname);
                req.removeAttribute("order");
                req.setAttribute("selectedCources",data);
                req.removeAttribute("infos");
                req.getRequestDispatcher("/studentSelectedCources.jsp").forward(req, resp);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}




