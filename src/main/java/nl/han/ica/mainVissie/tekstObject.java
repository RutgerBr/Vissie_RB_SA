package nl.han.ica.mainVissie;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;
import processing.core.PGraphics;

public class tekstObject extends GameObject {
    private String tekst;
    private float x;
    private float y;

    /**
     * Constructor
     *
     * @param tekst De tekst die moet verschijnen
     * @param x x-positie
     * @param y y-positie
     */
    public tekstObject(String tekst, float x, float y) {
        this.tekst = tekst;
        this.x = x;
        this.y = y;
    }

    /**
     * setter van de tekst
     */
    public void setTekst(String tekst) {
        this.tekst = tekst;
    }

    @Override
    public void update() {

    }

    /**
     * tekent het tekstobject.
     */
    @Override
    public void draw(PGraphics g) {
        g.textAlign(g.LEFT, g.TOP);
        g.textSize(50);
        g.text(tekst, x, y);
    }
}
