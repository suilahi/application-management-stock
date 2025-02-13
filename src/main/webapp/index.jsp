
<!DOCTYPE html>
<html lang="fr">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>StockMaster</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body id="main-body" class="bg-gray-100 p-6">
<div id="product-form-container" class="max-w-3xl mx-auto bg-white p-6 rounded-lg shadow-md">
    <form id="product-form" class="space-y-4">
        <input type="number" id="id" placeholder="ID du produit" class="w-full p-2 border rounded" required>
        <input type="text" id="name" placeholder="Nom du produit" class="w-full p-2 border rounded" required>
        <textarea id="description" placeholder="Description" class="w-full p-2 border rounded"></textarea>
        <input type="number" id="quantity" placeholder="Quantite en stock" class="w-full p-2 border rounded" min="0" required>
        <input type="number" id="price" placeholder="Prix unitaire" class="w-full p-2 border rounded" min="0" step="0.01" required>
        <select id="category" class="w-full p-2 border rounded" required>
            <option value="">Selectionner</option>
            <option value="Electronique">Electronique</option>
            <option value="Vetements">Vetements</option>
            <option value="Alimentation">Alimentation</option>
        </select>
        <button type="submit" id="add-product-button" class="w-32 bg-blue-500 text-white p-2 text-center rounded ">Ajouter</button>
    </form>
</div>

<div class="max-w-4xl mx-auto mt-6 bg-white p-6 rounded-lg shadow-md">
    <h2 class="text-xl font-bold mb-4">Liste des Produits</h2>
    <table class="w-full border border-gray-300">
        <thead>
        <tr class="bg-gray-200">
            <th class="border p-2">ID</th>
            <th class="border p-2">Nom</th>
            <th class="border p-2">Description</th>
            <th class="border p-2">Quantite</th>
            <th class="border p-2">Prix</th>
            <th class="border p-2">Categorie</th>
        </tr>
        </thead>
    </table>
</div>

</body>
</html>
