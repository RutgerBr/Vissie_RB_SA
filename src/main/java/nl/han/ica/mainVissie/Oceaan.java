package nl.han.ica.mainVissie;

import nl.han.ica.OOPDProcessingEngineHAN.Dashboard.Dashboard;
import nl.han.ica.OOPDProcessingEngineHAN.Engine.GameEngine;
import nl.han.ica.OOPDProcessingEngineHAN.Persistence.FilePersistence;
import nl.han.ica.OOPDProcessingEngineHAN.View.EdgeFollowingViewport;
import nl.han.ica.OOPDProcessingEngineHAN.View.View;


/**
 * Klasse Oceaan, hier worden alle objecten binnen aangemaakt die nodig zijn voor het spelen van Vissie
 */
public class Oceaan {
    private tekstObject scoreTekst;
    private int score;
    private VisSpawner visSpawner;
    private Vis speler;
    protected GameEngine g;
    private Menu menu;
    private boolean menuIsGemaakt;

    private int worldWidth = 1920;
    private int worldHeight = 1080;

    /**
     * @param g De engine waar oceaan gebruik van kan maken
     */
    public Oceaan(GameEngine g) {
        this.g = g;

        maakSpelerAan(g);
        printScore(worldWidth, 100);
        maakAiSpawnerAan();
    }

    /**
     * Maakt een eindmenu aan als het spel is afgelopen
     *
     * @param tekst Tekst die moet verschijnen in het eindmenu
     */
    public void maakEindMenuAan(String tekst) {
        if (!menuIsGemaakt) {
            g.deleteGameObject(speler);
            menu = new EindMenu(g, 0, 0, getWorldWidth(), getWorldHeight());
            menu.maakMenuAan(g, this, tekst);
            menuIsGemaakt = true;
        }
    }


    /**
     * Weergeeft de behaalde score linksbovenin het scherm
     *
     * @param width  Breedte van het scorevenster
     * @param height Hoogte van het scorevenster
     */
    private void printScore(int width, int height) {
        Dashboard dashboard = new Dashboard(0, 0, width, height);
        scoreTekst = new tekstObject("Score: 0", 0, 0);
        dashboard.addGameObject(scoreTekst);
        g.addDashboard(dashboard);
    }

    /**
     * Verhoogt de behaalde score
     */
    public void verhoogScore() {
        score = (speler.getGrootte() - 20) * 10;
        scoreTekst.setTekst("Score: " + score);
    }

    /**
     * Maakt de speler aan in de oceaan
     *
     * @param g GameEngine
     */
    public void maakSpelerAan(GameEngine g) {
        speler = new Speler(this);

        // Spawn de speler op het midden van het speelveld
        g.addGameObject(speler, worldWidth / 2, worldHeight / 2);
    }


    /**
     * Maakt het speelveld, met een speelveld buiten het zichtbare venster
     *
     * @param g            GameEngine
     * @param screenWidth  Vensterbreedte
     * @param screenHeight Vensterhoogte
     * @param zoomFactor   Hoe veel er ingezoomd moet worden
     */
    public void createViewWithViewport(GameEngine g, int screenWidth, int screenHeight, float zoomFactor) {
        EdgeFollowingViewport viewPort = new EdgeFollowingViewport(speler, (int) Math.ceil(screenWidth / zoomFactor), (int) Math.ceil(screenHeight / zoomFactor), 0, 0);
        View view = new View(viewPort, worldWidth, worldHeight);
        g.setView(view);
        g.size(screenWidth, screenHeight);
        view.setBackground(g.loadImage("src/main/java/nl/han/ica/mainVissie/media/AchtergrondVissie.jpg"));
    }

    /**
     * Maakt de spawner aan die nodig is bij het spawnen van de vissen
     */
    public void maakAiSpawnerAan() {
        visSpawner = new VisSpawner(g, 1, this);
    }


    /**
     * @return Breedte van de wereld
     */
    public int getWorldWidth() {
        return worldWidth;
    }

    /**
     * @return Hoogte van de wereld
     */
    public int getWorldHeight() {
        return worldHeight;
    }

    /**
     * @return Score
     */
    public int getScore() {
        return score;
    }
}