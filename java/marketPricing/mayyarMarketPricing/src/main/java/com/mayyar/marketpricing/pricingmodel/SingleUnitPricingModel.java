package com.mayyar.marketpricing.pricingmodel;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import com.mayyar.marketpricing.SingleUnitPricingDeals;
import com.mayyar.marketpricing.supermarket.Item;
import com.mayyar.marketpricing.supermarket.UnitsOfItem;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class SingleUnitPricingModel implements PricingModel {
    HashSet<String> hasDiscountPricing;
    HashMap<String, HashSet<SingleUnitPricingDeals>> discountedPriceModelForItem;

    @Override
    public double determinePrice(final UnitsOfItem unitsOfItem) {
        Item item = unitsOfItem.getItem();
        int quantity = unitsOfItem.getQuantity();
        double pricePerUnit = item.getCustomerCostPerABaseUnit();
        if (!hasDiscountPricing.contains(item.getSku()))
            return item.getCustomerCostPerABaseUnit() * quantity;

        HashSet<SingleUnitPricingDeals> pricingModelForItem = discountedPriceModelForItem.get(item.getSku());
        if (pricingModelForItem.contains(SingleUnitPricingDeals.BuyFourGetFifthFree)) {
            return determinePriceForDiscountModel(quantity, pricePerUnit, 2);
        } else if (pricingModelForItem.contains(SingleUnitPricingDeals.BuyTwoGetThirdFree)) {
            return determinePriceForDiscountModel(quantity, pricePerUnit, 3);
        } else {
            return determinePriceForDiscountModel(quantity, pricePerUnit, 4);
        }
    }

    private double determinePriceForDiscountModel(int totalUnits, double pricePerUnit, int quantityOfDiscountModel) {
        int purchasedUnits = totalUnits / quantityOfDiscountModel;
        int remainingUnits = totalUnits % quantityOfDiscountModel;
        return purchasedUnits * pricePerUnit + remainingUnits * pricePerUnit;
    }

}