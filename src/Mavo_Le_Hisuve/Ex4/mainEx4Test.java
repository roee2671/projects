package Mavo_Le_Hisuve.Ex4;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertTrue;

class mainEx4Test {
    @Test
    void maxSTest(){
        boolean ans = true;
        int[] arr1 = new int[4];
        arr1[0] = 0;
        arr1[1] = 0;
        arr1[2] = 0;
        arr1[3] = 0;
        int[] ansArr1 = new int[4];
        ansArr1 = mainEx4.maxS(arr1);
        for (int i = 0; i < ansArr1.length; i++) {
            if (ans != true || ansArr1[i] != arr1[i]) {
                ans = false;
            }
        }
        assertTrue(ans);
        boolean ans2 = true;
        int[] arr2 = {5,1,3,5,8};
        int[] ansArr2 = mainEx4.maxS(arr2);
        for (int t = 0; t < ansArr2.length; t++) {
            if (ans2 != true || ansArr2[t] != arr2[t+1]) {
                ans2 = false;
            }
        }
        assertTrue(ans2);
    }
}