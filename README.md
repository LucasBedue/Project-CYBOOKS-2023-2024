# Project-CYBOOKS-2023-2024
Project CYBOOKS 2023 2024 by Lucas Bédué, Mathiass Galisson, Audrey Truong, Maxime Dubin-Massé and Baptiste Moisseron

Bienvenue dans l'application de gestion de bibliothèque. Cette application offre une interface utilisateur intuitive permettant aux libraires de gérer les utilisateurs et les livres empruntés. Voici un aperçu des fonctionnalités disponibles et de leur utilisation.

Lancement et installation:

Télécharger puis lancer CY-Books/src/main/java/com/example/cybooks/CYBooks.java

Fonctionnalités de l'application

1. Enregistrement d'un utilisateur (Register a user)

        Cette fonctionnalité permet d'ajouter un nouvel utilisateur à la base de données.
        Procédure:

            Remplissez les informations nécessaires de l'utilisateur (prénom, nom de famille, adresse, date de naissance).
            Cliquez sur "Enregistrer".
            Si les informations sont correctes et que l'utilisateur n'existe pas déjà, il sera ajouté à la base de données.
            Si un utilisateur avec les mêmes prénom, nom, adresse et date de naissance existe déjà, un message d'erreur s'affichera.

2. Liste des utilisateurs (User list)

   Cette page affiche la liste de tous les utilisateurs enregistrés ainsi que leurs informations.
   Informations affichées:

            ID
            Nom de famille
            Prénom
            E-mail
            Numéro de téléphone
            Adresse
            Nombre de livres actuellement empruntés

   Des boutons "Page précédente" et "Page suivante" permettent de naviguer à travers la liste des utilisateurs.

3. Modification d'un utilisateur (Modify user)

   Cette fonctionnalité permet de modifier les informations d'un utilisateur existant.
        Procédure:

            Saisissez l'ID de l'utilisateur à modifier.
            Si l'ID n'existe pas, un message d'erreur s'affichera.
            Si l'ID existe, les informations actuelles de l'utilisateur seront affichées.
            Modifiez les champs nécessaires et validez pour mettre à jour les informations dans la base de données.

4. Historique des utilisateurs (Check user history)

Cette page permet d'afficher l'historique des emprunts d'un utilisateur.
Procédure:

            Entrez l'ID de l'utilisateur.
            L'historique des emprunts sera affiché.

5. Recherche d'un utilisateur (Search user)

Cette fonctionnalité permet d'afficher plus d'informations sur un utilisateur ainsi que les livres qu'il emprunte actuellement.
Procédure:

            Entrez l'ID de l'utilisateur.
            Les informations détaillées et les livres empruntés par cet utilisateur seront affichés.

6. Recherche de livres (Book search)

Cette fonctionnalité permet de rechercher des livres via une requête API auprès de la Bibliothèque nationale de France (BNF).
Procédure:

            Entrez les informations de recherche dans les champs appropriés.
            Cliquez sur "Rechercher" pour obtenir les résultats.
            Vous pouvez emprunter un livre depuis cette interface en entrant l'ID du client.

7. Livres empruntés (Borrowed book)

   Cette page affiche tous les livres actuellement empruntés via une requête SQL auprès de la table "borrows".
   Fonctions supplémentaires:

            Retourner un livre

   Conclusion

L'application de gestion de bibliothèque est conçue pour faciliter la gestion des utilisateurs et des emprunts de livres. Chaque fonctionnalité est accessible via une interface utilisateur simple et efficace, permettant aux libraires de gérer leur bibliothèque de manière optimale.
