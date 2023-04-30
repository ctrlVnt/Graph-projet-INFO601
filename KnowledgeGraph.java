import java.nio.file.WatchEvent;
import java.security.Principal;
import java.util.*;

public class KnowledgeGraph {

    //relations pour les objects
    public enum W3C {
        FOAF("FOAF"),
        RDF("RDF"),
        SKOS("SKOS");
        private final String text;

        W3C(String text) {
            this.text = text;
        }

        public String getText() {
            return text;
        }
    }

    public enum Relat {
        AMI("Ami"),
        MATIERE("Matiere"),
        PROFESSEUR("Professeur"),
        ENSEIGNE("Enseigne"),
        AGE("Age"),
        ADRESSE("Adresse"),
        LIEU("Lieu");

        private final String text;

        Relat(String text) {
            this.text = text;
        }

        public String getText() {
            return text;
        }
    }

    private Set<Node> nodes;
    private Set<Relation> relations;

    public KnowledgeGraph() {
        nodes = new HashSet<>();
        relations = new HashSet<>();
    }

    //add node
    public void addNode(Node node) {
        nodes.add(node);
    }

    //add relation from a node to b
    public void addRelation(Relation relation) {
        relations.add(relation);
    }

    //get all nodes related to x node
    public Set<Node> getRelatedNodes(Node node) {
        Set<Node> relatedNodes = new HashSet<>();
        for (Relation relation : relations) {
            if (relation.getSource().equals(node)) {
                relatedNodes.add(relation.getTarget());
            }
        }
        return relatedNodes;
    }

    //get all nodes related to x node BUT with label relation
    public Set<Node> getRelatedNodes(Node node, String label) {
        Set<Node> relatedNodes = new HashSet<>();
        for (Relation relation : relations) {
            if (relation.getSource().equals(node) && relation.getName().equals(label)) {
                relatedNodes.add(relation.getTarget());
            }
        }
        return relatedNodes;
    }

    //BFS research alghoritm
    public Set<Node> bfs(Node startNode, Node targetNode) {
        Queue<Node> queue = new LinkedList<>();
        Set<Node> visited = new HashSet<>();
    
        queue.add(startNode);
        visited.add(startNode);
    
        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
    
            if (currentNode.equals(targetNode)) {
                return visited;
            }
    
            Set<Node> relatedNodes = getRelatedNodes(currentNode);
            for (Node relatedNode : relatedNodes) {
                if (!visited.contains(relatedNode)) {
                    visited.add(relatedNode);
                    queue.add(relatedNode);
                }
            }
        }
    
