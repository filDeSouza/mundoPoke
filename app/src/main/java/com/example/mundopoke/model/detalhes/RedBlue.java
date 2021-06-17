
package com.example.mundopoke.model.detalhes;

import com.google.gson.annotations.SerializedName;

public class RedBlue {

    @SerializedName("back_default")
    private String backDefault;
    @SerializedName("back_gray")
    private String backGray;
    @SerializedName("front_default")
    private String frontDefault;
    @SerializedName("front_gray")
    private String frontGray;

    public String getBackDefault() {
        return backDefault;
    }

    public void setBackDefault(String backDefault) {
        this.backDefault = backDefault;
    }

    public String getBackGray() {
        return backGray;
    }

    public void setBackGray(String backGray) {
        this.backGray = backGray;
    }

    public String getFrontDefault() {
        return frontDefault;
    }

    public void setFrontDefault(String frontDefault) {
        this.frontDefault = frontDefault;
    }

    public String getFrontGray() {
        return frontGray;
    }

    public void setFrontGray(String frontGray) {
        this.frontGray = frontGray;
    }

}
