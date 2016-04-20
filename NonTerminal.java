/* NonTerminal.java
 * April 7, 2016
 * Abstract class for language nonterminals
 */

import java.util.LinkedList;
import java.util.Queue;

public abstract class NonTerminal {
 
    //Bare minimum superclass used for polymorphism
    Queue<NonTerminal> children = new LinkedList<>();

    String type, content;
    NonTerminal nt_parent = null;
}