/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package komunikacija;


import java.io.IOException;

import java.net.ServerSocket;
import java.net.Socket;


/**
 *
 * @author ivana
 */
public class Komunikacija {
    private Socket socket;
    private boolean kraj = false;
    
    public void pokreniServer() throws IOException, ClassNotFoundException {
        ServerSocket ss = new ServerSocket(9000);
        System.out.println("Server je pokrenut i spreman za rad.");
        while (!kraj) {
            socket = ss.accept();
            System.out.println("Klijent se povezao.");
            NitKlijent nit = new NitKlijent(socket);
            nit.start();
        }
    }
    
    
    

    
    
    
}
