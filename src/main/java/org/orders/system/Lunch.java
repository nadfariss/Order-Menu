package org.orders.system;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Lunch implements Meal{
    final static String main =Constants.SALAD;
    final static String side =Constants.CHIPS;
    final static String drinks =Constants.SODA;

    @Override
        public String displayMap(Collection<Integer> ids) {
        List<Integer> list = new ArrayList<>(ids);
        String message="";
        if(list.size()==0)
            message = "Unable to process: Main is missing, side is missing";
        if(list.size()==1)
            message = "Unable to process: Side is missing";

        if ((list.get(0) > 1)) {
            message="Unable to process: Salad cannot be ordered more than once";
        } else
            if(list.size()>2) {
                message = main
                        + Constants.COMMA 
                        + MealUtils.countItemsOrdered(side, list, 1) 
                        + Constants.COMMA
                        + MealUtils.countItemsOrdered(drinks, list, 2);
            }
            else if (list.size()==2){
                message = main
                        + Constants.COMMA
                        + MealUtils.countItemsOrdered(side, list, 1)
                        + Constants.COMMA
                        + Constants.WATER;
            }
            return message;
    }
}