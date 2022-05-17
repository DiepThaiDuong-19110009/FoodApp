package hcmute.edu.vn.foodapp_08.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class Store implements Serializable {
    @PrimaryKey(autoGenerate = true)
    public int store_id;
    public String nameStore;
    public String descriptionStore;
    public String locationStore;
    public int imageStore;

    public Store() {
    }

    public Store(String nameStore, String descriptionStore, String locationStore, int imageStore) {
        this.nameStore = nameStore;
        this.descriptionStore = descriptionStore;
        this.locationStore = locationStore;
        this.imageStore = imageStore;
    }

    public int getStore_id() {
        return store_id;
    }

    public void setStore_id(int store_id) {
        this.store_id = store_id;
    }

    public String getNameStore() {
        return nameStore;
    }

    public void setNameStore(String nameStore) {
        this.nameStore = nameStore;
    }

    public String getDescriptionStore() {
        return descriptionStore;
    }

    public void setDescriptionStore(String descriptionStore) {
        this.descriptionStore = descriptionStore;
    }

    public String getLocationStore() {
        return locationStore;
    }

    public void setLocationStore(String locationStore) {
        this.locationStore = locationStore;
    }

    public int getImageStore() {
        return imageStore;
    }

    public void setImageStore(int imageStore) {
        this.imageStore = imageStore;
    }
}
