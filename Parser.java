/* Parser.java
 * April 7, 2016
 * Parser class takes data file and tokenizes it creating Parse Tree of Non-Terminals
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

class Parser {
    final KeyList keys;
    private Stack<NonTerminal> nt_stack;
    private Gui gui;

    Parser() throws FileNotFoundException {
        keys = new KeyList();
        nt_stack = new Stack<>();

        File file = chooseFile();
        Scanner scan_file = new Scanner(file);
        scanFile(scan_file);
        gui.ntCheck();  
    }

    //Data file selection from user
    public File chooseFile() {
        JFrame frame = new JFrame();
        JFileChooser chooser = new JFileChooser(".");
        chooser.setDialogTitle("Open Data File");

        if (chooser.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION) {
            chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            File file = chooser.getSelectedFile();
            return file;
        } else {
            return null;
        }
    }
    //Parses data file for tokens signiyfing nonterminals and builds parse tree
    public void scanFile(Scanner scan_file) {
        while (scan_file.hasNext()) {
            String next = scan_file.next();

            //Condition signifing nonterminal
            if (keys.start_keys.contains(next)) {
              
                //Creates NT object using token enum  
                NonTerminal nt_child = createNT(next);
                
                //Anchor for Gui parent
                if (nt_child instanceof Gui){
                  gui= (Gui) nt_child;
                }
                nt_stack.push(nt_child);

            //If not nonterminal signifier, lexeme is added to previous NT
            } else {
                NonTerminal non_terminal = nt_stack.peek();
                
                //Special case for recursive productions
                if (non_terminal instanceof NTRecursive) {
                    non_terminal = non_terminal.children.peek();
                }
                non_terminal.content = non_terminal.content + next + " ";
                char[] c_next = next.toCharArray();
                
                //Inspects character stream for terminating character
                for (int i = 0; i < c_next.length; i++) {
                    if (keys.end_keys.contains(c_next[i])) {

                      //Special case for JPanel  
                      if (non_terminal instanceof NTRecursive && !(non_terminal.type.equals("Panel "))) {                     
                            non_terminal = nt_stack.pop();
                        } else {

                            non_terminal = nt_stack.pop();
                        }
                        if (!nt_stack.isEmpty()) {
                            NonTerminal parent = nt_stack.peek();
                            parent.children.add(non_terminal);
                        }
                    }
                }
            }
        }
    }

    //Creates and returns NonTerminal object from token
    private NonTerminal createNT(String next) {
        Tokens token = Tokens.getName(next);
        token.setType();

        return token.terminal_type;
    }
}




