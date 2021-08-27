package JDBC;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;

public class SqlControl {
    SqlUser sqlUser = new SqlUser("jxgl");

    public boolean GetPassWord(String uname,String pword) throws SQLException, ClassNotFoundException {
        if(uname.substring(0,1).equals("T")) {
            ArrayList data = new ArrayList();
            data = sqlUser.search("select * from tinfo where tno = '" + uname + "" + "';");
            if (data.isEmpty())
                return false;
            if (pword.equals(data.get(5).toString()))
                return true;
            else
                return false;
        }
        else {
            if (uname.substring(0, 1).equals("S")) {
                ArrayList data = new ArrayList();
                data = sqlUser.search("select * from sinfo where sno = '" + uname + "" + "';");
                if (data.isEmpty())
                    return false;
                if (pword.equals(data.get(5).toString()))
                    return true;
                else
                    return false;
            } else
                return false;
        }
    }

    public ArrayList GetInfos(String uname) throws SQLException, ClassNotFoundException{
        ArrayList data = new ArrayList();
        if(uname.substring(0,1).equals("S")) {
            data = sqlUser.search("select * from sinfo where sno = '" + uname + "" + "';");
        }
        if(uname.substring(0,1).equals("T")) {
            data = sqlUser.search("select * from tinfo where tno = '" + uname + "" + "';");
        }
        return data;
    }

    public ArrayList GetSelectedCourses(String uname) throws SQLException,ClassNotFoundException{
        ArrayList data = new ArrayList();
        data = sqlUser.search("select sc.cno,cname,credit,`describe`,grade from sc join c c2 on sc.cno = c2.cno where sno = '"+uname+"';");
        ArrayList data1 = new ArrayList();
        ArrayList row = new ArrayList();
        int x =4;
        for(int i =0 ;i<data.size();i++){
            row.add(data.get(i));
            if(i%x==0 && i>x-1){
                x=x+5;
                data1.add(row);
                row=new ArrayList();
            }
        }
        return data1;
    }

    public ArrayList GetOptionalCourses(String uname) throws SQLException,ClassNotFoundException{
        ArrayList data = new ArrayList();
        data = sqlUser.search("select c.cno,cname,credit,pcno,`describe`,rest,tname from " +
                "(c join tc on c.cno=tc.cno) join t on tc.tno=t.tno;");
        ArrayList data1 = new ArrayList();
        ArrayList row = new ArrayList();
        int x=6;
        for(int i =0 ;i<data.size();i++){
            row.add(data.get(i));
            if(i%x==0 && i>x-1){
                x=x+7;
                data1.add(row);
                row=new ArrayList();
            }
        }
        return data1;
    }

    public ArrayList Xuanke(String uname ,String cno) throws SQLException,ClassNotFoundException{
        ArrayList data = new ArrayList();
        data = sqlUser.search("call selectcourse('"+uname+"','"+cno+"');");
        return data;
    }

    public ArrayList Tuixuan(String uname ,String cno) throws SQLException,ClassNotFoundException{
        ArrayList data = new ArrayList();
        data = sqlUser.search("call unselectcourse('"+uname+"','"+cno+"');");
        return data;
    }

    public ArrayList GetCreatedCources(String uname ) throws SQLException, ClassNotFoundException {
        ArrayList data = new ArrayList();
        data = sqlUser.search("select tno,tc.cno,cname,credit,pcno,`describe`,rest from tc join c on tc.cno=c.cno where tno='"+uname+"';");
        ArrayList data1 = new ArrayList();
        ArrayList row = new ArrayList();
        int x =6;
        for(int i =0 ;i<data.size();i++){
            row.add(data.get(i));
            if(i%x==0 && i>x-1){
                x=x+7;
                data1.add(row);
                row=new ArrayList();
            }
        }
        return data1;
    }

    public ArrayList SelectStudents(String cno ) throws SQLException, ClassNotFoundException{
        ArrayList data = new ArrayList();
        data = sqlUser.search("select c.cno,cname,s.sno,sname,sdept,grade from (sc join s on sc.sno=s.sno) join c on c.cno=sc.cno where c.cno='"+cno+"';");
        ArrayList data1 = new ArrayList();
        ArrayList row = new ArrayList();
        int x =5;
        for(int i =0 ;i<data.size();i++){
            row.add(data.get(i));
            if(i%x==0 && i>x-1){
                x=x+6;
                data1.add(row);
                row=new ArrayList();
            }
        }
        return data1;
    }

    public ArrayList paixuGrade(String cno) throws SQLException, ClassNotFoundException {
        ArrayList data = new ArrayList();
        data = sqlUser.search("select c.cno,cname,s.sno,sname,sdept,grade from (sc join s on sc.sno=s.sno) join c on c.cno=sc.cno where c.cno='"+cno+"' order by grade desc;");
        System.out.println(data);
        ArrayList data1 = new ArrayList();
        ArrayList row = new ArrayList();
        int x =5;
        for(int i =0 ;i<data.size();i++){
            row.add(data.get(i));
            if(i%x==0 && i>x-1){
                x=x+6;
                data1.add(row);
                row=new ArrayList();
            }
        }
        System.out.println(data1);
        return data1;
    }

    public ArrayList SetGrade(String cno,String sno,String grade) throws SQLException, ClassNotFoundException {
        sqlUser.update("update sc set grade="+grade+" where sno='"+sno+"' and cno='"+cno+"';");
        ArrayList data = new ArrayList();
        data.add("Success");
        return  data;
    }

    public ArrayList AddCource(String tno1 , String cno1 , String cname1 ,
    String credit1 , String pcno1 , String describe1 , String rest1 ) throws SQLException, ClassNotFoundException {
        ArrayList data = sqlUser.search("call addnewcource('"+tno1+"','"+cno1+ "','"+cname1+"',"+credit1+",'"+pcno1+"','"+
                describe1+"',"+rest1+")");
        return  data;
    }

    public ArrayList searchByTname(String name) throws SQLException, ClassNotFoundException {
        ArrayList data = new ArrayList();
        ArrayList data2 = sqlUser.search("select tno from t where tname='"+name+"';");
        System.out.println(data2);
        String tno = (String) sqlUser.search("select tno from t where tname='"+name+"';").get(0);
        data = sqlUser.search("select c.cno,cname,credit,pcno,`describe`,rest,tname from " +
                "(c join tc on c.cno=tc.cno) join t on tc.tno=t.tno where t.tno='"+tno+"';");
        ArrayList data1 = new ArrayList();
        ArrayList row = new ArrayList();
        int x=6;
        for(int i =0 ;i<data.size();i++){
            row.add(data.get(i));
            if(i%x==0 && i>x-1){
                x=x+7;
                data1.add(row);
                row=new ArrayList();
            }
        }
        return data1;
    }

}
