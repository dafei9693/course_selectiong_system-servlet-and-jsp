package Servlets;

import JDBC.SqlControl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.util.ArrayList;
import java.util.Enumeration;

public class setGradeServlet extends HttpServlet {
    SqlControl sqlControl = new SqlControl();

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uname = req.getParameter("uname");
        req.setCharacterEncoding("utf-8");
        String cno = (String) this.getServletContext().getAttribute("SelectedCno");
        Enumeration data = req.getParameterNames();
        ArrayList grade= new ArrayList();
        while(data.hasMoreElements()){
            String paraname = (String) data.nextElement();
            grade.add(req.getParameter(paraname));
        }
        try {
            ArrayList snos = sqlControl.SelectStudents(cno);
            for (int i=0;i<snos.size();i++){
                ArrayList row = (ArrayList) snos.get(i);
                String sno = (String) row.get(2);
                if(!grade.get(i).equals("")) {
                    sqlControl.SetGrade(cno, sno, (String) grade.get(i));
                }
            }
            this.getServletContext().removeAttribute("SelectedCno");
            PrintWriter pw=resp.getWriter();
            pw.write("<script language='javascript'>alert('Success');</script>");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
