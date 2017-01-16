package com.lifemagazine.scrapper.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor 
@AllArgsConstructor
@Entity @Table(name="TX_P2P_SCHEDULE_SUB")
public class P2pScheduleSub {

	public static final String TABLE_NAME = "TX_P2P_SCHEDULE_SUB";
	
	@Id
	@Column(name = "SCH_SUB_ID")
	private String schSubId;
	
	@Column(name = "SCH_ID")
	private String schId;
	
	@Column(name = "SEQ")
	private Integer seq;
	
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
	private Integer depLocationId;
	
	@Column(name = "DEP_PORT_NM")
	private String depPortNm;
	
	@Column(name = "DEP_TMNL_NM")
	private String depTmnlNm;
	
	@Column(name = "DEP_ETA")
	private String depEta;
	
	@Column(name = "DEP_ETD")
	private String depEtd;
	
	@Column(name = "ARR_LOCATION_ID")
	private Integer arrLocationId;
	
	@Column(name = "ARR_PORT_NM")
	private String arrPortNm;
	
	@Column(name = "ARR_TMNL_NM")
	private String arrTmnlNm;
	
	@Column(name = "ARR_ETA")
	private String arrEta;
	
	@Column(name = "ARR_ETD")
	private String arrEtd;
	
	public String getSchSubId() {
		return schSubId;
	}

	public void setSchSubId(String schSubId) {
		this.schSubId = schSubId;
	}

	public String getSchId() {
		return schId;
	}

	public void setSchId(String schId) {
		this.schId = schId;
	}

	public Integer getSeq() {
		return seq;
	}

	public void setSeq(Integer seq) {
		this.seq = seq;
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

	public Integer getDepLocationId() {
		return depLocationId;
	}

	public void setDepLocationId(Integer depLocationId) {
		this.depLocationId = depLocationId;
	}

	public String getDepPortNm() {
		return depPortNm;
	}

	public void setDepPortNm(String depPortNm) {
		this.depPortNm = depPortNm;
	}

	public String getDepTmnlNm() {
		return depTmnlNm;
	}

	public void setDepTmnlNm(String depTmnlNm) {
		this.depTmnlNm = depTmnlNm;
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

	public Integer getArrLocationId() {
		return arrLocationId;
	}

	public void setArrLocationId(Integer arrLocationId) {
		this.arrLocationId = arrLocationId;
	}

	public String getArrPortNm() {
		return arrPortNm;
	}

	public void setArrPortNm(String arrPortNm) {
		this.arrPortNm = arrPortNm;
	}

	public String getArrTmnlNm() {
		return arrTmnlNm;
	}

	public void setArrTmnlNm(String arrTmnlNm) {
		this.arrTmnlNm = arrTmnlNm;
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
}
