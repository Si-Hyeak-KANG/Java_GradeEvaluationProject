package utils.report;

import java.util.ArrayList;

import grade.BasicEvaluation;
import grade.GradeEvaluation;
import grade.MajorEvaluation;
import school.School;
import school.Score;
import school.Student;
import school.Subject;
import utils.Define;

public class GenerateGradeReport {

	School school = School.getInstance();
	
	public static final String TITLE = " 수강생 학점 \t\t\n";
	public static final String HEADER = " 이륾 |  학번   | 중점과목 |  점수 \t\n";
	public static final String LINE = "---------------------------------\n";
	
	private StringBuffer buffer = new StringBuffer();
	
	
	public String getReport() {
		
		//모든 과목에 대한 학점 산출
		ArrayList<Subject> subjectList = school.getSubjectList();
		
		for(Subject subject : subjectList) {
			makeHeader(subject);
			makeBody(subject);
			makeFooter();
		}
		
		return buffer.toString();
	}
	
	public void makeHeader(Subject subject) {
		
		buffer.append(LINE);
		buffer.append("\t");
		buffer.append(subject.getSubjectName());
		buffer.append(TITLE);
		buffer.append(LINE);
		
		buffer.append(HEADER);
		buffer.append(LINE);
	}
	
	public void makeBody(Subject subject) {
		
		ArrayList<Student> studentList = school.getStudentList(); //학교에 등록된 학생 리스트
		
		for(int i=0; i < studentList.size(); i++) {
			
			Student student = studentList.get(i); // 리스트에 있는 학생
			
			buffer.append(student.getStudentName());	// 학생 이름
			buffer.append(" | ");
			buffer.append(student.getStudentId()); // 학번
			buffer.append(" | ");
			buffer.append(student.getMajorSubject().getSubjectName()); // 중점과목
			buffer.append("   | ");
			
			getScoreGrade(student, subject.getSubjectId());
			buffer.append("\n");
			buffer.append(LINE);
			
		}
	}
	
	public void getScoreGrade(Student student, int subjectId) {
		
		ArrayList<Score> scoreList = student.getScoreList(); //해당 학생의 점수 목록
		
		int majorId = student.getMajorSubject().getSubjectId();
		
		GradeEvaluation[] gradeEvaluation = {new BasicEvaluation(), new MajorEvaluation()};//학점 평가 클래스{0,1}
		
		//학생이 가진 점수들
		for(int i = 0; i < scoreList.size(); i++) {
			
			
			if(scoreList.get(i).getSubject().getSubjectId() == subjectId) {
			
				String grade;
				
				if(scoreList.get(i).getSubject().getSubjectId() == majorId)  {
					grade = gradeEvaluation[Define.SAB_TYPE].getGrade(scoreList.get(i).getPoint());
				}
				else
					grade = gradeEvaluation[Define.AB_TYPE].getGrade(scoreList.get(i).getPoint());
				
				buffer.append(scoreList.get(i).getPoint());
				buffer.append(" : ");
				buffer.append(grade);
				
				
			}
		}

	}
	public void makeFooter() {
		
		buffer.append("\n");
	}
}
