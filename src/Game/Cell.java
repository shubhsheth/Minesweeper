package Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Cell implements ActionListener,MouseListener {

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
		button.addMouseListener(this);
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
		if (!sealed) {
			revealed = true;
		//		
			button.setBackground(Color.WHITE);
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
	
	public void reset() {
		button.setText("");
		value = "";
		revealed = false;
		sealed = false;
		button.repaint();
		button.setBackground(null);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (value == "" && !sealed) {
			game.revealEmptyCells(id);
		} else if (value == "X" && !sealed) {
			reveal();
			game.fail();
		} else {
			reveal();
		}
		game.checkForWin();
	}
	

	public void mousePressed(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON3) {
			if (!sealed)
				seal();
			else
				unseal();
		}
		game.checkForWin();
    }
     
    public void mouseReleased(MouseEvent e) {}
     
    public void mouseEntered(MouseEvent e) {}
     
    public void mouseExited(MouseEvent e) {}
     
    public void mouseClicked(MouseEvent e) {}
	
}