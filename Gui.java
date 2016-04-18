/* Gui.java
 * April 14, 2016
 * NonTerminal Class for GUI
 */
import java.util.regex.*;

public class Gui extends NonTerminal{
  
  Gui(String type){
    this.type= type;
    this.content= type;
  }
 @Override  
    public String toString(){
    String str= new String("GUI");
    return str;
 }
 
 @Override
 public void testNT(){
    String format=".*?Window.*?((?:[a-z][a-z]+)).*?(\\d+).*?(\\d+)"; 

    Pattern pattern= Pattern.compile(format,Pattern.CASE_INSENSITIVE);
    Matcher match_format= pattern.matcher(content);
    if (match_format.find()){
        String s_1= match_format.group(1);
        String i_1= match_format.group(2);
        String i_2= match_format.group(3);
    }
    else{
      System.out.println("Syntax error with "+ type+ " input!");
    }
    
     NonTerminal non_terminal= children.remove();
     if (!(non_terminal instanceof Layout)){
       System.out.println("NT "+ non_terminal+ " error. Not Layout");
     }
     else if (!(children.peek() instanceof Widgets)){
       System.out.println("NT "+ children.peek()+ " error. Not Widget");
       
     }
     children.add(non_terminal);
 }
    
  
 
 }

