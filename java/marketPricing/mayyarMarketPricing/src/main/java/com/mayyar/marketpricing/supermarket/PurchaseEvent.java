package com.mayyar.marketpricing.supermarket;

import com.mayyar.marketpricing.pricingcalculator.PricingCalculator;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PurchaseEvent {
    ShoppingCart shoppingCart;
    PricingCalculator pricingCalculator;

    public double determinePrice() {
        return this.pricingCalculator.determineBasePrice(shoppingCart);
    }
}
