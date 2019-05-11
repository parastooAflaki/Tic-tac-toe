import java.util.Scanner;

public class main {


    public static void main(String[] args) {


        Scanner input = new Scanner(System.in);

        Game game = new Game();
        game.playerChar = input.next().charAt(0);
        game.pcChar = game.switchPlayer(game.playerChar);

        int turn=0; //turn=0 menas its ps's turn to play....turn=1 means its player's turn;

        if(game.playerChar=='x')
            turn=1;

        while (game.gameMap.checkIfGameIsFinished() == '-') {


            if(turn==0)
                game.findBestMove();
            else
                game.playerPlays();


            }

            System.out.println(game.gameMap.checkIfGameIsFinished());
        }


        public static char reverseTurn(char turn){
            if(turn=='x')
                return 'o';
            else
                return 'x';


    }


}
