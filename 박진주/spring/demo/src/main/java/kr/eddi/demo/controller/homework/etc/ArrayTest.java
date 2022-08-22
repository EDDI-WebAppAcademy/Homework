package kr.eddi.demo.controller.homework.etc;

import java.util.Arrays;

public class ArrayTest {

    public static void main(String[] args) {
        int[] arr1 = {4, 2, 1, 5, 5};
        int[] arr2 = {10};


        checkArray(arr1);
       checkArray(arr2);



    }



    public static void checkArray(int[] arr){

        int minArr = arr[0];

        for (int i = 0; i <arr.length ; i++) {
            if (arr.length == 1) {
                break;
            } else {
                if (arr[i] < minArr) {
                    minArr = arr[i];
                }
            }
        }
        System.out.println(Arrays.toString(minMinusArray(minArr, arr)));
    }


    public static int[] minMinusArray(int minArr, int[] arr){
        int[] changeArr= new int[arr.length-1];

        if(arr.length == 1) {
            arr[0] = -1;
            return arr;

        } else {
            for (int i = 0; i < arr.length; i++) {

                if(arr[i] == minArr){
                    for (int j = i; j < arr.length; j++){

                        if( j == arr.length-1){         // 최소값이 맨 마지막 인덱스면 마지막 자른후 copy
                            changeArr= Arrays.copyOfRange(arr, 0, arr.length-1);
                            break;

                        } else{
                            arr[j] = arr[j+1];           // 최소값이 처음 / 중간 인덱스면 한칸씩 땡겨서 arr[j]에 저장 후 마지막 인덱스 자른후 copy
                        }
                        changeArr = Arrays.copyOfRange(arr, 0, arr.length-1);

                    }
                    break;
                }
            }
        }
        return changeArr;
    }

}