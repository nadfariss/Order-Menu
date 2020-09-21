package org.orders.system;

import java.util.*;

public class Breakfast implements Meal{

    final static String main = Constants.EGG;
    final static String side = Constants.TOAST;
    final static String drinks = Constants.COFFEE;

    public String displayMap(Collection<Integer> ids) {
        List<Integer> list = new ArrayList<>(ids);
        String message="";
        if(list.size()==0)
            message = "Unable to process: Main is missing, side is missing";
        if(list.size()==1)
             message = "Unable to process: Side is missing";

            if(list.size()>2) {
                message =main + Constants.COMMA+ side + Constants.COMMA+
                        MealUtils.countItemsOrdered(drinks, list, 2);
            }
            else if (list.size()==2){
                message = main
                        + Constants.COMMA
                        + side
                        + Constants.COMMA
                        + Constants.WATER;
            }
            return message;
    }
}
