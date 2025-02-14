<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>StockMaster</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body id="main-body" class="bg-gray-100 p-6">

<!-- Product Form -->


<!-- Product List -->
<div class="max-w-4xl mx-auto mt-6 bg-white p-6 rounded-lg shadow-md">
    <h2 class="text-xl font-bold mb-4">Liste des Produits</h2>
    <table class="w-full border border-gray-300">
        <thead>
        <tr class="bg-gray-200">
            <th class="border p-2">ID</th>
            <th class="border p-2">Nom</th>
            <th class="border p-2">Description</th>
            <th class="border p-2">Quantité</th>
            <th class="border p-2">Prix</th>
            <th class="border p-2">Catégorie</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="produit" items="${produits}">
            <tr>
                <td class="border p-2"><c:out value="${produit.id}" /></td>
                <td class="border p-2"><c:out value="${produit.name}" /></td>
                <td class="border p-2"><c:out value="${produit.description}" /></td>
                <td class="border p-2"><c:out value="${produit.quantite}" /></td>
                <td class="border p-2"><c:out value="${produit.prixUnitaire}" /></td>
                <td class="border p-2"><c:out value="${produit.categorie}" /></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>
