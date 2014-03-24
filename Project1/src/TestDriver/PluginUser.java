package TestDriver;


import DataAnalysis.Plugin;
import DataObject.Question;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Test Driver.
 * @author Nacer Abreu
 */
public class PluginUser {

    public static void main(String[] args) {
        // pertChartTest();
        // dataMapTest();
        parallelCoordinatesTest();
    }

    public static void pertChartTest() {
        System.out.println("Pert Chart -- Questions");
        System.out.println("=======================\n");
        Plugin pertChartPlugin = PluginFactory.getPertChartPlugin();
        // Simulate asking several questions

        for (int x = 0; x < pertChartPlugin.size(); x++) {
            Question exploration = pertChartPlugin.exploration();
            String question = exploration.getQuestion();
            System.out.println(x + " - Question : " + question);
        }

        System.out.println("\n=======================\n\n");
    }

    public static void dataMapTest() {
        System.out.println("Data Map   -- Questions");
        System.out.println("=======================\n");
        Plugin dataMapPlugin = PluginFactory.getDataMapPlugin();
        // Simulate asking several questions

        for (int x = 0; x < dataMapPlugin.size(); x++) {
            Question exploration = dataMapPlugin.exploration();
            String question = exploration.getQuestion();
            System.out.println(x + " - Question : " + question);
        }

        System.out.println("\n=======================\n\n");
    }
    
    public static void parallelCoordinatesTest() {
        System.out.println(" Parallel Coordinates -- Questions");
        System.out.println("=======================\n");
        Plugin parallelCoordinatesPlugin = PluginFactory.getParallelCoordinatesPlugin();
        // Simulate asking several questions

        for (int x = 0; x < parallelCoordinatesPlugin.size(); x++) {
            Question exploration = parallelCoordinatesPlugin.exploration();
            String question = exploration.getQuestion();
            System.out.println(x + " - Question : " + question);
        }
        
        Question exploration = parallelCoordinatesPlugin.findMax();
        String question = exploration.getQuestion();
        System.out.println("findmax - Question : " + question);        

        
        exploration = parallelCoordinatesPlugin.findMin();
        question = exploration.getQuestion();
        System.out.println("findmin - Question : " + question);  
        
        
        System.out.println("\n=======================\n\n");
    }
}
