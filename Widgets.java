/* Gui.java
 * April 14, 2016
 * NonTerminal Class for Widgets
 */
import java.util.Queue;
import java.util.ArrayList;
import javax.swing.*;


public class Widgets extends NonTerminal implements NTRecursive{
  
 // Widget widget= new Widget();
  Widgets widgets;
  Widget widget;
  Layout layout;
  
  Widgets(String type){
    this.type= type;
    content= type;
    widgets= null;
    widget=null;
  }
  
  public ArrayList<JComponent> ntCheck(){
    ArrayList<JComponent> JC= new ArrayList<>();
    
     while(!children.isEmpty()){
       NonTerminal nt= children.remove();
       
       if (nt instanceof Widgets){
         widgets= (Widgets) nt;
         Widget nt_child= (Widget) widgets.children.peek();
         JC.add(nt_child.ntCheck());
         
       }
       else{
         widget= (Widget) nt;
         System.out.println("NT_ " + nt.type);
         if (widget.type.equals("Panel ")){
           widget.layout= (Layout) children.remove();
           System.out.println("NTerwerwerwerwerwe");
         }
         JC.add(widget.ntCheck());
       }
       
       
       
       
   /* widget= (Widget) children.remove();
    System.out.println("Removed " + widget.type);
    
    
    if (!children.isEmpty()){
      System.out.println("Another widget removerdsdsd");
      layout= (Layout) children.remove();
    }

    while(!children.isEmpty()){
      System.out.println("Another widget remover");
      widget= (Widget) children.remove();
    }
    */
  
    
  
     }
     return JC;
  }
  @Override  
    public String toString(){
    String str= new String("Widgets");
    return str;
  }
 
 // public Object ntCheck(){
  // Widget child= (Widget) children.peek();
   //child.ntCheck();
   //return 1;
   //}
  
  }

