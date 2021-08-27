package JDBC;

import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class test {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        /**SqlUser sqlUser = new SqlUser("piaowu");

        for(int i=0;i<500;i++){
            String name = "name" + String.valueOf(i);
            String depart = "city" + String.valueOf((int)(1+Math.random()*(200-1+1)));
            String arrival = "city" + String.valueOf((int)(1+Math.random()*(200-1+1)));
            while (depart.equals(arrival)) {
                depart = "city" + String.valueOf((int)(1+Math.random()*(200-1+1)));
                arrival = "city" + String.valueOf((int)(1+Math.random()*(200-1+1)));
            }
            ArrayList datex = sqlUser.search("select date(from_unixtime(\n" +
                    "            unix_timestamp('2021-06-20')\n" +
                    "            + floor(\n" +
                    "                        rand() * ( unix_timestamp('2021-12-20') - unix_timestamp('2021-06-20') + 1 )\n" +
                    "                )\n" +
                    "    )) as date;\n");


            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date dx = null;
            try {
                dx = format.parse(datex.get(0).toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
            Date date1 = new Date(dx.getTime());

            ArrayList datey = sqlUser.search("select date(DATEADD("+date1+",1,));");

            System.out.println(datey);


            System.out.println(date1);
            //sqlUser.insert("insert into lines values('"+String.valueOf(i)+"','"+depart+"','"+
                    //arrival+"',");
            */

        SqlControl sqlControl = new SqlControl();
        ArrayList data = sqlControl.Tuixuan("S11","C1");
        System.out.println(data);
    }
}

