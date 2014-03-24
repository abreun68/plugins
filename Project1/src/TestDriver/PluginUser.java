package TestDriver;


import DataAnalysis.Plugin;
import DataObject.Question;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nasser
 */
public class PluginUser {

    public static void main(String [] args)
	{
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
    
}
