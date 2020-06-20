package br.com.rodrigosnr.tictactoe.core;

import br.com.rodrigosnr.tictactoe.ui.UI;

public class Player {

	private String name;
	private Board board;
	private char symbol;
	
	
	
	public Player(String name, Board board, char symbol) {
		this.name = name;
		this.board = board;
		this.symbol = symbol;
	}

	private Move inputMove() throws InvalidMoveException{
		String moveStr = UI.readInput("Jogador '" + name + "' =>");
		Move m = new Move(moveStr);
		return m;
	}
	
	public boolean play() throws InvalidMoveException{
		Move move = inputMove();
		return board.play(this, move);
	}

	public String getName() {
		return name;
	}

	public Board getBoard() {
		return board;
	}

	public char getSymbol() {
		return symbol;
	}
	
	
}
