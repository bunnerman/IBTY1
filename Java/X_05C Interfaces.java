class Maine {
    public static void main(String[] args) {
		Student fyS = new Student();
		Student syS = new Student();
		fyS.getDataFY(4, "Arnold", 98.3);
		syS.getDataSY(49, "Bob", 85.8);
		fyS.showFY();
		System.out.println();
		syS.showSY();
    }
}

interface FY {
    void showFY();
}

interface SY {
    void showSY();
}

class Student implements FY, SY {
	int fyRn; String fyN; double fyRes;
	int syRn; String syN; double syRes;

    public void getDataFY(int rn, String n, double res) {
		this.fyRn = rn;
		this.fyN = n;
		this.fyRes = res;
	}

	public void getDataSY(int rn, String n, double res) {
		this.syRn = rn;
		this.syN = n;
		this.syRes = res;
	}

    public void showFY() {
        System.out.println("FY\nRoll No: " + fyRn + "\nName: " + fyN + "\nResult: " + fyRes);
    }

    public void showSY() {
		System.out.println("SY\nRoll No: " + syRn + "\nName: " + syN + "\nResult: " + syRes);
    }
}
