package com.jv.queue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class SnakeGame {
	
	List<Cell> foods;
	
	int [][] board; // not required.. Just keeping track of n , m would be fine. 
	
	Deque<Cell> snake; //I used array deque bcoz i wanted to see last element as well.
	
	
	
	public SnakeGame(int n, int m , List<Cell> foods) {
		
		this.board = new int[n][m];
		
		this.foods = foods;
		
		snake = new ArrayDeque<>();
		
		Cell curr = new Cell(0,0);
		
		snake.add(curr);
		
	}
	
	public void move(Move move) throws Exception {
		Cell curr = snake.peekLast();
		Cell nextCell = new Cell(curr.x, curr.y);
		switch(move) {
			case UP: 
				nextCell.x=nextCell.x-1;
				break;
			case DOWN:
				nextCell.x=nextCell.x+1;
				break;
			case LEFT:
				nextCell.y=nextCell.y-1;
				break;
			case RIGHT:
				nextCell.y=nextCell.y+1;
				break;
			
		}
		
		//Now cur cell is set.
		
		
		
		if(snake.contains(nextCell)) {
			System.out.print("Game Over!!");
			throw new Exception("Game over!!");
		}
		
		System.out.println("next cell : " + nextCell + " - food : " + foods.get(0));
		if(foods.isEmpty()|| !nextCell.equals(foods.get(0))) { //Always taking the first cell for food.
			//snake does not grow... so remove the prev cell.
			System.out.println("in");
			snake.poll();
		}
		else
			foods.remove(0);
		
		//snake moves to nextcell.
		snake.add(nextCell);
		
	}
	
	
	public static void main(String [] args) {
		
		List<Cell> foods = new ArrayList<>();
		
		foods.add(new Cell(1, 1));
		foods.add(new Cell(2, 2));
		foods.add(new Cell(1, 3));
		
		
		
		SnakeGame game = new SnakeGame(3, 4, foods);
		
		System.out.println("Your snake is at from tail to head :  " + game.snake);
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			System.out.println("Enter your move : ");
			String move = scanner.next();
			
			if(move.equals("exit"))
				break;
			
			try {
				game.move(Move.getMove(move));
				System.out.println("Your snake is at from tail to head :  " + game.snake);
			} catch (Exception e) {
				System.out.println("Game Over!!");
				break;
			}
			
		}
		
		scanner.close();
		
	}
	
	

}


class Cell {
	
	int x;
	int y;
	
	public Cell(int x , int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj!=null) {
			Cell cell = (Cell) obj;
			return cell.x == this.x && cell.y == this.y;
		}
		return false;
	}
	
	@Override
	public String toString() {
		
		return "("+this.x+","+this.y+")";
	}
	
}

enum Move{
	UP("U") , DOWN("D") , RIGHT("R") , LEFT("L");
	
	
	private Move(String value) {
		this.value=value;
	}
	private String value;
	
	
	private static Map<String,Move> map = new HashMap<>();
	
	static {
		for(Move move : Move.values()) {
			map.put(move.value, move);
		}
	}
	
	public static Move getMove(String value) {
		return map.get(value);
	}
	
	
}