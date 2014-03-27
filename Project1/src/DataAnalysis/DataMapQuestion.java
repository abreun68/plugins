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
		
		append("Is there a concentration in a certain location? Why?", 60, "s"); 
		append("Are there any inconclusive data areas?", 60, "s"); 
		append("Does the color scale contain patterns or textures to differentiate similar shades?", 60, "s"); 
		append("Can the under-represented areas be easily identified?", 60, "s");
		append("Can the over-represented areas be easily identified?", 60, "s");
		append("Are the boundaries clearly delineated?", 60, "s");
		append("Is context provided?", 60, "s");
		append("Are the colors used, readable for colorblind users?", 60, "s");
		append("Can you draw any conclusions from the data map?", 60, "s");
		append("Are the colors used representatives of the data in any way?", 60, "s");
	}

	/* (non-Javadoc)
	 * @see DataAnalysis.QuestionBase#finMax()
	 */
	@Override
	public Question finMax() {
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
	public Question findMin() {
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
	public Question findOutlier() {
		// This kind of plugin does not contain outliers
        return null;
	}

	/* (non-Javadoc)
	 * @see DataAnalysis.QuestionBase#findRecomendation()
	 */
	@Override
	public Question findRecomendation() {
		 // This kind of plugin does not contain any recommendation questions
        return null;
	}

	/* (non-Javadoc)
	 * @see DataAnalysis.QuestionBase#exploration()
	 */
	@Override
	public Question exploration() {
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
     * particular to this plugin. 
     */
    private void append(String question, int time, String type) {
        int score = 0;
        Question obj = new Question(question, time, type, score);
        eval.addQuestion(obj);

    }   


}
