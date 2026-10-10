
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.List;

abstract class Question {
    String text;
    String correctAnswer;
    String studentAnswer;
    double points;

    Question(String text, String correctAnswer,
             String studentAnswer, double points) {
        this.text = text;
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    abstract double evaluate();

    abstract String getType();
}

class MCQ extends Question {
    MCQ(String text, String correctAnswer,
        String studentAnswer, double points) {
        super(text, correctAnswer, studentAnswer, points);
    }

    double evaluate() {
        return studentAnswer.equals(correctAnswer) ? points : 0;
    }

    String getType() {
        return "MCQ";
    }
}

class TrueFalse extends Question {
    TrueFalse(String text, String correctAnswer,
              String studentAnswer, double points) {
        super(text, correctAnswer, studentAnswer, points);
    }

    double evaluate() {
        return studentAnswer.equals(correctAnswer) ? points : 0;
    }

    String getType() {
        return "TF";
    }
}

class Essay extends Question {
    Essay(String text, String correctAnswer,
          String studentAnswer, double points) {
        super(text, correctAnswer, studentAnswer, points);
    }

    double evaluate() {
        String[] keywords = correctAnswer.split(",");
        String answer = studentAnswer.toLowerCase();

        int matched = 0;

        for (String keyword : keywords) {
            if (answer.contains(keyword.trim().toLowerCase())) {
                matched++;
            }
        }

        if (matched >= 2) {
            return points * 0.75;
        } else if (matched == 1) {
            return points * 0.50;
        }

        return 0;
    }

    String getType() {
        return "ESSAY";
    }
}

public class ExamGrader {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine().trim());
        Question[] questions = new Question[n];

        Pattern pattern = Pattern.compile("\"([^\"]*)\"|(\\S+)");

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            Matcher matcher = pattern.matcher(line);
            List<String> fields = new ArrayList<>();

            while (matcher.find()) {
                if (matcher.group(1) != null) {
                    fields.add(matcher.group(1));
                } else {
                    fields.add(matcher.group(2));
                }
            }

            String type = fields.get(0);
            String text = fields.get(1);
            String correct = fields.get(2);
            String student = fields.get(3);
            double points = Double.parseDouble(fields.get(4));

            if (type.equals("MCQ")) {
                questions[i] =
                        new MCQ(text, correct, student, points);
            } else if (type.equals("TF")) {
                questions[i] =
                        new TrueFalse(text, correct, student, points);
            } else {
                questions[i] =
                        new Essay(text, correct, student, points);
            }
        }

        double total = 0;

        for (Question question : questions) {
            double score = question.evaluate();

            System.out.printf("%s: %.2f%n",
                    question.getType(), score);
            total += score;
        }

        System.out.printf("Total Score: %.2f%n", total);
        sc.close();
    }
}
