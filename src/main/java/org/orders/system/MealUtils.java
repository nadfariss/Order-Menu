package org.orders.system;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public final class MealUtils {
    private MealUtils(){}

 public static  Collection<Integer> mapItemsValues(Collection<Integer> collection){
     Map<Integer,Integer> hmap= new LinkedHashMap<>();
     if(!collection.isEmpty())
         for (Integer integer : collection) {
             if (hmap.containsKey(integer))
                 hmap.put(integer, hmap.get(integer) + 1);
             else
                 hmap.put(integer, 1);
         }
     return  hmap.values();
 }
    public static <T, U> List<U>
    convertFromStringListToIntList(List<T> listOfString,
                               Function<T, U> function)
    {
        return listOfString.stream()
                .map(function)
                .collect(Collectors.toList());
    }
    public static String countItemsOrdered(String item, List<Integer> list, int index){
        return  (list.get(index)>1) ? item.concat(Constants.OPENPARENTHESIS)
                        .concat(String.valueOf(list.get(index)))
                        .concat(Constants.CLOSEPARENTHESIS) :item;
    }
}
