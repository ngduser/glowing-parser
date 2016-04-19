/* Gui.java
 * April 14, 2016
 * NonTerminal Class for GUI
 */
import java.util.regex.*;

public class Gui extends NonTerminal{
  private String s_1, i_1, i_2;
  private NonTerminal layout, widgets;
  
  Gui(String type){
    this.type= type;
    content= type;
    s_1= "";
    i_1= "";
    i_2= "";
  }
  
 @Override  
    public String toString(){
    String str= new String("GUI");
    return str;
 }
 
 @Override
 public void ntCheck(){
    String format="Window.*?(\".*?\").*?\\((\\d+),.*?(\\d+)\\).*?End\\."; 

    Pattern pattern= Pattern.compile(format);
    Matcher match_format= pattern.matcher(content);
    if (!match_format.find()){
      System.out.println(type+"ERROR");
    }
    else{
        s_1= match_format.group(1);
        i_1= match_format.group(2);
        i_2= match_format.group(3);
        
        layout= children.remove();
        widgets= children.remove();
    
    }
 }
 }

