package com.lifemagazine.scrapper.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tx_check_sched_log")
@ToString
public class CheckSchedLog {

	@Id
	@Column(name="check_sched_log_seq")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer checkSchedLogSeq;
	@Column(name="scrapper_id")
	private Integer scrapperId;
	@Column(name="error_msg")
	private String errorMsg;
	@Column(name="result_yn")
	private String resultYn;
	@Column(name="modify_user")
	private String modifyUser;
	@Column(name="modify_date")
	private String modifyDate;
	
	public CheckSchedLog() {}

	public Integer getCheckSchedLogSeq() {
		return checkSchedLogSeq;
	}

	public void setCheckSchedLogSeq(Integer checkSchedLogSeq) {
		this.checkSchedLogSeq = checkSchedLogSeq;
	}

	public Integer getScrapperId() {
		return scrapperId;
	}

	public void setScrapperId(Integer scrapperId) {
		this.scrapperId = scrapperId;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public String getResultYn() {
		return resultYn;
	}

	public void setResultYn(String resultYn) {
		this.resultYn = resultYn;
	}

	public String getModifyUser() {
		return modifyUser;
	}

	public void setModifyUser(String modifyUser) {
		this.modifyUser = modifyUser;
	}

	public String getModifyDate() {
		return this.modifyDate;
	}

	public void setModifyDate(String modifyDate) {
		this.modifyDate = modifyDate;
	}
}
