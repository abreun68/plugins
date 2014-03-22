/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DataObject;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author nasser
 */
public interface Evaluation {

    /**
     * Adds a question to th objects ArrayList of Questions
     *
     * @param question
     */
    void addQuestion(Question question);

    ArrayList<Datapoint> getDatapoints();

    /**
     * Returns the type of evaluation (1 of 7)
     *
     * @return EvalType
     */
    String getEvalType();

    HashMap<String, String> getMany2Many();

    /**
     * returns the entire DBQuestion ArrayList
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
     * Use to print out the contents of the Eval Object
     * For Testing only
     */
    void test();
    
}
