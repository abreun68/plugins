package TestDriver;


import DataAnalysis.Plugin;
import DataObject.Question;

/**
 * This class is for TESTING PURPOSES ONLY. It is suppose to simulate a user of
 * the plugin.
 * @author Nacer Abreu
 */
public class PluginUser {

    public static void main(String[] args) {
         //pertChartTest();
         dataMapTest();
         //parallelCoordinatesTest();
    }

    public static void pertChartTest() {
        System.out.println("Pert Chart -- Questions");
        System.out.println("=======================\n");
        Plugin plugin = PluginFactory.getPertChartPlugin();
        callExplorationMethod(plugin);
    }

    public static void dataMapTest() {
        System.out.println("Data Map   -- Questions");
        System.out.println("=======================\n");
        Plugin plugin = PluginFactory.getDataMapPlugin();
        callExplorationMethod(plugin);
    }
    
    public static void parallelCoordinatesTest() {
        System.out.println(" Parallel Coordinates -- Questions");
        System.out.println("=======================\n");
        Plugin plugin = PluginFactory.getParallelCoordinatesPlugin();
        callExplorationMethod(plugin);
        
        Question maxQuestion = plugin.findMax();
        String question = maxQuestion.getQuestion();
        
        if (question != null) {
            System.out.println("findmax - Question : " + question);        
        }
        
        Question minQuestion = plugin.findMin();
        question = minQuestion.getQuestion();
        if (question != null) {
            System.out.println("findmin - Question : " + question);
        }
        
        System.out.println("\n=======================\n\n");
    }
    
    /**
     * This method simulates calling the Plugin::exploration() method
     */
    private static void callExplorationMethod(Plugin plugin) {
        
        for (int x = 0; x < plugin.size(); x++) {
            Question exploration = plugin.exploration();
            String question = exploration.getQuestion();
            System.out.println(x + " - Question : " + question);
        }

        System.out.println("\n=======================\n\n");
    }
    

}
