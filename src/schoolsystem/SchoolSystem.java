/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package schoolsystem;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import schoolsystem.View.Login;
import schoolsystem.models.Model.parent;
/**
 *
 * @author ff
 */
public class SchoolSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException  {
        // TODO code application logic here
        LinkedList<parent>prs=parent.All();
        System.out.println(prs.get(0).getName());
        Login start=new Login();
        start.setVisible(true);
        
    }
    
}
