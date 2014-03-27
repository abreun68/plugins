package DataAnalysis;

import DataObject.EvalObject;
import DataObject.Question;

public class ConceptMapQuestion extends QuestionBase {

	private EvalObject eval;
	
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
