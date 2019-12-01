package Game;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import Game.Cell;

public class Game {
	
	private static final int SIZE = 10;
	private int cellID = 0;
	private int totalMines;
	
	private Cell[][] cells = new Cell[SIZE][SIZE];
	
	public Game() {
		JFrame window = new JFrame("Minesweeper");
		window.add(createGrid());
		window.setSize(900, 900);

        assignMines();
        assignValues();
		
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }
	
	public JPanel createGrid() {
		JPanel panel = new JPanel(new GridLayout(SIZE,SIZE));
		
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				cells[i][j] = new Cell(this);
				cells[i][j].setID(getID());
				panel.add(cells[i][j].getButton());
			}
		}
		
		return panel;
	}
	
	private void assignMines() {
		
		// Number of Mines - between 20 and 30
		Random r = new Random();
		this.totalMines = (int) r.nextInt((30 - 20) + 1) + 20;

		// Assign Mines Randomly
		ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 100; i++) {
            list.add(new Integer(i));
        }
        Collections.shuffle(list); //unique random numbers from 0 - 99
        
        for ( int i = 0; i < this.totalMines; i++) {
        	Cell cell = getCellByID(list.get(i));
        	cell.setValue("X");
        }
	}
	
	private void assignValues() {
		// To Do
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
