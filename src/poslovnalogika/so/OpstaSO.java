/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package poslovnalogika.so;

import baza.DatabaseBroker;

/**
 *
 * @author student1
 */
public abstract class OpstaSO {
    public final synchronized void izvrsiOperaciju(Object obj) throws RuntimeException {
        try {
            DatabaseBroker.getInstance().ucitajDriver();
            DatabaseBroker.getInstance().otvoriKonekciju();
            proveriPreduslov(obj);
            izvrsiKonkretnuOperaciju(obj);
            DatabaseBroker.getInstance().commitTransakcije();
        } catch (RuntimeException ex) {
            ex.printStackTrace();
            DatabaseBroker.getInstance().rollbackTransakcije();
            throw ex;
        } finally {
            DatabaseBroker.getInstance().zatvoriKonekciju();
        }
    }
    
    // Specificno za svaku SO

    protected  void proveriPreduslov(Object obj) throws RuntimeException{
        
    }

    protected abstract void izvrsiKonkretnuOperaciju(Object obj) throws RuntimeException;
}
