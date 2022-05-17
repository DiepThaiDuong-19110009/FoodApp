package hcmute.edu.vn.foodapp_08.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(foreignKeys =
@ForeignKey(entity = Store.class, parentColumns = "store_id", childColumns = "store_id"))
public class Food implements Serializable {
    @PrimaryKey(autoGenerate = true)
    public int food_id;
    @ColumnInfo(name = "store_id")
    public int storeId;
    public String nameFood;
    public String priceFood;
    public int imgFood;

    public Food() {
    }

    public Food(int storeId, String nameFood, String priceFood, int imgFood) {
        this.storeId = storeId;
        this.nameFood = nameFood;
        this.priceFood = priceFood;
        this.imgFood = imgFood;
    }

    public int getFood_id() {
        return food_id;
    }

    public void setFood_id(int food_id) {
        this.food_id = food_id;
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public String getNameFood() {
        return nameFood;
    }

    public void setNameFood(String nameFood) {
        this.nameFood = nameFood;
    }

    public String getPriceFood() {
        return priceFood;
    }

    public void setPriceFood(String priceFood) {
        this.priceFood = priceFood;
    }

    public int getImgFood() {
        return imgFood;
    }

    public void setImgFood(int imgFood) {
        this.imgFood = imgFood;
    }
}
