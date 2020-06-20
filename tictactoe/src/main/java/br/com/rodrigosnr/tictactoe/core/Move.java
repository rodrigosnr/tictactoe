package br.com.rodrigosnr.tictactoe.core;

public class Move {
	
	private int i;
	private int j;
	
	public Move(String moveStr) throws InvalidMoveException{
		
		try {
			String[] tokens = moveStr.split(",");
			
			this.i = Integer.parseInt(tokens[0]);
			this.j = Integer.parseInt(tokens[1]);
		} catch (Exception e) {
			throw new InvalidMoveException("Jogada inv�lida");
		}
		
		

	}
	public int getI() {
		return i;
	}
	public int getJ() {
		return j;
	}

}
