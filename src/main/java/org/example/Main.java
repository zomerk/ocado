package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        BasketSplitter basketSplitter = new BasketSplitter("/Users/zomer/IdeaProjects/ocado/src/main/resources/config.json");

        // Array of items to be split into delivery packages
        String[] itemsArray = {
                "Fond - Chocolate", "Chocolate - Unsweetened", "Nut - Almond, Blanched, Whole", "Haggis", "Mushroom - Porcini Frozen", "Cake - Miini Cheesecake Cherry", "Sauce - Mint", "Longan", "Bag Clear 10 Lb", "Nantucket - Pomegranate Pear", "Puree - Strawberry", "Numi - Assorted Teas", "Apples - Spartan", "Garlic - Peeled", "Cabbage - Nappa", "Bagel - Whole White Sesame", "Tea - Apple Green Tea"
        };

        // Convert the array to a list of items
        List<String> itemList = new ArrayList<>(Arrays.asList(itemsArray));

        // Split the items into delivery packages using the BasketSplitter
        var result = basketSplitter.split(itemList);

        // Print the delivery packages
        for(var Package :result.entrySet()){
            System.out.println(Package.getKey() + " " + Package.getValue());
        }
    }
}