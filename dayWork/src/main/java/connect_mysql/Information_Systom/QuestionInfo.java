package connect_mysql.Information_Systom;

/**
 * @author csk
 * @date 2023/11/20 17:02
 */
public class QuestionInfo {
    int questionId;
    String question;
    String optionA;
    String optionB;
    String optionC;
    String optionD;
    String subject;
    String answer;

    public QuestionInfo(){

    }
    public QuestionInfo question(int questionId, String question, String optionA, String optionB, String optionC, String optionD, String subject, String answer) {
        QuestionInfo questionInfo = new QuestionInfo();
        questionInfo.question = question;
        questionInfo.questionId = questionId;
        questionInfo.optionA = optionA;
        questionInfo.optionB = optionB;
        questionInfo.optionC = optionC;
        questionInfo.optionD = optionD;
        questionInfo.subject = subject;
        questionInfo.answer = answer;
        return questionInfo;
    }


    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setOptionA(String optionA) {
        this.optionA = optionA;
    }

    public void setOptionB(String optionB) {
        this.optionB = optionB;
    }

    public void setOptionC(String optionC) {
        this.optionC = optionC;
    }

    public void setOptionD(String optionD) {
        this.optionD = optionD;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }


    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getQuestionId() {
        return questionId;
    }

    public String getAnswer() {
        return answer;
    }


    public String getOptionA() {
        return optionA;
    }

    public String getOptionB() {
        return optionB;
    }

    public String getOptionC() {
        return optionC;
    }

    public String getOptionD() {
        return optionD;
    }

    public String getQuestion() {
        return question;
    }

    public String getSubject() {
        return subject;
    }

    @Override
    public String toString() {
        return questionId+"\'"+question+"\'"+optionA+"\'"+optionB+"\'"+optionC+'\''+optionD+'\''+subject+'\''+answer;
    }
}
