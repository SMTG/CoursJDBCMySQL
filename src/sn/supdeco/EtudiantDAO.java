package sn.supdeco;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EtudiantDAO {
    // Lire tous les étudiants
    public List<Etudiant> findAll() throws SQLException {
        List<Etudiant> liste = new ArrayList<>();
        String sql = "SELECT * FROM etudiants ORDER BY nom";

        try (Connection cn = DatabaseConfig.getConnexion();
             Statement st = cn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Etudiant e = new Etudiant();
                e.setId(rs.getInt("id"));
                e.setMatricule(rs.getString("matricule"));
                e.setNom(rs.getString("nom"));
                e.setPrenom(rs.getString("prenom"));
                e.setEmail(rs.getString("email"));
                e.setFiliere(rs.getString("filiere"));
                e.setMoyenne(rs.getDouble("moyenne"));
                e.setDate_inscription(rs.getDate("date_inscription").toLocalDate());
                liste.add(e);
            }
        }
        return liste;
    }

    // Insérer un étudiant (PreparedStatement - sécurisé !)
    public boolean save(Etudiant e) throws SQLException {
        String sql = "INSERT INTO etudiants (matricule, nom, prenom, email, filiere,moyenne,date_inscription) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection cn = DatabaseConfig.getConnexion();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setString(1, e.getMatricule());
            ps.setString(2, e.getNom());
            ps.setString(3, e.getPrenom());
            ps.setString(4, e.getEmail());
            ps.setString(5, e.getFiliere());
            ps.setDouble(6,e.getMoyenne());
            ps.setDate(7, java.sql.Date.valueOf(e.getDate_inscription()));
            return ps.executeUpdate() > 0;
        }
    }

    // Mettre à jour
    public boolean update(Etudiant e) throws SQLException {
        String sql = "UPDATE etudiants SET nom=?, prenom=?, email=?, filiere=?,moyenne=?, date_inscription=? WHERE id=?";
        try (Connection cn = DatabaseConfig.getConnexion();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, e.getNom());
            ps.setString(2, e.getPrenom());
            ps.setString(3, e.getEmail());
            ps.setString(4,e.getFiliere());
            ps.setDouble(5, e.getMoyenne());
            ps.setDate(6, java.sql.Date.valueOf(e.getDate_inscription()));
            ps.setInt(7, e.getId());
            return ps.executeUpdate() > 0;
        }
    }

    // Supprimer
    public boolean delete(int id) throws SQLException {
        String sql = "DELETE FROM etudiants WHERE id = ?";
        try (Connection cn = DatabaseConfig.getConnexion();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        }
    }

}
