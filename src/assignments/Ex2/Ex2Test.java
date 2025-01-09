package assignments.Ex2;

import assignments.Ex1.Ex1;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Ex2Test {

    @Test
    void isNumber() {
        String[] good = {"   15 ", "135", "100111", "123456", "-0125", "123.5", "+0.8", "12", "8.5", "-1"};
        for (int i = 0; i < good.length; i = i + 1) {
            boolean ok = Ex2.isNumber(good[i]);
            assertTrue(ok);
        }
    }

    @Test
    void isText() {
        String[] good = {" asdad","*5"};
        for (int i = 0; i < good.length; i = i + 1) {
            boolean ok = Ex2.isText(good[i]);
            assertTrue(ok);
        }
    }

    @Test
    void isForm() {
        String[] good = {"=5*5*5*5", "   =  1  3  5", "=(1+2)*2", "=((1+2)*2)-1", "=1+2", "=01", " =(-5)", "=+5", "= 5", "=5/2","=(-(-(2)))", "=(((3)))"};//"=5)+5(+5"
        for (int i = 0; i < good.length; i = i + 1) {
            boolean ok = Ex2.isForm(good[i]);
            assertTrue(ok);
        }
        String[] not_good = {"=(5+2)5","=(1*2)-1)","=2+)", "=2+)+4-(2-8", "=2+()", "=(3+1*2)-", "=(-5", "=+-5", "=/5", "=NaN", "=Infinity", "     ", "","=5)+5(+5", null};
        for(int i=0;i<not_good.length;i=i+1) {
            boolean not_ok = Ex2.isForm(not_good[i]);
            assertFalse(not_ok);
        }
    }

    @Test
    void indOfMainOp() {
        assertEquals(1 ,Ex2.indOfMainOp("1+2"));
        assertEquals(5 ,Ex2.indOfMainOp("5*5*5*5"));
        assertEquals(1 ,Ex2.indOfMainOp("5/2"));
        assertEquals(0 ,Ex2.indOfMainOp("-5"));
        assertEquals(1 ,Ex2.indOfMainOp("0+1"));
        assertEquals(9 ,Ex2.indOfMainOp("((1+2)*2)-1"));
        assertEquals(0 ,Ex2.indOfMainOp("135"));
        assertEquals(5 ,Ex2.indOfMainOp("(1+2)*2"));
        assertEquals(0 ,Ex2.indOfMainOp("(-(-(2)))"));
        assertEquals(5 ,Ex2.indOfMainOp("(1+2)*2"));
        assertEquals(5 ,Ex2.indOfMainOp("(1*2)-1"));
    }

    @Test
    void computeFormRec(){
        assertEquals(5.0 ,Ex2.computeFormRec("((1+2)*2)-1"));
        assertEquals(3.0 ,Ex2.computeFormRec("1+2"));
        assertEquals(1.0 ,Ex2.computeFormRec("2-1"));
        assertEquals(1.0 ,Ex2.computeFormRec("2/2"));
        assertEquals(4.0 ,Ex2.computeFormRec("2*2"));
    }

    @Test
    void computeForm(){
        assertEquals(3.0 ,Ex2.computeForm("=1+2"));
        assertEquals(135.0 ,Ex2.computeForm("   =  1  3  5"));
        assertEquals(6.0 ,Ex2.computeForm("=(1+2)*2"));
        assertEquals(5.0 ,Ex2.computeForm("=((1+2)*2)-1"));
        assertEquals(-1.0 ,Ex2.computeForm("=1+(-2)"));
        assertEquals(1.0 ,Ex2.computeForm("=01"));
        assertEquals(-5.0 ,Ex2.computeForm("=(-5)"));
        assertEquals(3.0 ,Ex2.computeForm("=((1+1)*2)-1"));
        assertEquals(5.0 ,Ex2.computeForm("=+5"));
        assertEquals(5.0 ,Ex2.computeForm("= 5"));
        assertEquals(2.5 ,Ex2.computeForm("=5/2"));
        assertEquals(4.5 ,Ex2.computeForm("=5/2+2"));
        assertEquals(3.0 ,Ex2.computeForm("=(((3)))"));
        assertEquals(4.0 ,Ex2.computeForm("=((((2)+(3-1))))"));
        assertEquals(4.0 ,Ex2.computeForm("=(((2+(3-1))))"));
    }
    @Test
    void ComplexComputeForm(){
        assertEquals(33.0 ,Ex2.computeForm("=((((3+2)*4)-((8/2)+1))*2)+3"));
        assertEquals(46/3.0 ,Ex2.computeForm("=(((5+5)-3)*2)+(4/(2+1))"));
        assertEquals(10.0 ,Ex2.computeForm("=(((2+3)*2)+(8/2))-(3+1)"));
        assertEquals(20.0 ,Ex2.computeForm("=((((6*2)-3)+1)*2)"));
        assertEquals(16.0 ,Ex2.computeForm("=((((4+2)*3)-5)+(6/2))"));
        assertEquals(201.0 ,Ex2.computeForm("=(((((((1+2)*3)-4)*5)+6)-7)*8)+9"));
        assertEquals(800.0 ,Ex2.computeForm("=((((((((2+3)*4)-5)*6)+7)-8)*9)+10)-11"));
        assertEquals(211.0 ,Ex2.computeForm("=((((((((((1+1)*2)-3)*4)+5)-6)*7)+8)-9)*10)+11"));
        assertEquals(981513.0 ,Ex2.computeForm("=(((((((((((((4+5)*6)-7)*8)+9)-10)*11)+12)-13)*14)+15)-16)*17)+18"));
        assertEquals(2008531.0 ,Ex2.computeForm("=((((((((((((((5+6)*7)-8)*9)+10)-11)*12)+13)-14)*15)+16)-17)*18)+19)"));
        assertEquals(402.0, Ex2.computeForm("=((((((((2+3)*5)-(4/2))+(((62)-1)))/2)*((8-3)+5))-(((4+1)*3)+(6/2))))"));
        assertEquals(71/6.0, Ex2.computeForm("=(((((7+2)-3)*(4+((3*2)-1)))+((((8/4)+6)*3)-(5+2)))/((((2+1)*(3-2))+4)-1))"));
        assertEquals(9/8.0, Ex2.computeForm("=((((((3+5)-2)*4)+(6/(2+1)))-((7*3)-4))/((2+((5-3)*2))+(8/4)))"));
        assertEquals(83/24.0, Ex2.computeForm("=(((((((3+5)*2)-4)+((6*2)-8))*(4+2))-((5/1)+((7-3)*2)))/(((9-4)+3)*(2+1)))"));
        assertEquals(418/3.0, Ex2.computeForm("=(((((((2+3)*4)-(5*2))+((6/3)+(8-4)))*((5-2)+(3*2)))-(((((9+1)*3)-(4/2))/((2*2)+(3-1))))))"));
        assertEquals(5401/180.0, Ex2.computeForm("=(((((((((((((((((10/2)-3)*((5+6)))-(((8+4))*2))+(7/(((2+1)))))/(((((3*3)))+((((((5-2)))))))*((4+6)/2)))))))))))+(((((((((((2*5)-(3+1))*((8/4)+(6-3))))))))))))))"));
    }

}

