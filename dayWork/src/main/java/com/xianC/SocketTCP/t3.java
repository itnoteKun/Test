package com.xianC.SocketTCP;

public class t3 {
    public static void main(String[] args) {
        int nan,nv,xiao;
        for (nan=1;nan<=36;nan++){
            for (nv=1;nv<=36;nv++){
                xiao=36-nan-nv;
                if((4*nan+3*nv+xiao/2)==36){
                    System.out.println("男有"+nan+" 女"+nv+" 小孩"+xiao);
                    break;
                }
            }
        }

    }
}
