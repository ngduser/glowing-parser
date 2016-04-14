import java.util.Map;
import java.util.HashMap;

public enum Tokens{

    Window("Window"){
      public void setType(){
        this.terminal_type= new Window();
      }
    },
    Layout("Layout"){
      public void setType(){
        this.terminal_type= new Window();
System.out.println("EXECUTING");
      }
    },
    Flow("Flow:"){
      public void setType(){
        this.terminal_type= new Window();
System.out.println("EXECUTING");
      }
      
    },
    Grid("Grid"){
      public void setType(){
        this.terminal_type= new Window();
System.out.println("EXECUTING");
      }
      
    },
    Button("Button"){
      public void setType(){
        this.terminal_type= new Window();
System.out.println("EXECUTING");
      }
      
    },
    Group("Group"){
      public void setType(){
        this.terminal_type= new Window();
System.out.println("EXECUTING");
      }
      
    },
    Label("Label"){
      public void setType(){
        this.terminal_type= new Window();
System.out.println("EXECUTING");
      }
      
    },
    Panel("Panel"){
      public void setType(){
        this.terminal_type= new Window();
System.out.println("EXECUTING");
      }
      
    },
    Textfield("Textfield"){
      public void setType(){
        this.terminal_type= new Window();
System.out.println("EXECUTING");
      }
      
    },
    Radio("Radio"){
      public void setType(){
        this.terminal_type= new Window();
System.out.println("EXECUTING");
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
