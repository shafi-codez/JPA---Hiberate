package com.iit.mp2hib;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Admin
 */
@Entity
@XmlRootElement
public class USCensusPopulationData implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "SUMLEV")
    private Integer sumlev;
    @Column(name = "REGION")
    private Integer region;
    @Column(name = "DIVISION")
    private Integer division;
    @Column(name = "STATE")
    private Integer state;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "NAME")
    private String name;
    @Column(name = "CENSUS2010POP")
    private Integer census2010pop;
    @Column(name = "ESTIMATESBASE2010")
    private Integer estimatesbase2010;
    @Column(name = "POPESTIMATE2010")
    private Integer popestimate2010;
    @Column(name = "POPESTIMATE2011")
    private Integer popestimate2011;
    @Column(name = "NPOPCHG_2010")
    private Integer npopchg2010;
    @Column(name = "NPOPCHG_2011")
    private Integer npopchg2011;
    @Column(name = "BIRTHS2010")
    private Integer births2010;
    @Column(name = "BIRTHS2011")
    private Integer births2011;
    @Column(name = "DEATHS2010")
    private Integer deaths2010;
    @Column(name = "DEATHS2011")
    private Integer deaths2011;
    @Column(name = "NATURALINC2010")
    private Integer naturalinc2010;
    @Column(name = "NATURALINC2011")
    private Integer naturalinc2011;
    @Column(name = "INTERNATIONALMIG2010")
    private Integer internationalmig2010;
    @Column(name = "INTERNATIONALMIG2011")
    private Integer internationalmig2011;
    @Column(name = "DOMESTICMIG2010")
    private Integer domesticmig2010;
    @Column(name = "DOMESTICMIG2011")
    private Integer domesticmig2011;
    @Column(name = "NETMIG2010")
    private Integer netmig2010;
    @Column(name = "NETMIG2011")
    private Integer netmig2011;
    @Column(name = "RESIDUAL2010")
    private Integer residual2010;
    @Column(name = "RESIDUAL2011")
    private Integer residual2011;
    @Column(name = "RBIRTH2011")
    private Float rbirth2011;
    @Column(name = "RDEATH2011")
    private Float rdeath2011;
    @Column(name = "RNATURALINC2011")
    private Float rnaturalinc2011;
    @Column(name = "RINTERNATIONALMIG2011")
    private Float rinternationalmig2011;
    @Column(name = "RDOMESTICMIG2011")
    private Float rdomesticmig2011;
    @Column(name = "RNETMIG2011")
    private Float rnetmig2011;

    public USCensusPopulationData() {
    }

    @SuppressWarnings("OverridableMethodCallInConstructor")
    public USCensusPopulationData(String[] rowVal) {
        System.out.println("My value is ="+rowVal.length);
        if (rowVal.length == 31) {
            setSumlev(Integer.parseInt(rowVal[0]));
            setRegion(Integer.parseInt(rowVal[1].replace("X", "-1")));
            setDivision(Integer.parseInt(rowVal[2].replace("X", "-1")));
            setState(Integer.parseInt(rowVal[3]));
            setName(rowVal[4]);
            setCensus2010pop(Integer.parseInt(rowVal[5]));
            setEstimatesbase2010(Integer.parseInt(rowVal[6]));
            setPopestimate2010(Integer.parseInt(rowVal[7]));
            setPopestimate2011(Integer.parseInt(rowVal[8]));
            setNpopchg2010(Integer.parseInt(rowVal[9]));
            setNpopchg2011(Integer.parseInt(rowVal[10]));
            setBirths2010(Integer.parseInt(rowVal[11]));
            setBirths2011(Integer.parseInt(rowVal[12]));
            setDeaths2010(Integer.parseInt(rowVal[13]));
            setDeaths2011(Integer.parseInt(rowVal[14]));  
            setNaturalinc2010(Integer.parseInt(rowVal[15]));
            setNaturalinc2011(Integer.parseInt(rowVal[16]));
            setInternationalmig2010(Integer.parseInt(rowVal[17]));
            setInternationalmig2011(Integer.parseInt(rowVal[18]));
            setDomesticmig2010(Integer.parseInt(rowVal[19]));
            setDomesticmig2011(Integer.parseInt(rowVal[20]));
            setNetmig2010(Integer.parseInt(rowVal[21]));
            setNetmig2011(Integer.parseInt(rowVal[22]));
            setResidual2010(Integer.parseInt(rowVal[23]));
            setResidual2011(Integer.parseInt(rowVal[24]));
            setRbirth2011(Float.parseFloat(rowVal[25]));
            setRdeath2011(Float.parseFloat(rowVal[26]));
            setRnaturalinc2011(Float.parseFloat(rowVal[27]));
            setRinternationalmig2011(Float.parseFloat(rowVal[28]));
            setRdomesticmig2011(Float.parseFloat(rowVal[29]));
            setRnetmig2011(Float.parseFloat(rowVal[30]));
  
        }
    }

    public USCensusPopulationData(Integer state) {
        this.state = state;
    }

    public Integer getSumlev() {
        return sumlev;
    }

    public void setSumlev(Integer sumlev) {
        this.sumlev = sumlev;
    }

    public Integer getRegion() {
        return region;
    }

    public void setRegion(Integer region) {
        this.region = region;
    }

    public Integer getDivision() {
        return division;
    }

    public void setDivision(Integer division) {
        this.division = division;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCensus2010pop() {
        return census2010pop;
    }

    public void setCensus2010pop(Integer census2010pop) {
        this.census2010pop = census2010pop;
    }

    public Integer getEstimatesbase2010() {
        return estimatesbase2010;
    }

    public void setEstimatesbase2010(Integer estimatesbase2010) {
        this.estimatesbase2010 = estimatesbase2010;
    }

    public Integer getPopestimate2010() {
        return popestimate2010;
    }

    public void setPopestimate2010(Integer popestimate2010) {
        this.popestimate2010 = popestimate2010;
    }

    public Integer getPopestimate2011() {
        return popestimate2011;
    }

    public void setPopestimate2011(Integer popestimate2011) {
        this.popestimate2011 = popestimate2011;
    }

    public Integer getNpopchg2010() {
        return npopchg2010;
    }

    public void setNpopchg2010(Integer npopchg2010) {
        this.npopchg2010 = npopchg2010;
    }

    public Integer getNpopchg2011() {
        return npopchg2011;
    }

    public void setNpopchg2011(Integer npopchg2011) {
        this.npopchg2011 = npopchg2011;
    }

    public Integer getBirths2010() {
        return births2010;
    }

    public void setBirths2010(Integer births2010) {
        this.births2010 = births2010;
    }

    public Integer getBirths2011() {
        return births2011;
    }

    public void setBirths2011(Integer births2011) {
        this.births2011 = births2011;
    }

    public Integer getDeaths2010() {
        return deaths2010;
    }

    public void setDeaths2010(Integer deaths2010) {
        this.deaths2010 = deaths2010;
    }

    public Integer getDeaths2011() {
        return deaths2011;
    }

    public void setDeaths2011(Integer deaths2011) {
        this.deaths2011 = deaths2011;
    }

    public Integer getNaturalinc2010() {
        return naturalinc2010;
    }

    public void setNaturalinc2010(Integer naturalinc2010) {
        this.naturalinc2010 = naturalinc2010;
    }

    public Integer getNaturalinc2011() {
        return naturalinc2011;
    }

    public void setNaturalinc2011(Integer naturalinc2011) {
        this.naturalinc2011 = naturalinc2011;
    }

    public Integer getInternationalmig2010() {
        return internationalmig2010;
    }

    public void setInternationalmig2010(Integer internationalmig2010) {
        this.internationalmig2010 = internationalmig2010;
    }

    public Integer getInternationalmig2011() {
        return internationalmig2011;
    }

    public void setInternationalmig2011(Integer internationalmig2011) {
        this.internationalmig2011 = internationalmig2011;
    }

    public Integer getDomesticmig2010() {
        return domesticmig2010;
    }

    public void setDomesticmig2010(Integer domesticmig2010) {
        this.domesticmig2010 = domesticmig2010;
    }

    public Integer getDomesticmig2011() {
        return domesticmig2011;
    }

    public void setDomesticmig2011(Integer domesticmig2011) {
        this.domesticmig2011 = domesticmig2011;
    }

    public Integer getNetmig2010() {
        return netmig2010;
    }

    public void setNetmig2010(Integer netmig2010) {
        this.netmig2010 = netmig2010;
    }

    public Integer getNetmig2011() {
        return netmig2011;
    }

    public void setNetmig2011(Integer netmig2011) {
        this.netmig2011 = netmig2011;
    }

    public Integer getResidual2010() {
        return residual2010;
    }

    public void setResidual2010(Integer residual2010) {
        this.residual2010 = residual2010;
    }

    public Integer getResidual2011() {
        return residual2011;
    }

    public void setResidual2011(Integer residual2011) {
        this.residual2011 = residual2011;
    }

    public Float getRbirth2011() {
        return rbirth2011;
    }

    public void setRbirth2011(Float rbirth2011) {
        this.rbirth2011 = rbirth2011;
    }

    public Float getRdeath2011() {
        return rdeath2011;
    }

    public void setRdeath2011(Float rdeath2011) {
        this.rdeath2011 = rdeath2011;
    }

    public Float getRnaturalinc2011() {
        return rnaturalinc2011;
    }

    public void setRnaturalinc2011(Float rnaturalinc2011) {
        this.rnaturalinc2011 = rnaturalinc2011;
    }

    public Float getRinternationalmig2011() {
        return rinternationalmig2011;
    }

    public void setRinternationalmig2011(Float rinternationalmig2011) {
        this.rinternationalmig2011 = rinternationalmig2011;
    }

    public Float getRdomesticmig2011() {
        return rdomesticmig2011;
    }

    public void setRdomesticmig2011(Float rdomesticmig2011) {
        this.rdomesticmig2011 = rdomesticmig2011;
    }

    public Float getRnetmig2011() {
        return rnetmig2011;
    }

    public void setRnetmig2011(Float rnetmig2011) {
        this.rnetmig2011 = rnetmig2011;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (state != null ? state.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof USCensusPopulationData)) {
            return false;
        }
        USCensusPopulationData other = (USCensusPopulationData) object;
        if ((this.state == null && other.state != null) || (this.state != null && !this.state.equals(other.state))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "USCensusPopulationData{" + "sumlev=" + sumlev + ", region=" + region + ", division=" + division + ", state=" + state + ", name=" + name + ", census2010pop=" + census2010pop + ", estimatesbase2010=" + estimatesbase2010 + ", popestimate2010=" + popestimate2010 + ", popestimate2011=" + popestimate2011 + ", npopchg2010=" + npopchg2010 + ", npopchg2011=" + npopchg2011 + ", births2010=" + births2010 + ", births2011=" + births2011 + ", deaths2010=" + deaths2010 + ", deaths2011=" + deaths2011 + ", naturalinc2010=" + naturalinc2010 + ", naturalinc2011=" + naturalinc2011 + ", internationalmig2010=" + internationalmig2010 + ", internationalmig2011=" + internationalmig2011 + ", domesticmig2010=" + domesticmig2010 + ", domesticmig2011=" + domesticmig2011 + ", netmig2010=" + netmig2010 + ", netmig2011=" + netmig2011 + ", residual2010=" + residual2010 + ", residual2011=" + residual2011 + ", rbirth2011=" + rbirth2011 + ", rdeath2011=" + rdeath2011 + ", rnaturalinc2011=" + rnaturalinc2011 + ", rinternationalmig2011=" + rinternationalmig2011 + ", rdomesticmig2011=" + rdomesticmig2011 + ", rnetmig2011=" + rnetmig2011 + '}';
    }

    
}
