/* Gui.java
 * April 14, 2016
 * NonTerminal Class for Widget
 */
import java.util.regex.*;

public class Widget extends NonTerminal{
  private String s_1;
   Widget(String type){
     this.type= type;
     content= type;
  }
  @Override
    public String toString(){
    String str= new String("Widget");
    return str;
  }
  @Override
  public void ntCheck(){
    
    String format;
    
    switch(type){
      case "Button ":
        format= "Button.*?(\".*?\");";
        break;

      case "Group ":
        format= "Group End;";
        break;
        
      case "Label ":
        format= "Label.*?(\".*?\").*?;";
        break;
     
      case "Panel ":
        format= "Panel End;";
        break;
        
      case "Textfield ":
        format= "Textfield.*?(\\d+);";
        break;
        
      default:
        throw new IllegalArgumentException("Invalid Widget");
    }
    
    System.out.println(format);
  }
  
  private void matchPattern(String format, boolean out){
        
    Pattern pattern= Pattern.compile(format);
    Matcher match_format= pattern.matcher(content);
    if (!match_format.find()){
       System.out.println(type+ "- ERROR!!!");
    }
    else{
      s_1= match_format.group(1);
    }
    
  }
  private void matchPattern(String format){
        
    Pattern pattern= Pattern.compile(format);
    Matcher match_format= pattern.matcher(content);
    if (!match_format.find()){
       System.out.println(type+ "- ERROR!!!");
    }

    }
 
  }

