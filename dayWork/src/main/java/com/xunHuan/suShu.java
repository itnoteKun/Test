package com.xunHuan;

import java.util.Scanner;

public class suShu {
    public static void main(String[] args) {

        int sum = 0;

        for (int i=101;i<=200; i++){
            for (int j=2;j<i;j++){
                if(i%j==0){
                    break;
                }else if(j==i-1){
                    System.out.println(i);
                    sum++;
                }

            }

        }
        System.out.println("101-200之间的素数共有："+sum);

    }
}

 class shuiXianHua {
     public static void main(String[] args) {

         for (int i=100; i<1000; i++){
             int a=i/100;
             int b=i/10%10;
             int c=i%100%10;
             int sum = a*a*a + b*b*b + c*c*c;
             if(sum == i){
                 System.out.println(i);
             }
         }
     }
}

//分解质因数
class fenJie {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = 2;

        while (k<=n){
            if (k==n){
                System.out.println(k);
                break;
            }else if(n%k==0){
                System.out.print(k+'*');
                n = n/k;
            }else if(n%k!=0){
                k++;
            }
        }
        scanner.close();
    }
}


//利用条件运算符的嵌套来完成此题：学习成绩> =90分的同学用A表示，60-89分之间的用B表示，60分以下的用C表示。
//1.程序分析：(a> b)?a:b这是条件运算符的基本例子。

class app05{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        char b = (a>=90)?'A':(a>=60)?'B':'C';
        System.out.println(b);
        scanner.close();

    }

}

//输入两个正整数m和n，求其最大公约数和最小公倍数。
//1.程序分析：利用辗除法。

class app06{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入m和n");
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int i = 1;
        int yue = 1;
        while (i<=m&&i<=n){
            int m1 = m%i;
            int n1 = n%i;
            if(m1==0 && n1==0){
                 yue=i;
            }
            i++;
        }
        System.out.println("最大公约数为："+ yue);
        scanner.close();

    }

}

class test_07{
    public static void main(String[] args) {
        String string = "jon 12i 4n";
        


    }
}









class app07{
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一行字符:");
        String str = scanner.nextLine();
        scanner.close();
        int i=0;
        int letter = 0;
        int space = 0;
        int mou = 0;
        int other =0;
        while (str != "\n"){
            char   ch = str.charAt(i);
            i++;
            if(Character.isLetter(ch)){
                letter++;
            }else if (Character.isWhitespace(ch)){
                space++;
            }else if (Character.isDigit(ch)){
                mou++;

            }else {
                other++;
            }
            if (i==str.length()){
                break;
            }
        }
        System.out.println("字母个数为"+letter);
        System.out.println("空格个数为"+space);
        System.out.println("数字个数为"+mou);
        System.out.println("其他字符个数为"+other);
    }
}

//求s=a+aa+aaa+aaaa+aa...a的值，其中a是一个数字。例如2+22+222+2222+22222(此时共有5个数相加)，几个数相加有键盘控制。
//1.程序分析：关键是计算出每一项的值。

class app08{
    public static void main(String[]args){

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个数字：");
        int a = scanner.nextInt();
        System.out.println("输入相加的数的个数：");
        int cishu = scanner.nextInt();
        scanner.close();
        int sum = 0;
        for(int j=1; j<=cishu;j++) {
            int s = a;
            int a2 = a;
            for (int i = 1; i <j; i++) {
                int b = a2 * 10;
                s = s + b;
                a2 = b;
            }
            System.out.print(s+"+");
            sum +=s;
        }

        System.out.println("和为："+sum);
    }
}

class app08_t{
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int a=scanner.nextInt();
        int sum_a=0;
        int s=0;
        int cishu=5;
        while (cishu>0){
            sum_a=sum_a+a;
            a*=10;
            System.out.print(sum_a+"+");
            s=s+sum_a;
            cishu--;
        }
        System.out.print(s);
    }
}

//一个数如果恰好等于它的因子之和，这个数就称为 "完数 "。例如6=1＋2＋3.编程   找出1000以内的所有完数。

class wanshu{

    public static void main(String[] args) {

        for(int i=2;i<1000;i++){
            int sum=0;

            for (int j=1;j<i;j++){
                if(i%j==0){
                    sum+=j;
                }
            }
            if(sum==i){
                System.out.println(i);
            }
        }
    }
}

//【程序10】
//题目：一球从100米高度自由落下，每次落地后反跳回原高度的一半；再落下，求它在   第10次落地时，共经过多少米？第10次反弹多高？
class app10{
    public static void main(String[] args) {
        int s=0;
        float h=100;
        for (int i=1;i<=10;i++){
            s+=h;   //落地
            h=h/2;  //i次落地后反弹的高度
            s+=h;   //反弹
        }
        System.out.println(s-h);
        System.out.println(h);
    }
}

//【程序11】
//题目：有1、2、3、4个数字，能组成多少个互不相同且无重复数字的三位数？都是多少？
//1.程序分析：可填在百位、十位、个位的数字都是1、2、3、4。组成所有的排列后再去掉不满足条件的排列。

class app11 {
    public static void main(String[] args) {

        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= 4; j++) {
                for (int z = 1; z <= 4; z++) {
                    int x = i * 100 + j * 10 + z;
                    if(i!=j&&i!=z&&j!=z){
                        System.out.println(x);
                    }
                }
            }
        }
    }
}





















