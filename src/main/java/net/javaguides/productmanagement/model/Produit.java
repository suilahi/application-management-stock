package net.javaguides.productmanagement.model;

public class Produit {
    private int id;
    private String name;
    private String description;
    private int quantite;
    private double prixUnitaire;
    private String categorie;

    public Produit(String name, String description, int quantite, double prixUnitaire, String categorie) {
        this.name = name;
        this.description = description;
        this.quantite = quantite;
        this.prixUnitaire = prixUnitaire;
        this.categorie = categorie;
    }



    public Produit(int id, String name, String description, int quantite, double prixUnitaire, String categorie) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.quantite = quantite;
        this.prixUnitaire = prixUnitaire;
        this.categorie = categorie;
    }

    // Getters et Setters

    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getQuantite() {
        return quantite;
    }

    public double getPrixUnitaire() {
        return prixUnitaire;
    }
    public String getCategorie() {
        return categorie;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public void setPrixUnitaire(double prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }


    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    @Override
    public String toString() {
        return "Produit{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", quantite=" + quantite +
                ", prixUnitaire=" + prixUnitaire +
                ", categorie='" + categorie + '\'' +
                '}';
    }
}
