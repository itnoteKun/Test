package com.work;

public class test6 {
    class DianChi{
        public void Cell(){

            System.out.println("电池可以充电");
        }

    }
    class Phone extends DianChi{
        public void can(){
            System.out.println("可以下载音乐");

        }

        @Override
        public void Cell(){
            System.out.println("可以播放音乐");
        }

    }


    class TestPhont{
        public  void main(String[] args) {
            DianChi dian  = new DianChi();
            Phone phone = new Phone();
            dian.Cell();
            phone.can();
            phone.Cell();

        }

    }

}




