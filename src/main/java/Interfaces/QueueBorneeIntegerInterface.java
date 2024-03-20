package Interfaces;

public interface QueueBorneeIntegerInterface {
    int capacite();
    int taille();
    boolean estVide();
    boolean estPleine();
    void ajouteElement(int element) throws IllegalStateException;
    int supprimeElement() throws IllegalStateException;
}