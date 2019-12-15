package java9Thread;

public class Test1 extends Thread{

    @Override
    public void run() {

        for(int i=0;i<10;i++){
            System.out.println("子线程："+i);

        }
    }
}


class test {

     public static void main(String[] args) {
            Thread thread=new Test1();
            thread.start();
            for(int i=0;i<100;i++){
                System.out.println("父线程：" +i);
            }
    }


}