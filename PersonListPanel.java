package s;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.DefaultListModel;
import javax.swing.DefaultListSelectionModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.ListCellRenderer;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class PersonListPanel extends JPanel {
	
	DefaultListModel lm = new DefaultListModel();
	JList l = new JList(lm);
	JScrollPane scr = new JScrollPane(l);
	
	PersonPanel pp = new PersonPanel();
	Person p = new Person();
	private JButton nw = new JButton("Add");
	private JButton de = new JButton("Delete");
	private JButton up = new JButton("Update");
	boolean skip = false;
//	PersonPanel lm = new PersonPanel();
//	PersonPanel lm;
	

	public PersonListPanel(){
		JPanel p = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		
		l.setCellRenderer(new PersonRender());
		l.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		pp.setModel(this.p);
		l.setName("PersonList");
		pp.setName("PersonPanels");
		l.addListSelectionListener(new L());
		nw.addActionListener(new A());
		de.addActionListener(new D());
		l.addMouseListener(new M());
		l.addKeyListener(new Y());
		up.addActionListener(new U());
		
	
//		lm.addListDataListener(new T());
		
//		l.addMouseListener(new MouseAdapter() {
//
//		    int lastSelectedIndex;
//
//		    public void mouseClicked(MouseEvent e) {
//
//		        int index = l.locationToIndex(e.getPoint());
//
//		        if (index != -1 && index == lastSelectedIndex) {
//		            l.clearSelection();
//		        }
//
//		        lastSelectedIndex = l.getSelectedIndex();
//		    }
//		});
		
		c.anchor=GridBagConstraints.WEST;
		c.gridx=0;
		c.gridy=0;
		c.fill=1;
		p.add(scr, c);
		c.gridx=1;
		c.gridy=0;
		p.add(pp, c);
		c.gridx=0;
		c.gridy=1;
		c.fill=1;
		p.add(de,c);
		c.gridx=1;
		c.gridy=1;
		c.fill=0;
		p.add(nw,c);
		c.gridx=1;
		c.gridy=1;
		c.anchor= GridBagConstraints.EAST;
		p.add(up,c);
		
		
//		p.add(l);
//		p.add(pp);
//		p.add(nw);
		add(p);
		
	}
	public void setModel(DefaultListModel pp){
		lm.addElement(pp);
	}
	
	public DefaultListModel getModel(){
		return lm;
	}
	
	private class Li implements AdjustmentListener {
		@Override
		public void adjustmentValueChanged(AdjustmentEvent e) {
			
		}
	}
	
	private class PersonRender extends JLabel implements ListCellRenderer {

		@Override
		public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
			
			Person p = (Person)value;
			String n = p.getName();
			String e = p.getEmail();
			String b = p.getDateOfBirth();
			Gender g = p.getGender();
			int h = p.getHeight();
			cellHasFocus = true;
			ImageIcon ic = null;
			if(g==Gender.female){
				ic = new ImageIcon("/home/cube/workspace/Cake/src/s/f.jpg");
			}else if(g==Gender.male){
				ic = new ImageIcon("/home/cube/workspace/Cake/src/s/m.jpg");
			}else{
				
			}
			Font font = null;
			
			setBackground(isSelected ? Color.lightGray : Color.white);
	        setForeground(isSelected ? Color.red : Color.black);
//			l.setBackground(Color.black);
//			ic.setImage();
			setText(n + ", " + e);
			setFont(font);
			setIcon(ic);
			return this;
		}

	}
	private class M implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
