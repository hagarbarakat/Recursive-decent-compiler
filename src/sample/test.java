package sample;

public class test {
    public static void main(String[] args) {
        parser p = new parser();
        p.inputBuffer = "A=B+3*C$";
        p.A();
        if (p.LA=='$'){
            p.accept();
        }
    }
}
