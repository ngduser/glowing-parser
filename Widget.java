/* Gui.java
 * April 14, 2016
 * NonTerminal Class for Widget
 */

public class Widget extends NonTerminal{
   Widget(String type){
     this.type= type;
     this.content= type;
  }
  @Override
  
    public String toString(){
    String str= new String("Widget");
    return str;
  }
}
