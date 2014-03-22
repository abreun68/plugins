/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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
 * @author Dooug Taggart
 */
public interface Plugin
{
    
    /**
     * 
     * @return a question about a max value on the graph
     */
    public Question finMax( );
    
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
     * 
     * 
     * @return a question asking a user to recommend something  
     */
    public Question findRecomendation(); 
    
    /**
     * 
     * @return a question about exploring the graph 
     */
    public Question exploration();
    
    
    public String modifyQuestion(String s, int num, String l);
    
    
}
