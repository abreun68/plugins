
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
 * implementation were supposed to extend. The decision to change it to an 
 * interface is based on the fact that the class didn't implement any behavior,
 * for the subclasses to inherit.
 */
public interface Plugin
{
    
    /**
     * This method returns a question regarding single points that represent
     * the maximum values of the datasets.
     * 
     * @return a question about a max value on the graph
     */
    public Question findMax( );
    
    /**
     * This method returns a question regarding single points that represent 
     * the minimum values of the datasets.
     * 
     * @return a question about a minimum value on the graph   
     */
    public Question  findMin();
    
    /**
     * This method returns a question regarding single points that are not 
     * representative of 99% of the dataset. ”Outlier” is a scientific term to 
     * describe things or phenomena that lie outside normal experience.”
     * 
     * @return a question about an outlier 
     */
    public Question findOutlier();
    
    /**
     * This methods returns a question that uses random single points from the 
     * dataset to explore the visualization. For example,  typical 
     * recommendation questions would look like this : 
     * "If i purchased 'X', what other things might I be intrusted in?" 
     * So each time a call in made to this method, it should pick a different 
     * value to base the recommendations on. 
     * 
     * @return a question asking a user to recommend something  
     */
    public Question findRecomendation(); 
    
    /**
     * This method returns a question that can be specific to this plugin or
     * one of the generic ("canned") question from the underlying database.
     * Each time it is called, it will return a different question, up to the 
     * number of available question for this plugin (size). Once this number 
     * of calls are issue, the method returns null values. 
     * 
     * @return a question about exploring the graph 
     */
    public Question exploration();
    
    /**
     * This method is use to modify any of the exploration, or specific,
     * question related to this plugin. 
     * @param question The new question
     * @param index Position in the data structure of the plugin that will be 
     * modified.
     * @param answer
     * @return the inputed string question.
     */
    public String modifyQuestion(String question, int index, String answer);
    
    
    /**     
     * This method returns the total number of questions for this plugin. It is
     * important that when making calls to the exploration method we do not go 
     * beyond this size, since the returns after that it will be nulls.
     * 
     * @return the total number of questions in a plugin.
     */
    public int size();
    
    
     /**     
     * This method is used to call the initialize process of the plugin. 
     * 
     */
    public boolean init();
    
}
