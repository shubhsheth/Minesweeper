package Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Cell implements ActionListener {

	private Game game;
	private JButton button;
	private ActionListener actionListener;

	private int id;
	private String value = "";
	
	private Boolean revealed;
	private Boolean sealed;
		
	public Cell(Game game) {
		button = new JButton();
		this.game = game;
		revealed = false;
		sealed = false;
		button.addActionListener(actionListener);
	}
	
	public int getID() {
		return id;
	}
	
	public void setID(int id) {
		this.id = id;
	}
	
	public JButton getButton() {
		return button;
	}
	
	public void setValue(String val) {
		this.value = val;
		//button.setText(value);
	}
	
	public String getValue() {
		return this.value;
	}
	
	public void reveal() {
		if (!revealed && !sealed) {
			revealed = true;
			button.setText(value);
		}
	}
	
	private void seal() {
		if (!revealed && !sealed) {
			sealed = true;
			button.setText("S");
		}
	}
	
	private void unseal() {
		if (sealed) {
			sealed = false;
			button.setText("");
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		// To Do
		this.reveal();
	}
	
}