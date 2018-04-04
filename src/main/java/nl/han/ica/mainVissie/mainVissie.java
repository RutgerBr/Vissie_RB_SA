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
        if(oceaan.isOpgegeten())
        {
            maakEindMenuAan(100,100);
        }
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

    private void maakEindMenuAan(int width, int height)
    {
        Dashboard dashboard = new Dashboard(oceaan.getWorldWidth() / 2, 0, width, height);
        tekstObject startOpnieuw = new tekstObject("Je bent opgegeten, opnieuw beginnen: ");
        dashboard.addGameObject(startOpnieuw);
        addDashboard(dashboard);

        knop = new StartKnop(this, oceaan, oceaan.getWorldWidth(), 0, width, height);
    }

    public void initializePersistence()
    {

    }

    public void pauzeerSpel()
    {
        // to-do (could)
    }
}
