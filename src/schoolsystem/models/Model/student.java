/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package schoolsystem.models.Model;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import schoolsystem.models.Model.Model;

/**
 *
 * @author ff
 */
public class student extends Model {

    protected String name;
    protected String phone;
    protected String religion;
    protected String gender;
    protected String std_code;
    protected String birth_date;
    protected String address;
    protected String nat_id;
    protected String join_date;
    protected String rolling_status;
    protected String paymentstatus;
    protected String division;
    protected String transformed_from;
    protected String school_code;
    protected int id = 0;

    public student() throws SQLException {
        super();
        student.Connect();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
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

    public String getStd_code() {
        return std_code;
    }

    public void setStd_code(String std_code) {
        this.std_code = std_code;
    }

    public String getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(String birth_date) {
        this.birth_date = birth_date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNat_id() {
        return nat_id;
    }

    public void setNat_id(String nat_id) {
        this.nat_id = nat_id;
    }

    public String getJoin_date() {
        return join_date;
    }

    public void setJoin_date(String join_date) {
        this.join_date = join_date;
    }

    public int getId() {
        return id;
    }

    public static student find(int id) {
        try {
            Statement stat = student.conn.createStatement();
            String query = "SELECT * FROM student";
            ResultSet res = stat.executeQuery(query);
            if (res.next()) {
                student std = new student;
                std.name = res.getString("name");
                std.address = res.getString("address");
                std.birth_date = res.getString("birth_date");
                std.gender = res.getString("gender");
                std.id = res.getInt("id");
                std.join_date = res.getDate("join_date").toString();
                std.phone = res.getString("phone");
                std.religion = res.getString("religion");
                std.std_code = res.getString("std_code");
                std.gender = res.getString("gender");
                std.division=res.getString("division");
                std.paymentstatus=res.getString("paymentstatus");
                std.rolling_status=res.getString("rolling_status");
                std.transformed_from=res.getString("tranformed_from");
                std.school_code=res.getString("school_code");
                return std;
            }
            return null;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null
        }
    }

    public boolean save() {
        try {
            String query = "";
            Statement stat = conn.createStatement();

            if (this.id == 0) {
                query = "INSERT INTO student(name,phone,std_code,nat_id,gender,birth_date,address,religion)VALUES('" + this.name + "','" + this.phone + "','" + this.std_code + "','" + this.nat_id + "','" + this.gender + "','" + this.birth_date + "','" + this.address + "','" + this.religion + "');";
                stat.execute(query);
                ResultSet resultSet = stat.executeQuery("select max(id) as mx_id from student");
                this.id = resultSet.getInt("mx_id");
                return true;
            } else {
                query = "UPDATE student set name='" + this.name + "',phone='"this.phone"',std_code='"+this.std_code + "',nat_id='" + this.nat_id + "',gender='" + this.gender + "',birth_date='" + this.birth_date + "',address='" + this.address + "',religion='" + this.religion + "' where id=".concat(String.format("%d", this.id));
                ResultSet resultSet = stat.executeQuery("select max(id) as mx_id from student");
                this.id = resultSet.getInt("mx_id");
                return true;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getStackTrace());
        }
        return false;
    }

    public static ArrayList<student> All() {
        try {
            String query = "select id from student";
            Statement stat = student.conn.createStatement();
            ResultSet res = stat.executeQuery(query);
            ArrayList<student> stds = new ArrayList<student>();
            while (res.next()) {
                student std = student.find(res.getInt("id"));
                stds.add(std);
            }
            return stds;
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
        if (std!=null) {
            return std.delete();
        } else {
            return false;
        }
    }
    public static LinkedList<student>where(String column,String cond,String value){
        try{
            LinkedList<student>result=new LinkedList<student>();
            String query="SELECT  * FROM student "+column+cond+value;
            Statement stat=student.conn.createStatement();
            ResultSet res=stat.executeQuery(query);
            int i=0;
            while (res.next()){
                student std=new student();
                std.name=res.getString("name");
                std.address=res.getString("address");
                std.birth_date=res.getString("birth_date");
                std.division=res.getString("division");
                std.gender=res.getString("gender");
                std.id=res.getInt("id");
                std.join_date=res.getDate("join_date").toString();
                std.nat_id=res.getString("nat_id");
                std.paymentstatus=res.getString("paymentstatus");
                std.phone=res.getString("phone");
                std.religion=res.getString("religion");
                std.rolling_status=res.getString("rolling_status");
                std.school_code=res.getString("school_code");
                std.std_code=res.getString("std_code");
                std.transformed_from=res.getString("tranformed_from");
                result.add(std);
                i++;
            }
            return i!=0?result:null;
        }catch(SQLException ex){
            System.out.print(ex.getMessage());
        }
        return null;
    }
}
