package fenster;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class FensterMain {
	// Klassenobjektdefinition
	static int zufallsZahl = new Random().nextInt(1001);
	static int counter = 0;
	static int eingabe = 0;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static JFrame frame;
	private static JSplitPane sPFensterModus;
	private static JTextField tfFensterModus;
	private static JTextPane tPFensterModus;

	public static void fenstermodus() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					createAndShowGUI();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	//erstellt GUI und zeigt sie an
	private static void createAndShowGUI() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Zahlenraten");
		GridBagLayout gbl = new GridBagLayout();
		gbl.columnWidths = new int[] { 434, 0 };
		gbl.rowHeights = new int[] { 231, 0 };
		gbl.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		frame.getContentPane().setLayout(gbl);
		frame.setVisible(true);

		sPFensterModus = new JSplitPane();
		sPFensterModus.setOrientation(JSplitPane.VERTICAL_SPLIT);
		GridBagConstraints gbcFM = new GridBagConstraints();
		gbcFM.fill = GridBagConstraints.BOTH;
		gbcFM.gridx = 0;
		gbcFM.gridy = 0;
		frame.getContentPane().add(sPFensterModus, gbcFM);

		tfFensterModus = new JTextField();
		tfFensterModus.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyCode() == KeyEvent.VK_ENTER) {
					fenstermodusspiel();
					tfFensterModus.setText(null);
				}
			}
		});
		sPFensterModus.setLeftComponent(tfFensterModus);
		tfFensterModus.setColumns(1);

		tPFensterModus = new JTextPane();
		tPFensterModus.setEditable(false);
		sPFensterModus.setRightComponent(tPFensterModus);
		tPFensterModus.setText("Willkommen zu Zahlenraten! \nEs wurde eine Zahl zwischen 1 und 1000 erstellt. \nWarte auf Eingabe:"); // gibt was aus
	}

	//Struktur des Spiels
	private static void fenstermodusspiel() {
		try { // Versuche
			eingabe = Integer.parseInt(tfFensterModus.getText()); // Setz eingabe auf Integer von br.readLine()
			if (eingabe < zufallsZahl) { // wenn eingabe kleiner als zufallsZahl
				tPFensterModus.setText("Die eingegebene Zahl ist zu klein.");
				counter++; // Zähle counter + 1
			} else if (eingabe > zufallsZahl) { // wenn eingabe größer als zufallsZahl
				tPFensterModus.setText("Die eingegebene Zahl ist zu groß."); // gibt was aus
				counter++; // Zähle counter + 1
			}
		} catch (NumberFormatException e) { // Fang NumberFormatException ab
			tPFensterModus.setText("Ungültige Eingabe. Bitte ganze Zahl eingeben."); // gibt was aus
		}
		if (eingabe == zufallsZahl) {
			tPFensterModus.setText("Glückwunsch, Zufallszahl: " + zufallsZahl + " wurde in " + counter + " Versuchen erraten."); // gibt was aus
			String[] modi = { "Ja", "Nein" };
			int modus = JOptionPane.showOptionDialog(null, "Wollen Sie noch eine Runde spielen?", "Neues Spiel", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, modi, "Ja");
			if (modus == 0) { //wenn Ja
				frame.dispose();
				createAndShowGUI();
			}else if (modus == 1) { //wenn Nein
				System.exit(0);
			}
			
		}
	}
}
