package com.mayyar.marketpricing.supermarket;

import java.util.HashMap;
import java.util.List;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ShoppingCart {
    List<Item> items;
    HashMap<String, UnitsOfItem> unitsOfItemsPurchased;
}
