package Test;

import Interfaces.QueueBorneeInteger;
import org.junit.Test;
import static org.junit.Assert.*;

public class QueueBorneeIntegerTest {

    @Test
    public void testCapacite() {
        QueueBorneeInteger queue = new QueueBorneeInteger(5);
        assertEquals(5, queue.capacite());
    }

    @Test
    public void testTailleVide() {
        QueueBorneeInteger queue = new QueueBorneeInteger(5);
        assertTrue(queue.estVide());
        assertEquals(0, queue.taille());
    }

    @Test
    public void testAjouteElement() {
        QueueBorneeInteger queue = new QueueBorneeInteger(5);
        queue.ajouteElement(10);
        assertFalse(queue.estVide());
        assertEquals(1, queue.taille());
    }

    @Test(expected = IllegalStateException.class)
    public void testAjouteElementQueuePleine() {
        QueueBorneeInteger queue = new QueueBorneeInteger(1);
        queue.ajouteElement(10);
        queue.ajouteElement(20); // Exception lancée ici
    }

    @Test
    public void testSupprimeElement() {
        QueueBorneeInteger queue = new QueueBorneeInteger(5);
        queue.ajouteElement(10);
        int elementSupprime = queue.supprimeElement();
        assertEquals(10, elementSupprime);
        assertTrue(queue.estVide());
    }

    @Test(expected = IllegalStateException.class)
    public void testSupprimeElementQueueVide() {
        QueueBorneeInteger queue = new QueueBorneeInteger(5);
        queue.supprimeElement(); // Exception lancée ici
    }

}