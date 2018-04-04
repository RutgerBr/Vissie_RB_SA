package nl.han.ica.mainVissie;

import nl.han.ica.OOPDProcessingEngineHAN.Dashboard.Dashboard;
import nl.han.ica.OOPDProcessingEngineHAN.Engine.GameEngine;

public class EindMenu extends Menu
{
    private Knop knop;

    public EindMenu(float x, float y, float width, float height)
    {
        super(x, y, width, height);
    }


    @Override
    public void maakMenuAan(GameEngine g, Oceaan o)
    {
        this.setBackground(200, 200, 200);
        tekstObject startOpnieuw = new tekstObject("Je bent opgegeten, opnieuw beginnen: ");
        addGameObject(startOpnieuw);
        g.addDashboard(this);

        knop = new StartKnop(g, o, x, y, width, height);
    }
}
