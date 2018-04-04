package nl.han.ica.mainVissie;

import nl.han.ica.OOPDProcessingEngineHAN.Engine.GameEngine;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;
import nl.han.ica.OOPDProcessingEngineHAN.UserInput.IMouseInput;
import processing.core.PApplet;
import processing.core.PGraphics;

/**
 * Klasse om andere knoppen mee aan te maken
 */
public abstract class Knop extends GameObject
{
    protected GameEngine g;
    protected Oceaan o;

    protected float x, y, breedte, hoogte;

    /**
     * @param g GameEngine
     * @param o Oceaan
     * @param x x positie
     * @param y y positie
     * @param breedte breedte
     * @param hoogte hoogte
     */
    public Knop(GameEngine g, Oceaan o, float x, float y, float breedte, float hoogte) {
        this.g = g;
        this.x = x;
        this.y = y;
        this.breedte = breedte;
        this.hoogte = hoogte;
        this.o = o;
    }

    /**
     * @return true als muis over de knop is
     */
    public boolean isMuisOverKnop() {
        if (g.mouseX >= x && g.mouseX < x + breedte &&
                g.mouseY >= y && g.mouseY < y + hoogte) {
            return true;
        } else {
            return false;
        }
    }

    public abstract void tekenKnop(PGraphics pg);

    public abstract void doeKnopActie();
}

