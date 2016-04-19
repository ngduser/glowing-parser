/* Calculator.java
 * April 7, 2016
 * Abstract class for language nonterminals
 */ 

import java.util.LinkedList;
import java.util.Queue;
import java.util.List;
import java.util.ArrayList;


public abstract class NonTerminal{
  Queue<NonTerminal> children= new LinkedList<>();

  String type, content;
  NonTerminal nt_parent=null;

  
  public void ntCheck(){
    System.out.println("Narn");
  }
  
  public void getChildren(){
    for (NonTerminal child : children){
      System.out.println(type+"a "+child);
    }
  }
}