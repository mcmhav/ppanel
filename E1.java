package s;

import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.border.TitledBorder;

public class E1 extends JPanel{
	
	private JTextField t = new JTextField();
	
	private AbstractButton u = new JToggleButton("Upper case");
	private AbstractButton l = new JToggleButton("Lower case");
	
	private JCheckBox c = new JCheckBox("Continuous?");
	
	private ButtonGroup g = new ButtonGroup();
	
	private String s = "";
	
	public E1(){
		JPanel p = new JPanel(new GridLayout(1, 7));
		JPanel p2 = new JPanel(new GridLayout(1, 2));
		JPanel p3 = new JPanel(new GridLayout(1, 3));
		JPanel p4 = new JPanel(new GridLayout(1,1));
		
		p.setBorder(new TitledBorder(""));
		
		p2.add(t);
		p3.add(u);
		p3.add(l);
		p3.add(c);
		
		g.add(u);
		g.add(l);
		
		p.add(p2);
		p.add(p3);
//		p.add(p4);
		
		add(p);
		
		t.addActionListener(new E());
		u.addActionListener(new U());
		l.addActionListener(new L());
		t.addKeyListener(new K());
		
	}
	
	private class K implements KeyListener{

		public void keyPressed(KeyEvent e) {
			
		}

		public void keyReleased(KeyEvent e) {
			if(c.isSelected()&&e.getKeyCode()!=8){
				E es = new E();
				ActionEvent test = new ActionEvent(t, 1001, "d");
				es.actionPerformed(test);
			}
		}

		public void keyTyped(KeyEvent e) {
			
		}
		
	}
	
	private class E implements ActionListener{
		
		public void actionPerformed(ActionEvent e){
			int p = t.getCaretPosition();
			Enumeration elements = g.getElements();
	        while (elements.hasMoreElements()) {
	        	
	          AbstractButton b = (AbstractButton) elements.nextElement();
	          if (b.isSelected()) {
	            if(b.getText().equals("Upper case")){
	            	String s = t.getText().toUpperCase();
	    			t.setText(s);
	            }else if(b.getText().equals("Lower case")){
	            	String s = t.getText().toLowerCase();
	    			t.setText(s);
	            }
	          }
	        }
	        g.setSelected(null, true);
	        t.setCaretPosition(p);
		}
	}
	
	private class U implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			String s = t.getText().toUpperCase();
			t.setText(s);
		}
	}
	
	private class L implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			String s = t.getText().toLowerCase();
			t.setText(s);
		}
	}
	
	public static void main(String[] args) {
		JFrame f = new JFrame();
		E1 e = new E1();
		f.add(e);
		f.setSize(720, 74);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

/* Lexical level:
 * Går på funksjoner, hvordan disse skal kunne utføres for brukeren
 * 
 * Syntactical level:
 * Hvordan en oppgave skal kunne utføres 
 * 
 * Semantical level:
 * Brukers input mot maskins output.
 * 
 * På syntactical nivå har jeg et brukergrensesnitt som venter på innput.
 * Når den tekst venter den på en forespørsel fra brukeren om å gjøre det
 * til enten store eller små bokstaver? Dette gjøres gjennom knapper.
 * 
 * Så for å hondere syntactical events brukte jeg vel knappemuligheter. Enten 
 * om man vil få store eller små, eller konstant få den oppdatert.
 * 
 * Lexicale hendelser håndteres gjennom E klassen som venter på "enter"? 
 * Som da gjør bokstavene til tidligere valgte knapp.
 * 
 * Med syntacticale hendelser har vi knapper? som gjør det oversiktelig og 
 * brukervennelig. Brukeren kan vite hva som kommer til å skje ved de forskjellige
 * hendelsene. Mens ved lexicale hendelser kan ikke brukeren vite hva som kommer
 * til å skje ved ett gitt valg???
 * 
 * nei?
 * 
 * 
 */
