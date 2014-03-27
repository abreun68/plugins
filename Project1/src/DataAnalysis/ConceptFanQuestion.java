package DataAnalysis;

import DataObject.EvalObject;
import DataObject.Question;

public class ConceptFanQuestion extends QuestionBase {

	private EvalObject eval;
	
	public ConceptFanQuestion(EvalObject eval) {
		this.eval = eval;
		
		append("Are these ideas clearly represented by the visualization?", 30, "s");
		append("Is the problem clearly defined in the visualization?", 30, "s");
		append("Are the solutions to the problems feasible?", 30, "s");
		append("Do the labeled lines that radiate from a circle represent denote possible solutions?", 30, "s");
		append("Do circles to the left of any other circle, represent solutions that are impractical, unremarkable, or do not really solve the problem?", 30, "s");
		append("Are arrows used from the initial problem definition to a new one, shows the linkage between the problems?", 30, "s");
		append("Does the visualization leads to a satisfactory solution?", 30, "s");
		append("Is each circle labelled?", 30, "s");
		append("Work associated with problem solutions, what’s better? Easier?", 30, "s");
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
