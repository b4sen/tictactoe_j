import java.util.Scanner;
import java.util.Arrays;
class Main {
      public static void main(String[] args) {
        // write your code here
        String[] s1 = {" ", " ", " "};
        String[] s2 = {" ", " ", " "};
        String[] s3 = {" ", " ", " "};
        String[][] arr = {s1, s2, s3};
        boolean isFinished = false;
        boolean isWin = false;
        boolean xTurn = true;
        int steps = 0;
        Scanner scan = new Scanner(System.in);
        
        while(!isFinished){
            if(steps == 9){
                isFinished = true;
                System.out.println("No more steps! Game is finished!");
                break;
            }
            
            System.out.println("Coordinates: ");
            String idx = scan.nextLine();
            String[] temp = idx.split(" ");
            int x = Integer.parseInt(temp[0]);
            int y = Integer.parseInt(temp[1]);
            if(xTurn){
                arr[x][y] = "X";
            }else{
                arr[x][y] = "O";
            }
            
            printField(arr);
            isWin = checkWin(arr); 
            steps++;
            if(isWin){
                isFinished = true;
                String win = xTurn ? "X" : "O";
                System.out.println(win + " wins!");
                break;
            }
            xTurn = !xTurn;
        }
        
    }
    
    private static void printField(String[][] arr){
        System.out.println("-----");
        
        for(int i = 0; i < arr.length; i++){
            System.out.print("|");
            for(int j = 0; j < arr[i].length; j++){
                if(arr[i][j].equalsIgnoreCase("x")){
                    System.out.print("X");
                }else if(arr[i][j].equalsIgnoreCase("o")){
                    System.out.print("O");
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println("|");
        }
        
        System.out.println("-----");
    }

    private static boolean checkWin(String[][] arr){
      String[] tempArr = new String[3];
      for(int i = 0; i < arr.length; i++){
        // Horizontal check
        final String firstChar = arr[i][0];
        if(!firstChar.equals(" ")){
          boolean all = Arrays.stream(arr[i]).allMatch(s -> s.equals(firstChar));
          if(all){
            return true;
          }
        }
        // vertical check
        
        for(int j = 0; j < 3; j++){
          tempArr[j] = arr[j][i];
        }
        if(!tempArr[0].equals(" ")){
          boolean all = Arrays.stream(tempArr).allMatch(s -> s.equals(tempArr[0]));
          if(all){
            return true;
          }
        }

      }

      for(int i = 0; i < 3; i++){
        tempArr[i] = arr[i][i];
      }
      if(!tempArr[0].equals(" ")){
        boolean all = Arrays.stream(tempArr).allMatch(s -> s.equals(tempArr[0]));
        if(all){
          return true;
        }

      }
      
      for(int i = 0; i < 3; i++){
        tempArr[i] = arr[2-i][i];
      }
      if(!tempArr[0].equals(" ")){
        boolean all = Arrays.stream(tempArr).allMatch(s -> s.equals(tempArr[0]));
        if(all){
          return true;
        }
      
      }
      
      return false;
    }
}
