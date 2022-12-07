import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        /*** Creates new Scanner object ***/
        Scanner scan = new Scanner(System.in);

        /*** Introductory Sequence. This sequence leads into the main content and logic of the code. Players choose between 2 options, to either learn how to play or just start the game. ***/

        System.out.println("Welcome to TicTacToe!");
        System.out.println("1. Help! How do I place my move?");
        System.out.println("2. Start the Game!");
        System.out.print("Please enter your choice: ");
        int choice = scan.nextInt();
        GameProcess game = new GameProcess(choice);
        game.startingSequence(choice);
    }
}