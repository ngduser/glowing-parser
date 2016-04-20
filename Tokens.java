/* Tokens.java
 * April 14, 2016
 * Enumurated class for nonterminal types
 */
import java.util.Map;
import java.util.HashMap;

public enum Tokens {

  //Enum for all the different types for each class  
  Window("Window") {
                @Override
                public void setType() {
                    this.terminal_type = new Gui("Window ");
                }
            },
    Layout("Layout") {
                @Override
                public void setType() {
                    this.terminal_type = new Layout("Layout ");
                }
            },
    
    //Widgets are recursive productions but only signified by a widget, so a widget makes both classes
    //and inserts itself as a child to a Widgets parent
    Button("Button") {
                @Override
                public void setType() {
                    this.terminal_type = new Widgets("Widgets ");
                    this.child = new Widget("Button ");
                    this.terminal_type.children.add(child);
                }
            },
    Group("Group") {
                @Override
                public void setType() {
                    this.terminal_type = new Widgets("Widgets ");
                    this.child = new Widget("Group ");
                    this.terminal_type.children.add(child);
                }
            },
    Label("Label") {
                @Override
                public void setType() {
                    this.terminal_type = new Widgets("Widgets ");
                    this.child = new Widget("Label ");
                    this.terminal_type.children.add(child);
                }
            },
    Panel("Panel") {
                @Override
                public void setType() {
                    this.terminal_type = new Widgets("Widgets ");
                    this.child = new Widget("Panel ");
                    this.terminal_type.children.add(child);
                }
            },
    Textfield("Textfield") {
                @Override
                public void setType() {
                    this.terminal_type = new Widgets("Widgets ");
                    this.child = new Widget("Textfield ");
                    this.terminal_type.children.add(child);
                }
            },
    Radio("Radio") {
                @Override
                public void setType() {
                    this.terminal_type = new RadioButton("Radio ");
                }
            };
    //Shared fields
    NonTerminal terminal_type, child;
    
    //Public method called by parser.java
    public abstract void setType();

    private final String token_type;
    static Map<String, Tokens> map = new HashMap<>();

    //Default constructor for each ewnum
    private Tokens(String token_type) {
        this.token_type = token_type;
    }
    static {
        for (Tokens token : Tokens.values()) {
            map.put(token.token_type, token);
        }
    }
     public static Tokens getName(String name) {
        return map.get(name);
    }
}
