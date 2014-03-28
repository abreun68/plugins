package TestDriver;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import DataAnalysis.ConcentricCirclesQuestion;
import DataAnalysis.ConceptFanQuestion;
import DataAnalysis.ConceptMapQuestion;
import DataAnalysis.DataMapQuestion;
import DataAnalysis.MindMapQuestion;
import DataAnalysis.ParallelCoordinatesQuestion;
import DataAnalysis.PertChartQuestion;
import DataAnalysis.QuestionBase;
import DataAnalysis.TreeMapQuestion;
import DataObject.Datapoint;
import DataObject.EvalObject;
import DataObject.Question;



/**
 * This class is for TESTING PURPOSES ONLY. It is suppose to represent a
 * combination of different actors. One being the "DB Manager" which makes 
 * calls to the underlying database and populates the "Evaluation" objects. The 
 * second actor being some kind of "Plugin Factory" which is in charge of 
 * putting together a "Plugin". 
 * @author Nacer Abreu
 */
public class PluginFactory {

    private static ArrayList<String> cannedQuestions = new ArrayList<String>();

	public static PertChartQuestion getPertChartPlugin() {

    	
    	 // Add Datapoints
        ArrayList<Datapoint> dpList = new ArrayList<Datapoint>();
        for (int i = 0; i < 100; i++) {
        	dpList.add(new Datapoint("label", "group", "valueX", i, 30, 3));
        }   
        
        // Create Evaluation Object
        EvalObject evalObject = new EvalObject("PertChart Evaluation", 
                "Evaluates visual data analysis and reasoning", 
                dpList, 
                new HashMap<String, String>());

        
        // Add Canned Questions 
        Iterator<String> it = getCannedQuestions().iterator();
        while (it.hasNext()) {
            String question = it.next();
            evalObject.addQuestion(new Question(question, 30, "s", 0));
        }
 
        
        // Create Plugin
        PertChartQuestion plugin = new PertChartQuestion(evalObject);
        
        // test 
        evalObject.test();   
        
        return plugin;
    }//end of getPertChartPlugin()
        
    public static DataMapQuestion getDataMapPlugin() {
    	
    	// Add Datapoints
        ArrayList<Datapoint> dpList = new ArrayList<Datapoint>();
        for (int i = 0; i < 100; i++) {
        	dpList.add(new Datapoint("label", "group", "valueX", i, 30, 3));
        }

        // Create Evaluation Object
        EvalObject evalObject = new EvalObject("Data Map Evaluation",
                "Evaluates visual data analysis and reasoning",
                dpList,
                new HashMap<String, String>());
        
        // Add Questions
        Iterator<String> it = getCannedQuestions().iterator();
        while (it.hasNext()) {
            String question = it.next();
            evalObject.addQuestion(new Question(question, 30, "s", 0));
        }
          
        
        // Create Plugin
        DataMapQuestion plugin = new DataMapQuestion(evalObject);
        
        // test 
        evalObject.test();   
        
        return plugin;
        
    }//end of getDataMapPlugin()

    public static TreeMapQuestion getTreeMapPlugin() {

    	// Add Datapoints
        ArrayList<Datapoint> dpList = new ArrayList<Datapoint>();
        for (int i = 0; i < 100; i++) {
        	dpList.add(new Datapoint("label", "group", "valueX", i, 30, 3));
        }
        
        // Create Evaluation Object
        EvalObject evalObject = new EvalObject("Tree Map Evaluation",
                "Evaluates visual data analysis and reasoning",
                dpList,
                new HashMap<String, String>());
        
        // Add Questions
        Iterator<String> it = getCannedQuestions().iterator();
        while (it.hasNext()) {
            String question = it.next();
            evalObject.addQuestion(new Question(question, 30, "s", 0));
        }
         
        // Create Plugin
        TreeMapQuestion plugin = new TreeMapQuestion(evalObject);
        
        // test 
        evalObject.test();   
        
        return plugin;
        
    }//end of getTreeMapPlugin()    
    
