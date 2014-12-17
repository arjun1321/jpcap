package jpcap;

import java.net.InetAddress;
import java.util.ArrayList;
import javax.swing.JTextArea;
import javax.swing.SwingWorker;
import javax.swing.table.DefaultTableModel;
import jpcap.packet.Packet;
import jpcap.packet.*;


public class CapturePackets {
    
    ArrayList temp = new ArrayList();
    int tcpCount = 0;
    int udpCount = 0;
    int httpCount = 0;
    int icmpCount = 0;
    public static volatile boolean loop_stop = false;
    private SwingWorker<ArrayList,Integer> worker;
    

    //split packets according to type, then populate the table
    public void populate_table(Packet p,DefaultTableModel m,int packet_count)
    {

           Packet packets = p;
     
                    if (isHttp(packets)){ //check if tcp

                        TCPPacket tcpPckt =(TCPPacket)packets ;  
                        
                            httpCount++;
                            String col0 = "HTTP";
                            InetAddress col1 = tcpPckt.src_ip;
                            InetAddress col2 = tcpPckt.dst_ip;
                            int col3 = tcpPckt.src_port;
                            int col4 = tcpPckt.dst_port;
                            int col5 = tcpPckt.len;
                            Object[] rowHttp = {packet_count,col0,col1,col2,col3,col4,col5};
                            m.addRow(rowHttp);
                        
                    }   
                    else if (isTcp(packets)) {
                        
                        tcpCount++;
                        TCPPacket tcpPckt =(TCPPacket)packets ;  
                        String col0 = "TCP";
                        
                        InetAddress col1 = tcpPckt.src_ip;
                        InetAddress col2 = tcpPckt.dst_ip;
                        int col3 = tcpPckt.src_port;
                        int col4 = tcpPckt.dst_port;
                        int col5 = tcpPckt.len;
                        byte priority = tcpPckt.priority;
                        int protocol = tcpPckt.protocol;
                        DatalinkPacket dlp = tcpPckt.datalink;
                        int offset = tcpPckt.offset;
                        byte[] header = tcpPckt.header;
                        byte[] data = tcpPckt.data;
                        byte[] option = tcpPckt.option;
                        
                        Object[] rowTCP = {packet_count,col0,col1,col2,col3,col4,col5};
                        m.addRow(rowTCP);  //writes to the table
                    }    
                    
                    else if (isUdp(packets)){
                        
                        udpCount++;
                        UDPPacket udpPckt =(UDPPacket)packets ;
                        String col0 = "UDP";
                        
                        InetAddress col1 = udpPckt.src_ip;
                        InetAddress col2 = udpPckt.dst_ip;
                        int col3 = udpPckt.src_port;
                        int col4 = udpPckt.dst_port;
                        int col5 = udpPckt.len;
                        
                        Object[] row = {packet_count,col0,col1,col2,col3,col4,col5};
                        m.addRow(row);
                            
                    }
                    
                    else if (isIcmp(packets)){
                        icmpCount++;
                        ICMPPacket icmpPckt =(ICMPPacket)packets ;
                        
                        String col0 = "ICMP";
                        InetAddress col1 = icmpPckt.src_ip;
                        InetAddress col2 = icmpPckt.dst_ip;
                        IPPacket ipICMP = icmpPckt.ippacket;
                        int col5 = icmpPckt.len;
                        
                        Object[] row = {packet_count,col0,col1,col2,"","",col5};
                        m.addRow(row);
                        
                    }
                    else
                    {
                        int col5 = packets.len;
                        Object[] row = {packet_count,"","","","","",col5};
                        m.addRow(row);
                    }
                }
    
    
    //method to populate the text box with details of a selected packet
    
