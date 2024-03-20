package Interfaces;

public class QueueBorneeLente implements QueueBorneeIntegerInterface {
    private int[] queueArray;
    private int head;
    private int queue;
    private int size;
    private int capacity;

    public int[] getQueueArray() {
        return queueArray;
    }

        public int getHead() {
        return head;
    }

    public QueueBorneeLente(int capacite) {
        if (capacite < 0) {
            throw new IllegalArgumentException("La capacité doit être supérieure ou égale à zéro");
        }
        this.capacity = capacite;
        this.queueArray = new int[capacite];
        this.head = 0;
        this.queue = 0;
        this.size = 0;
    }

    @Override
    public int capacite() {
        return capacity;
    }

    @Override
    public int taille() {
        return size;
    }

    @Override
    public boolean estVide() {
        return size == 0;
    }

    @Override
    public boolean estPleine() {
        return size == capacity;
    }

    @Override
    public void ajouteElement(int element) throws IllegalStateException {
        if (estPleine()) {
            throw new IllegalStateException("La queue est pleine");
        }
        queueArray[queue] = element;
        queue = (queue + 1) % capacity;
        size++;
    }

    @Override
    public int supprimeElement() throws IllegalStateException {
        if (estVide()) {
            throw new IllegalStateException("La queue est vide");
        }
        int removedElement = queueArray[head];
        head = (head + 1) % capacity;
        size--;
        return removedElement;
    }
}