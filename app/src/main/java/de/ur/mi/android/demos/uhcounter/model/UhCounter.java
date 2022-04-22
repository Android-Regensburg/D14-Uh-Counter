package de.ur.mi.android.demos.uhcounter.model;

import java.util.ArrayList;

/**
 * Vom UI isolierte Zähler-Klasse für die Anzahl der "Ähms".
 */
public class UhCounter {

    // Default-Wert für den Zähler, der bei der Initialisierung und beim Rest gesetzt wird
    private static final int MIN_VALUE = 0;
    // Anzahl der aktuell gezählten "Ähms"
    private int value;
    // Liste der registrierten Listener, die über Änderungen am Zählerstand informiert werden sollen
    private final ArrayList<UhCounterChangeListener> uhCounterChangeListeners;

    public UhCounter() {
        uhCounterChangeListeners = new ArrayList<>();
        resetCounterValue();
    }

    /**
     * Fügt einen neuen Listener hinzu. Der Listener wird über alle zukünftigen Änderungen am
     * Zählerstand informiert.
     * @param listener Der neue Listener
     */
    public void addOnUhCounterChangeListener(UhCounterChangeListener listener) {
        uhCounterChangeListeners.add(listener);
    }

    /**
     * Entfernt den übergebenen Listener. Der Listener wird zukünftig nicht mehr über Änderungen am
     * Zählerstand informiert.
     * @param listener Der zu entfernende Listener
     */
    public void removeOnUhCounterChangeListener(UhCounterChangeListener listener) {
        uhCounterChangeListeners.remove(listener);
    }

    /**
     * Informiert alle aktuell registrierten Listener über den aktuellen Zählerstand.
     */
    private void notifyListener() {
        /*
         * Hier wird die forEach-Funktion der ArrayList mit einer in Kurzschreibweise notierten,
         * anonymen Klasse auf Basis des Consumers-Interface genutzt. Der als Parameter übergebene
         * Lambda-Ausdruck steht dabei für die Implementierung der accept-Funktion im Consumer-
         * Interface.
         */
        uhCounterChangeListeners.forEach(listener -> listener.onCounterValueChanged(value));
    }

    /**
     * Überschreibt den internen Zähler mit dem übergebenen Wert und informiert die registrierten
     * Listener über den neuen Zählerstand.
     * @param newValue Der neue Zählerstand
     */
    private void setValue(int newValue) {
        // Early-Return verhindert nicht zulässige, negative Zählerstände
        if (newValue < MIN_VALUE) {
            return;
        }
        value = newValue;
        notifyListener();
    }

    /**
     * Erhöht den internen Zähler um 1
     */
    public void increaseCounterValue() {
        setValue(value + 1);
    }

    /**
     * Reduziert den internen Zähler um 1
     */
    public void decreaseCounterValue() {
        setValue(value - 1);
    }

    /**
     * Setzt den internen Zähler auf den Standardwert zurück
     */
    public void resetCounterValue() {
        setValue(MIN_VALUE);
    }

    /**
     * Gibt den aktuellen Zählerstand zurück.
     * @return Der aktuelle Zählerstand
     */
    public int getCounterValue() {
        return value;
    }

}
