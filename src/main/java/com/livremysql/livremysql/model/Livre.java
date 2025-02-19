package com.livremysql.livremysql.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity//précise que c'est une entité => ajoute le @Id pour identitifier la classe
@Table(name = "livre") //au cas ou dans la bdd la table porte un autre nom
public class Livre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//la bdd va devoir incrémenter toute seul les enregistrements
    private Long id;
    //le lien entre la bdd le nom de la colone et celui de la classe
    @Column(name="titre")
    private String titre;
    @Column(name="description")
    private String description;
    @Column(name="date_publication")
    private String datePublication;

    //joiture table auteur 
    @ManyToOne
    @JoinColumn(name = "auteur_id")
    private Auteur auteur;

    public Auteur getAuteur() {
        return auteur;
    }

    public void setAuteur(Auteur auteur) {
        this.auteur = auteur;
    }
///////////////////////////////////////////////////////////
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitre() {
        return this.titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDatePublication() {
        return this.datePublication;
    }

    public void setDatePublication(String datePublication) {
        this.datePublication = datePublication;
    }

    public Livre(String titre, String description, String datePublication) { 
        this.titre = titre;
        this.description = description;
        this.datePublication = datePublication;
    }

    public Livre() {
    }

    @Override
    public String toString() {
        return "{" +
        
            ", titre='" + getTitre() + "'" +
            ", description='" + getDescription() + "'" +
            ", datePublication='" + getDatePublication() + "'" +
            "}";
    }
    

}