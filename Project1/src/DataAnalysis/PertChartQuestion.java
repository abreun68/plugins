/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAnalysis;

import DataAnalysis.QuestionBase;
import DataObject.EvalObject;
import DataObject.Question;


/**
 * Pert Chart Plugin implementation
 * @author Nacer Abreu
 */
public class PertChartQuestion extends QuestionBase {

    public PertChartQuestion(EvalObject eval) {
        this.eval = eval;
        
        append("Did the tasks, in this visualization, follow a logical order?", 60, "s");
    	append("Were the sub-tasks clearly labeled?", 60, "s");  
    	append("Was the visualization too detailed?", 60, "s"); 
    	append("Was the critical path easy to follow?", 60, "s"); 
    	append("Was the visualization conducive to decision making?", 60, "s"); 
    	append("Who performed the task faster or more efficiently?", 60, "s");
    	append("Did each task, or sub-task, defined a completion (duration" + ") time?", 60, "s");
    }

    @Override
    public Question finMax() {
    	 // This kind of plugin does not contain min/max questions
    	return null;
    }

    @Override
    public Question findMin() {
    	 // This kind of plugin does not contain min/max questions
    	return null;
    }

    @Override
    public Question findOutlier() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Question findRecomendation() {
    	// This kind of plugin does not contain any recommendation questions
    	return null;
    }

    @Override
    public Question exploration() {
        return null;
    }

    @Override
    public String modifyQuestion(String s, int num, String l) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private EvalObject eval;
    
	/**
     * This method will append to the list of "canned" questions, the ones
     * particular to this plugin. This method makes the following assumptions:
     * 1. The time suggested length of question is 30 seconds 
     * 2. The type of answer is always a string. 
     * 3. The question is always rated as 0 (zero)
     */
	/**
     * This method will append to the list of "canned" questions, the ones
     * particular to this plugin. 
     */
    private void append(String question, int time, String type) {
        int score = 0;
        Question obj = new Question(question, time, type, score);
        eval.addQuestion(obj);

    }   

    
}
