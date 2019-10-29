package java2Expression;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 测试pattern类和matcher类
 * 正则表达式的一般
 * Matcher对象是对输入字符串进行解释和匹配操作的引擎
 * 列表： {n，m} 最少n次，最多m次
 */

//通过 正则表达式查找对应字符

public class Test1 {


    public static void main(String[] args) {

        //带查询的字符串
        String line="silly stupid foolish stupid silly foolish";
        //定义捕获组
        String Spattern="(foolish)";

        //创建Patrern对象 通过编译complie
        Pattern pattern=Pattern.compile(Spattern);

        //创建Matcher
        Matcher matcher=pattern.matcher(line);

        //查找匹配字符的位置
        int index=1;
        System.out.println("total:"+matcher.groupCount());
        while(matcher.find())
        {
            System.out.println("第"+index+"个位置："+matcher.start());
        }

    }
}
