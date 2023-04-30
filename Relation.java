import java.util.Objects;

public class Relation {
    
    private Node source;
    private Node target;
    private String w3c;
    private String name;

    public Relation(Node source, Node target,String w3c, String name) {
        this.source = source;
        this.target = target;
        this.w3c = w3c;
        this.name = name;
    }

    public Node getSource() {
        return source;
    }

    public Node getTarget() {
        return target;
    }

    public String getName() {
        return name;
    }

    private String getW3c(){
        return w3c;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Relation)) {
            return false;
        }
        Relation relation = (Relation) obj;
        return Objects.equals(source, relation.getSource()) && Objects.equals(target, relation.getTarget())
                && Objects.equals(name, relation.getName()) && Objects.equals(w3c, relation.getW3c());
    }

    @Override
    public int hashCode() {
        return Objects.hash(source, target, name);
    }
}