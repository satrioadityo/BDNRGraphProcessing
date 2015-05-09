/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import View.AddNodeView;
import View.Main;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ima
 */
public class Driver {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        try {
            Controller c = new Controller();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Driver.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
