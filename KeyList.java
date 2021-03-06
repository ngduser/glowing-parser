/* KeyList.java
 * April 7, 2016
 * Class which generates key list for language nonterminal indicators
 */

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

final class KeyList {

    List<String> start_keys;
    List<Character> end_keys;

    //Create keys for the tokens which indicate the start and stop of a non-terminal
    KeyList() {
        String start = "Window,Layout,Button,Group,Label,Panel,Textfield,Radio";
        String start_split[] = start.split(",");
        start_keys = new ArrayList<>(Arrays.asList(start.split(",")));

        String end = ":.;";
        char[] char_end = end.toCharArray();
        end_keys = new ArrayList<>();
        for (char c : char_end) {
            end_keys.add(c);
        }
    }
}