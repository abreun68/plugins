package DataAnalysis;

import DataObject.EvalObject;
import DataObject.Question;

public class ConcentricCirclesQuestion extends QuestionBase {
	
	private EvalObject eval;

	public ConcentricCirclesQuestion(EvalObject eval) {
		this.eval = eval;
		
		append("What’s the total population of users?", 30, "s");					//TODO set answer
		append("What percentage is each section of total population?", 30, "s");	//TODO set answer
		append("What does the center of the circle represent?", 30, "s");
		append("What does the outer ring of the circle represent?", 30, "s");
		append("Does the number of rings have an impact on the visualization? ", 30, "s");
		append("Are the colors aiding in the understanding of the visualization?", 30, "s");
		append("Does the location of the center circles have an effect on the visualization?", 30, "s");
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
