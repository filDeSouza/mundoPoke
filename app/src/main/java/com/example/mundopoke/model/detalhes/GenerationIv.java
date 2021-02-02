
package com.example.mundopoke.model.detalhes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GenerationIv {

    @SerializedName("diamond-pearl")
    private DiamondPearl diamondPearl;
    @SerializedName("heartgold-soulsilver")
    private HeartgoldSoulsilver heartgoldSoulsilver;
    @Expose
    private Platinum platinum;

    public DiamondPearl getDiamondPearl() {
        return diamondPearl;
    }

    public void setDiamondPearl(DiamondPearl diamondPearl) {
        this.diamondPearl = diamondPearl;
    }

    public HeartgoldSoulsilver getHeartgoldSoulsilver() {
        return heartgoldSoulsilver;
    }

    public void setHeartgoldSoulsilver(HeartgoldSoulsilver heartgoldSoulsilver) {
        this.heartgoldSoulsilver = heartgoldSoulsilver;
    }

    public Platinum getPlatinum() {
        return platinum;
    }

    public void setPlatinum(Platinum platinum) {
        this.platinum = platinum;
    }

}
