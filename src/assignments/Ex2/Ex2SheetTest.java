package assignments.Ex2;

import assignments.Ex2.Compute.ComExprNum;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Ex2SheetTest {

    @Test
    void isNumber() {
    }

    @Test
    void indOfMainOp() {
    }

    @Test
    void compute() {
        Ex2Sheet sheet = new Ex2Sheet();
        sheet.set(0,0,"5");
        assertEquals(5.0 ,((ComExprNum)sheet.compute("=a0")).getNumValue());
        assertEquals(33.0 ,((ComExprNum)sheet.compute("=((((3+2)*4)-((8/2)+1))*2)+3")).getNumValue());
        assertEquals(46/3.0 ,((ComExprNum)sheet.compute("=(((A0+5)-3)*2)+(4/(2+1))")).getNumValue());
        assertEquals(10.0 ,((ComExprNum)sheet.compute("=(((2+3)*2)+(8/2))-(3+1)")).getNumValue());
        assertEquals(20.0 ,((ComExprNum)sheet.compute("=((((6*2)-3)+1)*2)")).getNumValue());
        assertEquals(16.0 ,((ComExprNum)sheet.compute("=((((4+2)*3)-A0)+(6/2))")).getNumValue());
        assertEquals(201.0 ,((ComExprNum)sheet.compute("=(((((((1+2)*3)-4)*5)+6)-7)*8)+9")).getNumValue());
        assertEquals(800.0 ,((ComExprNum)sheet.compute("=((((((((2+3)*4)-5)*6)+7)-8)*9)+10)-11")).getNumValue());
        assertEquals(211.0 ,((ComExprNum)sheet.compute("=((((((((((1+1)*2)-3)*4)+5)-6)*7)+8)-9)*10)+11")).getNumValue());
        assertEquals(981513.0 ,((ComExprNum)sheet.compute("=(((((((((((((4+5)*6)-7)*8)+9)-10)*11)+12)-13)*14)+15)-16)*17)+18")).getNumValue());
        assertEquals(2008531.0 ,((ComExprNum)sheet.compute("=((((((((((((((5+6)*7)-8)*9)+10)-11)*12)+13)-14)*15)+16)-17)*18)+19)")).getNumValue());
        assertEquals(402.0, ((ComExprNum)sheet.compute("=((((((((2+3)*5)-(4/2))+(((62)-1)))/2)*((8-3)+5))-(((4+1)*3)+(6/2))))")).getNumValue());
        assertEquals(71/6.0, ((ComExprNum)sheet.compute("=(((((7+2)-3)*(4+((3*2)-1)))+((((8/4)+6)*3)-(5+2)))/((((2+1)*(3-2))+4)-1))")).getNumValue());
        assertEquals(9/8.0, ((ComExprNum)sheet.compute("=((((((3+5)-2)*4)+(6/(2+1)))-((7*3)-4))/((2+((5-3)*2))+(8/4)))")).getNumValue());
        assertEquals(83/24.0, ((ComExprNum)sheet.compute("=(((((((3+5)*2)-4)+((6*2)-8))*(4+2))-((5/1)+((7-3)*2)))/(((9-4)+3)*(2+1)))")).getNumValue());
        assertEquals(418/3.0, ((ComExprNum)sheet.compute("=(((((((2+3)*4)-(5*2))+((6/3)+(8-4)))*((5-2)+(3*2)))-(((((9+1)*3)-(4/2))/((2*2)+(3-1))))))")).getNumValue());
        assertEquals(5401/180.0, ((ComExprNum)sheet.compute("=(((((((((((((((((10/2)-3)*((5+6)))-(((8+4))*2))+(7/(((2+1)))))/(((((3*3)))+((((((5-2)))))))*((4+6)/2)))))))))))+(((((((((((2*5)-(3+1))*((8/4)+(6-3))))))))))))))")).getNumValue());
    }

    @Test
    void calculate() {
    }

    @Test
    void getNumValue() {
    }

    @Test
    void get() {
    }

    @Test
    void testGet() {
    }

    @Test
    void width() {
    }

    @Test
    void height() {
    }

    @Test
    void set() {
    }

    @Test
    void eval() {
    }

    @Test
    void isIn() {
    }

    @Test
    void depth() {
        Ex2Sheet sheet = new Ex2Sheet();
        sheet.set(0,0,"5");
        sheet.set(1,0,"=A0+7");
        sheet.set(2,0,"=b0+A0");
        sheet.set(1,1,"=B2");
        sheet.set(1,2,"=B1");
        assertEquals(0 ,sheet.depth()[0][0]);
        assertEquals(1,sheet.depth()[1][0]);
        assertEquals(2,sheet.depth()[2][0]);
        assertEquals(-1,sheet.depth()[1][1]);
        assertEquals(-1,sheet.depth()[1][2]);
    }

    @Test
    void load() {
    }

    @Test
    void isForm() {
        Ex2Sheet sheet = new Ex2Sheet();
        String[] good = {"=5*5*5*5", "=  1  3  5", "=(1+2)*2", "=((1+2)*2)-1", "=1+2", "=01", "=(-5)", "=+5", "= 5", "=5/2","=(-(-(2)))", "=(((3)))", "=NaN", "=Infinity"};//"=5)+5(+5"
        for (int i = 0; i < good.length; i = i + 1) {
            boolean ok = ((SCell)sheet.get(0,0)).isForm(good[i]);;
            assertTrue(ok);
        }
        String[] not_good = {"=(5+2)5","=(1*2)-1)","=2+)", "=2+)+4-(2-8", "=2+()", "=(3+1*2)-", "=(-5", "=+-5", "=/5", "     ", "","=5)+5(+5", null};
        for(int i=0;i<not_good.length;i=i+1) {
            boolean not_ok = ((SCell)sheet.get(0,0)).isForm(not_good[i]);
            assertFalse(not_ok);
        }
    }

    @Test
    void save() {
    }

    @Test
    void testEval() {
    }
}