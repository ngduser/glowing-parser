/* Gui.java
 * April 14, 2016
 * NonTerminal Class for GUI
 */

import java.util.regex.*;
import javax.swing.*;
import java.util.regex.PatternSyntaxException;

import java.util.ArrayList;

public class Gui extends NonTerminal {
    private String s_1, i_1, i_2;
    private Widgets widgets, widget;
    Layout layout;

    //Default values
    Gui(String type) {
        this.type = type;
        content = type;
        s_1 = "";
        i_1 = "";
        i_2 = "";
    }
    //Custom string 
    @Override
    public String toString() {
        String str = "GUI";
        return str;
    }

    //Data validation and extraction
    public void ntCheck() {
        String format = "Window.*?\"(.*?)\".*?\\((\\d+),.*?(\\d+)\\).*?.";

        Pattern pattern = Pattern.compile(format);
        Matcher match_format = pattern.matcher(content);
        if (!match_format.find()) {
            throw new PatternSyntaxException("Syntax Error", "A", 1);
        } else {
            s_1 = match_format.group(1);
            i_1 = match_format.group(2);
            i_2 = match_format.group(3);

            layout = (Layout) children.remove();
            widgets = (Widgets) children.remove();
            widget = (Widgets) children.remove();
        }
        
        //Constructs gui object with language
        JFrame gui = new JFrame(s_1);
        int width = Integer.parseInt(i_1);
        int height = Integer.parseInt(i_2);

        gui.setSize(width, height);

        //First Jpanel
        JPanel jpanel = layout.ntCheck();
        ArrayList<JComponent> component_list = widgets.ntCheck();
        component_list.addAll(widget.ntCheck());

        //Adds child components to gui object
        for (int i = 0; i < component_list.size(); i++) {
            JComponent component = component_list.get(i);
            jpanel.add(component);

            //Nested JPanel patch to handle recursive bug
            //If more than 2 jpanels are needed it can be nested further
            if (component instanceof JPanel) {
                JPanel component_panel = (JPanel) component;
                for (++i; i < component_list.size(); i++) {
                    component = component_list.get(i);
                    component_panel.add(component);
                }
            }
        }
        //Final display
        gui.add(jpanel);
        gui.setVisible(true);
    }

}



