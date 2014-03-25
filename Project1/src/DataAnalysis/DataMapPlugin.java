
package DataAnalysis;

import DataObject.Evaluation;
import DataObject.Question;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Data Map Plugin implementation. 
 *
 * @author Nacer Abreu
 */
public class DataMapPlugin implements Plugin {

    public DataMapPlugin(Evaluation eval) {

        this.eval = eval;
        this.questions = eval.getQuestions();
        this.index = 0;
        
        append("Is there a concentration in a certain location? Why?"); 
	append("Are there any inconclusive data areas?"); 
	append("Does the color scale contain patterns or textures to differentiate similar shades?"); 
	append("Can the under-represented areas be easily identified?");
        append("Can the over-represented areas be easily identified?");
        append("Are the boundaries clearly delineated?");
        append("Is context provided?");
        append("Are the colors used, readable for colorblind users?");
        append("Can you draw any conclusions from the data map?");
        append("Are the colors used representatives of the data in any way? ");
        
        // Ramdomized...humm..why not?! 
        long seed = System.nanoTime();
        Collections.shuffle(this.questions, new Random(seed));
    }

    @Override
    public Question findMax() {
        int time = 30;
        int score = 0;
        String type = "s";
        
        String question = "What's the percentage of most populated state/area?";
        Question obj = eval.buildQuestion(question, time, type, score);
        
        // Determine the maximum value in the data set
        double max = eval.getDatapoints().get(0).getValueY();
        
        //iterate through all of the datapoints find the min
        for(int i =1; i < eval.getDatapoints().size(); i++)
        {
            if( eval.getDatapoints().get(i).getPercent() > max)
            {
                max = eval.getDatapoints().get(i).getPercent();
            }            
        } 
        obj.setAnswer(Double.toString(max));
        return obj;
    }//end of findMax()

    @Override
    public Question findMin() {
        int time = 30;
        int score = 0;
        String type = "s";
        String question = "What's the percentage of the least populated state/area?";
        Question obj = eval.buildQuestion(question, time, type, score);
        
        // Determine the minimum value in the data set
        double min = eval.getDatapoints().get(0).getValueY();

        //iterate through all of the datapoints find the min
        for (int i = 1; i < eval.getDatapoints().size(); i++) {

            if (eval.getDatapoints().get(i).getValueY() < min) {
                min = eval.getDatapoints().get(i).getValueY();
            }
        }
        obj.setAnswer(Double.toString(min));
        return obj;
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
