package de.ur.mi.android.demos.uhcounter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Uh-Counter-App (D14)
 *
 * Mit dieser App können Student*innen die "Verzögerungslaute", also die "Ähms" ihrer Dozent*innen
 * zählen (Vgl.: https://de.wikipedia.org/wiki/Verz%C3%B6gerungslaut). Die App stellt die aktuell
 * gezählten Ähms als Counter da und erlaubt über drei Schaltflächen das Hoch- und Runterzählen sowie
 * das Zurücksetzten des Zählers.
 *
 * Activities bilden die zentralen Einheiten einer App ab. Im wesentlichen beschreibt und verwaltet
 * eine Activitity das Ausehen und die Funktionalität eines "Bildschirms" der App, also eines
 * bestimmten, größeren Teilbereichs des gesamten User Interfaces. Zwischen Activities kann hin und
 * her gewechselt werden.
 *
 * Diese Activity stellt die notwendigen UI-Elemente der Uh-Counter-App dar, fängt die Interaktion
 * der Nutzer*innen mit den Buttons ab und aktualisiert entsprechen die Ausgabeelemente.
 */
public class MainActivity extends AppCompatActivity {

    /** Activites sind Klassen: Sie können über Instanzvariablen verfügen, z.b. für häufig genutzte
     * UI-Elemente oder Bestandteile der Programmlogik.
     */
    // Referenz auf das UI-Element, in dem der aktuelle Zählerstand angezeigt wird
    private TextView counterOutput;
    // Int-Variable für aktuellen Ähm-Zählerstand
    private int uhCounterValue;

    /**
     * Beim Starten einer Activity wird automatisch diese Methode aufgerufen. Sie dient uns als
     * Eintieg in den Programmcode unserer App. Hier "beginnt" alles. Später werden wir anderer dieser
     * "Lifecycle"-Methoden kennen lernen, die z.B. beim Neustarten einer Activity oder beim Schließen
     * dieser aufgerufen und von uns für entsprechende Reaktionen im Code verwendet werden können.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Abarbeitung dessen, was alle Activities beim Start machen müssen ...
        super.onCreate(savedInstanceState);
        // Verbindung mit einem bestimmten, vorbereiteten Layout in Form einer XML-Datei
        setContentView(R.layout.activity_main);
        initUI();
        resetCounterValue();
    }

    /**
     * Hier referenzieren wir alle UI-Elemente, der Anwendung und registrieren Listener auf den
     * Buttons, die die Clicks der Nutzer*innen auf diese abfangen.
     */
    private void initUI() {
        // findViewById sucht anhand des ID-Attributs nach einem Element im Layout und gibt dieses zurück
        Button increaseCounterButton = findViewById(R.id.increaseCounterButton);
        Button decreaseCounterButton = findViewById(R.id.decreaseCounterButton);
        Button resetCounterButton = findViewById(R.id.resetCounterButton);
        counterOutput = findViewById(R.id.counterOutput);
        /*
         * Android nutzt das bekannte Listener-Interface-Konzept, bei Bedarf können wir Listener direkt
         * im Code als anonyme, innere Klassen auf Basis der entsprechenden Interfaces erstellen und
         * dort die relevanten Callback-Methoden abfangen.
         */
        increaseCounterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                increaseCounterValue();
            }
        });
        decreaseCounterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decreaseCounterValue();
            }
        });
        resetCounterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetCounterValue();
            }
        });
    }

    /**
     * Erhöht den Ähm-Zähler um eins und aktualisiert das UI
     */
    private void increaseCounterValue() {
        uhCounterValue++;
        updateCounterView();
    }

    /**
     * Verringert den Ähm-Zähler um eins und aktualisiert das UI
     */
    private void decreaseCounterValue() {
        if(uhCounterValue > 0) {
            uhCounterValue--;
            updateCounterView();
        }
    }

    /**
     * Setzt den Ähm-Zähler auf 0 zurück und aktualisiert das UI
     */
    private void resetCounterValue() {
        uhCounterValue = 0;
        updateCounterView();
    }

    /**
     * Trägt den aktuellen Wert der Zählervariable als Inhalt des Ausgabeelements ins UI ein
     */
    private void updateCounterView() {
        counterOutput.setText(String.valueOf(uhCounterValue));
    }
}