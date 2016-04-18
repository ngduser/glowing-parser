/* Gui.java
 * April 7, 2016
 * Parser class takes data file and tokenizes it creating Parse Tree of Non-Terminals
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.NullPointerException;
import java.util.Scanner;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

class Parser{
  KeyList keys;
  Stack<NonTerminal> nt_stack;
  Queue<NonTerminal> nt_queue;
  
  Queue<NonTerminal> test_queue;
  
  Parser()throws FileNotFoundException{
    keys= new KeyList(); 
    nt_stack= new Stack<>();
    nt_queue= new LinkedList();
    test_queue= new LinkedList();
    
    File file= chooseFile();
    Scanner scan_file= new Scanner(file);
    scanFile(scan_file);
    testQueue();
  }
  
  //Test method to output structure
  public void testQueue(){
    NonTerminal non_terminal=null;
    while (!test_queue.isEmpty()){
      non_terminal= test_queue.remove();
      System.out.println(non_terminal+ "-"+ non_terminal.value+ " Content- "+ non_terminal.content);
      non_terminal.getChildren();
    }
  }
 
  //Data file selection
  public File chooseFile(){
    JFrame frame= new JFrame();
    JFileChooser chooser= new JFileChooser(".");
    chooser.setDialogTitle("Open Data File");
    
    if (chooser.showOpenDialog(frame)== JFileChooser.APPROVE_OPTION){
      chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
      File file= chooser.getSelectedFile();
      return file;
    }
    else{
      return null;
    }
  }
  
   //Parses data file and builds tree
   public void scanFile(Scanner scan_file){
      while(scan_file.hasNext()){
        String next= scan_file.next();
       
          if (keys.start_keys.contains(next)){
            NonTerminal nt_child= createNT(next);
          if (!nt_stack.isEmpty()){
             NonTerminal non_terminal= nt_stack.peek();
             non_terminal.content= non_terminal.content+ next+ " ";
           }
           nt_stack.push(nt_child);
           test_queue.add(nt_child);
     
          }
          
          else{
             NonTerminal non_terminal= nt_stack.peek();
             if (non_terminal instanceof NTRecursive){
               NonTerminal child= non_terminal.children.peek();
               child.content= child.content+ next+ " ";
             }
             else{
               non_terminal.content= non_terminal.content+ next+ " ";
             }
             
            char[] c_next= next.toCharArray();
            for (int i= 0; i< c_next.length; i++){
              if (keys.end_keys.contains(c_next[i])){
                
                if (non_terminal instanceof NTRecursive){
                    nt_queue.add(non_terminal.children.peek());
                    non_terminal= nt_stack.pop();
                }
             //   }
                else{
                  non_terminal= nt_stack.pop();
                }
          //      System.out.println("Closing " + non_terminal + non_terminal.value+"  "+ non_terminal.type+ " with "+ c_next[i]);
                if (!nt_stack.isEmpty()){
                 NonTerminal parent= nt_stack.peek();
                parent.children.add(non_terminal);
                
             }
              
         //       nt_queue.add(non_terminal);
              
              }
            }
          }
      }
   }
   //Creates and returns NonTerminal object from token
   private NonTerminal createNT(String next){
     Tokens token= Tokens.getName(next);
     token.setType();

     return token.terminal_type;
   }  
}