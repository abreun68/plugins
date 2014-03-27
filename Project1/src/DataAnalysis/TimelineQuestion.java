package DataAnalysis;

import DataObject.EvalObject;
import DataObject.Question;

public class TimelineQuestion extends QuestionBase {

	private EvalObject eval;
	
	public TimelineQuestion(EvalObject eval) {
		this.eval = eval;
		
		append("Who had more events in a timeframe?", 30, "s");
		append("Is the idea of chronological sequence present in the visualization?", 30, "s");
		append("Is the timeline divided into segments?", 30, "s");
		append("Does the timeline visualization label the units of time used?", 30, "s");
		append("Does the visualization contain multiple timelines?", 30, "s");
		append("Are events stacked? If so, does it look cluttered?", 30, "s");
	}

	@Override
	Question finMax() {
		Question newQuestion = new Question( "Who has the longest timeline?", 30, "s", 0);
		double max           = eval.getDatapoints().get(0).getValueY();
		double temp_max      = 0.0;
		int size             = eval.getDatapoints().size();
		
		for( int i = 1; i < size; i++ )
		{
			temp_max = eval.getDatapoints().get(i).getValueY();
			
			if( temp_max > max )
			{
				max = temp_max;
			}
		}
		
		newQuestion.setAnswer(new Double(max).toString());
		return newQuestion;
	}

	@Override
	Question findMin() {
		Question newQuestion = new Question("Who has the shortest timeline?", 30, "s", 0);
		double min           = eval.getDatapoints().get(0).getValueY();
		double temp_min      = 0.0;
		int size             = eval.getDatapoints().size();
		
		for( int i = 1; i < size; i++ )
		{
			temp_min = eval.getDatapoints().get(i).getValueY();
			
			if( temp_min < min )
			{
				min = temp_min;
			}
		}
		
		newQuestion.setAnswer(new Double(min).toString());
		return newQuestion;
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
