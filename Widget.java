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
  @Override
  public void ntCheck(){
    
    String format;
    
    switch(type){
      case "Button ":
        format= "Button.*?((?:[a-z][a-z]+));";
        break;

      case "Group ":
        format= "Group End;";
        break;
        
      case "Label ":
        format= "Label.*?((?:[a-z][a-z]+)).*?;";
        break;
     
      case "Panel ":
        format= "Panel End;";
        break;
        
      case "Textfield ":
        format= "Textfield.*?(\\d+);";
        break;
        
      default:
        throw new IllegalArgumentException("Invalid Widget");
    }
    
    System.out.println(format);
        
 /*       Pattern pattern= Pattern.compile(format);
    Matcher match_format= pattern.matcher(content);
    if (match_format.find()){
        s_1= match_format.group(1);
  */
  }
}
