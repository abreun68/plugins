/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAnalysis;

import DataObject.Datapoint;
import DataObject.Question;
import DataObject.Evaluation;
import java.util.ArrayList;


/**
 * Pert Chart Plugin implementation
 * @author Nacer Abreu
 */
public class PertChartPlugin implements Plugin {

    public PertChartPlugin(Evaluation eval) {
        
        this.eval = eval;
        this.questions = eval.getQuestions();
        
                
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Question exploration() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String modifyQuestion(String s, int num, String l) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private Evaluation eval;
    private ArrayList<Question> questions;

}
