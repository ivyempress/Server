
package poslovnalogika.so.organizacija;

import baza.DatabaseBroker;
import domen.Organizacija;
import poslovnalogika.so.OpstaSO;

/**
 *
 * @author Ivana
 */
public class VratiIDOrganizacije extends OpstaSO {
    private int id;
    @Override
    protected void proveriPreduslov(Object obj) throws RuntimeException {
        
    }

    @Override
    protected void izvrsiKonkretnuOperaciju(Object obj) throws RuntimeException {
        id = DatabaseBroker.getInstance().kreirajSifru((Organizacija)obj);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}
