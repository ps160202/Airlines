package com.mycompany.javaminiprojecttry;

import java.sql.*;
import java.util.Scanner;

public class Operator {
    private String operatorName;
    private String password;
    private static String adminPassword = "123456";
    Scanner sc = new Scanner(System.in);

    Connection con=null;
    Statement stmt=null;
    ResultSet rs=null;

    public Operator() {
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

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static String getAdminPassword() {
        return adminPassword;
    }

    public static void setAdminPassword(String adminPassword) {
        Operator.adminPassword = adminPassword;
    }


    public boolean authenticate() {
        try {
            ResultSet rs = stmt.executeQuery("select *from Operators where Username = '" + this.operatorName + "';");
            rs.next();
            String pass = rs.getString(2);
            if (pass.equals(this.password)) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return false;
    }

    public void checkFlightInfo(){
        
    }
    
    public void addFlight(){

    }
    
    public void cancelFlight(){
        
    }
    
    public void modifyFlight(){
        
    }

    public void changePassword(){
        System.out.print("\nEnter current password: ");
        String pass = sc.next();
        if(!(this.password.equals(pass))) {
            System.out.println("Incorrect Password..!");
            return;
        }

        System.out.println("Enter New Password for new operator: ");
        String tmp1 = sc.next();
        System.out.println("Confirm Password for new operator: ");
        String tmp2 = sc.next();
        if (!(tmp1.equals(tmp2))) {
            System.out.println("\nPasswords don't match..!\n");
            return;
        }

        try {
            stmt.execute("Update Operators SET Password = '" + tmp1 + "' where Username = '" + this.operatorName + "';");
            System.out.println("\nPassword changed successfully..!\n");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void addOperator(){
        //Verifying admin password
        System.out.print("Enter admin password: ");
        String adminPasswordVerify = sc.next();

        if(!(adminPasswordVerify.equals(adminPassword))) {
            System.out.println("Incorrect Admin Password..!");
            return;
        }

        System.out.println("Enter username for new operator: ");
        String newOperator = sc.next();
        System.out.println("Enter New Password for new operator: ");
        String tmp = sc.next();
        System.out.println("Confirm Password for new operator: ");
        String newPassword = sc.next();

        if (newPassword.equals(tmp) == false) {
            System.out.println("Password Fields don't match..!");
            return;
        }

        try {
            stmt.execute("insert into Operators values('" + newOperator + "', '" + newPassword + "');");
            System.out.println("\nOperator added..!\n");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void removeOperator(){
        System.out.print("Enter admin password: ");
        String adminPasswordVerify = sc.next();

        if(!(adminPasswordVerify.equals(adminPassword))) {
            System.out.println("Incorrect Admin Password..!");
            return;
        }

        System.out.print("Enter username of account to be deleted: ");
        String user = sc.next();

        if(user.equals(this.operatorName)) {
            System.out.println("\nYou cant delete your own account..!\n");
            return;
        }

        try {
            rs = stmt.executeQuery("select *from Operators where Username = '" + user + "';");
            if(!rs.next()) {
                System.out.println("\nOperator with username " + user + " does not exist..!\n");
                return;
            }

            stmt.execute("Delete from Operators where Username = '" + user + "';");
            System.out.println("\nOperator Deleted..!\n");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
