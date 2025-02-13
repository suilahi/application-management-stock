package net.javaguides.productmanagement.dao;

import net.javaguides.productmanagement.model.produit;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class produitDao {
    private String jdbcURL = "jdbc:mysql://localhost:3306/stockmaster";
    private String jdbcUser = "root";  // Mettez votre utilisateur MySQL
    private String jdbcPassword = "admin";  // Mettez votre mot de passe MySQL

    private static final String INSERT_PRODUCT = "INSERT INTO products (name, description, quantity, price, category) VALUES (?, ?, ?, ?, ?)";
    private static final String SELECT_ALL_PRODUCTS = "SELECT * FROM products";


    // Connexion à la BD
    protected Connection getConnection() {
        try {
            return DriverManager.getConnection(jdbcURL, jdbcUser, jdbcPassword);
        } catch (SQLException e) {
            throw new RuntimeException("Erreur de connexion à la base de données", e);
        }
    }

    // Ajouter un produit
    public void addProduct(produit produit) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement stmt = connection.prepareStatement(INSERT_PRODUCT)) {
            stmt.setString(1, produit.getName());
            stmt.setString(2, produit.getDescription());
            stmt.setInt(3, produit.getQuantite());
            stmt.setDouble(4, produit.getPrixUnitaire());
            stmt.setString(5, produit.getCategorie());
            stmt.executeUpdate();
        }
    }
    public List<produit> getAllProducts() throws SQLException {
        List<produit> products = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement stmt = connection.prepareStatement(SELECT_ALL_PRODUCTS);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                products.add(new produit(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getInt("quantity"),
                        rs.getDouble("prixUnitaire"),
                        rs.getString("category")
                ));
            }
        }
        return products;
    }
}
