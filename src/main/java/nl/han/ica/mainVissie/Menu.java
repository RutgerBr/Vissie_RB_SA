package nl.han.ica.mainVissie;

import nl.han.ica.OOPDProcessingEngineHAN.Dashboard.Dashboard;
import nl.han.ica.OOPDProcessingEngineHAN.Engine.GameEngine;

public class Menu extends Dashboard {
    private static float x = 0;
    private static float y = 0;
    private static float width = 1000;
    private static float height = 800;

    private Knop knop;

    public Menu(int x, int y, int width, int height)
    {
        super(x, y, width, height);

    }

    public void maakEindMenuAan(GameEngine g, Oceaan o)
    {
        Dashboard dashboard = new Dashboard(x, y, width, height);
        tekstObject startOpnieuw = new tekstObject("Je bent opgegeten, opnieuw beginnen: ");
        dashboard.addGameObject(startOpnieuw);
        g.addDashboard(dashboard);

        knop = new StartKnop(g, o, x, y, width, height);
    }
}
