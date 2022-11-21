package com.mayyar.marketpricing.pricingcalculator;

import com.mayyar.marketpricing.supermarket.ShoppingCart;

public interface PricingCalculator {
    double determineBasePrice(ShoppingCart shoppingCart);

}
