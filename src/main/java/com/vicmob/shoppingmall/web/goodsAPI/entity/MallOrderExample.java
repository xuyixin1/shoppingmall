package com.vicmob.shoppingmall.web.goodsAPI.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MallOrderExample {
    protected String pk_name = "orderId";

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MallOrderExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setPk_name(String pk_name) {
        this.pk_name = pk_name;
    }

    public String getPk_name() {
        return pk_name;
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andOrderidIsNull() {
            addCriterion("orderId is null");
            return (Criteria) this;
        }

        public Criteria andOrderidIsNotNull() {
            addCriterion("orderId is not null");
            return (Criteria) this;
        }

        public Criteria andOrderidEqualTo(Integer value) {
            addCriterion("orderId =", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidNotEqualTo(Integer value) {
            addCriterion("orderId <>", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidGreaterThan(Integer value) {
            addCriterion("orderId >", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidGreaterThanOrEqualTo(Integer value) {
            addCriterion("orderId >=", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidLessThan(Integer value) {
            addCriterion("orderId <", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidLessThanOrEqualTo(Integer value) {
            addCriterion("orderId <=", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidIn(List<Integer> values) {
            addCriterion("orderId in", values, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidNotIn(List<Integer> values) {
            addCriterion("orderId not in", values, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidBetween(Integer value1, Integer value2) {
            addCriterion("orderId between", value1, value2, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidNotBetween(Integer value1, Integer value2) {
            addCriterion("orderId not between", value1, value2, "orderid");
            return (Criteria) this;
        }

        public Criteria andMinaidIsNull() {
            addCriterion("minaId is null");
            return (Criteria) this;
        }

        public Criteria andMinaidIsNotNull() {
            addCriterion("minaId is not null");
            return (Criteria) this;
        }

        public Criteria andMinaidEqualTo(Integer value) {
            addCriterion("minaId =", value, "minaid");
            return (Criteria) this;
        }

        public Criteria andMinaidNotEqualTo(Integer value) {
            addCriterion("minaId <>", value, "minaid");
            return (Criteria) this;
        }

        public Criteria andMinaidGreaterThan(Integer value) {
            addCriterion("minaId >", value, "minaid");
            return (Criteria) this;
        }

        public Criteria andMinaidGreaterThanOrEqualTo(Integer value) {
            addCriterion("minaId >=", value, "minaid");
            return (Criteria) this;
        }

        public Criteria andMinaidLessThan(Integer value) {
            addCriterion("minaId <", value, "minaid");
            return (Criteria) this;
        }

        public Criteria andMinaidLessThanOrEqualTo(Integer value) {
            addCriterion("minaId <=", value, "minaid");
            return (Criteria) this;
        }

        public Criteria andMinaidIn(List<Integer> values) {
            addCriterion("minaId in", values, "minaid");
            return (Criteria) this;
        }

        public Criteria andMinaidNotIn(List<Integer> values) {
            addCriterion("minaId not in", values, "minaid");
            return (Criteria) this;
        }

        public Criteria andMinaidBetween(Integer value1, Integer value2) {
            addCriterion("minaId between", value1, value2, "minaid");
            return (Criteria) this;
        }

        public Criteria andMinaidNotBetween(Integer value1, Integer value2) {
            addCriterion("minaId not between", value1, value2, "minaid");
            return (Criteria) this;
        }

        public Criteria andCustomeridIsNull() {
            addCriterion("customerId is null");
            return (Criteria) this;
        }

        public Criteria andCustomeridIsNotNull() {
            addCriterion("customerId is not null");
            return (Criteria) this;
        }

        public Criteria andCustomeridEqualTo(Integer value) {
            addCriterion("customerId =", value, "customerid");
            return (Criteria) this;
        }

        public Criteria andCustomeridNotEqualTo(Integer value) {
            addCriterion("customerId <>", value, "customerid");
            return (Criteria) this;
        }

        public Criteria andCustomeridGreaterThan(Integer value) {
            addCriterion("customerId >", value, "customerid");
            return (Criteria) this;
        }

        public Criteria andCustomeridGreaterThanOrEqualTo(Integer value) {
            addCriterion("customerId >=", value, "customerid");
            return (Criteria) this;
        }

        public Criteria andCustomeridLessThan(Integer value) {
            addCriterion("customerId <", value, "customerid");
            return (Criteria) this;
        }

        public Criteria andCustomeridLessThanOrEqualTo(Integer value) {
            addCriterion("customerId <=", value, "customerid");
            return (Criteria) this;
        }

        public Criteria andCustomeridIn(List<Integer> values) {
            addCriterion("customerId in", values, "customerid");
            return (Criteria) this;
        }

        public Criteria andCustomeridNotIn(List<Integer> values) {
            addCriterion("customerId not in", values, "customerid");
            return (Criteria) this;
        }

        public Criteria andCustomeridBetween(Integer value1, Integer value2) {
            addCriterion("customerId between", value1, value2, "customerid");
            return (Criteria) this;
        }

        public Criteria andCustomeridNotBetween(Integer value1, Integer value2) {
            addCriterion("customerId not between", value1, value2, "customerid");
            return (Criteria) this;
        }

        public Criteria andPaytypeIsNull() {
            addCriterion("payType is null");
            return (Criteria) this;
        }

        public Criteria andPaytypeIsNotNull() {
            addCriterion("payType is not null");
            return (Criteria) this;
        }

        public Criteria andPaytypeEqualTo(Integer value) {
            addCriterion("payType =", value, "paytype");
            return (Criteria) this;
        }

        public Criteria andPaytypeNotEqualTo(Integer value) {
            addCriterion("payType <>", value, "paytype");
            return (Criteria) this;
        }

        public Criteria andPaytypeGreaterThan(Integer value) {
            addCriterion("payType >", value, "paytype");
            return (Criteria) this;
        }

        public Criteria andPaytypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("payType >=", value, "paytype");
            return (Criteria) this;
        }

        public Criteria andPaytypeLessThan(Integer value) {
            addCriterion("payType <", value, "paytype");
            return (Criteria) this;
        }

        public Criteria andPaytypeLessThanOrEqualTo(Integer value) {
            addCriterion("payType <=", value, "paytype");
            return (Criteria) this;
        }

        public Criteria andPaytypeIn(List<Integer> values) {
            addCriterion("payType in", values, "paytype");
            return (Criteria) this;
        }

        public Criteria andPaytypeNotIn(List<Integer> values) {
            addCriterion("payType not in", values, "paytype");
            return (Criteria) this;
        }

        public Criteria andPaytypeBetween(Integer value1, Integer value2) {
            addCriterion("payType between", value1, value2, "paytype");
            return (Criteria) this;
        }

        public Criteria andPaytypeNotBetween(Integer value1, Integer value2) {
            addCriterion("payType not between", value1, value2, "paytype");
            return (Criteria) this;
        }

        public Criteria andOrdernumberIsNull() {
            addCriterion("orderNumber is null");
            return (Criteria) this;
        }

        public Criteria andOrdernumberIsNotNull() {
            addCriterion("orderNumber is not null");
            return (Criteria) this;
        }

        public Criteria andOrdernumberEqualTo(String value) {
            addCriterion("orderNumber =", value, "ordernumber");
            return (Criteria) this;
        }

        public Criteria andOrdernumberNotEqualTo(String value) {
            addCriterion("orderNumber <>", value, "ordernumber");
            return (Criteria) this;
        }

        public Criteria andOrdernumberGreaterThan(String value) {
            addCriterion("orderNumber >", value, "ordernumber");
            return (Criteria) this;
        }

        public Criteria andOrdernumberGreaterThanOrEqualTo(String value) {
            addCriterion("orderNumber >=", value, "ordernumber");
            return (Criteria) this;
        }

        public Criteria andOrdernumberLessThan(String value) {
            addCriterion("orderNumber <", value, "ordernumber");
            return (Criteria) this;
        }

        public Criteria andOrdernumberLessThanOrEqualTo(String value) {
            addCriterion("orderNumber <=", value, "ordernumber");
            return (Criteria) this;
        }

        public Criteria andOrdernumberLike(String value) {
            addCriterion("orderNumber like", value, "ordernumber");
            return (Criteria) this;
        }

        public Criteria andOrdernumberNotLike(String value) {
            addCriterion("orderNumber not like", value, "ordernumber");
            return (Criteria) this;
        }

        public Criteria andOrdernumberIn(List<String> values) {
            addCriterion("orderNumber in", values, "ordernumber");
            return (Criteria) this;
        }

        public Criteria andOrdernumberNotIn(List<String> values) {
            addCriterion("orderNumber not in", values, "ordernumber");
            return (Criteria) this;
        }

        public Criteria andOrdernumberBetween(String value1, String value2) {
            addCriterion("orderNumber between", value1, value2, "ordernumber");
            return (Criteria) this;
        }

        public Criteria andOrdernumberNotBetween(String value1, String value2) {
            addCriterion("orderNumber not between", value1, value2, "ordernumber");
            return (Criteria) this;
        }

        public Criteria andCollagenoIsNull() {
            addCriterion("collageNo is null");
            return (Criteria) this;
        }

        public Criteria andCollagenoIsNotNull() {
            addCriterion("collageNo is not null");
            return (Criteria) this;
        }

        public Criteria andCollagenoEqualTo(String value) {
            addCriterion("collageNo =", value, "collageno");
            return (Criteria) this;
        }

        public Criteria andCollagenoNotEqualTo(String value) {
            addCriterion("collageNo <>", value, "collageno");
            return (Criteria) this;
        }

        public Criteria andCollagenoGreaterThan(String value) {
            addCriterion("collageNo >", value, "collageno");
            return (Criteria) this;
        }

        public Criteria andCollagenoGreaterThanOrEqualTo(String value) {
            addCriterion("collageNo >=", value, "collageno");
            return (Criteria) this;
        }

        public Criteria andCollagenoLessThan(String value) {
            addCriterion("collageNo <", value, "collageno");
            return (Criteria) this;
        }

        public Criteria andCollagenoLessThanOrEqualTo(String value) {
            addCriterion("collageNo <=", value, "collageno");
            return (Criteria) this;
        }

        public Criteria andCollagenoLike(String value) {
            addCriterion("collageNo like", value, "collageno");
            return (Criteria) this;
        }

        public Criteria andCollagenoNotLike(String value) {
            addCriterion("collageNo not like", value, "collageno");
            return (Criteria) this;
        }

        public Criteria andCollagenoIn(List<String> values) {
            addCriterion("collageNo in", values, "collageno");
            return (Criteria) this;
        }

        public Criteria andCollagenoNotIn(List<String> values) {
            addCriterion("collageNo not in", values, "collageno");
            return (Criteria) this;
        }

        public Criteria andCollagenoBetween(String value1, String value2) {
            addCriterion("collageNo between", value1, value2, "collageno");
            return (Criteria) this;
        }

        public Criteria andCollagenoNotBetween(String value1, String value2) {
            addCriterion("collageNo not between", value1, value2, "collageno");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("`name` is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("`name` is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("`name` =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("`name` <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("`name` >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("`name` >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("`name` <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("`name` <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("`name` like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("`name` not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("`name` in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("`name` not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("`name` between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("`name` not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andPhonenumberIsNull() {
            addCriterion("phoneNumber is null");
            return (Criteria) this;
        }

        public Criteria andPhonenumberIsNotNull() {
            addCriterion("phoneNumber is not null");
            return (Criteria) this;
        }

        public Criteria andPhonenumberEqualTo(String value) {
            addCriterion("phoneNumber =", value, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberNotEqualTo(String value) {
            addCriterion("phoneNumber <>", value, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberGreaterThan(String value) {
            addCriterion("phoneNumber >", value, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberGreaterThanOrEqualTo(String value) {
            addCriterion("phoneNumber >=", value, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberLessThan(String value) {
            addCriterion("phoneNumber <", value, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberLessThanOrEqualTo(String value) {
            addCriterion("phoneNumber <=", value, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberLike(String value) {
            addCriterion("phoneNumber like", value, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberNotLike(String value) {
            addCriterion("phoneNumber not like", value, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberIn(List<String> values) {
            addCriterion("phoneNumber in", values, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberNotIn(List<String> values) {
            addCriterion("phoneNumber not in", values, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberBetween(String value1, String value2) {
            addCriterion("phoneNumber between", value1, value2, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberNotBetween(String value1, String value2) {
            addCriterion("phoneNumber not between", value1, value2, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andDeliverymoneyIsNull() {
            addCriterion("deliveryMoney is null");
            return (Criteria) this;
        }

        public Criteria andDeliverymoneyIsNotNull() {
            addCriterion("deliveryMoney is not null");
            return (Criteria) this;
        }

        public Criteria andDeliverymoneyEqualTo(BigDecimal value) {
            addCriterion("deliveryMoney =", value, "deliverymoney");
            return (Criteria) this;
        }

        public Criteria andDeliverymoneyNotEqualTo(BigDecimal value) {
            addCriterion("deliveryMoney <>", value, "deliverymoney");
            return (Criteria) this;
        }

        public Criteria andDeliverymoneyGreaterThan(BigDecimal value) {
            addCriterion("deliveryMoney >", value, "deliverymoney");
            return (Criteria) this;
        }

        public Criteria andDeliverymoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("deliveryMoney >=", value, "deliverymoney");
            return (Criteria) this;
        }

        public Criteria andDeliverymoneyLessThan(BigDecimal value) {
            addCriterion("deliveryMoney <", value, "deliverymoney");
            return (Criteria) this;
        }

        public Criteria andDeliverymoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("deliveryMoney <=", value, "deliverymoney");
            return (Criteria) this;
        }

        public Criteria andDeliverymoneyIn(List<BigDecimal> values) {
            addCriterion("deliveryMoney in", values, "deliverymoney");
            return (Criteria) this;
        }

        public Criteria andDeliverymoneyNotIn(List<BigDecimal> values) {
            addCriterion("deliveryMoney not in", values, "deliverymoney");
            return (Criteria) this;
        }

        public Criteria andDeliverymoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("deliveryMoney between", value1, value2, "deliverymoney");
            return (Criteria) this;
        }

        public Criteria andDeliverymoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("deliveryMoney not between", value1, value2, "deliverymoney");
            return (Criteria) this;
        }

        public Criteria andTotalmoneyIsNull() {
            addCriterion("totalMoney is null");
            return (Criteria) this;
        }

        public Criteria andTotalmoneyIsNotNull() {
            addCriterion("totalMoney is not null");
            return (Criteria) this;
        }

        public Criteria andTotalmoneyEqualTo(BigDecimal value) {
            addCriterion("totalMoney =", value, "totalmoney");
            return (Criteria) this;
        }

        public Criteria andTotalmoneyNotEqualTo(BigDecimal value) {
            addCriterion("totalMoney <>", value, "totalmoney");
            return (Criteria) this;
        }

        public Criteria andTotalmoneyGreaterThan(BigDecimal value) {
            addCriterion("totalMoney >", value, "totalmoney");
            return (Criteria) this;
        }

        public Criteria andTotalmoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("totalMoney >=", value, "totalmoney");
            return (Criteria) this;
        }

        public Criteria andTotalmoneyLessThan(BigDecimal value) {
            addCriterion("totalMoney <", value, "totalmoney");
            return (Criteria) this;
        }

        public Criteria andTotalmoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("totalMoney <=", value, "totalmoney");
            return (Criteria) this;
        }

        public Criteria andTotalmoneyIn(List<BigDecimal> values) {
            addCriterion("totalMoney in", values, "totalmoney");
            return (Criteria) this;
        }

        public Criteria andTotalmoneyNotIn(List<BigDecimal> values) {
            addCriterion("totalMoney not in", values, "totalmoney");
            return (Criteria) this;
        }

        public Criteria andTotalmoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("totalMoney between", value1, value2, "totalmoney");
            return (Criteria) this;
        }

        public Criteria andTotalmoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("totalMoney not between", value1, value2, "totalmoney");
            return (Criteria) this;
        }

        public Criteria andCancelreasonIsNull() {
            addCriterion("cancelReason is null");
            return (Criteria) this;
        }

        public Criteria andCancelreasonIsNotNull() {
            addCriterion("cancelReason is not null");
            return (Criteria) this;
        }

        public Criteria andCancelreasonEqualTo(String value) {
            addCriterion("cancelReason =", value, "cancelreason");
            return (Criteria) this;
        }

        public Criteria andCancelreasonNotEqualTo(String value) {
            addCriterion("cancelReason <>", value, "cancelreason");
            return (Criteria) this;
        }

        public Criteria andCancelreasonGreaterThan(String value) {
            addCriterion("cancelReason >", value, "cancelreason");
            return (Criteria) this;
        }

        public Criteria andCancelreasonGreaterThanOrEqualTo(String value) {
            addCriterion("cancelReason >=", value, "cancelreason");
            return (Criteria) this;
        }

        public Criteria andCancelreasonLessThan(String value) {
            addCriterion("cancelReason <", value, "cancelreason");
            return (Criteria) this;
        }

        public Criteria andCancelreasonLessThanOrEqualTo(String value) {
            addCriterion("cancelReason <=", value, "cancelreason");
            return (Criteria) this;
        }

        public Criteria andCancelreasonLike(String value) {
            addCriterion("cancelReason like", value, "cancelreason");
            return (Criteria) this;
        }

        public Criteria andCancelreasonNotLike(String value) {
            addCriterion("cancelReason not like", value, "cancelreason");
            return (Criteria) this;
        }

        public Criteria andCancelreasonIn(List<String> values) {
            addCriterion("cancelReason in", values, "cancelreason");
            return (Criteria) this;
        }

        public Criteria andCancelreasonNotIn(List<String> values) {
            addCriterion("cancelReason not in", values, "cancelreason");
            return (Criteria) this;
        }

        public Criteria andCancelreasonBetween(String value1, String value2) {
            addCriterion("cancelReason between", value1, value2, "cancelreason");
            return (Criteria) this;
        }

        public Criteria andCancelreasonNotBetween(String value1, String value2) {
            addCriterion("cancelReason not between", value1, value2, "cancelreason");
            return (Criteria) this;
        }

        public Criteria andRefusereasonIsNull() {
            addCriterion("refuseReason is null");
            return (Criteria) this;
        }

        public Criteria andRefusereasonIsNotNull() {
            addCriterion("refuseReason is not null");
            return (Criteria) this;
        }

        public Criteria andRefusereasonEqualTo(String value) {
            addCriterion("refuseReason =", value, "refusereason");
            return (Criteria) this;
        }

        public Criteria andRefusereasonNotEqualTo(String value) {
            addCriterion("refuseReason <>", value, "refusereason");
            return (Criteria) this;
        }

        public Criteria andRefusereasonGreaterThan(String value) {
            addCriterion("refuseReason >", value, "refusereason");
            return (Criteria) this;
        }

        public Criteria andRefusereasonGreaterThanOrEqualTo(String value) {
            addCriterion("refuseReason >=", value, "refusereason");
            return (Criteria) this;
        }

        public Criteria andRefusereasonLessThan(String value) {
            addCriterion("refuseReason <", value, "refusereason");
            return (Criteria) this;
        }

        public Criteria andRefusereasonLessThanOrEqualTo(String value) {
            addCriterion("refuseReason <=", value, "refusereason");
            return (Criteria) this;
        }

        public Criteria andRefusereasonLike(String value) {
            addCriterion("refuseReason like", value, "refusereason");
            return (Criteria) this;
        }

        public Criteria andRefusereasonNotLike(String value) {
            addCriterion("refuseReason not like", value, "refusereason");
            return (Criteria) this;
        }

        public Criteria andRefusereasonIn(List<String> values) {
            addCriterion("refuseReason in", values, "refusereason");
            return (Criteria) this;
        }

        public Criteria andRefusereasonNotIn(List<String> values) {
            addCriterion("refuseReason not in", values, "refusereason");
            return (Criteria) this;
        }

        public Criteria andRefusereasonBetween(String value1, String value2) {
            addCriterion("refuseReason between", value1, value2, "refusereason");
            return (Criteria) this;
        }

        public Criteria andRefusereasonNotBetween(String value1, String value2) {
            addCriterion("refuseReason not between", value1, value2, "refusereason");
            return (Criteria) this;
        }

        public Criteria andDrawbackreasonIsNull() {
            addCriterion("drawbackReason is null");
            return (Criteria) this;
        }

        public Criteria andDrawbackreasonIsNotNull() {
            addCriterion("drawbackReason is not null");
            return (Criteria) this;
        }

        public Criteria andDrawbackreasonEqualTo(String value) {
            addCriterion("drawbackReason =", value, "drawbackreason");
            return (Criteria) this;
        }

        public Criteria andDrawbackreasonNotEqualTo(String value) {
            addCriterion("drawbackReason <>", value, "drawbackreason");
            return (Criteria) this;
        }

        public Criteria andDrawbackreasonGreaterThan(String value) {
            addCriterion("drawbackReason >", value, "drawbackreason");
            return (Criteria) this;
        }

        public Criteria andDrawbackreasonGreaterThanOrEqualTo(String value) {
            addCriterion("drawbackReason >=", value, "drawbackreason");
            return (Criteria) this;
        }

        public Criteria andDrawbackreasonLessThan(String value) {
            addCriterion("drawbackReason <", value, "drawbackreason");
            return (Criteria) this;
        }

        public Criteria andDrawbackreasonLessThanOrEqualTo(String value) {
            addCriterion("drawbackReason <=", value, "drawbackreason");
            return (Criteria) this;
        }

        public Criteria andDrawbackreasonLike(String value) {
            addCriterion("drawbackReason like", value, "drawbackreason");
            return (Criteria) this;
        }

        public Criteria andDrawbackreasonNotLike(String value) {
            addCriterion("drawbackReason not like", value, "drawbackreason");
            return (Criteria) this;
        }

        public Criteria andDrawbackreasonIn(List<String> values) {
            addCriterion("drawbackReason in", values, "drawbackreason");
            return (Criteria) this;
        }

        public Criteria andDrawbackreasonNotIn(List<String> values) {
            addCriterion("drawbackReason not in", values, "drawbackreason");
            return (Criteria) this;
        }

        public Criteria andDrawbackreasonBetween(String value1, String value2) {
            addCriterion("drawbackReason between", value1, value2, "drawbackreason");
            return (Criteria) this;
        }

        public Criteria andDrawbackreasonNotBetween(String value1, String value2) {
            addCriterion("drawbackReason not between", value1, value2, "drawbackreason");
            return (Criteria) this;
        }

        public Criteria andOrderstatusIsNull() {
            addCriterion("orderStatus is null");
            return (Criteria) this;
        }

        public Criteria andOrderstatusIsNotNull() {
            addCriterion("orderStatus is not null");
            return (Criteria) this;
        }

        public Criteria andOrderstatusEqualTo(Integer value) {
            addCriterion("orderStatus =", value, "orderstatus");
            return (Criteria) this;
        }

        public Criteria andOrderstatusNotEqualTo(Integer value) {
            addCriterion("orderStatus <>", value, "orderstatus");
            return (Criteria) this;
        }

        public Criteria andOrderstatusGreaterThan(Integer value) {
            addCriterion("orderStatus >", value, "orderstatus");
            return (Criteria) this;
        }

        public Criteria andOrderstatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("orderStatus >=", value, "orderstatus");
            return (Criteria) this;
        }

        public Criteria andOrderstatusLessThan(Integer value) {
            addCriterion("orderStatus <", value, "orderstatus");
            return (Criteria) this;
        }

        public Criteria andOrderstatusLessThanOrEqualTo(Integer value) {
            addCriterion("orderStatus <=", value, "orderstatus");
            return (Criteria) this;
        }

        public Criteria andOrderstatusIn(List<Integer> values) {
            addCriterion("orderStatus in", values, "orderstatus");
            return (Criteria) this;
        }

        public Criteria andOrderstatusNotIn(List<Integer> values) {
            addCriterion("orderStatus not in", values, "orderstatus");
            return (Criteria) this;
        }

        public Criteria andOrderstatusBetween(Integer value1, Integer value2) {
            addCriterion("orderStatus between", value1, value2, "orderstatus");
            return (Criteria) this;
        }

        public Criteria andOrderstatusNotBetween(Integer value1, Integer value2) {
            addCriterion("orderStatus not between", value1, value2, "orderstatus");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNull() {
            addCriterion("remarks is null");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNotNull() {
            addCriterion("remarks is not null");
            return (Criteria) this;
        }

        public Criteria andRemarksEqualTo(String value) {
            addCriterion("remarks =", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotEqualTo(String value) {
            addCriterion("remarks <>", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThan(String value) {
            addCriterion("remarks >", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThanOrEqualTo(String value) {
            addCriterion("remarks >=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThan(String value) {
            addCriterion("remarks <", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThanOrEqualTo(String value) {
            addCriterion("remarks <=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLike(String value) {
            addCriterion("remarks like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotLike(String value) {
            addCriterion("remarks not like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksIn(List<String> values) {
            addCriterion("remarks in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotIn(List<String> values) {
            addCriterion("remarks not in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksBetween(String value1, String value2) {
            addCriterion("remarks between", value1, value2, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotBetween(String value1, String value2) {
            addCriterion("remarks not between", value1, value2, "remarks");
            return (Criteria) this;
        }

        public Criteria andOrderstarttimeIsNull() {
            addCriterion("orderStartTime is null");
            return (Criteria) this;
        }

        public Criteria andOrderstarttimeIsNotNull() {
            addCriterion("orderStartTime is not null");
            return (Criteria) this;
        }

        public Criteria andOrderstarttimeEqualTo(Date value) {
            addCriterion("orderStartTime =", value, "orderstarttime");
            return (Criteria) this;
        }

        public Criteria andOrderstarttimeNotEqualTo(Date value) {
            addCriterion("orderStartTime <>", value, "orderstarttime");
            return (Criteria) this;
        }

        public Criteria andOrderstarttimeGreaterThan(Date value) {
            addCriterion("orderStartTime >", value, "orderstarttime");
            return (Criteria) this;
        }

        public Criteria andOrderstarttimeGreaterThanOrEqualTo(Date value) {
            addCriterion("orderStartTime >=", value, "orderstarttime");
            return (Criteria) this;
        }

        public Criteria andOrderstarttimeLessThan(Date value) {
            addCriterion("orderStartTime <", value, "orderstarttime");
            return (Criteria) this;
        }

        public Criteria andOrderstarttimeLessThanOrEqualTo(Date value) {
            addCriterion("orderStartTime <=", value, "orderstarttime");
            return (Criteria) this;
        }

        public Criteria andOrderstarttimeIn(List<Date> values) {
            addCriterion("orderStartTime in", values, "orderstarttime");
            return (Criteria) this;
        }

        public Criteria andOrderstarttimeNotIn(List<Date> values) {
            addCriterion("orderStartTime not in", values, "orderstarttime");
            return (Criteria) this;
        }

        public Criteria andOrderstarttimeBetween(Date value1, Date value2) {
            addCriterion("orderStartTime between", value1, value2, "orderstarttime");
            return (Criteria) this;
        }

        public Criteria andOrderstarttimeNotBetween(Date value1, Date value2) {
            addCriterion("orderStartTime not between", value1, value2, "orderstarttime");
            return (Criteria) this;
        }

        public Criteria andOrderpaytimeIsNull() {
            addCriterion("orderPayTime is null");
            return (Criteria) this;
        }

        public Criteria andOrderpaytimeIsNotNull() {
            addCriterion("orderPayTime is not null");
            return (Criteria) this;
        }

        public Criteria andOrderpaytimeEqualTo(Date value) {
            addCriterion("orderPayTime =", value, "orderpaytime");
            return (Criteria) this;
        }

        public Criteria andOrderpaytimeNotEqualTo(Date value) {
            addCriterion("orderPayTime <>", value, "orderpaytime");
            return (Criteria) this;
        }

        public Criteria andOrderpaytimeGreaterThan(Date value) {
            addCriterion("orderPayTime >", value, "orderpaytime");
            return (Criteria) this;
        }

        public Criteria andOrderpaytimeGreaterThanOrEqualTo(Date value) {
            addCriterion("orderPayTime >=", value, "orderpaytime");
            return (Criteria) this;
        }

        public Criteria andOrderpaytimeLessThan(Date value) {
            addCriterion("orderPayTime <", value, "orderpaytime");
            return (Criteria) this;
        }

        public Criteria andOrderpaytimeLessThanOrEqualTo(Date value) {
            addCriterion("orderPayTime <=", value, "orderpaytime");
            return (Criteria) this;
        }

        public Criteria andOrderpaytimeIn(List<Date> values) {
            addCriterion("orderPayTime in", values, "orderpaytime");
            return (Criteria) this;
        }

        public Criteria andOrderpaytimeNotIn(List<Date> values) {
            addCriterion("orderPayTime not in", values, "orderpaytime");
            return (Criteria) this;
        }

        public Criteria andOrderpaytimeBetween(Date value1, Date value2) {
            addCriterion("orderPayTime between", value1, value2, "orderpaytime");
            return (Criteria) this;
        }

        public Criteria andOrderpaytimeNotBetween(Date value1, Date value2) {
            addCriterion("orderPayTime not between", value1, value2, "orderpaytime");
            return (Criteria) this;
        }

        public Criteria andOrderrefundtimeIsNull() {
            addCriterion("orderRefundTime is null");
            return (Criteria) this;
        }

        public Criteria andOrderrefundtimeIsNotNull() {
            addCriterion("orderRefundTime is not null");
            return (Criteria) this;
        }

        public Criteria andOrderrefundtimeEqualTo(Date value) {
            addCriterion("orderRefundTime =", value, "orderrefundtime");
            return (Criteria) this;
        }

        public Criteria andOrderrefundtimeNotEqualTo(Date value) {
            addCriterion("orderRefundTime <>", value, "orderrefundtime");
            return (Criteria) this;
        }

        public Criteria andOrderrefundtimeGreaterThan(Date value) {
            addCriterion("orderRefundTime >", value, "orderrefundtime");
            return (Criteria) this;
        }

        public Criteria andOrderrefundtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("orderRefundTime >=", value, "orderrefundtime");
            return (Criteria) this;
        }

        public Criteria andOrderrefundtimeLessThan(Date value) {
            addCriterion("orderRefundTime <", value, "orderrefundtime");
            return (Criteria) this;
        }

        public Criteria andOrderrefundtimeLessThanOrEqualTo(Date value) {
            addCriterion("orderRefundTime <=", value, "orderrefundtime");
            return (Criteria) this;
        }

        public Criteria andOrderrefundtimeIn(List<Date> values) {
            addCriterion("orderRefundTime in", values, "orderrefundtime");
            return (Criteria) this;
        }

        public Criteria andOrderrefundtimeNotIn(List<Date> values) {
            addCriterion("orderRefundTime not in", values, "orderrefundtime");
            return (Criteria) this;
        }

        public Criteria andOrderrefundtimeBetween(Date value1, Date value2) {
            addCriterion("orderRefundTime between", value1, value2, "orderrefundtime");
            return (Criteria) this;
        }

        public Criteria andOrderrefundtimeNotBetween(Date value1, Date value2) {
            addCriterion("orderRefundTime not between", value1, value2, "orderrefundtime");
            return (Criteria) this;
        }

        public Criteria andOrderendtimeIsNull() {
            addCriterion("orderEndTime is null");
            return (Criteria) this;
        }

        public Criteria andOrderendtimeIsNotNull() {
            addCriterion("orderEndTime is not null");
            return (Criteria) this;
        }

        public Criteria andOrderendtimeEqualTo(Date value) {
            addCriterion("orderEndTime =", value, "orderendtime");
            return (Criteria) this;
        }

        public Criteria andOrderendtimeNotEqualTo(Date value) {
            addCriterion("orderEndTime <>", value, "orderendtime");
            return (Criteria) this;
        }

        public Criteria andOrderendtimeGreaterThan(Date value) {
            addCriterion("orderEndTime >", value, "orderendtime");
            return (Criteria) this;
        }

        public Criteria andOrderendtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("orderEndTime >=", value, "orderendtime");
            return (Criteria) this;
        }

        public Criteria andOrderendtimeLessThan(Date value) {
            addCriterion("orderEndTime <", value, "orderendtime");
            return (Criteria) this;
        }

        public Criteria andOrderendtimeLessThanOrEqualTo(Date value) {
            addCriterion("orderEndTime <=", value, "orderendtime");
            return (Criteria) this;
        }

        public Criteria andOrderendtimeIn(List<Date> values) {
            addCriterion("orderEndTime in", values, "orderendtime");
            return (Criteria) this;
        }

        public Criteria andOrderendtimeNotIn(List<Date> values) {
            addCriterion("orderEndTime not in", values, "orderendtime");
            return (Criteria) this;
        }

        public Criteria andOrderendtimeBetween(Date value1, Date value2) {
            addCriterion("orderEndTime between", value1, value2, "orderendtime");
            return (Criteria) this;
        }

        public Criteria andOrderendtimeNotBetween(Date value1, Date value2) {
            addCriterion("orderEndTime not between", value1, value2, "orderendtime");
            return (Criteria) this;
        }

        public Criteria andPrepayidIsNull() {
            addCriterion("prepayId is null");
            return (Criteria) this;
        }

        public Criteria andPrepayidIsNotNull() {
            addCriterion("prepayId is not null");
            return (Criteria) this;
        }

        public Criteria andPrepayidEqualTo(String value) {
            addCriterion("prepayId =", value, "prepayid");
            return (Criteria) this;
        }

        public Criteria andPrepayidNotEqualTo(String value) {
            addCriterion("prepayId <>", value, "prepayid");
            return (Criteria) this;
        }

        public Criteria andPrepayidGreaterThan(String value) {
            addCriterion("prepayId >", value, "prepayid");
            return (Criteria) this;
        }

        public Criteria andPrepayidGreaterThanOrEqualTo(String value) {
            addCriterion("prepayId >=", value, "prepayid");
            return (Criteria) this;
        }

        public Criteria andPrepayidLessThan(String value) {
            addCriterion("prepayId <", value, "prepayid");
            return (Criteria) this;
        }

        public Criteria andPrepayidLessThanOrEqualTo(String value) {
            addCriterion("prepayId <=", value, "prepayid");
            return (Criteria) this;
        }

        public Criteria andPrepayidLike(String value) {
            addCriterion("prepayId like", value, "prepayid");
            return (Criteria) this;
        }

        public Criteria andPrepayidNotLike(String value) {
            addCriterion("prepayId not like", value, "prepayid");
            return (Criteria) this;
        }

        public Criteria andPrepayidIn(List<String> values) {
            addCriterion("prepayId in", values, "prepayid");
            return (Criteria) this;
        }

        public Criteria andPrepayidNotIn(List<String> values) {
            addCriterion("prepayId not in", values, "prepayid");
            return (Criteria) this;
        }

        public Criteria andPrepayidBetween(String value1, String value2) {
            addCriterion("prepayId between", value1, value2, "prepayid");
            return (Criteria) this;
        }

        public Criteria andPrepayidNotBetween(String value1, String value2) {
            addCriterion("prepayId not between", value1, value2, "prepayid");
            return (Criteria) this;
        }

        public Criteria andFormidIsNull() {
            addCriterion("formId is null");
            return (Criteria) this;
        }

        public Criteria andFormidIsNotNull() {
            addCriterion("formId is not null");
            return (Criteria) this;
        }

        public Criteria andFormidEqualTo(String value) {
            addCriterion("formId =", value, "formid");
            return (Criteria) this;
        }

        public Criteria andFormidNotEqualTo(String value) {
            addCriterion("formId <>", value, "formid");
            return (Criteria) this;
        }

        public Criteria andFormidGreaterThan(String value) {
            addCriterion("formId >", value, "formid");
            return (Criteria) this;
        }

        public Criteria andFormidGreaterThanOrEqualTo(String value) {
            addCriterion("formId >=", value, "formid");
            return (Criteria) this;
        }

        public Criteria andFormidLessThan(String value) {
            addCriterion("formId <", value, "formid");
            return (Criteria) this;
        }

        public Criteria andFormidLessThanOrEqualTo(String value) {
            addCriterion("formId <=", value, "formid");
            return (Criteria) this;
        }

        public Criteria andFormidLike(String value) {
            addCriterion("formId like", value, "formid");
            return (Criteria) this;
        }

        public Criteria andFormidNotLike(String value) {
            addCriterion("formId not like", value, "formid");
            return (Criteria) this;
        }

        public Criteria andFormidIn(List<String> values) {
            addCriterion("formId in", values, "formid");
            return (Criteria) this;
        }

        public Criteria andFormidNotIn(List<String> values) {
            addCriterion("formId not in", values, "formid");
            return (Criteria) this;
        }

        public Criteria andFormidBetween(String value1, String value2) {
            addCriterion("formId between", value1, value2, "formid");
            return (Criteria) this;
        }

        public Criteria andFormidNotBetween(String value1, String value2) {
            addCriterion("formId not between", value1, value2, "formid");
            return (Criteria) this;
        }

        public Criteria andIsevaluateIsNull() {
            addCriterion("isEvaluate is null");
            return (Criteria) this;
        }

        public Criteria andIsevaluateIsNotNull() {
            addCriterion("isEvaluate is not null");
            return (Criteria) this;
        }

        public Criteria andIsevaluateEqualTo(Integer value) {
            addCriterion("isEvaluate =", value, "isevaluate");
            return (Criteria) this;
        }

        public Criteria andIsevaluateNotEqualTo(Integer value) {
            addCriterion("isEvaluate <>", value, "isevaluate");
            return (Criteria) this;
        }

        public Criteria andIsevaluateGreaterThan(Integer value) {
            addCriterion("isEvaluate >", value, "isevaluate");
            return (Criteria) this;
        }

        public Criteria andIsevaluateGreaterThanOrEqualTo(Integer value) {
            addCriterion("isEvaluate >=", value, "isevaluate");
            return (Criteria) this;
        }

        public Criteria andIsevaluateLessThan(Integer value) {
            addCriterion("isEvaluate <", value, "isevaluate");
            return (Criteria) this;
        }

        public Criteria andIsevaluateLessThanOrEqualTo(Integer value) {
            addCriterion("isEvaluate <=", value, "isevaluate");
            return (Criteria) this;
        }

        public Criteria andIsevaluateIn(List<Integer> values) {
            addCriterion("isEvaluate in", values, "isevaluate");
            return (Criteria) this;
        }

        public Criteria andIsevaluateNotIn(List<Integer> values) {
            addCriterion("isEvaluate not in", values, "isevaluate");
            return (Criteria) this;
        }

        public Criteria andIsevaluateBetween(Integer value1, Integer value2) {
            addCriterion("isEvaluate between", value1, value2, "isevaluate");
            return (Criteria) this;
        }

        public Criteria andIsevaluateNotBetween(Integer value1, Integer value2) {
            addCriterion("isEvaluate not between", value1, value2, "isevaluate");
            return (Criteria) this;
        }

        public Criteria andEmployeeidIsNull() {
            addCriterion("employeeId is null");
            return (Criteria) this;
        }

        public Criteria andEmployeeidIsNotNull() {
            addCriterion("employeeId is not null");
            return (Criteria) this;
        }

        public Criteria andEmployeeidEqualTo(Integer value) {
            addCriterion("employeeId =", value, "employeeid");
            return (Criteria) this;
        }

        public Criteria andEmployeeidNotEqualTo(Integer value) {
            addCriterion("employeeId <>", value, "employeeid");
            return (Criteria) this;
        }

        public Criteria andEmployeeidGreaterThan(Integer value) {
            addCriterion("employeeId >", value, "employeeid");
            return (Criteria) this;
        }

        public Criteria andEmployeeidGreaterThanOrEqualTo(Integer value) {
            addCriterion("employeeId >=", value, "employeeid");
            return (Criteria) this;
        }

        public Criteria andEmployeeidLessThan(Integer value) {
            addCriterion("employeeId <", value, "employeeid");
            return (Criteria) this;
        }

        public Criteria andEmployeeidLessThanOrEqualTo(Integer value) {
            addCriterion("employeeId <=", value, "employeeid");
            return (Criteria) this;
        }

        public Criteria andEmployeeidIn(List<Integer> values) {
            addCriterion("employeeId in", values, "employeeid");
            return (Criteria) this;
        }

        public Criteria andEmployeeidNotIn(List<Integer> values) {
            addCriterion("employeeId not in", values, "employeeid");
            return (Criteria) this;
        }

        public Criteria andEmployeeidBetween(Integer value1, Integer value2) {
            addCriterion("employeeId between", value1, value2, "employeeid");
            return (Criteria) this;
        }

        public Criteria andEmployeeidNotBetween(Integer value1, Integer value2) {
            addCriterion("employeeId not between", value1, value2, "employeeid");
            return (Criteria) this;
        }

        public Criteria andDeleteflagIsNull() {
            addCriterion("deleteFlag is null");
            return (Criteria) this;
        }

        public Criteria andDeleteflagIsNotNull() {
            addCriterion("deleteFlag is not null");
            return (Criteria) this;
        }

        public Criteria andDeleteflagEqualTo(Integer value) {
            addCriterion("deleteFlag =", value, "deleteflag");
            return (Criteria) this;
        }

        public Criteria andDeleteflagNotEqualTo(Integer value) {
            addCriterion("deleteFlag <>", value, "deleteflag");
            return (Criteria) this;
        }

        public Criteria andDeleteflagGreaterThan(Integer value) {
            addCriterion("deleteFlag >", value, "deleteflag");
            return (Criteria) this;
        }

        public Criteria andDeleteflagGreaterThanOrEqualTo(Integer value) {
            addCriterion("deleteFlag >=", value, "deleteflag");
            return (Criteria) this;
        }

        public Criteria andDeleteflagLessThan(Integer value) {
            addCriterion("deleteFlag <", value, "deleteflag");
            return (Criteria) this;
        }

        public Criteria andDeleteflagLessThanOrEqualTo(Integer value) {
            addCriterion("deleteFlag <=", value, "deleteflag");
            return (Criteria) this;
        }

        public Criteria andDeleteflagIn(List<Integer> values) {
            addCriterion("deleteFlag in", values, "deleteflag");
            return (Criteria) this;
        }

        public Criteria andDeleteflagNotIn(List<Integer> values) {
            addCriterion("deleteFlag not in", values, "deleteflag");
            return (Criteria) this;
        }

        public Criteria andDeleteflagBetween(Integer value1, Integer value2) {
            addCriterion("deleteFlag between", value1, value2, "deleteflag");
            return (Criteria) this;
        }

        public Criteria andDeleteflagNotBetween(Integer value1, Integer value2) {
            addCriterion("deleteFlag not between", value1, value2, "deleteflag");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}