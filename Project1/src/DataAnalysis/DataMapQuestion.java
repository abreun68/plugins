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
	}

	/* (non-Javadoc)
	 * @see DataAnalysis.QuestionBase#finMax()
	 */
	@Override
	Question finMax() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see DataAnalysis.QuestionBase#findMin()
	 */
	@Override
	Question findMin() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see DataAnalysis.QuestionBase#findOutlier()
	 */
	@Override
	Question findOutlier() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see DataAnalysis.QuestionBase#findRecomendation()
	 */
	@Override
	Question findRecomendation() {
		// TODO Auto-generated method stub
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
