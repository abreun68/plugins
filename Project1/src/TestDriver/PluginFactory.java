package TestDriver;


import DataAnalysis.DataMapPlugin;
import DataAnalysis.ParallelCoordinatesPlugin;
import DataAnalysis.PertChartPlugin;
import DataAnalysis.Plugin;
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
        
        
        PertChartPlugin pertChartPlugin = new PertChartPlugin(evalObject);
        
        return pertChartPlugin;
    }//end of getPertChartPlugin()
        
    public static Plugin getDataMapPlugin() {
	
        // Simulates getting the data from the database.        
        ArrayList<String> dataMapQuestions = new ArrayList<String>();
        dataMapQuestions.add("Is there a concentration in a certain location? Why?");
	dataMapQuestions.add("What state/area had the most?");  
	dataMapQuestions.add("What state/area had the least?"); 
	dataMapQuestions.add("Is there any inconclusive data areas?"); 
	dataMapQuestions.add("Does the color scale contain patterns or textures to differentiate similar shades?"); 
	dataMapQuestions.add("Can the under-represented areas be easily identified?");
        dataMapQuestions.add("Can the over-represented areas be easily identified?");
        dataMapQuestions.add("Are the boundaries clearly delineated?");
        dataMapQuestions.add("Is context provided?");
        dataMapQuestions.add("Are the colors used, readable for colorblind users?");
        dataMapQuestions.add("Can you draw any conclusions from the data map?");
        dataMapQuestions.add("Are the colors used representatives of the data in any way? ");
   
        EvalObject evalObject = new EvalObject("Data Map Evaluation",
                "Evaluates visual data analysis and reasoning",
                new ArrayList<Datapoint>(),
                new HashMap<String, String>());
        
        Iterator<String> it = getCannedQuestions().iterator();
        while (it.hasNext()) {
            String question = it.next();
            evalObject.addQuestion(new EvalQuestion(question, 30, "s", 0));
        }
        
        DataMapPlugin dataMapPlugin = new DataMapPlugin(evalObject);
        
        return dataMapPlugin;
    }//end of getDataMapPlugin()

    public static Plugin getParallelCoordinatesPlugin() {

       // Simulates the questions obtained by the DB Manager
        ArrayList<String> parallelCoordinatesQuestions = new ArrayList<String>();
        parallelCoordinatesQuestions.add("Canned Question 'a'?");
        parallelCoordinatesQuestions.add("Canned Question 'b'?");
        parallelCoordinatesQuestions.add("Canned Question 'c'?");
        parallelCoordinatesQuestions.add("Canned Question 'd'?");

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
        ParallelCoordinatesPlugin parallelCoordinatesPlugin = 
                new ParallelCoordinatesPlugin(evalObject);

        
        // Return plugin
        return parallelCoordinatesPlugin;
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
