/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package poslovnalogika;

import baza.DatabaseBroker;
import domen.Grad;

import domen.OpstiDomenskiObjekat;
import domen.Organizacija;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import poslovnalogika.so.organizacija.PretraziOrganizacijeSO;
import poslovnalogika.so.organizacija.SacuvajOrganizacijuSO;
import poslovnalogika.so.organizacija.VratiIDOrganizacije;
import poslovnalogika.so.organizacija.VratiSveGradoveSO;
import poslovnalogika.so.organizacija.VratiSveOrganizacijeSO;




/**
 *
 * @author student1
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
//
//    public int kreirajSifru() {
//        KreirajSifruUslugeSO ksu = new KreirajSifruUslugeSO();
//        ksu.izvrsiOperaciju(new Usluga());
//        return ksu.getSifra();
//        
//    }
//
//    public void sacuvajUslugu(Usluga u) {
//        ZapamtiUsluguSO zu = new ZapamtiUsluguSO();
//        zu.izvrsiOperaciju(u);
//    }
//
//    public List<OpstiDomenskiObjekat> vratiUsluge() {
//        VratiUslugeSO vu = new VratiUslugeSO();
//        vu.izvrsiOperaciju(new Usluga());
//        return vu.getLista();
//    }
//
//    public List<OpstiDomenskiObjekat> PronadjiUsluge(String naziv) {
//        PronadjiUslugeSO pu = new PronadjiUslugeSO();
//        pu.izvrsiOperaciju(new Usluga(naziv, naziv, 0, 0));
//        return pu.getLista();
//    }
//
//    public Usluga vratiUslugu(String sifraUsluge) {
//        VratiUsluguSO vu = new VratiUsluguSO();
//        vu.izvrsiOperaciju(new Usluga(sifraUsluge, sifraUsluge, 0, 0));
//        return vu.getU();
//    }
//
//    public void sacuvajIzmene(Usluga usl) {
//        SacuvajIzmeneUslugeSO si = new SacuvajIzmeneUslugeSO();
//        si.izvrsiOperaciju(usl);
//    }
//
//    public void obrisiUslugu(Usluga uslu) {
//        ObrisiUsluguSO ou = new ObrisiUsluguSO();
//        ou.izvrsiOperaciju(uslu);
//    }
//
//    public List<OpstiDomenskiObjekat> vratiMesta() {
//        VratiMestaSO vm = new VratiMestaSO();
//        vm.izvrsiOperaciju(new Mesto());
//        return vm.getLista();
//    }
//
//    public int kreirajSifruKorisnika() {
//        KreirajSifruKorisnikaSO ksk = new KreirajSifruKorisnikaSO();
//        ksk.izvrsiOperaciju(new Korisnik());
//        return ksk.getSifra();
//    }
//
//    public void zapamtiKorisnika(Korisnik k) {
//        ZapamtiKorisnikaSO zk = new ZapamtiKorisnikaSO();
//        zk.izvrsiOperaciju(k);
//    }
//
//    public List<OpstiDomenskiObjekat> PronadjiKorisnike(String ime) {
//        PronadjiKorisnikeSO pk = new PronadjiKorisnikeSO();
//        pk.izvrsiOperaciju(new Korisnik(ime, ime, ime, null));
//        return pk.getLista();
//    }
//
//    public Korisnik vratiKorisnika(String sifraKorisnika) {
//        VratiKorisnikaSO vk = new VratiKorisnikaSO();
//        vk.izvrsiOperaciju(new Korisnik(sifraKorisnika, sifraKorisnika, sifraKorisnika, null));
//        return vk.getK();
//    }
//
//    public void sacuvajIzmeneKorisnika(Korisnik kor) {
//        SacuvajIzmeneKorisnikaSO sik = new SacuvajIzmeneKorisnikaSO();
//        sik.izvrsiOperaciju(kor);
//    }
//
//    public void obrisiKorisnika(Korisnik kori) {
//        ObrisiKorisnikaSO ok = new ObrisiKorisnikaSO();
//        ok.izvrsiOperaciju(kori);
//    }
//
//    public List<OpstiDomenskiObjekat> vratiKorisnike() {
//        VratiKorisnikeSO vk = new VratiKorisnikeSO();
//        vk.izvrsiOperaciju(new Korisnik());
//        return vk.getLista();
//    }
//
//    public int kreirajSifruRacuna() {
//        KreirajSifruRacunaSO ksr = new KreirajSifruRacunaSO();
//        ksr.izvrsiOperaciju(new Racun());
//        return ksr.getSifra();
//    }
//
//    public void obradiRacun(Racun r) {
//        ObradiRacunSO or = new ObradiRacunSO();
//        or.izvrsiOperaciju(r);
//    }
//
//    public Racun pronadjiRacun(String sifraRacuna) {
//        PronadjiRacunSO pr = new PronadjiRacunSO();
//        pr.izvrsiOperaciju(new Racun(sifraRacuna, 0, true, null, null));
//        return pr.getR();
//    }
//
//    public void stornirajRacun(Racun rac) {
//        StornirajRacunSO sr = new StornirajRacunSO();
//        sr.izvrsiOperaciju(rac);
//    }
//
//    
    
    
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
        poso.izvrsiOperaciju(new Organizacija(uslov,uslov));
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

   
    
}
