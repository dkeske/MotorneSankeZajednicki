/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Daniel
 */
public class MotorneSanke extends AbstractObjekat {

    private String MotorneSankeID;
    private String BrojSasije;
    private String BrojMestaZaSedenje;
    private TipSanki TipSanki;

    public MotorneSanke() {
    }

    public MotorneSanke(String MotorneSankeID, String BrojSasije, String BrojMestaZaSedenje, TipSanki TipSanki) {
        this.MotorneSankeID = MotorneSankeID;
        this.BrojSasije = BrojSasije;
        this.BrojMestaZaSedenje = BrojMestaZaSedenje;
        this.TipSanki = TipSanki;
    }

    @Override
    public String toString() {
        return BrojSasije;
    }

    @Override
    public String vratiImeTabele() {
        return "motorne_sanke";
    }

    @Override
    public String vratiParametre() {
        return String.format("'%s', '%s', '%s', '%s'", MotorneSankeID, BrojSasije, BrojMestaZaSedenje, TipSanki.getTipSankiID());
    }

    @Override
    public String vratiPK() {
        return "MotorneSankeID";
    }

    @Override
    public String vratiVrednostPK() {
        return MotorneSankeID;
    }

    @Override
    public List<AbstractObjekat> RSuTabelu(ResultSet rs) {
        List<AbstractObjekat> motorneSanke = new ArrayList<>();
        try {
            while (rs.next()) {

                String motorneSankeID = rs.getString("MotorneSankeID");
                String brojSasije = rs.getString("BrojSasije");
                String brojMesta = rs.getString("BrojMestaZaSedenje");
                String tipSankiID = rs.getString("TipSankiID");
                MotorneSanke ms = new MotorneSanke(motorneSankeID, brojSasije, brojMesta, new TipSanki(tipSankiID, null, null, 0));
                motorneSanke.add(ms);
            }
        } catch (SQLException ex) {
            System.out.println("Greska RSuTabelu kod motornih sanki");
        }
        return motorneSanke;
    }

    @Override
    public String vratiUpdate() {
        return String.format("BrojSasije='%s',BrojMestaZaSedenje='%s',TipSankiID='%s'", BrojSasije, BrojMestaZaSedenje, TipSanki.getTipSankiID());
    }

    public String getMotorneSankeID() {
        return MotorneSankeID;
    }

    public void setMotorneSankeID(String MotorneSankeID) {
        this.MotorneSankeID = MotorneSankeID;
    }

    public String getBrojSasije() {
        return BrojSasije;
    }

    public void setBrojSasije(String BrojSasije) {
        this.BrojSasije = BrojSasije;
    }

    public String getBrojMestaZaSedenje() {
        return BrojMestaZaSedenje;
    }

    public void setBrojMestaZaSedenje(String BrojMestaZaSedenje) {
        this.BrojMestaZaSedenje = BrojMestaZaSedenje;
    }

    public TipSanki getTipSanki() {
        return TipSanki;
    }

    public void setTipSanki(TipSanki TipSanki) {
        this.TipSanki = TipSanki;
    }

    @Override
    public String vratiSlozenPK() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.MotorneSankeID);
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
        final MotorneSanke other = (MotorneSanke) obj;
        if (!Objects.equals(this.MotorneSankeID, other.MotorneSankeID)) {
            return false;
        }
        return true;
    }

    @Override
    public void postaviVrednostPK(String pk) {
        this.MotorneSankeID = pk;
    }
    
}
