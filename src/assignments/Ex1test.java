package assignments;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
        String[] good = {"1", "1b2", "01b2", "123bA", "ABbG", "0bA"};
        for(int i=0;i<good.length;i=i+1) {
            boolean ok = Ex1.isNumber(good[i]);
            assertTrue(ok);
        }
        String[] not_good = {"b2", "2b2", "1G3bG", " BbG", "0bbA", "abB", "!@b2", "A", "1bb2"};
        for(int i=0;i<not_good.length;i=i+1) {
            boolean not_ok = Ex1.isNumber(not_good[i]);
            assertFalse(not_ok);
        }
    }
    @Test
    void int2NumberTest() {
        assertEquals("10011b2", Ex1.int2Number(19, 2));
        assertEquals("15bA", Ex1.int2Number(15, 10));
        assertEquals("2b3", Ex1.int2Number(2, 3));
        assertEquals("", Ex1.int2Number(-1, 10));
        assertEquals("", Ex1.int2Number(10, 1));
    }

    @Test
    void maxIndexTest() {
        String[] arr1 = {"5", "8", "111b3", "1111b3"};
        assertEquals(3, Ex1.maxIndex(arr1));

        String[] arr2 = {"15bA", "15bB", "15bC", "15bD", "15bE", "15bF", "15bG"};
        assertEquals(6, Ex1.maxIndex(arr2));

        String[] arr3 = {"10b2", "10b3", "10b4", "10b5", "10b6", "10b7", "10b8", "10b9"};
        assertEquals(7, Ex1.maxIndex(arr3));

        String[] arr4 = {"100b2", "100b2", "100b2"};
        assertEquals(0, Ex1.maxIndex(arr4));
    }

    @Test
    void isNumberTest() {
        String[] good = {"135bA", "135", "100111b2", "12345b6", "012b5", "123bG", "EFbG", "1E2bG", "ABCbF"};
        for(int i=0;i<good.length;i=i+1) {
            boolean ok = Ex1.isNumber(good[i]);
            assertTrue(ok);
        }
        String[] not_good = {"b2", "0b1", "123b", "8bb2", "1234b11", "3b3", "-3b5", "3 b4", "GbG", "", null};
        for(int i=0;i<not_good.length;i=i+1) {
            boolean not_ok = Ex1.isNumber(not_good[i]);
            assertFalse(not_ok);
        }
    }

    @Test
    void number2IntTest() {
        String n1 = "1E2bG";
        int v1 = Ex1.number2Int(n1);
        assertEquals(v1, 482);

        String n2 = "ABCbF";
        int v2 = Ex1.number2Int(n2);
        assertEquals(v2, 2427);

        String n3 = "111b3";
        int v3 = Ex1.number2Int(n3);
        assertEquals(v3, 13);
    }

    @Test
    void toDecimalTest() {
        String n1 = "1E2";
        int v1 = Ex1.toDecimal(n1, 16);
        assertEquals(v1, 482);

        String n2 = "CBA";
        int v2 = Ex1.toDecimal(n2, 15);
        assertEquals(v2, 2875);

        String n3 = "0";
        int v3 = Ex1.toDecimal(n3, 5);
        assertEquals(v3, 0);
    }

    @Test
    void toDecimalEdgeCases() {
        String n1 = "F";
        int v = Ex1.toDecimal(n1, 16);
        assertEquals(v, 15);

        String n2 = "10";
        int v2 = Ex1.toDecimal(n2, 2);
        assertEquals(v2, 2);

        String n3 = "1111111111";
        int v3 = Ex1.toDecimal(n3, 10);
        assertEquals(v3, 1111111111);
    }

    @Test
    void number2IntEdgeCases() {
        String n1 = "1bG";
        int v = Ex1.number2Int(n1);
        assertEquals(v, 1);

        String n2 = "AAbF";
        int v2 = Ex1.number2Int(n2);
        assertEquals(v2, 160);

        String n3 = "0b5";
        int v3 = Ex1.number2Int(n3);
        assertEquals(v3, 0);

        String n4 = "273";
        int v4 = Ex1.number2Int(n4);
        assertEquals(v4, 273);
    }
}
