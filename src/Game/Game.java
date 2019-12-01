package Game;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;

import Game.Cell;

public class Game {
	private static final int MINES = 10;
	private static final int WIDTH = 10;
	
	private JFrame window;
	
	private Cell[][] board;
	
	
	
	public Game() {
        board = new Cell[WIDTH][WIDTH];

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
