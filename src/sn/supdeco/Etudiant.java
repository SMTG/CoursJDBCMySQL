package sn.supdeco;

import java.sql.Date;
import java.time.LocalDate;


public class Etudiant {
    private int id ;
    private String matricule;
    private String nom ;
    private String prenom;
    private String email;
    private String filiere ;
    private Double moyenne ;
    private LocalDate date_inscription;


    public Etudiant() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFiliere() {
        return filiere;
    }

    public void setFiliere(String filiere) {
        this.filiere = filiere;
    }

    public Double getMoyenne() {
        return moyenne;
    }

    public void setMoyenne(Double moyenne) {
        this.moyenne = moyenne;
    }

    public LocalDate getDate_inscription() {
        return date_inscription;
    }

    public void setDate_inscription(LocalDate date_inscription) {
        this.date_inscription = date_inscription;
    }

    public Etudiant(int id, String matricule, String nom, String prenom, String email, String filiere, Double moyenne, LocalDate date_inscription) {
        this.id = id;
        this.matricule = matricule;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.filiere = filiere;
        this.moyenne = moyenne;
        this.date_inscription = date_inscription;
    }


    @Override
    public String toString() {
        return "Etudiant{" +
                "id=" + id +
                ", matricule='" + matricule + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                ", filiere='" + filiere + '\'' +
                ", moyenne=" + moyenne +
                ", date_inscription=" + date_inscription +
                '}';
    }
}
