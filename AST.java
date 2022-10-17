import java.util.ArrayList;
import java.util.List;

public abstract class AST{

}
abstract class Command extends AST{

    abstract public void eval(Environment env);
}


class Start extends Command{

    @Override
    public void eval(Environment env) {

    }
}
class Assignment extends Command{  //model class til constructoren for identifiers.
    String varname;
    Expr expr;
    Assignment(String varname, Expr expr){ this.varname=varname; this.expr=expr;}
    public void eval(Environment env) {env.setVariable(varname, expr.eval(env));

    }
}
class inpseq extends Command{ //en liste med inputsekvensen.
    List<Boolean> inseq;

    String varname;
    public inpseq(String varname, String inInput){
        this.varname=varname;
        this.inseq=new ArrayList<>();

        for(char i : inInput.toCharArray()){
            int j = i-0x30;
            if(j==0){
                inseq.add(false);
            }
            else {
                inseq.add(true);
            }
        }
        System.out.println(inseq);
    }

    @Override
    public void eval(Environment env) {

    }
}

class Latch extends Command{
    String in;
    String out;
    Latch(String in, String out){
        this.in=in;
        this.out=out;
    }
    @Override
    public void eval(Environment env) {

    }
    @Override
    public String toString(){
        return this.in+"->"+this.out;
    }
}
abstract class Expr extends AST{
    abstract public Boolean eval(Environment env);
}

class b_and extends Expr{
    Expr e1, e2;
    b_and(Expr e1, Expr e2){this.e1=e1; this.e2=e2;}    
    public Boolean eval(Environment env){
	    return e1.eval(env) && e2.eval(env);
    }
}

class b_or extends Expr{
    Expr e1, e2;
    b_or(Expr e1, Expr e2){this.e1=e1; this.e2=e2;}    
    public Boolean eval(Environment env){
	return e1.eval(env) || e2.eval(env);
    }
}
class b_not extends Expr{
    Expr e1, e2;
    b_not(Expr e1){this.e1=e1;}
    public Boolean eval(Environment env){
	return !e1.eval(env);
    }
}
class sig extends Expr{
    String name;
    Boolean value;
    sig(String e) {
        this.name=e;
    }
    public Boolean eval(Environment env){
        return env.getVariable(this.name);
    }
}
class parentheses extends Expr{
    Expr e1;
    parentheses(Expr e1){
        this.e1=e1;
    }
    public Boolean eval(Environment env){
        return e1.eval(env);
    }
}
class Variable extends Expr{
    String name;
    Variable(String name){
        this.name=name;
    }
    @Override
    public Boolean eval(Environment env) {
        return env.getVariable(name);
    }
}




