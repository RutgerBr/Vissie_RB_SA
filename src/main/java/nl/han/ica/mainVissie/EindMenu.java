package nl.han.ica.mainVissie;

import nl.han.ica.OOPDProcessingEngineHAN.Engine.GameEngine;

public class EindMenu extends Menu
{
    private Knop knop;

    public EindMenu(GameEngine g, float x, float y, float width, float height)
    {
        super(g, x, y, width, height);
    }

    @Override
    public void maakMenuAan(GameEngine g, Oceaan o, String tekst)
    {
        this.setBackground(240, 240, 240);
        tekstObject eindScore = new tekstObject("Eindscore: " + o.getScore(), 0, 0);
        tekstObject startOpnieuw = new tekstObject(tekst + " opnieuw beginnen: ", 0, 100);
        addGameObject(eindScore);
        addGameObject(startOpnieuw);
        knop = new StartKnop(g, o, o.getWorldWidth() / 5, 200, 500, 100);
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
