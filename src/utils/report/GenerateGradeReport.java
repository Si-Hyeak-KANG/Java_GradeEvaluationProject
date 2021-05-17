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
	
	public static final String TITLE = " ������ ���� \t\t\n";
	public static final String HEADER = " �̐a |  �й�   | �������� |  ���� \t\n";
	public static final String LINE = "---------------------------------\n";
	
	private StringBuffer buffer = new StringBuffer();
	
	
	public String getReport() {
		
		//��� ���� ���� ���� ����
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
		
		ArrayList<Student> studentList = school.getStudentList(); //�б��� ��ϵ� �л� ����Ʈ
		
		for(int i=0; i < studentList.size(); i++) {
			
			Student student = studentList.get(i); // ����Ʈ�� �ִ� �л�
			
			buffer.append(student.getStudentName());	// �л� �̸�
			buffer.append(" | ");
			buffer.append(student.getStudentId()); // �й�
			buffer.append(" | ");
			buffer.append(student.getMajorSubject().getSubjectName()); // ��������
			buffer.append("   | ");
			
			getScoreGrade(student, subject.getSubjectId());
			buffer.append("\n");
			buffer.append(LINE);
			
		}
	}
	
	public void getScoreGrade(Student student, int subjectId) {
		
		ArrayList<Score> scoreList = student.getScoreList(); //�ش� �л��� ���� ���
		
		int majorId = student.getMajorSubject().getSubjectId();
		
		GradeEvaluation[] gradeEvaluation = {new BasicEvaluation(), new MajorEvaluation()};//���� �� Ŭ����{0,1}
		
		//�л��� ���� ������
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
