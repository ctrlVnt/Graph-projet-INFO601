import java.util.*;

public class KnowledgeGraph {

    private Set<Node> nodes;
    private Set<Relation> relations;

    public KnowledgeGraph() {
        nodes = new HashSet<>();
        relations = new HashSet<>();
    }

    public void addNode(Node node) {
        nodes.add(node);
    }

    public void addRelation(Relation relation) {
        relations.add(relation);
    }

    public Set<Node> getRelatedNodes(Node node) {
        Set<Node> relatedNodes = new HashSet<>();
        for (Relation relation : relations) {
            if (relation.getSource().equals(node)) {
                relatedNodes.add(relation.getTarget());
            }
        }
        return relatedNodes;
    }

    public static void main(String[] args) {
        Node agent = new Node("agent");
        Node LeGreco = new Node("Le Greco");
        Node Person = new Node("foaf:Person");
        Node objet = new Node("objeti");
        Node imageq = new Node("imageq");

        KnowledgeGraph kg2 = new KnowledgeGraph();
        kg2.addNode(agent);
        kg2.addNode(LeGreco);
        kg2.addNode(Person);
        kg2.addNode(objet);
        kg2.addNode(imageq);

        kg2.addRelation(new Relation(agent, LeGreco,"foaf:name"));
        kg2.addRelation(new Relation(agent, Person,"foaf:name"));
        kg2.addRelation(new Relation(agent, objet,"dc:creator"));
        kg2.addRelation(new Relation(objet, imageq,"foaf:depiction"));

        System.out.println("Relations de 'agent': " + kg2.getRelatedNodes(agent));
        System.out.println("Relations de 'objetq': " + kg2.getRelatedNodes(objet));
    }
}
