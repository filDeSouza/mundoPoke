
package com.example.mundopoke.model.detalhes;

import com.google.gson.annotations.SerializedName;

public class GenerationVi {

    @SerializedName("omegaruby-alphasapphire")
    private OmegarubyAlphasapphire omegarubyAlphasapphire;
    @SerializedName("x-y")
    private XY xY;

    public OmegarubyAlphasapphire getOmegarubyAlphasapphire() {
        return omegarubyAlphasapphire;
    }

    public void setOmegarubyAlphasapphire(OmegarubyAlphasapphire omegarubyAlphasapphire) {
        this.omegarubyAlphasapphire = omegarubyAlphasapphire;
    }

    public XY getXY() {
        return xY;
    }

    public void setXY(XY xY) {
        this.xY = xY;
    }

}
