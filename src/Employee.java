public class Employee {
    private String fName;
    private String lName;
    private int idNum;

    private static int idNumTracker = 101;

    public Employee(String f, String l) {
        fName = f;
        lName = l;
        idNum = idNumTracker;

        idNumTracker++;
    }

    public String getFullName() {
        return fName + " " + lName;
    }

    public int getIdNum() {
        return idNum;
    }

    public int recentIdNum() {
        return idNumTracker - 1;
    }

    public int numOfEmployees() {
        return idNumTracker - 101;
    }
}
