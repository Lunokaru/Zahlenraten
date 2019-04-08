package main;

// ^ packages and v imports
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

import javax.swing.JOptionPane;

public class Main {
	public static void main(String[] args) {
		// Objektdefinition
		int zufallsZahl = new Random().nextInt(1001);
		int counter = 0;
		int eingabe = 0;
		String[] modi = { "Konsole", "Fenster" };
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int modus = JOptionPane.showOptionDialog(null, "Bitte wählen Sie: Konsolen- oder Fenstermodus?", "Modusauswahl",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, modi, "Metric");

		// Hauptprogramm
		if (modus == 0) {// Konsole was choosen
			try {
				// Just one line and you are done !
				// We have given a command to start cmd
				// /K : Carries out command specified by string
				Runtime.getRuntime().exec(new String[] { "cmd", "/K", "Start" });

			} catch (Exception e) {
				System.out.println("HEY Buddy ! U r Doing Something Wrong ");
				e.printStackTrace();
			}
		} else {// Fenster was chosen
			System.out.println("Willkommen zu Zahlenraten! Es wurde eine Zahl zwischen 1 und 1000 erstellt. Warte auf Eingabe:"); // gibt was aus
			do { // tue
				try { // Versuche
					eingabe = Integer.parseInt(br.readLine()); // Setz eingabe auf Integer von br.readLine()
					if (eingabe < zufallsZahl) { // wenn eingabe kleiner als zufallsZahl
						System.out.println("Die eingegebene Zahl ist zu klein."); // gibt was aus
						counter++; // Zähle counter + 1
					} else if (eingabe > zufallsZahl) { // wenn eingabe größer als zufallsZahl
						System.out.println("Die eingegebene Zahl ist zu groß."); // gibt was aus
						counter++; // Zähle counter + 1
					}
				} catch (NumberFormatException e) { // Fang NumberFormatException ab
					System.out.println("Ungültige Eingabe. Bitte ganze Zahl eingeben."); // gibt was aus
				} catch (IOException e) { // Fang IOException ab
					e.printStackTrace(); // gib Fehlermeldung aus
				}
			} while (eingabe != zufallsZahl); // Solange eingabe nicht gleich zufallsZahl
			System.out.println("Glückwunsch, Zufallszahl: " + zufallsZahl + " wurde in " + counter + " Versuchen erraten."); // gibt was aus

		}

	}
}