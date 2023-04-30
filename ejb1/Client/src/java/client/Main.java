package client;

import ejb.BooksSessionBeanRemote;
import ejb.Cours;
import java.util.List;
import java.util.Scanner;
import javax.ejb.EJB;

/**
 *
 * @author Sara Mousselmal
 */
public class Main {

    @EJB
    private static BooksSessionBeanRemote booksSessionBean;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Cours Management System!");
        while (true) {
            System.out.println("Enter 1 to create a Cours");
            System.out.println("Enter 2 to retrieve all Cours");
            System.out.println("Enter 3 to retrieve a Cours by ID");
            System.out.println("Enter 4 to update a Cours");
            System.out.println("Enter 5 to delete a Cours");
            System.out.println("Enter 6 to exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character after reading an integer input

            switch (choice) {
                case 1:
                    System.out.println("Enter Cours ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter Cours credite: ");
                    int credite = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter Cours coefficients: ");
                    int coefficients = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter Cours namecours: ");
                    String namecours = scanner.nextLine();
                    System.out.println("Enter Cours prof: ");
                    String prof = scanner.nextLine();
                    
                    // Create a new Cours object
                    Cours cours = new Cours();
                    cours.setId(id);
                    cours.setCredite(credite);
                    cours.setCoefficients(coefficients);
                    cours.setNamecours(namecours);
                    cours.setProf(prof);
                    booksSessionBean.createCours(cours);
                    System.out.println("Cours created successfully!");
                    break;
                case 2:
                    // Retrieve all Cours
                    List<Cours> listCours = booksSessionBean.getAllCours();
                    System.out.println("All Cours: " + listCours);
                    break;
                case 3:
                    // Retrieve a Cours by ID
                    System.out.println("Enter Cours ID: ");
                    int coursId = scanner.nextInt();
                    scanner.nextLine();
                    Cours retrievedCours = booksSessionBean.getCoursById(coursId);
                    if (retrievedCours != null) {
                        System.out.println("Retrieved Cours: " + retrievedCours);
                    } else {
                        System.out.println("Cours not found!");
                    }
                    break;
                case 4:
                    // Update a Cours
                    System.out.println("Enter Cours ID: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();
                    Cours updatedCours = booksSessionBean.getCoursById(updateId);
                    if (updatedCours != null) {
                        System.out.println("Enter Cours credite: ");
                        int updatedCredite = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Enter Cours coefficients: ");
                        int updatedCoefficients = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Enter Cours namecours: ");
                        String updatedNamecours = scanner.nextLine();
                        System.out.println("Enter Cours prof: ");
                        String updatedProf = scanner.nextLine();
                        // Update the Cours object with new values
                        updatedCours.setCredite(updatedCredite);
                        updatedCours.setCoefficients(updatedCoefficients);
                        updatedCours.setNamecours(updatedNamecours);
                        updatedCours.setProf(updatedProf);
                        
                        booksSessionBean.updateCours(updatedCours);
                        System.out.println("Cours updated successfully!");
                    } else {
                        System.out.println("Cours not found!");
                    }
                    break;
                case 5:
                    // Delete a Cours
                    System.out.println("Enter Cours ID: ");
                    int deleteId = scanner.nextInt();
                    scanner.nextLine();
                    Cours deletedCours = booksSessionBean.getCoursById(deleteId);
                    if (deletedCours != null) {
                        booksSessionBean.deleteCours(deletedCours.getId());
                        System.out.println("Cours deleted successfully!");
                    } else {
                        System.out.println("Cours not found!");
                    }
                    break;
                case 6:
                    // Exit the program
                    System.out.println("Thank you for using Cours Management System. Goodbye!");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
                    break;
            }
        }
    }
}

