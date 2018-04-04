package nl.han.ica.mainVissie;

import nl.han.ica.OOPDProcessingEngineHAN.Dashboard.Dashboard;
import nl.han.ica.OOPDProcessingEngineHAN.Engine.GameEngine;

public abstract class Menu extends Dashboard
{
    protected GameEngine g;
    public Menu(GameEngine g, float x, float y, float width, float height)
    {
        super(x, y, width, height);
        this.g = g;
    }
    public abstract void maakMenuAan(GameEngine g, Oceaan o);
}
