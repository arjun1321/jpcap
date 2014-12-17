/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jpcap;

import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;
import jpcap.packet.*;

/**
 *
 * @author Priyath
 */
public class sessionFilter extends javax.swing.JFrame {
    
    UpdateGUI guiObject1 = new UpdateGUI(); //instance of CapturePackets class to access the methods
    NewJFrame3 nj3 = new NewJFrame3();
    ArrayList al1;     //array list to hold required packets
    DefaultTableModel m;
    JLabel http,tcp,udp,icmp,total,totalB;
     
    /** Creates new form sessionFilter
     * @param al1
     * @param m */
    public sessionFilter(ArrayList al1, DefaultTableModel m, JLabel http, JLabel tcp, JLabel udp, JLabel icmp,JLabel total,JLabel totalB) { //constructor to pass arguments from the NewJFrame3 class
        
        initComponents();
        this.al1 = al1;
        this.m = m;
        this.http = http;
        this.tcp = tcp;
        this.udp = udp;
        this.icmp = icmp;
        this.total = total;
        this.totalB = totalB;
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
        ipCheckBox = new javax.swing.JCheckBox();
        jLabel9 = new javax.swing.JLabel();
        portCheckBox = new javax.swing.JCheckBox();
        jLabel10 = new javax.swing.JLabel();
        piCheckBox = new javax.swing.JCheckBox();
        jLabel11 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("PROTOCOL:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, 40));

        buttonGroup1.add(icmpRadioButton);
        icmpRadioButton.setText("ICMP");
        icmpRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                icmpRadioButtonActionPerformed(evt);
            }
        });
        getContentPane().add(icmpRadioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 60, -1, -1));

        buttonGroup1.add(tcpRadioButton);
        tcpRadioButton.setText("TCP");
        tcpRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tcpRadioButtonActionPerformed(evt);
            }
        });
        getContentPane().add(tcpRadioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, -1, -1));

        buttonGroup1.add(httpRadioButton);
        httpRadioButton.setText("HTTP");
        httpRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                httpRadioButtonActionPerformed(evt);
            }
        });
        getContentPane().add(httpRadioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, 59, -1));

        buttonGroup1.add(udpRadioButton);
        udpRadioButton.setText("UDP");
        udpRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                udpRadioButtonActionPerformed(evt);
            }
        });
        getContentPane().add(udpRadioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 60, -1, -1));

        jLabel2.setText("FILTERS");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 21, -1, -1));

        jLabel3.setText("PORT:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 123, -1, -1));

        jLabel4.setText("Dst Port:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(248, 123, -1, -1));

        jLabel5.setText("Src Port:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(89, 123, -1, -1));

        sportTextField.setText("");
        getContentPane().add(sportTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(141, 120, 34, -1));

        dportTextField.setText("");
        dportTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dportTextFieldActionPerformed(evt);
            }
        });
        getContentPane().add(dportTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(301, 120, 34, -1));

        jLabel6.setText("IP ADDRESS:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 199, -1, -1));

        jLabel7.setText("Src IP:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(91, 199, -1, -1));

        jLabel8.setText("Dst IP:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(266, 199, -1, -1));

        setFilterButton.setText("SET FILTERS");
        setFilterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setFilterButtonActionPerformed(evt);
            }
        });
        getContentPane().add(setFilterButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 270, 110, -1));

        sipTextField.setText("");
        getContentPane().add(sipTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 196, 82, -1));

        dipTextField.setText("");
        getContentPane().add(dipTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(303, 196, 82, -1));

        ipCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ipCheckBoxActionPerformed(evt);
            }
        });
        getContentPane().add(ipCheckBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(229, 195, -1, -1));

        jLabel9.setText("AND");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(229, 222, -1, -1));

        portCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                portCheckBoxActionPerformed(evt);
            }
        });
        getContentPane().add(portCheckBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(201, 120, -1, -1));

        jLabel10.setText("AND");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, -1, 20));

        piCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                piCheckBoxActionPerformed(evt);
            }
        });
        getContentPane().add(piCheckBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));

        jLabel11.setText("AND");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(201, 146, -1, -1));

        jButton1.setText("CLEAR FILTERS");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 270, 110, -1));

        setBounds(920, 150, 411, 367);
    }// </editor-fold>//GEN-END:initComponents

    private void httpRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_httpRadioButtonActionPerformed
        
        
        sportTextField.setEditable(true);
        dportTextField.setEditable(true);
        portCheckBox.setEnabled(true);
        piCheckBox.setEnabled(true);
    }//GEN-LAST:event_httpRadioButtonActionPerformed

    private void dportTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dportTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dportTextFieldActionPerformed

  
    private void tcpRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tcpRadioButtonActionPerformed
        sportTextField.setEditable(true);
        dportTextField.setEditable(true);
        portCheckBox.setEnabled(true);
        piCheckBox.setEnabled(true);
    }//GEN-LAST:event_tcpRadioButtonActionPerformed

    private void setFilterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setFilterButtonActionPerformed
        // TODO add your handling code here:
            
             while (m.getRowCount() > 0){
                for (int i = 0; i < m.getRowCount(); i++){
                    m.removeRow(i);
                }
             }
             
                guiObject1.tcpCount = 0;
                guiObject1.udpCount = 0;
                guiObject1.httpCount=0;
                guiObject1.icmpCount = 0;
            //remove all rows (if any) before populating table
             int sPort = -1;  
             int dPort = -1;
             String sIp = "";
             String dIp = "";
             
             if (!"".equals(sportTextField.getText()))
                sPort = Integer.parseInt(sportTextField.getText());
             
             if (!"".equals(dportTextField.getText()))
                dPort = Integer.parseInt(dportTextField.getText());
             
             if (!"".equals(sipTextField.getText()))
             {
                sIp = (sipTextField.getText());
                sIp = "/" + sIp;

             }
             
             if (!"".equals(dipTextField.getText()))
             {
                dIp= (dipTextField.getText());
                dIp = "/" + dIp;
             }

             
             //filter packets according to the selections/filters set by the user.
             
             
            
                for(int x=0; x < al1.size();x++)
                {
                    
                    Packet p = (Packet) al1.get(x);

                     //sort by protocol
                        if (httpRadioButton.isSelected())
                        {    
                           
                            if(guiObject1.isHttp(p)) 
                            {
                                TCPPacket httpP = (TCPPacket)p;
                                if ( (sPort == -1) && (dPort == -1) && (sIp).equals("") && (dIp).equals(""))
                                {

                                    guiObject1.populate_table(p, m, x+1);
                                }
                                
                                else if (portCheckBox.isSelected() && ipCheckBox.isSelected() && piCheckBox.isSelected() )
                                {
                                    if ( ((httpP.src_port == sPort) && (httpP.dst_port == dPort)) && ((String.valueOf(httpP.src_ip)).equals(sIp) && (String.valueOf(httpP.dst_ip)).equals(dIp)))
                                        guiObject1.populate_table(p, m, x+1);
                                }
                                else if (!portCheckBox.isSelected() && !ipCheckBox.isSelected() && piCheckBox.isSelected())
                                {        if ( ((httpP.src_port == sPort) || (httpP.dst_port == dPort)) && ((String.valueOf(httpP.src_ip)).equals(sIp) || (String.valueOf(httpP.dst_ip)).equals(dIp)))
                                        guiObject1.populate_table(p, m, x+1);
                                }
                                else if (!portCheckBox.isSelected() && !ipCheckBox.isSelected() && !piCheckBox.isSelected())
                                {    if ( ((httpP.src_port == sPort) || (httpP.dst_port == dPort)) || ((String.valueOf(httpP.src_ip)).equals(sIp) || (String.valueOf(httpP.dst_ip)).equals(dIp)))
                                    guiObject1.populate_table(p, m, x+1);
                                }
                                else if (portCheckBox.isSelected() && !ipCheckBox.isSelected() && !piCheckBox.isSelected())
                                {    if ( ((httpP.src_port == sPort) && (httpP.dst_port == dPort)) || ((String.valueOf(httpP.src_ip)).equals(sIp) || (String.valueOf(httpP.dst_ip)).equals(dIp)))
                                    guiObject1.populate_table(p, m, x+1);
                                }
                                else if (!portCheckBox.isSelected() && ipCheckBox.isSelected() && !piCheckBox.isSelected())
                                {    if ( ((httpP.src_port == sPort) || (httpP.dst_port == dPort)) || ((String.valueOf(httpP.src_ip)).equals(sIp) && (String.valueOf(httpP.dst_ip)).equals(dIp)))
                                    guiObject1.populate_table(p, m, x+1);
                                }
                                else if ( (sPort == -1) && (dPort == -1) && (sIp).equals("") && (dIp).equals(""))
                                    guiObject1.populate_table(p, m, x+1);
                                
                            continue;
                            }           
                        }
         
                         if (tcpRadioButton.isSelected())
                         {
 
                              if(guiObject1.isTcp(p))
                             {
                                TCPPacket tcpP = (TCPPacket)p;
                                
                                if ( (sPort == -1) && (dPort == -1) && (sIp).equals("") && (dIp).equals(""))
                                {
                                    guiObject1.populate_table(p, m, x+1);
                                }
                               
                                else if (portCheckBox.isSelected() && ipCheckBox.isSelected() && piCheckBox.isSelected() )
                                {
                                    if ( ((tcpP.src_port == sPort) && (tcpP.dst_port == dPort)) && ((String.valueOf(tcpP.src_ip)).equals(sIp) && (String.valueOf(tcpP.dst_ip)).equals(dIp)))
                                        guiObject1.populate_table(p, m, x+1);
                                }
                                else if (!portCheckBox.isSelected() && !ipCheckBox.isSelected() && piCheckBox.isSelected())
                                {        if ( ((tcpP.src_port == sPort) || (tcpP.dst_port == dPort)) && ((String.valueOf(tcpP.src_ip)).equals(sIp) || (String.valueOf(tcpP.dst_ip)).equals(dIp)))
                                        guiObject1.populate_table(p, m, x+1);
                                }
                                else if (!portCheckBox.isSelected() && !ipCheckBox.isSelected() && !piCheckBox.isSelected())
                                {     
                                    if ( ((tcpP.src_port == sPort) || (tcpP.dst_port == dPort)) || ((String.valueOf(tcpP.src_ip)).equals(sIp) || (String.valueOf(tcpP.dst_ip)).equals(dIp)))
                                        guiObject1.populate_table(p, m, x+1);
                                }
                                else if (portCheckBox.isSelected() && !ipCheckBox.isSelected() && !piCheckBox.isSelected())
                                {    if ( ((tcpP.src_port == sPort) && (tcpP.dst_port == dPort)) || ((String.valueOf(tcpP.src_ip)).equals(sIp) || (String.valueOf(tcpP.dst_ip)).equals(dIp)))
                                    guiObject1.populate_table(p, m, x+1);
                                }
                                else if (!portCheckBox.isSelected() && ipCheckBox.isSelected() && !piCheckBox.isSelected())
                                {    if ( ((tcpP.src_port == sPort) || (tcpP.dst_port == dPort)) || ((String.valueOf(tcpP.src_ip)).equals(sIp) && (String.valueOf(tcpP.dst_ip)).equals(dIp)))
                                    guiObject1.populate_table(p, m, x+1);
                                }
                                
                                continue;
                            }    
                         }
                         
                         if (udpRadioButton.isSelected())
                         {
                              if(guiObject1.isUdp(p))
                            {
                               UDPPacket udpP = (UDPPacket)p;

                               if ( (sPort == -1) && (dPort == -1) && (sIp).equals("") && (dIp).equals(""))
                                {
                                    guiObject1.populate_table(p, m, x+1);
                                }
                               else if (portCheckBox.isSelected() && ipCheckBox.isSelected() && piCheckBox.isSelected() )
                                {
                                    if ( ((udpP.src_port == sPort) && (udpP.dst_port == dPort)) && ((String.valueOf(udpP.src_ip)).equals(sIp) && (String.valueOf(udpP.dst_ip)).equals(dIp)))
                                        guiObject1.populate_table(p, m, x+1);
                                }
                                else if (!portCheckBox.isSelected() && !ipCheckBox.isSelected() && piCheckBox.isSelected())
                                {        if ( ((udpP.src_port == sPort) || (udpP.dst_port == dPort)) && ((String.valueOf(udpP.src_ip)).equals(sIp) || (String.valueOf(udpP.dst_ip)).equals(dIp)))
                                        guiObject1.populate_table(p, m, x+1);
                                }
                                else if (!portCheckBox.isSelected() && !ipCheckBox.isSelected() && !piCheckBox.isSelected())
                                {    if ( ((udpP.src_port == sPort) || (udpP.dst_port == dPort)) || ((String.valueOf(udpP.src_ip)).equals(sIp) || (String.valueOf(udpP.dst_ip)).equals(dIp)))
                                    guiObject1.populate_table(p, m, x+1);
                                }
                                else if (portCheckBox.isSelected() && !ipCheckBox.isSelected() && !piCheckBox.isSelected())
                                {    if ( ((udpP.src_port == sPort) && (udpP.dst_port == dPort)) || ((String.valueOf(udpP.src_ip)).equals(sIp) || (String.valueOf(udpP.dst_ip)).equals(dIp)))
                                    guiObject1.populate_table(p, m, x+1);
                                }
                                else if (!portCheckBox.isSelected() && ipCheckBox.isSelected() && !piCheckBox.isSelected())
                                {    if ( ((udpP.src_port == sPort) || (udpP.dst_port == dPort)) || ((String.valueOf(udpP.src_ip)).equals(sIp) && (String.valueOf(udpP.dst_ip)).equals(dIp)))
                                    guiObject1.populate_table(p, m, x+1);
                                }
                                else if ( (sPort == -1) && (dPort == -1) && (sIp).equals("") && (dIp).equals(""))
                                    guiObject1.populate_table(p, m, x+1);
                                
                                continue;
                            }
                              
                              
                         }
                         
                         if (icmpRadioButton.isSelected())
                           if(guiObject1.isIcmp(p))
                            {
                               ICMPPacket icmpP = (ICMPPacket)p;
                               
                               if ((sIp).equals("") && (dIp).equals(""))
                                {
                                    guiObject1.populate_table(p, m, x+1);
                                }
                              
                               else if (ipCheckBox.isSelected() && piCheckBox.isSelected() )
                                {
                                    if (  ((String.valueOf(icmpP.src_ip)).equals(sIp) && (String.valueOf(icmpP.dst_ip)).equals(dIp)))
                                        guiObject1.populate_table(p, m, x+1);
                                }
                                else if ( !ipCheckBox.isSelected() && piCheckBox.isSelected())
                                {        if ( ((String.valueOf(icmpP.src_ip)).equals(sIp) || (String.valueOf(icmpP.dst_ip)).equals(dIp)))
                                        guiObject1.populate_table(p, m, x+1);
                                }
                                else if ( !ipCheckBox.isSelected() && !piCheckBox.isSelected())
                                {    if ( ((String.valueOf(icmpP.src_ip)).equals(sIp) || (String.valueOf(icmpP.dst_ip)).equals(dIp)))
                                    guiObject1.populate_table(p, m, x+1);
                                }
                                else if (!ipCheckBox.isSelected() && !piCheckBox.isSelected())
                                {    if ( ((String.valueOf(icmpP.src_ip)).equals(sIp) || (String.valueOf(icmpP.dst_ip)).equals(dIp)))
                                    guiObject1.populate_table(p, m, x+1);
                                }
                                else if (ipCheckBox.isSelected() && !piCheckBox.isSelected())
                                {    if ( ((String.valueOf(icmpP.src_ip)).equals(sIp) && (String.valueOf(icmpP.dst_ip)).equals(dIp)))
                                    guiObject1.populate_table(p, m, x+1);
                                }
                                
                                
                            }

                    }
                
                http.setText(String.valueOf(guiObject1.httpCount));
                tcp.setText(String.valueOf(guiObject1.tcpCount));
                udp.setText(String.valueOf(guiObject1.udpCount));
                icmp.setText(String.valueOf(guiObject1.icmpCount));
                total.setText(String.valueOf(guiObject1.httpCount+guiObject1.tcpCount+guiObject1.udpCount+guiObject1.icmpCount));
                
                int sum = 0;
                for (int i = 0; i < m.getRowCount();i++)
                {
                    sum = sum + (Integer)(m.getValueAt(i, 6));
                }
             
                totalB.setText("total bytes: " + String.valueOf(sum));
    }//GEN-LAST:event_setFilterButtonActionPerformed

    

    private void icmpRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_icmpRadioButtonActionPerformed
        // TODO add your handling code here:
        sportTextField.setEditable(false);
        dportTextField.setEditable(false);
        portCheckBox.setEnabled(false);
        piCheckBox.setEnabled(false);
              
    }//GEN-LAST:event_icmpRadioButtonActionPerformed

    private void udpRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_udpRadioButtonActionPerformed
        // TODO add your handling code here:
        sportTextField.setEditable(true);
        dportTextField.setEditable(true);
        portCheckBox.setEnabled(true);
        piCheckBox.setEnabled(true);
    }//GEN-LAST:event_udpRadioButtonActionPerformed

    private void ipCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ipCheckBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ipCheckBoxActionPerformed

    private void portCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_portCheckBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_portCheckBoxActionPerformed

    private void piCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_piCheckBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_piCheckBoxActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        ArrayList resObj = al1;
        
        buttonGroup1.clearSelection();
        sportTextField.setText("");
        dportTextField.setText("");
        sipTextField.setText("");
        dipTextField.setText("");
        portCheckBox.setSelected(false);
        ipCheckBox.setSelected(false);
        piCheckBox.setSelected(false);
        
        while (m.getRowCount() > 0){
                for (int i = 0; i < m.getRowCount(); i++){
                    m.removeRow(i);
                }
            }  //remove all rows (if any) before populating table
        
        guiObject1.tcpCount = 0;
        guiObject1.udpCount = 0;
        guiObject1.httpCount=0;
        guiObject1.icmpCount = 0;
        
        for (int r = 0; r < al1.size(); r++)
        {
            Packet pr = (Packet)resObj.get(r);
            guiObject1.populate_table(pr,m,r);
        }
        
        http.setText(String.valueOf(guiObject1.httpCount));
        tcp.setText(String.valueOf(guiObject1.tcpCount));
        udp.setText(String.valueOf(guiObject1.udpCount));
        icmp.setText(String.valueOf(guiObject1.icmpCount));
        total.setText(String.valueOf(guiObject1.httpCount+guiObject1.tcpCount+guiObject1.udpCount+guiObject1.icmpCount));
        
        int sum = 0;
        for (int i = 0; i < m.getRowCount();i++)
        {
            sum = sum + (Integer)(m.getValueAt(i, 6));
        }

        totalB.setText("total bytes: " + String.valueOf(sum));
    }//GEN-LAST:event_jButton1ActionPerformed


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
    private javax.swing.JCheckBox ipCheckBox;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JCheckBox piCheckBox;
    private javax.swing.JCheckBox portCheckBox;
    private javax.swing.JButton setFilterButton;
    private javax.swing.JTextField sipTextField;
    private javax.swing.JTextField sportTextField;
    private javax.swing.JRadioButton tcpRadioButton;
    private javax.swing.JRadioButton udpRadioButton;
    // End of variables declaration//GEN-END:variables

}
