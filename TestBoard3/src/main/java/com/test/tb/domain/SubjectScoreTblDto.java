package com.test.tb.domain;

import java.util.List;import javax.security.auth.Subject;

public class SubjectScoreTblDto {
	//pk
	private int score_idx; 
	//이름
	private String score_id;
	//년도
	private String score_year;
	//학기
	private String score_semester;
	//과목
	private String score_subject;
	//점수
	private String score_score;
	//순번
	private int score_rownum;
	//수정용
	private List<SubjectScoreTblDto> list;
	//총응시자
	private int score_totalCnt;
	//과목수
	private int score_totalsubject;
	//평균
	private int score_totalavg;
	//총점
	private int score_totalscore;
	//지원과목수 
	private int score_subjectcnt;
	//점유순위
	private int score_rank;
	//점유율		
	private String score_share;
	//국어평균
	private int score_kor;
	//수학평균 
	private int score_mat;
	//영어펴균
	private int score_eng;
	//사회평균
	private int score_soc;
	//과학평균
	private int score_sin;
	//점수 구분자
	private String score_totsort;
	//순서구분자
	private String score_sort;
	//수정창 체크박스
	private String editChk;
	
	
	
	
	public int getScore_idx() {
		return score_idx;
	}
	public void setScore_idx(int score_idx) {
		this.score_idx = score_idx;
	}
	public String getScore_id() {
		return score_id;
	}
	public void setScore_id(String score_id) {
		this.score_id = score_id;
	}
	public String getScore_year() {
		return score_year;
	}
	public void setScore_year(String score_year) {
		this.score_year = score_year;
	}
	public String getScore_semester() {
		return score_semester;
	}
	public void setScore_semester(String score_semester) {
		this.score_semester = score_semester;
	}
	public String getScore_subject() {
		return score_subject;
	}
	public void setScore_subject(String score_subject) {
		this.score_subject = score_subject;
	}
	public String getScore_score() {
		return score_score;
	}
	public void setScore_score(String score_score) {
		this.score_score = score_score;
	}
	public int getScore_rownum() {
		return score_rownum;
	}
	public void setScore_rownum(int score_rownum) {
		this.score_rownum = score_rownum;
	}
	
	public List<SubjectScoreTblDto> getList() {
		return list;
	}
	public void setList(List<SubjectScoreTblDto> list) {
		this.list = list;
	}
	public int getScore_totalCnt() {
		return score_totalCnt;
	}
	public void setScore_totalCnt(int score_totalCnt) {
		this.score_totalCnt = score_totalCnt;
	}
	public int getScore_totalsubject() {
		return score_totalsubject;
	}
	public void setScore_totalsubject(int score_totalsubject) {
		this.score_totalsubject = score_totalsubject;
	}
	public int getScore_totalavg() {
		return score_totalavg;
	}
	public void setScore_totalavg(int score_totalavg) {
		this.score_totalavg = score_totalavg;
	}
	public int getScore_totalscore() {
		return score_totalscore;
	}
	public void setScore_totalscore(int score_totalscore) {
		this.score_totalscore = score_totalscore;
	}
	public int getScore_subjectcnt() {
		return score_subjectcnt;
	}
	public void setScore_subjectcnt(int score_subjectcnt) {
		this.score_subjectcnt = score_subjectcnt;
	}
	
	public int getScore_rank() {
		return score_rank;
	}
	public void setScore_rank(int score_rank) {
		this.score_rank = score_rank;
	}
	
	public String getScore_share() {
		return score_share;
	}
	public void setScore_share(String score_share) {
		this.score_share = score_share;
	}
	public int getScore_kor() {
		return score_kor;
	}
	public void setScore_kor(int score_kor) {
		this.score_kor = score_kor;
	}
	public int getScore_mat() {
		return score_mat;
	}
	public void setScore_mat(int score_mat) {
		this.score_mat = score_mat;
	}
	public int getScore_eng() {
		return score_eng;
	}
	public void setScore_eng(int score_eng) {
		this.score_eng = score_eng;
	}
	public int getScore_soc() {
		return score_soc;
	}
	public void setScore_soc(int score_soc) {
		this.score_soc = score_soc;
	}
	public int getScore_sin() {
		return score_sin;
	}
	public void setScore_sin(int score_sin) {
		this.score_sin = score_sin;
	}
	public String getScore_totsort() {
		return score_totsort;
	}
	public void setScore_totsort(String score_totsort) {
		this.score_totsort = score_totsort;
	}
	public String getScore_sort() {
		return score_sort;
	}
	public void setScore_sort(String score_sort) {
		this.score_sort = score_sort;
	}
	
	public String getEditChk() {
		return editChk;
	}
	public void setEditChk(String editChk) {
		this.editChk = editChk;
	}
	@Override
	public String toString() {
		return "SubjectScoreTblDto [score_idx=" + score_idx + ", score_id=" + score_id + ", score_year=" + score_year
				+ ", score_semester=" + score_semester + ", score_subject=" + score_subject + ", score_score="
				+ score_score + ", score_rownum=" + score_rownum + ", list=" + list + ", score_totalCnt="
				+ score_totalCnt + ", score_totalsubject=" + score_totalsubject + ", score_totalavg=" + score_totalavg
				+ ", score_totalscore=" + score_totalscore + ", score_subjectcnt=" + score_subjectcnt + ", score_rank="
				+ score_rank + ", score_share=" + score_share + ", score_kor=" + score_kor + ", score_mat=" + score_mat
				+ ", score_eng=" + score_eng + ", score_soc=" + score_soc + ", score_sin=" + score_sin
				+ ", score_totsort=" + score_totsort + ", score_sort=" + score_sort + ", editChk=" + editChk + "]";
	}

	
	
}
