

public class JGame implements JGaloInterface{
	private char gameMatrix[][];
	private int nJogadas;
	private char actualPlayer;
	
	public JGame() {
		this.nJogadas = 0;
		this.gameMatrix = new char[3][3];
	}
	
	public char getActualPlayer() {
		if(nJogadas%2 == 0) {
			actualPlayer = 'X';
		}
		else {
			actualPlayer = 'O';
		}
		return actualPlayer;
	}
	
	public boolean setJogada(int lin, int col) {
		nJogadas++;
		if(positionIsValid(lin-1, col-1) && positionIsEmpty(lin-1, col-1)) {
			gameMatrix[lin-1][col-1] = actualPlayer;
			return true;
		}
		return false;
	}
	
	public boolean isFinished() {
		if(this.checkResult() == 'X' || checkResult() == 'O' || (checkResult() == ' ' && nJogadas == 9)) {
			return true;
		}
		return false;
	}
	
	public char checkResult() {
		for(int i = 0; i < 3; i++) {
			if(gameMatrix[0][i] == gameMatrix[1][i] && gameMatrix[1][i] == gameMatrix[2][i])
				return gameMatrix[0][i];
			else if(gameMatrix[i][0] == gameMatrix[i][1] && gameMatrix[i][1] == gameMatrix[i][2])
				return gameMatrix[i][0];
		}
		if(gameMatrix[0][0] == gameMatrix[1][1] && gameMatrix[1][1] == gameMatrix[2][2])
			return gameMatrix[0][0];
		else if(gameMatrix[0][2] == gameMatrix[1][1] && gameMatrix[1][1] == gameMatrix[2][0])
			return gameMatrix[0][2];
		return ' ';
	}
	
	private boolean positionIsValid(int lin, int col) {
		if(lin < 0 || lin > 2 || col < 0 || col > 2)
			return false;
		return true;
	}
	
	private boolean positionIsEmpty(int lin, int col) {
		if(gameMatrix[lin][col] == 'X' || gameMatrix[lin][col] == 'O')
			return false;
		return true;
	}
}
