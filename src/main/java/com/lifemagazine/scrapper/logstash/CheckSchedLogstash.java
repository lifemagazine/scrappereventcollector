package com.lifemagazine.scrapper.logstash;

public class CheckSchedLogstash {

	public String getShprCd() {
		return shprCd;
	}
	public void setShprCd(String shprCd) {
		this.shprCd = shprCd;
	}
	public String getScrapperType() {
		return scrapperType;
	}
	public void setScrapperType(String scrapperType) {
		this.scrapperType = scrapperType;
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
		return modifyDate;
	}
	public void setModifyDate(String modifyDate) {
		String[] tmp = modifyDate.split(",");
		String s = "20" + tmp[0];
		this.modifyDate = s;
	}
	
	private String shprCd;
	private String scrapperType;
	private String errorMsg;
	private String resultYn;
	private String modifyUser;
	private String modifyDate;
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("shprCd=").append(shprCd).append(", scrapperType=").append(scrapperType).append(", errorMsg=")
			.append(errorMsg).append(", resultYn=").append(resultYn).append(", modifyUser=").append(modifyUser).append(", modifyDate=").append(modifyDate);
		return sb.toString();
	}
}
