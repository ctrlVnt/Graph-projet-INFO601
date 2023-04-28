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

    public Set<Node> getNodes() {
        return nodes;
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

    public Set<Node> findNodesByLabel(String label) {
        Set<Node> result = new HashSet<>();
        for (Node node : getNodes()) {
            if (node.getLabel().equals(label)) {
                System.out.println("ciao");
                result.add(node);
            }
        }
        return result;
    }

    public int occurrencesNodes(String label) {
        int count = 0;
        for (Node node : getNodes()) {
            if (node.getLabel().equals(label)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        /*Node agent = new Node("agent");
        Node LeGreco = new Node("Le Greco");
        Node Person = new Node("foaf:Person");
        Node objet = new Node("objeti");
        Node imageq = new Node("imageq");*/
        Node a = new Node("a");
        Node b = new Node("b");
        Node c = new Node("c");
        Node d = new Node("d");
        Node e = new Node("e");
        Node f = new Node("f");
        Node g = new Node("g");
        Node h = new Node("h");
        Node i = new Node("i");
        Node j = new Node("j");
        Node k = new Node("k");
        Node l = new Node("l");
        Node m = new Node("m");
        Node n = new Node("n");
        Node o = new Node("o");
        Node p = new Node("p");
        Node q = new Node("q");
        Node r = new Node("r");
        Node s = new Node("s");
        Node t = new Node("t");
        Node m3 = new Node("m");
        Node m1 = new Node("m");
        Node m2 = new Node("m");

        KnowledgeGraph kg2 = new KnowledgeGraph();
        /*kg2.addNode(agent);
        kg2.addNode(LeGreco);
        kg2.addNode(Person);
        kg2.addNode(objet);
        kg2.addNode(imageq);

        kg2.addRelation(new Relation(agent, LeGreco,"foaf:name"));
        kg2.addRelation(new Relation(agent, Person,"foaf:name"));
        kg2.addRelation(new Relation(agent, objet,"dc:creator"));
        kg2.addRelation(new Relation(objet, imageq,"foaf:depiction"));*/

        kg2.addNode(a);
        kg2.addNode(b);
        kg2.addNode(c);
        kg2.addNode(d);
        kg2.addNode(e);
        kg2.addNode(f);
        kg2.addNode(g);
        kg2.addNode(h);
        kg2.addNode(i);
        kg2.addNode(j);
        kg2.addNode(k);
        kg2.addNode(l);
        kg2.addNode(m);
        kg2.addNode(n);
        kg2.addNode(o);
        kg2.addNode(p);
        kg2.addNode(q);
        kg2.addNode(r);
        kg2.addNode(s);
        kg2.addNode(t);
        kg2.addNode(m1);
        kg2.addNode(m2);
        kg2.addNode(m3);

        kg2.addRelation(new Relation(a, b,"ab"));
        kg2.addRelation(new Relation(b, c,"bc"));
        kg2.addRelation(new Relation(c, d,"cd"));
        kg2.addRelation(new Relation(b, h,"bh"));
        kg2.addRelation(new Relation(h, p,"hp"));
        kg2.addRelation(new Relation(c, e,"ce"));
        kg2.addRelation(new Relation(c, f,"cf"));
        kg2.addRelation(new Relation(f, l,"fl"));
        kg2.addRelation(new Relation(f, g,"fg"));
        kg2.addRelation(new Relation(l, m,"lm"));
        kg2.addRelation(new Relation(f, m1,"fal"));
        kg2.addRelation(new Relation(p, m2,"aa"));
        kg2.addRelation(new Relation(a, m3,"aaa"));

        kg2.addRelation(new Relation(i, j,"ij"));
        kg2.addRelation(new Relation(j, k,"jk"));
        kg2.addRelation(new Relation(j, n,"jn"));
        kg2.addRelation(new Relation(k, o,"ko"));

        /*System.out.println("Relations de 'agent': " + kg2.getRelatedNodes(agent));
        System.out.println("Relations de 'objetq': " + kg2.getRelatedNodes(objet));*/

        System.out.println("Relations de 'a': " + kg2.getRelatedNodes(a));
        System.out.println("Relations de 'f': " + kg2.getRelatedNodes(f));

        System.out.println("Relations de 'j': " + kg2.getRelatedNodes(j));

        /*System.out.println(kg2.bfs(agent, imageq));
        System.out.println(kg2.bfs(agent, Person));
        System.out.println(kg2.bfs(LeGreco, imageq));*/

        System.out.println("BFS a -> c : " + kg2.bfs(a, c));
        System.out.println("BFS a -> g : " + kg2.bfs(a, g));
        System.out.println("BFS a -> n : " + kg2.bfs(a, n));
        System.out.println("BFS i -> o : " + kg2.bfs(i, o));

        System.out.println("Combien R: " + kg2.occurrencesNodes("r"));
        System.out.println("Combien O: " + kg2.occurrencesNodes("o"));
        System.out.println("Combien Z: " + kg2.occurrencesNodes("z"));
        System.out.println("Combien M: " + kg2.occurrencesNodes("m"));
    }
}
