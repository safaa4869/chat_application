/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.pfa.component;

import com.pfa.model.Model_User_Account;
import java.awt.Color;

/**
 *
 * @author safae
 */
public class Chat_title extends javax.swing.JPanel {

    public Model_User_Account getUser() {
        return user;
    }

    private Model_User_Account user;

    public Chat_title() {
        initComponents();
    }

    public void setUserName(Model_User_Account user) {
        this.user = user;
        ibName.setText(user.getUserName());
        if (user.isStatus()) {
            StatusAvtive();

        } else {
            setStatusText("Offline");
        }

    }

    public void updateUser(Model_User_Account user) {
        if (this.user == user) {
            ibName.setText(user.getUserName());
            if (user.isStatus()) {
                StatusAvtive();

            } else {
                setStatusText("Offline");
            }
        }
    }

    private void StatusAvtive() {
        ibStatus.setText("Active now");
        ibStatus.setForeground(new Color(40, 147, 59));

    }

    private void setStatusText(String text) {
        ibStatus.setText(text);
        ibStatus.setForeground(new Color(160, 160, 160));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        layer = new javax.swing.JLayeredPane();
        ibName = new javax.swing.JLabel();
        ibStatus = new javax.swing.JLabel();

        setBackground(new java.awt.Color(249, 249, 249));

        layer.setLayout(new java.awt.GridLayout(0, 1));

        ibName.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        ibName.setForeground(new java.awt.Color(66, 66, 66));
        ibName.setText("Name");
        layer.add(ibName);

        ibStatus.setForeground(new java.awt.Color(35, 163, 61));
        ibStatus.setText("Active now");
        layer.add(ibStatus);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(layer, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(397, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(layer, javax.swing.GroupLayout.PREFERRED_SIZE, 26, Short.MAX_VALUE)
                .addGap(3, 3, 3))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ibName;
    private javax.swing.JLabel ibStatus;
    private javax.swing.JLayeredPane layer;
    // End of variables declaration//GEN-END:variables

}
