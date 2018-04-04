package nl.han.ica.mainVissie;

import nl.han.ica.OOPDProcessingEngineHAN.Sound.Sound;
import processing.core.PGraphics;

/**
 * Klasse speler waarin de vis geprogrammeerd wordt die kan worden bestuurd
 */
public class Speler extends Vis
{
    private int grootte = 20;
    private int maxGrootte = 200;
    private final Sound hapGeluid;

    Speler(Oceaan o)
    {
        super(o);

        hapGeluid = new Sound(o.g, "src/main/java/nl/han/ica/mainVissie/media/hap.mp3");

        // Hoe ver de speler beweegt in 1 "move"
        setFriction(0.05f);

        bepaalGrootte();
    }


    @Override
    public void bepaalGrootte()
    {
        setHeight(grootte);
        setWidth(grootte);
    }

    /**
     * Maakt de speler grootte met de meegegeven waarde, mits deze kleiner is dan de maximale grootte.
     *
     * @param waarde: deze waarde staat voor hoe veel groter de speler moet worden.
     */

    public void maakGroter(int waarde)
    {
        if (grootte <= maxGrootte)
        {
            grootte += waarde;
            setHeight(grootte);
            setWidth(grootte);
        }
    }

    public void speelHapGeluid()
    {
        hapGeluid.rewind();
        hapGeluid.play();
    }

    @Override

    public void update()
    {
        if (getX() <= 0)
        {
            setxSpeed(0);
            setX(0);
        }
        if (getY() <= 0)
        {
            setySpeed(0);
            setY(0);
        }
        if (getX() >= super.oceaan.getWorldWidth() - grootte)
        {
            setxSpeed(0);
            setX(super.oceaan.getWorldWidth() - grootte);
        }
        if (getY() >= super.oceaan.getWorldHeight() - grootte)
        {
            setySpeed(0);
            setY(super.oceaan.getWorldHeight() - grootte);
        }

        if (isOpgegeten())
        {
            oceaan.maakEindMenuAan("je bent opgegeten!");
        } else if (grootte == maxGrootte)
        {
            oceaan.maakEindMenuAan("Je bent de grootste vis!");
        }
    }

    @Override
    public void draw(PGraphics g)
    {
        g.ellipseMode(g.CORNER);
        g.fill(50, 50, 255);
        g.ellipse(getX(), getY(), grootte, grootte);
    }

    @Override
    public void keyPressed(int keyCode, char key)
    {
        final int speed = 5;
        if (keyCode == super.g.LEFT || keyCode == 65)
        {
            setDirectionSpeed(270, speed);
            //  setCurrentFrameIndex(0);
        }
        if (keyCode == super.g.UP || keyCode == 87)
        {
            setDirectionSpeed(0, speed);
            //   setCurrentFrameIndex(2);
        }
        if (keyCode == super.g.RIGHT || keyCode == 68)
        {
            setDirectionSpeed(90, speed);
            //    setCurrentFrameIndex(1);
        }
        if (keyCode == super.g.DOWN || keyCode == 83)
        {
            setDirectionSpeed(180, speed);
            //   setCurrentFrameIndex(3);
        }
    }

    public int getGrootte()
    {
        return grootte;
    }
}
