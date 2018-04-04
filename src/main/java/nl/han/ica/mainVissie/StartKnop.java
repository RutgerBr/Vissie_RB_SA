package nl.han.ica.mainVissie;

import nl.han.ica.OOPDProcessingEngineHAN.Engine.GameEngine;
import nl.han.ica.OOPDProcessingEngineHAN.Sound.Sound;
import processing.core.PGraphics;

public class StartKnop extends Knop
{

    public StartKnop(GameEngine g, Oceaan o, float x, float y, int breedte, int hoogte)
    {
        super(g, o, x, y, breedte, hoogte);
    }

    @Override
    public void tekenKnop(PGraphics pg)
    {
        pg.fill(50, 150, 50);
        pg.rect(super.x, super.y, super.breedte, super.hoogte);
    }

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
