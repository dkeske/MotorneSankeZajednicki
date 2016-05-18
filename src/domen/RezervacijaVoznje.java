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

/**
 *
 * @author Daniel
 */
public class RezervacijaVoznje extends AbstractObjekat{
    private String RezevacijaID;
    private Date DatumRezervacije;
    private boolean UplataUnapred;
    private Vozac vozac;

    public RezervacijaVoznje(String RezevacijaID, Date DatumRezervacije, boolean UplataUnapred, Vozac vozac) {
        this.RezevacijaID = RezevacijaID;
        this.DatumRezervacije = DatumRezervacije;
        this.UplataUnapred = UplataUnapred;
        this.vozac = vozac;
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
        return String.format("'%s', '%b', '%s'", datum , UplataUnapred, vozac.getVozacID());
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
                RezervacijaVoznje rv = new RezervacijaVoznje(rezervacijaID, datumRezervacije, uplataUnapred, new Vozac(vozacID, null, null, null));
                
                rezervacije.add(rv);
            }
        } catch (Exception e) {
            System.out.println("Greska kod stavki rezervacije.");
        }
        return rezervacije;
    }

    @Override
    public String vratiUpdate() {
        return String.format("DatumRezervacije='%s',UplataUnapred='%b',VozacID='%s'", DatumRezervacije, UplataUnapred, vozac.getVozacID());
    }

    @Override
    public String vratiSlozenPK() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
