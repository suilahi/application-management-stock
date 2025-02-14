package net.javaguides.productmanagement.web;

import net.javaguides.productmanagement.model.Produit;
import net.javaguides.productmanagement.dao.ProduitDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;



public class ProduitServlet extends HttpServlet {
    private static final long serialVersionUID = 1;
    ProduitDao produitDao ;

    public void init() {
        produitDao = new ProduitDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Produit> produits = produitDao.getAllProducts();

        for (Produit produit : produits) {
            System.out.println("The list"+produit);

        }
        request.setAttribute("produit", produits);
        RequestDispatcher rd = request.getRequestDispatcher("produits.jsp");


        rd.forward(request, response);
    }

    private void INSERT_PRODUCT(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        try {
            String name = request.getParameter("name");
            String description = request.getParameter("description");
            int quantite = Integer.parseInt(request.getParameter("quantite"));
            double prixUnitaire = Double.parseDouble(request.getParameter("prixUnitaire"));
            String categorie = request.getParameter("categorie");

            // Create a new product object
            Produit newProduct = new Produit(name, description, quantite, prixUnitaire, categorie);

            // Insert product into database
            produitDao.addProduct(newProduct);

            // Redirect to the product list
            response.sendRedirect("produits.jsp");
        } catch (NumberFormatException e) {
            e.printStackTrace(); // Log the error
            response.sendRedirect("errorPage.jsp?error=Invalid+Input");
        }
    }


}

