package Game;

import javax.swing.*;
import java.awt.*;

import java.util.Random;

import Game.Cell;

public class Game {
	
	
	private static final int SIZE = 10;
	
	private Cell[][] cells;
	private int cellID = 0;
	
	
	public Game() {
		JFrame window = new JFrame("Minesweeper");
		window.add(createGrid());
		window.setSize(600, 600);
		
        cells = new Cell[SIZE][SIZE];

        plantMines();
        setCellValues();
        
        Cell cel = getCellByID(2);
        cel.button.setText("Test");
        
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }
	
	public JPanel createGrid() {
		JPanel panel = new JPanel(new GridLayout(SIZE,SIZE));
		cells = new Cell[SIZE][SIZE];
		
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				cells[i][j] = new Cell(this);
				cells[i][j].setID(getID());
				panel.add(cells[i][j].getButton());
			}
		}
		
		return panel;
	}
	
	public void setGame() {
		
	}
	
	private void plantMines() {
		
	}
	
	private void setCellValues() {
		
	}
	
	public int getID() {
		int id = this.cellID;
		this.cellID++;
		return id;
	}
	
	public Cell getCellByID(int id) {
		int i = id / 10;
		int j = id % 10;
		return cells[i][j];
		
	}
	
}
