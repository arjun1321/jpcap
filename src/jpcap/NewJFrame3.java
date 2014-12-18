
package jpcap;

import java.awt.Font;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.util.logging.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.*;
import jpcap.packet.Packet;



public class NewJFrame3 extends javax.swing.JFrame {  
        
    ArrayList obj = new ArrayList();  //declartion of the ArrayList to store packets.
    DefaultTableModel m;
    UpdateGUI guiObject = new UpdateGUI(); //create new instance of the CapturePackets class
    volatile boolean cancelled = false;     //the flag to stop the while loop that executes the capture of packets
    String packet_count = "0";           //the value is used in the label to show the total number of packets captured
    int pck_count;

    public NewJFrame3() {   

        initComponents();
        m = (DefaultTableModel) jTable1.getModel();
        
        resizeColumns();
        
        addComponentListener(new ComponentAdapter() {
            
        @Override
            public void componentResized(ComponentEvent e) {
                resizeColumns();
            }
        });
        
        
        
        jTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
        @Override
            public void valueChanged(ListSelectionEvent e) { //action listner for the table to display captured packet details
                
                int sel = (jTable1.getSelectedRow()); //sel variable stores the index of the selected row

                if ((! e.getValueIsAdjusting()) && (sel != -1)) 
                {
                    int Pckno = (Integer)( jTable1.getModel().getValueAt(sel,0));
                    Packet p = (Packet) obj.get(Pckno-1);  //the packet corresponding to the row index is selected

                    guiObject.populate_text(p,Pckno,jTextArea1);                   //populate_text method is called to display the details of the selected packet
                }
            }
        });


        
        NetworkInterface   [] devices = JpcapCaptor.getDeviceList();
 
        for (NetworkInterface device : devices){ //initialize network device list for combobox
            interfaceListCombo.addItem(device.description + " " + device.name);    //add the interface list to the drop down menu
        }  
    }
    
    float[] columnWidthPercentage = {10.0f, 10.0f, 25.0f, 25.0f, 10.0f, 10.0f, 10.0f};

    private void resizeColumns() {
        
        int tW = jTable1.getWidth();
        TableColumn column;
        TableColumnModel jTableColumnModel = jTable1.getColumnModel();
        int cantCols = jTableColumnModel.getColumnCount();
        
        for (int i = 0; i < cantCols; i++) {
            
            column = jTableColumnModel.getColumn(i);
            int pWidth = Math.round(columnWidthPercentage[i] * tW);
            column.setPreferredWidth(pWidth);
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
        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        saveButton = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        captureButton = new javax.swing.JButton();
        interfaceListCombo = new javax.swing.JComboBox();
        stopButton = new javax.swing.JButton();
        loadButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
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
        icmpRadioButtonC = new javax.swing.JRadioButton();
        tcpRadioButtonC = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        intervalTextField = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        resetFilterButton = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jpcap/images/light_fawn_and_blue_waves-1280x800.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");

        jFrame1.getContentPane().setLayout(new java.awt.BorderLayout());

        jFrame2.getContentPane().setLayout(new java.awt.BorderLayout());

        jFrame3.getContentPane().setLayout(new java.awt.BorderLayout());

        jDialog1.getContentPane().setLayout(new java.awt.BorderLayout());

        jDialog2.getContentPane().setLayout(new java.awt.BorderLayout());

        jDialog3.getContentPane().setLayout(new java.awt.BorderLayout());

        jDialog4.getContentPane().setLayout(new java.awt.BorderLayout());

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
        getContentPane().add(saveButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 420, -1, 20));

        jLabel6.setForeground(new java.awt.Color(204, 204, 255));
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, 20, 20));

        captureButton.setText("START CAPTURE");
        captureButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                captureButtonActionPerformed(evt);
            }
        });
        getContentPane().add(captureButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 390, 120, 30));

        interfaceListCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select interface" }));
        interfaceListCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                interfaceListComboActionPerformed(evt);
            }
        });
        getContentPane().add(interfaceListCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 210, -1));

        stopButton.setText("STOP CAPTURE");
        stopButton.setEnabled(false);
        stopButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopButtonActionPerformed(evt);
            }
        });
        getContentPane().add(stopButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 390, 120, 30));

        loadButton.setText("Load previous session");
        loadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadButtonActionPerformed(evt);
            }
        });
        getContentPane().add(loadButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 10, 140, -1));

        jLabel4.setText("Save session");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 420, 80, 20));

        totalCountLabel.setText(packet_count);
        getContentPane().add(totalCountLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 390, 40, -1));

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
        filterButton.setEnabled(false);
        filterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterButtonActionPerformed(evt);
            }
        });
        getContentPane().add(filterButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 320, 120, -1));

        jLabel1.setText("Capture Filter");
        Font f = jLabel1.getFont();
        // bold
        jLabel1.setFont(f.deriveFont(f.getStyle() | Font.BOLD));
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

        buttonGroup1.add(udpRadioButtonC);
        udpRadioButtonC.setText("UDP");
        udpRadioButtonC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                udpRadioButtonCActionPerformed(evt);
            }
        });
        getContentPane().add(udpRadioButtonC, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 110, -1, 20));

        buttonGroup1.add(icmpRadioButtonC);
        icmpRadioButtonC.setText("ICMP");
        icmpRadioButtonC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                icmpRadioButtonCActionPerformed(evt);
            }
        });
        getContentPane().add(icmpRadioButtonC, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 130, -1, 20));

        buttonGroup1.add(tcpRadioButtonC);
        tcpRadioButtonC.setText("TCP/HTTP");
        tcpRadioButtonC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tcpRadioButtonCActionPerformed(evt);
            }
        });
        getContentPane().add(tcpRadioButtonC, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 90, 80, 20));

        jLabel5.setText("capture interval:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 190, -1, 20));

        intervalTextField.setText("0");
        intervalTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                intervalTextFieldActionPerformed(evt);
            }
        });
        getContentPane().add(intervalTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 220, 40, 20));

        jLabel10.setText("ms");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 220, 20, 20));

        resetFilterButton.setText("CLEAR FILTERS");
        resetFilterButton.setEnabled(false);
        resetFilterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetFilterButtonActionPerformed(evt);
            }
        });
        getContentPane().add(resetFilterButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 350, 120, -1));

        jLabel11.setText("Session Filter");
        Font f1 = jLabel11.getFont();
        // bold
        jLabel11.setFont(f1.deriveFont(f1.getStyle() | Font.BOLD));
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 290, -1, -1));

        jButton1.setText("reset");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 160, 60, 20));

        jLabel13.setText("");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 470, 150, -1));

        setSize(new java.awt.Dimension(761, 750));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

 
    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
                                                    
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Specify a file to save");   
            
            FileNameExtensionFilter ft = new FileNameExtensionFilter( "Text Files", "txt" );
            fileChooser.addChoosableFileFilter( ft );
            
            int userSelection = fileChooser.showSaveDialog(this);
            
            
 
            if (userSelection == JFileChooser.APPROVE_OPTION) {
                

            //object is written to the drive
            try {
                
                File fileToSave = fileChooser.getSelectedFile();
                
                FileWriter writer = new FileWriter("output.txt"); 
                BufferedWriter bw = new BufferedWriter(writer);
                for(int i = 0; i < obj.size(); i++) {
                bw.write(String.valueOf(obj.get(i)));
                bw.newLine();
                }
                bw.close();
                writer.close();
                
                FileOutputStream fos = new FileOutputStream(fileToSave + ".txt"); 
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(obj);
                oos.close();
                fos.close();
                JOptionPane.showMessageDialog(null,"Your session has been saved successfully.");
            }
            catch (IOException ex) {
                Logger.getLogger(NewJFrame3.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
    }//GEN-LAST:event_saveButtonActionPerformed

    
    private void captureButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_captureButtonActionPerformed

            int c = interfaceListCombo.getSelectedIndex();

            if (c == 0)
            {
                     JOptionPane.showMessageDialog(null,"Please select an interface");
            }
            else{
            filterButton.setEnabled(false);
            tcpRadioButtonC.setEnabled(false);
            udpRadioButtonC.setEnabled(false);
            icmpRadioButtonC.setEnabled(false);
            intervalTextField.setEnabled(false);
            captureButton.setEnabled(false); //once a capture is started the button is disabled
            stopButton.setEnabled(true);       //the stop buttn is enabled
            //variables from the CapturePackets to monitor the number of packets captured. all initialized to 0.
            resetCount();
            jTextArea1.setText(null);//clear text area before populating
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
            } 
    }//GEN-LAST:event_captureButtonActionPerformed

    private void interfaceListComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_interfaceListComboActionPerformed
  
        
    }//GEN-LAST:event_interfaceListComboActionPerformed

    private void stopButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopButtonActionPerformed

        captureButton.setEnabled(true);
        cancelled = true;
        stopButton.setEnabled(false);
        filterButton.setEnabled(true);
        tcpRadioButtonC.setEnabled(true);
        udpRadioButtonC.setEnabled(true);
        icmpRadioButtonC.setEnabled(true);
        intervalTextField.setEnabled(true);
        int sum = 0;
        for (int i = 0; i < jTable1.getRowCount();i++)
        {
  
            sum = sum + (Integer)jTable1.getModel().getValueAt(i,6);
        }
        jLabel13.setText("total bytes: "+String.valueOf(sum));
        
    }//GEN-LAST:event_stopButtonActionPerformed


    private void loadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadButtonActionPerformed

        JFileChooser jfc = new JFileChooser();
        FileNameExtensionFilter ft = new FileNameExtensionFilter( "Text Files", "txt" );
        jfc.addChoosableFileFilter( ft );
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
                
                resetCount();
                pck_count = 0;
                
                for (Object obj1 : obj) {
                    pck_count++;
                    guiObject.populate_table((Packet) obj1, m,pck_count); //populate_table method is used to display captured packets
                }

             updateCount(guiObject.httpCount,guiObject.tcpCount,guiObject.udpCount,guiObject.icmpCount);
             filterButton.setEnabled(true);
             
             int sum = 0;
                for (int i = 0; i < m.getRowCount();i++)
                {
                    sum = sum + (Integer)(m.getValueAt(i, 6));
                }
                jLabel13.setText("total bytes: "+String.valueOf(sum));
                
            } catch (FileNotFoundException ex) {
                Logger.getLogger(NewJFrame3.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(NewJFrame3.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(NewJFrame3.class.getName()).log(Level.SEVERE, null, ex);
            }

     }

    }//GEN-LAST:event_loadButtonActionPerformed

    public void updateCount (int h,int t,int u,int i)
    {
        totalCountLabel.setText(String.valueOf(h+t+u+i));  //update Jlabel showing number of packets captured
        udpCountLabel.setText(String.valueOf(u));
        tcpCountLabel.setText(String.valueOf(t));
        httpCountLabel.setText(String.valueOf(h));
        icmpCountLabel.setText(String.valueOf(i));
    
    }
    
    public void resetCount()
    {
        guiObject.tcpCount = 0;
        guiObject.udpCount = 0;
        guiObject.httpCount = 0;
        guiObject.icmpCount = 0;

    }
    
    
    private void filterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterButtonActionPerformed

       sessionFilter sf = new sessionFilter(obj,m,httpCountLabel,tcpCountLabel,udpCountLabel,icmpCountLabel,totalCountLabel,jLabel13); //new instance of sessionFilter frame, This provides access to session filter options
       sf.setVisible(true);
       resetFilterButton.setEnabled(true);
    }//GEN-LAST:event_filterButtonActionPerformed

    private void udpRadioButtonCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_udpRadioButtonCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_udpRadioButtonCActionPerformed

    private void icmpRadioButtonCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_icmpRadioButtonCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_icmpRadioButtonCActionPerformed

    private void tcpRadioButtonCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tcpRadioButtonCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tcpRadioButtonCActionPerformed

    private void formComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentHidden
        // TODO add your handling code here:
    }//GEN-LAST:event_formComponentHidden

    private void intervalTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_intervalTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_intervalTextFieldActionPerformed

    private void resetFilterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetFilterButtonActionPerformed

        ArrayList resObj = obj;
        
        while (m.getRowCount() > 0){
                for (int i = 0; i < m.getRowCount(); i++){
                    m.removeRow(i);
                }
            }  //remove all rows (if any) before populating table
        resetCount();
        
        for (int r = 0; r < obj.size(); r++)
        {
            Packet pr = (Packet)resObj.get(r);
            guiObject.populate_table(pr,m,r);
        }
        
        updateCount(guiObject.httpCount,guiObject.tcpCount,guiObject.udpCount,guiObject.icmpCount);
        
        int sum = 0;
        
        for (int i = 0; i < m.getRowCount();i++)
        {
            sum = sum + (Integer)(m.getValueAt(i, 6));
        }

        jLabel13.setText("total bytes: " + String.valueOf(sum));
    }//GEN-LAST:event_resetFilterButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        buttonGroup1.clearSelection();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed


    

    //New thread to carry out the capture process.
        class PacketCaptureWorker extends Thread {

            @Override
            public void run(){
                
                try {
                    
                    NetworkInterface [] devices = JpcapCaptor.getDeviceList();
                    
                    int index = (interfaceListCombo.getSelectedIndex()-1);                   //open network interfaces
                    int count = 0;
                    JpcapCaptor captor =JpcapCaptor.openDevice(devices[index], 65535, false, 20);
                    
                    //filters according to capture filters set.
                    if (tcpRadioButtonC.isSelected())
                    {   captor.setFilter("tcp", true);
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
                            Thread.sleep(Integer.parseInt(intervalTextField.getText()));         //pause between each capture. can be changed
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
                
                guiObject.populate_table(packets, m,count);            //populate the jtable, a row at a time
                packet_count = String.valueOf(count);
                updateCount(guiObject.httpCount,guiObject.tcpCount,guiObject.udpCount,guiObject.icmpCount);              //update Jlabel showing number of packets captured
                
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
           
        NetworkInterface   [] devices = JpcapCaptor.getDeviceList();
 
            for (NetworkInterface device : devices) {
                (nf1.interfaceListCombo).addItem(device.name);
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
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton captureButton;
    private javax.swing.JButton filterButton;
    public javax.swing.JLabel httpCountLabel;
    public javax.swing.JLabel icmpCountLabel;
    private javax.swing.JRadioButton icmpRadioButtonC;
    private javax.swing.JComboBox interfaceListCombo;
    private javax.swing.JTextField intervalTextField;
    private javax.swing.JButton jButton1;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JDialog jDialog3;
    private javax.swing.JDialog jDialog4;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JFrame jFrame2;
    private javax.swing.JFrame jFrame3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    public static javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JTable jTable1;
    public javax.swing.JTextArea jTextArea1;
    private javax.swing.JButton loadButton;
    private javax.swing.JButton resetFilterButton;
    private javax.swing.JButton saveButton;
    private javax.swing.JButton stopButton;
    public javax.swing.JLabel tcpCountLabel;
    private javax.swing.JRadioButton tcpRadioButtonC;
    public final javax.swing.JLabel totalCountLabel = new javax.swing.JLabel();
    public javax.swing.JLabel udpCountLabel;
    private javax.swing.JRadioButton udpRadioButtonC;
    // End of variables declaration//GEN-END:variables
    private SwingWorker<ArrayList,Integer> worker;
}
