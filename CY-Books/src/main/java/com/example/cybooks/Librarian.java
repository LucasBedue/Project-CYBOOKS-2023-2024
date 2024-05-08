package com.example.cybooks;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Librarian extends Person {
    
    private List<User> users; // Liste des utilisateurs
    
    // Constructeur
    public Librarian(int ID, String lastName, String firstName, String mail, double telephone, String address) {
        super(ID, lastName, firstName, mail, telephone, address);
        this.users = new ArrayList<>();
    }

    // Méthode pour inscrire un nouvel utilisateur
    public void InscriptionUser(User user) {
        // Ajouter l'utilisateur à la liste des utilisateurs
        users.add(user);
        System.out.println("New user registered: " + user.getFirstName() + " " + user.getLastName());
    }
    
    // Méthode pour afficher la liste des utilisateurs
    public void ListeUser() {
        // Afficher la liste des utilisateurs
        System.out.println("List of Users:");
        for (User user : users) {
            System.out.println(user.getFirstName() + " " + user.getLastName());
        }
    }
}
