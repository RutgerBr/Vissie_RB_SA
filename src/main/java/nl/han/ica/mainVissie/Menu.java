package nl.han.ica.mainVissie;

import nl.han.ica.OOPDProcessingEngineHAN.Dashboard.Dashboard;
import nl.han.ica.OOPDProcessingEngineHAN.Engine.GameEngine;

public abstract class Menu extends Dashboard
{
    public Menu(float x, float y, float width, float height)
    {
        super(x, y, width, height);
    }
    public abstract void maakMenuAan(GameEngine g, Oceaan o);
}
