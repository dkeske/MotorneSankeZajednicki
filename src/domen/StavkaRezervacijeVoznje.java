/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Daniel
 */
public class StavkaRezervacijeVoznje extends AbstractObjekat{
    private String StavkaRezervacijeID;
    private RezervacijaVoznje RezervacijaVoznje;
    private MotorneSanke MotorneSanke;
    private int RedniBrojStavke;

    public StavkaRezervacijeVoznje(String StavkaRezervacijeID, RezervacijaVoznje RezervacijaVoznje, MotorneSanke MotorneSanke, int RedniBrojStavke) {
        this.StavkaRezervacijeID = StavkaRezervacijeID;
        this.RezervacijaVoznje = RezervacijaVoznje;
        this.MotorneSanke = MotorneSanke;
        this.RedniBrojStavke = RedniBrojStavke;
    }

    public String getStavkaRezervacijeID() {
        return StavkaRezervacijeID;
    }

    public void setStavkaRezervacijeID(String StavkaRezervacijeID) {
        this.StavkaRezervacijeID = StavkaRezervacijeID;
    }

    public RezervacijaVoznje getRezervacijaVoznje() {
        return RezervacijaVoznje;
    }

    public void setRezervacijaVoznje(RezervacijaVoznje RezervacijaVoznje) {
        this.RezervacijaVoznje = RezervacijaVoznje;
    }

    public MotorneSanke getMotorneSanke() {
        return MotorneSanke;
    }

    public void setMotorneSanke(MotorneSanke MotorneSanke) {
        this.MotorneSanke = MotorneSanke;
    }

    public int getRedniBrojStavke() {
        return RedniBrojStavke;
    }

    public void setRedniBrojStavke(int RedniBrojStavke) {
        this.RedniBrojStavke = RedniBrojStavke;
    }

    @Override
    public String vratiImeTabele() {
        return "stavka_rezervacije_voznje";
    }

    @Override
    public String vratiParametre() {
        return String.format("'%s', '%s', '%s'", RezervacijaVoznje.getRezevacijaID(), MotorneSanke.getMotorneSankeID(), RedniBrojStavke);
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
