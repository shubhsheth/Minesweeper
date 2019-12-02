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
		button.setText(value);
	}
	
	private void seal() {
		sealed = true;
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