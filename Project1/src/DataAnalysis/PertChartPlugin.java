
package DataAnalysis;

import DataObject.Evaluation;
import DataObject.Question;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

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
        this.initialized = false;
        
        // Calling init() from the constructor is a temporary fix.
        // Ideally the plugin-user should call this routine whenever
        // it is ready to to use the plugin. Instead, of being done
        // automatically in the constructor.
        init();
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

    @Override
    public boolean init() {
        boolean accomplished = false;
        if (!initialized) {
            append("Did the tasks, in this visualization, follow a logical order?", 30, "s");
            append("Were the sub-tasks clearly labeled?", 30, "s");
            append("Was the visualization too detailed?", 30, "s");
            append("Was the critical path easy to follow?", 30, "s");
            append("Was the visualization conducive to decision making?", 30, "s");
            append("Who performed the task faster or more efficiently?", 30, "s");
            append("Did each task, or sub-task, defined a completion (duration"
                    + ") time?", 30, "s");

            // Ramdomized...humm..why not?! 
            long seed = System.nanoTime();
            Collections.shuffle(this.questions, new Random(seed));
            initialized = true;
            accomplished = true;
        }
        return accomplished;
    }
    
    /**
     * This method will append to the list of "canned" questions, the ones
     * particular to this plugin. This method makes the following assumptions:
     * 1. The time suggested length of question is 30 seconds 
     * 2. The type of answer is always a string. 
     * 3. The question is always rated as 0 (zero)
     */
    private void append(String question, int time, String type) {
        //int time = 30;
        int score = 0;
        //String type = "s";
        Question obj = eval.buildQuestion(question, time, type, score);
        questions.add(obj);

    }
    
    private Evaluation eval;
    private ArrayList<Question> questions;
    private int index; /** Current Question index */
    private boolean initialized;


}
