/* Gui.java
 * April 14, 2016
 * NonTerminal Class for Layout
 */
import java.util.regex.*;

public class Layout extends NonTerminal{
  private String i_1;
  private String i_2;
  private String i_3;
  private String i_4;
  
  Layout(String type){
      this.type= type;
      this.content= type;
      i_1= "";
      i_2= "";
      i_3= "";
      i_4= "";
  }
  @Override
  
    public String toString(){
    String str= new String("Layout");
    return str;
  }
  
  @Override
  public void ntCheck(){
    String flow_format= "Layout Flow";
    String grid_format= "Layout.*?Grid.(\\d+)..*?(\\d+)..*?(\\d+)..*?(\\d+)..";

    Pattern pattern = Pattern.compile(grid_format,Pattern.CASE_INSENSITIVE);
    Matcher match_format = pattern.matcher(content);
    if (match_format.find()){
      System.out.println("Yaabadabbadoooo!");
        String i_1= match_format.group(1);
        String i_2= match_format.group(2);
        String i_3= match_format.group(3);
        String i_4= match_format.group(4);
        System.out.print(i_1+" "+i_2+ " "+i_3+ " " + i_4);
    }
  }
}
  
  

