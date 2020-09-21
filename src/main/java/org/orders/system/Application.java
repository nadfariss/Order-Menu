package org.orders.system;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.orders.system.MealUtils.convertFromStringListToIntList;

public class Application {
    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) throws IOException {
log.info("Order System!!");
        File file = new File(Constants.PATH);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        String message="";
        while ((line = br.readLine()) != null) {
            String[] lineArray = line.split(" ");
            List<Integer> listOfInteger;
             if (lineArray.length == 1) {
                System.out.println("Unable to process: Main is missing, side is missing");
                continue;
            } else {
               String type = line.split(" ")[0];
               MealType mealType = MealType.valueOf(type.toUpperCase());
                Meal meal =MealFactory.create(mealType);

                if( line.split(" ")[1]
                          .split(",")
                          .length ==1) {
                      System.out.println("Unable to process: Side is missing");
                      continue;
                  }
                  else {
                      listOfInteger = convertFromStringListToIntList(
                              Arrays.asList(line.split(" ")[1]
                                      .split(",")), Integer::parseInt);
                  }

                 Collection<Integer> collection= listOfInteger;
                  Order order = new Order(meal,collection);
                 collection = MealUtils.mapItemsValues(listOfInteger);
                  System.out.println(order.getMeal().displayMap(collection));
                  }
        }

    }
}
