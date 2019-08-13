

public class JGaloEngine implements JGaloInterface {
    
    private char [][] board;
    private int nPlays;
    private char actualPlayer;
    
    public JGaloEngine(){
        nPlays = 0;
        actualPlayer = 'X';
        board = new char[3][3];
        Reset();
        
    }
    
    private void Reset(){
        for (int i = 0; i < 3; i ++){
            for (int j = 0; j < 3; j++){
                board[i][j] = ' ';
            }
        }
        
    }
    @Override
    public char getActualPlayer() {
        return this.actualPlayer;
    }

    @Override
    public boolean setJogada(int lin, int col) {
        
        
        if (isFinished() || !positionValid(lin,col) || !positionEmpty(lin,col) ){
            return false; 
        }
        nPlays++;
        char jog = getActualPlayer();
        board[lin-1][col-1] = jog;
        if(jog == 'X'){
            actualPlayer = 'O';
        }
        else{
            actualPlayer = 'X';
        }
        
        return true;
        
    }
    
    private boolean positionValid(int lin, int col){
        return !(lin < 1 || lin > 3 || col < 1 || col > 3);
    }
    
    private boolean positionEmpty (int lin, int col){
        return board[lin-1][col-1] == ' ';
    }

    @Override
    public boolean isFinished() {
        if(nPlays == 9 || checkResult() != ' '){
            return true;
        }
        return false;
    }

    @Override
    public char checkResult() {
        
        for (int i = 0; i < 3; i++){
            if(
                    board[i][0] == board[i][1] && 
                    board[i][1] == board[i][2]){
                return board[i][0];
            }
            else if(
                    board[0][i] == board[1][i] && 
                    board[1][i] == board[2][i]){
                return board[0][i];
            }
        }
        boolean diag = board[0][0] == board[1][1] && board[1][1] == board [2][2];
        if (diag){
            return board[0][0];
        }
        
        return ' ';
    }
    
    
}

