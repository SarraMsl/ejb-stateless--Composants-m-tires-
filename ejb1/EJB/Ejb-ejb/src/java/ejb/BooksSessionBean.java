/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package ejb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.print.Collation;
import javax.ejb.Stateless;

/**
 *
 * @author Sara Mousselmal
 */
@Stateless
public class BooksSessionBean implements BooksSessionBeanRemote {
    
    Map<Integer,Cours> map = new HashMap<>();

    @Override
    public boolean createCours(ejb.Cours cours) {
        map.put(cours.getId(), cours);
        return true;
    }

    @Override
    public boolean updateCours(ejb.Cours cours) {
        Cours get = getCoursById(cours.getId());
        if(get!=null){
            get.setCredite(cours.getCredite());
            get.setCoefficients(cours.getCoefficients());
            get.setNamecours(cours.getNamecours());
            get.setProf(cours.getProf());
            map.put(cours.getId(), get);
            return true;
        }
        return false;
        
    }

    @Override
    public boolean deleteCours(int id) {
        Cours get = getCoursById(id);
        if(get!=null){
            map.remove(id);
            return true;
        }
        return false;
    }

    @Override
    public Cours getCoursById(int id) {
        if(map.containsKey(id)){
            return map.get(id);
        }else{
            return null;
        }  
    }

    @Override
    public List<Cours> getAllCours() {
        return new ArrayList<>(map.values());
    }

}
