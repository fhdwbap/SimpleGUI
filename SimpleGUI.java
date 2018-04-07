/**
 * Das Paket de.fhdw.java ist fuer die Vorgabe-Codes gedacht.
 * Wenn Sie eigene Java-Klassen implementieren, so koennen Sie ein 
 * eigenes Paket (package) nutzen, beispielsweise de.fhdw.bg.bfwxy123a,
 * wobei bfwxy123a natuerlich durch Ihre FHDW-Login-Kennung zu
 * ersetzen waere. (Sie koennen das Paket aber natuerlich benennen, 
 * wie Sie moechten. Oder im sog. default package arbeiten, dann
 * entfaellt die package-Deklaration ganz einfach.) 
 * - Die package-Angabe impliziert eine entsprechende Ordner-Struktur
 *   im Projektverzeichnis.
 */
package de.fhdw.java;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


/**
 * Kleines Beispiel fuer eine elementare GUI.<br/>
 * Verwendet wird das Swing Framework.
 * 
 * @author fhdwbap
 * Version vom 07.04.2018
 *
 */
public class SimpleGUI extends JFrame implements ActionListener
{

	/**
	 * Titel des Programms (auch in Fenstertitel verwendet)
	 */
	private static String progtitle = "Simple GUI v 1.0";
	
	/**
	 * Textfeld 1 dieser kleinen Demo-Anwendung
	 */
	private JTextField textfield1;
	/**
	 * Textfeld 2 dieser kleinen Demo-Anwendung
	 */
	private JTextField textfield2;
	
	/**
	 * Das Label fuer den Programmtitel
	 */
	private JLabel label0;
	
	/**
	 * Das Label, das zu dem ersten Textfeld @see textfield1 gehoert.
	 */
	private JLabel label1;

	/**
	 * Das Label, das zu @see textfield2 gehoert.
	 */
	private JLabel label2;
	
	/**
	 * Und noch ein drittes Label...
	 */
	private JLabel label3;
	
	/**
	 * Der Name ist selbstsprechend: dies repraesentiert den "Ok"-Button
	 */
	private JButton buttonOk;
	
	/**
	 * Ein eigenes Thema: Serialisierung, die Moeglichkeit, 
	 * Java-Objekte persistent zu machen. (Wird nicht an dieser 
	 * Stelle vertieft...)
	 */
	private static final long serialVersionUID = 901902903; 
	/**
	 * Default-Konstruktor der Klasse
	 * <br/>Setzt die Startwerte insbesondere des Ausgangsdialoges.
	 */
	public SimpleGUI() 
	{
		super(progtitle);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container cont = getContentPane();
		cont.setLayout(new GridLayout(8,1,0,0));
		
		cont.add(new JLabel(progtitle + " - Ein reines Demo-Programm"));
		
		textfield1 = new JTextField(30);
		textfield2 = new JTextField(60); //nur zur Demo...
		
		textfield1.setInputVerifier( new InputVerifier() 
		{ 
			public boolean verify(JComponent input)
			{
				return isNotEmpty( (JTextField) input);
			}
		});
	
		textfield2.setInputVerifier( new InputVerifier() 
		{ 
			public boolean verify(JComponent input)
			{
				return isNotEmpty( (JTextField) input);
			}
		});
	
		label0 = new JLabel();
		label0.setText("Bitte zwei Texte eingeben:");
		
		label1 = new JLabel();
		label1.setForeground( Color.blue ); // Farbgebung nur zur Demo
		
		label2 = new JLabel();
		label2.setForeground( Color.red );
	
		label3 = new JLabel();
		label3.setForeground( Color.darkGray );
		
		buttonOk = new JButton("Ok!");
		buttonOk.addActionListener(this); // Das aktuelle Objekt wird als
		// Listener verwendet: daher oben das "implements ActionListener"
		
		cont.add(label0);
		cont.add(textfield1);
		cont.add(label1);
		cont.add(textfield2);
		cont.add(label2);
		cont.add(buttonOk);		
		cont.add(label3);
		
		pack();
		this.setVisible(true);
	}
	
   /**
    * Die Methode, die die Button-Aktion (hier "Ok!"-Button) durchfuehrt.
    * @param ae Der ausloesende ActionEvent.
    */
	public void actionPerformed(ActionEvent ae)
	{
		if (isNotEmpty(textfield1) && isNotEmpty(textfield2))
		{
			String inputs = textfield1.getText() + " - " + textfield2.getText();
		   System.out.println("-> " + inputs);	
			textfield1.setText("");
			textfield2.setText("");
			label3.setText( "Letzte gueltige Eingabe war: " + inputs);
		}
		
	
		System.out.println("Diagnose: actionPerformed() wurde ausgeloest.");
		// System.out.println("         " + ae);
		
	}
	
	/**
	 * Eine Pruefroutine, ob ein Textfeld (nicht) leer ist.
	 * @param jtf Das zu ueberpruefende Textfeld
	 * @return
	 */
	private boolean isNotEmpty(JTextField jtf)
	{
		if (jtf==null)
		{
			return false;
		}
		
		JLabel label = label1;
		String welches = "obere";
		if (jtf == textfield2)
		{
			label = label2;
			welches = "untere";
		}
		
		
		String s = jtf.getText().trim();
		if (s.length()==0)
		{
			label.setText("Bitte etwas in das " + welches + " Textfeld eingeben!");
			return false;
		}
		label.setText("");
		return true;
	}

	/**
	 * Der Programmeinstiegspunkt main()<br/>
	 * @param args Aktuell nicht verwendet.
	 */
	public static void main(String[] args) 
	{
		// Die Konsolen-Ausgaben dienen nur als Hilfsmittel waehrend
		// der Programmentwicklung
      System.out.println("[" + progtitle + "]: main() gestartet...");
      new SimpleGUI();
      System.out.println("[" + progtitle + "]: main() endet nun...");
      
	}

} // end class SimpleGUI
