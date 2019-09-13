package serversirmon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;

public class sirServer {

    //let's not add more objects to this class
    public String server_dns;
    public String server_name;
    public String server_type;
    public String server_qry;
    public String server_status;
    public String server_msg;
    public String server_ip;
    public int server_port;
    public String clientid;
    public Date lastupddttm;
    //nothing more to add here 

    public sirServer() {
        System.out.println("Constructor for Sir server");
        Date date = new Date();
        SimpleDateFormat ft1 = new SimpleDateFormat("yyyy-MM-dd");
        String dt = ft1.format(date);
        lastupddttm = date;
    }//end of constructor

    //this will just store data in database
    public void insInDB() {
        String query = "INSERT INTO `server_log` (`server_dns`, `server_name`, `server_type`, `server_qry`, `server_status`, `server_msg`, `server_ip`, `server_port`, `clientid`, `lastupddttm`) VALUES (?,?,?,?,?,?,?,?,?,?)";
        try {
            Connection conn = getSqlCon();
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString(1, server_dns);
            preparedStmt.setString(2, server_name);
            preparedStmt.setString(3, server_type);
            preparedStmt.setString(4, server_qry);
            preparedStmt.setString(5, server_status);
            preparedStmt.setString(6, server_msg);
            preparedStmt.setString(7, server_ip);
            preparedStmt.setInt(8, server_port);
            preparedStmt.setString(9, clientid);

            java.sql.Date startDate = new java.sql.Date(lastupddttm.getTime());
            preparedStmt.setDate(10, startDate);
            preparedStmt.execute();
            System.out.println("Insert successful for:"+server_dns +" client:"+ clientid);
            conn.close();

        } catch (Exception e) {
            System.out.println("Error insInDB-" + e);
        }
    }//end of insInDB

    /**
     * this will return a sql connection to database for use*
     */
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

}//end of main class
