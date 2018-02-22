package com.example.asus.pantallas_hotelspa;

/**
 * Created by ulises.
 */

public class Offers {
    private int imageId;
    private String name;
    private String price;
    private String offers;

    public Offers(int imageId, String name, String price, String offers){
        this.imageId=imageId;
        this.name=name;
        this.price=price;
        this.offers=offers;
    }
    public Offers(){
        this(R.mipmap.ic_launcher_round, "unamed","", "");
    }

    public int getImageId() {
        return imageId;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getOffers() {
        return offers;
    }
}
