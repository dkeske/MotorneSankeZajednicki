/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Daniel
 */
public class RezervacijaVoznje extends AbstractObjekat{
    private String RezevacijaID;
    private Date DatumRezervacije;
    private boolean UplataUnapred;
    private Vozac vozac;
    private List<StavkaRezervacijeVoznje> listaStavki;

    public RezervacijaVoznje() {
    }

    public RezervacijaVoznje(String RezevacijaID, Date DatumRezervacije, boolean UplataUnapred, Vozac vozac, List<StavkaRezervacijeVoznje> listaStavki) {
        this.RezevacijaID = RezevacijaID;
        this.DatumRezervacije = DatumRezervacije;
        this.UplataUnapred = UplataUnapred;
        this.vozac = vozac;
        this.listaStavki = listaStavki;
    }

    public String getRezevacijaID() {
        return RezevacijaID;
    }

    public void setRezevacijaID(String RezevacijaID) {
        this.RezevacijaID = RezevacijaID;
    }

    public Date getDatumRezervacije() {
        return DatumRezervacije;
    }

    public void setDatumRezervacije(Date DatumRezervacije) {
        this.DatumRezervacije = DatumRezervacije;
    }

    public boolean isUplataUnapred() {
        return UplataUnapred;
    }

    public void setUplataUnapred(boolean UplataUnapred) {
        this.UplataUnapred = UplataUnapred;
    }

    public Vozac getVozac() {
        return vozac;
    }

    public void setVozac(Vozac vozac) {
        this.vozac = vozac;
    }

    @Override
    public String vratiImeTabele() {
        return "rezervacija_voznje";
    }

    @Override
    public String vratiParametre() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String datum = sdf.format(DatumRezervacije);
        return String.format("'%s', '%s', '%d', '%s'",RezevacijaID, datum , (UplataUnapred) ? 1 : 0, vozac.getVozacID());
    }

    @Override
    public String vratiPK() {
        return "RezervacijaID";
    }

    @Override
    public String vratiVrednostPK() {
        return RezevacijaID;
    }

    @Override
    public List<AbstractObjekat> RSuTabelu(ResultSet rs) {
        List<AbstractObjekat> rezervacije = new ArrayList<>();
        try {
            while (rs.next()) {
                String rezervacijaID = rs.getString("RezervacijaID");
                Date datumRezervacije = rs.getDate("DatumRezervacije");
                boolean uplataUnapred = rs.getBoolean("UplataUnapred");
                String vozacID = rs.getString("VozacID");
                RezervacijaVoznje rv = new RezervacijaVoznje(rezervacijaID, datumRezervacije, uplataUnapred, new Vozac(vozacID, null, null, null), new ArrayList<StavkaRezervacijeVoznje>());
                
                rezervacije.add(rv);
            }
        } catch (Exception e) {
            System.out.println("Greska kod rezervacije.");
        }
        return rezervacije;
    }

    @Override
    public String vratiUpdate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String datum = sdf.format(DatumRezervacije);
        return String.format("DatumRezervacije='%s',UplataUnapred='%d',VozacID='%s'", datum, (UplataUnapred) ? 1 : 0, vozac.getVozacID());
    }

    @Override
    public String vratiSlozenPK() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<StavkaRezervacijeVoznje> getListaStavki() {
        return listaStavki;
    }

    public void setListaStavki(List<StavkaRezervacijeVoznje> listaStavki) {
        this.listaStavki = listaStavki;
    }

    @Override
    public String toString() {
        return RezevacijaID;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.RezevacijaID);
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
        final RezervacijaVoznje other = (RezervacijaVoznje) obj;
        if (!Objects.equals(this.RezevacijaID, other.RezevacijaID)) {
            return false;
        }
        return true;
    }
    
    

    @Override
    public void postaviVrednostPK(String pk) {
        this.RezevacijaID = pk;
    }
    
    
}
