
package com.example.mundopoke.model.detalhes;

import com.google.gson.annotations.SerializedName;

public class Other {

    @SerializedName("dream_world")
    private DreamWorld dreamWorld;
    @SerializedName("official-artwork")
    private OfficialArtwork officialArtwork;

    public DreamWorld getDreamWorld() {
        return dreamWorld;
    }

    public void setDreamWorld(DreamWorld dreamWorld) {
        this.dreamWorld = dreamWorld;
    }

    public OfficialArtwork getOfficialArtwork() {
        return officialArtwork;
    }

    public void setOfficialArtwork(OfficialArtwork officialArtwork) {
        this.officialArtwork = officialArtwork;
    }

}
