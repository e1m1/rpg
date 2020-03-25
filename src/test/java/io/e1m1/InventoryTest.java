package io.e1m1;

import org.junit.Test;

public class InventoryTest {

    @Test
    public void getTextTable_Test() {

        Inventory testInventory = new Inventory();
        testInventory.putItem(new Item(0, "Fancy Sword", 8.5, 20, "A fancy sword with fancy jewels"));
        testInventory.putItem(new Item(1, "Fancy Shield", 21, 300, "A fancy shield"));
        testInventory.putItem(new Item(2, "Jewel", 0.1, 500, "A very valuable jewel!"));

        System.out.println(testInventory.toString());
    }
}