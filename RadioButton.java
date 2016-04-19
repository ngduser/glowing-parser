/* Gui.java
 * April 14, 2016
 * NonTerminal Class for Radio Button
 */
import java.util.regex.*;

public class RadioButton extends NonTerminal{
  private String s_1;
  
  RadioButton(String type){
    this.type= type;
    this.content= type;
    s_1="";
  }
  
  @Override
    public String toString(){
    String str= new String("Radio Button");
    return str;
  }
  
  @Override
  public void ntCheck(){
    String format="Radio.*?((?:[a-z][a-z]+));"; 

    Pattern pattern= Pattern.compile(format);
    Matcher match_format= pattern.matcher(content);
    if (!match_format.find()){
      System.out.println("Error!");
    }
    else{
        s_1= match_format.group(1);
    }
  }
}
