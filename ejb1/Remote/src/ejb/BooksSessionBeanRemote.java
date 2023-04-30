/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionRemote.java to edit this template
 */
package ejb;

import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Sara Mousselmal
 */
@Remote
public interface BooksSessionBeanRemote {
    public boolean createCours(Cours cours);
    public Cours getCoursById(int id);
    public List<Cours> getAllCours();
    public boolean updateCours(Cours cours);
    public boolean deleteCours(int id);
}
