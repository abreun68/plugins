package TestDriver;


import DataAnalysis.DataMapPlugin;
import DataAnalysis.PertChartPlugin;
import DataAnalysis.Plugin;
import DataObject.Datapoint;
import DataObject.EvalObject;
import DataObject.EvalQuestion;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/*
 * This Test
 */

/**
 *
 * @author Nacer Abreu
 */
public class PluginFactory {

    public static Plugin getPertChartPlugin() {

        // Simulates getting the data from the database.        
        ArrayList<String> pertChartQuestions = new ArrayList<String>();
        pertChartQuestions.add("Did the tasks, in this visualization, follow a logical order?");
	pertChartQuestions.add("Were the sub-tasks clearly labeled?");  
	pertChartQuestions.add("Was the visualization too detailed?"); 
	pertChartQuestions.add("Was the critical path easy to follow?"); 
	pertChartQuestions.add("Was the visualization conducive to decision making?"); 
	pertChartQuestions.add("Who performed the task faster or more efficiently?");
        pertChartQuestions.add("Did each task, or sub-task, defined a completion (duration" + ") time?");


        
//        Doug Question: why Datapoint::valueX is a string, while 
//        Doug Question: Datapoint::valueY is a double?
//        Doug Question: Which are the possible values for Datapoint::groups?
//        Doug Question: Which are the possible values for Datapoint::label?        
        Datapoint datapoint = new Datapoint("PertCharDataPoints", "valid_group", "value_x", 1, 1, 1);

//        Doug Question: How do you insert datapoints into the EvalObject? 
//        Doug Question: Should we create a method like "addDatapoint()"?       
        EvalObject evalObject = new EvalObject("PertChart Plugins", "Exploration", new ArrayList<Datapoint>(), new HashMap<String, String>());

        
        Iterator<String> it = pertChartQuestions.iterator();
        while (it.hasNext()) {
            String question = it.next();
            evalObject.addQuestion(new EvalQuestion(question, 30, "s", 0));
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
   
        EvalObject evalObject = new EvalObject("PertChart Plugins", "Exploration", new ArrayList<Datapoint>(), new HashMap<String, String>());
        
        Iterator<String> it = dataMapQuestions.iterator();
        while (it.hasNext()) {
            String question = it.next();
            evalObject.addQuestion(new EvalQuestion(question, 30, "s", 0));
        }
        
        DataMapPlugin dataMapPlugin = new DataMapPlugin(evalObject);
        
        return dataMapPlugin;
    }//end of getDataMapPlugin()

}
