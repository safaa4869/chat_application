package com.pfa.component;

import com.pfa.app.MessageType;
import com.pfa.emoji.icon.Emoji;
import com.pfa.emoji.icon.Model_Emoji;
import com.pfa.emoji.icon.Emoji;
import com.pfa.emoji.icon.Model_Emoji;
import com.pfa.event.PublicEvent;
import com.pfa.main.Main;
import com.pfa.model.Model_Send_Message;
import com.pfa.model.Model_User_Account;
import com.pfa.service.Service;
import com.pfa.swing.ScrollBar;
import com.pfa.swing.WrapLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileFilter;
import net.miginfocom.swing.MigLayout;
import org.w3c.dom.css.CSSPrimitiveValue;

public class Panel_More extends javax.swing.JPanel {
    
    public Model_User_Account getUser() {
        return user;
    }
    
    public void setUser(Model_User_Account user) {
        this.user = user;
    }
    
    private Model_User_Account user;
    
    public Panel_More() {
        initComponents();
        init();
    }
    
    private void init() {
        setLayout(new MigLayout("fillx"));
        panelHeader = new JPanel();
        panelHeader.setLayout(new BoxLayout(panelHeader, BoxLayout.LINE_AXIS));
        panelHeader.add(getButtonImage());
        panelHeader.add(getButtonFile());
        panelHeader.add(getEmojiStyle1());
        panelHeader.add(getEmojiStyle2());
        add(panelHeader, " w 100%, h 30!, wrap");
        panelDetail = new JPanel();
        panelDetail.setLayout(new WrapLayout(WrapLayout.LEFT));
        JScrollPane ch = new JScrollPane(panelDetail);
        ch.setBorder(null);
        ch.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        ch.setVerticalScrollBar(new ScrollBar());
        //test color
        add(ch, "w 100%, h  100%");
    }
    
    private JButton getButtonImage() {
        OptionButton cmd = new OptionButton();
        cmd.setIcon(new ImageIcon(getClass().getResource("/com/pfa/icon/image.png")));
        cmd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser ch = new JFileChooser();
                ch.setMultiSelectionEnabled(true);
                ch.setFileFilter(new FileFilter() {
                    @Override
                    public boolean accept(File file) {
                        return file.isDirectory() || isImageFile(file);
                    }
                    
                    @Override
                    public String getDescription() {
                        return "Image File";
                    }
                    
                });
                
                int option = ch.showOpenDialog(Main.getFrames()[0]);
                if(option == JFileChooser.APPROVE_OPTION){
                    File files[]= ch.getSelectedFiles();
                    try {
                        for(File file : files){
                            Model_Send_Message message = new Model_Send_Message(MessageType.IMAGE, Service.getInstance().getUser().getUserID(), user.getUserID(),"");
                            Service.getInstance().addFile(file, message);
                            PublicEvent.getInstance().getEventChat().sendMessage(message);
                        }
                    }catch(IOException ex){
                        ex.printStackTrace();
                    }
                }
            }
            
        });
        return cmd;
    }
    
    private JButton getButtonFile() {
        OptionButton cmd = new OptionButton();
        cmd.setIcon(new ImageIcon(getClass().getResource("/com/pfa/icon/link.png")));
        cmd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser ch = new JFileChooser();
                ch.showOpenDialog(Main.getFrames()[0]);
                //update next
            }
            
        });
        return cmd;
    }
    
    private JButton getEmojiStyle1() {
        
        OptionButton cmd = new OptionButton();
        cmd.setIcon(Emoji.getInstance().getEmoji(1).toSize(25, 25).getIcon());
        cmd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearSelected();
                cmd.setSelected(true);
                panelDetail.removeAll();
                for (Model_Emoji d : Emoji.getInstance().getStyle1()) {
                    panelDetail.add(getButton(d));
                }
                panelDetail.repaint();
                panelDetail.revalidate();
            }
            
        });
        return cmd;
    }
    
    private JButton getEmojiStyle2() {
        
        OptionButton cmd = new OptionButton();
        cmd.setIcon(Emoji.getInstance().getEmoji(21).toSize(25, 25).getIcon());
        cmd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearSelected();
                cmd.setSelected(true);
                panelDetail.removeAll();
                for (Model_Emoji d : Emoji.getInstance().getStyle2()) {
                    
                    panelDetail.add(getButton(d));
                }
                panelDetail.repaint();
                panelDetail.revalidate();
            }
            
        });
        return cmd;
    }
    
    private JButton getButton(Model_Emoji data) {
        JButton cmd = new JButton(data.getIcon());
        cmd.setName(data.getId() + "");
        cmd.setBorder(new EmptyBorder(3, 3, 3, 3));
        cmd.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cmd.setContentAreaFilled(false);
        cmd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Model_Send_Message message = new Model_Send_Message(MessageType.EMOJI, Service.getInstance().getUser().getUserID(), user.getUserID(), data.getId() + "");
                sendMessage(message);
                PublicEvent.getInstance().getEventChat().sendMessage(message);
            }
        });
        return cmd;
    }
    
    private void sendMessage(Model_Send_Message data) {
        Service.getInstance().getClient().emit("send_to_user", data.toJSONObject());
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 515, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 94, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void clearSelected() {
        for (Component c : panelHeader.getComponents()) {
            if (c instanceof OptionButton) {
                ((OptionButton) c).setSelected(false);
            }
        }
    }
    
    private boolean isImageFile(File file) {
        String name = file.getName().toLowerCase();
        return name.endsWith(".jpg") || name.endsWith(".png") || name.endsWith(".gif");
    }
    private JPanel panelHeader;
    private JPanel panelDetail;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
