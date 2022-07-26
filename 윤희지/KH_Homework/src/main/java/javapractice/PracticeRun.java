package javapractice;

public class PracticeRun {
    public static void main(String[] args) {

        MultipleNum multi = new MultipleNum(100);

        multi.showMultipleNums(2);
        System.out.println("==========");
        multi.showMultipleNums(3);
        System.out.println("==========");
        multi.showMultipleNums(4);
        System.out.println("==========");
        multi.showMultipleNums(2, 9);


    }
}
