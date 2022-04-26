package com.mycompany.javaminiprojecttry;

import java.sql.*;
import java.util.Scanner;

public class Passenger implements DatabaseConnection{
    String phoneNumber;
    String name;
    String email;
    int age;

    static int passengerID = 0;

    Scanner sc = new Scanner(System.in);

    Connection con=null;
    Statement stmt=null;
    ResultSet rs=null;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) { this.age = age;}

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) { this.email = email; }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    public void createConnection() {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String db = "jdbc:mysql://localhost:3306/airline";
            con = DriverManager.getConnection(db, "root", "123456");
            stmt = con.createStatement();
        }
        catch(ClassNotFoundException | SQLException e)
        {
            System.out.println("Error "+e.toString());
            System.exit(0);
        }
    }

    public void closeConnection() {
        try {
            if(rs != null)
                rs.close();
            stmt.close();
            con.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void addPassenger(){
        createConnection();

        try {
            rs = stmt.executeQuery("select *from data");
            rs.next();
            passengerID = rs.getInt(2);

            stmt.execute("insert into passenger values(" + passengerID +
                    ", '" + this.name +
                    "', " + this.age +
                    ", '" + this.phoneNumber +
                    "', '" + this.email + "');");

            passengerID++;
            stmt.execute("update data set noOfPassengers=" + passengerID + ";");
            System.out.println("\nPassenger Added Successfully!\n");
        } catch (SQLException e){
            System.out.println(e);
            return;
        } finally {
            closeConnection();
        }
    }

    public boolean checkPassenger() {
        createConnection();

        try {
            rs = stmt.executeQuery("select *from passenger where emailID='" + this.email + "';");
            if(rs.next()) {
                return true;
            }
            else {
                return false;
            }
        } catch (SQLException e){
            System.out.println(e);
            return false;
        } finally {
            closeConnection();
        }
    }

    public void getPassenger() {
        createConnection();

        try {
            rs = stmt.executeQuery("select *from passenger where emailID='" + this.email + "';");
            rs.next();
            this.name = rs.getString(2);
            this.age = rs.getInt(3);
            this.phoneNumber = rs.getString(4);
        } catch (SQLException e){
            System.out.println(e);
        } finally {
            closeConnection();
        }
    }

}
