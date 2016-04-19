/* Gui.java
 * April 14, 2016
 * NonTerminal Class for Layout
 */
import java.util.regex.*;

public class Layout extends NonTerminal{
    Layout(String type){
      this.type= type;
      this.content= type;
  }
  @Override
  
    public String toString(){
    String str= new String("Layout");
    return str;
  }
  
  @Override
  public void ntCheck(){
    String flow_format= "Layout Flow";
    String grid_format= "(Layout.*?Grid.)(\\d+)(..*?)(\\d+)(..*?)(\\d+)(..*?)(\\d+)(..)";

    Pattern pattern = Pattern.compile(grid_format,Pattern.CASE_INSENSITIVE);
    Matcher match_format = pattern.matcher(content);
    if (match_format.find()){
      System.out.println("Yaabadabbadoooo!");
        String i_1= match_format.group(2);
        String i_2= match_format.group(4);
        String i_3= match_format.group(6);
        String i_4= match_format.group(8);
        System.out.print(i_1+" "+i_2+ " "+i_3+ " " + i_4);
    }
  }
}
  
  

