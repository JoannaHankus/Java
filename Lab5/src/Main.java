import java.util.Locale;

public class Main {
    public static void main(String[] args) {

        Variable x = new Variable("x");
        Node exp = new Sum()
                .add(new Power(x,3))
                .add(-2,new Power(x,2))
                .add(-1,x)
                .add(2);
        for(double v=-5;v<5;v+=0.1){
            x.setValue(v);
            System.out.printf(Locale.US,"f(%f)=%f\n",v,exp.evaluate());

        }

    }}