package com.bliepy;

import java.util.ArrayList;
import java.util.List;

public class SwipeImage {

    private int imageId;
    private String imageName;
    private boolean imageEurope;

    public SwipeImage() {
    }

    public SwipeImage(int imageId, String imageName, boolean imageEurope) {
        this.imageId = imageId;
        this.imageName = imageName;
        this.imageEurope = imageEurope;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public boolean isImageEurope() {
        return imageEurope;
    }

    public void setImageEurope(boolean imageEurope) {
        this.imageEurope = imageEurope;
    }

    public static List<SwipeImage> demoData(){

        List<SwipeImage> data = new ArrayList<>();

        data.add(new SwipeImage(R.drawable.img1_yes_denmark,"Denmark", true));
        data.add(new SwipeImage(R.drawable.img2_no_canada,"Canada", false));
        data.add(new SwipeImage(R.drawable.img3_no_bangladesh,"Bangladesh", true));
        data.add(new SwipeImage(R.drawable.img4_yes_kazachstan,"Kazachstan", true));
        data.add(new SwipeImage(R.drawable.img5_no_colombia,"Colombia", false));
        data.add(new SwipeImage(R.drawable.img6_yes_poland,"Polen", true));
        data.add(new SwipeImage(R.drawable.img7_yes_malta,"Malta", true));
        data.add(new SwipeImage(R.drawable.img8_no_thailand,"Thailand", false));
        return data;
    }
}
