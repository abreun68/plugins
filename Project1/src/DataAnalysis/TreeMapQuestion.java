package DataAnalysis;

import DataObject.EvalObject;
import DataObject.Question;

public class TreeMapQuestion extends QuestionBase {


	private EvalObject eval;
	 
	public TreeMapQuestion(EvalObject eval) {
		
		this.eval = eval;
		
		append("Did the colors effectively show patterns that would otherwise not be seen?");
		append("Is there some sense of order in the input data?");
		append("Was the hierarchy easily recognizable?");
		append("Can you easily compare various nodes?");
		append("Are the borders clearly defined?");
		append("Is the visualization showing too much information?");
		append("Are you able to quickly see patterns?");
		append("Do certain nodes (rectangles) stand out?");
		append("Do items in one group have similar or divergent colors?");
		append("Is one item in a group drastically different in size or color? Why?");
		append("Can you draw any conclusions from the tree map? If so, explain");
	}

	@Override
	Question finMax() {
		  // This kind of plugin does not contain any min/max question
        return null;
	}

	@Override
	Question findMin() {
		  // This kind of plugin does not contain any min/max question
        return null;
	}

	@Override
	Question findOutlier() {
		 // This kind of plugin does not contain outliers
		return null;
	}

	@Override
	Question findRecomendation() {
		// This kind of plugin does not contain any recommendation questions
		return null;
	}

	@Override
	Question exploration() {
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
     * particular to this plugin. This method makes the following assumptions:
     * 1. The time suggested length of question is 30 seconds 
     * 2. The type of answer is always a string. 
     * 3. The question is always rated as 0 (zero)
     */
    private void append(String question) {
        int time = 30;
        int score = 0;
        String type = "s";
        Question obj = new Question(question, time, type, score);
        this.eval.addQuestion(obj);

    }    

}
