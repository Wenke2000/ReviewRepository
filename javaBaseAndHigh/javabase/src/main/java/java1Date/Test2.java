package java1Date;


import java.util.Calendar;

public class Test2 {

    //给时间Date设置指定时间
    public static void main (String [] arg){
        Calendar calendar=Calendar.getInstance();
       //获取系统时间
        long sysSTime=System.currentTimeMillis();
        int year=calendar.get(Calendar.YEAR);
        int month=calendar.get(Calendar.MONTH)+1;
        int day=calendar.get(Calendar.DAY_OF_MONTH);
        int hour=calendar.get(Calendar.HOUR_OF_DAY);
        int minute=calendar.get(Calendar.MINUTE);
        int second=calendar.get(Calendar.SECOND);
        System.out.println(year+"-"+month+"-"+day+" "+hour+":"+minute+":"+second);
        for(long i=0;i<10000000000L;i++){}
        long sysETime=System.currentTimeMillis();
        System.out.println("一共耗时："+(sysETime-sysSTime));
    }
}
