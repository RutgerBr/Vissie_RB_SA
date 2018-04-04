package nl.han.ica.mainVissie;

import nl.han.ica.OOPDProcessingEngineHAN.Dashboard.Dashboard;
import nl.han.ica.OOPDProcessingEngineHAN.Engine.GameEngine;
import nl.han.ica.OOPDProcessingEngineHAN.View.EdgeFollowingViewport;
import nl.han.ica.OOPDProcessingEngineHAN.View.View;
import nl.han.ica.OOPDProcessingEngineHAN.Sound.Sound;

public class Oceaan
{
    private tekstObject scoreTekst;
    private int score = 0;
    private Sound achtergrondGeluid;
    private VisSpawner visSpawner;
    private Vis speler;
    protected GameEngine g;
    private Menu menu;

    private int worldWidth = 1920;
    private int worldHeight = 1080;

    public Oceaan(GameEngine g)
    {
        this.g = g;

        maakSpelerAan(g);
        printScore(worldWidth, 100);
        maakAiSpawnerAan();
        maakSoundAan();
    }

    public void maakEindMenuAan()
    {
        g.deleteGameObject(speler);
        menu = new EindMenu(getWorldWidth() / 2, getWorldHeight() / 2, 300, 300);
        menu.maakMenuAan(g, this);
    }
    private void printScore(int width, int height)
    {
        Dashboard dashboard = new Dashboard(0, 0, width, height);
        scoreTekst = new tekstObject("Score: 0");
        dashboard.addGameObject(scoreTekst);
        g.addDashboard(dashboard);
    }

    public void verhoogScore()
    {
        if (speler.isOpgegeten())
        {
            scoreTekst.setTekst("Behaalde score : " + score);
        }
        else
        {
            score = (speler.getGrootte()) * 10;
            scoreTekst.setTekst("Score: " + score);
        }
    }

    private void maakSoundAan()
    {
        achtergrondGeluid = new Sound(g, "src/main/java/nl/han/ica/mainVissie/media/background.mp3");
        achtergrondGeluid.loop(-1);
    }

    public void maakSpelerAan(GameEngine g)
    {
        speler = new Speler(this);

        // Spawn de speler op het midden van het speelveld
        g.addGameObject(speler, worldWidth / 2, worldHeight / 2);
    }

    public void createViewWithViewport(GameEngine g, int screenWidth, int screenHeight, float zoomFactor)
    {
        EdgeFollowingViewport viewPort = new EdgeFollowingViewport(speler, (int) Math.ceil(screenWidth / zoomFactor), (int) Math.ceil(screenHeight / zoomFactor), 0, 0);
        View view = new View(viewPort, worldWidth, worldHeight);
        g.setView(view);
        g.size(screenWidth, screenHeight);
        view.setBackground(g.loadImage("src/main/java/nl/han/ica/mainVissie/media/AchtergrondVissie.jpg"));
    }

    public void createViewWithoutViewport(GameEngine g, int screenWidth, int screenHeight) {
        View view = new View(screenWidth,screenHeight);
        view.setBackground(g.loadImage("src/main/java/nl/han/ica/mainVissie/media/AchtergrondVissie1000x800.jpg"));

        g.setView(view);
        g.size(screenWidth, screenHeight);
    }

    public void maakAiSpawnerAan()
    {
        visSpawner = new VisSpawner(g, 1, this);
    }

    public int getWorldWidth()
    {
        return worldWidth;
    }

    public int getWorldHeight()
    {
        return worldHeight;
    }
}