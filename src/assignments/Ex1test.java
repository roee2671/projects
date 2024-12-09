package assignments;
import assignments.Ex1;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This JUnit class represents a very partial test class for Ex1.
 * Make sure you complete all the needed JUnits
 */
public class Ex1test {
    @Test
    void computeNumberTest() {
        String s2 = "1011b2";
        int v = Ex1.number2Int(s2);
        assertEquals(v,11);
        String s10 = "1011bA";
        v = Ex1.number2Int(s10);
        s2 = Ex1.int2Number(v,2);
        int v2 = Ex1.number2Int(s2);
        assertEquals(v,v2);
        assertTrue(Ex1.equals(s10,s2));
    }

    @Test
    void isBasisNumberTest() {
        String[] good = {"1", "1b2", "01b2", "123bA", "ABbG", "0bA", "135", "100111b2", "12345b6", "012b5", "EFbG"};
        for(int i=0;i<good.length;i=i+1) {
            boolean ok = Ex1.isNumber(good[i]);
            assertTrue(ok);
        }
        String[] not_good = {"b2", "2b2", "1G3bG", " BbG", "0bbA", "abB", "!@b2", "A", "0b1", "123b", "1234b11", "-3b5", "3 b4", "GbG", "", null};
        for(int i=0;i<not_good.length;i=i+1) {
            boolean not_ok = Ex1.isNumber(not_good[i]);
            assertFalse(not_ok);
        }
    }
    @Test
    void int2NumberTest() {
        // implement this test
        assertEquals("10011b2", Ex1.int2Number(19, 2));
        assertEquals("15bA", Ex1.int2Number(15, 10));
        assertEquals("2b3", Ex1.int2Number(2, 3));
        assertEquals("", Ex1.int2Number(-1, 10));
        assertEquals("", Ex1.int2Number(10, 1));
    }
    @Test
    void maxIndexTest() {
        // implement this test
        String[] arr1 = {"101b2", "110b2", "111b2"};
        assertEquals(2, Ex1.maxIndex(arr1));
        String[] arr2 = {"10bA", "20bA", "15bA", "15bA"};
        assertEquals(1, Ex1.maxIndex(arr2));
        String[] arr3 = {"100b2", "100b2", "100b2"};
        assertEquals(0, Ex1.maxIndex(arr3));
    }
    @Test
    void isnumber() {
        assertFalse(Ex1.isNumber("0b1"));
        assertFalse(Ex1.isNumber(" 2b2"));
        assertFalse(Ex1.isNumber("GbG"));

    }

    // Add additional test functions - test as much as you can.
}
