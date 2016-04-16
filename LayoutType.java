/* Gui.java
 * April 14, 2016
 * NonTerminal Class for Layout Type
 */

public class LayoutType extends NonTerminal{
  Layout layout;
  
  LayoutType(String content){
    this.content= content;
  }
  @Override
    public String toString(){
    String str= new String("Layout Type");
    return str;
  }
}
