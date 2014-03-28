
package DataAnalysis;

import DataObject.Evaluation;
import DataObject.Question;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Pert Chart Plugin implementation.
 * The Program (or Project) Evaluation and Review Technique, commonly 
 * abbreviated PERT, is a statistical tool, used in project management, that is 
 * designed to analyze and represent the tasks involved in completing a given 
 * project. First developed by the United States Navy in the 1950s, it is 
 * commonly used in conjunction with the critical path method (CPM).
 *
 * @author Nacer Abreu
 */
public class PertChartPlugin implements Plugin {

        /**
     * Constructor. 
     * @param eval Object used to interact with the underlying data-points and 
     * questions data structures. 
     */
    public PertChartPlugin(Evaluation eval) {

        this.eval = eval;
        this.questions = eval.getQuestions();
        this.index = 0;
        this.initialized = false;
        
        // Calling init() from the constructor is a temporary fix.
        // Ideally the user of the plugin should call this routine once, before
        // it is ready to to use the plugin, instead, of being done
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
     * particular to this plugin. This method makes the following assumption(s):
     * 1. The question is always rated as 0 (zero)
     */
    private void append(String question, int time, String type) {
        int score = 0;
        Question obj = eval.buildQuestion(question, time, type, score);
        questions.add(obj);
    }//end of append()
    
    private Evaluation eval;
    private ArrayList<Question> questions;
    private int index; /** Current Question index */
    private boolean initialized;


}
