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

    public Set<Node> bfs(Node startNode, Node targetNode) {
        Queue<Node> queue = new LinkedList<>();
        Set<Node> visited = new HashSet<>();
    
        queue.add(startNode);
        visited.add(startNode);
    
        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
    
            if (currentNode.equals(targetNode)) {
                // abbiamo trovato il nodo di destinazione
                return visited;
            }
    
            // aggiungiamo i nodi adiacenti alla coda se non sono stati visitati
            Set<Node> relatedNodes = getRelatedNodes(currentNode);
            for (Node relatedNode : relatedNodes) {
                if (!visited.contains(relatedNode)) {
                    visited.add(relatedNode);
                    queue.add(relatedNode);
                }
            }
        }
    
        // il nodo di destinazione non è stato trovato
        return null;
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

        System.out.println(kg2.bfs(agent, imageq));
        System.out.println(kg2.bfs(agent, Person));
        System.out.println(kg2.bfs(LeGreco, imageq));
    }
}
