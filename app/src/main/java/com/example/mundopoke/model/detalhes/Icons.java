
package com.example.mundopoke.model.detalhes;

import com.google.gson.annotations.SerializedName;


public class Icons {

    @SerializedName("front_default")
    private String frontDefault;
    @SerializedName("front_female")
    private Object frontFemale;

    public String getFrontDefault() {
        return frontDefault;
    }

    public void setFrontDefault(String frontDefault) {
        this.frontDefault = frontDefault;
    }

    public Object getFrontFemale() {
        return frontFemale;
    }

    public void setFrontFemale(Object frontFemale) {
        this.frontFemale = frontFemale;
    }

}
