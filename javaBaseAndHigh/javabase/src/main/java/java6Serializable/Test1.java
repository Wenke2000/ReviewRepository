package java6Serializable;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 测试Enum类型
 * 测试Map
 * 测试Serializable
 */
public enum Test1 implements Serializable {
    RED("红色", 1), GREEN("绿色", 2), BLANK("白色", 3), YELLO("黄色", 4);
    // 成员变量
    private String name;
    private int index;

    // 构造方法
    private Test1(String name, int index) {
        this.name = name;
        this.index = index;
    }

    // 普通方法
    public static String getName(int index) {
        for (Test1 c : Test1.values()) {
            if (c.getIndex() == index) {
                return c.name;
            }
        }
        return null;
    }

    // get set 方法
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }


    public static void main(String[] args) {
        Map color=new HashMap<Integer,String>();
        color.put(Test1.RED.index,Test1.RED.name);
        color.put(Test1.GREEN.index,Test1.GREEN.name);
        color.put(Test1.BLANK.index,Test1.BLANK.name);
        color.put(Test1.YELLO.index,Test1.YELLO.name);
        for (int i=1;i<5;i++)
        {
            System.out.println("index:"+i+" Name:"+color.get(i));
        }
    }
}
