/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package komunikacija;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Ivana
 */
public class ServerskaNit extends Thread{
    private Komunikacija server;

    @Override
    public void run() {
        server = new Komunikacija();
        try {
            server.pokreniServer();
        } catch (IOException ex) {
            Logger.getLogger(ServerskaNit.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServerskaNit.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
