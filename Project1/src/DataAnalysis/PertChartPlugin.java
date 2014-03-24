
package DataAnalysis;

import DataObject.Evaluation;
import DataObject.Question;
import java.util.ArrayList;

/**
 * Pert Chart Plugin implementation
 *
 * @author Nacer Abreu
 */
public class PertChartPlugin implements Plugin {

    public PertChartPlugin(Evaluation eval) {

        this.eval = eval;
        this.questions = eval.getQuestions();
        this.index = 0;

    }

    @Override
    public Question findMax() {
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
        // This kind of plugin does not contain min/max questions
        return null;
    }

    @Override
    public Question findRecomendation() {
        // Makes sure that each time this method is called,  we get a different 
        // "recommendation" question. It will return null, after the last 
        // question is return.

        Question obj = null;
        if (eval.getEvalType().equalsIgnoreCase("recommendation")) {
            if ((this.index >= 0) && (index < questions.size())) {
                obj = questions.get(this.index);
                this.index++;
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
            if ((this.index >= 0) && (this.index < questions.size())) {
                obj = questions.get(this.index);
                this.index++;
            }
        }
        return obj;
    }//end of exploration()

    @Override
    public String modifyQuestion(String question, int index, String answer) {

        if ((index >= 0) && (index < questions.size())) {
            questions.get(index).setQuestion(question);
            questions.get(index).setAnswer(answer);
        }
        // Doug Question : Returning the string passed. Not sure why. we are 
        // Doug Question : mimicking here what we saw in one of the examples. 
        // Doug Question : Should it return a boolean instead.
        return question;
    }//end of modifyQuestion

    @Override
    public int size() {
        return questions.size();
    }
    
    
    private Evaluation eval;
    private ArrayList<Question> questions;

    /**
     * Current Question index
     */
    private int index;
}
