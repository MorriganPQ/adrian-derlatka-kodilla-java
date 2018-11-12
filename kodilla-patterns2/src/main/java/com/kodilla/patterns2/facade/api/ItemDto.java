package com.kodilla.patterns2.facade.api;

public final class ItemDto {
    private final long productId;
    private final double quantity;

    public ItemDto(final long productId, final double quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    public long getProductId() {
        return productId;
    }

    public double getQuantity() {
        return quantity;
    }
}
