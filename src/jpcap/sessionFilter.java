/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jpcap;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import jpcap.packet.Packet;
import jpcap.packet.TCPPacket;
import jpcap.packet.UDPPacket;

/**
 *
 * @author Priyath
 */
public class sessionFilter extends javax.swing.JFrame {
    
    CapturePackets cp5 = new CapturePackets(); //instance of CapturePackets class to access the methods
    ArrayList al1;     //array list to hold required packets
    DefaultTableModel m;
     
     
    /** Creates new form sessionFilter
     * @param al1
     * @param m */
    public sessionFilter(ArrayList al1, DefaultTableModel m) { //constructor to pass arguments from the NewJFrame3 class
        
        initComponents();
        this.al1 = al1;
        this.m = m;
    }

    private sessionFilter() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        icmpRadioButton = new javax.swing.JRadioButton();
        tcpRadioButton = new javax.swing.JRadioButton();
        httpRadioButton = new javax.swing.JRadioButton();
        udpRadioButton = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        sportTextField = new javax.swing.JTextField();
        dportTextField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        setFilterButton = new javax.swing.JButton();
        sipTextField = new javax.swing.JTextField();
        dipTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("PROTOCOL:");

        buttonGroup1.add(icmpRadioButton);
        icmpRadioButton.setText("ICMP");
        icmpRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                icmpRadioButtonActionPerformed(evt);
            }
        });

        buttonGroup1.add(tcpRadioButton);
        tcpRadioButton.setText("TCP");
        tcpRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tcpRadioButtonActionPerformed(evt);
            }
        });

        buttonGroup1.add(httpRadioButton);
        httpRadioButton.setText("HTTP");
        httpRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                httpRadioButtonActionPerformed(evt);
            }
        });

        buttonGroup1.add(udpRadioButton);
        udpRadioButton.setText("UDP");
        udpRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                udpRadioButtonActionPerformed(evt);
            }
        });

        jLabel2.setText("FILTERS");

        jLabel3.setText("PORT:");

        jLabel4.setText("Dst Port:");

        jLabel5.setText("Src Port:");

        sportTextField.setText("");

        dportTextField.setText("");
        dportTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dportTextFieldActionPerformed(evt);
            }
        });

        jLabel6.setText("IP ADDRESS:");

        jLabel7.setText("Src IP:");

        jLabel8.setText("Dst IP:");

        setFilterButton.setText("SET FILTERS");
        setFilterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setFilterButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(httpRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tcpRadioButton)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(udpRadioButton)
                        .addGap(18, 18, 18)
                        .addComponent(icmpRadioButton)
                        .addGap(80, 80, 80))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(46, 46, 46))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(14, 14, 14)))
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(sportTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(26, 26, 26)
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(dportTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(setFilterButton))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(121, 121, 121)
                                .addComponent(sipTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dipTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(httpRadioButton)
                    .addComponent(tcpRadioButton)
                    .addComponent(udpRadioButton)
                    .addComponent(icmpRadioButton))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(sportTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(dportTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(sipTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dipTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                .addComponent(setFilterButton)
                .addGap(57, 57, 57))
        );

        setSize(new java.awt.Dimension(365, 339));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void httpRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_httpRadioButtonActionPerformed
        
        
        sportTextField.setEditable(true);
        dportTextField.setEditable(true);
    }//GEN-LAST:event_httpRadioButtonActionPerformed

    private void dportTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dportTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dportTextFieldActionPerformed

  
    private void tcpRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tcpRadioButtonActionPerformed
        sportTextField.setEditable(true);
        dportTextField.setEditable(true);
    }//GEN-LAST:event_tcpRadioButtonActionPerformed

    private void setFilterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setFilterButtonActionPerformed
        // TODO add your handling code here:

             while (m.getRowCount() > 0){
                for (int i = 0; i < m.getRowCount(); i++){
                    m.removeRow(i);
                }
            }
            //remove all rows (if any) before populating table
             int sPort = -1;  
             int dPort = -1;
             
             if (!"".equals(sportTextField.getText()))
                sPort = Integer.parseInt(sportTextField.getText());
             
             if (!"".equals(dportTextField.getText()))
                dPort = Integer.parseInt(dportTextField.getText());

        
             //filter packets according to the selections/filters set by the user.
            
                for(int x=0; x < al1.size();x++)
                {
                    Packet p = (Packet) al1.get(x);

                    { //sort by protocol
                        if (httpRadioButton.isSelected())
                        {    
                            if(cp5.isHttp(p)) 
                            {
                                if ((sPort != -1) && (dPort != -1))
                                {
                                    if((((TCPPacket)p).src_port == sPort) && (((TCPPacket)p).dst_port == dPort))
                                    cp5.populate_table(p, m,x+1);
                                }
                                else if (sPort == -1 && dPort != -1)
                                {
                                    if(((TCPPacket)p).dst_port == dPort)
                                    cp5.populate_table(p, m,x+1);
                                }
                                else if (sPort != -1 && dPort == -1)
                                {
                                    if(((TCPPacket)p).src_port == sPort)
                                    cp5.populate_table(p, m,x+1);
                                }
                                else
                                    cp5.populate_table(p, m,x+1);
                            }
                            continue;
                        }           
                    
         
                         if (tcpRadioButton.isSelected())
                         {
                              if(cp5.isTcp(p))
                            {
                                if ((sPort != -1) && (dPort != -1))
                                {
                                    if((((TCPPacket)p).src_port == sPort) && (((TCPPacket)p).dst_port == dPort))
                                    cp5.populate_table(p, m,x+1);
                                }
                                else if (sPort == -1 && dPort != -1)
                                {
                                    if(((TCPPacket)p).dst_port == dPort)
                                    cp5.populate_table(p, m,x+1);
                                }
                                else if (sPort != -1 && dPort == -1)
                                {
                                    if(((TCPPacket)p).src_port == sPort)
                                    cp5.populate_table(p, m,x+1);
                                }
                                else
                                    cp5.populate_table(p, m,x+1);
                            }
                            continue;
                         }
                         
                         if (udpRadioButton.isSelected())
                         {
                              if(cp5.isUdp(p))
                            {
                                if ((sPort != -1) && (dPort != -1))
                                {
                                    if((((UDPPacket)p).src_port == sPort) && (((UDPPacket)p).dst_port == dPort))
                                    cp5.populate_table(p, m,x+1);
                                }
                                else if (sPort == -1 && dPort != -1)
                                {
                                    if(((UDPPacket)p).dst_port == dPort)
                                    cp5.populate_table(p, m,x+1);
                                }
                                else if (sPort != -1 && dPort == -1)
                                {
                                    if(((UDPPacket)p).src_port == sPort)
                                    cp5.populate_table(p, m,x+1);
                                }
                                else
                                    cp5.populate_table(p, m,x+1);
                            }
                              
                              continue;
                         }
                         
                         if (icmpRadioButton.isSelected())
                             
                             
                             if(cp5.isIcmp(p)) cp5.populate_table(p,m,x+1);
                    }
                         
                }

            dispose();
    }//GEN-LAST:event_setFilterButtonActionPerformed

    private void icmpRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_icmpRadioButtonActionPerformed
        // TODO add your handling code here:
        sportTextField.setEditable(false);
        dportTextField.setEditable(false);
    }//GEN-LAST:event_icmpRadioButtonActionPerformed

    private void udpRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_udpRadioButtonActionPerformed
        // TODO add your handling code here:
        sportTextField.setEditable(true);
        dportTextField.setEditable(true);
    }//GEN-LAST:event_udpRadioButtonActionPerformed


    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(sessionFilter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(sessionFilter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(sessionFilter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(sessionFilter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new sessionFilter().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField dipTextField;
    private javax.swing.JTextField dportTextField;
    private javax.swing.JRadioButton httpRadioButton;
    private javax.swing.JRadioButton icmpRadioButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JButton setFilterButton;
    private javax.swing.JTextField sipTextField;
    private javax.swing.JTextField sportTextField;
    private javax.swing.JRadioButton tcpRadioButton;
    private javax.swing.JRadioButton udpRadioButton;
    // End of variables declaration//GEN-END:variables

}
