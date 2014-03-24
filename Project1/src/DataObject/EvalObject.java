/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataObject;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *Class EvalObject holds all information about an evaluation setup
 * Information in this Class is given to the user 
 * @author Doug Taggart
 */
public class EvalObject implements Evaluation
{

    private String title;
    private String EvalType;
    private ArrayList<Question> questions; 
    private ArrayList<Datapoint> datapoints;
    private HashMap<String, String> many2many;
    
    /**
     * Constructor for creating the EVal Object
     * @param title the name of the evaluation
     * @param EvalType the type of evaluation
     */
    public EvalObject(String title, String EvalType, ArrayList<Datapoint> datapoint, HashMap<String, String> m2m)
    {
        this.title = title;
        this.EvalType = EvalType;
        questions = new ArrayList<Question>();
        this.datapoints = datapoint;
        many2many = m2m;
        
    }
    /**
     * returns the title of the evaluation
     * 
     * @return title 
     */
    @Override
    public String getTitle()
    {
        return title;
    }
    
    /**
     * Returns the type of evaluation (1 of 7)
     * 
     * @return EvalType
     */
    @Override
    public String getEvalType()
    {
        return EvalType;
    }
    
    /**
     * Adds a question to th objects ArrayList of Questions
     * 
     * @param question 
     */
    @Override
    public void addQuestion(Question question)
    {
        questions.add(question);
    }
    
    @Override
    public HashMap<String, String> getMany2Many()
    {
        return many2many;
    }
    
    
    /**
     * returns the entire DBQuestion ArrayList
     * 
     * @return questions 
     */
    @Override
    public ArrayList<Question> getQuestions()
    {
        return questions;
    }
    
    @Override
    public ArrayList<Datapoint> getDatapoints()
    {
        return datapoints;
    }
    
    
    /**
     * Use to print out the contents of the Eval Object
     * For Testing only
     */

    public void test()
    {
        System.out.println("title: " + this.title);
        System.out.println("Evaluation Type: " + this.EvalType);
        
        if(questions.isEmpty())
        { 
            System.out.println("Evaluation does not have any questions");
        }        
        else
        {
          for(int i =0; i < this.questions.size(); i++)
          {
              System.out.println((i+1) +": " + questions.get(i).getQuestion());
          }
        }
        
        
    }

    @Override
    public Question buildQuestion(String question, int time, String answerType, int score) {
        return new EvalQuestion(question, time, answerType, score);
    }

    @Override
    public void addDatapoint(Datapoint datapoint) {
        datapoints.add(datapoint);
    }
    
}
