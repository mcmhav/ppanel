    package s;

import java.beans.*;
import java.awt.event.*;
import javax.swing.*;


public class PersonPanel2 extends JPanel implements PropertyChangeListener {
	
	private Person2 model;
	private JTextField nameField;
	private JButton clearButton;

	public PersonPanel2() {
		nameField = new JTextField();
		nameField.setColumns(20);
		nameField.addActionListener(new myTextAction());
		add(nameField);
		clearButton = new JButton("Clear");
		clearButton.addActionListener(new ClearButtonAction());
		add(clearButton);
	}

	/** Action for text field * */
	class myTextAction implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			model.setName(nameField.getText());
		}
	}

	/** Action for clearButton * */
	class ClearButtonAction implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			model.setName("");
		}
	}
	
	// Set model
	public void setModel(Person2 theModel) {
		model = theModel;
		model.addPropertyChangeListener(this);
	}
	
	// PropertyChangeListener
	public void propertyChange(PropertyChangeEvent evt) {
		System.out.println("test");
		if (evt.getPropertyName() == Person2.NAME_PROPERTY) {
			nameField.setText(model.getName());
		}
	}
	
	public static void main(String args[]) {
		JFrame frame = new JFrame("...");
		frame.getContentPane().add(new PersonPanel2());
		frame.pack();
		frame.setVisible(true);
	}
}