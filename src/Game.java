import javax.swing.*;
import java.lang.annotation.Target;
import java.util.Scanner;

public class Game {


    final int column = 3;
    final int row = 3;
    Map gameMap = new Map();
    ;
    char pcChar, playerChar;
    Minimax minimax;

    void findBestMove() {


        minimax = new Minimax(gameMap, switchPlayer(pcChar), (pcChar));
        Move pcMove = minimax.play();

       // System.out.println(pcMove.row + " " + pcMove.column);
        gameMap.setTable(pcMove.row, pcMove.column, pcChar);

    }


    char switchPlayer(char playerChar) {
        if (playerChar == 'x')
            return 'o';
        return 'x';

    }

    void playerPlays() {
        Scanner input = new Scanner(System.in);

        while (true) {

            System.out.println("Enter Column & Row (0 based)");

            int row = input.nextInt();
            int column = input.nextInt();

            if(row>2 || column >2 || !gameMap.isMoveAvailable(row,column))
                System.out.println("invalid choice");

            else if (gameMap.isMoveAvailable(row, column)) {
                gameMap.setTable(row, column, playerChar);
                break;
            }

        }


    }

}
