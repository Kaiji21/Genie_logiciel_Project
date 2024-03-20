package Interfaces;

import java.util.ArrayList;

public class QueueBorneeInteger implements QueueBorneeIntegerInterface {
    private int capacite;
    private ArrayList<Integer> queue;

    public QueueBorneeInteger(int capacite) {
        if (capacite < 0) {
            throw new IllegalArgumentException("La capacité doit être supérieure ou égale à zéro");
        }
        this.capacite = capacite;
        this.queue = new ArrayList<>();
    }

    @Override
    public int capacite() {
        return capacite;
    }

    @Override
    public int taille() {
        return queue.size();
    }

    @Override
    public boolean estVide() {
        return queue.isEmpty();
    }

    @Override
    public boolean estPleine() {
        return queue.size() == capacite;
    }

    @Override
    public void ajouteElement(int element) throws IllegalStateException {
        if (estPleine()) {
            throw new IllegalStateException("La queue est pleine");
        }
        queue.add(element);
    }

    @Override
    public int supprimeElement() throws IllegalStateException {
        if (estVide()) {
            throw new IllegalStateException("La queue est vide");
        }
        return queue.remove(0);
    }
}