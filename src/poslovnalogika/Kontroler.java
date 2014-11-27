/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poslovnalogika;

import baza.DatabaseBroker;
import domen.Clan;
import domen.Grad;
import domen.Ljubimac;

import domen.OpstiDomenskiObjekat;
import domen.Organizacija;
import domen.Zivotinja;
import java.util.List;
import poslovnalogika.so.clan.IzmeniClanaSO;
import poslovnalogika.so.clan.ObrisiClanaSO;

import poslovnalogika.so.clan.PretraziClanoveSO;
import poslovnalogika.so.clan.SacuvajClanaSO;
import poslovnalogika.so.clan.VratiSveClanoveSO;
import poslovnalogika.so.clan.VratiSveLjubimceSO;
import poslovnalogika.so.organizacija.IzmeniOrganizacijuSO;
import poslovnalogika.so.organizacija.ObrisiOrganizacijuSO;
import poslovnalogika.so.organizacija.PretraziOrganizacijeSO;
import poslovnalogika.so.organizacija.SacuvajOrganizacijuSO;
import poslovnalogika.so.organizacija.VratiIDOrganizacije;
import poslovnalogika.so.organizacija.VratiSveGradoveSO;
import poslovnalogika.so.organizacija.VratiSveOrganizacijeSO;
import poslovnalogika.so.zivotinja.DodajLjubimcaSO;
import poslovnalogika.so.zivotinja.IzmeniZivotinjuSO;
import poslovnalogika.so.zivotinja.ObrisiZivotinjuSO;
import poslovnalogika.so.zivotinja.PretraziZivotinjuSO;
import poslovnalogika.so.zivotinja.SacuvajZivotinjuSO;
import poslovnalogika.so.zivotinja.VratiIDZivotinjeSO;
import poslovnalogika.so.zivotinja.VratiSveZivotinjeSO;

/**
 *
 * @author Ivana
 */
public class Kontroler {

    private DatabaseBroker db;
    private static Kontroler kontroler;

    private Kontroler() {

        db = DatabaseBroker.getInstance();
    }

    public static Kontroler vratiObjekat() {
        if (kontroler == null) {
            kontroler = new Kontroler();
        }
        return kontroler;
    }

    public List<OpstiDomenskiObjekat> vratiSveOrganizacije() {
        VratiSveOrganizacijeSO vso = new VratiSveOrganizacijeSO();
        vso.izvrsiOperaciju(new Organizacija());
        return vso.getLista();

    }

    public List<OpstiDomenskiObjekat> vratiSveGradove() {
        VratiSveGradoveSO vso = new VratiSveGradoveSO();
        vso.izvrsiOperaciju(new Grad());
        return vso.getLista();

    }

    public List<OpstiDomenskiObjekat> pretraziOrganizacije(String uslov) {
        PretraziOrganizacijeSO poso = new PretraziOrganizacijeSO();
        poso.izvrsiOperaciju(new Organizacija(uslov, uslov));
        return poso.getLista();
    }

    public int vratiIDOrganizacije() {
        VratiIDOrganizacije vido = new VratiIDOrganizacije();
        vido.izvrsiOperaciju(new Organizacija());
        return vido.getId();
    }

    public void sacuvajOrganizaciju(Organizacija o) {
        SacuvajOrganizacijuSO so = new SacuvajOrganizacijuSO();
        so.izvrsiOperaciju(o);
    }

    public void izmeniOrganizaciju(Organizacija org) {
        IzmeniOrganizacijuSO ioso = new IzmeniOrganizacijuSO();
        ioso.izvrsiOperaciju(org);
    }

    public void obrisiOrganizaciju(Organizacija organizacija) {
        ObrisiOrganizacijuSO ooso = new ObrisiOrganizacijuSO();
        ooso.izvrsiOperaciju(organizacija);
    }

    public int vratiIDZivotinje() {
        VratiIDZivotinjeSO vidz = new VratiIDZivotinjeSO();
        vidz.izvrsiOperaciju(new Zivotinja());
        return vidz.getId();
    }

    public void sacuvajZivotinju(Zivotinja z) {
        SacuvajZivotinjuSO so = new SacuvajZivotinjuSO();
        so.izvrsiOperaciju(z);
    }
    
     public List<OpstiDomenskiObjekat> pretraziZivotinje(String uslov) {
         PretraziZivotinjuSO pzso = new PretraziZivotinjuSO();
        pzso.izvrsiOperaciju(new Zivotinja(uslov));
        return pzso.getLista();
    }

     public void obrisiZivotinju(Zivotinja zivotinja) {
         ObrisiZivotinjuSO ozso = new ObrisiZivotinjuSO();
        ozso.izvrsiOperaciju(zivotinja);
    }
     
    public List<OpstiDomenskiObjekat> vratiSveZivotinje() {
        VratiSveZivotinjeSO vszso = new VratiSveZivotinjeSO();
        vszso.izvrsiOperaciju(new Zivotinja());
        return vszso.getLista();
    }
    
    public void izmeniZivotinju(Zivotinja zzz) {
        IzmeniZivotinjuSO iosz = new IzmeniZivotinjuSO();
        iosz.izvrsiOperaciju(zzz);
    }

    public void sacuvajClana(Clan c) {
        SacuvajClanaSO sacuvajClanaSO = new SacuvajClanaSO();
        sacuvajClanaSO.izvrsiOperaciju(c);
    }

    public List<OpstiDomenskiObjekat> vratiSveClanove() {
        VratiSveClanoveSO sveClanoveSO = new VratiSveClanoveSO();
        sveClanoveSO.izvrsiOperaciju(new Clan());
        return sveClanoveSO.getLista();
    }

    public List<OpstiDomenskiObjekat> vratiSveLjubimce(String jmbg) {
        VratiSveLjubimceSO vslj = new VratiSveLjubimceSO();
        vslj.izvrsiOperaciju(new Ljubimac(jmbg));
        return vslj.getLista();
    }

    public List<OpstiDomenskiObjekat> pretraziClanove(String uslov) {
        PretraziClanoveSO pcso = new PretraziClanoveSO();
        pcso.izvrsiOperaciju(new Clan(uslov));
        return pcso.getLista();
    }

    public void obrisiClana(Clan clanZaBrisanje) {
        ObrisiClanaSO obrisiClanaSO = new ObrisiClanaSO();
        obrisiClanaSO.izvrsiOperaciju(clanZaBrisanje);
    }

    public void sacuvajLjubimca(Ljubimac lj) {
        DodajLjubimcaSO dlso = new DodajLjubimcaSO();
        dlso.izvrsiOperaciju(lj);
    }

    public void izmeniClana(Clan clanZaIzmenu) {
        IzmeniClanaSO clanaSO = new IzmeniClanaSO();
        clanaSO.izvrsiOperaciju(clanZaIzmenu);
    }

}
