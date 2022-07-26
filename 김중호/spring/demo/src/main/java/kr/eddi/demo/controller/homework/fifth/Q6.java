package kr.eddi.demo.controller.homework.fifth;

    public class Q6 {

        public class Drainage {
            public static void main(String[] args){
                int count = 1;
                for(int i = 1 ; i<=100 ; i++ ){
                    if(i%3==0){
                        System.out.println(count+"번째 3의 배수: "+i);
                        count += 1;
                    }
                }
            }
        }}
