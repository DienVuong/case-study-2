
import java.io.Serializable;

public class Faculty implements Serializable {
    private String name;

    public Faculty(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
