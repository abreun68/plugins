package DataAnalysis;

import DataObject.EvalObject;
import DataObject.Question;

public class TreeMapQuestion extends QuestionBase {


	private EvalObject eval;
	 
	public TreeMapQuestion(EvalObject eval) {
		
		this.eval = eval;
		
		append("Did the colors effectively show patterns that would otherwise not be seen?", 30, "s");
		append("Is there some sense of order in the input data?", 30, "s");
		append("Was the hierarchy easily recognizable?", 30, "s");
		append("Can you easily compare various nodes?", 30, "s");
		append("Are the borders clearly defined?", 30, "s");
		append("Is the visualization showing too much information?", 30, "s");
		append("Are you able to quickly see patterns?", 30, "s");
		append("Do certain nodes (rectangles) stand out?", 30, "s");
		append("Do items in one group have similar or divergent colors?", 30, "s");
		append("Is one item in a group drastically different in size or color? Why?", 30, "s");
		append("Can you draw any conclusions from the tree map? If so, explain", 30, "s");
	}

	@Override
	public Question finMax() {
		  // This kind of plugin does not contain any min/max question
        return null;
	}

	@Override
	public Question findMin() {
		  // This kind of plugin does not contain any min/max question
        return null;
	}

	@Override
	public Question findOutlier() {
		 // This kind of plugin does not contain outliers
		return null;
	}

	@Override
	public Question findRecomendation() {
		// This kind of plugin does not contain any recommendation questions
		return null;
	}

	@Override
	public Question exploration() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	String modifyQuestion(String s, int num, String l) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
     * This method will append to the list of "canned" questions, the ones
     * particular to this plugin. 
     */
    private void append(String question, int time, String type) {
        int score = 0;
        Question obj = new Question(question, time, type, score);
        eval.addQuestion(obj);

    }   
   

}
