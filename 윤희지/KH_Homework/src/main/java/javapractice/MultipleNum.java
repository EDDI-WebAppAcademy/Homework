package javapractice;

public class MultipleNum {
    private int[] arr;
    private int multiple;

    public MultipleNum(int length) {
        arr = new int[length];

        for (int i = 0; i < length; i++) {
            arr[i] = i + 1;
        }
    }

    public void showMultipleNums(int multiple) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % multiple == 0) {
                System.out.println(arr[i]);
            }
        }
    }

    public void showMultipleNums(int min, int max) {
        int specific = (int) (Math.random() * (max - min + 1) + min);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % specific == 0) {
                System.out.println(arr[i]);
            }
        }
    }

    public void showMultipleNumsLoop(int min, int max) {
        int specific = (int) (Math.random() * (max - min + 1) + min);
        int count = 0;
        while (true) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] % specific == 0) {
                    count++;
                    System.out.println(arr[i]);
                }
            }
            arr = new int[count];
            if (arr.length == 1) {
                break;
            }

        }


    }
}

