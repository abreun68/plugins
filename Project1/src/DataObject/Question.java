/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DataObject;

/**
 * 
 * @author Nacer Abreu
 */
public interface Question {

    /**
     * this returns the type of answer a user should provide(i.e short, numerical, paragraph)
     * This can also be read as the type of question(short, long, counting)
     * @return answerType
     */
    String answerType();

    /**
     * returns the correct answer to the question
     * used by whomever
     * @return the correct answer
     */
    String getAnswer();

    /**
     * Returns the eval question
     * @return question
     */
    String getQuestion();

    /**
     * returns the score this question has
     * (in progress)
     * @return score
     */
    int getScore();

    /**
     * Returns the time a user should be given
     * to answer the question
     * @return time
     */
    int getTime();

    /**
     * Sets the correct answer to this question
     * used by classes in the DataAnalysis Package
     * @param correctAnswer
     */
    void setAnswer(String correctAnswer);
    
     /**
     * Sets the question
     * @param question
     */
    void setQuestion(String question);
    
    
}
