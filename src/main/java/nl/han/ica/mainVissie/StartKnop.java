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
    }
}
