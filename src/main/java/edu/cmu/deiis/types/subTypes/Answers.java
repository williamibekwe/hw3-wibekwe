

/* First created by JCasGen Sat Oct 05 13:51:31 EDT 2013 */
package edu.cmu.deiis.types.subTypes;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.cas.FSArray;
import org.apache.uima.jcas.cas.AnnotationBase;


/** 
 * Updated by JCasGen Tue Oct 08 18:34:54 EDT 2013
 * XML source: /Users/willibeamin/Documents/workspace/hw3-wibekwe/src/main/resources/descriptors/hw3-wibekwe-aae.xml
 * @generated */
public class Answers extends AnnotationBase {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(Answers.class);
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
  protected Answers() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public Answers(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public Answers(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** <!-- begin-user-doc -->
    * Write your own initialization here
    * <!-- end-user-doc -->
  @generated modifiable */
  private void readObject() {/*default - does nothing empty block */}
     
 
    
  //*--------------*
  //* Feature: AnswerList

  /** getter for AnswerList - gets 
   * @generated */
  public FSArray getAnswerList() {
    if (Answers_Type.featOkTst && ((Answers_Type)jcasType).casFeat_AnswerList == null)
      jcasType.jcas.throwFeatMissing("AnswerList", "edu.cmu.deiis.types.subTypes.Answers");
    return (FSArray)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((Answers_Type)jcasType).casFeatCode_AnswerList)));}
    
  /** setter for AnswerList - sets  
   * @generated */
  public void setAnswerList(FSArray v) {
    if (Answers_Type.featOkTst && ((Answers_Type)jcasType).casFeat_AnswerList == null)
      jcasType.jcas.throwFeatMissing("AnswerList", "edu.cmu.deiis.types.subTypes.Answers");
    jcasType.ll_cas.ll_setRefValue(addr, ((Answers_Type)jcasType).casFeatCode_AnswerList, jcasType.ll_cas.ll_getFSRef(v));}    
    
  /** indexed getter for AnswerList - gets an indexed value - 
   * @generated */
  public Answer getAnswerList(int i) {
    if (Answers_Type.featOkTst && ((Answers_Type)jcasType).casFeat_AnswerList == null)
      jcasType.jcas.throwFeatMissing("AnswerList", "edu.cmu.deiis.types.subTypes.Answers");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((Answers_Type)jcasType).casFeatCode_AnswerList), i);
    return (Answer)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((Answers_Type)jcasType).casFeatCode_AnswerList), i)));}

  /** indexed setter for AnswerList - sets an indexed value - 
   * @generated */
  public void setAnswerList(int i, Answer v) { 
    if (Answers_Type.featOkTst && ((Answers_Type)jcasType).casFeat_AnswerList == null)
      jcasType.jcas.throwFeatMissing("AnswerList", "edu.cmu.deiis.types.subTypes.Answers");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((Answers_Type)jcasType).casFeatCode_AnswerList), i);
    jcasType.ll_cas.ll_setRefArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((Answers_Type)jcasType).casFeatCode_AnswerList), i, jcasType.ll_cas.ll_getFSRef(v));}
  }

    