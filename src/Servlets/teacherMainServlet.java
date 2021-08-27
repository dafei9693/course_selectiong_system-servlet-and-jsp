package Servlets;

import JDBC.SqlControl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class teacherMainServlet extends HttpServlet {
    SqlControl sqlControl = new SqlControl();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.getServletContext().removeAttribute("SelectedCno");
        req.setCharacterEncoding("utf-8");
        String uname = (String) this.getServletContext().getAttribute("uname");
        String order = (String) req.getParameter("order");
        if(order.equals("退出登录")){
            req.removeAttribute("order");
            req.removeAttribute("infos");
            req.removeAttribute("uname");
            req.removeAttribute("pword");
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        }
        if(order.equals("本人开设课程")){
            try {
                ArrayList data = (ArrayList) sqlControl.GetCreatedCources(uname);
                req.setAttribute("createdCources",data);
                req.removeAttribute("infos");
                req.removeAttribute("order");
                req.getRequestDispatcher("/teacherCreatedCources.jsp").forward(req, resp);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        if(order.equals("开设课程")){
            req.removeAttribute("infos");
            req.removeAttribute("order");
            req.getRequestDispatcher("/teacherAddCource.jsp").forward(req, resp);
        }
    }
}
