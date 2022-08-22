package kr.eddi.demo.homework.basic.total2;

public enum PitchName {
    도(1, "도"),
    레(2, "레" ),
    미(3, "미"),
    파(4, "파"),
    솔(5, "솔"),
    라(6, "라"),
    시(7, "시");

    private final String name;
    private final int num;

    private PitchName( int num, String name){
        this.num = num;
        this.name = name;
    }

}
