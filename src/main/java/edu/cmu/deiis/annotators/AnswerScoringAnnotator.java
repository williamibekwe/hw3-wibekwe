package edu.cmu.deiis.annotators;

import java.util.Arrays;
import java.util.Iterator;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.cas.FSIndex;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.cas.FSArray;
import org.apache.uima.jcas.tcas.Annotation;

import edu.cmu.deiis.types.subTypes.Answer;
import edu.cmu.deiis.types.subTypes.Answers;
import edu.cmu.deiis.types.subTypes.CASDocuments;
import edu.cmu.deiis.types.subTypes.Question;
import edu.cmu.deiis.support.JaccardSimilarity;

public class AnswerScoringAnnotator extends JCasAnnotator_ImplBase {
	
	@Override
	public void process(JCas jcas) {
		/*
		 * This block of code gets the globally indexed file via iteratorso it
		 * can be used for the tokenization
		 */
		FSIndex<Annotation> docIndex = jcas.getAnnotationIndex(CASDocuments.type);
		Iterator<Annotation> iter = docIndex.iterator();
		CASDocuments document = (CASDocuments) iter.next();

		Question question = document.getQuestion();
		String questionString = question.getQuestionsString();
		questionString = questionString.replaceAll("[^a-zA-Z]+$", "");
		String questionarray[] = questionString.split("\\s+");
		questionarray = Arrays.copyOfRange(questionarray, 0,questionarray.length);
		Answers answers = document.getAnswers();
		FSArray answerList = answers.getAnswerList();
		//parse strings into string lists and passes them in to the JaccardSimilarity Algorithm
		for (int i = 0; i < answerList.size(); i++) {
			Answer ans = (Answer) answerList.get(i);
			String ansString = ans.getAnswerString();
			ansString = ansString.replaceAll("[^a-zA-Z]+$", "");
			String ansList[] = ansString.split("\\s+");
			ansList = Arrays.copyOfRange(ansList, 0, ansList.length);
			ans.setScore(JaccardSimilarity.jaccardSimilarity(questionarray,ansList));
		}

	}
}
