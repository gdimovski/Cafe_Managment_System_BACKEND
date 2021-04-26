package mk.ukim.finki.wpproekt.seminarska.web.dto;

public class OrderItemInput {

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer quantity;
    public Long productId;
}
