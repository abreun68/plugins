package DataAnalysis;

import DataObject.EvalObject;
import DataObject.Question;

public class ConceptFanQuestion extends QuestionBase {

	private EvalObject eval;
	
	public ConceptFanQuestion(EvalObject eval) {
		this.eval = eval;
		
		append("Are these ideas clearly represented by the visualization?");
		append("Is the problem clearly defined in the visualization?");
		append("Are the solutions to the problems feasible?");
		append("Do the labeled lines that radiate from a circle represent denote possible solutions?");
		append("Do circles to the left of any other circle, represent solutions that are impractical, unremarkable, or do not really solve the problem?");
		append("Are arrows used from the initial problem definition to a new one, shows the linkage between the problems?");
		append("Does the visualization leads to a satisfactory solution?");
		append("Is each circle labelled?");
		append("Work associated with problem solutions, what’s better? Easier?");
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
