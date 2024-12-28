/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package schoolsystem.models.Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import static schoolsystem.models.Model.Model.conn;

/**
 *
 * @author ff
 */
public class parent extends Model {

    public int id;
    protected String name;
    protected String phone;
    protected String address;
    protected String job;
    protected String birth_date;
    protected String religion;
    protected String gender;
    protected String nat_id;

    public parent() throws SQLException {
        super();
        parent.Connect();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(String birth_date) {
        this.birth_date = birth_date;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public static String getConnection_string() {
        return connection_string;
    }

    public static void setConnection_string(String connection_string) {
        Model.connection_string = connection_string;
    }

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        Model.username = username;
    }

    public boolean save() {
        try {
            String query = "";
            Statement stat = conn.createStatement();
            if (this.id == 0) {
                query = "INSERT INTO parents(name,phone,nat_id,gender,birth_date,address,religion,job)VALUES('" + this.name + "','" + this.phone + "','" + this.nat_id + "','" + this.gender + "','" + this.birth_date + "','" + this.address + "','" + this.religion + "','" + this.job + "');";
                System.out.println(query);
                stat.execute(query);
                ResultSet resultSet = stat.executeQuery("select max(id) as mx_id from parents");
                this.id = resultSet.getInt("mx_id");
                return true;
            } else {
                query = "UPDATE parents set name='" + this.name + "',phone='"this.phone"',nat_id='"+this.nat_id + "',nat_id='" + this.nat_id + "',gender='" + this.gender + "',birth_date='" + this.birth_date + "',address='" + this.address + "',religion='" + this.religion + "' where id=" + String.format("%d", this.id) + ";";
                System.out.println(query);
                ResultSet resultSet = stat.executeQuery("select max(id) as mx_id from student");
                this.id = resultSet.getInt("mx_id");
                return true;
            }
        } catch (SQLException ex) {
            System.out.print(ex.getMessage());
        }
        return false;
    }

    public static parent find(int id) {
        try {
            String query = "SELECT * FROM parents where id=" + id;
            Statement stat = parent.conn.createStatement();
            ResultSet res = stat.executeQuery(query);
            parent par = new parent();
            if (res.next()) {
                par.name = res.getString("name");
                par.address = res.getString("address");
                par.gender = res.getString("gender");
                par.job = res.getString("job");
                par.nat_id = res.getString("nat_id");
                par.phone = res.getString("phone");
                par.religion = res.getString("religion");
                par.birth_date = res.getDate("birth_date").toString();
                par.id = res.getInt("id");
                return par;
            }
            par.name = "ahmed";
            return par;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    public int getId() {
        return id;
    }

    public void setNat_id(String nat_id) {
        this.nat_id = nat_id;
    }

    public String getNat_id() {
        return nat_id;
    }

    public static LinkedList<parent> where(String col, String cond, String value) {
        try {
            LinkedList<parent> results = new LinkedList<parent>();
            String query = "SELECT * FROM parents where " + col + cond + value;
            Statement stat = parent.conn.createStatement();
            ResultSet res = stat.executeQuery(query);
            int i = 0;
            while (res.next()) {
                parent par = new parent();
                par.name = res.getString("name");
                par.address = res.getString("address");
                par.gender = res.getString("gender");
                par.id = res.getInt("id");
                par.job = res.getString("job");
                par.name = res.getString("name");
                par.nat_id = res.getString("nat_id");
                par.phone = res.getString("phone");
                par.religion = res.getString("religion");
                results.add(par);
                i++;
            }
            return i != 0 ? results : null;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    public static LinkedList<parent> All() throws SQLException, ClassNotFoundException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            parent.Connect();
            String query = "SELECT id FROM parents";
            LinkedList<parent> result = new LinkedList<parent>();
            Statement stat = parent.conn.createStatement();
            ResultSet res = stat.executeQuery(query);
            int i = 0;
            while (res.next()) {
                result.add(parent.find(res.getInt("id")));
            }
            return result;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    public boolean delete() {
        try {
            String query = "DELETE from student where id=" + String.format("%d", this.id);
            Statement stat = student.conn.createStatement();
            return stat.execute(query);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    public static boolean delete(int id) {
        student std = student.find(id);
        if (std != null) {
            return std.delete();
        } else {
            return false;
        }
    }
}
