package tictactoe;
import java.util.*;

public class Main {
    private final String[][] board;
    private final Scanner scanner;
    private int xCount;
    private int oCount;
    private String turn;

    /* Constructor */
    public Main()   {
        this.board = new String[][]   {
                {" ", " ", " "},
                {" ", " ", " "},
                {" ", " ", " "}
        };
        this.scanner = new Scanner(System.in);
        this.xCount = 0;
        this.oCount = 0;
        this.turn = "X";
    }

    public void run()    {
        displayBoard();
        gameLoop();
    }
    public void displayBoard() {
        System.out.printf(
                "---------%n" +
                "| %s %s %s |%n" +
                "| %s %s %s |%n" +
                "| %s %s %s |%n" +
                "---------%n",
                board[0][0], board[0][1], board[0][2],
                board[1][0], board[1][1], board[1][2],
                board[2][0], board[2][1], board[2][2]);
    }
    private String readInput()  {
        return scanner.nextLine();
    }

    private boolean gameState()    {
        if(scanBoard("X"))  {
            System.out.println("X wins");
            return true;
        }else if(scanBoard("O"))    {
            System.out.println("O wins");
            return true;
        } else if(xCount + oCount == 9)   {
                System.out.println("Draw");
                return true;
        }   else    {
                return false;   // Game isn't finished
        }
    }
    private boolean scanBoard(String input)  {
        if(!this.board[0][0].equals("_")
                && this.board[0][0].equals(input)
                && this.board[0][1].equals(input)
                && this.board[0][2].equals(input))
            return true;
        else if(!this.board[1][0].equals("_")
                && this.board[1][0].equals(input)
                && this.board[1][1].equals(input)
                && this.board[1][2].equals(input))
            return true;
        else if(!this.board[2][0].equals("_")
                && this.board[2][0].equals(input)
                && this.board[2][1].equals(input)
                && this.board[2][2].equals(input))
            return true;
        else if(!this.board[0][0].equals("_")
                && this.board[0][0].equals(input)
                && this.board[1][0].equals(input)
                && this.board[2][0].equals(input))
            return true;
        else if(!this.board[0][1].equals("_")
                && this.board[0][1].equals(input)
                && this.board[1][1].equals(input)
                && this.board[2][1].equals(input))
            return true;
        else if(!this.board[0][2].equals("_")
                && this.board[0][2].equals(input)
                && this.board[1][2].equals(input)
                && this.board[2][2].equals(input))
            return true;
        else if(!this.board[0][0].equals("_")
                && this.board[0][0].equals(input)
                && this.board[1][1].equals(input)
                && this.board[2][2].equals(input))
            return true;
        else return !this.board[2][0].equals("_")
                    && this.board[2][0].equals(input)
                    && this.board[1][1].equals(input)
                    && this.board[0][2].equals(input);
    }
    private void gameLoop() {
        while(!gameState()) {
            System.out.print("Enter the coordinates: ");
            String input = readInput();
            input = input.replaceAll(" ", "");

            if (input.matches("[1-3][1-3]"))  {
                int x = Character.getNumericValue(input.charAt(0));
                int y = Character.getNumericValue(input.charAt(1));
                System.out.println("x: " + --x + "\ty: " + --y);
                if(this.board[x][y].equals("X") || this.board[x][y].equals("O"))  {
                    System.out.println("This cell is occupied! Choose another one!");
                }   else    {
                    this.board[x][y] = turn;
                    if(turn.equals("X"))    {
                        xCount++;
                    }else   {
                        oCount++;
                    }
                    turn = turn.equals("X") ? "O" : "X"; // Swap turn with player
                    displayBoard();
                }
            }else {
                if(!input.matches("\\d{2}"))   {
                    System.out.println("You should enter numbers!");
                }   else    {
                    System.out.println("Coordinates should be from 1 to 3!");
                }
            }
        }
    }
    public static void main(String[] args) {
        Main ticTacToe = new Main();
        ticTacToe.run();
    }
}
