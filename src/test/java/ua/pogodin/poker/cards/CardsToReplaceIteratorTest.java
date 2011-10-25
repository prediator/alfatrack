package ua.pogodin.poker.cards;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CardsToReplaceIteratorTest {

    @Test(enabled = false)
    public void iteratorTest() throws Exception {
        CardsToReplaceIterator iterator = new CardsToReplaceIterator();
        assertTrue(iterator.hasNext());
        assertEquals(iterator.next(), new int[]{0});
        assertTrue(iterator.hasNext());
        assertEquals(iterator.next(), new int[]{1});
        assertTrue(iterator.hasNext());
        assertEquals(iterator.next(), new int[]{2});
        assertTrue(iterator.hasNext());
        assertEquals(iterator.next(), new int[]{3});
        assertTrue(iterator.hasNext());
        assertEquals(iterator.next(), new int[]{4});
        assertTrue(iterator.hasNext());
        assertEquals(iterator.next(), new int[]{0, 1});
        assertTrue(iterator.hasNext());
        assertEquals(iterator.next(), new int[]{0, 2});
        assertTrue(iterator.hasNext());
        assertEquals(iterator.next(), new int[]{0, 3});
        assertTrue(iterator.hasNext());
        assertEquals(iterator.next(), new int[]{0, 4});
        assertTrue(iterator.hasNext());
        assertEquals(iterator.next(), new int[]{1, 2});
        assertTrue(iterator.hasNext());
        assertEquals(iterator.next(), new int[]{1, 3});
        assertTrue(iterator.hasNext());
        assertEquals(iterator.next(), new int[]{1, 4});
        assertTrue(iterator.hasNext());
        assertEquals(iterator.next(), new int[]{2, 3});
        assertTrue(iterator.hasNext());
        assertEquals(iterator.next(), new int[]{2, 4});
        assertTrue(iterator.hasNext());
        assertEquals(iterator.next(), new int[]{3, 4});
        assertTrue(iterator.hasNext());
        assertEquals(iterator.next(), new int[]{0, 1, 2});
    }

    @Test
    public void testName() throws Exception {
        int len = 5;
        for (int a = 0; a < len; a++) {
            System.out.println("    a =     " + a );
            for (int b = 0; b < a; b++) {
                System.out.println("   ba =    " + b + a );
                for (int c = 0; c < b; c++) {
                    System.out.println("  cba =   " + c + b + a );
                    for (int d = 0; d < c; d++) {
                        System.out.println(" dcba =  " + d + c + b + a );
                        for (int e = 0; e < d; e++) {
                            System.out.println("edcba = " + e + d + c + b + a );
                        }
                    }
                }
            }
        }
    }
}
