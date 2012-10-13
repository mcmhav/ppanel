package s;

import javax.swing.JPanel;
import javax.swing.JFrame;

public class PersonPanelExample_Simple extends JPanel {
	private PersonPanel2 personPanelA, personPanelB;

	private Person2 model;

	public PersonPanelExample_Simple() {
		model = new Person2();
		personPanelA = new PersonPanel2();
		personPanelA.setModel(model);
		add(personPanelA);
		personPanelB = new PersonPanel2();
		personPanelB.setModel(model);
		add(personPanelB);
	}

	public static void main(String args[]) {
		JFrame frame = new JFrame("...");
		PersonPanelExample_Simple pp = new PersonPanelExample_Simple();
		pp.model.setName("sdsf");
		frame.add(pp);
		frame.pack();
		frame.setVisible(true);
	}
}