import java.util.Scanner;

public class main {


    public static void main(String[] args) {


        Scanner input = new Scanner(System.in);

        Game game = new Game();
        System.out.println("choose your character: (x,o)");
        game.playerChar = input.next().charAt(0);
        game.pcChar = game.switchPlayer(game.playerChar);

        int turn = 0; //turn=0 menas its ps's turn to play....turn=1 means its player's turn;

        if (game.playerChar == 'x')
            turn = 1;

        while (game.gameMap.checkIfGameIsFinished() == '-') {

            System.out.println("");
            game.gameMap.print();
            if (turn == 0)
                game.findBestMove();
            else
                game.playerPlays();
            turn = reverseTurn(turn);


        }
        System.out.println("");
        game.gameMap.print();
        if (game.gameMap.checkIfGameIsFinished() == 'D')
            System.out.println("Draw!");
        else
            System.out.println(game.gameMap.checkIfGameIsFinished() + " WINS!");
    }


    public static char reverseTurn(int turn) {
        if (turn == 1)
            return 0;
        else
            return 1;
    }


}
