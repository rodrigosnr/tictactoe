package br.com.rodrigosnr.tictactoe.core;

import java.io.IOException;

import br.com.rodrigosnr.tictactoe.Constants;
import br.com.rodrigosnr.tictactoe.score.FileScoreManager;
import br.com.rodrigosnr.tictactoe.score.ScoreManager;
import br.com.rodrigosnr.tictactoe.ui.UI;

public class Game {
	
	private Board board = new Board();
	private Player [] players = new Player[Constants.SYMBOL_PLAYERS.length];
	private int currentPlayerIndex = -1;
	private ScoreManager scoreManager;
	
	
	
	public void play() throws IOException{
		scoreManager = createScoreManager();
		
		UI.printGameTitle();
		
		for (int i = 0; i < players.length; i++) {
			Player player = createPlayer(i);
			players[i] = player;
		}
		
		boolean gameEnded = false;
		Player currentPlayer = nextPlayer();
		Player winner = null;
		
		while(!gameEnded) {
			board.print();
			boolean sequenceFound;
			try {
				sequenceFound = currentPlayer.play();
			} catch (Exception e) {
				UI.printText("ERRO: " + e.getMessage());
				continue;
			}
			
			
			if (sequenceFound) {
				gameEnded = true;
				winner = currentPlayer;
			} else if (board.isFull()) {
				gameEnded = true;
			} else {
				currentPlayer = nextPlayer();
			}
		}
		
		
		if (winner == null) {
			UI.printText("O jogo terminou empatado");
			
		} else {
			UI.printText("O jogador '" + winner.getName() + "' venceu o jogo!");
			
			scoreManager.saveScore(winner);
		}
		
		board.print();
		UI.printText("Fim do jogo");
		
	}
	
	private Player createPlayer(int index) {
		String name = UI.readInput("Jogador " + (index + 1) + " =>");
		char symbol = Constants.SYMBOL_PLAYERS[index];
		Player player = new Player(name, board, symbol);
		
		Integer score = scoreManager.getScore(player);
		
		if (score != null) {
			UI.printText("O jogador '" + player.getName() + "' j� possui " + score + " vit�ria(s)!");
		}
		
		UI.printText("O jogador '" + name + "' vai usar o s�mbolo '" + symbol + "'");
		
		return player;
	}
	
	private Player nextPlayer() {
		currentPlayerIndex++;
		
		if (currentPlayerIndex >= players.length) {
			currentPlayerIndex = 0;
		}
		
		return players[currentPlayerIndex];
	}
	
	private ScoreManager createScoreManager() throws IOException{
		return new FileScoreManager();
	}
}
