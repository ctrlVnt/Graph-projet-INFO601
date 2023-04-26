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
        Node personne = new Node("personne");
        Node animal = new Node("animal");
        Node chat = new Node("chat");
        Node chien = new Node("chien");
    
        KnowledgeGraph kg = new KnowledgeGraph();
        kg.addNode(personne);
        kg.addNode(animal);
        kg.addNode(chat);
        kg.addNode(chien);
    
        kg.addRelation(new Relation(personne, animal,"est_un"));
        kg.addRelation(new Relation(animal, chat,"est_un"));
        kg.addRelation(new Relation(animal, chien, "est_un"));
    
        System.out.println("Relations de 'animal': " + kg.getRelatedNodes(animal));
    }
}
