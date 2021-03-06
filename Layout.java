/* Layout.java
 * April 14, 2016
 * NonTerminal Class for Layout
 */

import java.util.regex.*;
import java.awt.*;
import javax.swing.*;
import java.util.regex.PatternSyntaxException;

public class Layout extends NonTerminal {
    private String i_1, i_2, i_3, i_4;

    //Layout with shared values given defaults
    Layout(String type) {
        this.type = type;
        this.content = type;
        i_1 = "";
        i_2 = "";
        i_3 = "";
        i_4 = "";
    }

    //Custom toString
    @Override
    public String toString() {
        String str = "Layout";
        return str;
    }
    
    //Validation based on flow or grid layout type
    public JPanel ntCheck() {
        String flow_format = "Layout Flow: ";
        String grid_format = "Layout.*?Grid.(\\d+)..*?(\\d+)..*?(\\d+)..*?(\\d+)..";

        Pattern pattern = Pattern.compile(grid_format, Pattern.CASE_INSENSITIVE);
        Matcher match_format = pattern.matcher(content);

        JPanel jp = null;
        if (!match_format.find() && !content.equals(flow_format)) {
            throw new PatternSyntaxException("Syntax Error", "A", 1);
        } else if (!content.equals(flow_format)) {
            i_1 = match_format.group(1);
            i_2 = match_format.group(2);
            i_3 = match_format.group(3);
            i_4 = match_format.group(4);
            
            //Inserting values into fields from input
            int rows = Integer.parseInt(i_1);
            int cols = Integer.parseInt(i_2);
            int hor_gap = Integer.parseInt(i_3);
            int ver_gap = Integer.parseInt(i_4);

            jp = new JPanel(new GridLayout(rows, cols, hor_gap, ver_gap));
        } else {
            jp = new JPanel(new FlowLayout());
        }

        return jp;
    }

}
  
  

