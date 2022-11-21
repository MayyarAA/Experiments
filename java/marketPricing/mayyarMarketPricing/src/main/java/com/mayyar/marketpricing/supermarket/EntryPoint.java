package com.mayyar.marketpricing.supermarket;

import java.util.HashMap;
import java.util.HashSet;

import com.mayyar.marketpricing.SingleUnitPricingDeals;
import com.mayyar.marketpricing.Utils.Logger;
import com.mayyar.marketpricing.pricingcalculator.PricingCalculator;
import com.mayyar.marketpricing.pricingcalculator.PricingCalculatorBaseImpl;
import com.mayyar.marketpricing.pricingmodel.PricingModel;
import com.mayyar.marketpricing.pricingmodel.SingleUnitPricingModel;

public class EntryPoint {
    String soupCan = "soupCan";
    String packOfEggs = "packOfEggs";
    String yougurt = "yougurt";

    public void start() {
        Logger.start(EntryPoint.class.getName());
        HashMap<String, UnitsOfItem> unitsOfItemsPurchased = generateUnitsOfItemsPurchased();
        ShoppingCart shoppingCart = ShoppingCart.builder().unitsOfItemsPurchased(unitsOfItemsPurchased).build();
        HashMap<String, HashSet<SingleUnitPricingDeals>> discountedPriceModelForItem = generateDiscountedPriceModelForItem();
        SingleUnitPricingModel pricingModel = SingleUnitPricingModel.builder()
                .discountedPriceModelForItem(discountedPriceModelForItem).build();
        PricingCalculator pricingCalculator = PricingCalculatorBaseImpl.builder().singleUnitPricingModel(pricingModel)
                .build();
        Logger.log("pricingCalculator " + pricingCalculator.determineBasePrice(shoppingCart));
        Logger.end(EntryPoint.class.getName());
    }

    private HashMap<String, HashSet<SingleUnitPricingDeals>> generateDiscountedPriceModelForItem() {
        HashMap<String, HashSet<SingleUnitPricingDeals>> map = new HashMap<>();
        HashSet<SingleUnitPricingDeals> set1 = new HashSet<>();
        set1.add(SingleUnitPricingDeals.BuyOneGetSecondFree);
        set1.add(SingleUnitPricingDeals.BuyTwoGetThirdFree);
        map.put(soupCan, set1);

        HashSet<SingleUnitPricingDeals> set2 = new HashSet<>();
        set2.add(SingleUnitPricingDeals.BuyTwoGetThirdFree);
        map.put(packOfEggs, set1);

        HashSet<SingleUnitPricingDeals> set3 = new HashSet<>();
        map.put(yougurt, set3);
        return null;
    }

    private HashMap<String, UnitsOfItem> generateUnitsOfItemsPurchased() {
        HashMap<String, UnitsOfItem> result = new HashMap<>();
        UnitsOfItem unitsOfItem1 = UnitsOfItem.builder().item(generateItem("soupCan")).quantity(2).build();
        UnitsOfItem unitsOfItem2 = UnitsOfItem.builder().item(generateItem("packOfEggs")).quantity(3).build();
        UnitsOfItem unitsOfItem3 = UnitsOfItem.builder().item(generateItem("yougurt")).quantity(1).build();
        result.put(soupCan, unitsOfItem1);
        result.put(packOfEggs, unitsOfItem2);
        result.put(yougurt, unitsOfItem3);
        return result;
    }

    private Item generateItem(String sku) {
        return null;
    }
}