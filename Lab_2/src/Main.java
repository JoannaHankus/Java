public class Main {
    public static void main (String[] args){

     Matrix s = new Matrix(new double [][]{{1,3,2},{4,5,6},{7,8,9}});
     Matrix col = s.getSubmatrix(1,3,1,3);
     //double res = result.frobenius();
     System.out.println(col);
        }
    }

