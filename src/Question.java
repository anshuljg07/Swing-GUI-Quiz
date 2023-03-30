import java.util.ArrayList;
import java.util.Collections;

/**
 * The Question class serves as a representation of the quetions that will be populated into the quiz GUI panels. It will take
 *  the question body, correct anwers, and incorrect answers and provide ways to jumble them and keep track of the answer.
 */
public class Question {
    /**
     * The String questionText serves as the question body.
     */
    private final String questionText;
    /**
     * The String array answers holds the correct answers for a given Question object.
     */
    private final String[] answers;
    /**
     * The String array nonAnswers holds the incorrect answers for a given Question object.
     */
    private final String[] nonAnswers;
    /**
     * The String array scrambledOutput holds both the correct and incorrect answers of the question in a randomly
     * generated order.
     */
    private String[] scrambledOutput;
    /**
     * The Integer array correctAnswerIndexes contains the indexes of the correct answers in the scrambledOutput String array.
     */
    private Integer[] correctAnswerIndexes;

    /**
     * Getter for questionText
     * @return
     */
    public String getQuestionText() {
        return questionText;
    }

    /**
     * Getter for answers
     * @return
     */
    public String[] getAnswers() {
        return answers;
    }

    /**
     * Getter for nonAnswers
     * @return
     */
    public String[] getNonAnswers() {
        return nonAnswers;
    }

    /**
     * Getter for scrambledOutput
     * @return
     */
    public String[] getScrambledOutput() {
        return scrambledOutput;
    }

    /**
     * Getter for scrambledOutput
     * @param scrambledOutput
     */
    public void setScrambledOutput(String[] scrambledOutput) {
        this.scrambledOutput = scrambledOutput;
    }

    /**
     * Getter for correctAnswerIndexes
     * @return
     */
    public Integer[] getCorrectAnswerIndexes() {
        return correctAnswerIndexes;
    }

    /**
     * Setter for correctAnswerIndexes
     * @param correctAnswerIndexes
     */
    public void setCorrectAnswerIndexes(Integer[] correctAnswerIndexes) {
        this.correctAnswerIndexes = correctAnswerIndexes;
    }

    /**
     * The constructor Question() takes in String QTest corresponding to the question body, String[] answers corresponding to the correct
     * answers for the question body, and a Stringp[] nAnswers corresponding to the incorrect answers for the question body. It initializes
     *  these specific membervalues.
     * @param QText
     * @param answers
     * @param nAnswers
     */
    Question(String QText, String[] answers, String[] nAnswers)
    {
        questionText = QText;
        this.answers = answers;
        nonAnswers = nAnswers;
        correctAnswerIndexes = new Integer[answers.length];
        scrambledOutput = new String[answers.length + nonAnswers.length];
        generateRandomOrder();
    }

    /**
     * The generateRandomOrder() method generates the scrambledOutput String Array by randomly assigning items from both the
     * answers and nonAnswers array into the scrambledOutput array. It saves the indexes of the correct answers into the correctAnswerIndexes array.
     */
    public void generateRandomOrder()
    {
        ArrayList<Integer> randomnums = new ArrayList<Integer>(); //create an arraylist so I can use collections
        for(int i = 0; i < scrambledOutput.length; i++)
        {
            randomnums.add(i); //add indexs of new output
        }
        Collections.shuffle(randomnums); //shuffle them
        for(int i = 0; i < scrambledOutput.length; i++)
        {
            if(i < answers.length)
            {
                scrambledOutput[randomnums.get(i)] = answers[i];
                correctAnswerIndexes[i] = randomnums.get(i);
            }
            else {
                scrambledOutput[randomnums.get(i)] = nonAnswers[i - answers.length];
            }
        }
    }
}
