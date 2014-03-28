package DataAnalysis;

import DataObject.EvalObject;
import DataObject.Question;

/**
 * Concentric Circles Plugin implementation.
 * 
 * Concentric circles are circles with a common center. The region 
 * between two concentric circles of different radii is called an annulus. 
 * Any two circles can be made concentric by inversion by picking the 
 * inversion center as one of the limiting points.
 * 
 * 
 */
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
	
	/**
	 * This method returns a question and answer about the total
	 * population of the whole circle.
	 * 
	 * @return a question about the total population of the circles
	 */
	public Question findTotal() {
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
	
	/**
	 * This method returns a question and answer about the percentage
	 * of each section.
	 * 
	 * @return a question about the percentage of the circles
	 */
	public Question findPercentage() {
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

	/**
	 * This method returns a question and answer about the 
	 * maximum value on the current graph.
     * 
     * @return a question about a maximum value on the graph   
     */
	@Override
	public Question finMax() {
		 // This kind of plugin does not contain min/max questions
		return null;
	}

	/**
	 * This method returns a question and answer about the 
	 * minimum value on the current graph.
     * 
     * @return a question about a minimum value on the graph   
     */
	@Override
	public Question findMin() {
		 // This kind of plugin does not contain min/max questions
		return null;
	}

    /**
     * This method returns a question and answer about the 
	 * any outlier values on the current graph.
     * 
     * @return a question about an outlier 
     */
	@Override
	public Question findOutlier() {
		// This kind of plugin does not contain outliers
		return null;
	}

    /**
     * This method returns a question and answer about the 
	 * any recommendations based on the current graph.
     * 
     * 
     * @return a question asking a user to recommend something  
     */
	@Override
	public Question findRecomendation() {
		// This kind of plugin does not contain any recommendation questions
		return null;
	}

	/**
	 * This method returns a question about the 
	 * exploring the current graph.
     *  
     * @return a question about exploring the graph 
     */
	@Override
	public Question exploration() {
		// This kind of plugin does not contain any exploration questions
		return null;
	}

	@Override
	String modifyQuestion(String s, int num, String l) {
		
		s = s.substring(0, s.indexOf("blank"));

		return s;
	}
	
    /**
     * This method will append to the list of "canned" questions, the ones
     * particular to this plugin. This method makes the following assumption(s):
     * 1. The question is always rated as 0 (zero)
     */
    private void append(String question, int time, String type) {
        int score = 0;
        Question obj = new Question(question, time, type, score);
        eval.addQuestion(obj);

    }   

}
