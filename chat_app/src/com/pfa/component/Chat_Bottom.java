package com.pfa.component;

import com.pfa.app.MessageType;
import com.pfa.event.PublicEvent;
import com.pfa.model.Model_Send_Message;
import com.pfa.model.Model_User_Account;
import com.pfa.service.Service;
import com.pfa.swing.JIMSendTextPane;
import com.pfa.swing.ScrollBar;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author safae
 */
public class Chat_Bottom extends javax.swing.JPanel {

    public Model_User_Account getUser() {
        return user;
    }

    public void setUser(Model_User_Account user) {
        this.user = user;
        panelMore.setUser(user);
    }

    private Model_User_Account user;

    public Chat_Bottom() {
        initComponents();
        init();
    }

    private void init() {
        mig = new MigLayout("fillx, filly", "2[fill]0[]0[]2", "2[fill]2[]0");
        setLayout(mig);
        JScrollPane scroll = new JScrollPane();
        scroll.setBorder(null);
        scroll.setBorder(null);
        JIMSendTextPane txt = new JIMSendTextPane();
        txt.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent ke) {
                refresh();
                if(ke.getKeyChar() == 10 &&ke.isControlDown()){
                    eventSend(txt);
                }
            }
        });
        txt.setBorder(new EmptyBorder(5, 5, 5, 5));
        txt.setHintText("Ecrire un message ici ...");
        scroll.setViewportView(txt);
        ScrollBar sb = new ScrollBar();
        sb.setBackground(new Color(229, 229, 229));
        scroll.setVerticalScrollBar(sb);
        sb.setPreferredSize(new Dimension(2, 10));
        add(sb);
        add(scroll, "w 100%");
        JPanel panel = new JPanel();
        panel.setLayout(new MigLayout("filly", "0[]3[]0", "0[bottom]0"));
        panel.setPreferredSize(new Dimension(30, 28));
        JButton cmd = new JButton();
        cmd.setBorder(null);
        panel.setBackground(Color.WHITE);
        cmd.setContentAreaFilled(false);
        cmd.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cmd.setIcon(new ImageIcon(getClass().getResource("/com/pfa/icon/send.png")));
        cmd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eventSend(txt);
            }

        });

        JButton cmdMore = new JButton();
        cmdMore.setBorder(null);
        panel.setBackground(Color.WHITE);
        cmdMore.setContentAreaFilled(false);
        cmdMore.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cmdMore.setIcon(new ImageIcon(getClass().getResource("/com/pfa/icon/more_disable.png")));
        cmdMore.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(panelMore.isVisible()){
                    cmdMore.setIcon(new ImageIcon(getClass().getResource("/com/pfa/icon/more_disable.png")));
                    panelMore.setVisible(false);
                    mig.setComponentConstraints(panelMore, "dock south, h 0!");
                    revalidate();
                }else{
                    cmdMore.setIcon(new ImageIcon(getClass().getResource("/com/pfa/icon/more.png")));
                    panelMore.setVisible(true);
                    mig.setComponentConstraints(panelMore, "dock south, h 170!");
                    revalidate();
                }

            }
        });
        panel.add(cmdMore);
        panel.add(cmd);
        add(panel, "wrap");
        panelMore = new Panel_More();
        panelMore.setVisible(false);
        add(panelMore, "dock south, h 0!");

    }

    private void eventSend(JIMSendTextPane txt){
        String text = txt.getText().trim();
                if (!text.equals("")) {
                    Model_Send_Message message = new Model_Send_Message(MessageType.TEXT,Service.getInstance().getUser().getUserID(), user.getUserID(), text);
                    send(message);
                    PublicEvent.getInstance().getEventChat().sendMessage(message);
                    txt.setText("");
                    txt.grabFocus();
                    refresh();
                } else {
                    txt.grabFocus();
                }
    }
    
    private void send(Model_Send_Message data) {
        Service.getInstance().getClient().emit("send_to_user", data.toJSONObject());
    }

    private void refresh() {
        revalidate();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(229, 229, 229));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 391, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    
    private MigLayout mig;
    private Panel_More panelMore;


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
