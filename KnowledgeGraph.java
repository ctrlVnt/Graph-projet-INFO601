import java.util.*;

public class KnowledgeGraph {

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

    public Set<Node> getRelatedNodesType(Node node, String label) {
        Set<Node> relatedNodes = new HashSet<>();
        for (Relation relation : relations) {
            if (relation.getSource().equals(node) && relation.getW3c().equals(label)) {
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

    //afficher all Graph
    public ArrayList<Node> afficheGraph(Node startNode) {
        Queue<Node> queue = new LinkedList<>();
        ArrayList<Node> visited =  new ArrayList<Node>();
    
        queue.add(startNode);
        visited.add(startNode);
    
        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
    
            Set<Node> relatedNodes = getRelatedNodes(currentNode);
            for (Node relatedNode : relatedNodes) {
                if (!visited.contains(relatedNode)) {
                    visited.add(relatedNode);
                    queue.add(relatedNode);
                }
            }
        }
    
        return visited;
    }

    //nombre de node de une type
    public int occurrencesNodes(Node startNode, Class label) {
        Queue<Node> queue = new LinkedList<>();
        Set<Node> visited =  new LinkedHashSet<>();

        int count = 0;
    
        queue.add(startNode);
        visited.add(startNode);
    
        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
    
            Set<Node> relatedNodes = getRelatedNodes(currentNode);
            for (Node relatedNode : relatedNodes) {
                if (!visited.contains(relatedNode)) {

                    if(relatedNode.getClass().equals(label)){
                        count++;
                    }

                    visited.add(relatedNode);
                    queue.add(relatedNode);
                }
            }
        }
    
        return count;
    }

    //Affiche les occurrence de la class label
    public ArrayList<Node> afficheOccurrencesNodes(Node startNode, Class label) {
        Queue<Node> queue = new LinkedList<>();
        Set<Node> visited =  new LinkedHashSet<>();
        ArrayList<Node> res =  new ArrayList<Node>();

        queue.add(startNode);
        visited.add(startNode);
    
        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
    
            Set<Node> relatedNodes = getRelatedNodes(currentNode);
            for (Node relatedNode : relatedNodes) {
                if (!visited.contains(relatedNode)) {

                    if(relatedNode.getClass().equals(label)){
                        res.add(relatedNode);
                        Set<Node> tmp = getRelatedNodesType(relatedNode, W3C.SKOS.getText());
                        for (Node i : tmp){
                            res.add(i);
                        }
                    }

                    visited.add(relatedNode);
                    queue.add(relatedNode);
                }
            }
        }
    
        return res;
    }

    //affiche si existe une chemin ou pas
    public Boolean existe(Node startNode, Node targetNode) {
        Queue<Node> queue = new LinkedList<>();
        Set<Node> visited = new HashSet<>();
    
        queue.add(startNode);
        visited.add(startNode);
    
        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
    
            if (currentNode.equals(targetNode)) {
                return true;
            }
    
            Set<Node> relatedNodes = getRelatedNodes(currentNode);
            for (Node relatedNode : relatedNodes) {
                if (!visited.contains(relatedNode)) {
                    visited.add(relatedNode);
                    queue.add(relatedNode);
                }
            }
        }
    
        return false;
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
        Teacher Cavalini = new Teacher("Cavalini");
        Adresse rueBourget = new Adresse("34 rue du Bourget");
        Adresse rueBourget2 = new Adresse("22 rue du Bourget");
        Adresse rueJacob = new Adresse("33 rue de Jacob");
        Age Aenzo = new Age("21");
        Age Amathis = new Age("21");
        Age Aclement = new Age("21");
        Age Atom = new Age("20");
        Age Ariccardo = new Age("23");
        Age Aboris = new Age("21");

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
        StudentGraph.addNode(Cavalini);
        StudentGraph.addNode(rueBourget);
        StudentGraph.addNode(rueBourget2);
        StudentGraph.addNode(rueJacob);
        StudentGraph.addNode(Aenzo);
        StudentGraph.addNode(Amathis);
        StudentGraph.addNode(Aclement);
        StudentGraph.addNode(Atom);
        StudentGraph.addNode(Ariccardo);
        StudentGraph.addNode(Aboris);
        
