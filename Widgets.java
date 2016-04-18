/* Gui.java
 * April 14, 2016
 * NonTerminal Class for Widgets
 */

public class Widgets extends NonTerminal implements NTRecursive{
  
 // Widget widget= new Widget();
  Widgets widgets= null;
  
  Widgets(String type){
    this.type= type;
    this.content= type;
  }
  
  @Override  
    public String toString(){
    String str= new String("Widgets");
    return str;
  }
}
