package nl.han.ica.mainVissie;

import nl.han.ica.OOPDProcessingEngineHAN.Engine.GameEngine;
import nl.han.ica.OOPDProcessingEngineHAN.UserInput.IMouseInput;
import processing.core.PApplet;
import processing.core.PGraphics;

public abstract class Knop {
    protected GameEngine g;
    protected Oceaan o;

    protected float x, y, breedte, hoogte;

    public Knop(GameEngine g, Oceaan o, float x, float y, float breedte, float hoogte) {
        this.g = g;
        this.x = x;
        this.y = y;
        this.breedte = breedte;
        this.hoogte = hoogte;
        this.o = o;
    }

    public boolean isMuisOverKnop(int xMuis, int yMuis) {
        if (xMuis >= x && xMuis < x + breedte &&
                yMuis >= y && yMuis < y + hoogte) {
            return true;
        } else {
            return false;
        }
    }

    public abstract void tekenKnop();

    public abstract void doeKnopActie();
}

