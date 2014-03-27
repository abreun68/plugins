
package DataAnalysis;

import DataObject.Evaluation;
import DataObject.Question;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 *  Parallel Coordinates Plugin implementation
 *
 * @author Nacer Abreu
 */
public class ParallelCoordinatesPlugin implements Plugin {

    public ParallelCoordinatesPlugin(Evaluation eval) {

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
        double max = eval.getDatapoints().get(0).getValueY();
        
        //iterate through all of the datapoints find the min
        for(int i =1; i < eval.getDatapoints().size(); i++)
        {
        
            if( eval.getDatapoints().get(i).getValueY() > max)
            {
                max = eval.getDatapoints().get(i).getValueY();
            }            
        }       
        //create a new question object 
        Question newQuestion = eval.buildQuestion("What is the maximum Y value?", 30, "s", 0);
        newQuestion.setAnswer(new Double(max).toString());
        return newQuestion;
    }

    @Override
    public Question findMin() {
        double min = eval.getDatapoints().get(0).getValueY();
        
        //iterate through all of the datapoints find the min
        for(int i =1; i < eval.getDatapoints().size(); i++)
        {
        
            if( eval.getDatapoints().get(i).getValueY() < min)
            {
                min = eval.getDatapoints().get(i).getValueY();
            }            
        }       
        //create a new question object 
        Question newQuestion = eval.buildQuestion("What is the minimum Y value?", 30, "s", 0);
        newQuestion.setAnswer(new Double(min).toString());
        return newQuestion;
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
    }//end of modifyQuestion()

    @Override
    public int size() {
        return questions.size();
    }
    
    @Override
    public boolean init() {
        boolean accomplished = false;
        if (!initialized) {
            append("Is there a pattern to the visualization?", 60, "s");
            append("Was there an event that caused this?", 30, "s");
            append("Does the number of entries make the visualization harder to interpret?", 120, "s");
            append("Does the number of columns make the visualization harder to interpret?", 30, "s");

            // Ramdomized...humm..why not?! 
            long seed = System.nanoTime();
            Collections.shuffle(this.questions, new Random(seed));
            initialized = true;
            accomplished = true;
        }
        return accomplished;
    }//end of init()
    
    /**
     * This method will append to the list of "canned" questions, the ones
     * particular to this plugin. This method makes the following assumptions:
     * 1. The time suggested length of question is 30 seconds 
     * 2. The type of answer is always a string. 
     * 3. The question is always rated as 0 (zero)
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
