package s;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class PersonPanel extends JPanel implements ChangeListener, ItemListener, PropertyChangeListener{

	private JLabel na = new JLabel("Name:");
	private JLabel em = new JLabel("Email:");
	private JLabel bi = new JLabel("Birthday:");
	private JLabel ge = new JLabel("Gender:");
	private JLabel he = new JLabel("Height:");
	
	private JTextField name = new JTextField();
	private JTextField email = new JTextField();
	private JTextField birthday = new JTextField();
	
//	private String[] fu = {"Male", "Female"};
	private JComboBox gender = new JComboBox(Gender.values());
	private JSlider height = new JSlider(120, 220);
//	private JButton nw = new JButton("Add");
	
	private Person model = null;
	
	public PersonPanel(){
		JPanel p = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		name.setColumns(30);
		name.addActionListener(new E());
		name.setName("name");
		
		email.setColumns(30);
		email.addActionListener(new E());
		email.setName("email");
		
		birthday.setColumns(30);
		birthday.addActionListener(new E());
		
		gender.setAlignmentX(FlowLayout.LEFT);
		gender.addActionListener(new E());
		gender.addItemListener(this);
		
		height.setMajorTickSpacing(10);
		height.setMinorTickSpacing(5);
		height.setPaintTicks(true);
		height.setPaintLabels(true);
		height.addChangeListener(this);
		
//		nw.addActionListener(new A());
		
		
		c.anchor=GridBagConstraints.WEST;
		c.gridx=0;
		c.gridy=0;
		p.add(na, c);
		c.gridx=1;
		c.gridy=0;
		p.add(name, c);
		c.gridx=0;
		c.gridy=1;
		p.add(em,c);
		c.gridx=1;
		c.gridy=1;
		p.add(email,c);
		c.gridx=0;
		c.gridy=2;
		p.add(bi, c);
		c.gridx=1;
		c.gridy=2;
		p.add(birthday, c);
		c.gridx=0;
		c.gridy=3;
		p.add(ge,c);
		c.gridx=1;
		c.gridy=3;
		p.add(gender,c);
		c.gridx=0;
		c.gridy=4;
		p.add(he,c);
		c.gridx=1;
		c.gridy=4;
		c.fill=1;
		p.add(height,c);
//		c.gridx=1;
//		c.gridy=5;
//		c.fill=1;
//		p.add(nw,c);
		add(p);
	}
	
	public String getNamee() {
		return name.getText();
	}

	public void setNamee(String name) {
		this.name.setText(name);
	}

	public String getEmail() {
		return email.getText();
	}

	public void setEmail(String email) {
		this.email.setText(email);
	}

	public String getBirthday() {
		return birthday.getText();
	}

	public void setBirthday(String birthday) {
		this.birthday.setText(birthday);
	}

	public Gender getGender() {
		return (Gender)gender.getSelectedItem();
	}

	public void setGender(Gender gender) {
//		this.gender. = gender;
	}

	public int getHeight() {
		return height.getValue();
	}

	public void setHeightt(int height) {
		this.height.setValue(height);
	}

	public void setModel(Person p){
		if(p == model){
			
		}
		model = p;
		model.addPropertyChangeListener(this);
		name.setText(model.getName());
		email.setText(model.getEmail());
		birthday.setText(model.getDateOfBirth());
		height.setValue(model.getHeight());
		gender.setSelectedItem((Gender)model.getGender());
	}
	
	public Person getModel(){
		return model;
	}
	
	public void removeModel(Person p){
		
	}
	
	public void propertyChange(PropertyChangeEvent evt) {
//		System.out.println("test");
//		if (evt.getPropertyName() == Person.N) {
			name.setText(model.getName());
			email.setText(model.getEmail());
			birthday.setText(model.getDateOfBirth());
			gender.setSelectedItem((Gender)model.getGender());
			height.setValue(model.getHeight());
//		}
	}
	
	private class E implements ActionListener {
		public void actionPerformed(ActionEvent e) {
//			model = new Person();
			if(model.getName().equals("name")){
				
			}
			
			String n = name.getText();
			String m = email.getText();
			String b = birthday.getText();
			Gender g = (Gender)gender.getSelectedItem();
			int h = height.getValue();
			
			model.setName(n);
			model.setEmail(m);
			model.setDateOfBirth(b);
			model.setGender(g);
			model.setHeight(h);
			model.print();
		}
	}
	

	@Override
	public void stateChanged(ChangeEvent arg0) {
		model.setHeight(height.getValue());
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) {
		JFrame f = new JFrame();
		JFrame f2 = new JFrame();
		PersonPanel p = new PersonPanel();
		PersonPanel p2 = new PersonPanel();
		Person person = new Person();

		person.setName("tesicus");
		person.setEmail("homail");
		person.setDateOfBirth("222");
		person.setGender(Gender.female);
		person.setHeight(130);
		
		p.setModel(person);
		p2.setModel(person);

		f.add(p);
		f2.add(p2);
		f.pack();
		f.setVisible(true);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f2.pack();
		f2.setVisible(true);
		f2.setLocationRelativeTo(null);
		f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
