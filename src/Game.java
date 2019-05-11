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

        gameMap.print();
        System.out.printf("'pc's turn");

        minimax = new Minimax(gameMap, switchPlayer(pcChar), (pcChar));
        Move pcMove = minimax.play();

        System.out.println(pcMove.row + " " + pcMove.column);
        gameMap.setTable(pcMove.row, pcMove.column, pcChar);

    }


    char switchPlayer(char playerChar) {
        if (playerChar == 'X')
            return 'O';
        return 'X';

    }

    void playerPlays() {
        Scanner input = new Scanner(System.in);
        System.out.println("your turn");

        while (true) {

            gameMap.print();
            System.out.println("Enter Column & Row (0 based)");

            int row = input.nextInt();
            int column = input.nextInt();

            if (gameMap.IsMoveAvailable(row, column)) {
                gameMap.setTable(row, column, playerChar);
                break;
            }
        }


    }

}
