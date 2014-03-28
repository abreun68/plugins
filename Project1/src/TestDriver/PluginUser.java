package TestDriver;


import DataAnalysis.PertChartQuestion;
import DataAnalysis.QuestionBase;
import DataAnalysis.TreeMapQuestion;
import DataObject.Question;

/**
 * This class is for TESTING PURPOSES ONLY. It is suppose to simulate a user of
 * the plugin.
 * @author Nacer Abreu
 */
public class PluginUser {

    public static void main(String[] args) {
         pertChartTest();
         dataMapTest();
         treeMapTest();
         parallelCoordinatesTest();
         
         concentricCiclesTest();
         conceptFanTest();
         conceptMapTest();
         mindMapTest();
    }

    public static void pertChartTest() {
        System.out.println("Pert Chart -- Questions");
        System.out.println("=======================\n");
        PertChartQuestion plugin = PluginFactory.getPertChartPlugin();
        callExplorationMethod(plugin);
        callFindMinMaxMethod(plugin);
        System.out.println("\n=======================\n\n");
    }

    public static void dataMapTest() {
        System.out.println("Data Map -- Questions");
        System.out.println("=======================\n");
        QuestionBase plugin = PluginFactory.getDataMapPlugin();
        callExplorationMethod(plugin);
        callFindMinMaxMethod(plugin);
        System.out.println("\n=======================\n\n");
    }
    
    public static void treeMapTest() {
        System.out.println("Tree Map -- Questions");
        System.out.println("=======================\n");
        TreeMapQuestion plugin = PluginFactory.getTreeMapPlugin();
        callExplorationMethod(plugin);
        callFindMinMaxMethod(plugin);
        System.out.println("\n=======================\n\n");
    }
    
    
    public static void parallelCoordinatesTest() {
        System.out.println(" Parallel Coordinates -- Questions");
        System.out.println("=======================\n");
        QuestionBase plugin = PluginFactory.getParallelCoordinatesPlugin();
        callExplorationMethod(plugin);
        callFindMinMaxMethod(plugin);        
        System.out.println("\n=======================\n\n");
    }
    
    public static void concentricCiclesTest() {
        System.out.println(" Concentric Circles -- Questions");
        System.out.println("=======================\n");
        QuestionBase plugin = PluginFactory.getConcentricCirclePlugin();
        callExplorationMethod(plugin);
        callFindMinMaxMethod(plugin);        
        System.out.println("\n=======================\n\n");
    }
    
    public static void conceptFanTest() {
        System.out.println(" Concept Fan -- Questions");
        System.out.println("=======================\n");
        QuestionBase plugin = PluginFactory.getConceptFanPlugin();
        callExplorationMethod(plugin);
        callFindMinMaxMethod(plugin);        
        System.out.println("\n=======================\n\n");
    }
    
    public static void conceptMapTest() {
        System.out.println(" Concept Map -- Questions");
        System.out.println("=======================\n");
        QuestionBase plugin = PluginFactory.getConceptMapPlugin();
        callExplorationMethod(plugin);
        callFindMinMaxMethod(plugin);        
        System.out.println("\n=======================\n\n");
    }
    
    public static void mindMapTest() {
        System.out.println(" Mind Map -- Questions");
        System.out.println("=======================\n");
        QuestionBase plugin = PluginFactory.getMindMapPlugin();
        callExplorationMethod(plugin);
        callFindMinMaxMethod(plugin);        
        System.out.println("\n=======================\n\n");
    }
    
    /**
     * This method simulates calling the Plugin::exploration() method
     */
    private static void callExplorationMethod(QuestionBase plugin) {
        

            Question exploration = plugin.exploration();
            if(exploration != null) {
            	String question = exploration.getQuestion();
            	System.out.println("Question : " + question);
            }

        
    }
    
        /**
     * This method simulates calling the Plugin::findMin() and Plugin::findMax()
     * method
     */
    private static void callFindMinMaxMethod(QuestionBase plugin) {
        
            Question question = plugin.findMin();
            
            if (question != null){
              System.out.println("Question : " + question.getQuestion() + "; Answer: " + question.getAnswer());  
            }
            
            question = plugin.finMax();
            
            if (question != null){
              System.out.println("Question : " + question.getQuestion() + "; Answer: " + question.getAnswer());  
            }
        
    }

}