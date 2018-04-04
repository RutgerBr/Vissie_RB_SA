package nl.han.ica.mainVissie;

import nl.han.ica.OOPDProcessingEngineHAN.Dashboard.Dashboard;
import nl.han.ica.OOPDProcessingEngineHAN.Engine.GameEngine;

public class EindMenu extends Menu
{
    private Knop knop;

    public EindMenu(int x, int y, int width, int height)
    {
        super(x, y, width, height);
    }


    @Override
    public void maakMenuAan(GameEngine g, Oceaan o)
    {
        Dashboard dashboard = new Dashboard(x, y, width, height);
        tekstObject startOpnieuw = new tekstObject("Je bent opgegeten, opnieuw beginnen: ");
        dashboard.addGameObject(startOpnieuw);
        g.addDashboard(dashboard);

        knop = new StartKnop(g, o, x, y, width, height);
    }
}
