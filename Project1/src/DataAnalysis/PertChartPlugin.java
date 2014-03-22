/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAnalysis;

import DataObject.Evaluation;
import DataObject.Question;
import java.util.ArrayList;


/**
 * Pert Chart Plugin implementation
 * @author Nacer Abreu
 */
public class PertChartPlugin implements Plugin {

    public PertChartPlugin(Evaluation eval) {
        
        this.eval = eval;
        this.questions = eval.getQuestions();
        this.index = 0;
                
    }

    @Override
    public Question finMax() {
        // This kind of plugin do not contain min/max questions
        return null;        
    }

    @Override
    public Question findMin() {
        // This kind of plugin do not contain min/max questions
        return null;
    }

    @Override
    public Question findOutlier() {
        // This kind of plugin do not contain min/max questions
        return null;
    }

    @Override
    public Question findRecomendation() {
        // Makes sure that each time this method is called,  we get a different 
        // "recommendation" question. It will return null, after the last 
        // question is return.
        
        Question obj = null;
        if (eval.getEvalType().equalsIgnoreCase("recommendation")) {
            if (index >= 0 || questions.size() >= index) {
                obj = questions.get(index);
                index++;
            }
        }
        return obj;
    }//end of findRecomendation()

    @Override
    public Question exploration() {
        // Makes sure that each time this method is called,  we get a different 
        // "exploration" question. It will return null, after the last 
        // question is return.
        Question obj = null;
        if (eval.getEvalType().equalsIgnoreCase("exploration")) {
            if (index >= 0 || questions.size() >= index) {
                obj = questions.get(index);
                index++;
            }
        }
        return obj;
    }//end of exploration()

    @Override
    public String modifyQuestion(String question, int index, String answer) {

        if (index >= 0 || questions.size() >= index) {
            questions.get(index).setQuestion(question);
            questions.get(index).setAnswer(answer);
        }
        // Returning the string passed. Not sure why. we are mimicking here
        // what we saw in one of the examples.
        return question;

    }

    private Evaluation eval;
    private ArrayList<Question> questions;
    
    /**
     * Current Question index
     */
    private int index;

}
