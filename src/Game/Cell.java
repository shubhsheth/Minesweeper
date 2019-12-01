package Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Cell implements ActionListener {

	private Game game;
	private JButton button;

	private int id;
	private String value;
	
//	private Boolean mined;
	
	private Boolean revealed;
	private Boolean sealed;
		
	
	public Cell(Game game) {
		
		button = new JButton();
		this.game = game;
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
	
	public void setValue(String val) {
		this.value = val;
		button.setText(val);
	}
	
	public void actionPerformed(ActionEvent e) {
		
	}
	
}