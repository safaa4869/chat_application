package com.pfa.form;

import com.pfa.component.item_People;
import com.pfa.event.EventMenuLeft;
import com.pfa.event.PublicEvent;
import com.pfa.model.Model_User_Account;
import net.miginfocom.swing.MigLayout;
import com.pfa.swing.ScrollBar;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;

public class Menu_left extends javax.swing.JPanel {

    private List<Model_User_Account> userAccount;

    public Menu_left() {
        initComponents();
        init();

    }

    private void init() {
        sp.setVerticalScrollBar(new ScrollBar());
        MenuList.setLayout(new MigLayout("fillx", "0[]0", "0[]0"));
        userAccount = new ArrayList<>();
        PublicEvent.getInstance().addEventMenuLeft(new EventMenuLeft() {
            @Override
            public void newUser(List<Model_User_Account> users) {
                for (Model_User_Account U : users) {
                    userAccount.add(U);
                    MenuList.add(new item_People(U), "wrap");

                }
            }

            @Override
            public void userConnect(int userID) {
                for (Model_User_Account u : userAccount) {
                    if (u.getUserID() == userID) {
                        u.setStatus(true);
                        PublicEvent.getInstance().getEventMain().updateUser(u);
                        break;
                    }
                }
                if (menuMessage.isSelected()) {
                    for (Component com : MenuList.getComponents()) {
                        item_People item = (item_People) com;
                        if (item.getUser().getUserID() == userID) {
                            item.updateStatus();
                            break;
                        }
                    }
                }
            }

            @Override
            public void userDisconnect(int userID) {
                for (Model_User_Account u : userAccount) {
                    if (u.getUserID() == userID) {
                        u.setStatus(false);
                        PublicEvent.getInstance().getEventMain().updateUser(u);
                        break;
                    }
                }
                if (menuMessage.isSelected()) {
                    for (Component com : MenuList.getComponents()) {
                        item_People item = (item_People) com;
                        if (item.getUser().getUserID() == userID) {
                            item.updateStatus();
                            break;
                        }
                    }
                }

            }
        });
        showMessage();
    }

    private void showMessage() {
        MenuList.removeAll();
        for (Model_User_Account U : userAccount) {
            MenuList.add(new item_People(null), "wrap");
        }
        refreshMenuList();
    }

    private void showGroup() {
        MenuList.removeAll();
        for (int i = 0; i < 12; i++) {
            MenuList.add(new item_People(null), "wrap");
        }
        refreshMenuList();
    }

    private void showBox() {
        MenuList.removeAll();
        for (int i = 0; i < 2; i++) {
            MenuList.add(new item_People(null), "wrap");
        }
        refreshMenuList();
    }

    private void refreshMenuList() {
        MenuList.repaint();
        MenuList.revalidate();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menu = new javax.swing.JLayeredPane();
        menuMessage = new com.pfa.component.MenuButton();
        menuGroup = new com.pfa.component.MenuButton();
        menuBox = new com.pfa.component.MenuButton();
        sp = new javax.swing.JScrollPane();
        MenuList = new javax.swing.JLayeredPane();

        setBackground(new java.awt.Color(249, 249, 249));

        menu.setBackground(new java.awt.Color(249, 249, 249));
        menu.setOpaque(true);
        menu.setLayout(new java.awt.GridLayout(1, 3));

        menuMessage.setIconSelected(new javax.swing.ImageIcon(getClass().getResource("/com/pfa/icon/message_selected.png"))); // NOI18N
        menuMessage.setIconSimple(new javax.swing.ImageIcon(getClass().getResource("/com/pfa/icon/message.png"))); // NOI18N
        menuMessage.setSelected(true);
        menuMessage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuMessageActionPerformed(evt);
            }
        });
        menu.add(menuMessage);

        menuGroup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/pfa/icon/group.png"))); // NOI18N
        menuGroup.setIconSelected(new javax.swing.ImageIcon(getClass().getResource("/com/pfa/icon/group_selected.png"))); // NOI18N
        menuGroup.setIconSimple(new javax.swing.ImageIcon(getClass().getResource("/com/pfa/icon/group.png"))); // NOI18N
        menuGroup.setPreferredSize(new java.awt.Dimension(50, 42));
        menuGroup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuGroupActionPerformed(evt);
            }
        });
        menu.add(menuGroup);

        menuBox.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/pfa/icon/box.png"))); // NOI18N
        menuBox.setIconSelected(new javax.swing.ImageIcon(getClass().getResource("/com/pfa/icon/box_selected.png"))); // NOI18N
        menuBox.setIconSimple(new javax.swing.ImageIcon(getClass().getResource("/com/pfa/icon/box.png"))); // NOI18N
        menuBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuBoxActionPerformed(evt);
            }
        });
        menu.add(menuBox);

        sp.setBackground(new java.awt.Color(249, 249, 249));
        sp.setBorder(null);
        sp.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        MenuList.setBackground(new java.awt.Color(249, 249, 249));
        MenuList.setOpaque(true);

        javax.swing.GroupLayout MenuListLayout = new javax.swing.GroupLayout(MenuList);
        MenuList.setLayout(MenuListLayout);
        MenuListLayout.setHorizontalGroup(
            MenuListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        MenuListLayout.setVerticalGroup(
            MenuListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 471, Short.MAX_VALUE)
        );

        sp.setViewportView(MenuList);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1))
            .addComponent(sp)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(sp, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(265, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void menuMessageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuMessageActionPerformed
        if (!menuMessage.isSelected()) {
            menuMessage.setSelected(true);
            menuGroup.setSelected(false);
            menuBox.setSelected(false);
            showMessage();
        }
    }//GEN-LAST:event_menuMessageActionPerformed

    private void menuGroupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuGroupActionPerformed
        if (!menuGroup.isSelected()) {
            menuMessage.setSelected(false);
            menuGroup.setSelected(true);
            menuBox.setSelected(false);
            showGroup();
        }
    }//GEN-LAST:event_menuGroupActionPerformed

    private void menuBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuBoxActionPerformed
        if (!menuBox.isSelected()) {
            menuMessage.setSelected(false);
            menuGroup.setSelected(false);
            menuBox.setSelected(true);
            showBox();
        }
    }//GEN-LAST:event_menuBoxActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane MenuList;
    private javax.swing.JLayeredPane menu;
    private com.pfa.component.MenuButton menuBox;
    private com.pfa.component.MenuButton menuGroup;
    private com.pfa.component.MenuButton menuMessage;
    private javax.swing.JScrollPane sp;
    // End of variables declaration//GEN-END:variables
}
