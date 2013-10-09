

/* First created by JCasGen Sat Oct 05 13:51:31 EDT 2013 */
package edu.cmu.deiis.types.subTypes;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import edu.cmu.deiis.types.AnswerScore;


/** 
 * Updated by JCasGen Tue Oct 08 18:34:54 EDT 2013
 * XML source: /Users/willibeamin/Documents/workspace/hw3-wibekwe/src/main/resources/descriptors/hw3-wibekwe-aae.xml
 * @generated */
public class Answer extends AnswerScore {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(Answer.class);
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int type = typeIndexID;
  /** @generated  */
  @Override
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected Answer() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public Answer(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public Answer(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public Answer(JCas jcas, int begin, int end) {
    super(jcas);
    setBegin(begin);
    setEnd(end);
    readObject();
  }   

  /** <!-- begin-user-doc -->
    * Write your own initialization here
    * <!-- end-user-doc -->
  @generated modifiable */
  private void readObject() {/*default - does nothing empty block */}
     
 
    
  //*--------------*
  //* Feature: SentenceStructure

  /** getter for SentenceStructure - gets 
   * @generated */
  public Sentence getSentenceStructure() {
    if (Answer_Type.featOkTst && ((Answer_Type)jcasType).casFeat_SentenceStructure == null)
      jcasType.jcas.throwFeatMissing("SentenceStructure", "edu.cmu.deiis.types.subTypes.Answer");
    return (Sentence)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((Answer_Type)jcasType).casFeatCode_SentenceStructure)));}
    
  /** setter for SentenceStructure - sets  
   * @generated */
  public void setSentenceStructure(Sentence v) {
    if (Answer_Type.featOkTst && ((Answer_Type)jcasType).casFeat_SentenceStructure == null)
      jcasType.jcas.throwFeatMissing("SentenceStructure", "edu.cmu.deiis.types.subTypes.Answer");
    jcasType.ll_cas.ll_setRefValue(addr, ((Answer_Type)jcasType).casFeatCode_SentenceStructure, jcasType.ll_cas.ll_getFSRef(v));}    
   
    
  //*--------------*
  //* Feature: AnswerString

  /** getter for AnswerString - gets 
   * @generated */
  public String getAnswerString() {
    if (Answer_Type.featOkTst && ((Answer_Type)jcasType).casFeat_AnswerString == null)
      jcasType.jcas.throwFeatMissing("AnswerString", "edu.cmu.deiis.types.subTypes.Answer");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Answer_Type)jcasType).casFeatCode_AnswerString);}
    
  /** setter for AnswerString - sets  
   * @generated */
  public void setAnswerString(String v) {
    if (Answer_Type.featOkTst && ((Answer_Type)jcasType).casFeat_AnswerString == null)
      jcasType.jcas.throwFeatMissing("AnswerString", "edu.cmu.deiis.types.subTypes.Answer");
    jcasType.ll_cas.ll_setStringValue(addr, ((Answer_Type)jcasType).casFeatCode_AnswerString, v);}    
   
    
  //*--------------*
  //* Feature: CorrectAnswer

  /** getter for CorrectAnswer - gets 
   * @generated */
  public boolean getCorrectAnswer() {
    if (Answer_Type.featOkTst && ((Answer_Type)jcasType).casFeat_CorrectAnswer == null)
      jcasType.jcas.throwFeatMissing("CorrectAnswer", "edu.cmu.deiis.types.subTypes.Answer");
    return jcasType.ll_cas.ll_getBooleanValue(addr, ((Answer_Type)jcasType).casFeatCode_CorrectAnswer);}
    
  /** setter for CorrectAnswer - sets  
   * @generated */
  public void setCorrectAnswer(boolean v) {
    if (Answer_Type.featOkTst && ((Answer_Type)jcasType).casFeat_CorrectAnswer == null)
      jcasType.jcas.throwFeatMissing("CorrectAnswer", "edu.cmu.deiis.types.subTypes.Answer");
    jcasType.ll_cas.ll_setBooleanValue(addr, ((Answer_Type)jcasType).casFeatCode_CorrectAnswer, v);}    
  }

    