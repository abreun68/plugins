
import DataAnalysis.PertChartPlugin;
import DataAnalysis.Plugin;
import DataObject.Datapoint;
import DataObject.EvalObject;
import DataObject.EvalQuestion;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nacer Abreu
 */
public class PluginFactory {

    public static Plugin getPertChartPlugin() {

        ArrayList<String> pertChartQuestions = new ArrayList<String>();
        pertChartQuestions.add("Did the tasks, in this visualization, follow a logical order?");
	pertChartQuestions.add("Were the sub-tasks clearly labeled?");  
	pertChartQuestions.add("Was the visualization too detailed?"); 
	pertChartQuestions.add("Was the critical path easy to follow?"); 
	pertChartQuestions.add("Was the visualization conducive to decision making?"); 
	pertChartQuestions.add("Who performed the task faster or more efficiently?");        

        
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
    }

}
