package Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Cell implements ActionListener {
	private Game game;
//	private final int x;
//	private final int y;
	private Boolean revealed;
	private Boolean sealed;
	private Boolean mined;
	private int id;
	public JButton button;
	
	
	public Cell(Game game) {
		
		button = new JButton();
		
//		
//		this.x = x;
//		this.y = y;
//		this.mined = mined;
//		revealed = false;
//		sealed = false;
//		
//		setText("");
//		if (mined)
//			setText("M");
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
	
	public void setValue(String text) {
		button.setText(text);
	}
	
	public void actionPerformed(ActionEvent e) {
		
	}
	
}