/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Daniel
 */
public class StavkaRezervacijeVoznje extends AbstractObjekat{
    private RezervacijaVoznje RezervacijaVoznje;
    private MotorneSanke MotorneSanke;
    private int RedniBrojStavke;

    public StavkaRezervacijeVoznje() {
    }

    public StavkaRezervacijeVoznje(RezervacijaVoznje RezervacijaVoznje, MotorneSanke MotorneSanke, int RedniBrojStavke) {
        this.RezervacijaVoznje = RezervacijaVoznje;
        this.MotorneSanke = MotorneSanke;
        this.RedniBrojStavke = RedniBrojStavke;
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
        return String.format("'%s', '%s', '%s'", RezervacijaVoznje.getRezevacijaID(), RedniBrojStavke, MotorneSanke.getMotorneSankeID());
    }

    @Override
    public String vratiPK() {
        return "RezervacijaID";
    }

    @Override
    public String vratiVrednostPK() {
        return RezervacijaVoznje.getRezevacijaID();
    }

    @Override
    public List<AbstractObjekat> RSuTabelu(ResultSet rs) {
        List<AbstractObjekat> stavke = new ArrayList<>();
        try {
            while (rs.next()) {
                String RezervacijaID = rs.getString("RezervacijaID");
                String MotorneSankeID = rs.getString("MotorneSankeID");
                int RedniBrojStavkeRB = rs.getInt("RedniBrojStavke");
                RezervacijaVoznje rez = new RezervacijaVoznje(RezervacijaID, null, false, null, null);
                MotorneSanke ms = new MotorneSanke(MotorneSankeID, null, null, null);
                StavkaRezervacijeVoznje srv = new StavkaRezervacijeVoznje(rez, ms, RedniBrojStavkeRB);
                stavke.add(srv);
            }
        } catch (Exception e) {
            System.out.println("Greska kod stavki rezervacije." + e.getMessage());
        }
        return stavke;
    }

    @Override
    public String vratiUpdate() {
        return String.format("MotorneSankeID = %s, RedniBrojStavke = %s", MotorneSanke.getMotorneSankeID(), RedniBrojStavke);
    }

    @Override
    public String vratiSlozenPK() {
        return String.format("RedniBrojStavke = %s AND RezervacijaID = %s", RedniBrojStavke, RezervacijaVoznje.getRezevacijaID());
    }

    @Override
    public String toString() {
        return "StavkaRezervacijeVoznje{" + ", RezervacijaVoznje=" + RezervacijaVoznje + ", MotorneSanke=" + MotorneSanke + ", RedniBrojStavke=" + RedniBrojStavke + '}';
    }

    @Override
    public void postaviVrednostPK(String pk) {
//        RedniBrojStavke = Integer.parseInt(pk);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.RezervacijaVoznje);
        hash = 31 * hash + this.RedniBrojStavke;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final StavkaRezervacijeVoznje other = (StavkaRezervacijeVoznje) obj;
        if (this.RedniBrojStavke != other.RedniBrojStavke) {
            return false;
        }
        if (!Objects.equals(this.RezervacijaVoznje, other.RezervacijaVoznje)) {
            return false;
        }
        return true;
    }
    
    
    
}
