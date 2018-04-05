package nl.han.ica.mainVissie;

import nl.han.ica.OOPDProcessingEngineHAN.Engine.GameEngine;

/**
 * Dit startmenu tekent een venster dat een een startknop weergeeft
 */
public class StartMenu extends Menu
{
    private Knop knop;

    /**
     * @param g GameEngine
     * @param x x positie
     * @param y y positie
     * @param width breedte
     * @param height hoogte
     */
    public StartMenu(GameEngine g, float x, float y, float width, float height)
    {
        super(g, x, y, width, height);
    }


    /**
     * Maakt het volledige menu aan, roept textobjecten aan en zorgt dat de knop wordt getekend
     * @param g     GameEngine
     * @param o     Oceaan
     * @param tekst tekst
     */
    @Override
    public void maakMenuAan(GameEngine g, Oceaan o, String tekst)
    {
        this.setBackground(200, 200, 200);
        tekstObject startOpnieuw = new tekstObject(tekst, 0, 0);
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
