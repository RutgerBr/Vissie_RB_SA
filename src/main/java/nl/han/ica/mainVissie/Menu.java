package nl.han.ica.mainVissie;

import nl.han.ica.OOPDProcessingEngineHAN.Dashboard.Dashboard;
import nl.han.ica.OOPDProcessingEngineHAN.Engine.GameEngine;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;

public abstract class Menu extends GameObject
{
    protected static float x;
    protected static float y;
    protected static float width;
    protected static float height;

    public Menu(int x, int y, int width, int height)
    {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    public abstract void maakMenuAan(GameEngine g, Oceaan o);
}
