package s;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

enum Gender {male, female};

public class Person {
	public final static String N = "Beate";
	public final static String D = "Beate";
	public final static String E = "Beate";
	public final static String H = "Beate";
	public final static String G = "Beate";
	private String name = "";
	private String dateOfBirth = "";
	private String email = "";
	private int height;
	private Gender gender;
	private PropertyChangeSupport pcs;
	
	public Person(){
		pcs = new PropertyChangeSupport(this);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		String o = this.name;
		this.name = name;
		pcs.firePropertyChange(N, o, name);
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		String o = this.dateOfBirth;
		this.dateOfBirth = dateOfBirth;
		pcs.firePropertyChange(D, o, dateOfBirth);
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		String o = this.email;
		this.email = email;
		pcs.firePropertyChange(E, o, email);
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		int o = this.height;
		this.height = height;
		pcs.firePropertyChange(H, o, height);
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		Gender o = this.gender;
		this.gender = gender;
		pcs.firePropertyChange(G, o, gender);
	}
	
	public void print(){
		System.out.println(name);
		System.out.println(email);
		System.out.println(dateOfBirth);
		System.out.println(gender);
		System.out.println(height);
		System.out.println();
	}
	
	public String toString(){
		return name;
	}
	
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		if(pcs==null){
			pcs = new PropertyChangeSupport(this);
		}
		pcs.addPropertyChangeListener(listener);
	}
}
