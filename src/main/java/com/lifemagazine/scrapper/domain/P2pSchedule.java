package com.lifemagazine.scrapper.domain;

import java.util.Calendar;
import java.util.TimeZone;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor 
@AllArgsConstructor
@Entity 
@Table(name="TX_P2P_SCHEDULE")
public class P2pSchedule {

	public static final String TABLE_NAME = "TX_P2P_SCHEDULE";
	
	@Id
	@Column(name = "SCH_ID")
	private String schId;
	
	@Column(name = "SHPR_CD")
	private String shprCd;
	
	@Column(name = "VESSEL_ID")
	private Integer vesselId;
	
	@Column(name = "VESSEL_NM")
	private String vesselNm;
	
	@Column(name = "VESSEL_MAP_YN")
	private String vesselMapYn;
	
	@Column(name = "VOYAGE")
	private String voyage;
	
	@Column(name = "SRVC_CD")
	private String srvcCd;
	
	@Column(name = "DEP_LOCATION_ID")
	private Integer depLocation;
	
	@Column(name = "DEP_ETA")
	private String depEta;
	
	@Column(name = "DEP_ETD")
	private String depEtd;
	
	@Column(name = "ARR_LOCATION_ID")
	private Integer arrLocation;
	
	@Column(name = "ARR_ETA")
	private String arrEta;
	
	@Column(name = "ARR_ETD")
	private String arrEtd;
	
	@Column(name = "TRANS_TP")
	private String transTp;
	
	@Column(name = "TT")
	private Integer tt;
	
	@Column(name = "DOC_CLOSE_DTM")
	private String docCloseDtm;
	
	@Column(name = "CARGO_CLOSE_DTM")
	private String cargoCloseDtm;
	
	@Column(name = "REMARK")
	private String remark;
	
	@Column(name = "REG_DATE")
	private Calendar regDate = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
	
	public String getSchId() {
		return schId;
	}

	public void setSchId(String schId) {
		this.schId = schId;
	}

	public String getShprCd() {
		return shprCd;
	}

	public void setShprCd(String shprCd) {
		this.shprCd = shprCd;
	}

	public Integer getVesselId() {
		return vesselId;
	}

	public void setVesselId(Integer vesselId) {
		this.vesselId = vesselId;
	}

	public String getVesselNm() {
		return vesselNm;
	}

	public void setVesselNm(String vesselNm) {
		this.vesselNm = vesselNm;
	}

	public String getVesselMapYn() {
		return vesselMapYn;
	}

	public void setVesselMapYn(String vesselMapYn) {
		this.vesselMapYn = vesselMapYn;
	}

	public String getVoyage() {
		return voyage;
	}

	public void setVoyage(String voyage) {
		this.voyage = voyage;
	}

	public String getSrvcCd() {
		return srvcCd;
	}

	public void setSrvcCd(String srvcCd) {
		this.srvcCd = srvcCd;
	}

	public Integer getDepLocation() {
		return depLocation;
	}

	public void setDepLocation(Integer depLocation) {
		this.depLocation = depLocation;
	}

	public String getDepEta() {
		return depEta;
	}

	public void setDepEta(String depEta) {
		this.depEta = depEta;
	}

	public String getDepEtd() {
		return depEtd;
	}

	public void setDepEtd(String depEtd) {
		this.depEtd = depEtd;
	}

	public Integer getArrLocation() {
		return arrLocation;
	}

	public void setArrLocation(Integer arrLocation) {
		this.arrLocation = arrLocation;
	}

	public String getArrEta() {
		return arrEta;
	}

	public void setArrEta(String arrEta) {
		this.arrEta = arrEta;
	}

	public String getArrEtd() {
		return arrEtd;
	}

	public void setArrEtd(String arrEtd) {
		this.arrEtd = arrEtd;
	}

	public String getTransTp() {
		return transTp;
	}

	public void setTransTp(String transTp) {
		this.transTp = transTp;
	}

	public Integer getTt() {
		return tt;
	}

	public void setTt(Integer tt) {
		this.tt = tt;
	}

	public String getDocCloseDtm() {
		return docCloseDtm;
	}

	public void setDocCloseDtm(String docCloseDtm) {
		this.docCloseDtm = docCloseDtm;
	}

	public String getCargoCloseDtm() {
		return cargoCloseDtm;
	}

	public void setCargoCloseDtm(String cargoCloseDtm) {
		this.cargoCloseDtm = cargoCloseDtm;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Calendar getRegDate() {
		return regDate;
	}

	public void setRegDate(Calendar regDate) {
		this.regDate = regDate;
	}
	
}
