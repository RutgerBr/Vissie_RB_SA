package nl.han.ica.mainVissie;

import nl.han.ica.OOPDProcessingEngineHAN.Engine.GameEngine;

import nl.han.ica.OOPDProcessingEngineHAN.Sound.Sound;
import processing.core.PApplet;

public class mainVissie extends GameEngine
{
    private Oceaan oceaan;
    private Sound achtergrondGeluid;
    private Menu menu;

    public static void main(String[] args)
    {
        PApplet.main(new String[]{"nl.han.ica.mainVissie.mainVissie"});
    }

    @Override
    public void setupGame()
    {
        maakSoundAan();
        maakOceaanAan();
        oceaan.createViewWithViewport(this, 1000, 800, 1f);
        oceaan.maakAiSpawnerAan();
        menu = new StartMenu(this, 0, 0, oceaan.getWorldWidth(), oceaan.getWorldHeight());
        menu.maakMenuAan(this, oceaan, "Begin spel: ");
    }


    private void maakSoundAan()
    {
        achtergrondGeluid = new Sound(this, "src/main/java/nl/han/ica/mainVissie/media/background.mp3");
        achtergrondGeluid.loop(-1);
    }

    @Override
    public void update()
    {

    }

    @Override
    public void mousePressed()
    {
        System.out.println(mousePressed);
    }

    private void maakOceaanAan()
    {
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
