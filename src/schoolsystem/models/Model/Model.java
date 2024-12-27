/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package schoolsystem.models.Model;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author ff
 */
public class Model {
    protected static String connection_string="jdbc:mysql://localhost/school_system";
    protected static String username="root";
    protected static String password="ahmed1";
    protected static Connection conn;
    public Model() throws SQLException {
        boolean Connect = Model.Connect();
    }
    protected static boolean Connect() {
        try {
            conn=DriverManager.getConnection(connection_string, username, password);
        } catch (SQLException ex) {
            System.out.println(ex.getStackTrace());
        }
        return false;
    }
}
