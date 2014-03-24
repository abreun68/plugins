
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
        
        append("Did the tasks, in this visualization, follow a logical order?");
	append("Were the sub-tasks clearly labeled?");  
	append("Was the visualization too detailed?"); 
	append("Was the critical path easy to follow?"); 
	append("Was the visualization conducive to decision making?"); 
	append("Who performed the task faster or more efficiently?");
        append("Did each task, or sub-task, defined a completion (duration" + 
                ") time?");
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
        // This kind of plugin does not contain any recommendation questions
        return null;
    }//end of findRecomendation()

    @Override
    public Question exploration() {
        
        Question obj = null;
        if ((this.index >= 0) && (this.index < questions.size())) {
            obj = questions.get(this.index);
            this.index++;
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
        // Doug Question : mimicking here, what we saw in one of the examples. 
        // Doug Question : Should it return a boolean instead?
        return question;
    }//end of modifyQuestion

    @Override
    public int size() {
        return questions.size();
    }
    
    /**
     * This method will append to the list of "canned" questions, the ones
     * particular to this plugin. This method makes the following assumptions:
     * 1. The time suggested length of question is 30 seconds 
     * 2. The type of answer is always a string. 
     * 3. The question is always rated as 0 (zero)
     */
    private void append(String question) {
        int time = 30;
        int score = 0;
        String type = "s";
        Question obj = eval.buildQuestion(question, time, type, score);
        questions.add(obj);

    }
    
    private Evaluation eval;
    private ArrayList<Question> questions;

    /**
     * Current Question index
     */
    private int index;
}
