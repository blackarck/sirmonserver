/*
 * Program to save data in database
 */
package serversirmon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author vivek sharma
 */
public class envclass {

    String clientid;
    String prcsfail;
    String prcspass;
    String outsucc;
    String outpend;
    String outfail;
    String inbsucc;
    String inbfail;
    String inbpend;

    public void insInDB() {
        Date date = new Date();
        SimpleDateFormat ft1 = new SimpleDateFormat("yyyy-MM-dd");
        String dt = ft1.format(date);
        Date updatedate = date;
        try {
            Connection conn = getSqlCon();
            java.sql.Date upddate = new java.sql.Date(updatedate.getTime());
            String query = "delete from `prcssummary` WHERE  `date` = '" + upddate + "'";
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.execute();
            query = "INSERT INTO `prcssummary`(`clientid`, `date`, `prcspass`, `prcsfail`) VALUES (?,?,?,?)";
            preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString(1, this.clientid);
            preparedStmt.setDate(2, upddate);
            preparedStmt.setString(3, this.prcspass);
            preparedStmt.setString(4, this.prcsfail);
            preparedStmt.execute();

            query = "Delete from `ibsummary` WHERE  `date` = '" + upddate + "'";
            preparedStmt = conn.prepareStatement(query);
            preparedStmt.execute();
            query = "INSERT INTO `ibsummary`(`clientid`, `date`, `outsucc`, `outpend`, `outfail`, `inbsucc`, `inbfail`, `inbpend`) VALUES (?,?,?,?,?,?,?,?)";
            preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString(1, this.clientid);
            preparedStmt.setDate(2, upddate);
            preparedStmt.setString(3, this.outsucc);
            preparedStmt.setString(4, this.outpend);
            preparedStmt.setString(5, this.outfail);
            preparedStmt.setString(6, this.inbsucc);
            preparedStmt.setString(7, this.inbfail);
            preparedStmt.setString(8, this.inbpend);
            preparedStmt.execute();
        } catch (Exception e) {
            System.out.println("Error insInDB-" + e);
        }
    }//end of insindb

    private Connection getSqlCon() {
        Connection con1 = null;
        String uid = "javadmin";
        String pwd = "password";
        String connString = "jdbc:mysql://localhost:3306/sirmonserv";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con1 = DriverManager.getConnection(connString, uid, pwd);
        } catch (Exception e) {
            System.out.println("Error constructor-" + e);
        }
        return con1;
    }//end of getSqlCon

}//end of class
