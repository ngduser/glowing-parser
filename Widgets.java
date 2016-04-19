/* Gui.java
 * April 14, 2016
 * NonTerminal Class for Widgets
 */

public class Widgets extends NonTerminal implements NTRecursive{
  
 // Widget widget= new Widget();
  Widgets widgets;
  Widget widget;
  
  Widgets(String type){
    this.type= type;
    content= type;
    widgets= null;
    widget=null;
  }
  
  @Override  
    public String toString(){
    String str= new String("Widgets");
    return str;
  }
  @Override
  public void ntCheck(){
   NonTerminal child= children.peek();
   //System.out.println(child.type);
   child.ntCheck();
  }
}
