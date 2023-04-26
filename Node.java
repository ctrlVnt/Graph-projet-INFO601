public class Node<S> {

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
  
  /**
   * Overrides the method that calculates the hash value
   * If two objects are equal according to the equals(Object) method,
   * then calling the hashCode method on each of the two objects must produce the
   * same integer result.
   */
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
}
