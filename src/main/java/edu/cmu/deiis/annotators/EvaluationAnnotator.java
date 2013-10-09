package edu.cmu.deiis.annotators;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.cas.FSIndex;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.cas.FSArray;
import org.apache.uima.jcas.tcas.Annotation;

import edu.cmu.deiis.types.subTypes.Answer;
import edu.cmu.deiis.types.subTypes.Answers;
import edu.cmu.deiis.types.subTypes.Question;
import edu.cmu.deiis.types.subTypes.CASDocuments;

public class EvaluationAnnotator extends JCasAnnotator_ImplBase {

	public void process(JCas jcas) {
		/*
		 * This block of code gets the globally indexed file via iterator so it
		 * can be used for the tokenization
		 */
		FSIndex<Annotation> docIndex = jcas.getAnnotationIndex(CASDocuments.type);
		Iterator<Annotation> iter = docIndex.iterator();
		CASDocuments document = (CASDocuments) iter.next();
		Question question = document.getQuestion(); 
		String questionString = question.getQuestionsString(); 
		System.out.println(questionString); 
		
		Answers answers = document.getAnswers();
		FSArray answerList = answers.getAnswerList(); 
		Map<Answer,Double> ranking =new HashMap<Answer,Double>(); 
		for(int i = 0; i < answerList.size(); i++ ){  
			Answer ans = (Answer) answerList.get(i);
			ranking.put(ans, ans.getScore());
		}
		//puts all answer inside a map for better easier printing. 
		//prints into the right answers and the calculated score then prints the wrong answer and calculated score
		for(Map.Entry<Answer,Double> entry : ranking.entrySet()){
			if( entry.getKey().getCorrectAnswer())
			System.out.println( "+ " + Math.round( entry.getValue() * 10.0 ) / 10.0 + " " + (entry.getKey()).getAnswerString());
		}
		for(Map.Entry<Answer,Double> entry : ranking.entrySet()){
			if( !entry.getKey().getCorrectAnswer())
			System.out.println( "- " + Math.round( entry.getValue() * 10.0 ) / 10.0 + " " + (entry.getKey()).getAnswerString());
		}
		System.out.println();
	}

}
