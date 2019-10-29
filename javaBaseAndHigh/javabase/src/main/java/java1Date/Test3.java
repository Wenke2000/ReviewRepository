package java1Date;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Test3 {

    public static void main(String [] arg) {
        Calendar gregorianCalendar=new GregorianCalendar();
        int year=gregorianCalendar.get(Calendar.YEAR);
        int month=gregorianCalendar.get(Calendar.MONTH)+1;
        int day=gregorianCalendar.get(Calendar.DAY_OF_MONTH);
        int hour=gregorianCalendar.get(Calendar.HOUR_OF_DAY);
        int minute=gregorianCalendar.get(Calendar.MINUTE);
        int second=gregorianCalendar.get(Calendar.SECOND);
        System.out.println(year+"-"+month+"-"+day+" "+hour+":"+minute+":"+second);
    }
}
