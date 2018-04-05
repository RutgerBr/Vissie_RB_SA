package nl.han.ica.mainVissie;

import nl.han.ica.OOPDProcessingEngineHAN.Alarm.Alarm;
import nl.han.ica.OOPDProcessingEngineHAN.Alarm.IAlarmListener;
import nl.han.ica.OOPDProcessingEngineHAN.Engine.GameEngine;

import java.util.Random;

    /**
     * Deze klasse zorg er voor dat er andere vissen in het water worden gespawned
     *
     * @authors Stefan Anbeek en Rutger Broekkamp.
     */
public class VisSpawner implements IAlarmListener {
    private Random random;
    private Oceaan oceaan;
    private float vissenPerSeconde;
    private GameEngine g;

        /**
         * Constructor
         *
         * @param g GameEngine
         * @param vissenPerSeconde float
         * @param oceaan Oceaan
         */
    VisSpawner(GameEngine g, float vissenPerSeconde, Oceaan oceaan) {
        this.vissenPerSeconde = vissenPerSeconde;
        this.oceaan = oceaan;
        this.g = g;

        random = new Random();
        startAlarm();
    }
        /**
         * Start een alarm uit IAlarmListener.
         *
         * Dit gebeurd door een naam en de vissen per seconde mee te geven aan dit alarm.
         */
    private void startAlarm() {
        Alarm alarm = new Alarm("Nieuwe vis", 1 / vissenPerSeconde);
        alarm.addTarget(this);
        alarm.start();
    }

        /**
         * Triggered een alarm uit IAlarmListener.
         *
         * Deze trigger voegt een AI toe op een random y-positie in de oceaan waar de x is gebaseerd op de richting.
         */
    @Override
    public void triggerAlarm(String alarmName) {
        Vis ai = new AI(oceaan);


        if (((AI) ai).getRichting() == 0) {
            g.addGameObject(ai, oceaan.getWorldWidth(), random.nextInt(oceaan.getWorldHeight()));
        } else {
            g.addGameObject(ai, 10, random.nextInt(oceaan.getWorldHeight()));
        }
        startAlarm();
    }
}