package beans;

public class Needy {
    public MyClass ms=null;
    public Needy(MyClass m){
        this.ms=m;
    }
    public void caller(){
        ms.printer();
    }
}
