<%--
  Created by IntelliJ IDEA.
  User: suila
  Date: 14/02/2025
  Time: 17:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <script src="https://cdn.tailwindcss.com"></script>
    <title>Ajoute produit</title>
</head>
<body>
<div id="product-form-container" class="max-w-3xl mx-auto bg-white p-6 rounded-lg shadow-md">
  <form id="product-form" action="/untitled2/ajouter" method="POST" class="space-y-4">
    <input type="text" name="name" placeholder="Nom du produit" class="w-full p-2 border rounded" required>
    <textarea name="description" placeholder="Description" class="w-full p-2 border rounded"></textarea>
    <input type="number" name="quantite" placeholder="Quantité en stock" class="w-full p-2 border rounded" min="0" required>
    <input type="number" name="prixUnitaire" placeholder="Prix unitaire" class="w-full p-2 border rounded" min="0" step="0.01" required>
    <select name="categorie" class="w-full p-2 border rounded" required>
      <option value="">Sélectionner</option>
      <option value="Electronique">Électronique</option>
      <option value="Vetements">Vêtements</option>
      <option value="Alimentation">Alimentation</option>
    </select>
    <button type="submit" class="w-32 bg-blue-500 text-white p-2 text-center rounded">Ajouter</button>
  </form>
</div>
</body>
</html>
