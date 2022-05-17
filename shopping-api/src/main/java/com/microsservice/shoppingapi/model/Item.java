package com.microsservice.shoppingapi.model;

import com.microsservice.shoppingapi.model.dto.ItemDTO;

import javax.persistence.Embeddable;
import java.math.BigDecimal;

@Embeddable
public class Item {

    private String productIdentifier;

    private BigDecimal price;

    public String getProductIdentifier() {
        return productIdentifier;
    }

    public void setProductIdentifier(String productIdentifier) {
        this.productIdentifier = productIdentifier;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public static Item convert(ItemDTO itemDTO) {
        Item item = new Item();
        item.setProductIdentifier(itemDTO.getProductIdentifier());
        item.setPrice(itemDTO.getPrice());
        return item;
    }
}
