/* Gui.java
 * April 14, 2016
 * NonTerminal Class for Radio Button
 */

public class RadioButton extends NonTerminal{
  RadioButton(String type){
    this.type= type;
    this.content= type;
  }
  
  @Override
  
    public String toString(){
    String str= new String("Radio Button");
    return str;
  }
}
