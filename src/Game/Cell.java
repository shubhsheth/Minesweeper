package Game;

import javax.swing.JButton;

public class Cell extends JButton {
	private final int x;
	private final int y;
	private Boolean revealed;
	private Boolean sealed;
	private Boolean mined;
	
	Cell(final int x, final int y, final Boolean mined) {
		this.x = x;
		this.y = y;
		this.mined = mined;
		revealed = false;
		sealed = false;
		
		setText("");
		if (mined)
			setText("M");
	}
}