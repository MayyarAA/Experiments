package com.mayyar.marketpricing.pricingcalculator;

import com.mayyar.marketpricing.supermarket.Item;
import com.mayyar.marketpricing.supermarket.ShoppingCart;
import com.mayyar.marketpricing.supermarket.UnitsOfItem;

import lombok.Builder;
import lombok.Data;

import com.mayyar.marketpricing.pricingmodel.SingleUnitPricingModel;
import com.mayyar.marketpricing.supermarket.BaseUnit;

@Builder
@Data
public class PricingCalculatorBaseImpl implements PricingCalculator {
    SingleUnitPricingModel singleUnitPricingModel;

    public double determineBasePrice(ShoppingCart shoppingCart) {
        double resultingTotalPrice = 0.0;
        for (String itemUnqiueIdentifier : shoppingCart.getUnitsOfItemsPurchased().keySet()) {
            UnitsOfItem unitsOfItem = shoppingCart.getUnitsOfItemsPurchased().get(itemUnqiueIdentifier);
            resultingTotalPrice += determineAnyDiscountModelOnPrice(unitsOfItem);
        }

        return resultingTotalPrice;
    }

    public double determineAnyDiscountModelOnPrice(UnitsOfItem unitsOfItem) {
        BaseUnit baseUnitOfItem = unitsOfItem.getItem().getBaseUnit();
        if (baseUnitOfItem == BaseUnit.SingleUnit) {
            return singleUnitPricingModel.determinePrice(unitsOfItem);
        } else if (baseUnitOfItem == BaseUnit.Grams) {
            return singleUnitPricingModel.determinePrice(unitsOfItem);
        } else if (baseUnitOfItem == BaseUnit.Mililiters) {
            return singleUnitPricingModel.determinePrice(unitsOfItem);
        }
        return 0.0;
    }
}