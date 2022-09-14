package kr.eddi.demo.entity.basic.practice2;

import lombok.*;
@Getter
@Setter
public class Array {
    int[] arr; //밖에 배열 생성.
    public Array(int num){
        arr = new int[num];
    }

    public void OneToHundred(){
        for(int i=0; i<100; i++){
            arr[i] = i+1; //배열에 1부터 100까지의 숫자가 저장됨.(재사용성 낮음)
        }
    }
}

