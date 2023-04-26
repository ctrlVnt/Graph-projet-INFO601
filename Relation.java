import java.util.Objects;

public class Relation {
    
    private Node source;
    private Node target;
    private String name;

    public Relation(Node source, Node target, String name) {
        this.source = source;
        this.target = target;
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
                && Objects.equals(name, relation.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(source, target, name);
    }
}