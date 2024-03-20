package Test;

import Interfaces.QueueBorneeRapide;
import org.junit.Test;
import static org.junit.Assert.*;


public class QueueBorneeRapideTest {

    @Test
    public void testCapacite() {
        QueueBorneeRapide queue = new QueueBorneeRapide(5);
        assertEquals(5, queue.capacite());
    }

    @Test
    public void testTailleVide() {
        QueueBorneeRapide queue = new QueueBorneeRapide(5);
        assertTrue(queue.estVide());
        assertEquals(0, queue.taille());
    }

    @Test
    public void testAjouteElement() {
        QueueBorneeRapide queue = new QueueBorneeRapide(5);
        queue.ajouteElement(10);
        assertFalse(queue.estVide());
        assertEquals(1, queue.taille());
    }

    @Test(expected = IllegalStateException.class)
    public void testAjouteElementQueuePleine() {
        QueueBorneeRapide queue = new QueueBorneeRapide(1);
        queue.ajouteElement(10);
        queue.ajouteElement(20);
    }

    @Test
    public void testSupprimeElement() {
        QueueBorneeRapide queue = new QueueBorneeRapide(5);
        queue.ajouteElement(10);
        int elementSupprime = queue.supprimeElement();
        assertEquals(10, elementSupprime);
        assertTrue(queue.estVide());
    }

    @Test(expected = IllegalStateException.class)
    public void testSupprimeElementQueueVide() {
        QueueBorneeRapide queue = new QueueBorneeRapide(5);
        queue.supprimeElement();
    }

    @Test
    public void testTeteQueueApresAjoutSuppression() {
        QueueBorneeRapide queue = new QueueBorneeRapide(3);
        queue.ajouteElement(10);
        queue.ajouteElement(20);
        queue.supprimeElement();
        assertEquals(20, queue.getQueue()[0]);
    }

}