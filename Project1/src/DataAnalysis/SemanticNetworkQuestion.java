package DataAnalysis;

import DataObject.EvalObject;
import DataObject.Question;

public class SemanticNetworkQuestion extends QuestionBase {

	private EvalObject eval;
	
	public SemanticNetworkQuestion(EvalObject eval) {
		this.eval = eval;
		
		append("What’s at the center of the visualization?");
		append("How many degrees are at the center visualization?");
		append("What do the outside networks represent?");
		append("Is there a relationship with the connecting nodes?");
		append("Is there a pattern in the clustering of this visualization?");
		append("Is the visualization too detailed?");
		append("What's the shortest path length of connecting nodes?");
		append("What’s the longest path length?");
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
