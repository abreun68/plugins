package DataAnalysis;

import DataObject.EvalObject;
import DataObject.Question;

public class TimelineQuestion extends QuestionBase {

	private EvalObject eval;
	
	public TimelineQuestion(EvalObject eval) {
		this.eval = eval;
		
		append("Who had more events in a timeframe?", 30, "s");
		append("Who had longer timeline?", 30, "s");
		append("Who had shorter timeline?", 30, "s");
		append("Is the idea of chronological sequence present in the visualization?", 30, "s");
		append("Is the timeline divided into segments?", 30, "s");
		append("Does the timeline visualization label the units of time used?", 30, "s");
		append("Does the visualization contain multiple timelines?", 30, "s");
		append("Are events stacked? If so, does it look cluttered?", 30, "s");
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
     * particular to this plugin. 
     */
    private void append(String question, int time, String type) {
        int score = 0;
        Question obj = new Question(question, time, type, score);
        eval.addQuestion(obj);

    }   
 

}