    public static ParallelCoordinatesQuestion getParallelCoordinatesPlugin() {

        // Add Datapoints
        ArrayList<Datapoint> dpList = new ArrayList<Datapoint>();
        for (int i = 0; i < 100; i++) {
        	dpList.add(new Datapoint("label", "group", "valueX", i, 30, 3));
        } 

        // Create Evaluation Object
        EvalObject evalObject = new EvalObject("Parallel Coordinates Evaluation",
                "Evaluates visual data analysis and reasoning",
                dpList,
                new HashMap<String, String>());

        // Adds Canned Questions
        Iterator<String> it = getCannedQuestions().iterator();
        while (it.hasNext()) {
            String question = it.next();
            evalObject.addQuestion(new Question(question, 30, "s", 0));
        }


                
        // Creates plugin
        ParallelCoordinatesQuestion plugin = new ParallelCoordinatesQuestion(evalObject);
        
        // test 
        evalObject.test();   
        
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

	public static QuestionBase getConcentricCirclePlugin() {
		 // Add Datapoints
        ArrayList<Datapoint> dpList = new ArrayList<Datapoint>();
        for (int i = 0; i < 100; i++) {
        	dpList.add(new Datapoint("label", "group", "valueX", i, 30, 3));
        }   
        
        // Create Evaluation Object
        EvalObject evalObject = new EvalObject("Concentric Circle Evaluation", 
                "Evaluates visual data analysis and reasoning", 
                dpList, 
                new HashMap<String, String>());

        
        // Add Canned Questions 
        Iterator<String> it = getCannedQuestions().iterator();
        while (it.hasNext()) {
            String question = it.next();
            evalObject.addQuestion(new Question(question, 30, "s", 0));
        }
 
        
        // Create Plugin
        ConcentricCirclesQuestion plugin = new ConcentricCirclesQuestion(evalObject);
        
        // test 
        evalObject.test();   
        
        return plugin;
	}

	public static QuestionBase getConceptFanPlugin() {
		 // Add Datapoints
        ArrayList<Datapoint> dpList = new ArrayList<Datapoint>();
        for (int i = 0; i < 100; i++) {
        	dpList.add(new Datapoint("label", "group", "valueX", i, 30, 3));
        }   
        
        // Create Evaluation Object
        EvalObject evalObject = new EvalObject("Concept Fan Evaluation", 
                "Evaluates visual data analysis and reasoning", 
                dpList, 
                new HashMap<String, String>());

        
        // Add Canned Questions 
        Iterator<String> it = getCannedQuestions().iterator();
        while (it.hasNext()) {
            String question = it.next();
            evalObject.addQuestion(new Question(question, 30, "s", 0));
        }
 
        
        // Create Plugin
        ConceptFanQuestion plugin = new ConceptFanQuestion(evalObject);
        
        // test 
        evalObject.test();   
        
        return plugin;
	}

	public static QuestionBase getConceptMapPlugin() {
		 // Add Datapoints
        ArrayList<Datapoint> dpList = new ArrayList<Datapoint>();
        for (int i = 0; i < 100; i++) {
        	dpList.add(new Datapoint("label", "group", "valueX", i, 30, 3));
        }   
        
        // Create Evaluation Object
        EvalObject evalObject = new EvalObject("Concept Map Evaluation", 
                "Evaluates visual data analysis and reasoning", 
                dpList, 
                new HashMap<String, String>());

        
        // Add Canned Questions 
        Iterator<String> it = getCannedQuestions().iterator();
        while (it.hasNext()) {
            String question = it.next();
            evalObject.addQuestion(new Question(question, 30, "s", 0));
        }
 
        
        // Create Plugin
        ConceptMapQuestion plugin = new ConceptMapQuestion(evalObject);
        
        // test 
        evalObject.test();   
        
        return plugin;
	}

	public static QuestionBase getMindMapPlugin() {
		 // Add Datapoints
        ArrayList<Datapoint> dpList = new ArrayList<Datapoint>();
        for (int i = 0; i < 100; i++) {
        	dpList.add(new Datapoint("label", "group", "valueX", i, 30, 3));
        }   
        
        // Create Evaluation Object
        EvalObject evalObject = new EvalObject("Mind Map Evaluation", 
                "Evaluates visual data analysis and reasoning", 
                dpList, 
                new HashMap<String, String>());

        
        // Add Canned Questions 
        Iterator<String> it = getCannedQuestions().iterator();
        while (it.hasNext()) {
            String question = it.next();
            evalObject.addQuestion(new Question(question, 30, "s", 0));
        }
 
        
        // Create Plugin
        MindMapQuestion plugin = new MindMapQuestion(evalObject);
        
        // test 
        evalObject.test();   
        
        return plugin;
	}
    
}