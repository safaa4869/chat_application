
package com.pfa.component;

import java.awt.Color;
import javax.swing.Icon;


public class Chat_Left_with_Profile extends javax.swing.JLayeredPane {


    public Chat_Left_with_Profile() {
        initComponents();
        txt.setBackground(new Color(242,242,242));
    }
    
    public void setUserProfile(String User){
        txt.setUserProfile(User);
    }
    public void setImageProfile(Icon image){
    Ibimage.setImage(image);
    }
public void setText(String text){
    if(text.equals("")){
        txt.hideText();
    }else{
        txt.setText(text);
    }
    
    
}
public void setImage(Icon... image){
    //txt.setImage(false, image);
    //Update next
} 

public void setImage(String... image){
    txt.setImage(false, image);
}

public void setFile(String fileName, String fileSize){
    txt.setFile(fileName,fileSize);
}

public void setTime(){
    txt.setTime("10:30 PM");
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        Ibimage = new com.pfa.swing.ImageAvatar();
        txt = new com.pfa.component.Chat_Item();

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.LINE_AXIS));

        Ibimage.setBorderColor(new java.awt.Color(242, 242, 242));
        Ibimage.setBorderSize(1);
        Ibimage.setImage(new javax.swing.ImageIcon(getClass().getResource("/com/pfa/icon/testing/dog.jpg"))); // NOI18N
        Ibimage.setMaximumSize(new java.awt.Dimension(31, 31));
        Ibimage.setMinimumSize(new java.awt.Dimension(31, 31));
        Ibimage.setPreferredSize(new java.awt.Dimension(31, 31));

        jLayeredPane1.setLayer(Ibimage, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Ibimage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(Ibimage, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        add(jLayeredPane1);

        txt.setBackground(new java.awt.Color(249, 249, 249));
        add(txt);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.pfa.swing.ImageAvatar Ibimage;
    private javax.swing.JLayeredPane jLayeredPane1;
    private com.pfa.component.Chat_Item txt;
    // End of variables declaration//GEN-END:variables
}
