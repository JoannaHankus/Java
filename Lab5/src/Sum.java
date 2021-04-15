import java.util.ArrayList;
import java.util.List;

public class Sum extends Node{

    List<Node> args = new ArrayList<>();

    Sum(){}

    Sum(Node n1, Node n2){
        args.add(n1);
        args.add(n2);
    }

    Sum add(Node n){
        args.add(n);
        return this;
    }

    Sum add(double c){
        args.add(new Constant(c));
        return this;
    }

    Sum add(double c, Node n){
        Node mul = new Prod(c,n);
        args.add(mul);
        return this;
    }

    @Override
    double evaluate() {
        double result = 0;
        for (Node i:args){
            result +=i.evaluate();
        }
        return sign*result;
    }

    @Override
    Node diff(Variable var) {
        Sum r = new Sum();
        for(Node n:args){
            //if (!n.isZero())
            r.add(n.diff(var));
        }
        return r;
    }

    @Override
    boolean isZero() {
        if (this.evaluate()==0)return true;
        else return false;
    }

    int getArgumentsCount(){return args.size();}

    public String toString(){
        StringBuilder b =new StringBuilder();
        if(sign<0)b.append("-(");

        String argString="";
        for (Node j:args){
            argString = j.toString();
            b.append(argString);
            if (j!=args.get(args.size()-1))b.append("+");
        }
        if(sign<0)b.append(")");
        return b.toString();
    }
}