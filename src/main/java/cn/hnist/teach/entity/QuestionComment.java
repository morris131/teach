package cn.hnist.teach.entity;


import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * QuestionComment entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "question_comment", catalog = "teach")
public class QuestionComment implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer questionId;
	private String questionName;
	private String questionClass;
	private String questionTel;
	private String questionEmail;
	private Timestamp questionDate;
	private String questionTitle;
	private String questionContent;
	private String questionReply;

	// Constructors

	/** default constructor */
	public QuestionComment() {
	}

	/** minimal constructor */
	public QuestionComment(String questionName, String questionClass,
			String questionTel, String questionEmail, Timestamp questionDate,
			String questionTitle, String questionContent) {
		this.questionName = questionName;
		this.questionClass = questionClass;
		this.questionTel = questionTel;
		this.questionEmail = questionEmail;
		this.questionDate = questionDate;
		this.questionTitle = questionTitle;
		this.questionContent = questionContent;
	}

	/** full constructor */
	public QuestionComment(String questionName, String questionClass,
			String questionTel, String questionEmail, Timestamp questionDate,
			String questionTitle, String questionContent, String questionReply) {
		this.questionName = questionName;
		this.questionClass = questionClass;
		this.questionTel = questionTel;
		this.questionEmail = questionEmail;
		this.questionDate = questionDate;
		this.questionTitle = questionTitle;
		this.questionContent = questionContent;
		this.questionReply = questionReply;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "question_id", unique = true, nullable = false)
	public Integer getQuestionId() {
		return this.questionId;
	}

	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}

	@Column(name = "question_name", nullable = false, length = 50)
	public String getQuestionName() {
		return this.questionName;
	}

	public void setQuestionName(String questionName) {
		this.questionName = questionName;
	}

	@Column(name = "question_class", nullable = false, length = 50)
	public String getQuestionClass() {
		return this.questionClass;
	}

	public void setQuestionClass(String questionClass) {
		this.questionClass = questionClass;
	}

	@Column(name = "question_tel", nullable = false, length = 50)
	public String getQuestionTel() {
		return this.questionTel;
	}

	public void setQuestionTel(String questionTel) {
		this.questionTel = questionTel;
	}

	@Column(name = "question_email", nullable = false, length = 50)
	public String getQuestionEmail() {
		return this.questionEmail;
	}

	public void setQuestionEmail(String questionEmail) {
		this.questionEmail = questionEmail;
	}

	@Column(name = "question_date", nullable = false, length = 19)
	public Timestamp getQuestionDate() {
		return this.questionDate;
	}

	public void setQuestionDate(Timestamp questionDate) {
		this.questionDate = questionDate;
	}

	@Column(name = "question_title", nullable = false, length = 50)
	public String getQuestionTitle() {
		return this.questionTitle;
	}

	public void setQuestionTitle(String questionTitle) {
		this.questionTitle = questionTitle;
	}

	@Column(name = "question_content", nullable = false, length = 65535)
	public String getQuestionContent() {
		return this.questionContent;
	}

	public void setQuestionContent(String questionContent) {
		this.questionContent = questionContent;
	}

	@Column(name = "question_reply", length = 65535)
	public String getQuestionReply() {
		return this.questionReply;
	}

	public void setQuestionReply(String questionReply) {
		this.questionReply = questionReply;
	}

}