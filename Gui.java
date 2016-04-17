/* Gui.java
 * April 14, 2016
 * NonTerminal Class for GUI
 */

public class Gui extends NonTerminal{
  String type;
  Gui(String type){
    this.type= type;
    this.content= type;
  }
  @Override
  public String toString(){
    return type;
  }
  
}
