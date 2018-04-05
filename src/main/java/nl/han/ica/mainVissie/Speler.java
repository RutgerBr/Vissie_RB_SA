package nl.han.ica.mainVissie;

import nl.han.ica.OOPDProcessingEngineHAN.Sound.Sound;
import processing.core.PGraphics;

/**
 * Klasse speler waarin de vis geprogrammeerd wordt die kan worden bestuurd middels de pijltjestoetsen of WASD
 */
public class Speler extends Vis
{
    private int grootte = 20;
    private int maxGrootte = 200;
    private final Sound hapGeluid;

    /**
     * Maak de Speler aan, bepaal de grootte van iedere beweegstap en zeg tegen de engine hoe groot de speler is
     * @param o Oceaan
     */
    Speler(Oceaan o)
    {
        super(o);

        hapGeluid = new Sound(o.g, "src/main/java/nl/han/ica/mainVissie/media/hap.mp3");

        // Hoe ver de speler beweegt in 1 "move"
        setFriction(0.05f);

        bepaalGrootte();
    }


    /**
     * Zegt tegen de GameEngine hoe groot de speler is, de engine bepaalt dan weer de 'hitbox'
     */
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

    /**
     * Speelt het geluid af dat in de constructor is geinitialiseerd
     */
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
        }

        if (grootte >= maxGrootte)
        {
            oceaan.maakEindMenuAan("Je bent enorm!");
        }
    }

    /**
     * Tekent de speler op het speelveld
     * @param g PGraphics object will be given by the GameEngine.
     */
    @Override
    public void draw(PGraphics g)
    {
        g.ellipseMode(g.CORNER);
        g.fill(50, 50, 255);
        g.ellipse(getX(), getY(), grootte, grootte);
    }

    /**
     * Zorgt ervoor dat input van de toetsenbord wordt vertaald naar een actie van de speler. Zo kan de speler bewegen.
     * @param keyCode
     * @param key
     */
    @Override
    public void keyPressed(int keyCode, char key)
    {
        final int speed = 5;
        if (keyCode == super.g.LEFT || keyCode == 65)
        {
            setDirectionSpeed(270, speed);
        }
        if (keyCode == super.g.UP || keyCode == 87)
        {
            setDirectionSpeed(0, speed);
        }
        if (keyCode == super.g.RIGHT || keyCode == 68)
        {
            setDirectionSpeed(90, speed);
        }
        if (keyCode == super.g.DOWN || keyCode == 83)
        {
            setDirectionSpeed(180, speed);
        }
    }

    /**
     * @return Grootte van de speler
     */
    public int getGrootte()
    {
        return grootte;
    }
}
