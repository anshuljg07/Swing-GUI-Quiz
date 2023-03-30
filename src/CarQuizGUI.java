import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * This class creates an interactive quiz GUI using Java Swing and loads preset questions.
 */
public class CarQuizGUI {
    /**
     * This main methods instantiates the interactive quiz GUI and instantiates 5 preset questions of various question
     * style types.
     * @param args the arguements given during execution
     */
    public static void main(String[] args)
    {
        ArrayList<Question> questions = new ArrayList<Question>();
        Question q1 = new Question("Which vehicle had such unfortunate gas tank placement that it was known to erupt into flames from minor rear collisions?", new String[]{"1971 Ford Pinto"}, new String[]{"2010 BMW 550i", "2003 Ford E-450", "1972 Oldsmobile 442"});
        Question q2 = new Question("Select the following cars that have participated in official NASCAR races.", new String[]{"2008 Cheverolet Impala SS", "2010 Toyota Camry"}, new String[]{"2001 Honda Accord", "1998 Lexus LS 400"});
        Question q3 = new Question("Which F1 driver won the 2020 Grand Prix?", new String[]{"Lewis Hamilton"}, new String[]{"Max Verstappen", "Charles Leclerc", "Sergio Perez", "Pierre Gasly", "Fernando Alonso", "Esteban Ocon", "Daniel Riccardo"});
        Question q4 = new Question("Which billionaire founded Tesla?", new String[]{"Elon Musk"}, new String[]{"Bill Gates", "Jeff Bezos", "Sundar Pichai"});
        Question q5 = new Question("From the list of car companies drag the companies that have a German origin into the adjacent box.", new String[]{"Audi", "BMW", "Volkswagen", "Porsche"}, new String[]{"Toyota", "Ford", "Ferrari", "Lexus", "Subaru", "GMC", "Nissan", "Peugot", "Mini Cooper"});
        questions.add(q1);
        questions.add(q2);
        questions.add(q3);
        questions.add(q4);
        questions.add(q5);

        for(int i = 0; i < questions.size(); i++)
        {
            questions.get(i).generateRandomOrder();
        }

        MultiQuizFrame quiz = new MultiQuizFrame(questions); //when constructor is called, generate main tab in JTabbedPanel (start)
        //once start button is clicked, generate the quiz question tabs
        quiz.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        quiz.setSize(800, 600);
        quiz.setVisible(true);

    }
}
