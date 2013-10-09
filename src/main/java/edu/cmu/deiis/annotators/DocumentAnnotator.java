package edu.cmu.deiis.annotators;

import edu.cmu.deiis.types.subTypes.*;


import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.cas.FSArray;

public class DocumentAnnotator extends JCasAnnotator_ImplBase {
	
	/**
	   * @see JCasAnnotator_ImplBase#process(JCas)
	   */
	@Override
	 public void process(JCas aJCas) {
		
		/* @param
		 * This annotator will get the document and split the contents into a question and a list of answers
		 * 
		 */
		String d = aJCas.getDocumentText();
		String[] document = d.split("\n"); 
		Question question =new Question(aJCas);
		Answers answers =new Answers(aJCas);
		CASDocuments doc =new CASDocuments(aJCas);
		FSArray answerList =new FSArray(aJCas, document.length - 1);

		if(document[0].startsWith("Q")){
			question.setQuestionsString(document[0].replaceAll("Q ", ""));
		}
		
		for( int i = 1; i < document.length; i++ ){
			Answer a =new Answer(aJCas);
			String splitAnswer[] = document[i].split(" ");
			//The following will check the gold standard
			if(splitAnswer[1].equals("1")){
				a.setCorrectAnswer(true);
			} else {
				a.setCorrectAnswer(false);
			}
			a.setAnswerString(document[i].replaceAll("A [0-1] ", ""));
			answerList.set(i-1, a);			
		}
		answers.setAnswerList(answerList); 

		doc.setQuestion(question);
		doc.setAnswers(answers); 
		// this will index this type as a document type. 
		doc.addToIndexes();
	}
}
