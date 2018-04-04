package nl.han.ica.mainVissie;

import nl.han.ica.OOPDProcessingEngineHAN.Engine.GameEngine;

public class StartKnop extends Knop
{

    public StartKnop(GameEngine g, Oceaan o, float x, float y, float breedte, float hoogte)
    {
        super(g, o, x, y, breedte, hoogte);
        tekenKnop();
    }

    @Override
    public void tekenKnop()
    {
        o.g.fill(50, 50, 255);
        o.g.rect(x, y, breedte, hoogte);
    }

    @Override
    public void doeKnopActie()
    {
        g.deleteAllGameOBjects();
        o.maakSpelerAan(g);
        o.maakAiSpawnerAan();
    }

    @Override
    public void mousePressed(int x, int y, int button)
    {
        if (super.isMuisOverKnop())
        {
            doeKnopActie();
        }
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
