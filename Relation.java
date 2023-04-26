import java.util.Objects;

public class Relation {
    private Node source;
    private Node target;

    public Relation(Node source, Node target) {
        this.source = source;
        this.target = target;
    }

    public Node getSource() {
        return source;
    }

    public Node getTarget() {
        return target;
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
        return Objects.equals(source, relation.getSource()) && Objects.equals(target, relation.getTarget());
    }

    @Override
    public int hashCode() {
        return Objects.hash(source, target);
    }
}