package DataAnalysis;

import DataObject.EvalObject;
import DataObject.Question;

/**
 * Parallel Coordinates Plugin implementation.
 * Parallel coordinates is a common way of visualizing high-dimensional 
 * geometry and analyzing multivariate data.
 * 
 * To show a set of points in an n-dimensional space, a backdrop is drawn 
 * consisting of n parallel lines, typically vertical and equally spaced. 
 * A point in n-dimensional space is represented as a polyline with vertices 
 * on the parallel axes; the position of the vertex on the ith axis corresponds 
 * to the ith coordinate of the point.
 * 
 * @author Nacer Abreu
 */
public class ParallelCoordinatesQuestion extends QuestionBase {

	private EvalObject eval;
	
	public ParallelCoordinatesQuestion(EvalObject eval) {
		this.eval = eval;
		
		append("Is there a pattern to the visualization?", 60, "s");
        append("Was there an event that caused this?", 60, "s");
        append("Does the number of entries make the visualization harder to interpret?", 60, "s");
        append("Does the number of columns make the visualization harder to interpret?", 60, "s");
	}

	@Override
    public Question finMax() {
        double max = eval.getDatapoints().get(0).getValueY();
        
        //iterate through all of the datapoints find the min
        for(int i =1; i < eval.getDatapoints().size(); i++)
        {
        
            if( eval.getDatapoints().get(i).getValueY() > max)
            {
                max = eval.getDatapoints().get(i).getValueY();
            }            
        }       
        //create a new question object 
        Question newQuestion = new Question("What is the maximum Y value?", 30, "s", 0);
        newQuestion.setAnswer(new Double(max).toString());
        return newQuestion;
    }

    @Override
    public Question findMin() {
        double min = eval.getDatapoints().get(0).getValueY();
        
        //iterate through all of the datapoints find the min
        for(int i =1; i < eval.getDatapoints().size(); i++)
        {
        
            if( eval.getDatapoints().get(i).getValueY() < min)
            {
                min = eval.getDatapoints().get(i).getValueY();
            }            
        }       
        //create a new question object 
        Question newQuestion = new Question("What is the minimum Y value?", 30, "s", 0);
        newQuestion.setAnswer(new Double(min).toString());
        return newQuestion;
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
     * particular to this plugin. This method makes the following assumption(s): 
     * 1. The question is always rated as 0 (zero)
     */
    private void append(String question, int time, String type) {
        int score = 0;
        Question obj = new Question(question, time, type, score);
        eval.addQuestion(obj);

    }   


}
