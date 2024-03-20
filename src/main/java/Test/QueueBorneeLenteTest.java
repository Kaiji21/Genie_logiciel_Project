package Test;

import Interfaces.QueueBorneeLente;
import org.junit.Test;

import static org.junit.Assert.*;

public class QueueBorneeLenteTest {

    @Test
    public void testCapacite() {
        QueueBorneeLente queue = new QueueBorneeLente(5);
        assertEquals(5, queue.capacite());
    }

    @Test
    public void testTailleVide() {
        QueueBorneeLente queue = new QueueBorneeLente(5);
        assertTrue(queue.estVide());
        assertEquals(0, queue.taille());
    }

    @Test
    public void testAjouteElement() {
        QueueBorneeLente queue = new QueueBorneeLente(5);
        queue.ajouteElement(10);
        assertFalse(queue.estVide());
        assertEquals(1, queue.taille());
    }

    @Test(expected = IllegalStateException.class)
    public void testAjouteElementQueuePleine() {
        QueueBorneeLente queue = new QueueBorneeLente(1);
        queue.ajouteElement(10);
        queue.ajouteElement(20); // Exception lancée ici
    }

    @Test
    public void testSupprimeElement() {
        QueueBorneeLente queue = new QueueBorneeLente(5);
        queue.ajouteElement(10);
        int elementSupprime = queue.supprimeElement();
        assertEquals(10, elementSupprime);
        assertTrue(queue.estVide());
    }

    @Test(expected = IllegalStateException.class)
    public void testSupprimeElementQueueVide() {
        QueueBorneeLente queue = new QueueBorneeLente(5);
        queue.supprimeElement(); // Exception lancée ici
    }


    @Test
    public void testTeteApresAjoutSuppressionMultiple() {
        QueueBorneeLente queue = new QueueBorneeLente(3);
        queue.ajouteElement(10);
        queue.ajouteElement(20);
        queue.supprimeElement();
        queue.ajouteElement(30);
        assertEquals(20, queue.getQueueArray()[queue.getHead()]);
    }

    @Test
    public void testSuppressionCirculaire() {
        QueueBorneeLente queue = new QueueBorneeLente(3);
        queue.ajouteElement(10);
        queue.ajouteElement(20);
        queue.ajouteElement(30);
        queue.supprimeElement();
        queue.supprimeElement();
        queue.ajouteElement(40);
        assertEquals(40, queue.getQueueArray()[queue.getHead()]);
    }

}