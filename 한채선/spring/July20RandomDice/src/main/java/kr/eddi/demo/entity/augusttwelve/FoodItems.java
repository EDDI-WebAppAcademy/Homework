package kr.eddi.demo.entity.augusttwelve;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FoodItems {

    private Map<String, Integer> foodItems;
    private Map<String, Map<String, Integer>> skillList;

    private String bread = "HP를 5 올립니다.";
    private String apple = "HP를 3 올립니다.";
    private String wine = "공격력을 2 올립니다.";
    private String soup = "방어력을 2 올립니다.";

    private final int BREAD_HP = 5;
    private final int APPLE_HP = 3;
    private final int WINE_ATK = 2;
    private final int SOUP_DEF = 2;

    public void setFoodItemnSkill() {
        foodItems = new HashMap<>();
        skillList = new HashMap<String, Map<String, Integer>>();
        foodItems.put("bread", BREAD_HP);
        foodItems.put("apple", APPLE_HP);
        foodItems.put("wine", WINE_ATK);
        foodItems.put("soup", SOUP_DEF);

        for (int i = 0; i < foodItems.size(); i++) {
            switch (i) {
                case 0 -> skillList.put(bread, foodItems);
                case 1 -> skillList.put(apple, foodItems);
                case 2 -> skillList.put(wine, foodItems);
                case 3 -> skillList.put(soup, foodItems);
            }
        }
    }

    public void applyFoodSkills(String food, List<Player> players, int playerIdx) {
        String findFoodIdx = food;
        switch (findFoodIdx) {
            case "bread", "apple" -> players.get(playerIdx).sethp(skillList.get(food).get(findFoodIdx));
            case "wine" -> players.get(playerIdx).setAtk(skillList.get(food).get(findFoodIdx));
            case "soup" -> players.get(playerIdx).setDef(skillList.get(food).get(findFoodIdx));
        }
    }
}
