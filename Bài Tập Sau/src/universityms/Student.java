package universityms;

class Student {
    private int studentID;
    private String name;
    private int age;
    private String email;
    private double gpa;

    public Student(int studentID, String name, int age, String email, double gpa) {
		super();
		this.studentID = studentID;
		this.name = name;
		this.age = age;
		this.email = email;
		this.gpa = gpa;
	}

	public int getStudentID() {
		return studentID;
	}

	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	
    public Student(int studentID, String name, int age, double gpa) {
        this.studentID = studentID;
        this.name = name;
        this.age = age;
        this.gpa = gpa;
        this.email = generateEmail(name);
    }

    private String generateEmail(String name) {
        name = name.toLowerCase().replaceAll(" ", "");
        return name + "@vku.udn.vn";
    }
}
