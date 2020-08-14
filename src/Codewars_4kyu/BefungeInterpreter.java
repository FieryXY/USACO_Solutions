package Codewars_4kyu;
import java.util.*;

public class BefungeInterpreter {
  
  //left, right, up, down
  int[] ro  = {0,0,-1,1};
  int[] co = {-1,1,0,0};
  
  
  private int row = 0;
  private int column = 0;
  private int direction = 1;
  
  private String[] parsed;
  private Stack<Integer> stck = new Stack<Integer>();
  
  
    public String interpret(String code) {
        return "";
    }
  
    private void operator() {
      char op = parsed[row].charAt(column);
      if(op >= '0' && op <= '9') {
        stck.push(Integer.valueOf(String.valueOf(op)));
      }
      else if(op == '+') {
        stck.push(stck.pop() + stck.pop());
      }
      else if(op == '-') {
        int a = stck.pop();
        int b = stck.pop();
        stck.push(b-a);
      }
      else if(op == '*') {
        stck.push(stck.pop()*stck.pop());
      }
      else if(op == '/') {
        int a = stck.pop();
        int b = stck.pop();
        stck.push(b/a);
      }
      else if(op == '%') {
        int a = stck.pop();
        int b = stck.pop();
        stck.push(b%a);
      }
      else if(op == '!') {
        int a = stck.pop();
        if(a == 0) stck.push(1);
        else stck.push(0);
      }
      else if(op == '`') {
        int a = stck.pop();
        int b = stck.pop();
        stck.push((b>a)?1:0);
      }
      else if(op == '>') {
        direction = 1;
      }
      else if(op == '<') {
        direction = 0;
      }
      else if(op == '^') {
        direction = 2;
      }
      else if(op == 'v') {
        direction = 3;
      }
      else if(op == '?') {
        Random r = new Random();
        direction = r.nextInt(4);
      }
      else if(op == '_') {
        
      }
    }
    
    private void update() {
      row += ro[direction];
      column += co[direction];
      if(row >= parsed.length) {
        row = parsed.length - row;
      }
      if(column >= parsed[row].length()) {
        column = parsed.length - column;
      }
    }

}