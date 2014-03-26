package DataAnalysis;

import DataObject.EvalObject;
import DataObject.Question;

public class ConcentricCirclesQuestion extends QuestionBase {
	
	private EvalObject eval;

	public ConcentricCirclesQuestion(EvalObject eval) {
		this.eval = eval;
		
		this.eval.addQuestion(findTotal());
		this.eval.addQuestion(findPercentage());
		
		append("What does the center of the circle represent?", 60, "s");
		append("What does the outer ring of the circle represent?", 60, "s");
		append("Does the number of rings have an impact on the visualization? ", 60, "s");
		append("Are the colors aiding in the understanding of the visualization?", 60, "s");
		append("Does the location of the center circles have an effect on the visualization?", 60, "s");
	}
	
	Question findTotal() {
		double total = eval.getDatapoints().get(0).getEdges();


		//itterate through all of the datapoints find the total population
		for(int i =1; i < eval.getDatapoints().size(); i++)
		{
			total += eval.getDatapoints().get(i).getEdges();
		}
		
		//create a new question object 
		Question newQuestion = new Question("What’s the total population of users?", 60, "s", 0);
		newQuestion.setAnswer(new Double(total).toString());
		return newQuestion;
	}
	
	Question findPercentage() {
		double percent = eval.getDatapoints().get(0).getPercent();

		String answer = "[" + new Double(percent).toString();
		//itterate through all of the datapoints find the percent of each section
		for(int i =1; i < eval.getDatapoints().size(); i++)
		{
			answer += "," + eval.getDatapoints().get(i).getPercent();
		}
		answer = answer + "]";
		//create a new question object 
		Question newQuestion = new Question("What percentage is each section of total population?", 60, "s", 0);
		newQuestion.setAnswer(answer);
		return newQuestion;
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
