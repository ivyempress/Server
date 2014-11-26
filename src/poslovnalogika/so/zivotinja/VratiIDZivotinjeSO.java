/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poslovnalogika.so.zivotinja;

import baza.DatabaseBroker;

import domen.Zivotinja;
import poslovnalogika.so.OpstaSO;

/**
 *
 * @author Ivana
 */
public class VratiIDZivotinjeSO extends OpstaSO{
private int id;
    @Override
    protected void proveriPreduslov(Object obj) throws RuntimeException {
    }

    @Override
    protected void izvrsiKonkretnuOperaciju(Object obj) throws RuntimeException {
       id = DatabaseBroker.getInstance().kreirajSifru((Zivotinja)obj);  }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}
