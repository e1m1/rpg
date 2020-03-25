package io.e1m1;

public class Player {
    private String name = "Devon";
    private Inventory inventory;

    public Player() {
        this.inventory = new Inventory();
    }

    public Player(String name) {
        this.name = name;
        this.inventory = new Inventory();
    }

    public Player(String name, Inventory inventory) {
        this.name = name;
        this.inventory = inventory;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Inventory getInventory() {
        return this.inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public String toString() {
        return new StringBuilder()
            .append("Name: ").append(name).append("\n\n")
            .append("Stats:\n")
            .append("TODO stats...\n\n")
            .append("Inventory:\n")
            .append(inventory)
        .toString();
    }
}