
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
    Queue<NonTerminal> nt_queue= new LinkedList<>();
    File file= chooseFile();
    Scanner scan_file= new Scanner(file);
    scanFile(scan_file);

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
        
        if (keys.start_keys.contains(next)){
          NonTerminal non_terminal= createNT(next);
          if (!nt_stack.isEmpty()){
            NonTerminal nt_parent= nt_stack.peek();
            nt_parent.children.add(non_terminal);
          }
          nt_stack.push(non_terminal);
        }
        
        
        
        else{
          NonTerminal nt_parent= nt_stack.peek();
          nt_parent.string_list.add(next);
          char[] c_next= next.toCharArray();
          for (int i= 0; i< c_next.length; i++){
            if (keys.end_keys.contains(c_next[i])){
              NonTerminal non_terminal= nt_stack.pop();
              nt_queue.add(non_terminal);
            }
          }
        }
      }
    }
   
   private NonTerminal createNT(String next){
   
  //   if (next.isEqualTo(
     return null;
   
   }
  
}