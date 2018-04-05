package nl.han.ica.mainVissie;

import nl.han.ica.OOPDProcessingEngineHAN.Engine.GameEngine;
import processing.core.PGraphics;

/**
 * Klasse voor een knop om het spel mee (opnieuw) te starten
 */
public class StartKnop extends Knop
{

    /**
     * @param g GameEngine
     * @param o Oceaan
     * @param x x positie
     * @param y y positie
     * @param breedte breedte
     * @param hoogte hoogte
     */
    public StartKnop(GameEngine g, Oceaan o, float x, float y, int breedte, int hoogte)
    {
        super(g, o, x, y, breedte, hoogte);
    }

    /**
     * Tekent de knop op de eerder bepaalde positie
     * @param pg
     */
    @Override
    public void tekenKnop(PGraphics pg)
    {
        pg.fill(50, 150, 50);
        pg.rect(super.x, super.y, super.breedte, super.hoogte);
    }

    /**
     * Verwijdert alle objecten die met de game te maken hebben, maakt een nieuwe oceaan en speler
     */
    @Override
    public void doeKnopActie()
    {
        g.deleteAllGameOBjects();
        g.deleteAllDashboards();
        o = new Oceaan(g);
        o.createViewWithViewport(g, 1000, 800, 1f);
        o.maakSpelerAan(g);
    }

    @Override
    public void update()
    {

    }

    @Override
    public void draw(PGraphics g)
    {
        tekenKnop(g);
    }
}
