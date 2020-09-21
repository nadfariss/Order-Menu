package org.orders.system;

public class MealFactory {
    public static Meal create(MealType type){
        switch(type) {
            case BREAKFAST: return new Breakfast();
            case LUNCH: return new Lunch();
            case DINNER: return new Dinner();
            default: throw new IllegalArgumentException("No such a meal " +type);
        }
    }
}
