package org.orders.system;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Dinner implements Meal {
    final static String main = Constants.STEAK;
    final static String side = Constants.POTATOES;
    final static String drinks = Constants.WINE;
    final static String desserts = Constants.CAKE;

    @Override
    public String displayMap(Collection<Integer> ids) {
        List<Integer> list = new ArrayList<>(ids);
        String message="";
        if(list.size()==0)
             message = "Unable to process: Main is missing, side is missing";
        if(list.size()==1)
             message = "Unable to process: Side is missing";

            if (list.size() > 2) {
                if (list.size() == 3) {
                    message = "Unable to process: Dessert is missing";
                } else {
                    message = main
                            + Constants.COMMA
                            + side
                            + Constants.COMMA
                            + MealUtils.countItemsOrdered(drinks, list, 2)
                            + Constants.COMMA
                            + Constants.WATER
                            + Constants.COMMA
                            + MealUtils.countItemsOrdered(desserts, list, 3);
                }
            }
            return message;
        }
    }
