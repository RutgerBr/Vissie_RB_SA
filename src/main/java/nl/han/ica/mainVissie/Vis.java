package nl.han.ica.mainVissie;

import nl.han.ica.OOPDProcessingEngineHAN.Collision.ICollidableWithGameObjects;
import nl.han.ica.OOPDProcessingEngineHAN.Engine.GameEngine;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.AnimatedSpriteObject;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;


import java.util.List;

public abstract class Vis extends GameObject implements ICollidableWithGameObjects
{
    protected Oceaan oceaan;
    protected GameEngine g;
    private int marge = 4;
    private boolean opgegeten = false;

    Vis(Oceaan o)
    {
        this.oceaan = o;
        g = oceaan.g;
    }

    /**
     * Check of speler groter is dan de 'collided' AI en verwijder dan het kleinste object.
     * Als speler kleiner is dan het object dan zal de speler worden opgegeten en het spel worden gestopt.
     *
     * @param collidedGameObjects
     */
    @Override
    public void gameObjectCollisionOccurred(List<GameObject> collidedGameObjects)
    {
        for (GameObject go : collidedGameObjects)
        {
            if (this instanceof Speler && go instanceof AI)
            {
                if (this.getGrootte() > ((AI) go).getGrootte())
                {
                    ((Speler) this).speelHapGeluid();
                    g.deleteGameObject(go);
                    ((Speler) this).maakGroter(((AI) go).getGrootte() / marge);
                } else if (this.getGrootte() < ((AI) go).getGrootte())
                {
                    opgegeten = true;
                }
                oceaan.verhoogScore();
            }
        }
    }

    public abstract void bepaalGrootte();
    public abstract int getGrootte();

    @Override
    public void update()
    {

    }

    public boolean isOpgegeten()
    {
        return opgegeten;
    }
}
