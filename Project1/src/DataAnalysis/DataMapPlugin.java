
package DataAnalysis;

import DataObject.Evaluation;
import DataObject.Question;
import java.util.ArrayList;

/**
 * Data Map Plugin implementation
 *
 * @author Nacer Abreu
 */
public class DataMapPlugin implements Plugin {

    public DataMapPlugin(Evaluation eval) {

        this.eval = eval;
        this.questions = eval.getQuestions();
        this.index = 0;
        
        append("Is there a concentration in a certain location? Why?");
	append("What state/area had the most?");  
	append("What state/area had the least?"); 
	append("Is there any inconclusive data areas?"); 
	append("Does the color scale contain patterns or textures to differentiate similar shades?"); 
	append("Can the under-represented areas be easily identified?");
        append("Can the over-represented areas be easily identified?");
        append("Are the boundaries clearly delineated?");
        append("Is context provided?");
        append("Are the colors used, readable for colorblind users?");
        append("Can you draw any conclusions from the data map?");
        append("Are the colors used representatives of the data in any way? ");
        

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
        // Makes sure that each time this method is called,  we get a different 
        // "exploration" question. It will return null, after the last 
        // question is return.
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
     * 1. The time suggested length of question is 30 seconds 2. The type of
     * answer is always a string. 3. The question is always rated as 0 (zero)
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