//			if(e.getClickCount()==2){
//				l.clearSelection();
//				l.
//				pp.setNamee("");
//				pp.setEmail("");
//				pp.setBirthday("");
////				pp.setGender(gender);
//				pp.setHeight(170);
//				pp.repaint();
//			}
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			if(e.getClickCount()==2){
				pp.setNamee("");
				pp.setEmail("");
				pp.setBirthday("");
//				pp.setGender();
				pp.setHeightt(170);
//				pp.repaint();
				pp.setModel(new Person());
				skip = true;
				l.clearSelection();
			}
		}
		
	}
	
	private class Y implements KeyListener{

		@Override
		public void keyPressed(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			System.out.println(arg0.toString());
			System.out.println(arg0.getKeyChar());
			if(arg0.getKeyChar() ==('d')){
				l.clearSelection();
				pp.setNamee("");
				pp.setEmail("");
				pp.setBirthday("");
//				pp.setGender(gender);
				pp.setHeightt(170);
				pp.repaint();
			}
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	private class L implements ListSelectionListener {
		@Override
		public void valueChanged(ListSelectionEvent e) {
			
			if(!skip){
				
				pp.setModel((Person)l.getSelectedValue());
			}else{
				skip = false;
			}
			
		}
	}
	
	private class A implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Person per = new Person();
			per.setName(pp.getNamee());
			per.setEmail(pp.getEmail());
			per.setDateOfBirth(pp.getBirthday());
			per.setGender(pp.getGender());
			per.setHeight(pp.getHeight());
//			pp.setModel(per);
			lm.addElement(per);
			pp.setModel(new Person());
		}
	}
	
	private class D implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(l.getSelectedIndex()>=0){
				int temp = l.getSelectedIndex();
				pp.setNamee("");
				pp.setEmail("");
				pp.setBirthday("");
	//			pp.setGender(gender);
				pp.setHeightt(170);
				pp.setModel(new Person());
				skip = true;
				lm.remove(temp);
				
	//			l.remove(l.getLastVisibleIndex());
	//			l.repaint();
			}
		}
	}
	
	private class T extends DefaultListSelectionModel{
		boolean gestureStarted = false;

		public void setSelectionInterval(int index0, int index1) {
			if (isSelectedIndex(index0) && !gestureStarted) {
				super.removeSelectionInterval(index0, index1);
			}
			else {
				super.setSelectionInterval(index0, index1);
			}
			gestureStarted = true;
		}

		public void setValueIsAdjusting(boolean isAdjusting) {
			if (isAdjusting == false) {
				gestureStarted = false;
			}
		}
	}
	
	private class U implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			Person per = pp.getModel();
			
			String n = pp.getNamee();
			String m = pp.getEmail();
			String b = pp.getBirthday();
			
			per.setName(n);
			per.setEmail(m);
			per.setDateOfBirth(b);
//			pp.getModel().setName(pp.getName());
//			pp.getModel().setName(pp.getName());
//			model.setEmail(email.getText());
//			model.setDateOfBirth(birthday.getText());
//			model.setGender((Gender)gender.getSelectedItem());
//			model.setHeight(height.getValue());PersonPanels
		}
		
	}
	
	public static void main(String[] args) {
		JFrame f = new JFrame();
//		JList l = new JList();
//		p.setModel(person);
//		f.getContentPane().add(l);
//		f.add(p);
		
		PersonListPanel pl = new PersonListPanel();
		
//		PersonPanel p = new PersonPanel();
		
		Person person = new Person();
		Person person2 = new Person();
		Person person3 = new Person();
		
		person.setName("Per");
		person.setEmail("sdf@mail.com");
		person.setDateOfBirth("51");
		person.setGender(Gender.male);
		person.setHeight(150);
		
		person2.setName("Uginda");
		person2.setEmail("2sdf@mail.com");
		person2.setDateOfBirth("251");
		person2.setGender(Gender.female);
		person2.setHeight(123);
		
		person3.setName("Bjartulf");
		person3.setEmail("3sdf@mail.com");
		person3.setDateOfBirth("351");
		person3.setGender(Gender.male);
		person3.setHeight(130);
		
//		pl.pp.setModel(person);
		
		pl.lm.addElement(person);
		pl.lm.addElement(person2);
		pl.lm.addElement(person3);
//		p.setModel(person);
//		pl.setModel(p);
		
		f.add(pl);
		f.pack();
		f.setVisible(true);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
/*

Make sure the JList instance "PersonList" uses this 
DefaultListModel instance as its model. Implement a main method for testing 
purposes, that creates an outer JFrame with a PersonListPanel as its content, and uses 
its setModel method to fill the JList with three Person instances. 

2. Implement support for selecting a Person instance in JList and editing it in the 
PersonPanel. I.e. if a Person instance is selected, it should be available for editing in 
the PersonPanel, and if no instance is selected, the PersonPanel must be 
empty/emptied.  

3. Create an Action implementation for creating a new Person instance. The action must 
both create a new Person instance and make sure this instance is ready for editing in 
the PersonPanel. Add a JButton to PersonListPanel with this Action attached. Use the 
setName method to name this JButton "NewPersonButton".  

4. Create an Action implementation for deleting the Person instance that is selected in the 
JList. The action must both remove the new Person instance from the model, i.e. 
DefaultListModel instance and make sure a different or no Person instance is ready for 
editing in the PersonPanel. Add a JButton to PersonListPanel with this Action 
attached. Use the setName method to name this JButton "DeletePersonButton".  

5. Create a class named PersonRenderer that implements the ListCellRenderer interface, 
so a Person is shown in the list with the name followed by the email address. The icon 
must depend on the value of the gender property. Hint: Subclass 
DefaultListCellRenderer, override its getListCellRendererComponent(...) method and 
use JLabel label = super.getListCellRendererComponent(...) in the overriding method. 
Use the ImageIcon class for the icon.  
 */