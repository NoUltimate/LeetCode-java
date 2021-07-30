package leetcode.classify.search.backtracking.N皇后;

import com.alibaba.fastjson.JSONObject;

import java.util.Arrays;

public class ArrTwo {
    public static void main(String[] args) {
        new ArrTwo().test();
        new ArrTwo().testClone();
        new ArrTwo().testArraysCopy();
    }

    // 浅拷贝 一方改变都会改变
    public void test() {
        System.out.println("----------测试二维数组赋值-------------");
        int[][] oldArr = new int[5][1];
        int[][] newArr = new int[5][1];
        newArr = oldArr;
        change(oldArr, 1);
        print(oldArr, newArr);
        change(newArr, 2);
        print(oldArr, newArr);
    }

    // 深拷贝 一方改变都会改变
    public void testClone() {
        System.out.println("----------测试二维数组clone-------------");
        int[][] oldArr = new int[5][1];
        int[][] newArr = new int[5][1];
        int count = 0;
        for(int[] t : oldArr) {
            newArr[count++] = t.clone();
        }
        change(oldArr, 1);
        print(oldArr, newArr);
        change(newArr, 2);
        print(oldArr, newArr);
    }

    public void testArraysCopy() {
        System.out.println("----------测试二维数组Arrays.copyOf-------------");
        int[][] oldArr = new int[5][1];
        int[][] newArr = new int[5][1];
        for(int i = 0; i < oldArr.length; ++i) {
            newArr[i] = Arrays.copyOf(oldArr[i], oldArr[i].length);
        }
        change(oldArr, 1);
        print(oldArr, newArr);
        change(newArr, 2);
        print(oldArr, newArr);
    }


    public void change(int[][] arr, int val) {
        for(int i = 0; i < arr.length; ++i) {
            arr[i][0] = val;
        }
    }

    public void print(int[][] oldArr, int[][] newArr) {
        System.out.println(JSONObject.toJSONString(oldArr));
        System.out.println(JSONObject.toJSONString(newArr));
        System.out.println("-----------------------");
        System.out.println("");
    }
}
