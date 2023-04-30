/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejb;

import java.io.Serializable;

/**
 *
 * @author Sara Mousselmal
 */
public class Cours implements Serializable{

    private int id;
    private int credite;
    private int coefficients;
    private String Namecours;
    private String prof;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCredite() {
        return credite;
    }

    public void setCredite(int credite) {
        this.credite = credite;
    }

    public int getCoefficients() {
        return coefficients;
    }

    public void setCoefficients(int coefficients) {
        this.coefficients = coefficients;
    }

    public String getNamecours() {
        return Namecours;
    }

    public void setNamecours(String Namecours) {
        this.Namecours = Namecours;
    }

    public String getProf() {
        return prof;
    }

    public void setProf(String prof) {
        this.prof = prof;
    }

    @Override
    public String toString() {
        return "Cours{" + "id=" + id + ", credite=" + credite + ", coefficients=" + coefficients + ", Namecours=" + Namecours + ", prof=" + prof + '}';
    }

  
    
    
    
}

