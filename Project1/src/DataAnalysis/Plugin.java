
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
     * 
     * @return a question about exploring the graph 
     */
    public Question exploration();
    
    
    public String modifyQuestion(String question, int index, String answer);
    
    /**     
     * 
     * 
     * @return the total number of questions in a plugin.
     */
    public int size();
}
