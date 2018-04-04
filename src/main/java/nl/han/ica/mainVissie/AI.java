package nl.han.ica.mainVissie;

import java.util.Random;

import processing.core.PGraphics;

public class AI extends Vis
{
    private int grootte;
    private int richting;
    private int snelheid;

    private final static int LINKS = 0;
    private final static int RECHTS = 1;


    public AI(Oceaan o)
    {
        super(o);
        Random r = new Random();
        this.grootte = r.nextInt(100) + 1; // Returned een waarde van 1 tot en met 50
        this.snelheid = r.nextInt(4) + 1; // Returned een waarde van 1 tot en met 5
        this.richting = r.nextInt(RECHTS + 1); // Returned een waarde 0 of 1
        bepaalGrootte();
        beweeg(richting);
    }

    public void bepaalGrootte()
    {
        setHeight(grootte);
        setWidth(grootte);
        //super.s.resize(grootte, grootte);
        //setFrameWidth(grootte / 2); // setter gemaakt in AnimatedSpriteObject uit GameEngine
    }

    @Override
    public void draw(PGraphics g)
    {
        g.ellipseMode(g.CORNER
        );
        g.fill(255, 50, 50);
        g.ellipse(getX(), getY(), grootte, grootte);
    }

    public void beweeg(int richting)
    {
        switch (richting)
        {
            case LINKS:
                setxSpeed(-snelheid);
                break;
            case RECHTS:
                setxSpeed(snelheid);
                break;
        }
    }

    @Override
    public void update()
    {
        if (getX() <= 10 || getX() >= oceaan.getWorldWidth())
        {
            super.g.deleteGameObject(this);
        }
    }

    public int getRichting()
    {
        return richting;
    }

    public int getGrootte()
    {
        return grootte;
    }
}