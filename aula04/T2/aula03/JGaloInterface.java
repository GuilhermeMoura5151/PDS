;

public interface JGaloInterface {
	public abstract char getActualPlayer();
	public abstract boolean setJogada(int lin, int col);
	public abstract boolean isFinished();
	public abstract char checkResult();
	public abstract boolean isFull();
	public abstract boolean checkMark(char c1, char c2, char c3); 
}
