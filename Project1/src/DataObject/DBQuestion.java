/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataObject;

/**
 *This class encapsulates all of the information needed for a eval question
 * It is created by the DB Manager class after a DB query
 * 
 * Only getter methods, once created no need to change fields
 * 
 * @author Doug Taggart
 */
public class DBQuestion implements Question 
{
    private String question;
    private int time;
    private String answerType;
    private int score;
    private String correctAnswer;
    
    
    /**
     * Constructor for the Question class
     * fields should be set when object is created
     * 
     * @param question the question
     * @param time suggested length of question 
     * @param answerType the type of response the user should give
     * @param score how other users have rated this questions
     */
    
    public DBQuestion(String question, int time, String answerType, int score)
    {
        this.question = question;
        this.time = time;
        this.answerType = answerType;
        this.score = score;
    }
    
    /**
     * Returns the eval question
     * @return question 
     */
    @Override
    public String getQuestion()
    {
        return question;
    }
    
    /**
     * Returns the time a user should be given 
     * to answer the question
     * @return time 
     */
    @Override
    public int getTime()
    {
        return time;
    }
    /**
     * this returns the type of answer a user should provide(i.e short, numerical, paragraph)
     * This can also be read as the type of question(short, long, counting)
     * @return answerType 
     */
    @Override
    public String answerType()
    {
        return answerType;
    }
    /**
     * returns the score this question has
     * (in progress)
     * @return score 
     */
    @Override
    public int getScore()
    {
        return score;
    }
    
    /**
     * Sets the correct answer to this question
     * used by classes in the DataAnalysis Package
     * @param correctAnswer 
     */
    @Override
    public void setAnswer(String correctAnswer)
    {
        this.correctAnswer = correctAnswer;
    }
    
    /**
     * returns the correct answer tot he question
     * used by whomever 
     * @return the correct answer 
     */
    @Override
    public String getAnswer()
    {
        return correctAnswer;
    }

    /**
     * Method that sets the question.
     * @param question 
     */
    @Override
    public void setQuestion(String question) {
        this.question = question;
    }
    
}
