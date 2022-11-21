package com.mayyar.marketpricing.supermarket;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UnitsOfItem {
    Item item;
    int quantity;
}