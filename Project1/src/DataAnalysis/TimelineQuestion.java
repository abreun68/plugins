package DataAnalysis;

import DataObject.EvalObject;
import DataObject.Question;

public class TimelineQuestion extends QuestionBase {

	private EvalObject eval;
	
	public TimelineQuestion(EvalObject eval) {
		this.eval = eval;
		
		append("Who had more events in a timeframe?");
		append("Who had longer timeline?");
		append("Who had shorter timeline?");
		append("Is the idea of chronological sequence present in the visualization?");
		append("Is the timeline divided into segments?");
		append("Does the timeline visualization label the units of time used?");
		append("Does the visualization contain multiple timelines?");
		append("Are events stacked? If so, does it look cluttered?");
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
