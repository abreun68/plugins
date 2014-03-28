package DataAnalysis;

import DataObject.EvalObject;
import DataObject.Question;

public class ConceptFanQuestion extends QuestionBase {

	private EvalObject eval;
	
	/**
	 * Concept Fan Plugin implementation.
	 * 
	 * Concept fans are a technique for taking a step back to 
	 * get a broader perspective and thereby a new view of the 
	 * subject, what you want to achieve and new ways of solving 
	 * the problem.
	 * 
	 * @param eval
	 */
	public ConceptFanQuestion(EvalObject eval) {
		this.eval = eval;
		
		append("Are these ideas clearly represented by the visualization?", 60, "s");
		append("Is the problem clearly defined in the visualization?", 60, "s");
		append("Are the solutions to the problems feasible?", 60, "s");
		append("Do the labeled lines that radiate from a circle represent denote possible solutions?", 60, "s");
		append("Do circles to the left of any other circle, represent solutions that are impractical, unremarkable, or do not really solve the problem?", 60, "s");
		append("Are arrows used from the initial problem definition to a new one, shows the linkage between the problems?", 60, "s");
		append("Does the visualization leads to a satisfactory solution?", 60, "s");
		append("Is each circle labelled?", 60, "s");
		append("Work associated with problem solutions, what's better? Easier?", 60, "s");
	}

	/**
	 * This method returns a question and answer about the 
	 * maximum value on the current graph.
     * 
     * @return a question about a maximum value on the graph   
     */
	@Override
	public Question finMax() {
		// This kind of plugin does not contain min/max questions
		return null;
	}

	/**
	 * This method returns a question and answer about the 
	 * minimum value on the current graph.
     * 
     * @return a question about a minimum value on the graph   
     */
	@Override
	public Question findMin() {
		 // This kind of plugin does not contain min/max questions
		return null;
	}

    /**
     * This method returns a question and answer about the 
	 * any outlier values on the current graph.
     * 
     * @return a question about an outlier 
     */
	@Override
	public Question findOutlier() {
		// This kind of plugin does not contain outliers
		return null;
	}

    /**
     * This method returns a question and answer about the 
	 * any recommendations based on the current graph.
     * 
     * @return a question asking a user to recommend something  
     */
	@Override
	public Question findRecomendation() {
		// This kind of plugin does not contain any recommendation questions
		return null;
	}

	/**
     * 
     * This method returns a question about the 
	 * exploring the current graph.
	 * 
     * @return a question about exploring the graph 
     */
	@Override
	public Question exploration() {
		// This kind of plugin does not contain any exploration questions
		return null;
	}

	@Override
	String modifyQuestion(String s, int num, String l) {

		s = s.substring(0, s.indexOf("blank"));

		return s;
	}
	
    /**
     * This method will append to the list of "canned" questions, the ones
     * particular to this plugin. This method makes the following assumption(s):
     * 1. The question is always rated as 0 (zero)
     */
    private void append(String question, int time, String type) {
        int score = 0;
        Question obj = new Question(question, time, type, score);
        eval.addQuestion(obj);

    }   


}
