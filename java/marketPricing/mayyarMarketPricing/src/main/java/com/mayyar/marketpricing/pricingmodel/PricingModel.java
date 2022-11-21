package com.mayyar.marketpricing.pricingmodel;

import com.mayyar.marketpricing.supermarket.Item;
import com.mayyar.marketpricing.supermarket.UnitsOfItem;

public interface PricingModel {
    double determinePrice(UnitsOfItem item);
}