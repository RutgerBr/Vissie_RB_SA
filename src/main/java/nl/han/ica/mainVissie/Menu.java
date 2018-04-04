package nl.han.ica.mainVissie;

import nl.han.ica.OOPDProcessingEngineHAN.Dashboard.Dashboard;
import nl.han.ica.OOPDProcessingEngineHAN.Engine.GameEngine;

public abstract class Menu extends Dashboard {
    protected static float x;
    protected static float y;
    protected static float width;
    protected static float height;

    public Menu(int x, int y, int width, int height)
    {
        super(x, y, width, height);

    }
    public abstract void maakMenuAan(GameEngine g, Oceaan o);
}
