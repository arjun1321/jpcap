/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpcap;

import java.io.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import jpcap.packet.Packet;
import jpcap.packet.TCPPacket;
import jpcap.packet.UDPPacket;
import org.jdesktop.xswingx.PromptSupport;


/**
 *
 * @author DELL
 */
public class NewJFrame3 extends javax.swing.JFrame {  
        
    ArrayList obj = new ArrayList();  //declartion of the ArrayList to store packets.
    DefaultTableModel m;
    CapturePackets cp0 = new CapturePackets(); //create new instance of the CapturePackets class
    volatile boolean cancelled = false;     //the flag to stop the while loop that executes the capture of packets
    String packet_count = "0";           //the value is used in the label to show the total number of packets captured
    int pck_count;

    public NewJFrame3() {   
  
        
        initComponents();
        m = (DefaultTableModel) jTable1.getModel();

        
        jTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
        @Override
            public void valueChanged(ListSelectionEvent e) { //action listner for the table to display captured packet details
                
                int sel = (jTable1.getSelectedRow()); //sel variable stores the index of the selected row
                
       
                if ((! e.getValueIsAdjusting()) && (sel != -1)) 
                {
                    int Pckno = (Integer)( jTable1.getModel().getValueAt(sel,0));
                    Packet p = (Packet) obj.get(Pckno-1);  //the packet corresponding to the row index is selected
                    
                    populate_text(p);                   //populate_text method is called to display the details of the selected packet
                }
            }
        });

        PromptSupport.setPrompt("Save As...", saveTextField); //prompt for save text field.
        
        NetworkInterface   [] devices = JpcapCaptor.getDeviceList();
 
        for (NetworkInterface device : devices){ //initialize network device list for combobox
            intefaceListCombo.addItem(device.name);    //add the interface list to the drop down menu
        }  
    }
    

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jFrame1 = new javax.swing.JFrame();
        jFrame2 = new javax.swing.JFrame();
        jFrame3 = new javax.swing.JFrame();
        jDialog1 = new javax.swing.JDialog();
        jDialog2 = new javax.swing.JDialog();
        jDialog3 = new javax.swing.JDialog();
        jDialog4 = new javax.swing.JDialog();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        saveButton = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        captureButton = new javax.swing.JButton();
        intefaceListCombo = new javax.swing.JComboBox();
        stopButton = new javax.swing.JButton();
        loadButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        saveTextField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        udpCountLabel = new javax.swing.JLabel();
        tcpCountLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        filterButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        httpCountLabel = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        icmpCountLabel = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        udpRadioButtonC = new javax.swing.JRadioButton();
        httpRadioButtonC = new javax.swing.JRadioButton();
        icmpRadioButtonC = new javax.swing.JRadioButton();
        tcpRadioButtonC = new javax.swing.JRadioButton();

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jpcap/images/light_fawn_and_blue_waves-1280x800.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                formComponentHidden(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Packet No", "Protocol", "Src IP", "Dest IP", "Src Port", "Dest Port", "Packet Length"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 580, 340));

        saveButton.setText("SAVE");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });
        getContentPane().add(saveButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 440, 60, 20));

        jLabel6.setForeground(new java.awt.Color(204, 204, 255));
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, 20, 20));

        captureButton.setText("START CAPTURE");
        captureButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                captureButtonActionPerformed(evt);
            }
        });
        getContentPane().add(captureButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 390, 120, 30));

        intefaceListCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select interface" }));
        intefaceListCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                intefaceListComboActionPerformed(evt);
            }
        });
        getContentPane().add(intefaceListCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 210, -1));

        stopButton.setText("STOP CAPTURE");
        stopButton.setEnabled(false);
        stopButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopButtonActionPerformed(evt);
            }
        });
        getContentPane().add(stopButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 390, 120, 30));

        loadButton.setText("Load previous session");
        loadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadButtonActionPerformed(evt);
            }
        });
        getContentPane().add(loadButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 10, 140, -1));

        jLabel4.setText("Save session");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 410, -1, -1));

        saveTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveTextFieldActionPerformed(evt);
            }
        });
        getContentPane().add(saveTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 440, 70, -1));

        totalCountLabel.setText(packet_count);
        getContentPane().add(totalCountLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 390, -1, -1));

        jLabel7.setText("Packets captured");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, -1, -1));

        jLabel8.setText("TCP");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, -1, -1));

        jLabel9.setText("HTTP");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 450, -1, -1));

        udpCountLabel.setText("0");
        getContentPane().add(udpCountLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 430, 30, -1));

        tcpCountLabel.setText("0");
        getContentPane().add(tcpCountLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 410, 30, -1));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 490, 700, 220));

        jLabel3.setText("PACKET DETAILS");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 460, 90, 20));

        filterButton.setText("FILTER SESSION");
        filterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterButtonActionPerformed(evt);
            }
        });
        getContentPane().add(filterButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 390, 120, -1));

        jLabel1.setText("Capture Filter");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 60, -1, -1));

        jLabel12.setText("UDP");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, -1, -1));

        httpCountLabel.setText("0");
        getContentPane().add(httpCountLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 450, 30, -1));

        jLabel14.setText("ICMP");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 470, -1, -1));

        icmpCountLabel.setText("0");
        getContentPane().add(icmpCountLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 470, 30, -1));

        jLabel16.setText("Protocol:");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 90, -1, -1));

        udpRadioButtonC.setText("UDP");
        udpRadioButtonC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                udpRadioButtonCActionPerformed(evt);
            }
        });
        getContentPane().add(udpRadioButtonC, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 130, -1, 20));

        httpRadioButtonC.setText("HTTP");
        httpRadioButtonC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                httpRadioButtonCActionPerformed(evt);
            }
        });
        getContentPane().add(httpRadioButtonC, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 90, -1, 20));

        icmpRadioButtonC.setText("ICMP");
        icmpRadioButtonC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                icmpRadioButtonCActionPerformed(evt);
            }
        });
        getContentPane().add(icmpRadioButtonC, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 150, -1, 20));

        tcpRadioButtonC.setText("TCP");
        tcpRadioButtonC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tcpRadioButtonCActionPerformed(evt);
            }
        });
        getContentPane().add(tcpRadioButtonC, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 110, -1, 20));

        setSize(new java.awt.Dimension(761, 750));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

 
    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
                                                    
            String filename = saveTextField.getText(); //entered filename is stored to a string variable

            //object is written to the drive
            try {
                FileOutputStream fos = new FileOutputStream("C:\\"+filename+".txt"); 
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(obj);
                oos.close();
                fos.close();                  
            }
            catch (IOException ex) {
                Logger.getLogger(NewJFrame3.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_saveButtonActionPerformed

    
    private void captureButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_captureButtonActionPerformed

            captureButton.setEnabled(false); //once a capture is started the button is disabled
            stopButton.setEnabled(true);       //the stop buttn is enabled
            
            //variables from the CapturePackets to monitor the number of packets captured. all initialized to 0.
            cp0.tcpCount = 0;
            cp0.udpCount = 0;
            cp0.httpCount = 0;
            cp0.icmpCount = 0;
            pck_count = 0;
            PacketCaptureWorker pcw = new PacketCaptureWorker();//instance of thread to capture packets
            
            while (m.getRowCount() > 0){
                for (int i = 0; i < m.getRowCount(); i++){
                    m.removeRow(i);
                }
            }  //remove all rows (if any) before populating table
            
            obj.clear(); 
            cancelled = false; //set flag to false controls the while loop
            pcw.start(); //start a thread to capture packets
         
    }//GEN-LAST:event_captureButtonActionPerformed

    private void intefaceListComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_intefaceListComboActionPerformed
  
        
    }//GEN-LAST:event_intefaceListComboActionPerformed

    private void stopButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopButtonActionPerformed
        
        captureButton.setEnabled(true);
        cancelled = true;
        stopButton.setEnabled(false);
        
    }//GEN-LAST:event_stopButtonActionPerformed


    private void loadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadButtonActionPerformed

        JFileChooser jfc = new JFileChooser();
        int a = jfc.showOpenDialog(this);
              
        FileReader reader = null;

                   
     if (a == JFileChooser.APPROVE_OPTION) //loads a previous session from memory
     {

            try {
                //DESERIALIZATION of array list.
                File f = jfc.getSelectedFile();
                FileInputStream fis = new FileInputStream(f);
                ObjectInputStream ois = new ObjectInputStream(fis);
                
                obj.clear(); 
                obj = (ArrayList) ois.readObject(); //obj ArrayList now stores the loaded session from memory
                
                ois.close();
                fis.close();
                
//populating the table with the loaded session.
                
                while (m.getRowCount() > 0){
                    
                    for (int i = 0; i < m.getRowCount(); i++){
                    m.removeRow(i);
                    }
                }  //remove all rows (if any) before populating table
                
                cp0.tcpCount = 0;
                cp0.udpCount = 0;
                cp0.httpCount = 0;
                cp0.icmpCount = 0;
                pck_count = 0;
                
                for (Object obj1 : obj) {
                    pck_count++;
                    cp0.populate_table((Packet) obj1, m,pck_count); //populate_table method is used to display captured packets
                }

             totalCountLabel.setText(String.valueOf(cp0.udpCount+cp0.tcpCount+cp0.httpCount+cp0.icmpCount));  //update Jlabel showing number of packets captured
             udpCountLabel.setText(String.valueOf(cp0.udpCount));
             tcpCountLabel.setText(String.valueOf(cp0.tcpCount));
             httpCountLabel.setText(String.valueOf(cp0.httpCount));
             icmpCountLabel.setText(String.valueOf(cp0.icmpCount));
                
            } catch (FileNotFoundException ex) {
                Logger.getLogger(NewJFrame3.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(NewJFrame3.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(NewJFrame3.class.getName()).log(Level.SEVERE, null, ex);
            }

     }

    }//GEN-LAST:event_loadButtonActionPerformed

    private void saveTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveTextFieldActionPerformed

    }//GEN-LAST:event_saveTextFieldActionPerformed

    private void filterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterButtonActionPerformed

       sessionFilter sf = new sessionFilter(obj,m); //new instance of sessionFilter frame, This provides access to session filter options
       sf.setVisible(true);
    }//GEN-LAST:event_filterButtonActionPerformed

    private void udpRadioButtonCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_udpRadioButtonCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_udpRadioButtonCActionPerformed

    private void httpRadioButtonCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_httpRadioButtonCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_httpRadioButtonCActionPerformed

    private void icmpRadioButtonCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_icmpRadioButtonCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_icmpRadioButtonCActionPerformed

    private void tcpRadioButtonCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tcpRadioButtonCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tcpRadioButtonCActionPerformed

    private void formComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentHidden
        // TODO add your handling code here:
    }//GEN-LAST:event_formComponentHidden


    //method to populate the text box with details of a selected packet
    
    private void populate_text(Packet p) {

        jTextArea1.setText(null);//clear text area before populating
        
        if (p instanceof TCPPacket){


            TCPPacket tcpPckt =(TCPPacket)p ;
            
            //assign packet details to variables
            String srcIP = String.valueOf(tcpPckt.src_ip);
            String destIP = String.valueOf(tcpPckt.dst_ip);
            String protocol = String.valueOf(tcpPckt.protocol);
            int srcPort = tcpPckt.src_port;
            int dstPort = tcpPckt.dst_port;
            
            byte[] header = tcpPckt.header;
            int version = tcpPckt.version;
            jTextArea1.append("Header: ");
            for (int k = 0; k < header.length; k++)
            {
             jTextArea1.append((header[k] +" "));
            }
              
            //print out the details
            jTextArea1.append("\nSource ip: "+srcIP+ "\n");
            jTextArea1.append("Destination ip: "+destIP+ "\n");
            jTextArea1.append("Source port: "+srcPort+ "\n");
            jTextArea1.append("Destination port: "+dstPort+ "\n");
            jTextArea1.append("Protocol: "+protocol+ "\n\n");
            jTextArea1.append("Data: ");
            byte[] data = (tcpPckt.data);
            
            String dataS = new String(data);
            //boolean test = CharMatcher.ASCII.matchesAllOf(dataS);
            if (cp0.isHttp(p))
                jTextArea1.append(dataS);
            
            else{
            for (int i = 0; i < data.length; i++)
            {
              jTextArea1.append((data[i] +" "));
            }
            }
            jTextArea1.append("\n");
        }
        
        else if (p instanceof UDPPacket){
            
            UDPPacket udpPckt =(UDPPacket)p ;
            
            String srcIP = String.valueOf(udpPckt.src_ip);
            String destIP = String.valueOf(udpPckt.dst_ip);
            String protocol = String.valueOf(udpPckt.protocol);
            int srcPort = udpPckt.src_port;
            int dstPort = udpPckt.dst_port;
            
            byte[] header = udpPckt.header;
            jTextArea1.append("Header: ");
            for (int k = 0; k < header.length; k++)
            {
              jTextArea1.append(String.valueOf(header[k] +" "));
            }
              
            jTextArea1.append("\nSource ip: "+srcIP+ "\n");
            jTextArea1.append("Destination ip: "+destIP+ "\n");
            jTextArea1.append("Source port: "+srcPort+ "\n");
            jTextArea1.append("Destination port: "+dstPort+ "\n");
            jTextArea1.append("Protocol: "+protocol+ "\n\n");
            
            byte[] data = (udpPckt.data);
            jTextArea1.append("Data: ");
            for (int i = 0; i < data.length; i++)
            {
              jTextArea1.append(String.valueOf(data[i] +" "));
            }
            
            jTextArea1.append("\n");
        }

        jTextArea1.setCaretPosition(0);
    }
    
    //New thread to carry out the capture process.
        class PacketCaptureWorker extends Thread {

            @Override
            public void run(){
                
                try {
                    
                    NetworkInterface [] devices = JpcapCaptor.getDeviceList();
                    
                    int index = (intefaceListCombo.getSelectedIndex()-1);                   //open network interfaces
                    int count = 0;
                    JpcapCaptor captor =JpcapCaptor.openDevice(devices[index], 65535, false, 20);
                    
                    //filters according to capture filters set.
                    if (tcpRadioButtonC.isSelected())
                    {   captor.setFilter("tcp and ipv4 and !port 80", true);
                    }
                    if (httpRadioButtonC.isSelected())
                    {   captor.setFilter("tcp and port 80", true);
                    }
                    if (udpRadioButtonC.isSelected())
                    {   captor.setFilter("udp", true);
                    }
                    if (icmpRadioButtonC.isSelected())
                    {   captor.setFilter("icmp", true);
                    }
                   // check flag , and capture packets
                    while (!cancelled){
                        Packet packets = captor.getPacket(); //captures packets
                        //System.out.println(packets);
                       if (packets != null)  //filters out null packets
                        {

                            count++;
                            updateGUI(packets,count); //updateGUI method is used to update the GUI on the Event Dispatcher Thread
                            Thread.sleep(50);         //pause between each capture. can be changed
                            obj.add(packets);  //add packets to obj ArrayList
                            
                        }
                        
                       
                    }

                }catch (InterruptedException ex) {
                Logger.getLogger(NewJFrame3.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                Logger.getLogger(NewJFrame3.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
    }
        
        //method to update the GUI
        private void updateGUI(final Packet packets,final int count){
                    
                    
                    SwingUtilities.invokeLater(new Runnable() { //THIS is used to update the GUI on the EDT
            @Override
            public void run() {
                
                cp0.populate_table(packets, m,count);            //populate the jtable, a row at a time
                packet_count = String.valueOf(count);
                totalCountLabel.setText(packet_count);              //update Jlabel showing number of packets captured
                udpCountLabel.setText(String.valueOf(cp0.udpCount));
                tcpCountLabel.setText(String.valueOf(cp0.tcpCount));
                httpCountLabel.setText(String.valueOf(cp0.httpCount));
                icmpCountLabel.setText(String.valueOf(cp0.icmpCount));
            }
     
            });
                
            }  
        
    public static void main(String args[]) {
        
        try {
                 UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                 
             }catch (ClassNotFoundException e){
             } catch (InstantiationException e) {
        } catch (IllegalAccessException e) {
        } catch (UnsupportedLookAndFeelException e) {
        }
            
        
        
        
        NewJFrame3 nf1 = new NewJFrame3();
        
        PromptSupport.setPrompt("Save as", nf1.saveTextField);
        
        NetworkInterface   [] devices = JpcapCaptor.getDeviceList();
 
            for (NetworkInterface device : devices) {
                (nf1.intefaceListCombo).addItem(device.name);
            }
        
        
        /*
         * Set the Nimbus look and feel
         */
      /*  //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
     /*   try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewJFrame3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }*/
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {
            

            @Override
            public void run() {

                new NewJFrame3().setVisible(true);
                
            }
        });
        
        
    }
    
    
    
    
     
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton captureButton;
    private javax.swing.JButton filterButton;
    private javax.swing.JLabel httpCountLabel;
    private javax.swing.JRadioButton httpRadioButtonC;
    private javax.swing.JLabel icmpCountLabel;
    private javax.swing.JRadioButton icmpRadioButtonC;
    private javax.swing.JComboBox intefaceListCombo;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JDialog jDialog3;
    private javax.swing.JDialog jDialog4;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JFrame jFrame2;
    private javax.swing.JFrame jFrame3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    public static javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JTable jTable1;
    public javax.swing.JTextArea jTextArea1;
    private javax.swing.JButton loadButton;
    private javax.swing.JButton saveButton;
    private javax.swing.JTextField saveTextField;
    private javax.swing.JButton stopButton;
    private javax.swing.JLabel tcpCountLabel;
    private javax.swing.JRadioButton tcpRadioButtonC;
    private final javax.swing.JLabel totalCountLabel = new javax.swing.JLabel();
    private javax.swing.JLabel udpCountLabel;
    private javax.swing.JRadioButton udpRadioButtonC;
    // End of variables declaration//GEN-END:variables
    private SwingWorker<ArrayList,Integer> worker;
}
