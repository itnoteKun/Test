package com.xunHuan;

public class app18 {
    public static void main(String[] args) {
        char a,b,c;
        for (a='x';a<='z';a++){
            if (a!='x'){
                for (b='x';b<='z';b++){
                    if(a!=b) {
                        for (c = 'x'; c <= 'z'; c++) {

                            if(c!='x'&&c!='z'){
                                if(a!=c&&b!=c){
                                    System.out.println("a对"+a+"\nb对"+b+"\nc对"+c);
                                }
                            }
                        }
                    }
                }
            }

        }


    }


}
