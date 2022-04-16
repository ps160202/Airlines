/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javaminiprojecttry;

/**
 *
 * @author PS
 */
public class Operator {
    private String operatorName;
    private String password;
    private static String adminPassword;

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

    public void checkFlightInfo(){
        
    }
    
    public void addFlight(){
        
    }
    
    public void cancelFlight(){
        
    }
    
    public void modifyFlight(){
        
    }
    
    public void addOperator(){
        
    }
    
    public void removeOperator(){
        
    }
    
    public void changePassword(){
        
    }
}
