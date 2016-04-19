/* Gui.java
 * April 14, 2016
 * NonTerminal Class for Widget
 */
import java.util.regex.*;
import javax.swing.*;
import java.awt.*;

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
    Matcher match_format= null;
    
    String format;
    
    switch(type){
      case "Button ":
        format= "Button.*?(\".*?\");";
        match_format= matchPattern(format);
        s_1= match_format.group(1);
   
        break;

      case "Group ":
        format= "Group End;";
        matchPattern(format);
        break;
        
      case "Label ":
        format= "Label.*?(\".*?\").*?;";
        match_format= matchPattern(format);
        s_1= match_format.group(1);       
        break;
     
      case "Panel ":
        format= "Panel End;";
        matchPattern(format);
        break;
        
      case "Textfield ":
        format= "Textfield.*?(\\d+);";
        match_format= matchPattern(format);
        s_1= match_format.group(1);
        break;
        
      default:
        throw new IllegalArgumentException("Invalid Widget");
    }
    
    System.out.println(format);
  }
  
  private Matcher matchPattern(String format){
        
    Pattern pattern= Pattern.compile(format);
    Matcher match_format= pattern.matcher(content);
    if (!match_format.find()){
       System.out.println(type+ "- ERROR!!!");
    }
    return match_format;
  }
  
  public JComponent build(){
    JComponent jc_widget=null;
    Matcher match_format= null;
    
    String format;
    
    switch(type){
      case "Button ":
        format= "Button.*?(\".*?\");";
        match_format= matchPattern(format);
        s_1= match_format.group(1);
        
        jc_widget= new JButton(s_1);
   
        break;

      case "Group ":
        format= "Group End;";
        matchPattern(format);
        break;
        
      case "Label ":
        format= "Label.*?(\".*?\").*?;";
        match_format= matchPattern(format);
        s_1= match_format.group(1); 
        
        jc_widget= new JLabel(s_1);
        
        break;
     
      case "Panel ":
        format= "Panel End;";
        matchPattern(format);
        
        Layout layout= (Layout) children.remove();
        jc_widget= layout.build();
        
        System.out.println(children.remove().type+ "JJJJJJJJJJJJJJJJJJ");
        
        /////////////////////////////////////////////////////////////////////
        break;
        
      case "Textfield ":
        format= "Textfield.*?(\\d+);";
        match_format= matchPattern(format);
        s_1= match_format.group(1);
        int width= Integer.parseInt(s_1);
        
        jc_widget= new JTextField(width);
        
        break;
        
      default:
        //jc_widget= null;
        throw new IllegalArgumentException("Invalid Widget");
    }

    
    System.out.println(format);
        return jc_widget;
  }
}

