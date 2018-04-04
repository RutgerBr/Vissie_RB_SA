package nl.han.ica.mainVissie;

import nl.han.ica.OOPDProcessingEngineHAN.Engine.GameEngine;


/**
 * Menu dat moet worden weergegeven aan het einde van het spel
 */
public class EindMenu extends Menu
{
    private Knop knop;

    /**
     * @param g GameEngine
     * @param x x positie
     * @param y y positie
     * @param width Breedte
     * @param height Hoogte
     */
    public EindMenu(GameEngine g, float x, float y, float width, float height)
    {
        super(g, x, y, width, height);
    }

    /**
     * Maak objecten aan die zichtbaar moeten zijn in het menu
     * @param g GameEngine
     * @param o Oceaan
     * @param tekst Tekst wat moet worden weergegeven
     */
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
