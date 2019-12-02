package Game;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

import Game.Cell;

public class Game {
	
	private static final int SIZE = 10;
	private int cellID = 0;
	private int totalMines;
	
	JFrame window = new JFrame("Minesweeper");
	private Cell[][] cells = new Cell[SIZE][SIZE];
	
	public Game() {
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(900, 900);				
    }
	
	public void setGame() {
		window.add(createGrid());
		window.setVisible(true);

        assignMines();
        assignValues(); 
	}
	
	public JPanel createGrid() {
		JPanel panel = new JPanel(new GridLayout(SIZE,SIZE));
		
		//Create button for each grid block
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
		
		// Number of Mines - between 10 and 20
		Random r = new Random();
		this.totalMines = (int) r.nextInt((20 - 10) + 1) + 10;

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
		for ( int i = 0; i < 100; i++ ) {
			
			int surroundingMines = 0;
			
			// Get Cell
			Cell cell = getCellByID(i);
			
			// Check if cell is a mine
			if (cell.getValue() == "X") {
				continue;
			}
			
			// Get All Surrounding Cells
			int surroundingCells[] = new int[] {-11,-10,-9,-1,1,9,10,11};

			// Check for Mines
			for (int j = 0; j < 8; j++) {
				
				int cellid = i + surroundingCells[j];
				
				if (cellid > -1 && cellid < 100) {
					if (getCellByID(cellid).getValue() == "X") {						
						surroundingMines++;
					}
				}
			}
			
			// Update Current Cell
			if(surroundingMines > 0) {
				cell.setValue(String.valueOf(surroundingMines));
			}
		}
	}
	
	public void revealEmptyCells(int id) {
		
		Cell selectedCell = getCellByID(id);
		
		ArrayList<Cell> emptyCells = new ArrayList<Cell>();
		emptyCells.add(selectedCell);
		
		int i = 0;
		while(i < emptyCells.size()) {
			
			// Reveal Cell
			Cell cell = emptyCells.get(i);
			id = cell.getID();
			cell.reveal();
			
			// Get All Surrounding Cells
			ArrayList<Integer> surroundingCells = new ArrayList<Integer>();
			if(id % 10 == 0) { // left corner cells
				surroundingCells.addAll(Arrays.asList(-10,1,10));
			} else if (id % 10 == 9) { // right corner cells
				surroundingCells.addAll(Arrays.asList(-10,-1,10));
			} else {
				surroundingCells.addAll(Arrays.asList(-10,-1,1,10));
			}
			
			// Check for Empty
			for (int j = 0; j < surroundingCells.size(); j++) {
				
				int cellid = id + surroundingCells.get(j);
				
				if (cellid > -1 && cellid < 100) {
					Cell surCell = getCellByID(cellid);
					
					if (surCell.getValue() == "") {
						if (surCell.revealed == false && !emptyCells.contains(surCell)) {
							emptyCells.add(surCell);
						}
					} else if (surCell.getValue() != "X") {
						surCell.reveal();
					}
				}
			}
			
			i++;
		}
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
	
	public void endGame () {
		this.setGame();
	}
	
	
	
	public void fail() {
		JOptionPane.showMessageDialog(null, "java is fun");
	}
}
