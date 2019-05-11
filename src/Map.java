public class Map{


    char[][] table=new char[3][3];
    int column=3;
    int row=3;

    public Map(){

        for (int i = 0; i <3 ; i++) {
            for (int j = 0; j <3 ; j++) {
                table[i][j]='-';
            }
        }

    }

    void setTable(int row,int column,char playerChar)
    {
        table[row][column]=playerChar;
    }
    void undoSetTable(int row,int column){

        table[row][column]='-';
    }



    boolean isMoveAvailable(int row,int column) {

        if (table[row][column] == '-')
            return true;
        return false;
    }



    char checkColumns(){

        for(int i=0;i<column;i++)
            if(table[0][i]==table[1][i]&& table[1][i]==table[2][i]&& table[1][i]!='-')
                return table[1][i];
    return '-';

    }



    char checkRows(){

        for(int i=0;i<row;i++)
            if(table[i][0]==table[i][1]&& table[i][1]==table[i][2]&& table[i][1]!='-')
                return table[i][1];
        return '-';

    }




    char checkDimension(){

      if(table[0][0]==table[1][1] && table[1][1]==table[2][2] && table[1][1]!='-')
          return table[1][1];
      if (table[0][2]==table[1][1] && table[1][1]==table[2][0] && table[1][1]!='-')
          return table[1][1];
      return '-';

    }


    char checkIfGameIsFinished() {


        if (checkColumns() != '-')
            return checkColumns();
        if (checkRows() != '-')
            return checkRows();
        if (checkDimension() != '-')
            return checkDimension();
        else {
            for (int i = 0; i < row; i++)
                for (int j = 0; j < column; j++)
                    if (table[i][j] == '-')
                        return '-';
        }
        return 'D';
    }

void print(){
    for (int i = 0; i <row ; i++) {
        for (int j = 0; j < column; j++) {
            System.out.print(table[i][j]);
        }
        System.out.println();
    }
}




}
