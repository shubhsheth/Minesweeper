package FirstWindow;
import javax.swing.*;
import java.util.*;
import java.awt.*;

public class FirstWindow {
	public static final int WIDTH = 300;
	public static final int HEIGHT = 200;
	
	public static void main(String[] args) {
//		JFrame firstWindow = new JFrame("Window Title");
//		firstWindow.setSize(WIDTH, HEIGHT);
//		
//		firstWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		firstWindow.setVisible(true);
		new Game(10);
	}
	
	public static class Game {
		private static final int MINES = 10;
		private static final int WIDTH = 10;
		
		private JFrame window;
		
		private Cell[][] board;
		
		private class Cell extends JButton {
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
		
		private Game(final int width) {
	        board = new Cell[width][width];

	        window = new JFrame("Minesweeper");
	        window.setSize(300, 200);
	        window.setLayout(new BorderLayout());

	        createGrid();

	        window.setLocationRelativeTo(null);
	        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        window.setVisible(true);
	    }
		
		private void createGrid() {
			Container grid = new Container();
			Random r = new Random();
			
			grid.setLayout(new GridLayout(WIDTH, WIDTH));
			
			for (int i = 0; i < WIDTH; i++) {
				for (int j = 0; j < WIDTH; j++) {
					board[i][j] = new Cell(i, j, r.nextBoolean());
					grid.add(board[i][j]);
				}
			}
			window.add(grid, BorderLayout.CENTER);
		}
	}
	
}
