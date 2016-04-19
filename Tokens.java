import java.util.Map;
import java.util.HashMap;

public enum Tokens{

    Window("Window"){
      public void setType(){
        this.terminal_type= new Gui("Window ");
      }
    },
    Layout("Layout"){
      public void setType(){
        this.terminal_type= new Layout("Layout ");
      }
    },
    Button("Button"){
      public void setType(){
       this.terminal_type= new Widgets("Widgets ");
       this.child= new Widget("Button ");
       this.terminal_type.children.add(child);
      }
    },
    Group("Group"){
      public void setType(){
        this.terminal_type= new Widgets("Widgets ");
        this.child= new Widget("Group ");
        this.terminal_type.children.add(child);
      }
    },
    Label("Label"){
      public void setType(){
        this.terminal_type= new Widgets("Widgets ");
        this.child= new Widget("Label ");
        this.terminal_type.children.add(child);
     //   this.terminal_type.widget= child;
      }
    },
    Panel("Panel"){
      public void setType(){
        this.terminal_type= new Widgets("Widgets ");
        this.child= new Widget("Panel ");
        this.terminal_type.children.add(child);
      }
    },
    Textfield("Textfield"){
      public void setType(){
        this.terminal_type= new Widgets("Widgets ");
        this.child= new Widget("Textfield ");
        this.terminal_type.children.add(child);
      }
    },
    Radio("Radio"){
      public void setType(){
        this.terminal_type= new RadioButton("Radio ");
      }
    };
    NonTerminal terminal_type, child;
    public abstract void setType();
    
    private final String token_type;
    static Map<String, Tokens> map = new HashMap<>();
    
    private Tokens(String token_type){
      this.token_type= token_type;
    }
    
    static {
       for (Tokens token: Tokens.values()) {
          map.put(token.token_type, token);
       }
    }
    public static Tokens getName(String name) {
       return map.get(name);
    }
 }
