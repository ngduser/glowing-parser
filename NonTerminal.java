/* Calculator.java
 * April 7, 2016
 * Abstract class for language nonterminals
 */ 

import java.util.LinkedList;
import java.util.Queue;
import java.util.List;
import java.util.ArrayList;


public abstract class NonTerminal{
  Queue children= new LinkedList();
  ArrayList<String> string_list;
  String type, content;
  NonTerminal nt_parent=null;
  int value;
  
  NonTerminal(){
 
    string_list= new ArrayList();
    value= (int) (Math.random()*100);
  }
  
  public void getChildren(){
    while (!children.isEmpty()){
      System.out.print(" "+ children.remove());
    }
  }
}