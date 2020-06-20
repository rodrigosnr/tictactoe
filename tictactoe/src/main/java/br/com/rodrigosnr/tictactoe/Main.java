package br.com.rodrigosnr.tictactoe;

import java.io.IOException;

import br.com.rodrigosnr.tictactoe.core.Board;
import br.com.rodrigosnr.tictactoe.core.Game;
import br.com.rodrigosnr.tictactoe.core.InvalidMoveException;
import br.com.rodrigosnr.tictactoe.ui.UI;

public class Main {

	public static void main(String[] args)throws IOException {
		
		Game g = new Game();
		g.play();
		
		
	}

}
