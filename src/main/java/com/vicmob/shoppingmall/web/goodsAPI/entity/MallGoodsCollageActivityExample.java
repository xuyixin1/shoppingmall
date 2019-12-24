package com.vicmob.shoppingmall.web.goodsAPI.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MallGoodsCollageActivityExample {
    protected String pk_name = "collageActivityId";

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MallGoodsCollageActivityExample() {
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

        public Criteria andCollageactivityidIsNull() {
            addCriterion("collageActivityId is null");
            return (Criteria) this;
        }

        public Criteria andCollageactivityidIsNotNull() {
            addCriterion("collageActivityId is not null");
            return (Criteria) this;
        }

        public Criteria andCollageactivityidEqualTo(String value) {
            addCriterion("collageActivityId =", value, "collageactivityid");
            return (Criteria) this;
        }

        public Criteria andCollageactivityidNotEqualTo(String value) {
            addCriterion("collageActivityId <>", value, "collageactivityid");
            return (Criteria) this;
        }

        public Criteria andCollageactivityidGreaterThan(String value) {
            addCriterion("collageActivityId >", value, "collageactivityid");
            return (Criteria) this;
        }

        public Criteria andCollageactivityidGreaterThanOrEqualTo(String value) {
            addCriterion("collageActivityId >=", value, "collageactivityid");
            return (Criteria) this;
        }

        public Criteria andCollageactivityidLessThan(String value) {
            addCriterion("collageActivityId <", value, "collageactivityid");
            return (Criteria) this;
        }

        public Criteria andCollageactivityidLessThanOrEqualTo(String value) {
            addCriterion("collageActivityId <=", value, "collageactivityid");
            return (Criteria) this;
        }

        public Criteria andCollageactivityidIn(List<String> values) {
            addCriterion("collageActivityId in", values, "collageactivityid");
            return (Criteria) this;
        }

        public Criteria andCollageactivityidNotIn(List<String> values) {
            addCriterion("collageActivityId not in", values, "collageactivityid");
            return (Criteria) this;
        }

        public Criteria andCollageactivityidBetween(String value1, String value2) {
            addCriterion("collageActivityId between", value1, value2, "collageactivityid");
            return (Criteria) this;
        }

        public Criteria andCollageactivityidNotBetween(String value1, String value2) {
            addCriterion("collageActivityId not between", value1, value2, "collageactivityid");
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

        public Criteria andGoodsidIsNull() {
            addCriterion("goodsId is null");
            return (Criteria) this;
        }

        public Criteria andGoodsidIsNotNull() {
            addCriterion("goodsId is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsidEqualTo(Integer value) {
            addCriterion("goodsId =", value, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsidNotEqualTo(Integer value) {
            addCriterion("goodsId <>", value, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsidGreaterThan(Integer value) {
            addCriterion("goodsId >", value, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsidGreaterThanOrEqualTo(Integer value) {
            addCriterion("goodsId >=", value, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsidLessThan(Integer value) {
            addCriterion("goodsId <", value, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsidLessThanOrEqualTo(Integer value) {
            addCriterion("goodsId <=", value, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsidIn(List<Integer> values) {
            addCriterion("goodsId in", values, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsidNotIn(List<Integer> values) {
            addCriterion("goodsId not in", values, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsidBetween(Integer value1, Integer value2) {
            addCriterion("goodsId between", value1, value2, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsidNotBetween(Integer value1, Integer value2) {
            addCriterion("goodsId not between", value1, value2, "goodsid");
            return (Criteria) this;
        }

        public Criteria andSpecidIsNull() {
            addCriterion("specId is null");
            return (Criteria) this;
        }

        public Criteria andSpecidIsNotNull() {
            addCriterion("specId is not null");
            return (Criteria) this;
        }

        public Criteria andSpecidEqualTo(Integer value) {
            addCriterion("specId =", value, "specid");
            return (Criteria) this;
        }

        public Criteria andSpecidNotEqualTo(Integer value) {
            addCriterion("specId <>", value, "specid");
            return (Criteria) this;
        }

        public Criteria andSpecidGreaterThan(Integer value) {
            addCriterion("specId >", value, "specid");
            return (Criteria) this;
        }

        public Criteria andSpecidGreaterThanOrEqualTo(Integer value) {
            addCriterion("specId >=", value, "specid");
            return (Criteria) this;
        }

        public Criteria andSpecidLessThan(Integer value) {
            addCriterion("specId <", value, "specid");
            return (Criteria) this;
        }

        public Criteria andSpecidLessThanOrEqualTo(Integer value) {
            addCriterion("specId <=", value, "specid");
            return (Criteria) this;
        }

        public Criteria andSpecidIn(List<Integer> values) {
            addCriterion("specId in", values, "specid");
            return (Criteria) this;
        }

        public Criteria andSpecidNotIn(List<Integer> values) {
            addCriterion("specId not in", values, "specid");
            return (Criteria) this;
        }

        public Criteria andSpecidBetween(Integer value1, Integer value2) {
            addCriterion("specId between", value1, value2, "specid");
            return (Criteria) this;
        }

        public Criteria andSpecidNotBetween(Integer value1, Integer value2) {
            addCriterion("specId not between", value1, value2, "specid");
            return (Criteria) this;
        }

        public Criteria andCollageactivitynameIsNull() {
            addCriterion("collageActivityName is null");
            return (Criteria) this;
        }

        public Criteria andCollageactivitynameIsNotNull() {
            addCriterion("collageActivityName is not null");
            return (Criteria) this;
        }

        public Criteria andCollageactivitynameEqualTo(String value) {
            addCriterion("collageActivityName =", value, "collageactivityname");
            return (Criteria) this;
        }

        public Criteria andCollageactivitynameNotEqualTo(String value) {
            addCriterion("collageActivityName <>", value, "collageactivityname");
            return (Criteria) this;
        }

        public Criteria andCollageactivitynameGreaterThan(String value) {
            addCriterion("collageActivityName >", value, "collageactivityname");
            return (Criteria) this;
        }

        public Criteria andCollageactivitynameGreaterThanOrEqualTo(String value) {
            addCriterion("collageActivityName >=", value, "collageactivityname");
            return (Criteria) this;
        }

        public Criteria andCollageactivitynameLessThan(String value) {
            addCriterion("collageActivityName <", value, "collageactivityname");
            return (Criteria) this;
        }

        public Criteria andCollageactivitynameLessThanOrEqualTo(String value) {
            addCriterion("collageActivityName <=", value, "collageactivityname");
            return (Criteria) this;
        }

        public Criteria andCollageactivitynameLike(String value) {
            addCriterion("collageActivityName like", value, "collageactivityname");
            return (Criteria) this;
        }

        public Criteria andCollageactivitynameNotLike(String value) {
            addCriterion("collageActivityName not like", value, "collageactivityname");
            return (Criteria) this;
        }

        public Criteria andCollageactivitynameIn(List<String> values) {
            addCriterion("collageActivityName in", values, "collageactivityname");
            return (Criteria) this;
        }

        public Criteria andCollageactivitynameNotIn(List<String> values) {
            addCriterion("collageActivityName not in", values, "collageactivityname");
            return (Criteria) this;
        }

        public Criteria andCollageactivitynameBetween(String value1, String value2) {
            addCriterion("collageActivityName between", value1, value2, "collageactivityname");
            return (Criteria) this;
        }

        public Criteria andCollageactivitynameNotBetween(String value1, String value2) {
            addCriterion("collageActivityName not between", value1, value2, "collageactivityname");
            return (Criteria) this;
        }

        public Criteria andCollageactivitypeopleIsNull() {
            addCriterion("collageActivityPeople is null");
            return (Criteria) this;
        }

        public Criteria andCollageactivitypeopleIsNotNull() {
            addCriterion("collageActivityPeople is not null");
            return (Criteria) this;
        }

        public Criteria andCollageactivitypeopleEqualTo(Integer value) {
            addCriterion("collageActivityPeople =", value, "collageactivitypeople");
            return (Criteria) this;
        }

        public Criteria andCollageactivitypeopleNotEqualTo(Integer value) {
            addCriterion("collageActivityPeople <>", value, "collageactivitypeople");
            return (Criteria) this;
        }

        public Criteria andCollageactivitypeopleGreaterThan(Integer value) {
            addCriterion("collageActivityPeople >", value, "collageactivitypeople");
            return (Criteria) this;
        }

        public Criteria andCollageactivitypeopleGreaterThanOrEqualTo(Integer value) {
            addCriterion("collageActivityPeople >=", value, "collageactivitypeople");
            return (Criteria) this;
        }

        public Criteria andCollageactivitypeopleLessThan(Integer value) {
            addCriterion("collageActivityPeople <", value, "collageactivitypeople");
            return (Criteria) this;
        }

        public Criteria andCollageactivitypeopleLessThanOrEqualTo(Integer value) {
            addCriterion("collageActivityPeople <=", value, "collageactivitypeople");
            return (Criteria) this;
        }

        public Criteria andCollageactivitypeopleIn(List<Integer> values) {
            addCriterion("collageActivityPeople in", values, "collageactivitypeople");
            return (Criteria) this;
        }

        public Criteria andCollageactivitypeopleNotIn(List<Integer> values) {
            addCriterion("collageActivityPeople not in", values, "collageactivitypeople");
            return (Criteria) this;
        }

        public Criteria andCollageactivitypeopleBetween(Integer value1, Integer value2) {
            addCriterion("collageActivityPeople between", value1, value2, "collageactivitypeople");
            return (Criteria) this;
        }

        public Criteria andCollageactivitypeopleNotBetween(Integer value1, Integer value2) {
            addCriterion("collageActivityPeople not between", value1, value2, "collageactivitypeople");
            return (Criteria) this;
        }

        public Criteria andActivitystartdateIsNull() {
            addCriterion("activityStartDate is null");
            return (Criteria) this;
        }

        public Criteria andActivitystartdateIsNotNull() {
            addCriterion("activityStartDate is not null");
            return (Criteria) this;
        }

        public Criteria andActivitystartdateEqualTo(Date value) {
            addCriterion("activityStartDate =", value, "activitystartdate");
            return (Criteria) this;
        }

        public Criteria andActivitystartdateNotEqualTo(Date value) {
            addCriterion("activityStartDate <>", value, "activitystartdate");
            return (Criteria) this;
        }

        public Criteria andActivitystartdateGreaterThan(Date value) {
            addCriterion("activityStartDate >", value, "activitystartdate");
            return (Criteria) this;
        }

        public Criteria andActivitystartdateGreaterThanOrEqualTo(Date value) {
            addCriterion("activityStartDate >=", value, "activitystartdate");
            return (Criteria) this;
        }

        public Criteria andActivitystartdateLessThan(Date value) {
            addCriterion("activityStartDate <", value, "activitystartdate");
            return (Criteria) this;
        }

        public Criteria andActivitystartdateLessThanOrEqualTo(Date value) {
            addCriterion("activityStartDate <=", value, "activitystartdate");
            return (Criteria) this;
        }

        public Criteria andActivitystartdateIn(List<Date> values) {
            addCriterion("activityStartDate in", values, "activitystartdate");
            return (Criteria) this;
        }

        public Criteria andActivitystartdateNotIn(List<Date> values) {
            addCriterion("activityStartDate not in", values, "activitystartdate");
            return (Criteria) this;
        }

        public Criteria andActivitystartdateBetween(Date value1, Date value2) {
            addCriterion("activityStartDate between", value1, value2, "activitystartdate");
            return (Criteria) this;
        }

        public Criteria andActivitystartdateNotBetween(Date value1, Date value2) {
            addCriterion("activityStartDate not between", value1, value2, "activitystartdate");
            return (Criteria) this;
        }

        public Criteria andActivityenddateIsNull() {
            addCriterion("activityEndDate is null");
            return (Criteria) this;
        }

        public Criteria andActivityenddateIsNotNull() {
            addCriterion("activityEndDate is not null");
            return (Criteria) this;
        }

        public Criteria andActivityenddateEqualTo(Date value) {
            addCriterion("activityEndDate =", value, "activityenddate");
            return (Criteria) this;
        }

        public Criteria andActivityenddateNotEqualTo(Date value) {
            addCriterion("activityEndDate <>", value, "activityenddate");
            return (Criteria) this;
        }

        public Criteria andActivityenddateGreaterThan(Date value) {
            addCriterion("activityEndDate >", value, "activityenddate");
            return (Criteria) this;
        }

        public Criteria andActivityenddateGreaterThanOrEqualTo(Date value) {
            addCriterion("activityEndDate >=", value, "activityenddate");
            return (Criteria) this;
        }

        public Criteria andActivityenddateLessThan(Date value) {
            addCriterion("activityEndDate <", value, "activityenddate");
            return (Criteria) this;
        }

        public Criteria andActivityenddateLessThanOrEqualTo(Date value) {
            addCriterion("activityEndDate <=", value, "activityenddate");
            return (Criteria) this;
        }

        public Criteria andActivityenddateIn(List<Date> values) {
            addCriterion("activityEndDate in", values, "activityenddate");
            return (Criteria) this;
        }

        public Criteria andActivityenddateNotIn(List<Date> values) {
            addCriterion("activityEndDate not in", values, "activityenddate");
            return (Criteria) this;
        }

        public Criteria andActivityenddateBetween(Date value1, Date value2) {
            addCriterion("activityEndDate between", value1, value2, "activityenddate");
            return (Criteria) this;
        }

        public Criteria andActivityenddateNotBetween(Date value1, Date value2) {
            addCriterion("activityEndDate not between", value1, value2, "activityenddate");
            return (Criteria) this;
        }

        public Criteria andCollagevaliddateIsNull() {
            addCriterion("collageValidDate is null");
            return (Criteria) this;
        }

        public Criteria andCollagevaliddateIsNotNull() {
            addCriterion("collageValidDate is not null");
            return (Criteria) this;
        }

        public Criteria andCollagevaliddateEqualTo(Integer value) {
            addCriterion("collageValidDate =", value, "collagevaliddate");
            return (Criteria) this;
        }

        public Criteria andCollagevaliddateNotEqualTo(Integer value) {
            addCriterion("collageValidDate <>", value, "collagevaliddate");
            return (Criteria) this;
        }

        public Criteria andCollagevaliddateGreaterThan(Integer value) {
            addCriterion("collageValidDate >", value, "collagevaliddate");
            return (Criteria) this;
        }

        public Criteria andCollagevaliddateGreaterThanOrEqualTo(Integer value) {
            addCriterion("collageValidDate >=", value, "collagevaliddate");
            return (Criteria) this;
        }

        public Criteria andCollagevaliddateLessThan(Integer value) {
            addCriterion("collageValidDate <", value, "collagevaliddate");
            return (Criteria) this;
        }

        public Criteria andCollagevaliddateLessThanOrEqualTo(Integer value) {
            addCriterion("collageValidDate <=", value, "collagevaliddate");
            return (Criteria) this;
        }

        public Criteria andCollagevaliddateIn(List<Integer> values) {
            addCriterion("collageValidDate in", values, "collagevaliddate");
            return (Criteria) this;
        }

        public Criteria andCollagevaliddateNotIn(List<Integer> values) {
            addCriterion("collageValidDate not in", values, "collagevaliddate");
            return (Criteria) this;
        }

        public Criteria andCollagevaliddateBetween(Integer value1, Integer value2) {
            addCriterion("collageValidDate between", value1, value2, "collagevaliddate");
            return (Criteria) this;
        }

        public Criteria andCollagevaliddateNotBetween(Integer value1, Integer value2) {
            addCriterion("collageValidDate not between", value1, value2, "collagevaliddate");
            return (Criteria) this;
        }

        public Criteria andPartsnumberIsNull() {
            addCriterion("partsNumber is null");
            return (Criteria) this;
        }

        public Criteria andPartsnumberIsNotNull() {
            addCriterion("partsNumber is not null");
            return (Criteria) this;
        }

        public Criteria andPartsnumberEqualTo(Integer value) {
            addCriterion("partsNumber =", value, "partsnumber");
            return (Criteria) this;
        }

        public Criteria andPartsnumberNotEqualTo(Integer value) {
            addCriterion("partsNumber <>", value, "partsnumber");
            return (Criteria) this;
        }

        public Criteria andPartsnumberGreaterThan(Integer value) {
            addCriterion("partsNumber >", value, "partsnumber");
            return (Criteria) this;
        }

        public Criteria andPartsnumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("partsNumber >=", value, "partsnumber");
            return (Criteria) this;
        }

        public Criteria andPartsnumberLessThan(Integer value) {
            addCriterion("partsNumber <", value, "partsnumber");
            return (Criteria) this;
        }

        public Criteria andPartsnumberLessThanOrEqualTo(Integer value) {
            addCriterion("partsNumber <=", value, "partsnumber");
            return (Criteria) this;
        }

        public Criteria andPartsnumberIn(List<Integer> values) {
            addCriterion("partsNumber in", values, "partsnumber");
            return (Criteria) this;
        }

        public Criteria andPartsnumberNotIn(List<Integer> values) {
            addCriterion("partsNumber not in", values, "partsnumber");
            return (Criteria) this;
        }

        public Criteria andPartsnumberBetween(Integer value1, Integer value2) {
            addCriterion("partsNumber between", value1, value2, "partsnumber");
            return (Criteria) this;
        }

        public Criteria andPartsnumberNotBetween(Integer value1, Integer value2) {
            addCriterion("partsNumber not between", value1, value2, "partsnumber");
            return (Criteria) this;
        }

        public Criteria andLimitedpurchaseIsNull() {
            addCriterion("limitedPurchase is null");
            return (Criteria) this;
        }

        public Criteria andLimitedpurchaseIsNotNull() {
            addCriterion("limitedPurchase is not null");
            return (Criteria) this;
        }

        public Criteria andLimitedpurchaseEqualTo(Integer value) {
            addCriterion("limitedPurchase =", value, "limitedpurchase");
            return (Criteria) this;
        }

        public Criteria andLimitedpurchaseNotEqualTo(Integer value) {
            addCriterion("limitedPurchase <>", value, "limitedpurchase");
            return (Criteria) this;
        }

        public Criteria andLimitedpurchaseGreaterThan(Integer value) {
            addCriterion("limitedPurchase >", value, "limitedpurchase");
            return (Criteria) this;
        }

        public Criteria andLimitedpurchaseGreaterThanOrEqualTo(Integer value) {
            addCriterion("limitedPurchase >=", value, "limitedpurchase");
            return (Criteria) this;
        }

        public Criteria andLimitedpurchaseLessThan(Integer value) {
            addCriterion("limitedPurchase <", value, "limitedpurchase");
            return (Criteria) this;
        }

        public Criteria andLimitedpurchaseLessThanOrEqualTo(Integer value) {
            addCriterion("limitedPurchase <=", value, "limitedpurchase");
            return (Criteria) this;
        }

        public Criteria andLimitedpurchaseIn(List<Integer> values) {
            addCriterion("limitedPurchase in", values, "limitedpurchase");
            return (Criteria) this;
        }

        public Criteria andLimitedpurchaseNotIn(List<Integer> values) {
            addCriterion("limitedPurchase not in", values, "limitedpurchase");
            return (Criteria) this;
        }

        public Criteria andLimitedpurchaseBetween(Integer value1, Integer value2) {
            addCriterion("limitedPurchase between", value1, value2, "limitedpurchase");
            return (Criteria) this;
        }

        public Criteria andLimitedpurchaseNotBetween(Integer value1, Integer value2) {
            addCriterion("limitedPurchase not between", value1, value2, "limitedpurchase");
            return (Criteria) this;
        }

        public Criteria andCollageactivitypriceIsNull() {
            addCriterion("collageActivityPrice is null");
            return (Criteria) this;
        }

        public Criteria andCollageactivitypriceIsNotNull() {
            addCriterion("collageActivityPrice is not null");
            return (Criteria) this;
        }

        public Criteria andCollageactivitypriceEqualTo(BigDecimal value) {
            addCriterion("collageActivityPrice =", value, "collageactivityprice");
            return (Criteria) this;
        }

        public Criteria andCollageactivitypriceNotEqualTo(BigDecimal value) {
            addCriterion("collageActivityPrice <>", value, "collageactivityprice");
            return (Criteria) this;
        }

        public Criteria andCollageactivitypriceGreaterThan(BigDecimal value) {
            addCriterion("collageActivityPrice >", value, "collageactivityprice");
            return (Criteria) this;
        }

        public Criteria andCollageactivitypriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("collageActivityPrice >=", value, "collageactivityprice");
            return (Criteria) this;
        }

        public Criteria andCollageactivitypriceLessThan(BigDecimal value) {
            addCriterion("collageActivityPrice <", value, "collageactivityprice");
            return (Criteria) this;
        }

        public Criteria andCollageactivitypriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("collageActivityPrice <=", value, "collageactivityprice");
            return (Criteria) this;
        }

        public Criteria andCollageactivitypriceIn(List<BigDecimal> values) {
            addCriterion("collageActivityPrice in", values, "collageactivityprice");
            return (Criteria) this;
        }

        public Criteria andCollageactivitypriceNotIn(List<BigDecimal> values) {
            addCriterion("collageActivityPrice not in", values, "collageactivityprice");
            return (Criteria) this;
        }

        public Criteria andCollageactivitypriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("collageActivityPrice between", value1, value2, "collageactivityprice");
            return (Criteria) this;
        }

        public Criteria andCollageactivitypriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("collageActivityPrice not between", value1, value2, "collageactivityprice");
            return (Criteria) this;
        }

        public Criteria andCollageactivitystatusIsNull() {
            addCriterion("collageActivityStatus is null");
            return (Criteria) this;
        }

        public Criteria andCollageactivitystatusIsNotNull() {
            addCriterion("collageActivityStatus is not null");
            return (Criteria) this;
        }

        public Criteria andCollageactivitystatusEqualTo(Integer value) {
            addCriterion("collageActivityStatus =", value, "collageactivitystatus");
            return (Criteria) this;
        }

        public Criteria andCollageactivitystatusNotEqualTo(Integer value) {
            addCriterion("collageActivityStatus <>", value, "collageactivitystatus");
            return (Criteria) this;
        }

        public Criteria andCollageactivitystatusGreaterThan(Integer value) {
            addCriterion("collageActivityStatus >", value, "collageactivitystatus");
            return (Criteria) this;
        }

        public Criteria andCollageactivitystatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("collageActivityStatus >=", value, "collageactivitystatus");
            return (Criteria) this;
        }

        public Criteria andCollageactivitystatusLessThan(Integer value) {
            addCriterion("collageActivityStatus <", value, "collageactivitystatus");
            return (Criteria) this;
        }

        public Criteria andCollageactivitystatusLessThanOrEqualTo(Integer value) {
            addCriterion("collageActivityStatus <=", value, "collageactivitystatus");
            return (Criteria) this;
        }

        public Criteria andCollageactivitystatusIn(List<Integer> values) {
            addCriterion("collageActivityStatus in", values, "collageactivitystatus");
            return (Criteria) this;
        }

        public Criteria andCollageactivitystatusNotIn(List<Integer> values) {
            addCriterion("collageActivityStatus not in", values, "collageactivitystatus");
            return (Criteria) this;
        }

        public Criteria andCollageactivitystatusBetween(Integer value1, Integer value2) {
            addCriterion("collageActivityStatus between", value1, value2, "collageactivitystatus");
            return (Criteria) this;
        }

        public Criteria andCollageactivitystatusNotBetween(Integer value1, Integer value2) {
            addCriterion("collageActivityStatus not between", value1, value2, "collageactivitystatus");
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

        public Criteria andCreatedateIsNull() {
            addCriterion("createDate is null");
            return (Criteria) this;
        }

        public Criteria andCreatedateIsNotNull() {
            addCriterion("createDate is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedateEqualTo(Date value) {
            addCriterion("createDate =", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateNotEqualTo(Date value) {
            addCriterion("createDate <>", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateGreaterThan(Date value) {
            addCriterion("createDate >", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateGreaterThanOrEqualTo(Date value) {
            addCriterion("createDate >=", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateLessThan(Date value) {
            addCriterion("createDate <", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateLessThanOrEqualTo(Date value) {
            addCriterion("createDate <=", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateIn(List<Date> values) {
            addCriterion("createDate in", values, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateNotIn(List<Date> values) {
            addCriterion("createDate not in", values, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateBetween(Date value1, Date value2) {
            addCriterion("createDate between", value1, value2, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateNotBetween(Date value1, Date value2) {
            addCriterion("createDate not between", value1, value2, "createdate");
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