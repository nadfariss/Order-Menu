package org.orders.system;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.*;

/**
 * Unit test for  Application.
 */
public class applicationTest
{
    Order order;
    Collection<Integer> collection;
    Meal breakfast =MealFactory.create(MealType.BREAKFAST);
    Meal lunch =MealFactory.create(MealType.LUNCH);
    Meal dinner =MealFactory.create(MealType.DINNER);

    @Test
    public void shouldBeInstanceOfInterface()
    {
        assertTrue(breakfast instanceof Meal);
        assertTrue(lunch instanceof Meal);
        assertTrue(dinner instanceof Meal);
    }

    @Test
    public void ShouldBreakfastOrderReturnNameItemsOrdered()
    {

        collection= new ArrayList<>(Arrays.asList(1,2,3));
        order = new Order(breakfast,collection);
        collection = MealUtils.mapItemsValues(collection);
        assertEquals("Same size ",3, collection.size());
        assertEquals("Eggs, Toast, Coffee",order.getMeal().displayMap(collection));
    }
    @Test
    public void ShouldBreakfastOrderReturnsNamesOrderedEvenWhenCollectionNotOrdered()
    {
        collection= new ArrayList<>(Arrays.asList(3,2,1));
        order = new Order(breakfast,collection);
        collection = MealUtils.mapItemsValues(collection);
        assertEquals("Same size ",3, collection.size());
        assertEquals("Eggs, Toast, Coffee",order.getMeal().displayMap(collection));
    }
    @Test
    public void ShouldBreakfastOrderReturnWaterIfNoDrinks()
    {
        collection= new ArrayList<>(Arrays.asList(1,2));
        order = new Order(breakfast,collection);
        collection = MealUtils.mapItemsValues(collection);
        assertEquals("Same size ",2, collection.size());
        assertEquals("Eggs, Toast, Water",order.getMeal().displayMap(collection));
    }
    @Test
    public void ShouldBreakfastOrderNumberOfItemsBeIndicated()
    {
        collection= new ArrayList<>(Arrays.asList(1,2,3,3,3));
        order = new Order(breakfast,collection);
        collection = MealUtils.mapItemsValues(collection);
        assertEquals("Same size ",3, collection.size());
        assertEquals("Eggs, Toast, Coffee(3)",order.getMeal().displayMap(collection));
    }
    @Test
    public void ShouldBreakfastOrderContainsBothMainAndSide()
    {
        collection= new ArrayList<>(Collections.singletonList(1));
        order = new Order(breakfast,collection);
        collection = MealUtils.mapItemsValues(collection);
        assertEquals("Same size ",1, collection.size());
        assertEquals("Unable to process: Side is missing",order.getMeal().displayMap(collection));
    }
    @Test
    public void ShouldBreakfastOrderSendAnErrorIfOnlyMealTypeIsSupplied()
    {
        collection= new ArrayList<>(Collections.emptyList());
        order = new Order(breakfast,collection);
        collection = MealUtils.mapItemsValues(collection);
        assertEquals("Same size ",0, collection.size());
        assertEquals("Unable to process: Main is missing, side is missing",order.getMeal().displayMap(collection));
    }

    @Test
    public void ShouldLunchOrderReturnsNamesItemsOrdered()
    {

        collection= new ArrayList<>(Arrays.asList(1,2,3));
        order = new Order(lunch,collection);
        collection = MealUtils.mapItemsValues(collection);
        assertEquals("Same size ",3, collection.size());
        assertEquals("Salad, Chips, Soda",order.getMeal().displayMap(collection));
    }
    @Test
    public void ShouldLunchOrderReturnsNamesOrderedEvenWhenCollectionNotOrdered()
    {
        collection= new ArrayList<>(Arrays.asList(3,2,1));
        order = new Order(lunch,collection);
        collection = MealUtils.mapItemsValues(collection);
        assertEquals("Same size ",3, collection.size());
        assertEquals("Salad, Chips, Soda",order.getMeal().displayMap(collection));
    }
    @Test
    public void shouldLunchNotAllowMoreThanOneSalad()
    {
        collection= new ArrayList<>(Arrays.asList(1,1,2,3));
        order = new Order(lunch,collection);
        collection = MealUtils.mapItemsValues(collection);
        assertEquals("Same size ",3, collection.size());
        assertEquals("Unable to process: Salad cannot be ordered more than once",order.getMeal().displayMap(collection));
    }
    @Test
    public void ShouldLunchOrderNotAllowMultipleSides()
    {
        collection= new ArrayList<>(Arrays.asList(1,2,2,3));
        order = new Order(lunch,collection);
        collection = MealUtils.mapItemsValues(collection);
        assertEquals("Same size ",3, collection.size());
    }
    @Test
    public void ShouldLunchOrderReturnWaterIfNoDrinks()
    {
        collection= new ArrayList<>(Arrays.asList(1,2));
        order = new Order(lunch,collection);
        collection = MealUtils.mapItemsValues(collection);
        assertEquals("Same size ",2, collection.size());
        assertEquals("Salad, Chips, Water",order.getMeal().displayMap(collection));
    }

    @Test
    public void ShouldDinnerOrderNotAllowWithoutDessert()
    {
        collection= new ArrayList<>(Arrays.asList(1,2,3));
        order = new Order(dinner,collection);
        collection = MealUtils.mapItemsValues(collection);
        assertEquals("Unable to process: Dessert is missing",order.getMeal().displayMap(collection));
    }
    @Test
    public void ShouldDinnerOrderDisplayItemsInOrder()
    {
        collection= new ArrayList<>(Arrays.asList(1,2,3,4));
        order = new Order(dinner,collection);
        collection = MealUtils.mapItemsValues(collection);
        assertEquals("Steak, Potatoes, Wine, Water, Cake",order.getMeal().displayMap(collection));
    }

}