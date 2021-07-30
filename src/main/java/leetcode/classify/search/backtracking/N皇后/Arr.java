package leetcode.classify.search.backtracking.N皇后;

import com.alibaba.fastjson.JSONObject;

import java.util.Arrays;

public class Arr {
    public static void main(String[] args) {
        new Arr().test();
        new Arr().testClone();
        new Arr().testArraysCopy();
    }

    // 浅拷贝 一方改变都会改变
    public void test() {
        System.out.println("----------测试一维数组赋值-------------");
        int[] oldArr = new int[10];
        int[] newArr = new int[10];
        newArr = oldArr;
        change(oldArr, 1);
        print(oldArr, newArr);
        change(newArr, 2);
        print(oldArr, newArr);
    }

    // 深拷贝 一方改变对另一个没有影响
    public void testClone() {
        System.out.println("----------测试一维数组clone-------------");
        int[] oldArr = new int[10];
        int[] newArr = new int[10];
        newArr = oldArr.clone();
        change(oldArr, 1);
        print(oldArr, newArr);
        change(newArr, 2);
        print(oldArr, newArr);
    }

    // 深拷贝 一方改变对另一个没有影响
    public void testArraysCopy() {
        System.out.println("----------测试一维数组Arrays.copyOf-------------");
        int[] oldArr = new int[10];
        int[] newArr = new int[10];
        newArr = Arrays.copyOf(oldArr, oldArr.length);
        change(oldArr, 1);
        print(oldArr, newArr);
        change(newArr, 2);
        print(oldArr, newArr);
    }


    public void change(int[] arr, int val) {
        for(int i = 0; i < arr.length; ++i) {
            arr[i] = val;
        }
    }

    public void print(int[] oldArr, int[] newArr) {
        System.out.println(JSONObject.toJSONString(oldArr));
        System.out.println(JSONObject.toJSONString(newArr));
        System.out.println("-----------------------");
        System.out.println("");
    }
}
