/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pfa.model;

/**
 *
 * @author safae
 */
public class Model_Login {
    private String userName;
    private String Password;

    public Model_Login() {
    }

    public Model_Login(String userName, String Password) {
        this.userName = userName;
        this.Password = Password;
    }


    public String getUserName() {
        return userName;
    }


    public void setUserName(String userName) {
        this.userName = userName;
    }


    public String getPassword() {
        return Password;
    }


    public void setPassword(String Password) {
        this.Password = Password;
    }
    
}
