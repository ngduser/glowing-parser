/* Gui.java
 * April 14, 2016
 * NonTerminal Class for Layout Type
 */

public class LayoutType extends NonTerminal{
  Layout layout;
  
  LayoutType(String type){
    this.type= type;
    this.content= type;
  }
  @Override
    public String toString(){
    String str= new String("Layout Type");
    return str;
  }
}
