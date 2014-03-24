

package DataObject;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
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
     * Adds a question to th objects ArrayList of Datapoints
     *
     * @param datapoint
     */
    void addDatapoint(Datapoint datapoint);
    
    
    ArrayList<Datapoint> getDatapoints();

    /**
     * Returns the type of evaluation (1 of 7)
     *
     * @return EvalType
     */
    String getEvalType();

    HashMap<String, String> getMany2Many();

    /**
     * returns the entire Question ArrayList
     *
     * @return questions
     */
    ArrayList<Question> getQuestions();

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
