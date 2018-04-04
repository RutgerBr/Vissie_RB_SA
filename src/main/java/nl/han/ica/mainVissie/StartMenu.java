package nl.han.ica.mainVissie;

import nl.han.ica.OOPDProcessingEngineHAN.Engine.GameEngine;

public class StartMenu extends Menu
{
    private Knop knop;

    public StartMenu(GameEngine g, float x, float y, float width, float height)
    {
        super(g, x, y, width, height);
    }


    @Override
    public void maakMenuAan(GameEngine g, Oceaan o)
    {
        this.setBackground(200, 200, 200);
        tekstObject startOpnieuw = new tekstObject("Begin spel: ", 0, 0);
        addGameObject(startOpnieuw);
        knop = new StartKnop(g, o, o.getWorldWidth() / 5, 1, 500, 100);
        addGameObject(knop);
        g.addDashboard(this);
    }

    @Override
    public void update()
    {
        if (knop.isMuisOverKnop() && super.g.mousePressed)
        {
            knop.doeKnopActie();
        }
    }
}
