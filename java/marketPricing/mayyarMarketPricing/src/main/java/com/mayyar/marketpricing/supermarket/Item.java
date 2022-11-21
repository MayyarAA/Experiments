package com.mayyar.marketpricing.supermarket;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Builder
@Data
public class Item extends Object {
    @NonNull
    private String sku;
    @NonNull
    private String labelName;
    @NonNull
    private double vendorCostPerABaseUnit;
    @NonNull
    private double customerCostPerABaseUnit;
    @NonNull
    private BaseUnit baseUnit;

}