        StudentGraph.addRelation(new Relation(Bourget, Usmb, W3C.RDF.getText(), Relat.LIEU.getText()));
        StudentGraph.addRelation(new Relation(Bourget, Jacob, W3C.RDF.getText(), Relat.LIEU.getText()));
        StudentGraph.addRelation(new Relation(Usmb, Info605, W3C.RDF.getText(), Relat.MATIERE.getText()));
        StudentGraph.addRelation(new Relation(Usmb, Info606, W3C.RDF.getText(), Relat.MATIERE.getText()));
        StudentGraph.addRelation(new Relation(Info605, Wayntal, W3C.FOAF.getText(), Relat.PROFESSEUR.getText()));
        StudentGraph.addRelation(new Relation(Info606, Roche, W3C.FOAF.getText(), Relat.PROFESSEUR.getText()));
        StudentGraph.addRelation(new Relation(Wayntal, Boris, W3C.FOAF.getText(), Relat.ENSEIGNE.getText()));
        StudentGraph.addRelation(new Relation(Wayntal, Riccardo, W3C.FOAF.getText(), Relat.ENSEIGNE.getText()));
        StudentGraph.addRelation(new Relation(Boris, Riccardo, W3C.FOAF.getText(), Relat.AMI.getText()));

        StudentGraph.addRelation(new Relation(Info605, Cavalini, W3C.FOAF.getText(), Relat.PROFESSEUR.getText()));

        StudentGraph.addRelation(new Relation(Roche, Enzo, W3C.FOAF.getText(), Relat.ENSEIGNE.getText()));
        StudentGraph.addRelation(new Relation(Roche, Mathis, W3C.FOAF.getText(), Relat.ENSEIGNE.getText()));
        StudentGraph.addRelation(new Relation(Roche, Clement, W3C.FOAF.getText(), Relat.ENSEIGNE.getText()));
        StudentGraph.addRelation(new Relation(Roche, Tom, W3C.FOAF.getText(), Relat.ENSEIGNE.getText()));

        StudentGraph.addRelation(new Relation(Tom, Atom, W3C.SKOS.getText(), Relat.AGE.getText()));
        StudentGraph.addRelation(new Relation(Clement, Aclement, W3C.SKOS.getText(), Relat.AGE.getText()));
        StudentGraph.addRelation(new Relation(Mathis, Amathis, W3C.SKOS.getText(), Relat.AGE.getText()));
        StudentGraph.addRelation(new Relation(Enzo, Aenzo, W3C.SKOS.getText(), Relat.AGE.getText()));
        StudentGraph.addRelation(new Relation(Riccardo, Ariccardo, W3C.SKOS.getText(), Relat.AGE.getText()));
        StudentGraph.addRelation(new Relation(Boris, Aboris, W3C.SKOS.getText(), Relat.AGE.getText()));

        StudentGraph.addRelation(new Relation(Usmb, rueBourget2, W3C.SKOS.getText(), Relat.ADRESSE.getText()));
        StudentGraph.addRelation(new Relation(Jacob, rueJacob, W3C.SKOS.getText(), Relat.ADRESSE.getText()));
        StudentGraph.addRelation(new Relation(Cavalini, rueBourget, W3C.SKOS.getText(), Relat.ADRESSE.getText()));

        StudentGraph.addRelation(new Relation(Cavalini, Wayntal, W3C.FOAF.getText(), Relat.AMI.getText()));
        StudentGraph.addRelation(new Relation(Wayntal, Cavalini, W3C.FOAF.getText(), Relat.AMI.getText()));

        System.out.println("Le Graph : " + StudentGraph.afficheGraph(Bourget));
        System.out.println();
        System.out.println("Combient etudiant au Burget :" + StudentGraph.occurrencesNodes(Bourget, Student.class));
        System.out.println("toutes les relations de Wayntal :" + StudentGraph.getRelatedNodes(Wayntal));
        System.out.println();
        System.out.println("Boris est dans le Jacob? :" + StudentGraph.existe(Jacob, Boris));
        System.out.println("Boris est dans le USMB? :" + StudentGraph.existe(Usmb, Boris));
        System.out.println();
        System.out.println("Les relations des amitié de Wayntal :" + StudentGraph.getRelatedNodes(Wayntal, Relat.AMI.getText()));
        System.out.println("Les relations des ensegnement de Wayntal :" + StudentGraph.getRelatedNodes(Wayntal, Relat.ENSEIGNE.getText()));
        System.out.println();
        System.out.println("Les etudiant au Burget :" + StudentGraph.afficheOccurrencesNodes(Bourget, Student.class));
        System.out.println("Les prof au Burget :" + StudentGraph.afficheOccurrencesNodes(Bourget, Teacher.class));
    }

    static class OrderedSet<T> extends LinkedHashSet<T> {

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            boolean first = true;
            for (T element : this) {
                if (!first) {
                    sb.append(", ");
                }
                sb.append(element.toString());
                first = false;
            }
            sb.append("]");
            return sb.toString();
        }
    }
}
