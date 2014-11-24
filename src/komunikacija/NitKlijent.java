/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package komunikacija;


import domen.OpstiDomenskiObjekat;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;
import poslovnalogika.Kontroler;
import transfer.TransferObjekatOdgovor;
import transfer.TransferObjekatZahtev;
import util.Konstante;


/**
 *
 * @author student1
 */
public class NitKlijent extends Thread {

    private Socket socket;
    private boolean kraj;

    public NitKlijent(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
           izvrsenjeOperacija();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println("Nit je zavrsila sa radom!");
    }

    public void izvrsenjeOperacija() throws IOException, ClassNotFoundException {
        while (!kraj) {
            ObjectInputStream inSocket = new ObjectInputStream(socket.getInputStream());
            TransferObjekatZahtev toZahtev = (TransferObjekatZahtev) inSocket.readObject();
            TransferObjekatOdgovor toOdogovor = new TransferObjekatOdgovor();
            try {
                switch (toZahtev.getOperacija()) {
                    case   Konstante.VRATI_SVE_ORGANIZACIJE:
                        System.out.println("O:" + Konstante.VRATI_SVE_ORGANIZACIJE);
                        List<OpstiDomenskiObjekat> lo = Kontroler.vratiObjekat().vratiSveOrganizacije();
                        toOdogovor.setRezultat(lo);
                        
                        if (lo.size()== 0) toOdogovor.setOdgovor(Konstante.ERROR_LISTA_ORGANIZACIJA);
                        else toOdogovor.setOdgovor(Konstante.OK_LISTA_ORGANIZACIJA);
                        break;
                            
                        
//                    case Konstante.SIFRA_USLUGE:
//                        System.out.println("O: " + Konstante.SIFRA_USLUGE);
//                        int sifra = Kontroler.vratiObjekat().kreirajSifru();
//                        toOdogovor.setOdgovor(sifra);
//                        if(sifra<=0) toOdogovor.setRezultat(Konstante.ERROR);
//                        else toOdogovor.setRezultat(Konstante.OK);
//                        break;
//                    case Konstante.ZAPAMTI_USLUGU:
//                        System.out.println("O: " + Konstante.ZAPAMTI_USLUGU);
//                        Usluga u = (Usluga) toZahtev.getParametar();
//                        Kontroler.vratiObjekat().sacuvajUslugu(u);
//                        toOdogovor.setRezultat(Konstante.OK);
//                        break;
//                    case Konstante.VRATI_USLUGE:
//                        System.out.println("O: " + Konstante.VRATI_USLUGE);
//                        List<OpstiDomenskiObjekat> lu = Kontroler.vratiObjekat().vratiUsluge();
//                        toOdogovor.setOdgovor(lu);
//                        if(lu.size()==0) toOdogovor.setRezultat(Konstante.ERROR);
//                        else toOdogovor.setRezultat(Konstante.OK);
//                        break;
//                    case Konstante.PRONADJI_USLUGE:
//                        System.out.println("O: " + Konstante.PRONADJI_USLUGE);
//                        String naziv = (String) toZahtev.getParametar();
//                        List<OpstiDomenskiObjekat> l = Kontroler.vratiObjekat().PronadjiUsluge(naziv);
//                        toOdogovor.setOdgovor(l);
//                        if(l.size()==0) toOdogovor.setRezultat(Konstante.ERROR);
//                        else toOdogovor.setRezultat(Konstante.OK);
//                        break;
//                    case Konstante.VRATI_USLUGU:
//                        System.out.println("O: " + Konstante.VRATI_USLUGU);
//                        String sifraUsluge = (String) toZahtev.getParametar();
//                        Usluga us = Kontroler.vratiObjekat().vratiUslugu(sifraUsluge);
//                        toOdogovor.setOdgovor(us);
//                        if(us==null) toOdogovor.setRezultat(Konstante.ERROR);
//                        else toOdogovor.setRezultat(Konstante.OK);
//                        break;
//                    case Konstante.SACUVAJ_IZMENE:
//                        System.out.println("O: " + Konstante.SACUVAJ_IZMENE);
//                        Usluga usl = (Usluga) toZahtev.getParametar();
//                        Kontroler.vratiObjekat().sacuvajIzmene(usl);
//                        toOdogovor.setRezultat(Konstante.OK);
//                        break;
//                    case Konstante.OBRISI_USLUGU:
//                        System.out.println("O: " + Konstante.OBRISI_USLUGU);
//                        Usluga uslu = (Usluga) toZahtev.getParametar();
//                        Kontroler.vratiObjekat().obrisiUslugu(uslu);
//                        toOdogovor.setRezultat(Konstante.OK);
//                        break;
//                    case Konstante.VRATI_MESTA:
//                        System.out.println("O: " + Konstante.VRATI_MESTA);
//                        List<OpstiDomenskiObjekat> lm = Kontroler.vratiObjekat().vratiMesta();
//                        toOdogovor.setOdgovor(lm);
//                        if(lm.size()==0) toOdogovor.setRezultat(Konstante.ERROR);
//                        else toOdogovor.setRezultat(Konstante.OK);
//                        break;
//                    case Konstante.SIFRA_KORISNIKA:
//                        System.out.println("O: " + Konstante.SIFRA_KORISNIKA);
//                        int sifra1 = Kontroler.vratiObjekat().kreirajSifruKorisnika();
//                        toOdogovor.setOdgovor(sifra1);
//                        if(sifra1<=0) toOdogovor.setRezultat(Konstante.ERROR);
//                        else toOdogovor.setRezultat(Konstante.OK);
//                        break;
//                    case Konstante.ZAPAMTI_KORISNIKA:
//                        System.out.println("O: " + Konstante.ZAPAMTI_KORISNIKA);
//                        Korisnik k = (Korisnik) toZahtev.getParametar();
//                        Kontroler.vratiObjekat().zapamtiKorisnika(k);
//                        toOdogovor.setRezultat(Konstante.OK);
//                        break;
//                    case Konstante.PRONADJI_KORISNIKE:
//                        System.out.println("O: " + Konstante.PRONADJI_KORISNIKE);
//                        String ime = (String) toZahtev.getParametar();
//                        List<OpstiDomenskiObjekat> li = Kontroler.vratiObjekat().PronadjiKorisnike(ime);
//                        toOdogovor.setOdgovor(li);
//                        System.out.println("2"+li.size());
//                        if(li.size()==0) toOdogovor.setRezultat(Konstante.ERROR);
//                        else toOdogovor.setRezultat(Konstante.OK);
//                        break;
//                    case Konstante.VRATI_KORISNIKA:
//                        System.out.println("O: " + Konstante.VRATI_KORISNIKA);
//                        String sifraKorisnika = (String) toZahtev.getParametar();
//                        Korisnik korisnik = Kontroler.vratiObjekat().vratiKorisnika(sifraKorisnika);
//                        toOdogovor.setOdgovor(korisnik);
//                        if(korisnik==null) toOdogovor.setRezultat(Konstante.ERROR);
//                        else toOdogovor.setRezultat(Konstante.OK);
//                        break;
//                    case Konstante.SACUVAJ_IZMENE_KORISNIKA:
//                        System.out.println("O: " + Konstante.SACUVAJ_IZMENE_KORISNIKA);
//                        Korisnik kor = (Korisnik) toZahtev.getParametar();
//                        Kontroler.vratiObjekat().sacuvajIzmeneKorisnika(kor);
//                        toOdogovor.setRezultat(Konstante.OK);
//                        break;
//                    case Konstante.OBRISI_KORISNIKA:
//                        System.out.println("O: " + Konstante.OBRISI_KORISNIKA);
//                        Korisnik kori = (Korisnik) toZahtev.getParametar();
//                        Kontroler.vratiObjekat().obrisiKorisnika(kori);
//                        toOdogovor.setRezultat(Konstante.OK);
//                        break;
//                    case Konstante.VRATI_KORISNIKE:
//                        System.out.println("O: " + Konstante.VRATI_KORISNIKE);
//                        List<OpstiDomenskiObjekat> lk = Kontroler.vratiObjekat().vratiKorisnike();
//                        toOdogovor.setOdgovor(lk);
//                        if(lk.size()==0) toOdogovor.setRezultat(Konstante.ERROR);
//                        else toOdogovor.setRezultat(Konstante.OK);
//                        break;
//                    case Konstante.SIFRA_RACUNA:
//                        System.out.println("O: " + Konstante.SIFRA_RACUNA);
//                        int sifra2 = Kontroler.vratiObjekat().kreirajSifruRacuna();
//                        toOdogovor.setOdgovor(sifra2);
//                        if(sifra2<=0) toOdogovor.setRezultat(Konstante.ERROR);
//                        else toOdogovor.setRezultat(Konstante.OK);
//                        break;
//                    case Konstante.OBRADI_RACUN:
//                        System.out.println("O: " + Konstante.OBRADI_RACUN);
//                        Racun r = (Racun) toZahtev.getParametar();
//                        Kontroler.vratiObjekat().obradiRacun(r);
//                        toOdogovor.setRezultat(Konstante.OK);
//                        break;
//                    case Konstante.PRONADJI_RACUN:
//                        System.out.println("O: " + Konstante.PRONADJI_RACUN);
//                        String sifraRacuna = (String) toZahtev.getParametar();
//                        Racun racun = Kontroler.vratiObjekat().pronadjiRacun(sifraRacuna);
//                        toOdogovor.setOdgovor(racun);
//                        if(racun==null) toOdogovor.setRezultat(Konstante.ERROR);
//                        else toOdogovor.setRezultat(Konstante.OK);
//                        break;
//                    case Konstante.STORNIRAJ_RACUN:
//                        System.out.println("O: " + Konstante.STORNIRAJ_RACUN);
//                        Racun rac = (Racun) toZahtev.getParametar();
//                        Kontroler.vratiObjekat().stornirajRacun(rac);
//                        toOdogovor.setRezultat(Konstante.OK);
//                        break;
                    
                }
            } catch (Exception ex) {
                toOdogovor.setIzuzetak(ex);
                toOdogovor.setRezultat(ex.getMessage());
            }
            posaljiOdgovor(toOdogovor);
        }
    }

    private void posaljiOdgovor(TransferObjekatOdgovor toOdogovor) throws IOException {
        ObjectOutputStream outSocket = new ObjectOutputStream(socket.getOutputStream());
        outSocket.writeObject(toOdogovor);
    }

}
