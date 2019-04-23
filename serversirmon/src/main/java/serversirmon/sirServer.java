package serversirmon;

import java.sql.Connection;
import java.util.Date;

public class sirServer {
    
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
    
    public sirServer(){
        System.out.println("Constructor for Sir server");
        String uid = "javadmin";
    String pwd = "password";
    Connection con;
    }
}
