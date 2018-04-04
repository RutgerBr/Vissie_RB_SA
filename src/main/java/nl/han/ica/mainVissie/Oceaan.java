package nl.han.ica.mainVissie;

import nl.han.ica.OOPDProcessingEngineHAN.Dashboard.Dashboard;
import nl.han.ica.OOPDProcessingEngineHAN.Engine.GameEngine;
import nl.han.ica.OOPDProcessingEngineHAN.View.EdgeFollowingViewport;
import nl.han.ica.OOPDProcessingEngineHAN.View.View;

public class Oceaan
{
    private tekstObject scoreTekst;
    private int score;
    private VisSpawner visSpawner;
    private Vis speler;
    protected GameEngine g;
    private Menu menu;
    private boolean menuIsGemaakt;

    private int worldWidth = 1920;
    private int worldHeight = 1080;

    public Oceaan(GameEngine g)
    {
        this.g = g;

        maakSpelerAan(g);
        printScore(worldWidth, 100);
    }

    public void maakEindMenuAan(String tekst)
    {
        if(!menuIsGemaakt)
        {
            g.deleteGameObject(speler);
            menu = new EindMenu(g, 0, 0, getWorldWidth(), getWorldHeight());
            menu.maakMenuAan(g, this, tekst);
            menuIsGemaakt = true;
        }
    }

    private void printScore(int width, int height)
    {
        Dashboard dashboard = new Dashboard(0, 0, width, height);
        scoreTekst = new tekstObject("Score: 0", 0, 0);
        dashboard.addGameObject(scoreTekst);
        g.addDashboard(dashboard);
    }

    public void verhoogScore()
    {
        score = (speler.getGrootte() - 20) * 10;
        scoreTekst.setTekst("Score: " + score);
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

    public int getScore()
    {
        return score;
    }
}