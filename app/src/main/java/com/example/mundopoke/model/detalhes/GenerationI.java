
package com.example.mundopoke.model.detalhes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GenerationI {

    @SerializedName("red-blue")
    private RedBlue redBlue;
    @Expose
    private Yellow yellow;

    public RedBlue getRedBlue() {
        return redBlue;
    }

    public void setRedBlue(RedBlue redBlue) {
        this.redBlue = redBlue;
    }

    public Yellow getYellow() {
        return yellow;
    }

    public void setYellow(Yellow yellow) {
        this.yellow = yellow;
    }

}
