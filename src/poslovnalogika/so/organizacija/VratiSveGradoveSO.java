/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poslovnalogika.so.organizacija;

import baza.DatabaseBroker;
import domen.Grad;
import domen.OpstiDomenskiObjekat;
import domen.Organizacija;
import java.util.List;
import poslovnalogika.so.OpstaSO;

/**
 *
 * @author Ivana
 */
public class VratiSveGradoveSO extends OpstaSO{

    private List<OpstiDomenskiObjekat> lista;
    
    @Override
    protected void proveriPreduslov(Object obj) throws RuntimeException {
    }

    @Override
    protected void izvrsiKonkretnuOperaciju(Object obj) throws RuntimeException {
        Grad grad = (Grad) obj;
        lista = DatabaseBroker.getInstance().vratiListu(grad);
    }

    public List<OpstiDomenskiObjekat> getLista() {
        return lista;
    }

    public void setLista(List<OpstiDomenskiObjekat> lista) {
        this.lista = lista;
    }
    
}
