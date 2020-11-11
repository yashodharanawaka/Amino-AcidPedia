/*
@AminoAcdiPedia
 */
package aminoacidpedia;

import org.apache.jena.query.*;
import org.apache.jena.rdf.model.*;
import org.apache.jena.util.FileManager;

/**
 *
 * @author Yashodha Ranawaka
 */
public class AminoAcidPedia {

    static void sprqltest(String aminoAcid) {
//        String aminoAcid = "Alanine";
//        FileManager.get().addLocatorClassLoader(AminoAcidPedia.class.getClassLoader());
        Model model = FileManager.get().loadModel("D:/NetBeansProjects/AminoAcidPedia/src/aminoacidpediaOntology.rdf");
//        Query query = QueryFactory.create(
//                "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>"
//                + "PREFIX owl: <http://www.w3.org/2002/07/owl#>"
//                + "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>"
//                + "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>"
//                + "PREFIX ex: <http://www.aminoacidpedia.org/ontologies/aminoacid#>"
//                + "SELECT ?s WHERE { ?s rdf:type ex:AliphaticAminoAcid}");
        Query query = QueryFactory.create(
                "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>"
                + "PREFIX owl: <http://www.w3.org/2002/07/owl#>"
                + "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>"
                + "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>"
                + "PREFIX ex: <http://www.aminoacidpedia.org/ontologies/aminoacid#>"
                + "SELECT distinct ?class WHERE { ex:" + aminoAcid + " rdf:type ?class."
                + "FILTER(?class != owl:NamedIndividual && ?class != ex:AminoAcid)}"
                + "ORDER BY ?class");
//        System.out.println(query);
        try (QueryExecution qexec = QueryExecutionFactory.create(query, model)) {
            ResultSet results = qexec.execSelect();
            System.out.println(results);

//            System.out.println("outside while");
            while (results.hasNext()) {
//                System.out.println("inside while");
                QuerySolution solution = results.nextSolution();

//                System.out.println(solution);
                System.out.println(solution.getResource("class").getLocalName());
//                System.out.println(solution.getResource("s").getLocalName());
            }
//            String res ;
//            return res;
        }
    }

    static void sprqltest2(String category) {
        FileManager.get().addLocatorClassLoader(AminoAcidPedia.class.getClassLoader());
        Model model = FileManager.get().loadModel("C:/Users/Yashodha Ranawaka/Documents/NetBeansProjects/JenaTest/src/jenatest/Ontology.rdf");
        Query query = QueryFactory.create(
                //                "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>"
                //                + "PREFIX owl: <http://www.w3.org/2002/07/owl#>"
                //                + "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>"
                //                + "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>"
                //                + "PREFIX ex: <http://www.aminoacidpedia.org/ontologies/aminoacid#>"
                //                + "SELECT ?s WHERE { ex:Valine ?dataPop ?val."
                //                + "?dataPop a owl:DatatypeProperty}");
                "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>"
                + "PREFIX owl: <http://www.w3.org/2002/07/owl#>"
                + "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>"
                + "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>"
                + "PREFIX ex: <http://www.aminoacidpedia.org/ontologies/aminoacid#>"
                + "SELECT ?s WHERE { ?s rdf:type ex:" + category + "}");
//        System.out.println(query);
        try (QueryExecution qexec = QueryExecutionFactory.create(query, model)) {
            ResultSet results = qexec.execSelect();
            System.out.println(results);
            System.out.println("outside while");
            while (results.hasNext()) {
                System.out.println("inside while");
                QuerySolution solution = results.nextSolution();
                System.out.println(solution.getResource("s").getLocalName());
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
//        sprqltest();
        MainWindow app = new MainWindow();
        app.setVisible(true);
        app.setLocationRelativeTo(null);
    }

}
