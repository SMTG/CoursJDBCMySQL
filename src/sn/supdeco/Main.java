package sn.supdeco;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main() throws SQLException {

        EtudiantDAO dao = new EtudiantDAO();

        try {
            // 1. Ajouter un étudiant

            Etudiant e = new Etudiant();

            e.setMatricule("MAT1111");
            e.setNom("Diop");
            e.setPrenom("Talla");
            e.setEmail("talla@gmail.com");
            e.setFiliere("Informatique");
            e.setMoyenne(14.5);
            e.setDate_inscription(LocalDate.now());

            if (dao.save(e)) {
                System.out.println("Étudiant ajouté avec succès.");
            }

            // 2. Afficher tous les étudiants


            System.out.println("\n===== Liste des étudiants =====");

            List<Etudiant> liste = dao.findAll();

            for (Etudiant etu : liste) {

                System.out.println(etu.getId() + " - " + etu.getMatricule() + " - " + etu.getNom() + " - " + etu.getPrenom() + " - " + etu.getFiliere()+ " - "+etu.getMoyenne()+ " - "+ etu.getDate_inscription());

            }
            // 3. Modifier un étudiant

            Etudiant modif = new Etudiant();

            modif.setId(1);               // ID à modifier
            modif.setNom("GUEYE");
            modif.setPrenom("Mor Talla");
            modif.setEmail("mortalla.gueye@gmail.com");
            modif.setFiliere("Informatique");
            modif.setMoyenne(16.75);
            modif.setDate_inscription(LocalDate.now());
            if (dao.update(modif)) {
                System.out.println("\nÉtudiant modifié.");
            }

            // 4. Supprimer un étudiant
            if (dao.delete(1)) {      // Supprime l'étudiant d'ID=2
                System.out.println("Étudiant supprimé.");
            }
        } catch (SQLException e) {

            System.err.println("Erreur SQL : " + e.getMessage());

            e.printStackTrace();

        }
    }
}
