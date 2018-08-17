package com.ylfcf.ppp.entity;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by yjx on 2018/8/13.
 */
public class BorrowInfoSafeInfo implements Serializable{


    /**
     * danbaohan : <p><img src="http://www.dev_admin.com/upload/image/20180807/1533636519456136.jpg" title="1533636519456136.jpg" alt="20160721102409115.jpg"/></p>
     * danbaohan_nomark : <p><img src="http://www.dev_admin.com/upload/image/20180807/1533636530657525.jpg" title="1533636530657525.jpg" alt="20170928055040833.jpg"/></p>
     * project_overview : <p>aerharhaehehehaehadfhhhhhhhhhh</p>
     * measures : <p>garehaehaafhhhhhhhhhhhhh</p>
     * repay_from : <p>harhrahahfaghawrhrrrrrr</p>
     * repo_letter : <p><img src="http://www.dev_admin.com/upload/image/20180807/1533636582309140.jpg" title="1533636582309140.jpg" alt="20160721105755349.jpg"/></p>
     * repo_letter_nomark : <p><img src="http://www.dev_admin.com/upload/image/20180807/1533636575559154.jpg" title="1533636575559154.jpg" alt="20160721102600677.jpg"/></p>
     * confirm_letter : <p><img src="http://www.dev_admin.com/upload/image/20180807/1533636589628522.jpg" title="1533636589628522.jpg" alt="20160721105424361.jpg"/></p>
     * confirm_letter_nomark : <p><img src="http://www.dev_admin.com/upload/image/20180807/1533636596115927.jpg" title="1533636596115927.jpg" alt="20160721105655961.jpg"/></p>
     * materials : <p><img src="http://www.dev_admin.com/upload/image/20180807/1533636556106202.jpg" title="1533636556106202.jpg" alt="20160721102724786.jpg"/></p>
     * materials_nomark : <p><img src="http://www.dev_admin.com/upload/image/20180807/1533636548630243.jpg" title="1533636548630243.jpg" alt="20160721105516749.jpg"/></p>
     * materials_img_name : fagawgawg
     * entity_status : 尽调通过
     * yyzz : <p style="text-align: center;"><img src="http://www.dev_admin.com/upload/image/20180730/1532932394134848.jpg" title="1532932394134848.jpg" alt="aboutusimg.jpg" style="width: 764px; height: 309px;" width="764" height="309"/></p>
     * yyzz_mark : <p><img src="http://www.dev_admin.com/upload/image/20180807/1533636480648575.jpg" style="float:right;" title="1533636480648575.jpg" alt="20170928055027314.jpg"/></p>
     * true_promise_picture : <p><img src="http://www.dev_admin.com/upload/image/20180807/1533638990970538.jpg" title="1533638990970538.jpg" alt="20160721102724786.jpg"/></p>
     */

    private String                        danbaohan;//担保函 1
    private String                        danbaohan_nomark;//担保函无码 2
    private String                        project_overview;//项目概述
    private String                        measures;//担保措施
    private String                        repay_from;//偿还来源
    private String                        repo_letter;//回购函 1
    private String                        repo_letter_nomark;//回购函无码 2
    private String                        confirm_letter;//确认函 1
    private String                        confirm_letter_nomark;//确认函无码 2
    private String                        materials;//材料
    private String                        materials_nomark;//材料无码
    private String                        materials_img_name;//材料名称
    private String                        entity_status;
    private String                        yyzz;//营业执照 1
    private String                        yyzz_mark;//营业执照打码 2
    private String                        true_promise_picture;//真实性承诺函 1 2
    private ArrayList<ProjectCailiaoInfo> cailiaoMarkList;//打码的材料的集合
    private ArrayList<ProjectCailiaoInfo> cailiaoNoMarkList;//没有打码的材料的集合

    public ArrayList<ProjectCailiaoInfo> getCailiaoMarkList() {
        return cailiaoMarkList;
    }

    public void setCailiaoMarkList(ArrayList<ProjectCailiaoInfo> cailiaoMarkList) {
        this.cailiaoMarkList = cailiaoMarkList;
    }

    public ArrayList<ProjectCailiaoInfo> getCailiaoNoMarkList() {
        return cailiaoNoMarkList;
    }

    public void setCailiaoNoMarkList(ArrayList<ProjectCailiaoInfo> cailiaoNoMarkList) {
        this.cailiaoNoMarkList = cailiaoNoMarkList;
    }

    public String getDanbaohan() {
        return danbaohan;
    }

    public void setDanbaohan(String danbaohan) {
        this.danbaohan = danbaohan;
    }

    public String getDanbaohan_nomark() {
        return danbaohan_nomark;
    }

    public void setDanbaohan_nomark(String danbaohan_nomark) {
        this.danbaohan_nomark = danbaohan_nomark;
    }

    public String getProject_overview() {
        return project_overview;
    }

    public void setProject_overview(String project_overview) {
        this.project_overview = project_overview;
    }

    public String getMeasures() {
        return measures;
    }

    public void setMeasures(String measures) {
        this.measures = measures;
    }

    public String getRepay_from() {
        return repay_from;
    }

    public void setRepay_from(String repay_from) {
        this.repay_from = repay_from;
    }

    public String getRepo_letter() {
        return repo_letter;
    }

    public void setRepo_letter(String repo_letter) {
        this.repo_letter = repo_letter;
    }

    public String getRepo_letter_nomark() {
        return repo_letter_nomark;
    }

    public void setRepo_letter_nomark(String repo_letter_nomark) {
        this.repo_letter_nomark = repo_letter_nomark;
    }

    public String getConfirm_letter() {
        return confirm_letter;
    }

    public void setConfirm_letter(String confirm_letter) {
        this.confirm_letter = confirm_letter;
    }

    public String getConfirm_letter_nomark() {
        return confirm_letter_nomark;
    }

    public void setConfirm_letter_nomark(String confirm_letter_nomark) {
        this.confirm_letter_nomark = confirm_letter_nomark;
    }

    public String getMaterials() {
        return materials;
    }

    public void setMaterials(String materials) {
        this.materials = materials;
    }

    public String getMaterials_nomark() {
        return materials_nomark;
    }

    public void setMaterials_nomark(String materials_nomark) {
        this.materials_nomark = materials_nomark;
    }

    public String getMaterials_img_name() {
        return materials_img_name;
    }

    public void setMaterials_img_name(String materials_img_name) {
        this.materials_img_name = materials_img_name;
    }

    public String getEntity_status() {
        return entity_status;
    }

    public void setEntity_status(String entity_status) {
        this.entity_status = entity_status;
    }

    public String getYyzz() {
        return yyzz;
    }

    public void setYyzz(String yyzz) {
        this.yyzz = yyzz;
    }

    public String getYyzz_mark() {
        return yyzz_mark;
    }

    public void setYyzz_mark(String yyzz_mark) {
        this.yyzz_mark = yyzz_mark;
    }

    public String getTrue_promise_picture() {
        return true_promise_picture;
    }

    public void setTrue_promise_picture(String true_promise_picture) {
        this.true_promise_picture = true_promise_picture;
    }
}
