//import the Scanner class used for user input
import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {

        Human h = new Human("Andrew", "X");
        Computer c = new Computer("O");
        Scanner sc =  new Scanner(System.in);
        board b = new board();

        while(!b.checkWin(c.token)) {
            boolean legalCol = false;
            int moveCol = -1;
            while(!legalCol) {

                System.out.println(h.name + " enter column to move:");

                if(sc.hasNextInt()) {
                    moveCol = sc.nextInt()-1;
                    legalCol = true;

                    if(moveCol > 8) {
                        System.out.println("Enter a valid column!");
                        legalCol = false;
                        sc.next();
                    }

                    if(moveCol < 8 && !b.colHasRoom(moveCol)){
                        System.out.println("Column is Full");
                        legalCol = false;
                        sc.next();
                    }
                }
                else {
                    System.out.println("Enter a legal column!");
                    sc.next();  //very important, resets the input from the "bad" one
                }



                if(legalCol && b.colHasRoom(moveCol)) {
                    b.makeMove(moveCol,h.token);
                }
            }
            if(b.checkWin(h.token)) {
                break;
            }
            int cMove = c.determineMove();
            b.makeMove(cMove,c.token);
            b.printBoard();
        }
        System.out.print("Game Over!!");
    }

}