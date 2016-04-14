
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
  
  Parser()throws FileNotFoundException{
    keys= new KeyList(); 
    nt_stack= new Stack<>();
    nt_queue= new LinkedList();
    File file= chooseFile();
    Scanner scan_file= new Scanner(file);
    scanFile(scan_file);
    testQueue();
  }
  
  public void testQueue(){
    NonTerminal non_terminal=null;
    while (!nt_queue.isEmpty()){
      non_terminal= nt_queue.remove();
      System.out.println(non_terminal+ " has- "+ non_terminal.content);
    }
    
    
  }
 
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
  
   public void scanFile(Scanner scan_file){
      while(scan_file.hasNext()){
        String next= scan_file.next();
        
        if (!nt_stack.isEmpty()){
          NonTerminal non_terminal= nt_stack.peek();
          non_terminal.content= non_terminal.content+ next+ " ";
          
          if (keys.start_keys.contains(next)){
            NonTerminal nt_child= createNT(next);
            non_terminal.children.add(nt_child);
            nt_stack.push(nt_child);
          }
          else{
            char[] c_next= next.toCharArray();
            for (int i= 0; i< c_next.length; i++){
              if (keys.end_keys.contains(c_next[i])){
                non_terminal= nt_stack.pop();
                System.out.println("Closing " + non_terminal + " with "+ c_next[i]);
                if (!nt_stack.isEmpty()){
                  NonTerminal nt_parent= nt_stack.peek();
                  nt_parent.children.add(non_terminal);
                }
              
                nt_queue.add(non_terminal);
              }
            }
          }
        }
        
        else if (keys.start_keys.contains(next)){
            NonTerminal nt_child= createNT(next);
            nt_stack.push(nt_child);
          }
      }
   }
   //Creates and returns NonTerminal object from token
   private NonTerminal createNT(String next){
     Tokens token= Tokens.getName(next);
     token.setType();
     
     System.out.println("Opening "+ token.terminal_type+ " with "+ next);
     return token.terminal_type;
   
   }
  
}