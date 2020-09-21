package org.orders.system;

import java.util.*;

public class Order {
    Meal meal;
    Collection<Integer> collection;

    public Order(Meal meal, Collection<Integer> collection) {
        this.meal = meal;
        this.collection=collection;

    }

    public Meal getMeal() {
        return meal;
    }

    public Collection<Integer> getCollection() {
        return collection;
    }

    public void setCollection(Collection<Integer> collection) {
        this.collection = collection;
    }
}
