/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poslovnalogika.so.zivotinja;

import baza.DatabaseBroker;
import domen.OpstiDomenskiObjekat;
import domen.Zivotinja;
import java.util.List;
import poslovnalogika.so.OpstaSO;

/**
 *
 * @author Ivana
 */
public class PretraziZivotinjuSO extends OpstaSO{
private List<OpstiDomenskiObjekat> lista;
    @Override
    protected void proveriPreduslov(Object obj) throws RuntimeException {
        
    }

    @Override
    protected void izvrsiKonkretnuOperaciju(Object obj) throws RuntimeException {
        lista = DatabaseBroker.getInstance().pronadjiListu((Zivotinja) obj);
    }

    public List<OpstiDomenskiObjekat> getLista() {
        return lista;
    }

    public void setLista(List<OpstiDomenskiObjekat> lista) {
        this.lista = lista;
    }
    
}
