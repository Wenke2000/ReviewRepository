package java1Rubbish;

public class Test1 {

    public static void main(String[] args) {

        System.out.println(6+6+"aaa"+6+6);
        Integer a=2;
        a=5;
        System.gc();
        System.out.println(a);
    }
}
