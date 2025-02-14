package net.javaguides.productmanagement.dao;

import net.javaguides.productmanagement.model.Produit;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProduitDao {
    private String jdbcURL = "jdbc:mysql://localhost:3306/stockmaster?useSSL=false";
    private String jdbcUser = "root";
    private String jdbcPassword = "admin";

    public static final String INSERT_PRODUCT = "INSERT INTO produit_table (name, description, quantite, prixUnitaire, categorie) VALUES (?, ?, ?, ?, ?)";
    private static final String SELECT_ALL_PRODUCTS = "SELECT * FROM produit_table;";
    private static final String UPDATE_PRODUCT = "UPDATE products SET name = ?, description = ?, quantity = ?, prixUnitaire = ?, category = ? WHERE id = ?";
    private static final String DELETE_PRODUCT = "DELETE FROM products WHERE id = ?";

    // Connexion à la BD
    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUser, jdbcPassword);
        }
        catch (SQLException e) {
            throw new RuntimeException("Erreur de connexion à la base de données", e);
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    // Ajouter un produit
    public void addProduct(Produit produit) {
        try (
                Connection connection = getConnection();
                PreparedStatement stmt = connection.prepareStatement(INSERT_PRODUCT)
        ){
            stmt.setString(1, produit.getName());
            stmt.setString(2, produit.getDescription());
            stmt.setInt(3, produit.getQuantite());
            stmt.setDouble(4, produit.getPrixUnitaire());
            stmt.setString(5, produit.getCategorie());
            stmt.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    // Récupérer tous les produits
    public List<Produit> getAllProducts() {
        List<Produit> products = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement stmt = connection.prepareStatement(SELECT_ALL_PRODUCTS);
             ) {
            System.out.println("connected on " + connection);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                products.add(new Produit(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getInt("quantite"),
                        rs.getDouble("prixUnitaire"),
                        rs.getString("categorie")
                ));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return products;
    }

    // Mettre à jour un produit
    public boolean updateProduct(Produit produit) {
        boolean rowUpdated = false;
        try (Connection connection = getConnection(); PreparedStatement stmt = connection.prepareStatement(UPDATE_PRODUCT)) {
            stmt.setString(1, produit.getName());
            stmt.setString(2, produit.getDescription());
            stmt.setInt(3, produit.getQuantite());
            stmt.setDouble(4, produit.getPrixUnitaire());
            stmt.setString(5, produit.getCategorie());
            stmt.setInt(6, produit.getId());
            rowUpdated = stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            printSQLException(e);
        }
        return rowUpdated;
    }

    // Supprimer un produit
    public boolean deleteProduct(int id) {
        boolean rowDeleted = false;
        try (Connection connection = getConnection(); PreparedStatement stmt = connection.prepareStatement(DELETE_PRODUCT)) {
            stmt.setInt(1, id);
            rowDeleted = stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            printSQLException(e);
        }
        return rowDeleted;
    }

    // Gérer les exceptions SQL
    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.err.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
