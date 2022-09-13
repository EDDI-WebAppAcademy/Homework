package kr.eddi.demo.entity.basic.practiceQuestion;

public enum UseItemList {

    APPLE("사과"),
    TANGERINE("귤"),
    ROTAPPLE("썩은 사과"),
    GRAPE("포도"),
    BREAD("빵"),
    GOLDENAPPLE("황금사과");


    private String name;
    private UseItemList(String name){this.name = name;}
}
