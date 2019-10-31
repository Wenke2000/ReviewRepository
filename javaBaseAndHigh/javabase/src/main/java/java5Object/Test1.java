package java5Object;

//封装，继承，多态

public class Test1 {
    public static void main(String[] args) {
        A test=new B();
        test.run();
        test.play();
    }
}



//父类 抽象类A
abstract class A{

    public  abstract void run();
    public  abstract void play();

}


//子类 class B
class B extends A{
    @Override
    public void run(){
        System.out.println("我会跑");
    }

    @Override
    public void play() {
        System.out.println("我会跳");
    }
}