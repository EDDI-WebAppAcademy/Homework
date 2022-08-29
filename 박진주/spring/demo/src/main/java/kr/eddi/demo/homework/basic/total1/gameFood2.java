//package kr.eddi.demo.homework.basic.total1;
//
//import kr.eddi.demo.entity.basic.utility.basic.third.CustomRandom;
//
//import java.util.*;
//
//public class gameFood2 {
//
//    private static final int MIN = 1;
//    private static final int MAX = 10;
//
//    public List<String> food;
//
//
//    public List<Integer> ablity;
//
//    public Map<String, List<Integer>> foodAblilty;
//
//    public List<String> makeFood(){
//        food = new ArrayList<>();
//        food.add("apple");
//        food.add("banana");
//        food.add("bread");
//        food.add("ice-cream");
//        System.out.println(food);
//        return food;
//    }
//
//    public List<Integer> makePower(){
//        ablity = new ArrayList<>();
//        for (int i = 0; i < food.size(); i++) {
//            ablity.add(CustomRandom.makeIntCustomRandom(MIN, MAX));
//        }
//        System.out.println(ablity);
//        return ablity;
//    }
//
//
////    public Map<String, Map<Integer, Integer>> makeFoodAbility(List<String> food, List<Integer> abliity){
////        foodAblilty =  new HashMap<String, List<Integer>>();
////
////        for (int i = 0; i < food.size(); i++) {
////            Map<Integer, Integer> abliityEntry = abliity.entrySet().iterator().next();     // 맵 요소를 (인덱스 없음) 반복해서 넣기 위한 코드
////                foodAblilty.put(food.get(i), List<Integer> abliityEntry);
////        }
////        System.out.println(foodAblilty);
////
////        return foodAblilty;
////    }
//
//}
//
//
////1. 이중 해쉬 + for문으로 객체 다루기 + 인터페이스 + 리스트 + 클래스간 정보 연동 문제
//
////게임 아이템 중 음식 클래스 내부에 사과, 귤, 포도, 빵 등을 구현해봅시다.
////음식들을 먹으면 어떤 음식을 먹었냐에 따라서 각기 다른 능력이 발휘됨
////(이건 각자 하고 싶은대로 hp를 회복시키던 공격력을 올리던 등등) <-- 캐릭터 클래스가 하나 필요하긴함.
//
////* for 문으로 객체 다루는 경우엔
////포도를 5개 한 번에 먹기 기능 같은 구현으로 작업합니다.
////* 인터페이스의 경우엔 각각의 과일을 먹었을때 기능이 될 것임.
////* 리스트의 경우엔 과일들을 관리하는 차원에서 필요함.
////
//
