
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
        Plugin pertChartPlugin = PluginFactory.getPertChartPlugin();

        // Simulate asking several questions 
        for (int x = 0; x < pertChartPlugin.size(); x++) {
            Question exploration = pertChartPlugin.exploration();
            String question = exploration.getQuestion();
            System.out.println(x + " - Question : " + question);
        }
    }
    
}
