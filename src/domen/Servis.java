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
public class Servis extends AbstractObjekat{
    private String ServisID;
    private Date DatumServisa;
    private boolean ZamenaUlja;
    private double BrojRadnihSati;

    public Servis(String ServisID, Date DatumServisa, boolean ZamenaUlja, double BrojRadnihSati) {
        this.ServisID = ServisID;
        this.DatumServisa = DatumServisa;
        this.ZamenaUlja = ZamenaUlja;
        this.BrojRadnihSati = BrojRadnihSati;
    }

    public String getServisID() {
        return ServisID;
    }

    public void setServisID(String ServisID) {
        this.ServisID = ServisID;
    }

    public Date getDatumServisa() {
        return DatumServisa;
    }

    public void setDatumServisa(Date DatumServisa) {
        this.DatumServisa = DatumServisa;
    }

    public boolean isZamenaUlja() {
        return ZamenaUlja;
    }

    public void setZamenaUlja(boolean ZamenaUlja) {
        this.ZamenaUlja = ZamenaUlja;
    }

    public double getBrojRadnihSati() {
        return BrojRadnihSati;
    }

    public void setBrojRadnihSati(double BrojRadnihSati) {
        this.BrojRadnihSati = BrojRadnihSati;
    }

    @Override
    public String vratiImeTabele() {
        return "servis";
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

    @Override
    public String vratiSlozenPK() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void postaviVrednostPK(String pk) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
