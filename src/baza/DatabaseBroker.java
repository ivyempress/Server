/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baza;

import domen.Clan;
import domen.OpstiDomenskiObjekat;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author Ivana
 */
public class DatabaseBroker {

    private Connection connection;
    private static DatabaseBroker instance;

    private DatabaseBroker() {
    }

    public static DatabaseBroker getInstance() {
        if (instance == null) {
            instance = new DatabaseBroker();
        }
        return instance;
    }

    public void ucitajDriver() throws RuntimeException {
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        } catch (Exception ex) {
            throw new RuntimeException("Driver nije pronadjen!");
        }
    }

    public void otvoriKonekciju() throws RuntimeException {
        try {
            connection = DriverManager.getConnection("jdbc:odbc:IvanaSeminarski");
            connection.setAutoCommit(false); //zahteva elksplicitnu potvrdu transakcije
        } catch (Exception ex) {
            throw new RuntimeException("Neuspesno otvaranje konekcije!");
        }
    }

    public void commitTransakcije() throws RuntimeException {
        try {
            connection.commit();
        } catch (SQLException ex) {
            throw new RuntimeException("Neuspesan commit!");
        }
    }

    public void rollbackTransakcije() throws RuntimeException {
        try {
            connection.rollback();
        } catch (SQLException ex) {
            throw new RuntimeException("Neuspesan rollback!");
        }
    }

    public void zatvoriKonekciju() throws RuntimeException {
        try {
            connection.close();
        } catch (SQLException ex) {
            throw new RuntimeException("Neuspesno zatvaranje konekcije!");
        }
    }

    public int kreirajSifru(OpstiDomenskiObjekat odo) {
        try {
            String sql = "SELECT MAX(" + odo.vratiNazivKolonePrimarnogKljuca() + ") AS Sifra FROM " + odo.vratiNazivTabele();
            Statement sqlNaredba = connection.createStatement();
            ResultSet rs = sqlNaredba.executeQuery(sql);
            int sifra = 0;
            if (rs.next()) {
                try {
                    sifra = Integer.parseInt(rs.getString("Sifra"));
                } catch (Exception e) {
                    System.out.println("Prvi unos u bazu");
                }

            }
            sifra++;
            rs.close();
            sqlNaredba.close();
            return sifra;
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException("Neuspesno generisanje sifre racuna!");
        }

    }

    public void sacuvaj(OpstiDomenskiObjekat odo) {
        try {
            String sql = "INSERT INTO " + odo.vratiNazivTabeleZaInsert() + " VALUES (" + odo.vratiParametreZaInsert() + ")";
            System.out.println(sql);
            Statement sqlNaredba = connection.createStatement();
            System.out.println("" + sql);
            sqlNaredba.executeUpdate(sql);
            sqlNaredba.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException("Neuspesno cuvanje objekta!");
        }
    }

    public List<OpstiDomenskiObjekat> vratiListu(OpstiDomenskiObjekat odo) {
        try {
            String sql = "SELECT * FROM " + odo.vratiNazivTabele() + odo.uslov3();
            System.out.println(sql);
            Statement sqlNaredba = connection.createStatement();
            ResultSet rs = sqlNaredba.executeQuery(sql);
            return odo.vratiListu(rs);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException("Neuspesno vracanje liste");
        }
    }

    public List<OpstiDomenskiObjekat> pronadjiListu(OpstiDomenskiObjekat odo) {
        try {
            String sql = "SELECT * FROM " + odo.vratiNazivTabele() + odo.uslov() + odo.uslov3();
            System.out.println(sql);
            Statement sqlNaredba = connection.createStatement();
            ResultSet rs = sqlNaredba.executeQuery(sql);
            return odo.vratiListu(rs);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException("Neuspesno vracanje liste");
        }
    }

    public OpstiDomenskiObjekat vratiObjekat(OpstiDomenskiObjekat odo) {
        try {
            String sql = "SELECT * FROM " + odo.vratiNazivTabele() + odo.uslov2();
            System.out.println(sql);
            Statement sqlNaredba = connection.createStatement();
            ResultSet rs = sqlNaredba.executeQuery(sql);
            return odo.vratiObjekat(rs);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException("Neuspesno vracanje objekta");
        }
    }

    public void sacuvajIzmene(OpstiDomenskiObjekat odo) {
        try {
            String sql = "";
            if (odo instanceof Clan) {
               sql = "UPDATE " + odo.vratiNazivTabeleZaUpdate() + " SET " + odo.vratiParametreZaUpdate() + " WHERE " + odo.vratiNazivKolonePrimarnogKljuca() + " = '" + odo.vratiSifru()+"'";
            } else {
                sql = "UPDATE " + odo.vratiNazivTabeleZaUpdate() + " SET " + odo.vratiParametreZaUpdate() + " WHERE " + odo.vratiNazivKolonePrimarnogKljuca() + " = " + odo.vratiSifru();
            }
            
            System.out.println(sql);
            PreparedStatement sqlNaredba = connection.prepareStatement(sql);
            System.out.println("" + sql);
            sqlNaredba.executeUpdate();
            sqlNaredba.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException("Neuspesno cuvanje izmena");
        }
    }

    public void obrisi(OpstiDomenskiObjekat odo) {
        try {
            String sql = "";
            if (odo instanceof Clan) {
                sql = "DELETE FROM " + odo.vratiNazivTabeleZaBrisanje() + " WHERE " + odo.vratiNazivKolonePrimarnogKljuca() + " = " + "'" + odo.vratiSifru() + "'";
            } else {
                sql = "DELETE FROM " + odo.vratiNazivTabeleZaBrisanje() + " WHERE " + odo.vratiNazivKolonePrimarnogKljuca() + " = " + odo.vratiSifru();
            }
            System.out.println(sql);
            PreparedStatement sqlNaredba = connection.prepareStatement(sql);
            sqlNaredba.executeUpdate();
            sqlNaredba.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException("Neuspesno cuvanje izmena");
        }
    }

}
