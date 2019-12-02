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
	
	public Boolean revealed;
	public Boolean sealed;
		
	public Cell(Game game) {
		button = new JButton();
		button.addActionListener(this);
		this.game = game;
		revealed = false;
		sealed = false;
		button.addActionListener(actionListener);
		button.setText("");
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
	}
	
	public String getValue() {
		return this.value;
	}
	
	public void reveal() {
		button.setBackground(Color.WHITE);
		revealed = true;
		switch (value) {
		case "1":
		case "2":
		case "3":
		case "4":
		case "5":
		case "6":
		case "7":
		case "8":
			button.setBackground(Color.green);
			break;
		case "X":
			button.setForeground(Color.black);
			button.setBackground(Color.red);
			break;
		default:
			button.setBackground(Color.white);
			button.setForeground(Color.black);
		}
		button.setText(value);
	}
	
	private void seal() {
		sealed = true;
		button.setForeground(Color.blue);
		button.setText("S");
	}
	
	private void unseal() {
		sealed = false;
		button.setText("");
	}
	
	public void actionPerformed(ActionEvent e) {
		reveal();
	}
	
}