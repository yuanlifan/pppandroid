package com.ylfcf.ppp.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by yjx on 2018/8/6.
 */
public class InvestmentListInfo implements Serializable {


    /**
     * list : [{"id":"10","loan_application_num":"1586392596","apply_id":"10","borrow_type":"企业","borrow_name":"101010","user_id":"372","actual_loan_money":"1200000","actual_raising_money":"5000","borrow_interest":"5.00","borrow_period":"24","borrow_status":"部分成立","show_status":"上架","add_time":"2018-07-30 11:41:59","update_time":"2018-07-31 11:38:40","publish_time":"2018-07-31 12:00:24","full_time":"2018-08-02 13:05:11","interest_start_time":"0000-00-00 00:00:00","interest_end_time":"0000-00-00 00:00:00","raising_period":"2018-08-02 13:05:11","return_type":"1","invest_highest":"0.00","invest_lowest":"0.00","co_user_entity_id":"1","apply_type":"企业","iphone":"15936259871","address":"0","address_detail":"0","use_purpose":"旅游消费","salary":"30000","repayment":"商铺收入","other_loan_num":"0","total_debt":"0","degree":"","job_type":"","industry":"","occupancy":"","commerce_club_name":"","commerce_club_addr":"","commerce_club_mobile":"","approve_money":"1000000","expire_time":"0000-00-00 00:00:00","is_show":"否","add_ip":"","apply_status":"待审核","order_type":null},{"id":"8","loan_application_num":"1586392578","apply_id":"8","borrow_type":"企业","borrow_name":"8888","user_id":"372","actual_loan_money":"150000","actual_raising_money":"0","borrow_interest":"4.80","borrow_period":"12","borrow_status":"筹集中","show_status":"上架","add_time":"2018-07-30 11:41:59","update_time":"2018-07-31 11:38:31","publish_time":"2018-07-28 12:00:18","full_time":"0000-00-00 00:00:00","interest_start_time":"0000-00-00 00:00:00","interest_end_time":"0000-00-00 00:00:00","raising_period":"2018-08-11 13:13:42","return_type":"1","invest_highest":"0.00","invest_lowest":"0.00","co_user_entity_id":"1","apply_type":"企业","iphone":"15936259871","address":"0","address_detail":"0","use_purpose":"旅游消费","salary":"30000","repayment":"商铺收入","other_loan_num":"0","total_debt":"0","degree":"","job_type":"","industry":"","occupancy":"","commerce_club_name":"","commerce_club_addr":"","commerce_club_mobile":"","approve_money":"1000000","expire_time":"0000-00-00 00:00:00","is_show":"否","add_ip":"","apply_status":"待审核","order_type":"1"},{"id":"16","loan_application_num":"1852365658","apply_id":"16","borrow_type":"企业","borrow_name":"1616161","user_id":"372","actual_loan_money":"1200000","actual_raising_money":"0","borrow_interest":"7.80","borrow_period":"24","borrow_status":"筹集中","show_status":"上架","add_time":"2018-07-30 11:41:59","update_time":"2018-07-31 11:39:15","publish_time":"2018-07-31 12:00:24","full_time":"0000-00-00 00:00:00","interest_start_time":"0000-00-00 00:00:00","interest_end_time":"0000-00-00 00:00:00","raising_period":"2018-08-07 13:05:46","return_type":"1","invest_highest":"0.00","invest_lowest":"0.00","co_user_entity_id":"1","apply_type":"企业","iphone":"15936259871","address":"0","address_detail":"0","use_purpose":"旅游消费","salary":"30000","repayment":"商铺收入","other_loan_num":"0","total_debt":"0","degree":"","job_type":"","industry":"","occupancy":"","commerce_club_name":"","commerce_club_addr":"","commerce_club_mobile":"","approve_money":"1000000","expire_time":"0000-00-00 00:00:00","is_show":"否","add_ip":"","apply_status":"待审核","order_type":"1"}]
     * total : 14
     */

    private String total;
    private String list;
    private List<ListBean> mInvestListData;

    public List<ListBean> getInvestListData() {
        return mInvestListData;
    }

