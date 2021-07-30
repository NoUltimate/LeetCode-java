package leetcode.base.数组拷贝;
/*
 *
 *
 * @author sunbowen
 * @date 2021年07月13日 13:38
 */

import com.alibaba.fastjson.JSONObject;

import java.util.Arrays;
import java.util.List;

public class Solution {

    public void copyOf(String[] a) {
        System.out.println("-------copyOf-------");
        String[] b = Arrays.copyOf(a, a.length);
        b[0] = "修改后";
        print(a, b);
    }

    public void copyOfRange(String[] a) {
        System.out.println("-------copyOf-------");
        String[] b = Arrays.copyOfRange(a,0,  a.length);
        b[0] = "修改后";
        print(a, b);
    }

    public void arrayCopy(String[] a) {
        System.out.println("-------arrayCopy-------");
        String[] b = new String[a.length];
        System.arraycopy(a, 0, b, 0, a.length);
        b[0] = "修改后";
        print(a, b);
    }

    public void clone(String[] a) {
        System.out.println("-------clone-------");
        String[] b = (String[])a.clone();
        b[0] = "修改后";
        print(a, b);
    }


    public void listCopy(String[] a) {
        System.out.println("-------Arrays.asList-------");
        List<String> copyA = Arrays.asList(a);
        copyA.set(0, "第一次修改后");
        System.out.println(JSONObject.toJSONString(a));
        System.out.println(JSONObject.toJSONString(copyA));
        if (a[0].equals(copyA.get(0))) {
            System.out.println("结论: 深拷贝");
        } else {
            System.out.println("结论: 浅拷贝");
        }

        System.out.println("-------list.toArray-------");
        String[] b = (String[])copyA.toArray();
        b[0] = "第二次修改";
        System.out.println(JSONObject.toJSONString(a));
        System.out.println(JSONObject.toJSONString(copyA));
        System.out.println(JSONObject.toJSONString(b));
        if (a[0].equals(b[0])) {
            System.out.println("结论: 深拷贝");
        } else {
            System.out.println("结论: 浅拷贝");
        }

        String[] b2 = copyA.toArray(new String[a.length]);
        b2[0] = "第三次修改";
        System.out.println(JSONObject.toJSONString(a));
        System.out.println(JSONObject.toJSONString(copyA));
        System.out.println(JSONObject.toJSONString(b2));
        if (a[0].equals(b2[0])) {
            System.out.println("结论: 深拷贝");
        } else {
            System.out.println("结论: 浅拷贝");
        }

    }





    public void print(String[] a, String[] b) {
        System.out.println(JSONObject.toJSONString(a));
        System.out.println(JSONObject.toJSONString(b));
        if (a[0].equals(b[0])) {
            System.out.println("结论: 深拷贝");
        } else {
            System.out.println("结论: 浅拷贝");
        }
    }

    public static void main(String[] args) {
        String[] a = new String[]{"修改前"};
        new Solution().copyOf(a);
        new Solution().copyOfRange(a);
        new Solution().arrayCopy(a);
        new Solution().clone(a);
        new Solution().listCopy(a);
    }
}