    public void populate_text(Packet p, int N, JTextArea jTextArea1) {

        jTextArea1.setText(null);//clear text area before populating
        
        if (p instanceof TCPPacket){


            TCPPacket tcpPckt =(TCPPacket)p ;
            
            //assign packet details to variables
            String srcIP = String.valueOf(tcpPckt.src_ip);
            String destIP = String.valueOf(tcpPckt.dst_ip);
            String protocol = String.valueOf(tcpPckt.protocol);
            int srcPort = tcpPckt.src_port;
            int dstPort = tcpPckt.dst_port;
            int version = tcpPckt.version;
            boolean syn = tcpPckt.syn;
            boolean ack = tcpPckt.ack;
            boolean fin = tcpPckt.fin;
            long seqNo =tcpPckt.sequence;
            long ackNo = tcpPckt.ack_num;
            
            byte[] header = tcpPckt.header;
            byte[] data = (tcpPckt.data);

   
            //print out the details
            jTextArea1.append("Packet #"+ N +" ("+ tcpPckt.len + " bytes)"+"\n\n");
            jTextArea1.append("Header length: "+ header.length +" bytes\n");
            jTextArea1.append("Source ip: "+srcIP+ "\n");
            jTextArea1.append("Destination ip: "+destIP+ "\n");
            jTextArea1.append("Source port: "+srcPort+ "\n");
            jTextArea1.append("Destination port: "+dstPort+ "\n");
            jTextArea1.append("Protocol: "+protocol+ "\n");
            jTextArea1.append("Flags: SYN = "+ syn + " ACK = " +ack+ " FIN = "+fin+"\n");
            jTextArea1.append("Sequence number = " + seqNo + "\n");
            jTextArea1.append("Acknowledgement number = " + ackNo + "\n");
            jTextArea1.append("Version: "+version+"\n" );
            jTextArea1.append("Data" + "("+ data.length + " bytes)" + ": ");
            
            
            String dataS = new String(data);
            //boolean test = CharMatcher.ASCII.matchesAllOf(dataS);
            if (isHttp(p))
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
            int version = udpPckt.version;
            
            byte[] header = udpPckt.header;
            byte[] data = (udpPckt.data);
            
            jTextArea1.append("Packet #"+ N +" ("+ udpPckt.len + " bytes)"+"\n\n");
            jTextArea1.append("Header length: " + header.length+" bytes\n");
            jTextArea1.append("Source ip: "+srcIP+ "\n");
            jTextArea1.append("Destination ip: "+destIP+ "\n");
            jTextArea1.append("Source port: "+srcPort+ "\n");
            jTextArea1.append("Destination port: "+dstPort+ "\n");
            jTextArea1.append("Protocol: "+protocol+ "\n");
            jTextArea1.append("Version: "+version+ "\n");
            
            jTextArea1.append("Data" + "("+ data.length + " bytes)" + ": ");
            for (int i = 0; i < data.length; i++)
            {
              jTextArea1.append(String.valueOf(data[i] +" "));
            }
            
            jTextArea1.append("\n");
        }
        else if (p instanceof ICMPPacket){
            
            ICMPPacket icmpPckt =(ICMPPacket)p ;
            
            String srcIP = String.valueOf(icmpPckt.src_ip);
            String destIP = String.valueOf(icmpPckt.dst_ip);
            String protocol = String.valueOf(icmpPckt.protocol);
            int sequence = icmpPckt.seq;
            byte[] header = icmpPckt.header;
            byte[] data = (icmpPckt.data);
            int aliveTime = icmpPckt.alive_time;
            int hopLimit = icmpPckt.hop_limit;
            String redirIp = String.valueOf(icmpPckt.redir_ip);
            InetAddress[] routerIP = icmpPckt.router_ip;
            int Subnetmask = icmpPckt.subnetmask;
            int version = icmpPckt.version;
            
            jTextArea1.append("Packet #"+ N + " ("+ icmpPckt.len + " bytes)" +  "\n\n"); 
            jTextArea1.append("Header length: "+header.length+ "\n");
            jTextArea1.append("Source ip: "+srcIP+ "\n");
            jTextArea1.append("Destination ip: "+destIP+ "\n");
            jTextArea1.append("Redirect ip: "+redirIp+ "\n");
            
            if (routerIP != null)
            {    for (int k = 0; k < routerIP.length; k++)
                {
                  jTextArea1.append(String.valueOf(routerIP[k] +" "));
                }
            }
            jTextArea1.append("Alive time: "+aliveTime+ "\n");
            jTextArea1.append("Hop limit: "+hopLimit+ "\n");
            jTextArea1.append("Subnetmask: "+Subnetmask+ "\n");
            jTextArea1.append("Sequence: "+sequence+ "\n");
            jTextArea1.append("Protocol: "+protocol+ "\n");
            jTextArea1.append("Version: "+version+ "\n");
            
            
            jTextArea1.append("Data(" +data.length + " bytes): ");
            for (int i = 0; i < data.length; i++)
            {
              jTextArea1.append(String.valueOf(data[i] +" "));
            }
            
            jTextArea1.append("\n");
        }

        jTextArea1.setCaretPosition(0);
    }
    
    
 //methods to check if a packet belongs to a particular type

    public boolean isHttp(Packet pck)
    {
        if( (pck instanceof TCPPacket) && ((((TCPPacket)pck).src_port == 80) || (((TCPPacket)pck).dst_port == 80)))
                {
                    TCPPacket pckt = (TCPPacket)pck;
                    String pcktData = new String(pckt.data);
                    int length = pcktData.length();
                    
                    if (!pcktData.equals("") && length > 2)
                    {
                        String firstletter = pcktData.substring(0,3);
                        if (firstletter.equals("GET") || firstletter.equals("HTT"))
                            return true;
                    }
                }
        return false;
    }
    
    public boolean isTcp(Packet pck)
    {
        return (pck instanceof TCPPacket) ;
                //&& ((((TCPPacket)pck).src_port != 80) && (((TCPPacket)pck).dst_port != 80));
    }
        
    public boolean isUdp(Packet pck)
    {
        return (pck instanceof UDPPacket);
    }
    
    public boolean isIcmp(Packet pck)
    {
        return pck instanceof ICMPPacket;
    }
        }


    
    

