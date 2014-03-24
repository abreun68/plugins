
package DataAnalysis;

import DataObject.Question;


/**
 * All VizTool Specific Questions extend this class
 * This Class has the base methods for finding:
 * Outlier Questions
 * Recommendation Questions
 * Min Questions
 * Max Questions
 * 
 * @author Doug Taggart
 */
/** 
 * This was originally the "QuestionBase" abstract class, which "plugins" 
 * implementation were suppose to extend. The decision to change it to an 
 * interface is based on the fact that the class didn't implement any behavior,
 * for the subclasses to inherit.
 */
public interface Plugin
{
    
    /**
     * 
     * @return a question about a max value on the graph
     */
    public Question findMax( );
    
    /**
     * 
     * @return a question about a minimum value on the graph   
     */
    public Question  findMin();
    
    /**
     * 
     * @return a question about an outlier 
     */
    public Question findOutlier();
    
    /**
     * A typical recommendation questions would look like this : 
     * "If i purchased X what other things might I be intrusted in?" 
     * So each time you generate a recommendation question it should pick a 
     * different value to base the recommendations on. 
     * 
     * @return a question asking a user to recommend something  
     */
    public Question findRecomendation(); 
    
    /**
     * This method returns a question that can be specific to this plugin or
     * one of the generic ("canned") question from the underlying database.
     * Each time it is called, it will return a different question, up to the 
     * number of available question for this plugin (size). Once this number 
     * of calls are issue, the method return null values. 
     * @return a question about exploring the graph 
     */
    public Question exploration();
    
    /**
     * This method is use to modify any of the exploration or specific question 
     * related to this plugin. 
     * @param question
     * @param index
     * @param answer
     * @return 
     */
    public String modifyQuestion(String question, int index, String answer);
    
    /**     
     * This method returns the total number of questions for this plugin. It is
     * important that when making calls to the exploration method we do not go 
     * beyond this size since the return after that it will return null.
     * @return the total number of questions in a plugin.
     */
    public int size();
}
