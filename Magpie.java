/**
 * A program to carry on conversations with a human user.
 * This is the initial version that:
 * <ul><li>
 *       Uses indexOf to find strings
 * </li><li>
 * 		    Handles responding to simple words and phrases
 * </li></ul>
 * This version uses a nested if to handle default responses.
 * @author Laurie White
 * @version April 2012
 */

public class Magpie
{
    /**
     * Get a default greeting
     * @return a greeting
     */
    public String getGreeting()
    {
        return "Hello, let's talk.";
    }

    /**
     * Gives a response to a user statement
     *
     * @param statement
     *            the user statement
     * @return a response based on the rules given
     */
    public String getResponse(String statement)
    {
        statement.toLowerCase();
        String response = "";
        statement = statement.trim();
        if (statement.length() == 0){
            response = "Say something, I'm giving up on you...";
        }
        else if (findKeyWord(statement, "no", 0) >= 0)
        {
            response = "Why so negative?";
        }
        else if (statement.indexOf("i like") >= 0){
            transformILikeStatement(statement);
        }
        else if (statement.indexOf("mother") >= 0
                || statement.indexOf("father") >= 0
                || statement.indexOf("sister") >= 0
                || statement.indexOf("brother") >= 0)
        {
            response = "Tell me more about your family.";
        }
//        else if (statement.indexOf("dog") >= 0
//            || statement.indexOf("cat") >= 0){
//            response = "Tell me more about your pet(s)";
//        }
        else if (statement.indexOf("hubbard") >= 0){
            double y = Math.random();
            int whichResponse = (int)(y * 2);
            response = "";

            if (whichResponse == 0)
            {
                response = "This is all a simulation anyway, why do you keep talking to me?";
            }
            else if (whichResponse == 1)
            {
                response = "lets chill.";
            }

        }
        else if (statement.indexOf("do you") >= 0
                || statement.indexOf("have you") >= 0
                || statement.indexOf("will you") >= 0) {
            double y = Math.random();
            int whichResponse = (int)(y * 2);
            response = "";

            if (whichResponse == 0)
            {
                response = "Nope.";
            }
            else if (whichResponse == 1)
            {
                response = "Yes.";
            }
        }

        else
        {
            response = getRandomResponse();
        }
        return response;
    }

    /**
     *
     * @param statement what we are looking through
     * @param keyword isolated String we are looking for
     * @param index where search should begin
     * @return
     */
    public int findKeyWord (String statement, String keyword, int index){
        int i = statement.indexOf(keyword, index);
        while (i >= 0){
            char before = ' ', after = ' ';

            if(i > 0){
                before = statement.charAt(i - 1);}
            if (i + keyword.length() < statement.length()) {
                after = statement.charAt(i + keyword.length());}
            if (!isLetter(before + "") && !isLetter(after + "")){
                return i;
            }
        }
        return -1;
    }

    /**
     * Pick a default response to use if nothing else fits.
     * @return a non-committal string
     */
    private String getRandomResponse()
    {
        final int NUMBER_OF_RESPONSES = 4;
        double r = Math.random();
        int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
        String response = "";


        if (whichResponse == 0)
        {
            response = "Interesting, tell me more.";
        }
        else if (whichResponse == 1)
        {
            response = "Hmmm.";
        }
        else if (whichResponse == 2)
        {
            response = "Do you really think so?";
        }
        else if (whichResponse == 3)
        {
            response = "You don't say.";
        }

        return response;
    }
    public boolean isLetter (String str){
        str.toLowerCase();
        return "a".compareTo(str) > 0 || "z".compareTo(str) < 0;
    }
    private String transformILikeStatement (String n){
        n.toLowerCase();

        String str = n.substring(n.indexOf("i like"), '!');

        return "You like" + str + '?' + "I love" + str + '!';
    }
}
