package io.e1m1;

public class Item {

    int id;
    String displayName;
    double weight;
    int value;
    String description;

    public Item(int id, String displayName, double weight, int value, String description) {
        this.id = id;
        this.displayName = displayName;
        this.weight = weight;
        this.value = value;
        this.description = description;
    }

    public int getId() {
        return this.id;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public double getWeight() {
        return this.weight;
    }

    public int getValue() {
        return this.value;
    }

    public String getDescription() {
        return this.description;
    }

}