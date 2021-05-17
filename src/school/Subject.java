package school;

import java.util.ArrayList;

import utils.Define;

public class Subject {

	private int subjectId; // 과목 고유번호
	private String subjectName; //과목 이름
	private int gradeType; //과목 평가 방법
	
	//수강신청한 학생 리스트
	//register() 호출 시 학생 추가
	private ArrayList<Student> studentList = new ArrayList<>();
	
	public Subject(String subjectName, int subjectId) {
		
		this.subjectName = subjectName;
		this.subjectId = subjectId;
		this.gradeType = Define.AB_TYPE; //기본은 AB_TYPE 적용
	}
	
	//해당 과목 수강 신청
	public void register(Student student) {
		
		studentList.add(student);
	}

	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public int getGradeType() {
		return gradeType;
	}

	public void setGradeType(int gradeType) {
		this.gradeType = gradeType;
	}

	public ArrayList<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(ArrayList<Student> studentList) {
		this.studentList = studentList;
	}
	
	
	
}
