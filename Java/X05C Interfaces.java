class Maine {
    public static void main(String[] args) {
        Student s = new Student(4, "Tom", 85.5, 5, "Tom", 89.2);

        s.displayFY();
        s.displaySY();
    }
}

interface FY {
    void displayFY();
}

interface SY {
    void displaySY();
}

class Student implements FY, SY {
    int fyRoll, syRoll;
    String fyName, syName;
    double fyResult, syResult;

    Student(int r1, String n1, double res1, int r2, String n2, double res2) {
        this.fyRoll = r1;
        this.fyName = n1;
        this.fyResult = res1;

        // SY Initialization
        this.syRoll = r2;
        this.syName = n2;
        this.syResult = res2;
    }

    // Interface Method Implementation
    public void displayFY() {
        System.out.println("FY Details -> Roll No: " + fyRoll + ", Name: " + fyName + ", Result: " + fyResult);
    }

    public void displaySY() {
        System.out.println("SY Details -> Roll No: " + syRoll + ", Name: " + syName + ", Result: " + syResult);
    }
}
