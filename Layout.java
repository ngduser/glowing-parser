/* Gui.java
 * April 14, 2016
 * NonTerminal Class for Layout
 */

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
}
