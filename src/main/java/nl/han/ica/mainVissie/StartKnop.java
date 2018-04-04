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
        pg.fill(50, 255, 50);
        pg.rect(super.x, super.y, super.breedte, super.hoogte);
    }

    @Override
    public void doeKnopActie()
    {
        g.deleteAllGameOBjects();
        g.deleteAllDashboards();
        o = new Oceaan(g);
        o.maakSpelerAan(g);
        o.maakAiSpawnerAan();
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

    @Override
    public void mouseReleased(int x, int y, int button)
    {

    }

    @Override
    public void mouseClicked(int x, int y, int button)
    {

    }

    @Override
    public void mouseMoved(int x, int y)
    {

    }

    @Override
    public void mouseDragged(int x, int y, int button)
    {

    }

    @Override
    public void mouseWheel(int direction)
    {

    }
}
