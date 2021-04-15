import static org.junit.Assert.*;

public class MatrixTest {

    @org.junit.Test
    public void MatrixTest() {

            Matrix tets = new Matrix( 3, 4);
            assertEquals(3,tets.getRows());
            assertEquals(4,tets.getCols());
    }
   @org.junit.Test
    public void MatrixTest2() {
        double[][] test ={{1,2},{3,4,5}} ;
        Matrix test1 = new Matrix(test);
        double[][] exp = test1.asArray();
        assertEquals(3, exp[0].length);
        assertEquals(2,exp.length);
    }

    @org.junit.Test
    public void asArray() {
        double[][] test ={{1,2,3},{3,4,5}} ;
        Matrix test1 = new Matrix(test);
        double[][] exp = test1.asArray();
        assertArrayEquals(test, exp);
        assertArrayEquals(test[0], exp[0],1e-7);


    }

    @org.junit.Test
    public void get() {
        double[][] test ={{1,2},{3,4,5}} ;
        Matrix test1 = new Matrix(test);
        double exp = test1.get(0,0);
        assertEquals(test[0][0],exp ,1e-7);
    }

    @org.junit.Test
    public void getRows() {
    }

    @org.junit.Test
    public void getCols() {
    }

    @org.junit.Test
    public void set() {
        Matrix test = new Matrix(1,2);
        test.set(0,0,15.0);
        assertEquals(15,test.get(0,0),1e-7);
    }

    @org.junit.Test
    public void testToString() {
        double[][] test0 ={{1,2},{3,4,5}} ;
        Matrix test1 = new Matrix(test0);
        String txt = test1.toString();
        String[] arrOfStr = txt.split(",", -2);
        int num_of_colon = arrOfStr.length-1;
        System.out.println(num_of_colon);
        String[] arrOfBrack = txt.split("]", -2);
        int num_of_brack= arrOfStr.length-1;
        System.out.println(num_of_brack);

    }

    @org.junit.Test
    public void shape() {
    }

    @org.junit.Test
    public void reshape() {
        //double[][] test0 ={{1,2},{3,4,5}};
        Matrix test1 = new Matrix(2,2);
        try{
        test1.reshape(1,2);}
        catch(RuntimeException error){
            return;}
        fail("To nie dziala");
        }


    @org.junit.Test
    public void add() {
        Matrix test0 = new Matrix(new double[][]{{1,2},{2,0}});
        Matrix test1 = new Matrix(new double[][]{{1,1},{1,1}});
        Matrix res = test0.add(test1);
        assertEquals(2,res.data[0],1e-7);
        assertEquals(3,res.data[1],1e-7);
        assertEquals(3,res.data[2],1e-7);
        assertEquals(1,res.data[3],1e-7);


    }

    @org.junit.Test
    public void testAdd() {
        Matrix test = new Matrix(new double[][]{{1,2},{3,4}});
        Matrix result = test.add(2);
        assertEquals(3,result.data[0],1e-7);
        assertEquals(4,result.data[1],1e-7);
        assertEquals(5,result.data[2],1e-7);
        assertEquals(6,result.data[3],1e-7);
    }

    @org.junit.Test
    public void sub() {
        Matrix test = new Matrix(new double[][]{{1,2},{3,4}});
        Matrix result = test.sub(test);
        double norm = result.frobenius();
        assertEquals(0, norm,1e-7);
    }

    @org.junit.Test
    public void testSub() {
    }

    @org.junit.Test
    public void mul() {
    }

    @org.junit.Test
    public void testMul() {
        Matrix test = new Matrix(new double[][]{{1,2},{3,4}});
        Matrix res_mul = test.mul(-1);
        double norm = (test.add(res_mul)).frobenius();
        assertEquals(0, norm, 1e-7);
    }

    @org.junit.Test
    public void div() {
        Matrix test = new Matrix(new double[][]{{1,2},{3,4}});
        Matrix result = test.div(test);
        double norm = result.frobenius();
        assertEquals(test.getRows()*test.getCols(),norm,1e-7);
    }

    @org.junit.Test
    public void testDiv() {
    }

    @org.junit.Test
    public void dot() {
    }

    @org.junit.Test
    public void frobenius(){ 
        Matrix test = new Matrix(new double[][]{{1,2},{3,4}});
        double result = test.frobenius();
        assertEquals(30.0,result, 1e-7);

    }
}