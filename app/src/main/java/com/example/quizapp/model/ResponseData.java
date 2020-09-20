package com.example.quizapp.model;

import java.util.List;

public class ResponseData {


    /**
     * response_code : 0
     * results : [{"category":"General Knowledge","type":"multiple","difficulty":"easy","question":"What is the most common surname Wales?","correct_answer":"Jones","incorrect_answers":["Williams","Davies","Evans"]},{"category":"General Knowledge","type":"multiple","difficulty":"easy","question":"What does a funambulist walk on?","correct_answer":"A Tight Rope","incorrect_answers":["Broken Glass","Balls","The Moon"]},{"category":"General Knowledge","type":"multiple","difficulty":"easy","question":"Which sign of the zodiac is represented by the Crab?","correct_answer":"Cancer","incorrect_answers":["Libra","Virgo","Sagittarius"]},{"category":"General Knowledge","type":"multiple","difficulty":"easy","question":"What is the name of the Jewish New Year?","correct_answer":"Rosh Hashanah","incorrect_answers":["Elul","New Year","Succoss"]},{"category":"General Knowledge","type":"multiple","difficulty":"easy","question":"What type of animal was Harambe, who was shot after a child fell into it&#039;s enclosure at the Cincinnati Zoo?","correct_answer":"Gorilla","incorrect_answers":["Tiger","Panda","Crocodile"]},{"category":"General Knowledge","type":"multiple","difficulty":"easy","question":"What was the nickname given to the Hughes H-4 Hercules, a heavy transport flying boat which achieved flight in 1947?","correct_answer":"Spruce Goose","incorrect_answers":["Noah&#039;s Ark","Fat Man","Trojan Horse"]},{"category":"General Knowledge","type":"multiple","difficulty":"easy","question":"What is the Spanish word for &quot;donkey&quot;?","correct_answer":"Burro","incorrect_answers":["Caballo","Toro","Perro"]},{"category":"General Knowledge","type":"multiple","difficulty":"easy","question":"Who is depicted on the US hundred dollar bill?","correct_answer":"Benjamin Franklin","incorrect_answers":["George Washington","Abraham Lincoln","Thomas Jefferson"]},{"category":"General Knowledge","type":"multiple","difficulty":"easy","question":"Which American-owned brewery led the country in sales by volume in 2015?","correct_answer":"D. G. Yuengling and Son, Inc","incorrect_answers":["Anheuser Busch","Boston Beer Company","Miller Coors"]},{"category":"General Knowledge","type":"multiple","difficulty":"easy","question":"What is the name of Poland in Polish?","correct_answer":"Polska","incorrect_answers":["Pupcia","Polszka","P&oacute;land"]},{"category":"General Knowledge","type":"multiple","difficulty":"easy","question":"Which restaurant&#039;s mascot is a clown?","correct_answer":"McDonald&#039;s","incorrect_answers":["Whataburger","Burger King","Sonic"]},{"category":"General Knowledge","type":"multiple","difficulty":"easy","question":"What was the first ever London Underground line to be built?","correct_answer":"Metropolitan Line","incorrect_answers":["Circle Line","Bakerloo Line","Victoria Line"]},{"category":"General Knowledge","type":"multiple","difficulty":"easy","question":"Which of the following presidents is not on Mount Rushmore?","correct_answer":"John F. Kennedy","incorrect_answers":["Theodore Roosevelt","Abraham Lincoln","Thomas Jefferson"]},{"category":"General Knowledge","type":"multiple","difficulty":"easy","question":"What is Tasmania?","correct_answer":"An Australian State","incorrect_answers":["A flavor of Ben and Jerry&#039;s ice-cream","A Psychological Disorder","The Name of a Warner Brothers Cartoon Character"]},{"category":"General Knowledge","type":"multiple","difficulty":"easy","question":"Which candy is NOT made by Mars?","correct_answer":"Almond Joy","incorrect_answers":["M&amp;M&#039;s","Twix","Snickers"]},{"category":"General Knowledge","type":"multiple","difficulty":"easy","question":"The likeness of which president is featured on the rare $2 bill of USA currency?","correct_answer":"Thomas Jefferson","incorrect_answers":["Martin Van Buren","Ulysses Grant","John Quincy Adams"]},{"category":"General Knowledge","type":"multiple","difficulty":"easy","question":"What is Cynophobia the fear of?","correct_answer":"Dogs","incorrect_answers":["Birds","Flying","Germs"]},{"category":"General Knowledge","type":"multiple","difficulty":"easy","question":"When someone is inexperienced they are said to be what color?","correct_answer":"Green","incorrect_answers":["Red","Blue","Yellow"]},{"category":"General Knowledge","type":"multiple","difficulty":"easy","question":"Earth is located in which galaxy?","correct_answer":"The Milky Way Galaxy","incorrect_answers":["The Mars Galaxy","The Galaxy Note","The Black Hole"]},{"category":"General Knowledge","type":"multiple","difficulty":"easy","question":"What are Panama hats made out of?","correct_answer":"Straw","incorrect_answers":["Silk","Hemp","Flax"]}]
     */

    private int response_code;
    private List<ResultsBean> results;

    public int getResponse_code() {
        return response_code;
    }

    public void setResponse_code(int response_code) {
        this.response_code = response_code;
    }

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean {
        /**
         * category : General Knowledge
         * type : multiple
         * difficulty : easy
         * question : What is the most common surname Wales?
         * correct_answer : Jones
         * incorrect_answers : ["Williams","Davies","Evans"]
         */

        private String category;
        private String type;
        private String difficulty;
        private String question;
        private String correct_answer;
        private List<String> incorrect_answers;
        private boolean isCorrect = false;
        private String notAttempt = "0";

        public String getNotAttempt() {
            return notAttempt;
        }

        public void setNotAttempt(String notAttempt) {
            this.notAttempt = notAttempt;
        }

        public boolean isCorrect() {
            return isCorrect;
        }

        public void setCorrect(boolean correct) {
            isCorrect = correct;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getDifficulty() {
            return difficulty;
        }

        public void setDifficulty(String difficulty) {
            this.difficulty = difficulty;
        }

        public String getQuestion() {
            return question;
        }

        public void setQuestion(String question) {
            this.question = question;
        }

        public String getCorrect_answer() {
            return correct_answer;
        }

        public void setCorrect_answer(String correct_answer) {
            this.correct_answer = correct_answer;
        }

        public List<String> getIncorrect_answers() {
            return incorrect_answers;
        }

        public void setIncorrect_answers(List<String> incorrect_answers) {
            this.incorrect_answers = incorrect_answers;
        }
    }
}
