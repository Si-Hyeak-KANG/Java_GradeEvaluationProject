package school;

public class Score {

	private int studentId;		//어떤 학생의
	private Subject subject;	//어떤 과목의
	private int point;			//점수
	
	
	public Score(int studentId, Subject subject, int point) {
		
		this.studentId = studentId;
		this.subject = subject;
		this.point = point;
		
	}
	
	public int getStudentId() {
		return studentId;
	}
	
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	
	public Subject getSubject() {
		return subject;
	}
	
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	
	public int getPoint() {
		return point;
	}
	
	public void setPoint(int point) {
		this.point = point;
	}
	
	
}
