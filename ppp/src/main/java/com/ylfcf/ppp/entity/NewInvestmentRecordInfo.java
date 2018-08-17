package com.ylfcf.ppp.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by yjx on 2018/8/14.
 */
public class NewInvestmentRecordInfo implements Serializable {


    /**
     * list : [{"id":"58","borrow_id":"4","interest_rate":"8.00","invest_user_id":"12913","money":"100.00","type":"个人","status":"2","interest_add":"0.00","coupon_interest_add":"0.00","invest_time":"2018-08-14 13:43:54","interest_start_time":"0000-00-00 00:00:00","phone":"15502115105","co_mobile":"","interest_end_time":"0000-00-00 00:00:00","sub_time":"0000-00-00 00:00:00","interest_days":"12","red_bag_add":"0.00","real_name":"姜晓毅","user_name":"ylf11510513","borrow_name":"444444","raising_period":"2018-08-30 14:25:48","reimbursement_amount":"0.00","iphone":"15502115105"},{"id":"57","borrow_id":"4","interest_rate":"8.00","invest_user_id":"12913","money":"100.00","type":"个人","status":"2","interest_add":"0.00","coupon_interest_add":"0.00","invest_time":"2018-08-14 13:43:12","interest_start_time":"0000-00-00 00:00:00","phone":"15502115105","co_mobile":"","interest_end_time":"0000-00-00 00:00:00","sub_time":"0000-00-00 00:00:00","interest_days":"12","red_bag_add":"0.00","real_name":"姜晓毅","user_name":"ylf11510513","borrow_name":"444444","raising_period":"2018-08-30 14:25:48","reimbursement_amount":"0.00","iphone":"15502115105"},{"id":"56","borrow_id":"4","interest_rate":"8.00","invest_user_id":"12913","money":"100.00","type":"个人","status":"2","interest_add":"0.00","coupon_interest_add":"0.00","invest_time":"2018-08-14 10:48:36","interest_start_time":"0000-00-00 00:00:00","phone":"15502115105","co_mobile":"","interest_end_time":"0000-00-00 00:00:00","sub_time":"0000-00-00 00:00:00","interest_days":"12","red_bag_add":"0.00","real_name":"姜晓毅","user_name":"ylf11510513","borrow_name":"444444","raising_period":"2018-08-30 14:25:48","reimbursement_amount":"0.00","iphone":"15502115105"},{"id":"55","borrow_id":"4","interest_rate":"8.00","invest_user_id":"12913","money":"100.00","type":"个人","status":"2","interest_add":"0.00","coupon_interest_add":"0.00","invest_time":"2018-08-14 10:43:14","interest_start_time":"0000-00-00 00:00:00","phone":"15502115105","co_mobile":"","interest_end_time":"0000-00-00 00:00:00","sub_time":"0000-00-00 00:00:00","interest_days":"12","red_bag_add":"0.00","real_name":"姜晓毅","user_name":"ylf11510513","borrow_name":"444444","raising_period":"2018-08-30 14:25:48","reimbursement_amount":"0.00","iphone":"15502115105"},{"id":"54","borrow_id":"4","interest_rate":"8.00","invest_user_id":"12913","money":"500.00","type":"个人","status":"2","interest_add":"0.00","coupon_interest_add":"0.00","invest_time":"2018-08-14 10:40:16","interest_start_time":"0000-00-00 00:00:00","phone":"15502115105","co_mobile":"","interest_end_time":"0000-00-00 00:00:00","sub_time":"0000-00-00 00:00:00","interest_days":"12","red_bag_add":"0.00","real_name":"姜晓毅","user_name":"ylf11510513","borrow_name":"444444","raising_period":"2018-08-30 14:25:48","reimbursement_amount":"0.00","iphone":"15502115105"},{"id":"53","borrow_id":"4","interest_rate":"8.00","invest_user_id":"12913","money":"10000.00","type":"个人","status":"2","interest_add":"0.00","coupon_interest_add":"0.00","invest_time":"2018-08-13 16:51:47","interest_start_time":"0000-00-00 00:00:00","phone":"15502115105","co_mobile":"","interest_end_time":"0000-00-00 00:00:00","sub_time":"0000-00-00 00:00:00","interest_days":"12","red_bag_add":"0.00","real_name":"姜晓毅","user_name":"ylf11510513","borrow_name":"444444","raising_period":"2018-08-30 14:25:48","reimbursement_amount":"0.00","iphone":"15502115105"},{"id":"45","borrow_id":"4","interest_rate":"8.00","invest_user_id":"12913","money":"10000.00","type":"个人","status":"2","interest_add":"0.00","coupon_interest_add":"0.00","invest_time":"2018-08-13 14:41:04","interest_start_time":"0000-00-00 00:00:00","phone":"15502115105","co_mobile":"","interest_end_time":"0000-00-00 00:00:00","sub_time":"0000-00-00 00:00:00","interest_days":"12","red_bag_add":"0.00","real_name":"姜晓毅","user_name":"ylf11510513","borrow_name":"444444","raising_period":"2018-08-30 14:25:48","reimbursement_amount":"0.00","iphone":"15502115105"},{"id":"44","borrow_id":"4","interest_rate":"8.00","invest_user_id":"12913","money":"10000.00","type":"个人","status":"2","interest_add":"0.00","coupon_interest_add":"0.00","invest_time":"2018-08-13 14:41:01","interest_start_time":"0000-00-00 00:00:00","phone":"15502115105","co_mobile":"","interest_end_time":"0000-00-00 00:00:00","sub_time":"0000-00-00 00:00:00","interest_days":"12","red_bag_add":"0.00","real_name":"姜晓毅","user_name":"ylf11510513","borrow_name":"444444","raising_period":"2018-08-30 14:25:48","reimbursement_amount":"0.00","iphone":"15502115105"},{"id":"33","borrow_id":"8","interest_rate":"4.80","invest_user_id":"12913","money":"100.00","type":"个人","status":"2","interest_add":"0.00","coupon_interest_add":"0.00","invest_time":"2018-08-09 17:24:44","interest_start_time":"0000-00-00 00:00:00","phone":"15502115105","co_mobile":"","interest_end_time":"0000-00-00 00:00:00","sub_time":"0000-00-00 00:00:00","interest_days":"12","red_bag_add":"0.00","real_name":"姜晓毅","user_name":"ylf11510513","borrow_name":"8888","raising_period":"2018-08-11 13:13:42","reimbursement_amount":"0.00","iphone":"15502115105"},{"id":"32","borrow_id":"8","interest_rate":"4.80","invest_user_id":"12913","money":"100.00","type":"个人","status":"2","interest_add":"0.00","coupon_interest_add":"0.00","invest_time":"2018-08-09 13:42:28","interest_start_time":"0000-00-00 00:00:00","phone":"15502115105","co_mobile":"","interest_end_time":"0000-00-00 00:00:00","sub_time":"0000-00-00 00:00:00","interest_days":"12","red_bag_add":"0.00","real_name":"姜晓毅","user_name":"ylf11510513","borrow_name":"8888","raising_period":"2018-08-11 13:13:42","reimbursement_amount":"0.00","iphone":"15502115105"},{"id":"27","borrow_id":"8","interest_rate":"4.80","invest_user_id":"12913","money":"100.00","type":"个人","status":"2","interest_add":"0.00","coupon_interest_add":"0.00","invest_time":"2018-08-08 11:29:33","interest_start_time":"0000-00-00 00:00:00","phone":"15502115105","co_mobile":"","interest_end_time":"0000-00-00 00:00:00","sub_time":"0000-00-00 00:00:00","interest_days":"12","red_bag_add":"0.00","real_name":"姜晓毅","user_name":"ylf11510513","borrow_name":"8888","raising_period":"2018-08-11 13:13:42","reimbursement_amount":"0.00","iphone":"15502115105"},{"id":"26","borrow_id":"8","interest_rate":"4.80","invest_user_id":"12913","money":"100.00","type":"个人","status":"2","interest_add":"0.00","coupon_interest_add":"0.00","invest_time":"2018-08-08 11:22:34","interest_start_time":"0000-00-00 00:00:00","phone":"15502115105","co_mobile":"","interest_end_time":"0000-00-00 00:00:00","sub_time":"0000-00-00 00:00:00","interest_days":"12","red_bag_add":"0.00","real_name":"姜晓毅","user_name":"ylf11510513","borrow_name":"8888","raising_period":"2018-08-11 13:13:42","reimbursement_amount":"0.00","iphone":"15502115105"}]
     * total : 12
     */

