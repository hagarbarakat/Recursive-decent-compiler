package sample;

public class parser {

    Character LA;
    public String inputBuffer;
    private StringBuilder string=new StringBuilder("");
    private void scan(){

        LA = inputBuffer.charAt(0);
        inputBuffer = inputBuffer.substring(1);
    }
    public void accept(){
        System.out.println("\nACCEPTED! ");
        string.append("\nACCEPTED!\n ");
    }
    private void fail(){
        System.out.println("\nFAILED! ");
        string.append("\nFAILED!\n ");
    }
    private void check(Character token){
        if(LA.equals(token)){scan();}
        else {fail();}
    }
    public void A(){
        scan();
        V();
        check('=');
        E();
        System.out.print("STORE");
        string.append("STORE");
    }
    private void E(){
        if(LA=='-'){
            scan();
            T();
            System.out.print("NEG ");
            string.append("NEG ");
        }
        else {
            T();
        }
        if(LA=='+'){
            while (LA=='+'){
                scan();
                T();
                System.out.print("ADD ");
                string.append("ADD ");
            }
        }
        else if (LA=='-'){
            while (LA=='-'){
                scan();
                T();
                System.out.print("SUB ");
                string.append("SUB ");
            }
        }

    }
    private void T(){
        F();
        if (LA=='*'){
            while (LA=='*'){
                scan();
                F();
                System.out.print("MUL ");
                string.append("MUL ");
            }
        }
        else if(LA=='/'){
            while (LA=='/'){
                scan();
                F();
                System.out.print("DIV ");
                string.append("DIV ");
            }
        }
    }
    private void F(){
        if(LA=='('){
            scan();
            E();
            check(')');
        }
        else if(Character.isDigit(LA)){
            C();
        }
        else {
            V();
            System.out.print("LOAD ");
            string.append("LOAD ");
        }
    }
    private void C(){
        System.out.print("LIT "+LA+" ");
        string.append("LIT ").append(LA).append(" ");
        scan();
    }
    private void V(){
        System.out.print("LIT "+LA+" ");
        string.append("LIT ").append(LA).append(" ");
        scan();
    }

    public StringBuilder getString() {
        return string;
    }
}
