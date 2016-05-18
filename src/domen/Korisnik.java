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
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author Daniel
 */
public class Korisnik extends AbstractObjekat {

    private String korisnikID;
    private String ime;
    private String korisnickoIme;
    private String password;
    private boolean ulogovan;

    public Korisnik() {
    }

    public Korisnik(String ime, String korisnickoIme, String password) {
        this.ime = ime;
        this.korisnickoIme = korisnickoIme;
        this.password = password;
    }

    public Korisnik(String ime, String korisnickoIme, String password, boolean ulogovan) {
        this.ime = ime;
        this.korisnickoIme = korisnickoIme;
        this.password = password;
        this.ulogovan = ulogovan;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.korisnickoIme);
        hash = 37 * hash + Objects.hashCode(this.password);
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
        final Korisnik other = (Korisnik) obj;
        if (!Objects.equals(this.korisnickoIme, other.korisnickoIme)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        return true;
    }

    @Override
    public String vratiImeTabele() {
        return "korisnik";
    }

    @Override
    public String vratiParametre() {
        return String.format("'%s','%s','%s', 0", ime, korisnickoIme, password);
    }

    @Override
    public String vratiPK() {
        return "KorisnikID";
    }

    @Override
    public String vratiVrednostPK() {
        return korisnikID;
    }

    @Override
    public List<AbstractObjekat> RSuTabelu(ResultSet rs) {
        List<AbstractObjekat> korisnici = new ArrayList<>();
        try {
            while (rs.next()) {

                String KorisnikID = rs.getString("KorisnikID");
                String Ime = rs.getString("ime");
                String KorisnickoIme = rs.getString("KorisnickoIme");
                String Password = rs.getString("Password");
                boolean Ulogovan = rs.getBoolean("Ulogovan");
                Korisnik k = new Korisnik(Ime, KorisnickoIme, Password, Ulogovan);
                korisnici.add(k);
            }
        } catch (SQLException ex) {
            System.out.println("Greska RSuTabelu kod motornih sanki");
        }
        return korisnici;
    }

    @Override
    public String vratiUpdate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getStatusText() {
        if (ulogovan == false) {
            return "Nije ulogovan";
        } else {
            return "Ulogovan";
        }
    }

    public String getKorisnikID() {
        return korisnikID;
    }

    public void setKorisnikID(String korisnikID) {
        this.korisnikID = korisnikID;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setHashPassword(String pass) {
        this.password = DigestUtils.sha256Hex(password);
    }

    public boolean isUlogovan() {
        return ulogovan;
    }

    public void setUlogovan(boolean ulogovan) {
        this.ulogovan = ulogovan;
    }

}
