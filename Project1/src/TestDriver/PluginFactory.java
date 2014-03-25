package TestDriver;


import DataAnalysis.DataMapPlugin;
import DataAnalysis.ParallelCoordinatesPlugin;
import DataAnalysis.PertChartPlugin;
import DataAnalysis.Plugin;
import DataAnalysis.TreeMapPlugin;
import DataObject.Datapoint;
import DataObject.EvalObject;
import DataObject.EvalQuestion;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;



/**
 * This class is for TESTING PURPOSES ONLY. It is suppose to represent a
 * combination of different actors. One being the "DB Manager" which makes 
 * calls to the underlying database and populates the "Evaluation" objects. The 
 * second actor being some kind of "Plugin Factory" which is in charge of 
 * putting together a "Plugin". 
 * @author Nacer Abreu
 */
public class PluginFactory {

    public static Plugin getPertChartPlugin() {

        
        // Create Evaluation Object
        EvalObject evalObject = new EvalObject("PertChart Evaluation", 
                "Evaluates visual data analysis and reasoning", 
                new ArrayList<Datapoint>(), 
                new HashMap<String, String>());

        
        // Add Canned Questions        
        Iterator<String> it = getCannedQuestions().iterator();
        while (it.hasNext()) {
            String question = it.next();
            evalObject.addQuestion(new EvalQuestion(question, 30, "s", 0));
        }

        // Add Datapoints
        for (int i = 0; i < 100; i++) {
            evalObject.addDatapoint(new Datapoint("label", "group", "valueX",
                    i, 30, 3));
        }        
        
        // Create Plugin
        Plugin plugin = new PertChartPlugin(evalObject);
        return plugin;
    }//end of getPertChartPlugin()
        
    public static Plugin getDataMapPlugin() {

        // Create Evaluation Object
        EvalObject evalObject = new EvalObject("Data Map Evaluation",
                "Evaluates visual data analysis and reasoning",
                new ArrayList<Datapoint>(),
                new HashMap<String, String>());
        
        // Add Questions
        Iterator<String> it = getCannedQuestions().iterator();
        while (it.hasNext()) {
            String question = it.next();
            evalObject.addQuestion(new EvalQuestion(question, 30, "s", 0));
        }
        
        // Add Datapoints
        for (int i = 20; i < 100; i++) {
            evalObject.addDatapoint(new Datapoint("label", "group", "valueX",
                    i, i, 3));
        }  
        
        // Create Plugin
        Plugin plugin = new DataMapPlugin(evalObject);
        return plugin;
        
    }//end of getDataMapPlugin()

    public static Plugin getTreeMapPlugin() {

        // Create Evaluation Object
        EvalObject evalObject = new EvalObject("Tree Map Evaluation",
                "Evaluates visual data analysis and reasoning",
                new ArrayList<Datapoint>(),
                new HashMap<String, String>());
        
        // Add Questions
        Iterator<String> it = getCannedQuestions().iterator();
        while (it.hasNext()) {
            String question = it.next();
            evalObject.addQuestion(new EvalQuestion(question, 30, "s", 0));
        }
        
        // Add Datapoints
        for (int i = 20; i < 100; i++) {
            evalObject.addDatapoint(new Datapoint("label", "group", "valueX",
                    i, i, 3));
        }  
        
        // Create Plugin
        Plugin plugin = new TreeMapPlugin(evalObject);
        return plugin;
        
    }//end of getTreeMapPlugin()    
    
    public static Plugin getParallelCoordinatesPlugin() {


        // Create Evaluation Object
        EvalObject evalObject = new EvalObject("Parallel Coordinates Evaluation",
                "Evaluates visual data analysis and reasoning",
                new ArrayList<Datapoint>(),
                new HashMap<String, String>());

        // Adds Canned Questions
        Iterator<String> it = getCannedQuestions().iterator();
        while (it.hasNext()) {
            String question = it.next();
            evalObject.addQuestion(new EvalQuestion(question, 30, "s", 0));
        }

        // Add Datapoints
        for (int i = 0; i < 100; i++) {
            evalObject.addDatapoint(new Datapoint("label", "group", "valueX",
                    i, 30, 3));
        }
                
        // Creates plugin
        Plugin plugin = new ParallelCoordinatesPlugin(evalObject);
        return plugin;
        
    }//end of getParallelCoordinatesPlugin()

    private static ArrayList<String> getCannedQuestions() {
        if (cannedQuestions.isEmpty()) {
            cannedQuestions.add("Canned Question 'a'?");
            cannedQuestions.add("Canned Question 'b'?");
            cannedQuestions.add("Canned Question 'c'?");
            cannedQuestions.add("Canned Question 'd'?");
            cannedQuestions.add("Canned Question 'e'?");
            cannedQuestions.add("Canned Question 'f'?");
            cannedQuestions.add("Canned Question 'g'?");
        }        
        return cannedQuestions;
    }//end of getCannedQuestions()
    
    private static ArrayList<String> cannedQuestions = new ArrayList<String>();
    
}
