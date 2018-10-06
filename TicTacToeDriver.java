import java.util.Scanner;
import java.util.NoSuchElementException;
public class TicTacToeDriver{
	public static void main(String[] args){
		boolean done = false, pass1 = false, pass2 = false;
		int num1 = 1, num2 = 2;
		int won1 = 0, won2 = 0;
		int position;
		TicTacToe player1 = new TicTacToe(), player2 = new TicTacToe();
		Scanner scan  = new Scanner(System.in);
		System.out.println(player1);
		while(!done){
			while(!pass1){
				System.out.println("Take a move player 1");
				try{
				position = scan.nextInt();
				}catch(NoSuchElementException err){
					//System.out.println("quit..");
					return;
				}
				System.out.println(position);
				player1 = new TicTacToe(num1,position);
				int legal = player1.ifLegal();
				if(legal == 1){
					player1.addMoves();
					break;
				}
			}
			System.out.println(player1);
			TicTacToe.checkIfWon();
			if(TicTacToe.won == 1){
				TicTacToe.resultOfGame();
				break;
			}
			TicTacToe.checkIfTie();
			if(TicTacToe.tie == 1){
				TicTacToe.resultOfGame();
				break;
			}
			while(!pass2){
				System.out.println("Take a move player 2");
				position = scan.nextInt();
				player2 = new TicTacToe(num2, position);
				int legal = player2.ifLegal();
				if(legal == 1){
					player2.addMoves();
					break;
				}
			}
			System.out.println(player2);
			TicTacToe.checkIfWon();
			if(TicTacToe.won == 2){
				TicTacToe.resultOfGame();
				break;
			}
			TicTacToe.checkIfTie();
			if(TicTacToe.tie == 1){
				TicTacToe.resultOfGame();
				break;
			}	
		}
	}
}