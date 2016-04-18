/* Gui.java
 * April 14, 2016
 * NonTerminal Class for RadioButtons
 */

public class RadioButtons extends NonTerminal{
   RadioButtons(String type){
     this.type= type;
     this.content= type;
  }
  @Override
  
    public String toString(){
    String str= new String("Radio Buttons");
    return str;
  }
}
