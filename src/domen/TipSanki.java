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

/**
 *
 * @author Daniel
 */
public class TipSanki extends AbstractObjekat{
    private String TipSankiID;
    private String NazivTipa;
    private String Namena;
    private double DuzinaKrampona;

    public TipSanki() {
    }

    public TipSanki(String TipSankiID, String NazivTipa, String Namena, double DuzinaKrampona) {
        this.TipSankiID = TipSankiID;
        this.NazivTipa = NazivTipa;
        this.Namena = Namena;
        this.DuzinaKrampona = DuzinaKrampona;
    }

    public String getTipSankiID() {
        return TipSankiID;
    }

    public void setTipSankiID(String TipSankiID) {
        this.TipSankiID = TipSankiID;
    }

    public String getNazivTipa() {
        return NazivTipa;
    }

    public void setNazivTipa(String NazivTipa) {
        this.NazivTipa = NazivTipa;
    }

    public String getNamena() {
        return Namena;
    }

    public void setNamena(String Namena) {
        this.Namena = Namena;
    }

    public double getDuzinaKrampona() {
        return DuzinaKrampona;
    }

    public void setDuzinaKrampona(double DuzinaKrampona) {
        this.DuzinaKrampona = DuzinaKrampona;
    }

    @Override
    public String toString() {
        return NazivTipa;
    }

    @Override
    public String vratiImeTabele() {
        return "tip_motornih_sanki";
    }

    @Override
    public String vratiParametre() {
        return String.format("'%s', '%s', '%,.2f'", NazivTipa, Namena, DuzinaKrampona);
    }

    @Override
    public String vratiPK() {
        return "TipSankiID";
    }

    @Override
    public String vratiVrednostPK() {
        return TipSankiID;
    }

    @Override
    public List<AbstractObjekat> RSuTabelu(ResultSet rs) {
        List<AbstractObjekat> tipoviSanki = new ArrayList<>();
        try {
            while(rs.next()){

                String tipSankiID = rs.getString("TipSankiID");
                String nazivTipa = rs.getString("NazivTipa");
                String namena = rs.getString("Namena");
                Double duzinaKrampona = rs.getDouble("DuzinaKrampona");
                TipSanki ts = new TipSanki(tipSankiID, nazivTipa, namena, duzinaKrampona);
                tipoviSanki.add(ts);
                } 
            }
        catch (SQLException ex) {
            System.out.println("Greska RSuTabelu kod motornih sanki");
            }
        return tipoviSanki;
    }

    @Override
    public String vratiUpdate() {
        return String.format("NazivTipa='%s',Namena='%s',DuzinaKrampona='%d'", NazivTipa, Namena, DuzinaKrampona);
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
