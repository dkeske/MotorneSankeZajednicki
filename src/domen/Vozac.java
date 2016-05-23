/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Daniel
 */
public class Vozac extends AbstractObjekat {

    private String VozacID;
    private Date DatumPrveVoznje;
    private String Ime;
    private String Mail;

    public Vozac(String VozacID, Date DatumPrveVoznje, String Ime, String Mail) {
        this.VozacID = VozacID;
        this.DatumPrveVoznje = DatumPrveVoznje;
        this.Ime = Ime;
        this.Mail = Mail;
    }

    public Vozac() {
    }

    public String getVozacID() {
        return VozacID;
    }

    public void setVozacID(String VozacID) {
        this.VozacID = VozacID;
    }

    public Date getDatumPrveVoznje() {
        return DatumPrveVoznje;
    }

    public void setDatumPrveVoznje(Date DatumPrveVoznje) {
        this.DatumPrveVoznje = DatumPrveVoznje;
    }

    public String getIme() {
        return Ime;
    }

    public void setIme(String Ime) {
        this.Ime = Ime;
    }

    public String getMail() {
        return Mail;
    }

    public void setMail(String Mail) {
        this.Mail = Mail;
    }

    @Override
    public String vratiImeTabele() {
        return "vozac";
    }

    @Override
    public String vratiParametre() {
        return String.format("'%s', '%s', '%s'", DatumPrveVoznje, Ime, Mail);
    }

    @Override
    public String vratiPK() {
        return "VozacID";
    }

    @Override
    public String vratiVrednostPK() {
        return VozacID;
    }

    @Override
    public List<AbstractObjekat> RSuTabelu(ResultSet rs) {
        List<AbstractObjekat> vozaci = new ArrayList<>();
        try {
            while (rs.next()) {

                String VozacID = rs.getString("VozacID");
                Date DatumPrveVoznje = rs.getDate("DatumPrveVoznje");
                String Ime = rs.getString("Ime");
                String Mail = rs.getString("Mail");
                Vozac vo = new Vozac(VozacID, DatumPrveVoznje, Ime, Mail);
                vozaci.add(vo);
            }
        } catch (SQLException ex) {
            System.out.println("Greska RSuTabelu kod motornih sanki");
        }
        return vozaci;
    }

    @Override
    public String vratiUpdate() {
        return String.format("DatumPrveVoznje=%s, Ime=%s, Mail=%s", DatumPrveVoznje, Ime, Mail);
    }

    @Override
    public String vratiSlozenPK() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return Ime;
    }

    
}
