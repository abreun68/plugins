package DataAnalysis;

import DataObject.EvalObject;
import DataObject.Question;

public class ConceptMapQuestion extends QuestionBase {

	private EvalObject eval;
	
	/**
	 * Concept Map Plugin implementation.
	 * 
	 * A concept map is a diagram that depicts suggested relationships between concepts.
	 * They typically represents ideas and information as boxes or circles, 
	 * which it connects with labeled arrows in a downward-branching hierarchical structure.
	 * 
	 * 
	 * @param eval
	 */
	public ConceptMapQuestion(EvalObject eval) {
		this.eval = eval;
		
		append("Are the most general concepts at the top of the map?", 60, "s");
		append("Are lines between concepts, labeled with the nature of the relation?  ", 60, "s");
		append("Is it clear the question we seek to answer?", 60, "s");
		append("Are there any specific examples of events or objects that help to clarify the meaning of a given concept?", 60, "s");
		append("Are the most specific concepts at the bottom of the map?", 60, "s");
		append("Are different domains of knowledge identifiable in the visualization?", 60, "s");
		append("Is color use in this visualization? If so, how is it being use?", 60, "s");
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
