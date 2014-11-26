/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poslovnalogika.so.clan;

import baza.DatabaseBroker;
import domen.Clan;
import domen.OpstiDomenskiObjekat;
import java.util.List;
import poslovnalogika.so.OpstaSO;

/**
 *
 * @author Ivana
 */
public class PretraziClanoveSO extends OpstaSO {

    private List<OpstiDomenskiObjekat> lista;

    @Override
    protected void proveriPreduslov(Object obj) throws RuntimeException {
    }

    @Override
    protected void izvrsiKonkretnuOperaciju(Object obj) throws RuntimeException {
        lista = DatabaseBroker.getInstance().pronadjiListu((Clan) obj);

        for (OpstiDomenskiObjekat clan : lista) {
            DatabaseBroker.getInstance().vratiListu(clan);
        }
    }

    public List<OpstiDomenskiObjekat> getLista() {
        return lista;
    }

    public void setLista(List<OpstiDomenskiObjekat> lista) {
        this.lista = lista;
    }

}
