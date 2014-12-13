/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpcap;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author DELL
 */
public class Jpcap {

    /**
     * @param args the command line arguments
     * @throws javax.swing.UnsupportedLookAndFeelException
     */
    public static void main(String[] args) throws UnsupportedLookAndFeelException {
        
          try { 
       // Set System L&F 
        UIManager.setLookAndFeel( 
            UIManager.getSystemLookAndFeelClassName()); 
    } 
    catch (ClassNotFoundException e) { 
       // handle exception 
    } 
    catch (InstantiationException e) { 
       // handle exception 
    } 
    catch (IllegalAccessException e) { 
       // handle exception 
    } 

     new NewJFrame().setVisible(true);
    }
}
