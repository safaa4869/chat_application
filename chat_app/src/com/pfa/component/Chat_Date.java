
package com.pfa.component;

/**
 *
 * @author safae
 */
public class Chat_Date extends javax.swing.JLayeredPane {


    public Chat_Date() {
        initComponents();
    }

    public void setDate(String date){
        IdDate.setText(date);
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        IdDate = new javax.swing.JLabel();
        line1 = new com.pfa.swing.Line();
        line2 = new com.pfa.swing.Line();

        IdDate.setForeground(new java.awt.Color(176, 176, 176));
        IdDate.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        IdDate.setText("06/06/2021");

        line1.setForeground(new java.awt.Color(176, 176, 176));

        line2.setForeground(new java.awt.Color(176, 176, 176));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(line1, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(IdDate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(line2, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(IdDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(line1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(line2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel IdDate;
    private com.pfa.swing.Line line1;
    private com.pfa.swing.Line line2;
    // End of variables declaration//GEN-END:variables
}
