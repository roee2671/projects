package Mavo_Le_Hisuve.Ex3;

import Mavo_Le_Hisuve.Ex3.pdfUtils.BinaryTreeClass;
import Mavo_Le_Hisuve.Ex3.pdfUtils.MyList;
import Mavo_Le_Hisuve.Ex3.pdfUtils.MyListInterface;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class Ex3Test {

    @Test
    void q1() {
    }

    @Test
    void q2() {
    }

    @Test
    void q5() {
    }

    @Test
    public void testIsSet() {
        MyListInterface<Integer> list1 = new MyList<>();
        list1.addAt(1, 0);
        list1.addAt(2, 1);
        list1.addAt(3, 2);
        list1.addAt(4, 3);

        MyListInterface<Integer> list2 = new MyList<>();
        list2.addAt(1, 0);
        list2.addAt(2, 1);
        list2.addAt(2, 2);

        // Expecting true because there are no duplicates in list1
        assertTrue(Ex3.isSet(list1));

        // Expecting false because there is a duplicate (2) in list2
        assertFalse(Ex3.isSet(list2));
    }

    @Test
    public void testToSet() {
        MyListInterface<Integer> list1 = new MyList<>();
        list1.addAt(1, 0);
        list1.addAt(2, 1);
        list1.addAt(2, 2);
        list1.addAt(3, 3);

        MyListInterface<Integer> result1 = Ex3.toSet(list1);

        assertEquals(3, result1.size());
        assertTrue(result1.contains(1));
        assertTrue(result1.contains(2));
        assertTrue(result1.contains(3));

        MyListInterface<Integer> list2 = new MyList<>();
        list2.addAt(4, 0);
        list2.addAt(5, 1);

        MyListInterface<Integer> result2 = Ex3.toSet(list2);

        // Testing if the original list without duplicates stays the same
        assertEquals(2, result2.size());
        assertTrue(result2.contains(4));
        assertTrue(result2.contains(5));

        MyListInterface<Integer> list3 = new MyList<>();
        list3.addAt(1, 0);
        list3.addAt(2, 1);
        list3.addAt(4, 2);

        MyListInterface<Integer> result3 = Ex3.toSet(list3);

        assertEquals(3, result3.size());
        assertTrue(result3.contains(1));
        assertTrue(result3.contains(2));
        assertTrue(result3.contains(4));
    }

    @Test
    public void testIntersect() {
        MyListInterface<Integer> list1 = new MyList<>();
        list1.addAt(1, 0);
        list1.addAt(2, 1);
        list1.addAt(3, 2);

        MyListInterface<Integer> list2 = new MyList<>();
        list2.addAt(2, 0);
        list2.addAt(3, 1);
        list2.addAt(4, 2);

        MyListInterface<Integer> result = Ex3.intersect(list1, list2);

        // Checking if only common elements are in the intersection
        assertEquals(2, result.size());
        assertTrue(result.contains(2));
        assertTrue(result.contains(3));

        MyListInterface<Integer> list3 = new MyList<>();
        list3.addAt(5, 0);
        list3.addAt(6, 1);

        MyListInterface<Integer> result2 = Ex3.intersect(list1, list3);

        // Testing case where no common elements are found
        assertEquals(0, result2.size());
    }

    @Test
    public void testUnion() {
        MyListInterface<Integer> list1 = new MyList<>();
        list1.addAt(1, 0);
        list1.addAt(2, 1);

        MyListInterface<Integer> list2 = new MyList<>();
        list2.addAt(2, 0);
        list2.addAt(3, 1);

        MyListInterface<Integer> result = Ex3.union(list1, list2);

        assertEquals(3, result.size());
        assertTrue(result.contains(1));
        assertTrue(result.contains(2));
        assertTrue(result.contains(3));

        MyListInterface<Integer> list3 = new MyList<>();
        list3.addAt(4, 0);

        MyListInterface<Integer> result2 = Ex3.union(list1, list3);

        assertEquals(3, result2.size());
        assertTrue(result2.contains(1));
        assertTrue(result2.contains(2));
        assertTrue(result2.contains(4));
    }
    @Test
    public void testQ7() {
        MyListInterface<Object> list = new MyList<Object>();
        list.addAt((Object) 1, 0);
        list.addAt((Object) "fghfhg", 1);
        list.addAt((Object) 5.4, 2);
        list.addAt((Object) 5.2, 3);
        list.addAt((Object) 5, 4);

        int result = Ex3.Q7(list);
        assertEquals(3, result);
    }

    @Test
    public void testQ9() {
        // יצירת עץ בינארי
        BinaryTreeClass<Integer> tree = new BinaryTreeClass<>();
        tree.setRoot(1); // השורש הוא 1

        // תת-עץ שמאלי
        BinaryTreeClass<Integer> leftSubTree = new BinaryTreeClass<>();
        leftSubTree.setRoot(2);

        // תת-עץ ימני
        BinaryTreeClass<Integer> rightSubTree = new BinaryTreeClass<>();
        rightSubTree.setRoot(3);

        tree.setLeft(leftSubTree);
        tree.setRight(rightSubTree);

        // עלים לתת-עץ שמאלי
        BinaryTreeClass<Integer> leftLeaf1 = new BinaryTreeClass<>();
        leftLeaf1.setRoot(4);

        BinaryTreeClass<Integer> leftLeaf2 = new BinaryTreeClass<>();
        leftLeaf2.setRoot(5);

        leftSubTree.setLeft(leftLeaf1);
        leftSubTree.setRight(leftLeaf2);

        // בדיקה: חישוב עלים בין רמה 1 ל-3 (לא כולל 3)
        int result = Ex3.q9(tree, 1, 3);
        System.out.println("Number of leaves between levels 1 and 3: " + result);
        assertEquals(2, result); // ציפייה לשני עלים: 4 ו-5
    }
    @Test
    public void testq10() {
        BinaryTreeClass<Integer> tree = new BinaryTreeClass<>();
        tree.setRoot(1);

        // תת-עץ שמאלי
        BinaryTreeClass<Integer> leftSubTree = new BinaryTreeClass<>();
        leftSubTree.setRoot(2);

        // תת-עץ ימני
        BinaryTreeClass<Integer> rightSubTree = new BinaryTreeClass<>();
        rightSubTree.setRoot(3);

        // חיבור תתי-עץ לשורש
        tree.setLeft(leftSubTree);
        tree.setRight(rightSubTree);

        // עלים לתת-עץ שמאלי
        BinaryTreeClass<Integer> leftLeaf1 = new BinaryTreeClass<>();
        leftLeaf1.setRoot(4);

        BinaryTreeClass<Integer> leftLeaf2 = new BinaryTreeClass<>();
        leftLeaf2.setRoot(5);

        leftSubTree.setLeft(leftLeaf1);
        leftSubTree.setRight(leftLeaf2);

        // קריאה לפונקציה q10
        ArrayList<Integer> leaves = Ex3.q10(tree);

        // הדפסת התוצאה לבדיקה
        System.out.println("Leaves in InOrder: " + leaves);

        // בדיקת התוצאה
        assertEquals(Arrays.asList(4, 5, 3), leaves); // ציפייה לסדר: 4, 2, 5, 1, 3
    }


    @Test
    public void testQ10() {
    }

    @Test
    void q12() {
    }

    @Test
    void testQ12() {
    }
    @Test
    public void testAllCodes() {
        String[] expectedCodes = {
                "1234#", "1235#", "1243#", "1245#", "1253#", "1254#",
                "1324#", "1325#", "1342#", "1345#", "1352#", "1354#",
                "1423#", "1425#", "1432#", "1435#", "1452#", "1453#",
                "1523#", "1524#", "1532#", "1534#", "1542#", "1543#",
                "2134#", "2135#", "2143#", "2145#", "2153#", "2154#",
                "2314#", "2315#", "2341#", "2345#", "2351#", "2354#",
                "2413#", "2415#", "2431#", "2435#", "2451#", "2453#",
                "2513#", "2514#", "2531#", "2534#", "2541#", "2543#",
                "3124#", "3125#", "3142#", "3145#", "3152#", "3154#",
                "3214#", "3215#", "3241#", "3245#", "3251#", "3254#",
                "3412#", "3415#", "3421#", "3425#", "3451#", "3452#",
                "3512#", "3514#", "3521#", "3524#", "3541#", "3542#",
                "4123#", "4125#", "4132#", "4135#", "4152#", "4153#",
                "4213#", "4215#", "4231#", "4235#", "4251#", "4253#",
                "4312#", "4315#", "4321#", "4325#", "4351#", "4352#",
                "4512#", "4513#", "4521#", "4523#", "4531#", "4532#",
                "5123#", "5124#", "5132#", "5134#", "5142#", "5143#",
                "5213#", "5214#", "5231#", "5234#", "5241#", "5243#",
                "5312#", "5314#", "5321#", "5324#", "5341#", "5342#",
                "5412#", "5413#", "5421#", "5423#", "5431#", "5432#"
        };

        // שליפת הקודים מתוך הפונקציה
        String[] actualCodes = Ex3.allCodes();

        // השוואת המערכים
        assertArrayEquals(expectedCodes, actualCodes);
    }
}