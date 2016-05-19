/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.sql.ResultSet;
import java.util.ArrayList;
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

    public StavkaRezervacijeVoznje() {
    }

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
        return null;
    }

    @Override
    public String vratiVrednostPK() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<AbstractObjekat> RSuTabelu(ResultSet rs) {
        List<AbstractObjekat> stavke = new ArrayList<>();
        try {
            while (rs.next()) {
                String StavkaRVID = rs.getString("StavkaRVID");
                String RezervacijaID = rs.getString("RezervacijaID");
                String MotorneSankeID = rs.getString("MotorneSankeID");
                int RedniBrojStavkeRB = rs.getInt("RedniBrojStavke");
                RezervacijaVoznje rez = new RezervacijaVoznje(RezervacijaID, null, false, null, null);
                MotorneSanke ms = new MotorneSanke(MotorneSankeID, null, null, null);
                StavkaRezervacijeVoznje srv = new StavkaRezervacijeVoznje(StavkaRVID, rez, ms, RedniBrojStavkeRB);
                stavke.add(srv);
            }
        } catch (Exception e) {
            System.out.println("Greska kod stavki rezervacije.");
        }
        return stavke;
    }

    @Override
    public String vratiUpdate() {
        return String.format("MotorneSankeID = %s, RedniBrojStavke = %s", MotorneSanke.getMotorneSankeID(), RedniBrojStavke);
    }

    @Override
    public String vratiSlozenPK() {
        return String.format("StavkaRVID = %s AND RezervacijaID = %s", StavkaRezervacijeID, RezervacijaVoznje.getRezevacijaID());
    }

    @Override
    public String toString() {
        return "StavkaRezervacijeVoznje{" + "StavkaRezervacijeID=" + StavkaRezervacijeID + ", RezervacijaVoznje=" + RezervacijaVoznje + ", MotorneSanke=" + MotorneSanke + ", RedniBrojStavke=" + RedniBrojStavke + '}';
    }
    
    
    
}
