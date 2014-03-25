/**
 * 
 */
package DataAnalysis;

import DataObject.EvalObject;
import DataObject.Question;

/**
 * @author MIKE
 *
 */
public class DataMapQuestion extends QuestionBase {

	private EvalObject eval;
	
	/**
	 * 
	 */
	public DataMapQuestion(EvalObject eval) {
		this.eval = eval;
		
		append("Is there a concentration in a certain location? Why?"); 
		append("Are there any inconclusive data areas?"); 
		append("Does the color scale contain patterns or textures to differentiate similar shades?"); 
		append("Can the under-represented areas be easily identified?");
		append("Can the over-represented areas be easily identified?");
		append("Are the boundaries clearly delineated?");
		append("Is context provided?");
		append("Are the colors used, readable for colorblind users?");
		append("Can you draw any conclusions from the data map?");
		append("Are the colors used representatives of the data in any way?");
	}

	/* (non-Javadoc)
	 * @see DataAnalysis.QuestionBase#finMax()
	 */
	@Override
	Question finMax() {
		 int time = 30;
	        int score = 0;
	        String type = "s";
	        
	        String question = "What's the percentage of most populated state/area?";
	        Question obj = new Question(question, time, type, score);
	        
	        // Determine the maximum value in the data set
	        double max = eval.getDatapoints().get(0).getValueY();
	        
	        //iterate through all of the datapoints find the min
	        for(int i =1; i < eval.getDatapoints().size(); i++)
	        {
	            if( eval.getDatapoints().get(i).getPercent() > max)
	            {
	                max = eval.getDatapoints().get(i).getPercent();
	            }            
	        } 
	        obj.setAnswer(Double.toString(max));
	        return obj;
	}

	/* (non-Javadoc)
	 * @see DataAnalysis.QuestionBase#findMin()
	 */
	@Override
	Question findMin() {
		int time = 30;
        int score = 0;
        String type = "s";
        String question = "What's the percentage of the least populated state/area?";
        Question obj = new Question(question, time, type, score);
        
        // Determine the minimum value in the data set
        double min = eval.getDatapoints().get(0).getValueY();

        //iterate through all of the datapoints find the min
        for (int i = 1; i < eval.getDatapoints().size(); i++) {

            if (eval.getDatapoints().get(i).getValueY() < min) {
                min = eval.getDatapoints().get(i).getValueY();
            }
        }
        obj.setAnswer(Double.toString(min));
        return obj;
	}

	/* (non-Javadoc)
	 * @see DataAnalysis.QuestionBase#findOutlier()
	 */
	@Override
	Question findOutlier() {
		// This kind of plugin does not contain outliers
        return null;
	}

	/* (non-Javadoc)
	 * @see DataAnalysis.QuestionBase#findRecomendation()
	 */
	@Override
	Question findRecomendation() {
		 // This kind of plugin does not contain any recommendation questions
        return null;
	}

	/* (non-Javadoc)
	 * @see DataAnalysis.QuestionBase#exploration()
	 */
	@Override
	Question exploration() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see DataAnalysis.QuestionBase#modifyQuestion(java.lang.String, int, java.lang.String)
	 */
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
