package main.java.com.xianC.SocketTCP;

public class t1 {
    public static void main(String[] args) {
        for (int i=1;i<101;i++){
            int a=i/10;
            int b=i%10;
            if (i%7!=0&&a!=7&&b!=7){
                System.out.println(i);
            }
        }
    }
}