    private String total;
    private String list;
    private List<ListBean> RecordInfoList;

    public void setList(String list) {
        this.list = list;
    }

    public String getList() {
        return list;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public List<ListBean> getRecordInfoList() {
        return RecordInfoList;
    }

    public void setRecordInfoList(List<ListBean> list) {
        this.RecordInfoList = list;
    }

    public static class ListBean {
        /**
         * id : 58
         * borrow_id : 4
         * interest_rate : 8.00
         * invest_user_id : 12913
         * money : 100.00
         * type : 个人
         * status : 2
         * interest_add : 0.00
         * coupon_interest_add : 0.00
         * invest_time : 2018-08-14 13:43:54
         * interest_start_time : 0000-00-00 00:00:00
         * phone : 15502115105
         * co_mobile :
         * interest_end_time : 0000-00-00 00:00:00
         * sub_time : 0000-00-00 00:00:00
         * interest_days : 12
         * red_bag_add : 0.00
         * real_name : 姜晓毅
         * user_name : ylf11510513
         * borrow_name : 444444
         * raising_period : 2018-08-30 14:25:48
         * reimbursement_amount : 0.00
         * iphone : 15502115105
         */

        private String id;
        private String borrow_id;
        private String interest_rate;
        private String invest_user_id;
        private String money;
        private String type;
        private String status;
        private String interest_add;
        private String coupon_interest_add;
        private String invest_time;
        private String interest_start_time;
        private String phone;
        private String co_mobile;
        private String interest_end_time;
        private String sub_time;
        private String interest_days;
        private String red_bag_add;
        private String real_name;
        private String user_name;
        private String borrow_name;
        private String raising_period;
        private String reimbursement_amount;
        private String iphone;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getBorrow_id() {
            return borrow_id;
        }

        public void setBorrow_id(String borrow_id) {
            this.borrow_id = borrow_id;
        }

        public String getInterest_rate() {
            return interest_rate;
        }

        public void setInterest_rate(String interest_rate) {
            this.interest_rate = interest_rate;
        }

        public String getInvest_user_id() {
            return invest_user_id;
        }

        public void setInvest_user_id(String invest_user_id) {
            this.invest_user_id = invest_user_id;
        }

        public String getMoney() {
            return money;
        }

        public void setMoney(String money) {
            this.money = money;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getInterest_add() {
            return interest_add;
        }

        public void setInterest_add(String interest_add) {
            this.interest_add = interest_add;
        }

        public String getCoupon_interest_add() {
            return coupon_interest_add;
        }

        public void setCoupon_interest_add(String coupon_interest_add) {
            this.coupon_interest_add = coupon_interest_add;
        }

        public String getInvest_time() {
            return invest_time;
        }

        public void setInvest_time(String invest_time) {
            this.invest_time = invest_time;
        }

        public String getInterest_start_time() {
            return interest_start_time;
        }

        public void setInterest_start_time(String interest_start_time) {
            this.interest_start_time = interest_start_time;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getCo_mobile() {
            return co_mobile;
        }

        public void setCo_mobile(String co_mobile) {
            this.co_mobile = co_mobile;
        }

        public String getInterest_end_time() {
            return interest_end_time;
        }

        public void setInterest_end_time(String interest_end_time) {
            this.interest_end_time = interest_end_time;
        }

        public String getSub_time() {
            return sub_time;
        }

        public void setSub_time(String sub_time) {
            this.sub_time = sub_time;
        }

        public String getInterest_days() {
            return interest_days;
        }

        public void setInterest_days(String interest_days) {
            this.interest_days = interest_days;
        }

        public String getRed_bag_add() {
            return red_bag_add;
        }

        public void setRed_bag_add(String red_bag_add) {
            this.red_bag_add = red_bag_add;
        }

        public String getReal_name() {
            return real_name;
        }

        public void setReal_name(String real_name) {
            this.real_name = real_name;
        }

        public String getUser_name() {
            return user_name;
        }

        public void setUser_name(String user_name) {
            this.user_name = user_name;
        }

        public String getBorrow_name() {
            return borrow_name;
        }

        public void setBorrow_name(String borrow_name) {
            this.borrow_name = borrow_name;
        }

        public String getRaising_period() {
            return raising_period;
        }

        public void setRaising_period(String raising_period) {
            this.raising_period = raising_period;
        }

        public String getReimbursement_amount() {
            return reimbursement_amount;
        }

        public void setReimbursement_amount(String reimbursement_amount) {
            this.reimbursement_amount = reimbursement_amount;
        }

        public String getIphone() {
            return iphone;
        }

        public void setIphone(String iphone) {
            this.iphone = iphone;
        }
    }
}
