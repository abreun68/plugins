
package DataAnalysis;

import DataObject.Evaluation;
import DataObject.Question;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Tree Map Plugin implementation. 
 *
 * @author Nacer Abreu
 */
public class TreeMapPlugin implements Plugin {

    public TreeMapPlugin(Evaluation eval) {

        // Initialize class variables
        this.eval = eval;
        this.questions = eval.getQuestions();
        this.index = 0;
        
	append("Did the colors effectively show patterns that would otherwise not be seen?");
	append("Is there some sense of order in the input data?");
        append("Was the hierarchy easily recognizable?");
        append("Can you easily compare various nodes?");
        append("Are the borders clearly defined?");
        append("Is the visualization showing too much information?");
        append("Are you able to quickly see patterns?");
        append("Do certain nodes (rectangles) stand out?");
        append("Do items in one group have similar or divergent colors?");
        append("Is one item in a group drastically different in size or color? Why?");
        append("Can you draw any conclusions from the tree map? If so, explain");
        
        // Ramdomized...humm..why not?! 
        long seed = System.nanoTime();
        Collections.shuffle(this.questions, new Random(seed));
        
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
