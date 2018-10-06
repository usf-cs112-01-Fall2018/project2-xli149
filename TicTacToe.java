import java.util.Scanner;
public class TicTacToe{
	private static int[][] board;
	private int player;
	private int position;
	public static int won = 0;
	public static int tie = 0;
	public TicTacToe(int player, int position){
		this.player = player;
		this.position = position;
	}
	public TicTacToe(){//default constructor!
		board = new int[3][3];
	}
	public void addMoves(){
		boolean done = false;
		while(!done){
			for(int i = 0; i < 3; i++){
				for(int j = 0; j < 3; j++){
					if(3*i + j + 1 == position && board[i][j] == 0){
						board[i][j] = this.player;
						done = true;
					}
				}
			}
		}
	}
	/**public void addMovesAgain(){
		Scanner scan = new Scanner(System.in);
		this.position = scan.nextInt();
	}**/
	public static void checkIfWon(){
		for(int i = 0; i < 3; i++){
			if(board[i][0] == board[i][1] && board[i][0] == board[i][2]){
					won = board[i][0];
					return;
			}
		}
		for(int j = 0; j < 3; j++){
			if(board[0][j] == board[1][j] && board[0][j] == board[2][j]){
					won =  board[0][j];
					return;
			}
		}
		if(board[0][0] == board[1][1] && board[0][0] == board[2][2]){
			won =  board[0][0];
			return;
		}
		else if(board[0][2] == board[1][1] && board[0][2] == board[2][0]){
			won =  board[0][2];
			return;
		}
 	}
 	public static void checkIfTie(){
 		int count = 0;
 		for(int i = 0; i < 3; i++){
 			for(int j = 0; j < 3; j++){
 				if(board[i][j] == 0){
 					count++;
 				}
 			}
 		}
 		if(count == 0){
 			tie = 1;
 		}
 	}
 	public int ifLegal(){
 		for(int i = 0; i < 3; i++){
 			for(int j = 0; j < 3; j++){
 				if(3*i + j + 1 == this.position && board[i][j] != 0){
 					System.out.println("This is not a legal move, try again.");
 					return 0;
 				}
 			}
 		}
 		if(position > 9 || position < 0){
 			System.out.println("This is not a legal move, try again.");
 			return 0;
 		}
 		else{
 			return 1;
 		}
 	}
 	public static void resultOfGame(){
 		if(won == 1){
 			System.out.println("Player 1 won.");
 		}
 		else if(won == 2){
 			System.out.println("Player 2 won.");
 		}
 		else if(tie == 1){
 			System.out.println("Tie game.");
 		}
 	}
 	public String toString(){
 		String result = "";
 		for(int i = 0; i < 3; i++){
 			for(int j = 0; j < 3; j++){
 				result += "[" + board[i][j] + "] ";
 			}
 			result += "\n";
 		}
 		return result;
 	}
}