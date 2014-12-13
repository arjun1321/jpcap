package jpcap;

import java.net.InetAddress;
import java.util.ArrayList;
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
        return (pck instanceof TCPPacket);
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


    
    

