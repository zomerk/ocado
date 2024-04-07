package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.*;
/**
 * This class represents a BasketSplitter which splits a list of items into delivery packages based on a configuration file.
 */
public class BasketSplitter {
    private  Map<String, List<String>> productsList = new HashMap<>(); // Map to store product configurations
    /**
     * Constructs a BasketSplitter object with the specified absolute path to the configuration file.
     *
     * @param absolutePathToConfigFile The absolute path to the configuration file
     */
    public BasketSplitter(String absolutePathToConfigFile) {
        // Initialize ObjectMapper to read JSON
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            File configFile = new File(absolutePathToConfigFile);
            // Read the configuration file and store the products list
            productsList = objectMapper.readValue(configFile, Map.class);
        } catch (IOException e) {
            e.printStackTrace(); // Print stack trace in case of an IO exception
        }
    }
    /**
     * Splits the given list of items into delivery packages based on the configured products.
     *
     * @param items The list of items to be split into delivery packages
     * @return A map representing the delivery packages where the key is the delivery option and the value is the list of items for that option
     */
    public Map<String, List<String>> split(List<String> items) {
      Map<String, List<String>> deliveryPackages = new HashMap<>(); // Map to store delivery packages
      // Continue splitting items until the items list is empty
      while(!items.isEmpty()){
          Map<String,Integer> productsCountInPackages = new HashMap<>(); // Map to store product counts in packages

          // Count occurrences of products for each delivery option
          for (var item : items) {
              var deliveryOptions = productsList.get(item);
              for (var delivery : deliveryOptions) {
                  productsCountInPackages.put(delivery, productsCountInPackages.getOrDefault(delivery, 0) + 1);
              }
          }

          // Find the delivery option with the maximum count
          int maxValue = Integer.MIN_VALUE;
          String maxKey = null;
          for (var entry : productsCountInPackages.entrySet()) {
              if (entry.getValue() > maxValue) {
                  maxValue = entry.getValue();
                  maxKey = entry.getKey();
              }
          }

          // Collect items for the delivery option with the maximum count
          var productsToSendWithOneDelivery = new ArrayList<String>();
          for (var item : items) {
              var deliveryOptions = productsList.get(item);
              if (deliveryOptions.contains(maxKey)) {
                  productsToSendWithOneDelivery.add(item);
              }
          }

          // Add the collected items to the delivery package
          deliveryPackages.put(maxKey, productsToSendWithOneDelivery);

          // Remove the collected items from the original list
          productsToSendWithOneDelivery.forEach(items::remove);
      }
      return deliveryPackages;
  }
}
