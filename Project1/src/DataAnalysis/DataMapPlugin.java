package DataAnalysis;

import DataObject.Evaluation;
import DataObject.Question;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Data Map Plugin implementation.
 * Choropleth maps are one of the most frequently used maps in infographic style
 * visualizations. As the name suggests, color is the important part to these 
 * maps. A color scale is assigned to categorical or numerical data, and the 
 * value for each region is used to color the region. These maps usually use 
 * political boundaries as the regions.
 * 
 * @author Nacer Abreu
 */
public class DataMapPlugin implements Plugin {

    public DataMapPlugin(Evaluation eval) {

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
        int time = 30;
        int score = 0;
        String type = "s";

        String question = "What's the percentage of most populated state/area?";
        Question obj = eval.buildQuestion(question, time, type, score);

        // Determine the maximum value in the data set
        double max = eval.getDatapoints().get(0).getValueY();

        //iterate through all of the datapoints find the min
        for (int i = 1; i < eval.getDatapoints().size(); i++) {
            if (eval.getDatapoints().get(i).getPercent() > max) {
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

    @Override
    public boolean init() {
        boolean accomplished = false;

        if (!initialized) {
            append("Is there a concentration in a certain location? Why?", 120, "s");
            append("Are there any inconclusive data areas?", 120, "s");
            append("Does the color scale contain patterns or textures to differentiate similar shades?", 120, "s");
            append("Can the under-represented areas be easily identified?", 60, "s");
            append("Can the over-represented areas be easily identified?", 60, "s");
            append("Are the boundaries clearly delineated?", 120, "s");
            append("Is context provided?", 30, "s");
            append("Are the colors used, readable for colorblind users?", 120, "s");
            append("Can you draw any conclusions from the data map?", 30, "s");
            append("Are the colors used representatives of the data in any way?", 120, "s");

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
    private int index;
    private boolean initialized; /* Current Question index */
}
