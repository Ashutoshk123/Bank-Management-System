package bank;
import java.sql.*;
public class Conn {
    Connection c;
    Statement s;
    public Conn(){
        try{
            c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem", "root", "Ashutosh kumar");
            s = c.createStatement();
        } catch(Exception e) {
            System.out.println(e);
        }
    }
}
