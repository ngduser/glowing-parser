/* Gui.java
 * April 14, 2016
 * NonTerminal Class for GUI
 */
import java.util.regex.*;
import javax.swing.*;
import java.awt.*;
import java.util.Queue;
import java.util.ArrayList;

public class Gui extends NonTerminal{
  private String s_1, i_1, i_2;
  private Widgets widgets, widget;
  Layout layout;
  
  Gui(String type){
    this.type= type;
    content= type;
    s_1= "";
    i_1= "";
    i_2= "";
  }
  
 @Override  
    public String toString(){
    String str= new String("GUI");
    return str;
 }
 

 public void ntCheck(){
    String format="Window.*?\"(.*?)\".*?\\((\\d+),.*?(\\d+)\\).*?."; 

    Pattern pattern= Pattern.compile(format);
    Matcher match_format= pattern.matcher(content);
    if (!match_format.find()){
      System.out.println(type+"ERROR "+ content);
    }
    else{
        s_1= match_format.group(1);
        i_1= match_format.group(2);
        i_2= match_format.group(3);
        System.out.println("1- "+ s_1+ " 2- "+ i_1+ " 3- "+ i_2);
        
       layout= (Layout) children.remove();
       widgets= (Widgets) children.remove();
       widget= (Widgets) children.remove();
    }
   JFrame gui= new JFrame(s_1);
   int width= Integer.parseInt(i_1);
   int height= Integer.parseInt(i_2);
   
   gui.setSize(width, height);
   
   JPanel jpanel= layout.ntCheck();
   
   ArrayList<JComponent> component_list= widgets.ntCheck();
   component_list.addAll(widget.ntCheck());
   
   for (int i= 0; i< component_list.size(); i++){
     JComponent component= component_list.get(i);
     jpanel.add(component);
                
     if (component instanceof JPanel){
       JPanel component_panel= (JPanel) component;
        for (++i; i< component_list.size(); i++){
          component= component_list.get(i);
          component_panel.add(component);
        }
     }
   }
    gui.add(jpanel);
   
   gui.setVisible(true);
   
   
  
  



 }
    
 }



