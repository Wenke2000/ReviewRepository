package java4Exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Test1 {

    public static void main(String[] args) {

        int a[]={1,2,3,4,5,6};

        //数组下标溢出
        try{
            System.out.println(a[a.length]);
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println(e.getCause()+"\n输出数组元素失败！");
        }finally{
            System.out.println("第一个异常结束");
        }


        //输入数据类型不匹配
        Scanner input = new Scanner(System.in);
        try{
            System.out.println("Enter :"+input.nextInt());
            return ;
        }catch (InputMismatchException e)
        {
            System.out.println("输入数据类型失败！");
        }finally{
            System.out.println("See you !");
        }

    }
}
