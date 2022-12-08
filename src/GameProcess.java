/*** The Main logic of the code. A GameProcess class is created, and the game can function using the logic in this code.***/
import java.util.Scanner;

class GameProcess{

    /*** Creates a Scanner object ***/
    Scanner scan = new Scanner(System.in);

    /*** Variables ***/
    private String pchar = "";
    private String computerChar = "";
    private int computer = -1;
    private int choice = -1;
    private String codeDetect = "";

    //Extra Variables, stores each value of the slots on the board.
    private String one = " ";
    private String two = " ";
    private String three = " ";
    private String four = " ";
    private String five = " ";
    private String six = " ";
    private String seven = " ";
    private String eight = " ";
    private String nine = " ";

    /*** Constructor ***/
    public GameProcess(int choice){
        this.choice = choice;
    }

    /*** Methods ***/

    /*** Method startingSequence: The starting sequence in order to play TicTacToe. ***/
    public void startingSequence(int choice){
        if(this.choice == 1 && choice == this.choice){
            System.out.println();
            System.out.println("This is the board.");
            System.out.println("- - - - - - - - ");
            System.out.print("[1] [2] [3]\n[4] [5] [6]\n[7] [8] [9]\n");
            System.out.println("- - - - - - - - ");
            System.out.println();
            System.out.println("Each number corresponds to a place on the board.");
            System.out.println("You can place your move by entering the corresponding integer.");
        }
        System.out.println();
        System.out.print("Choose between \"X\" or \"O\": ");
        String str = scan.nextLine();
        while(!str.equals("O") && !str.equals("X")){
            str = scan.nextLine();
            if(!str.equals("O") && !str.equals("X")){
                System.out.print("Invalid Choice! Choose between \"X\" or \"O\": ");
            }
        }
        if(str.equals("O")){
            computerChar = "X";
        }else{
            computerChar = "O";
        }
        pchar = str;
        progress();
    }


    /*** Method: getComputerMove. Gets the computer's next move by using math.Random(), selecting a random square slot. If the slot is filled, it selects another until there is an empty slot. ***/
    public void getComputerMove(){
        codeDetect = one+two+three+four+five+six+seven+eight+nine;
        computer = (int)(Math.random()*(8) + 1);
        if(codeDetect.indexOf(" ") > -1){
            while(!codeDetect.substring(computer - 1, computer).equals(" ")){
                computer = (int)(Math.random()*(8) + 1);
                if(codeDetect.substring(computer - 1, computer) == " "){
                    break;
                }
            }
        }
        store(computer, computerChar);
    }

    /*** Method: winDetect. This method detects if the player/computer has won. If player/computer gets 3 in a row, the method will return an integer based on who won. 0 = tie, 1 = computer, 2 = computer. ***/
    public int winDetect(){
        int returnVar = 0;
        if(one.equals(two) && two.equals(three) && one != " "){
            if(one.equals(pchar)){
                returnVar = 2;
            }else{
                returnVar = 1;
            }
        }
        if(four.equals(five) && five.equals(six) && four != " "){
            if(four.equals(pchar)){
                returnVar = 2;
            }else{
                returnVar = 1;
            }
        }
        if(seven.equals(eight) && eight.equals(nine) && seven != " "){
            if(seven.equals(pchar)){
                returnVar = 2;
            }else{
                returnVar = 1;
            }
        }
        if(one.equals(four) && four.equals(seven) && one != " "){
            if(one.equals(pchar)){
                returnVar = 2;
            }else{
                returnVar = 1;
            }
        }
        if(two.equals(five) && five.equals(eight) && two != " "){
            if(two.equals(pchar)){
                returnVar = 2;
            }else{
                returnVar = 1;
            }
        }
        if(three.equals(six) && six.equals(nine) && three != " "){
            if(three.equals(pchar)){
                returnVar = 2;
            }else{
                returnVar = 1;
            }
        }
        if(one.equals(five) && five.equals(nine) && one != " "){
            if(one.equals(pchar)){
                returnVar = 2;
            }else{
                returnVar = 1;
            }
        }
        if(three.equals(five) && five.equals(seven) && three != " "){
            if(three.equals(pchar)){
                returnVar = 2;
            }else{
                returnVar = 1;
            }
        }
        return returnVar;
    }

    /*** Method: store. This method stores the inputs of the player and computer into the corresponding slot on the board so it can be printed. ***/
    public Boolean store(int num, String input){
        Boolean returnVar = true;
        if(num == 1){
            if(one.equals(" ")){
                one = input;
            }else{
                returnVar = false;
            }
        }
        if(num == 2){
            if(two.equals(" ")){
                two = input;
            }else{
                returnVar = false;
            }
        }
        if(num == 3){
            if(three.equals(" ")){
                three = input;
            }else{
                returnVar = false;
            }
        }
        if(num == 4){
            if(four.equals(" ")){
                four = input;
            }else{
                returnVar = false;
            }
        }
        if(num == 5){
            if(five.equals(" ")){
                five = input;
            }else{
                returnVar = false;
            }
        }
        if(num == 6){
            if(six.equals(" ")){
                six = input;
            }else{
                returnVar = false;
            }
        }
        if(num == 7){
            if(seven.equals(" ")){
                seven = input;
            }else{
                returnVar = false;
            }
        }
        if(num == 8){
            if(eight.equals(" ")){
                eight = input;
            }else{
                returnVar = false;
            }
        }
        if(num == 9){
            if(nine.equals(" ")){
                nine = input;
            }else{
                returnVar = false;
            }
        }
        return returnVar;
    }

    //*** Method: progress. This method progresses the game by asking the player where they want to move at, then detects if that position is available. If it isn't, it requests the player to choose another Integer. After a valid integer gets selected, the method calls getComputerMove (gets computer's move) and then prints the board. This method also detects who won.***/
    public void progress(){
        while (winDetect() == 0){
            System.out.print("Enter an integer based on the square you want to move at: ");
            int playerChoice = scan.nextInt();
            while(!store(playerChoice, pchar) || playerChoice > 9 || playerChoice < 1){
                System.out.print("Invalid choice! Enter another Integer: ");
                playerChoice = scan.nextInt();
            }
            store(playerChoice, pchar);
            getComputerMove();
            printBoard();
        }
        if(winDetect() == 1){
            System.out.println("Computer Wins!");
        }else if(winDetect() == 2){
            System.out.println("Player Wins!");
        }else{
            System.out.println("Tie!");
        }

    }

    /*** Method: printBoard. This method prints the board when called, based on the variables per slot.***/
    public void printBoard(){
        System.out.println();
        System.out.println("Game Board: ");
        System.out.println("- - - - - - - - ");
        System.out.print("[" + one + "] [" + two + "] [" + three + "]\n");
        System.out.print("[" + four + "] [" + five + "] [" + six + "]\n");
        System.out.print("[" + seven + "] [" + eight + "] [" + nine + "]\n");
        System.out.println("- - - - - - - - ");
        System.out.println();
    }

}