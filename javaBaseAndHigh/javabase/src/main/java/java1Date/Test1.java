package java1Date;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 测试 SimpleDateFormat 的方法  parse  和  format
 * Thread的方法 sleep
 */
public class Test1 {


    //时间类格式化
    public StringBuilder formatString (Date date){
        //创建日期格式化
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        StringBuilder a=new StringBuilder(simpleDateFormat.format(date));
        return a;
    }

    //将字符串转换成时间类
    public Date formatDate(StringBuilder Sdate){
        Date date=null;
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
       try {
           date = simpleDateFormat.parse(Sdate.toString());
       }catch (Exception e)
       {
           System.out.println("字符串转换失败！");
       }
       return date;
    }


    //规定一个时间，输出显示，经过一段时间后（将程序进行休眠），在打印输出
    public static void main(String [] agr){
        Test1 test=new Test1();
        Date date =new Date();
        System.out.println(test.formatString(date));
        //设置休息的时间
        try {
            Thread.sleep(3*1000);
        } catch (InterruptedException e) {
            System.out.println("It is fail that set time for sleep ");
        }

        StringBuilder a=test.formatString(new Date());
        System.out.println(test.formatDate(a));




    }

}
