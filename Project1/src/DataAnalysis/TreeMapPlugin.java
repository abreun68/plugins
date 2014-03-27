
package DataAnalysis;

import DataObject.Evaluation;
import DataObject.Question;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Tree Map Plugin implementation. 
 * Treemap is a space-constrained visualization of hierarchical structures. 
 * It is very effective in showing attributes of leaf nodes using size and color
 * coding. Treemap enables users to compare nodes and sub-trees even at varying 
 * depth in the tree, and help them spot patterns and exceptions. Treemap was 
 * first designed by Ben Shneiderman during the 1990s.
 * 
 * @author Nacer Abreu
 */
public class TreeMapPlugin implements Plugin {

    public TreeMapPlugin(Evaluation eval) {

        // Initialize class variables
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
        // This kind of plugin does not contain any min/max question
        return null;
    }//end of findMax()

    @Override
    public Question findMin() {
        // This kind of plugin does not contain any min/max question
        return null;
    }//end of findMin()

    @Override
    public Question findOutlier() {
        // This kind of plugin does not contain outliers
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
    }//end of modifyQuestion()

    @Override
    public int size() {
        return questions.size();
    }

    @Override
    public boolean init() {
        boolean accomplished = false;
        if(!initialized){
        append("Did the colors effectively show patterns that would otherwise not be seen?", 60, "s");
        append("Is there some sense of order in the input data?", 30, "s");
        append("Was the hierarchy easily recognizable?", 60, "s");
        append("Can you easily compare various nodes?", 120, "s");
        append("Are the borders clearly defined?", 120, "s");
        append("Is the visualization showing too much information?", 30, "s");
        append("Are you able to quickly see patterns?", 30, "s");
        append("Do certain nodes (rectangles) stand out?", 30, "s");
        append("Do items in one group have similar or divergent colors?", 30, "s");
        append("Is one item in a group drastically different in size or color? Why?", 30, "s");
        append("Can you draw any conclusions from the tree map? If so, explain", 30, "s");

        // Ramdomized...humm..why not?! 
        long seed = System.nanoTime();
        Collections.shuffle(this.questions, new Random(seed));
        initialized = true;
        }
        return accomplished;
    }//end of init();  
    
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
