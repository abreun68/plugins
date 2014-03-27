package DataAnalysis;

import DataObject.EvalObject;
import DataObject.Question;

public class SemanticNetworkQuestion extends QuestionBase {

	private EvalObject eval;
	
	public SemanticNetworkQuestion(EvalObject eval) {
		this.eval = eval;
		
		append("What’s at the center of the visualization?", 30, "s");
		append("How many degrees are at the center visualization?", 30, "s");
		append("What do the outside networks represent?", 30, "s");
		append("Is there a relationship with the connecting nodes?", 30, "s");
		append("Is there a pattern in the clustering of this visualization?", 30, "s");
		append("Is the visualization too detailed?", 30, "s");
		append("What's the shortest path length of connecting nodes?", 30, "s");
		append("What’s the longest path length?", 30, "s");
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
