package Codewars_4kyu;
import java.util.*;

public class Finder {
    
    static int[] tC = {0,0,-1,1};
    static int[] tR = {1,-1,0,0};
  
    static String[] traversable;
    
  
    static boolean pathFinder(String maze) { 
      
      traversable = maze.split("\n");
      int msl = traversable[0].length();
      boolean[][] visited = new boolean[msl][msl];
      Stack<Pair> tt = new Stack<Pair>();
      
      tt.push(new Pair(0,0));
      
      if(traversable[0].charAt(0) == 'W') {
    	  return false;
      }
      if(traversable[msl-1].charAt(msl-1) == 'W') {
    	  return false;
      }
      
      
      
      
      while(!tt.isEmpty()) {
        Pair target = tt.pop();
        if(target.row == msl -1 && target.col == msl-1) return true;
  
        
        if(visited[target.row][target.col]) continue;
        
        
        Integer[] poss = surroundingCells(visited, target.row, target.col);
        if(poss.length == 0) { 
          continue;
        }
        for(int i = 1; i < poss.length; i++) {
          tt.push(new Pair(target.row+tR[poss[i]], target.col+tC[poss[i]]));
        }
        
        
        visited[target.row][target.col] = true;
        
        
        int offset = 1;
        while(true) {
          int tmR = target.row+(tR[poss[0]]*offset);
          int tmC = target.col+(tC[poss[0]]*offset);
        
          
          
          
          
          if(tmR == msl-1 && tmC == msl-1) {
            return true;
          }
          
          Integer[] tempP = surroundingCells(visited, tmR, tmC);
          if(tempP.length == 0) {
            break;
          }
          if(traversable[tmR].charAt(tmC) == 'W') {
        	  break;
          }
          if(tempP.length > 0) {
            for(int j = 0; j < tempP.length; j++) {
            if(tempP[j] != poss[0]) {
            	tt.push(new Pair(tmR+tR[tempP[j]], tmC+tC[tempP[j]]));
            }
              
            }
          }
          visited[tmR][tmC] = true;
          offset++;
        }
        
      }
      
        // Your code here!!
        return false;
    }
  
    private static Integer[] surroundingCells(boolean[][] vv, int row, int col) {
      List<Integer> list = new ArrayList<Integer>();
      for(int i = 0; i < 4; i++) {
        try {
          if(!vv[row+tR[i]][col+tC[i]] && traversable[row+tR[i]].charAt(col+tC[i]) == '.') {
             list.add(i);
          }
          }
        catch(ArrayIndexOutOfBoundsException e) {continue;}
      }
      return list.toArray(new Integer[list.size()]);
    }
  
}


class Pair {
  int row;
  int col;
  Pair(int r, int c) {
    this.row = r;
    this.col = c;
  }
}



