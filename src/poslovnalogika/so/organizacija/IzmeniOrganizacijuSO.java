
package poslovnalogika.so.organizacija;

import baza.DatabaseBroker;
import domen.Organizacija;
import poslovnalogika.so.OpstaSO;

/**
 *
 * @author Ivana
 */
public class IzmeniOrganizacijuSO extends OpstaSO {

    @Override
    protected void proveriPreduslov(Object obj) throws RuntimeException {
        
    }

    @Override
    protected void izvrsiKonkretnuOperaciju(Object obj) throws RuntimeException {
        DatabaseBroker.getInstance().sacuvajIzmene((Organizacija)obj);
    }
    
}
