package com.example.bean.question;


import javax.persistence.*;
import java.util.Date;

/**
 * 
 * 2018-11-14
 */
@Table(name = "t_lable_info")
public class TLableInfo {
    /**
     * label_id: 
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer labelId;

    /**
     * label_name: 
     */
    private String labelName;

    /**
     * parent_label_id: 
     */
    private Integer parentLabelId;

    /**
     * label_type: 
     */
    private String labelType;

    /**
     * status: 
     */
    private String status;

    /**
     * label_desc: 
     */
    private String labelDesc;

    /**
     * create_by: 
     */
    private Integer createBy;

    /**
     * create_time: 
     */
    private Date createTime;

    /**
     * modify_time: 
     */
    private Date modifyTime;

    /**
     * modify_by: 
     */
    private Integer modifyBy;

    /**
     * 
     */
    @Column(name = "label_id")
    public Integer getLabelId() {
        return labelId;
    }

    public void setLabelId(Integer labelId) {
        this.labelId = labelId;
    }

    /**
     * 
     */
    @Column(name = "label_name")
    public String getLabelName() {
        return labelName;
    }

    public void setLabelName(String labelName) {
        this.labelName = labelName == null ? null : labelName.trim();
    }

    /**
     * 
     */
    @Column(name = "parent_label_id")
    public Integer getParentLabelId() {
        return parentLabelId;
    }

    public void setParentLabelId(Integer parentLabelId) {
        this.parentLabelId = parentLabelId;
    }

    /**
     * 
     */
    @Column(name = "label_type")
    public String getLabelType() {
        return labelType;
    }

    public void setLabelType(String labelType) {
        this.labelType = labelType == null ? null : labelType.trim();
    }

    /**
     * 
     */
    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * 
     */
    @Column(name = "label_desc")
    public String getLabelDesc() {
        return labelDesc;
    }

    public void setLabelDesc(String labelDesc) {
        this.labelDesc = labelDesc == null ? null : labelDesc.trim();
    }

    /**
     * 
     */
    @Column(name = "create_by")
    public Integer getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    /**
     * 
     */
    @Column(name = "create_time")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 
     */
    @Column(name = "modify_time")
    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * 
     */
    @Column(name = "modify_by")
    public Integer getModifyBy() {
        return modifyBy;
    }

    public void setModifyBy(Integer modifyBy) {
        this.modifyBy = modifyBy;
    }
}