        return null;
    }

    //DFS research alghoritm
    public Set<Node> dfs(Node startNode, Node targetNode) {
        Set<Node> visited = new HashSet<>();
        Stack<Node> stack = new Stack<>();
        
        stack.push(startNode);
        
        while (!stack.isEmpty()) {
            Node currentNode = stack.pop();
            
            if (!visited.contains(currentNode)) {
                visited.add(currentNode);
                
                if (currentNode.equals(targetNode)) {
                    return visited;
                }
                
                Set<Node> relatedNodes = getRelatedNodes(currentNode);
                
                for (Node relatedNode : relatedNodes) {
                    stack.push(relatedNode);
                }
            }
        }
        
        return null;
    }

    //Number of node with label string
    public int occurrencesNodes(Node startNode, Node targetNode, String label) {
        Queue<Node> queue = new LinkedList<>();
        Set<Node> visited = new HashSet<>();

        int count = 0;
    
        queue.add(startNode);
        visited.add(startNode);
    
        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
    
            if (currentNode.equals(targetNode)) {
                return count;
            }
    
            Set<Node> relatedNodes = getRelatedNodes(currentNode);
            for (Node relatedNode : relatedNodes) {
                
                if(relatedNode.getLabel().equals(label)){
                    count++;
                }

                if (!visited.contains(relatedNode)) {
                    visited.add(relatedNode);
                    queue.add(relatedNode);
                }
            }
        }
    
        return count;
    }

    //find all nodes connected to startNode with label relation
    public Set<Node> find(Node startNode, Node targetNode, String label) {
        Queue<Node> queue = new LinkedList<>();
        Set<Node> visited = new HashSet<>();

        queue.add(startNode);
        visited.add(startNode);
    
        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
    
            if (currentNode.equals(targetNode)) {
                return visited;
            }
    
            Set<Node> relatedNodes = getRelatedNodes(currentNode, label);

            for (Node relatedNode : relatedNodes) {

                if (!visited.contains(relatedNode)) {
                    visited.add(relatedNode);
                    queue.add(relatedNode);
                }
            }
        }
    
        return null;
    }

    //find all nodes with label proprierty in the graph
    public Set<Node> findElementsAssociated(Node startNode, Node targetNode, String label) {
        Queue<Node> queue = new LinkedList<>();
        Set<Node> visited = new HashSet<>();
        Set<Node> res = new HashSet<>();
    
        queue.add(startNode);
        visited.add(startNode);
    
        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
    
            if (currentNode.equals(targetNode)) {
                return res;
            }
    
            Set<Node> relatedNodes = getRelatedNodes(currentNode);
            for (Node relatedNode : relatedNodes) {
                
                if(relatedNode.getLabel().equals(label)){
                    res.add(currentNode);
                }

                if (!visited.contains(relatedNode)) {
                    visited.add(relatedNode);
                    queue.add(relatedNode);
                }
            }
        }
    
        return null;
    }

   
    public static void main(String[] args) 
    {
        City Bourget = new City("Bourget");
        University Usmb = new University("Usmb");
        University Jacob = new University("Jacob");
        Subject Info605 = new Subject("info605");
        Subject Info606 = new Subject("info606");
        Teacher Roche = new Teacher("Roche");
        Teacher Wayntal = new Teacher("Wayntal");
        Student Boris = new Student("Boris");
        Student Riccardo = new Student("Riccardo");
        Student Clement = new Student("Clement");
        Student Tom = new Student("Tom");
        Student Enzo = new Student("Enzo");
        Student Mathis = new Student("Mathis");

        KnowledgeGraph StudentGraph = new KnowledgeGraph();
        StudentGraph.addNode(Bourget);
        StudentGraph.addNode(Usmb);
        StudentGraph.addNode(Jacob);
        StudentGraph.addNode(Info605);
        StudentGraph.addNode(Info606);
        StudentGraph.addNode(Roche);
        StudentGraph.addNode(Wayntal);
        StudentGraph.addNode(Boris);
        StudentGraph.addNode(Riccardo);
        StudentGraph.addNode(Clement);
        StudentGraph.addNode(Tom);
        StudentGraph.addNode(Enzo);
        StudentGraph.addNode(Mathis);

        StudentGraph.addRelation(new Relation(Bourget, Usmb, W3C.RDF.getText(), Relat.LIEU.getText()));
        StudentGraph.addRelation(new Relation(Bourget, Jacob, W3C.RDF.getText(), Relat.LIEU.getText()));
        StudentGraph.addRelation(new Relation(Usmb, Info605, W3C.RDF.getText(), Relat.MATIERE.getText()));
        StudentGraph.addRelation(new Relation(Usmb, Info606, W3C.RDF.getText(), Relat.MATIERE.getText()));
        StudentGraph.addRelation(new Relation(Info605, Wayntal, W3C.FOAF.getText(), Relat.PROFESSEUR.getText()));
        StudentGraph.addRelation(new Relation(Info606, Roche, W3C.FOAF.getText(), Relat.PROFESSEUR.getText()));
        StudentGraph.addRelation(new Relation(Wayntal, Boris, W3C.FOAF.getText(), Relat.ENSEIGNE.getText()));
        StudentGraph.addRelation(new Relation(Wayntal, Riccardo, W3C.FOAF.getText(), Relat.ENSEIGNE.getText()));
        StudentGraph.addRelation(new Relation(Boris, Riccardo, W3C.FOAF.getText(), Relat.AMI.getText()));

        System.out.println("BFS Bourget -> Riccardo : " + StudentGraph.dfs(Bourget,Riccardo));
        System.out.println("BFS Bourget -> Riccardo : " + StudentGraph.getRelatedNodes(Wayntal));




        

    }
}
