package DataAnalysis;

import DataObject.EvalObject;
import DataObject.Question;

public class MindMapQuestion extends QuestionBase {

	private EvalObject eval;
	
	public MindMapQuestion(EvalObject eval) {
		this.eval = eval;
		
		append("Is the primary idea clearly defined at the center?");
		append("Is color being use to encode or group ideas?");
		append("Is line thickness being use to denote hierarchy (an outline) from the center out to the edge branches?");
		append("Does the visualization uses images, symbols and codes?");
		append("Do all lines connect back to the center?");
		append("Are branching easy to follow?");
		append("Does this visualization represent a case of digging to the root causes of a problem? Or, does it represent a summary of some information?");
	}

	@Override
	Question finMax() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	Question findMin() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	Question findOutlier() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	Question findRecomendation() {
		// TODO Auto-generated method stub
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
