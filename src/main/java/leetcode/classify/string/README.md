* 如果输入的数据有三行，第一行是整数，第二行和第三行都是字符串，java中的Scanner类在nextInt()后输入的nextLine()无效
```java
public class test {
    public void t() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        s1 = s1.replaceAll(" ", "");
        s2 = s2.replaceAll(" ", "");
    }
}
```