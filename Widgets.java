/* Widgets.java
 * April 14, 2016
 * NonTerminal Class for Widgets
 */

import java.util.ArrayList;
import javax.swing.*;

public class Widgets extends NonTerminal implements NTRecursive {

    private Widgets widgets; 
    private Widget widget;
    private Layout layout;

    //Set defaults
    Widgets(String type) {
        this.type = type;
        content = type;
        widgets = null;
        widget = null;
    }

    //Creates arraylist by recursively calling each subsequent ntCheck method on branch
    public ArrayList<JComponent> ntCheck() {
        ArrayList<JComponent> JC = new ArrayList<>();

        while (!children.isEmpty()) {
            NonTerminal nt = children.remove();

            if (nt instanceof Widgets) {
                widgets = (Widgets) nt;
                Widget nt_child = (Widget) widgets.children.peek();
                JC.add(nt_child.ntCheck());

              //For widget instead of widgets  
            } else {
                widget = (Widget) nt;                
                if (widget.type.equals("Panel ")) {
                    widget.layout = (Layout) children.remove();
                }
                JC.add(widget.ntCheck());
            }
        }
        return JC;
    }

    @Override
    public String toString() {
        String str = "Widgets";
        return str;
    }
}


