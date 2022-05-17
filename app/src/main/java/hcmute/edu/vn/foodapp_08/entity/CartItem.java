package hcmute.edu.vn.foodapp_08.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(foreignKeys = {
        @ForeignKey(
                entity = Food.class,
                parentColumns = "food_id",
                childColumns = "food_id"
        ),
        @ForeignKey(
                entity = Cart.class,
                parentColumns = "id",
                childColumns = "cart_id"
        )
})
public class CartItem implements Serializable {
    @PrimaryKey(autoGenerate = true)
    public int cartItemId;
    @ColumnInfo(name = "cart_id")
    public String cartId;
    @ColumnInfo(name = "food_id")
    public int foodId;
    public int quantity;
    public int imageFoodCartItem;

    public CartItem() {
    }

    public CartItem(String cartId, int foodId, int quantity, int imageFoodCartItem) {
        this.cartId = cartId;
        this.foodId = foodId;
        this.quantity = quantity;
        this.imageFoodCartItem = imageFoodCartItem;
    }

    public int getCartItemId() {
        return cartItemId;
    }

    public void setCartItemId(int cartItemId) {
        this.cartItemId = cartItemId;
    }

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    public int getFoodId() {
        return foodId;
    }

    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getImageFoodCartItem() {
        return imageFoodCartItem;
    }

    public void setImageFoodCartItem(int imageFoodCartItem) {
        this.imageFoodCartItem = imageFoodCartItem;
    }
}
