package Interfaces;

class QueueBorneeRapide implements QueueBorneeIntegerInterface {
    private int capacite;
    private int[] queue;
    private int taille;

    public QueueBorneeRapide(int capacite) {
        this.capacite = capacite;
        this.queue = new int[capacite];
        this.taille = 0;
    }

    @Override
    public int capacite() {
        return capacite;
    }

    @Override
    public int taille() {
        return taille;
    }

    @Override
    public boolean estVide() {
        return taille == 0;
    }

    @Override
    public boolean estPleine() {
        return taille == capacite;
    }

    @Override
    public void ajouteElement(int element) throws IllegalStateException {
        if (estPleine()) {
            throw new IllegalStateException("La queue est pleine.");
        }
        queue[taille] = element;
        taille++;
    }

    @Override
    public int supprimeElement() throws IllegalStateException {
        if (estVide()) {
            throw new IllegalStateException("La queue est vide.");
        }
        int elementSupprime = queue[0];
        for (int i = 0; i < taille - 1; i++) {
            queue[i] = queue[i + 1];
        }
        taille--;
        return elementSupprime;
    }
}
