package Servlets;

import JDBC.SqlControl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class loginServlet extends HttpServlet {
    SqlControl sqlControl = new SqlControl();

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.getServletContext().removeAttribute("SelectedCno");
        String uname = req.getParameter("uname");
        String pword = req.getParameter("pword");
        if (uname.equals("")){
            PrintWriter pw=resp.getWriter();
            pw.write("<script language='javascript'>alert('error! check your account and password.');window.location.href='index.jsp';</script>");
        }
        else {
            try {
                if (sqlControl.GetPassWord(uname, pword)) {
                    this.getServletContext().setAttribute("uname", uname);
                    if(uname.substring(0,1).equals("S")) {
                        req.setAttribute("infos",sqlControl.GetInfos(uname));
                        req.getRequestDispatcher("/studentMain.jsp").forward(req, resp);
                    }
                    if(uname.substring(0,1).equals("T")) {
                        req.setAttribute("infos", sqlControl.GetInfos(uname));
                        req.getRequestDispatcher("/teacherMain.jsp").forward(req, resp);
                    }
                } else {
                    PrintWriter pw = resp.getWriter();
                    pw.write("<script language='javascript'>alert('error! check your account and password.');window.location.href='index.jsp';</script>");
                    //req.getRequestDispatcher("/index.jsp").forward(req, resp);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
