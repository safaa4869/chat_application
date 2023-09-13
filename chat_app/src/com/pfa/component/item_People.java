package com.pfa.component;

import com.pfa.event.PublicEvent;
import com.pfa.model.Model_User_Account;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class item_People extends javax.swing.JPanel {

    public Model_User_Account getUser() {
        return user;
    }
    
    private boolean mouseOver;
    
    private final Model_User_Account user;

    public item_People(Model_User_Account user) {
        this.user =user;
        initComponents();
        ib.setText(user.getUserName());
        activeStatus.setActive(user.isStatus());
        init();
    }
    public void updateStatus(){
        activeStatus.setActive(user.isStatus());
    }
    private void init() {

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent me) {
                setBackground(new Color(230, 230, 230));
                mouseOver=true;
            }

            @Override
            public void mouseExited(MouseEvent me) {
                setBackground(new Color(242, 242, 242));
                mouseOver=false;
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if(mouseOver){
                    PublicEvent.getInstance().getEventMain().selectUser(user);
                }
            }
            
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        imageAvatar1 = new com.pfa.swing.ImageAvatar();
        ib = new javax.swing.JLabel();
        ibStatus = new javax.swing.JLabel();
        activeStatus = new com.pfa.swing.ActiveStatus();

        imageAvatar1.setToolTipText("");
        imageAvatar1.setBorderColor(new java.awt.Color(204, 51, 255));
        imageAvatar1.setBorderSize(0);
        imageAvatar1.setImage(new javax.swing.ImageIcon(getClass().getResource("/com/pfa/icon/user.png"))); // NOI18N

        ib.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ib.setText("Name");

        ibStatus.setFont(new java.awt.Font("SansSerif", 2, 12)); // NOI18N
        ibStatus.setForeground(new java.awt.Color(117, 117, 117));
        ibStatus.setText("New User");

        activeStatus.setActive(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imageAvatar1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ib, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ibStatus)
                        .addGap(3, 3, 3)
                        .addComponent(activeStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(imageAvatar1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(ib)
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ibStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(activeStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(3, 3, 3))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.pfa.swing.ActiveStatus activeStatus;
    private javax.swing.JLabel ib;
    private javax.swing.JLabel ibStatus;
    private com.pfa.swing.ImageAvatar imageAvatar1;
    // End of variables declaration//GEN-END:variables

}
