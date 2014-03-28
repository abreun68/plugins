package DataAnalysis;

import DataObject.EvalObject;
import DataObject.Question;

public class MindMapQuestion extends QuestionBase {

	private EvalObject eval;
	
	/**
	 * Mind Map Plugin implementation
	 * 
	 * A mind map is a diagram used to visually outline information. 
	 * They are often created around a single word or text, placed in the center,
	 * to which associated ideas, words and concepts are added. Major categories 
	 * radiate from a central node, and lesser categories are sub-branches of 
	 * larger branches. Categories can represent words, ideas, tasks, or other 
	 * items related to a central key word or idea.
	 * 
	 * @param eval
	 */
	public MindMapQuestion(EvalObject eval) {
		this.eval = eval;
		
		append("Is the primary idea clearly defined at the center?", 60, "s");
		append("Is color being use to encode or group ideas?", 60, "s");
		append("Is line thickness being use to denote hierarchy (an outline) from the center out to the edge branches?", 60, "s");
		append("Does the visualization uses images, symbols and codes?", 60, "s");
		append("Do all lines connect back to the center?", 60, "s");
		append("Are branching easy to follow?", 60, "s");
		append("Does this visualization represent a case of digging to the root causes of a problem? Or, does it represent a summary of some information?", 60, "s");
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
