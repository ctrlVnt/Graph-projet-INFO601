/*public class Node<S> {

  private S nodeName;

  public Node(S nodeName) {
    this.nodeName = nodeName;
  }

  public S getNodeName() {
    return this.nodeName;
  }


  public void setNodeName(S nodeName) {
    this.nodeName = nodeName;
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 19;

    result = prime * result + nodeName.hashCode();

    return result;
  }

  @Override
  @SuppressWarnings("unchecked")
  public boolean equals(Object o) {
    if (o == null) {
      return false;
    } else {
      Node<S> tmp = (Node<S>) o;
      if ((this.nodeName.equals(tmp.nodeName))) {
        return true;
      } else {
        return false;
      }
    }
  }
}*/

import java.util.Objects;

public class Node {
    private String label;

    public Node(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Node)) {
            return false;
        }
        Node node = (Node) obj;
        return Objects.equals(label, node.getLabel());
    }

    @Override
    public int hashCode() {
        return Objects.hash(label);
    }

    @Override
    public String toString() {
        return "Node{" +
        "label ='" + label +
        '}';
    }
}