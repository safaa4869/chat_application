package com.pfa.form;

import com.pfa.event.EventLogin;
import com.pfa.event.EventMessage;
import com.pfa.event.PublicEvent;
import com.pfa.model.Model_Login;
import com.pfa.model.Model_Message;
import com.pfa.model.Model_Register;
import com.pfa.model.Model_User_Account;
import com.pfa.service.Service;
import io.socket.client.Ack;

/**
 *
 * @author safae
 */
public class Login extends javax.swing.JPanel {

    public Login() {
        initComponents();
        init();
    }

    private void init() {
        PublicEvent.getInstance().addEventLogin(new EventLogin() {
            @Override
            public void login(Model_Login data) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        PublicEvent.getInstance().getEventMain().ShowLoading(true);
                        Service.getInstance().getClient().emit("login", data.toJSONObject(), new Ack() {
                            @Override
                            public void call(Object... os) {
                                if (os.length > 0) {
                                    boolean action = (Boolean) os[0];
                                    if (action) {
                                        Service.getInstance().setUser(new Model_User_Account(os[1]));
                                        PublicEvent.getInstance().getEventMain().ShowLoading(false);
                                        PublicEvent.getInstance().getEventMain().initChat();
                                    } else {
                                        //  password wrong
                                        PublicEvent.getInstance().getEventMain().ShowLoading(false);
                                    }
                                } else {
                                    PublicEvent.getInstance().getEventMain().ShowLoading(false);
                                }
                            }
                        });

                    }
                }).start();
            }

            @Override
            public void register(Model_Register data, EventMessage message) {

                Service.getInstance().getClient().emit("register", data.toJsonObject(), new Ack() {
                    @Override
                    public void call(Object... os) {
                        if (os.length > 0) {
                            Model_Message ms = new Model_Message((boolean) os[0], os[1].toString());
                            if (ms.isAction()) {
                                Model_User_Account user = new Model_User_Account(os[2]);
                                Service.getInstance().setUser(user);
                            }
                            message.callMessage(ms);
                        }
                    }

                });
            }

            @Override
            public void goRegister() {
                slide.show(1);
            }

            @Override
            public void goLogin() {
                slide.show(0);
            }

        });
        P_Login login = new P_Login();
        P_Register register = new P_Register();
        slide.init(login, register);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        plc = new com.pfa.swing.PictureBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        slide = new com.pfa.swing.PanelSlide();

        setBackground(new java.awt.Color(255, 255, 255));

        plc.setImage(new javax.swing.ImageIcon(getClass().getResource("/com/pfa/icon/login_image.png"))); // NOI18N

        jLabel2.setBackground(new java.awt.Color(66, 66, 66));
        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel2.setText("Chat Application");

        plc.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout plcLayout = new javax.swing.GroupLayout(plc);
        plc.setLayout(plcLayout);
        plcLayout.setHorizontalGroup(
            plcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plcLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(577, Short.MAX_VALUE))
        );
        plcLayout.setVerticalGroup(
            plcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, plcLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(0, 0, 0))
        );

        jLabel1.setBackground(new java.awt.Color(34, 142, 214));
        jLabel1.setOpaque(true);

        jPanel1.setBackground(new java.awt.Color(34, 142, 214));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        slide.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout slideLayout = new javax.swing.GroupLayout(slide);
        slide.setLayout(slideLayout);
        slideLayout.setHorizontalGroup(
            slideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 245, Short.MAX_VALUE)
        );
        slideLayout.setVerticalGroup(
            slideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 348, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(slide, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(slide, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(1, 1, 1))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(1, 1, 1))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(plc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(plc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 51, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private com.pfa.swing.PictureBox plc;
    private com.pfa.swing.PanelSlide slide;
    // End of variables declaration//GEN-END:variables
}
