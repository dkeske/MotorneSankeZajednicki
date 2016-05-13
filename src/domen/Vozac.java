/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.sql.ResultSet;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Daniel
 */
public class Vozac extends AbstractObjekat{
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiPK() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiVrednostPK() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<AbstractObjekat> RSuTabelu(ResultSet rs) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiUpdate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
