

public class JGaloEngine implements JGaloInterface{
	
	private char[][] board;
	private char actualPlayer;
	private int numPlays;
	
	public JGaloEngine (char player) {
		this.board = new char[4][4];
		this.actualPlayer = player;
		this.numPlays = 0;
	}

	public char getActualPlayer() {
		// TODO Auto-generated method stub		
		return actualPlayer;
	}

	public boolean setJogada(int lin, int col) {
		// TODO Auto-generated method stub
		
		if ((lin >= 0) && (lin <= 3)) { // verificar os limites do tabuleiro
			if ((col >= 0) && (col <= 3)) {
				if (getActualPlayer() == 'X') { // alternar entre os jogadores
					actualPlayer = 'O';
					numPlays++;
				} else {
					actualPlayer = 'X';
					numPlays++;
				}
				if (board[lin][col] == 0) { // verificar se esta vazio
					board[lin][col] = getActualPlayer(); // inserir jogada
					return true;
				}
			}
		}
		return false;
	}

	public boolean isFinished() {
		// TODO Auto-generated method stub
		if (checkResult() == 'w' || checkResult() == 'd') {
			return true;
		}
		return false;
	}
	
	public boolean isFull() { // checar se o tabuleiro esta cheio -> empate
		if (numPlays > 8) {
			return true;
		}
		return false;
	}
	
	public boolean checkMark(char c1, char c2, char c3) { // método para a verificação de ganhador		
		return ((c1 != 0) && (c1 == c2) && (c2 == c3));
	}

	public char checkResult() {
		// TODO Auto-generated method stub
		if (isFull()) {
			return 'd'; // empate
		} else {
			for (int i = 1 ; i <= 3 ; i++) {
				System.out.println(board[i][0]);
				if (checkMark(board[i][1], board[i][2], board[i][3])|| // verificar colunas e linhas
					checkMark(board[1][i], board[2][i], board[3][i])) {
					return 'w';
					
				} else if (checkMark(board[1][1], board[2][2], board[3][3])|| // verificar diagonais
						   checkMark(board[1][3], board[2][2], board[3][1])) {
					return 'w';
				}
			}		
		}	
		return 0;
	}
}
