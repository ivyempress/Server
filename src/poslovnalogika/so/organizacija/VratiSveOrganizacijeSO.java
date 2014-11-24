/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poslovnalogika.so.organizacija;

import baza.DatabaseBroker;
import domen.OpstiDomenskiObjekat;
import domen.Organizacija;
import java.util.List;
import poslovnalogika.so.OpstaSO;

/**
 *
 * @author Bata
 */
public class VratiSveOrganizacijeSO extends OpstaSO{

    private List<OpstiDomenskiObjekat> lista;
    
    @Override
    protected void izvrsiKonkretnuOperaciju(Object obj) throws RuntimeException {
        Organizacija org = (Organizacija) obj;
        lista = DatabaseBroker.getInstance().vratiListu(org);

    }

    @Override
    protected void proveriPreduslov(Object obj) throws RuntimeException {
        
    }

    public List<OpstiDomenskiObjekat> getLista() {
        return lista;
    }

    public void setLista(List<OpstiDomenskiObjekat> lista) {
        this.lista = lista;
    }
    
}