    public void setInvestListData(List<ListBean> investListData) {
        mInvestListData = investListData;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getList() {
        return list;
    }

    public void setList(String list) {
        this.list = list;
    }

    public static class ListBean {
        /**
         * id : 10
         * loan_application_num : 1586392596
         * apply_id : 10
         * borrow_type : 企业
         * borrow_name : 101010
         * user_id : 372
         * actual_loan_money : 1200000
         * actual_raising_money : 5000
         * borrow_interest : 5.00
         * borrow_period : 24
         * borrow_status : 部分成立
         * show_status : 上架
         * add_time : 2018-07-30 11:41:59
         * update_time : 2018-07-31 11:38:40
         * publish_time : 2018-07-31 12:00:24
         * full_time : 2018-08-02 13:05:11
         * interest_start_time : 0000-00-00 00:00:00
         * interest_end_time : 0000-00-00 00:00:00
         * raising_period : 2018-08-02 13:05:11
         * return_type : 1
         * invest_highest : 0.00
         * invest_lowest : 0.00
         * co_user_entity_id : 1
         * apply_type : 企业
         * iphone : 15936259871
         * address : 0
         * address_detail : 0
         * use_purpose : 旅游消费
         * salary : 30000
         * repayment : 商铺收入
         * other_loan_num : 0
         * total_debt : 0
         * degree :
         * job_type :
         * industry :
         * occupancy :
         * commerce_club_name :
         * commerce_club_addr :
         * commerce_club_mobile :
         * approve_money : 1000000
         * expire_time : 0000-00-00 00:00:00
         * is_show : 否
         * add_ip :
         * apply_status : 待审核
         * order_type : null
         */

        private String id;
        private String loan_application_num;
        private String apply_id;
        private String borrow_type;
        private String borrow_name;
        private String user_id;
        private String actual_loan_money;
        private String actual_raising_money;
        private String borrow_interest;
        private String borrow_period;
        private String borrow_status;
        private String show_status;
        private String add_time;
        private String update_time;
        private String publish_time;
        private String full_time;
        private String interest_start_time;
        private String interest_end_time;
        private String raising_period;
        private String return_type;
        private String invest_highest;
        private String invest_lowest;
        private String co_user_entity_id;
        private String apply_type;
        private String iphone;
        private String address;
        private String address_detail;
        private String use_purpose;
        private String salary;
        private String repayment;
        private String other_loan_num;
        private String total_debt;
        private String degree;
        private String job_type;
        private String industry;
        private String occupancy;
        private String commerce_club_name;
        private String commerce_club_addr;
        private String commerce_club_mobile;
        private String approve_money;
        private String expire_time;
        private String is_show;
        private String add_ip;
        private String apply_status;
        private Object order_type;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getLoan_application_num() {
            return loan_application_num;
        }

        public void setLoan_application_num(String loan_application_num) {
            this.loan_application_num = loan_application_num;
        }

        public String getApply_id() {
            return apply_id;
        }

        public void setApply_id(String apply_id) {
            this.apply_id = apply_id;
        }

        public String getBorrow_type() {
            return borrow_type;
        }

        public void setBorrow_type(String borrow_type) {
            this.borrow_type = borrow_type;
        }

        public String getBorrow_name() {
            return borrow_name;
        }

        public void setBorrow_name(String borrow_name) {
            this.borrow_name = borrow_name;
        }

        public String getUser_id() {
            return user_id;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }

        public String getActual_loan_money() {
            return actual_loan_money;
        }

        public void setActual_loan_money(String actual_loan_money) {
            this.actual_loan_money = actual_loan_money;
        }

        public String getActual_raising_money() {
            return actual_raising_money;
        }

        public void setActual_raising_money(String actual_raising_money) {
            this.actual_raising_money = actual_raising_money;
        }

        public String getBorrow_interest() {
            return borrow_interest;
        }

        public void setBorrow_interest(String borrow_interest) {
            this.borrow_interest = borrow_interest;
        }

        public String getBorrow_period() {
            return borrow_period;
        }

        public void setBorrow_period(String borrow_period) {
            this.borrow_period = borrow_period;
        }

        public String getBorrow_status() {
            return borrow_status;
        }

        public void setBorrow_status(String borrow_status) {
            this.borrow_status = borrow_status;
        }

        public String getShow_status() {
            return show_status;
        }

        public void setShow_status(String show_status) {
            this.show_status = show_status;
        }

        public String getAdd_time() {
            return add_time;
        }

        public void setAdd_time(String add_time) {
            this.add_time = add_time;
        }

        public String getUpdate_time() {
            return update_time;
        }

        public void setUpdate_time(String update_time) {
            this.update_time = update_time;
        }

        public String getPublish_time() {
            return publish_time;
        }

        public void setPublish_time(String publish_time) {
            this.publish_time = publish_time;
        }

        public String getFull_time() {
            return full_time;
        }

        public void setFull_time(String full_time) {
            this.full_time = full_time;
        }

        public String getInterest_start_time() {
            return interest_start_time;
        }

        public void setInterest_start_time(String interest_start_time) {
            this.interest_start_time = interest_start_time;
        }

        public String getInterest_end_time() {
            return interest_end_time;
        }

        public void setInterest_end_time(String interest_end_time) {
            this.interest_end_time = interest_end_time;
        }

        public String getRaising_period() {
            return raising_period;
        }

        public void setRaising_period(String raising_period) {
            this.raising_period = raising_period;
        }

        public String getReturn_type() {
            return return_type;
        }

        public void setReturn_type(String return_type) {
            this.return_type = return_type;
        }

        public String getInvest_highest() {
            return invest_highest;
        }

        public void setInvest_highest(String invest_highest) {
            this.invest_highest = invest_highest;
        }

        public String getInvest_lowest() {
            return invest_lowest;
        }

        public void setInvest_lowest(String invest_lowest) {
            this.invest_lowest = invest_lowest;
        }

        public String getCo_user_entity_id() {
            return co_user_entity_id;
        }

        public void setCo_user_entity_id(String co_user_entity_id) {
            this.co_user_entity_id = co_user_entity_id;
        }

        public String getApply_type() {
            return apply_type;
        }

        public void setApply_type(String apply_type) {
            this.apply_type = apply_type;
        }

        public String getIphone() {
            return iphone;
        }

        public void setIphone(String iphone) {
            this.iphone = iphone;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getAddress_detail() {
            return address_detail;
        }

        public void setAddress_detail(String address_detail) {
            this.address_detail = address_detail;
        }

        public String getUse_purpose() {
            return use_purpose;
        }

        public void setUse_purpose(String use_purpose) {
            this.use_purpose = use_purpose;
        }

        public String getSalary() {
            return salary;
        }

        public void setSalary(String salary) {
            this.salary = salary;
        }

        public String getRepayment() {
            return repayment;
        }

        public void setRepayment(String repayment) {
            this.repayment = repayment;
        }

        public String getOther_loan_num() {
            return other_loan_num;
        }

        public void setOther_loan_num(String other_loan_num) {
            this.other_loan_num = other_loan_num;
        }

        public String getTotal_debt() {
            return total_debt;
        }

        public void setTotal_debt(String total_debt) {
            this.total_debt = total_debt;
        }

        public String getDegree() {
            return degree;
        }

        public void setDegree(String degree) {
            this.degree = degree;
        }

        public String getJob_type() {
            return job_type;
        }

        public void setJob_type(String job_type) {
            this.job_type = job_type;
        }

        public String getIndustry() {
            return industry;
        }

        public void setIndustry(String industry) {
            this.industry = industry;
        }

        public String getOccupancy() {
            return occupancy;
        }

        public void setOccupancy(String occupancy) {
            this.occupancy = occupancy;
        }

        public String getCommerce_club_name() {
            return commerce_club_name;
        }

        public void setCommerce_club_name(String commerce_club_name) {
            this.commerce_club_name = commerce_club_name;
        }

        public String getCommerce_club_addr() {
            return commerce_club_addr;
        }

        public void setCommerce_club_addr(String commerce_club_addr) {
            this.commerce_club_addr = commerce_club_addr;
        }

        public String getCommerce_club_mobile() {
            return commerce_club_mobile;
        }

        public void setCommerce_club_mobile(String commerce_club_mobile) {
            this.commerce_club_mobile = commerce_club_mobile;
        }

        public String getApprove_money() {
            return approve_money;
        }

        public void setApprove_money(String approve_money) {
            this.approve_money = approve_money;
        }

        public String getExpire_time() {
            return expire_time;
        }

        public void setExpire_time(String expire_time) {
            this.expire_time = expire_time;
        }

        public String getIs_show() {
            return is_show;
        }

        public void setIs_show(String is_show) {
            this.is_show = is_show;
        }

        public String getAdd_ip() {
            return add_ip;
        }

        public void setAdd_ip(String add_ip) {
            this.add_ip = add_ip;
        }

        public String getApply_status() {
            return apply_status;
        }

        public void setApply_status(String apply_status) {
            this.apply_status = apply_status;
        }

        public Object getOrder_type() {
            return order_type;
        }

        public void setOrder_type(Object order_type) {
            this.order_type = order_type;
        }
    }
}
