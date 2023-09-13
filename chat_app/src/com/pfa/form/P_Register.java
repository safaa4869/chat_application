
package com.pfa.form;

import com.pfa.event.EventMessage;
import com.pfa.event.PublicEvent;
import com.pfa.model.Model_Message;
import com.pfa.model.Model_Register;

/**
 *
 * @author safae
 */
public class P_Register extends javax.swing.JPanel {

    public P_Register() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbTitle = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtPass = new javax.swing.JPasswordField();
        cmdRegister = new javax.swing.JButton();
        cmdBackLogin = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtRePass = new javax.swing.JPasswordField();
        lbError = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        lbTitle.setFont(new java.awt.Font("SansSerif", 0, 30)); // NOI18N
        lbTitle.setForeground(new java.awt.Color(86, 86, 86));
        lbTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTitle.setText("Register");

        jLabel1.setText("User Name");

        txtUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserActionPerformed(evt);
            }
        });

        jLabel2.setText("Password");

        cmdRegister.setText("Register");
        cmdRegister.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cmdRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdRegisterActionPerformed(evt);
            }
        });

        cmdBackLogin.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        cmdBackLogin.setForeground(new java.awt.Color(16, 130, 206));
        cmdBackLogin.setText("Back Login");
        cmdBackLogin.setContentAreaFilled(false);
        cmdBackLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cmdBackLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdBackLoginActionPerformed(evt);
            }
        });

        jLabel3.setText("Confirm Password");

        txtRePass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRePassActionPerformed(evt);
            }
        });

        lbError.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        lbError.setForeground(new java.awt.Color(255, 51, 51));
        lbError.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cmdBackLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtPass)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtUser, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmdRegister, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                    .addComponent(txtRePass)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
            .addComponent(lbError, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lbTitle)
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtRePass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(cmdRegister)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmdBackLogin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbError, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUserActionPerformed

    private void cmdBackLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdBackLoginActionPerformed
        PublicEvent.getInstance().getEventLogin().goLogin();
    }//GEN-LAST:event_cmdBackLoginActionPerformed

    private void cmdRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdRegisterActionPerformed
        String userName=txtUser.getText().trim();
        String password = String.valueOf(txtPass.getPassword());
        String confirmPassword = String.valueOf(txtRePass.getPassword());
        if(userName.equals("")){
            txtUser.grabFocus();
        }else if(password.equals("")){
            txtPass.grabFocus();
        }else if(!confirmPassword.equals(password)){
            txtPass.grabFocus();
        }else{
            Model_Register data =new Model_Register(userName,password);
            PublicEvent.getInstance().getEventLogin().register(data, new EventMessage() {
                @Override
                public void callMessage(Model_Message message) {
                    if(!message.isAction()){
                        lbError.setText(message.getMessage());
                    }else{
                        //PublicEvent.getInstance().getEventLogin().login();
                        PublicEvent.getInstance().getEventMain().initChat();
                    }
                }
            });
        }
        
        
    }//GEN-LAST:event_cmdRegisterActionPerformed

    private void txtRePassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRePassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRePassActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdBackLogin;
    private javax.swing.JButton cmdRegister;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lbError;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JPasswordField txtRePass;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
