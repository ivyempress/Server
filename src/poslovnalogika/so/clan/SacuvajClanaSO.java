
package poslovnalogika.so.clan;

import baza.DatabaseBroker;
import domen.Clan;
import domen.Ljubimac;
import poslovnalogika.so.OpstaSO;

/**
 *
 * @author Ivana
 */
public class SacuvajClanaSO extends OpstaSO {

    @Override
    protected void proveriPreduslov(Object obj) throws RuntimeException {
    }

    @Override
    protected void izvrsiKonkretnuOperaciju(Object obj) throws RuntimeException {
        Clan c = (Clan)obj;
        DatabaseBroker.getInstance().sacuvaj(c);
        for (Ljubimac ljubimac : c.getListaLjubimaca()) {
            DatabaseBroker.getInstance().sacuvaj(ljubimac);
        }
    }
    
}
