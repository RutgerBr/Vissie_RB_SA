package nl.han.ica.mainVissie;

import nl.han.ica.OOPDProcessingEngineHAN.Dashboard.Dashboard;
import nl.han.ica.OOPDProcessingEngineHAN.Engine.GameEngine;

import processing.core.PApplet;

public class mainVissie extends GameEngine {
    private Oceaan oceaan;
    private Knop knop;

    public static void main(String[] args) {
        PApplet.main(new String[]{"nl.han.ica.mainVissie.mainVissie"});
    }

    @Override
    public void setupGame() {
        maakOceaanAan();
        oceaan.createViewWithViewport(this, 1000, 800, 1f);
        //oceaan.createViewWithoutViewport(this, 1000, 800);
    }

    @Override
    public void update()
    {

    }

    @Override
    public void mousePressed()
    {
        if (knop.isMuisOverKnop())
        {
            knop.doeKnopActie();
        }
    }

    private void maakOceaanAan() {
        oceaan = new Oceaan(this);
    }

    public void initializePersistence()
    {

    }

    public void pauzeerSpel()
    {
        // to-do (could)
    }
}
