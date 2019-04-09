package main;

import javax.swing.JOptionPane;

public class Main {
	public static void main(String[] args) {
		// Objektdefinition
		String[] modi = { "Konsole", "Fenster" };
		int modus = JOptionPane.showOptionDialog(null, "Bitte wählen Sie: Konsolen- oder Fenstermodus?", "Modusauswahl", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, modi, "Metric");

		// Hauptprogramm
		if (modus == 0) {// Konsole was choosen
			konsole.KonsoleMain.konsolenmodus();
		} else {// Fenster was chosen
			fenster.FensterMain.fenstermodus();
		}
	}
}