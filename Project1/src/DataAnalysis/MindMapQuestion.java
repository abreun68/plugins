package DataAnalysis;

import DataObject.EvalObject;
import DataObject.Question;

public class MindMapQuestion extends QuestionBase {

	private EvalObject eval;
	
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

	@Override
	public Question finMax() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Question findMin() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Question findOutlier() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Question findRecomendation() {
		// TODO Auto-generated method stub
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
