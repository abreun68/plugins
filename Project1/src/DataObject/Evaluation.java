

package DataObject;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * This interface is used to abstract the actual implementation of an evaluation. 
 * @author Nacer Abreu
 */
public interface Evaluation {

    /**
     * Adds a question to th objects ArrayList of Questions
     *
     * @param question
     */
    void addQuestion(Question question);

    /**
     * returns the entire Question ArrayList
     *
     * @return questions
     */
    ArrayList<Question> getQuestions();    
    
    /**
     * Adds a question to the objects ArrayList of Datapoints
     *
     * @param datapoint
     */
    void addDatapoint(Datapoint datapoint);
    

    /**
     * returns the entire Datapoints ArrayList
     *
     * @return  datapoints
     */    
    ArrayList<Datapoint> getDatapoints();

    /**
     * Returns the type of evaluation (1 of 7)
     * 
     * 1. Evaluates environments and work practices
     * 2. Evaluates visual data analysis and reasoning 
     * 3. Evaluates communication through visualization
     * 4. Evaluates collaborative data analysis
     * 5. Evaluates user performance
     * 6. Evaluates user experience
     * 7. Automated evaluation of visualizations
     *
     * @return EvalType
     */
    String getEvalType();

    
    /**
     * NEEDS DOCUMENTATION
     *
     * @return hashmap
     */    
    HashMap<String, String> getMany2Many();

    
    /**
     * returns the title of the evaluation
     *
     * @return title
     */
    String getTitle();

    
    /**
     * This method allows the user to create a free standing question, that is
     * not part of the underlying pool of questions.
     * @param question the question
     * @param time suggested length of question 
     * @param answerType the type of response the user should give. 
     * 's' for string
     * 'i' for integer
     * 'd' for double
     * @param score how other users have rated this questions
     */
    Question buildQuestion(String question, int time, String answerType, int score);
    

    
}
