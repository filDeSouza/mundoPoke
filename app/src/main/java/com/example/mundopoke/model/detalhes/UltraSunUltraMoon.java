
package com.example.mundopoke.model.detalhes;

import com.google.gson.annotations.SerializedName;


public class UltraSunUltraMoon {

    @SerializedName("front_default")
    private String frontDefault;
    @SerializedName("front_female")
    private Object frontFemale;
    @SerializedName("front_shiny")
    private String frontShiny;
    @SerializedName("front_shiny_female")
    private Object frontShinyFemale;

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

    public String getFrontShiny() {
        return frontShiny;
    }

    public void setFrontShiny(String frontShiny) {
        this.frontShiny = frontShiny;
    }

    public Object getFrontShinyFemale() {
        return frontShinyFemale;
    }

    public void setFrontShinyFemale(Object frontShinyFemale) {
        this.frontShinyFemale = frontShinyFemale;
    }

}
