/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazeoutlab;

/**
 *
 * @author tybik
 */
public class MazeOutlab {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //creates maze as 2-d char array
        char[][] maze={      
            {'#','#','#','#','#','#','#','#','#','#','#','#'},
            {'#','.','.','.','#','.','.','.','.','.','.','#'},
            {'.','.','#','.','#','.','#','#','#','#','.','#'},
            {'#','#','#','.','#','.','.','.','.','#','.','#'},
            {'#','.','.','.','.','#','#','#','.','#','.','#'},
            {'#','#','#','#','.','#','F','#','.','#','.','#'},
            {'#','.','.','#','.','#','.','#','.','#','.','#'},
            {'#','#','.','#','.','#','.','#','.','#','.','#'},
            {'#','.','.','.','.','.','.','.','.','#','.','#'},
            {'#','#','#','#','#','#','.','#','#','#','.','#'},
            {'#','.','.','.','.','.','.','#','.','.','.','#'},
            {'#','#','#','#','#','#','#','#','#','#','#','#'}
        };
        //runs maze
        solveMaze(maze,0,2,0,3);   
    }
    public static boolean solveMaze(char[][] mazeArray,int xLoc,int yLoc,int xHand,int yHand){
        boolean done=(mazeArray[yLoc][xLoc]=='F');
        mazeArray[yLoc][xLoc]='O';
        //prints the maze
        for(int i=0;i<12;i++){
            for(int j=0;j<12;j++)
                System.out.print(mazeArray[i][j]+" ");
            System.out.println();
        }
        System.out.println();
        mazeArray[yLoc][xLoc]='X';
        if(done) return true;
        //ends program if done
//        if(yHand==-1)
//            return solveMaze(mazeArray,xLoc,yLoc,xHand+1,0);
//        if(xHand==-1)
//            return solveMaze(mazeArray,xLoc,yLoc,0,yHand-1);
        int direction;
        //calculates direction facing
        if(xHand<xLoc) direction=2;        
        else if(xHand>xLoc) direction=0;
        else if(yHand<yLoc) direction=3;
        else direction=1;
        //if facing north
        if(direction==0){   
            if(mazeArray[yLoc][xLoc+1]=='.'||mazeArray[yLoc][xLoc+1]=='F')
                return solveMaze(mazeArray,xLoc+1,yLoc,xLoc+1,yLoc+1);
            if(mazeArray[yLoc-1][xLoc]=='.'||mazeArray[yLoc-1][xLoc]=='F')
                return solveMaze(mazeArray,xLoc,yLoc-1,xLoc+1,yLoc-1);
            if(mazeArray[yLoc][xLoc+1]=='X')       
                return solveMaze(mazeArray,xLoc+1,yLoc,xLoc+1,yLoc+1);
            if(mazeArray[yLoc-1][xLoc]=='X')
                return solveMaze(mazeArray,xLoc,yLoc-1,xLoc+1,yLoc-1);
            return solveMaze(mazeArray,xLoc,yLoc,xLoc,yLoc-1);
        }
        //if facing east
        if(direction==1){      
            if(mazeArray[yLoc+1][xLoc]=='.'||mazeArray[yLoc+1][xLoc]=='F')
                return solveMaze(mazeArray,xLoc,yLoc+1,xLoc-1,yLoc);
            if(mazeArray[yLoc][xLoc+1]=='.'||mazeArray[yLoc][xLoc+1]=='F')
                return solveMaze(mazeArray,xLoc+1,yLoc,xLoc+1,yLoc+1);
            if(mazeArray[yLoc+1][xLoc]=='X')
                return solveMaze(mazeArray,xLoc,yLoc+1,xLoc-1,yLoc);
            if(mazeArray[yLoc][xLoc+1]=='X')
                return solveMaze(mazeArray,xLoc+1,yLoc,xLoc+1,yLoc+1);
            return solveMaze(mazeArray,xLoc,yLoc,xLoc+1,yLoc);
        }
        //if facing south
        if(direction==2){      
            if(mazeArray[yLoc][xLoc-1]=='.'||mazeArray[yLoc][xLoc-1]=='F')
                return solveMaze(mazeArray,xLoc-1,yLoc,xLoc-1,yLoc-1);
            if(mazeArray[yLoc+1][xLoc]=='.'||mazeArray[yLoc+1][xLoc]=='F')
                return solveMaze(mazeArray,xLoc,yLoc+1,xLoc-1,yLoc+1);
            if(mazeArray[yLoc][xLoc-1]=='X')
                return solveMaze(mazeArray,xLoc-1,yLoc,xLoc-1,yLoc-1);
            if(mazeArray[yLoc+1][xLoc]=='X')
                return solveMaze(mazeArray,xLoc,yLoc+1,xLoc-1,yLoc+1);
            return solveMaze(mazeArray,xLoc,yLoc,xLoc,yLoc+1);
        }
        //if facing west
        if(direction==3){            
            if(mazeArray[yLoc-1][xLoc]=='.'||mazeArray[yLoc-1][xLoc]=='F')
                return solveMaze(mazeArray,xLoc,yLoc-1,xLoc+1,yLoc-1);
            if(mazeArray[yLoc][xLoc-1]=='.'||mazeArray[yLoc][xLoc-1]=='F')
                return solveMaze(mazeArray,xLoc-1,yLoc,xLoc-1,yLoc-1);
            if(mazeArray[yLoc-1][xLoc]=='X')
                return solveMaze(mazeArray,xLoc,yLoc-1,xLoc+1,yLoc-1);
            if(mazeArray[yLoc][xLoc-1]=='X')
                return solveMaze(mazeArray,xLoc-1,yLoc,xLoc-1,yLoc-1);
            return solveMaze(mazeArray,xLoc,yLoc,xLoc-1,yLoc);
        }
        return false;
        }
    }
