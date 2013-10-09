package edu.cmu.deiis.annotators;

import java.util.Iterator;

import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.cas.FSArray;
import org.apache.uima.jcas.tcas.Annotation;
import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.cas.FSIndex;

import edu.cmu.deiis.types.subTypes.*;

public class TokenAnnotator extends JCasAnnotator_ImplBase {
		
	@Override
	public void process(JCas jcas) throws NullPointerException {
		/*
		 *This block of code gets the globally indexed file via iterator
		 *so it can be used for the tokenization
		 */
		FSIndex<Annotation> docIndex = jcas.getAnnotationIndex(CASDocuments.type);
		Iterator<Annotation> iter = docIndex.iterator();
		CASDocuments document = (CASDocuments) iter.next();
		Question question = document.getQuestion();
		
		/*
		 * 
		 * This block of code tokenizes the word in the question string
		 * and puts this back into the document globals index 
		 */
		String questionString = question.getQuestionsString();
		//System.out.println( "This is a question " + questionString);
		String[] questionTokens = questionString.split(" "); 
		//The length is n-1 because the in the file the first two word are not in the question string
		FSArray qtokenList =new FSArray(jcas, questionTokens.length); 
		for( int i = 0; i < questionTokens.length; i++ ) { 
			Token t =new Token(jcas); 
			t.setTokenString(questionTokens[i]);
			qtokenList.set(i, t);
		}
		Sentence sentence =new Sentence(jcas);
		sentence.setTokenList(qtokenList);
		question.setSentenceStructure(sentence);
		document.setQuestion(question);
		
		/*
		 * This block of code tokenizes the word in the List of answers string
		 * and puts this back into the document globals index 
		 */
		Answers answers = document.getAnswers();
		FSArray answerList = answers.getAnswerList();
		for( int i = 0; i < answerList.size(); i++ ){ 
			Answer a = (Answer) answerList.get(i);
			String[] answerTokens = a.getAnswerString().split(" ");
			Answer suba =new Answer(jcas);
			//stores the the list of tokens in each variable
			FSArray atokenList =new FSArray(jcas, answerTokens.length); 
			for( int j = 0; j < answerTokens.length; j++ ){ 
				Token t =new Token(jcas); 
				t.setTokenString(answerTokens[j]);
				//System.out.println(answerTokens[j+2]);
				atokenList.set(j, t);
			}
			Sentence answerSentence =new Sentence(jcas);
			answerSentence.setTokenList(atokenList); 
			a.setSentenceStructure(answerSentence);
			answerList.set(i, a);
		}
		answers.setAnswerList(answerList);
		document.setAnswers(answers);
		document.setQuestion(question);		
		
	}

}
