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
  String content="";
  NonTerminal nt_parent=null;
  
  NonTerminal(){
    string_list= new ArrayList();
  }
  
  public String toString(){
    String str= new String("NONTERMINAL");
    return str;
  }
  
  public void getChildren(){
    while (!children.isEmpty()){
      System.out.print(" "+ children.remove());
    }
  }
}