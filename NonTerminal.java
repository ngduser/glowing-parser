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
  List<String> string_list= new ArrayList<>();

}