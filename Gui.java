/* Gui.java
 * April 14, 2016
 * NonTerminal Class for GUI
 */

public class Gui extends NonTerminal{
  
  Gui(String type){
    this.type= type;
    this.content= type;
  }
 @Override  
    public String toString(){
    String str= new String("GUI");
    return str;
 }
 
}
