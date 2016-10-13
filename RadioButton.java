/* RadioButton.java
 * April 14, 2016
 * NonTerminal Class for Radio Button
 */

import java.util.regex.*;
import java.util.regex.PatternSyntaxException;

public class RadioButton extends NonTerminal {
    private String s_1;
    
    //Constructor sets defaults
    RadioButton(String type) {
        this.type = type;
        this.content = type;
        s_1 = "";
    }
    //Custom toString
    @Override
    public String toString() {
        String str = "Radio Button";
        return str;
    }

    //Verifies input
    public void ntCheck() {
        String format = "Radio.*?((?:[a-z][a-z]+));";

        Pattern pattern = Pattern.compile(format);
        Matcher match_format = pattern.matcher(content);
        if (!match_format.find()) {
            throw new PatternSyntaxException("Syntax Error", "A", 1);
        } else {
            s_1 = match_format.group(1);
        }
    }
}
