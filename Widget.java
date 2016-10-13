/* Widget.java
 * April 14, 2016
 * NonTerminal Class for Widget
 */

import java.util.regex.*;
import javax.swing.*;
import java.util.regex.PatternSyntaxException;

public class Widget extends NonTerminal {
    private String s_1;
    public Layout layout;

    Widget(String type) {
        this.type = type;
        content = type;
    }

    //Custom toString
    @Override
    public String toString() {
        String str = "Widget";
        return str;
    }

    //Validates declaration
    private Matcher matchPattern(String format) {
        Pattern pattern = Pattern.compile(format);
        Matcher match_format = pattern.matcher(content);
        if (!match_format.find()) {
            throw new PatternSyntaxException("Syntax Error", "A", 1);
        }
        return match_format;
    }
    //Returns JComponent for Gui creation
    public JComponent ntCheck() {
        //Default values
        JComponent jc_widget = null;
        Matcher match_format = null;

        String format;
        
        //Switch statement for all the different widget types
        switch (type) {
            case "Button ":
                format = "Button.*?\"(.*?)\";";
                match_format = matchPattern(format);
                s_1 = match_format.group(1);

                jc_widget = new JButton(s_1);

                break;

            case "Group ":
                format = "Group End;";
                matchPattern(format);
                break;

            case "Label ":
                format = "Label.*?\"(.*?)\".*?;";
                match_format = matchPattern(format);
                s_1 = match_format.group(1);

                jc_widget = new JLabel(s_1);

                break;

            case "Panel ":
                format = "Panel End;";
                matchPattern(format);
                jc_widget = layout.ntCheck();

                break;

            case "Textfield ":
                format = "Textfield.*?(\\d+);";
                match_format = matchPattern(format);
                s_1 = match_format.group(1);
                int width = Integer.parseInt(s_1);

                jc_widget = new JTextField(width);

                break;

            default:
                throw new IllegalArgumentException("Invalid Widget");
        }
        return jc_widget;
    }
}
