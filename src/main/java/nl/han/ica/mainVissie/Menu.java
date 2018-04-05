package nl.han.ica.mainVissie;

import nl.han.ica.OOPDProcessingEngineHAN.Dashboard.Dashboard;
import nl.han.ica.OOPDProcessingEngineHAN.Engine.GameEngine;

/**
 * Klasse om verschillende soorten menu's mee aan te maken
 */
public abstract class Menu extends Dashboard
{
    protected GameEngine g;

    /**
     * @param g GameEngine
     * @param x x positie
     * @param y y positie
     * @param width breedte
     * @param height hoogte
     */
    public Menu(GameEngine g, float x, float y, float width, float height)
    {
        super(x, y, width, height);
        this.g = g;
    }

    /**
     * Maak het menu aan
     * @param g GameEngine
     * @param o Oceaan
     * @param tekst tekst
     */
    public abstract void maakMenuAan(GameEngine g, Oceaan o, String tekst);
}
