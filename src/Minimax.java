public class Minimax {


    Map gameMap;
    Move bestMove;
    char playerChar;
    char opponentChar;
    int column = 3;
    int row = 3;

    public Minimax(Map gameMap, char playerChar, char opponentChar) {
        this.playerChar = playerChar;
        this.opponentChar = opponentChar;
        this.gameMap = gameMap;
        bestMove = new Move(0, 0, 0);
    }


    Move play() {
        bestMove=new Move(0,0,1000);

        for (int i = 0; i < column; i++)
            for (int j = 0; j < row; j++)

                if (gameMap.isMoveAvailable(i, j)) {

                    Move tempMove = new Move(i, j, 0);
                    gameMap.setTable(i, j, opponentChar);
                    tempMove.score = minimax(0, true);
                    gameMap.undoSetTable(i, j);

                    bestMove = updateBestMove(tempMove, bestMove);
                }
        return bestMove;

    }

    int minimax(int depth, boolean maxplayer) {

        if (gameMap.checkIfGameIsFinished() != '-')
            return evaluate(gameMap);

        if (maxplayer) return CalculateMinimaxForMaxplayer(depth, maxplayer);
        else return CalculateMinimaxForMinplayer(depth, maxplayer);


    }

    int CalculateMinimaxForMaxplayer(int depth, boolean maxplayer) {

        int bestscore = -1000;
        for (int i = 0; i < column; i++)
            for (int j = 0; j < row; j++)

                if (gameMap.isMoveAvailable(i, j)) {

                    gameMap.setTable(i, j, playerChar);
                    bestscore = Math.max(bestscore, minimax(depth + 1, !maxplayer));
                    gameMap.undoSetTable(i, j);
                }
        return bestscore;
    }

    int CalculateMinimaxForMinplayer(int depth, boolean maxplayer) {

        int bestscore = 1000;
        for (int i = 0; i < column; i++)
            for (int j = 0; j < row; j++)

                if (gameMap.isMoveAvailable(i, j)) {

                    gameMap.setTable(i, j, opponentChar);
                    bestscore = Math.min(bestscore, minimax(depth + 1, !maxplayer));
                    gameMap.undoSetTable(i, j);
                }
        return bestscore;

    }

    Move updateBestMove(Move tempMove, Move BestMove) {
        if (tempMove.score < BestMove.score) {
            BestMove.row = tempMove.row;
            BestMove.column = tempMove.column;
            BestMove.score = tempMove.score;

        }
        return BestMove;
    }

    int evaluate(Map map) {
        if (map.checkIfGameIsFinished() == playerChar)
            return 10;
        else if (map.checkIfGameIsFinished() == opponentChar)
            return -10;
        else return 0;
    }


}
