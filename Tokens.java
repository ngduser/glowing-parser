import java.util.Map;
import java.util.HashMap;

public enum Tokens{

    Window("Window"){
      public void setType(){
        this.terminal_type= new Gui();
      }
    },
    Layout("Layout"){
      public void setType(){
        this.terminal_type= new Layout();

      }
    },
 /*   Flow("Flow:"){
      public void setType(){
        this.terminal_type= new LayoutType();

      }
      
    },
    Grid("Grid"){
      public void setType(){
        this.terminal_type= new LayoutType();

      }
      
    },
    */
    Button("Button"){
      public void setType(){
        this.terminal_type= new Widget();

      }
      
    },
    Group("Group"){
      public void setType(){
        this.terminal_type= new Widget();

      }
      
    },
    Label("Label"){
      public void setType(){
        this.terminal_type= new Widget();

      }
      
    },
    Panel("Panel"){
      public void setType(){
        this.terminal_type= new Widget();

      }
      
    },
    Textfield("Textfield"){
      public void setType(){
        this.terminal_type= new Widget();

      }
      
    },
    Radio("Radio"){
      public void setType(){
        this.terminal_type= new RadioButton();

      }
      
    };
    
    NonTerminal terminal_type;
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
