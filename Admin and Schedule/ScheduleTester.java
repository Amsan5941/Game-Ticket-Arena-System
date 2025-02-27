/* The Schedule object will connect to the schedule table in the arena database

Functions found in Schedule will let it:
    Connect to a database
    Retrieve all Game objects from the database
    Return an ArrayList of Game objects
*/

/* Run program from terminal using: 
    javac Schedule.java                                                  to compile the .java file

    java -classpath ".:sqlite-jdbc-3.34.0.jar" ScheduleTester               to run the file in the terminal 
                                                                            (the '.:' in the path is for Mac/Linux)
                                                                            (the '.;' is used for Windows)
                                                                         Your jdbc version might be different
*/

public class ScheduleTester {
    public static void main (String[] args) throws Exception {
        // Connect to the Arena database
        Schedule schedule = new Schedule();
        schedule.loadGames();
        System.out.println("Before adding table");
        System.out.println(schedule.scheduleInfo());
    }
}