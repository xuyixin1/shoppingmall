package com.vicmob.shoppingmall.web.goodsAPI.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MallGoodsCollageExample {
    protected String pk_name = "collageId";

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MallGoodsCollageExample() {
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

        public Criteria andCollageidIsNull() {
            addCriterion("collageId is null");
            return (Criteria) this;
        }

        public Criteria andCollageidIsNotNull() {
            addCriterion("collageId is not null");
            return (Criteria) this;
        }

        public Criteria andCollageidEqualTo(Integer value) {
            addCriterion("collageId =", value, "collageid");
            return (Criteria) this;
        }

        public Criteria andCollageidNotEqualTo(Integer value) {
            addCriterion("collageId <>", value, "collageid");
            return (Criteria) this;
        }

        public Criteria andCollageidGreaterThan(Integer value) {
            addCriterion("collageId >", value, "collageid");
            return (Criteria) this;
        }

        public Criteria andCollageidGreaterThanOrEqualTo(Integer value) {
            addCriterion("collageId >=", value, "collageid");
            return (Criteria) this;
        }

        public Criteria andCollageidLessThan(Integer value) {
            addCriterion("collageId <", value, "collageid");
            return (Criteria) this;
        }

        public Criteria andCollageidLessThanOrEqualTo(Integer value) {
            addCriterion("collageId <=", value, "collageid");
            return (Criteria) this;
        }

        public Criteria andCollageidIn(List<Integer> values) {
            addCriterion("collageId in", values, "collageid");
            return (Criteria) this;
        }

        public Criteria andCollageidNotIn(List<Integer> values) {
            addCriterion("collageId not in", values, "collageid");
            return (Criteria) this;
        }

        public Criteria andCollageidBetween(Integer value1, Integer value2) {
            addCriterion("collageId between", value1, value2, "collageid");
            return (Criteria) this;
        }

        public Criteria andCollageidNotBetween(Integer value1, Integer value2) {
            addCriterion("collageId not between", value1, value2, "collageid");
            return (Criteria) this;
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

        public Criteria andCollagestartdateIsNull() {
            addCriterion("collageStartDate is null");
            return (Criteria) this;
        }

        public Criteria andCollagestartdateIsNotNull() {
            addCriterion("collageStartDate is not null");
            return (Criteria) this;
        }

        public Criteria andCollagestartdateEqualTo(Date value) {
            addCriterion("collageStartDate =", value, "collagestartdate");
            return (Criteria) this;
        }

        public Criteria andCollagestartdateNotEqualTo(Date value) {
            addCriterion("collageStartDate <>", value, "collagestartdate");
            return (Criteria) this;
        }

        public Criteria andCollagestartdateGreaterThan(Date value) {
            addCriterion("collageStartDate >", value, "collagestartdate");
            return (Criteria) this;
        }

        public Criteria andCollagestartdateGreaterThanOrEqualTo(Date value) {
            addCriterion("collageStartDate >=", value, "collagestartdate");
            return (Criteria) this;
        }

        public Criteria andCollagestartdateLessThan(Date value) {
            addCriterion("collageStartDate <", value, "collagestartdate");
            return (Criteria) this;
        }

        public Criteria andCollagestartdateLessThanOrEqualTo(Date value) {
            addCriterion("collageStartDate <=", value, "collagestartdate");
            return (Criteria) this;
        }

        public Criteria andCollagestartdateIn(List<Date> values) {
            addCriterion("collageStartDate in", values, "collagestartdate");
            return (Criteria) this;
        }

        public Criteria andCollagestartdateNotIn(List<Date> values) {
            addCriterion("collageStartDate not in", values, "collagestartdate");
            return (Criteria) this;
        }

        public Criteria andCollagestartdateBetween(Date value1, Date value2) {
            addCriterion("collageStartDate between", value1, value2, "collagestartdate");
            return (Criteria) this;
        }

        public Criteria andCollagestartdateNotBetween(Date value1, Date value2) {
            addCriterion("collageStartDate not between", value1, value2, "collagestartdate");
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

        public Criteria andGoodsnameIsNull() {
            addCriterion("goodsName is null");
            return (Criteria) this;
        }

        public Criteria andGoodsnameIsNotNull() {
            addCriterion("goodsName is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsnameEqualTo(String value) {
            addCriterion("goodsName =", value, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsnameNotEqualTo(String value) {
            addCriterion("goodsName <>", value, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsnameGreaterThan(String value) {
            addCriterion("goodsName >", value, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsnameGreaterThanOrEqualTo(String value) {
            addCriterion("goodsName >=", value, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsnameLessThan(String value) {
            addCriterion("goodsName <", value, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsnameLessThanOrEqualTo(String value) {
            addCriterion("goodsName <=", value, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsnameLike(String value) {
            addCriterion("goodsName like", value, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsnameNotLike(String value) {
            addCriterion("goodsName not like", value, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsnameIn(List<String> values) {
            addCriterion("goodsName in", values, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsnameNotIn(List<String> values) {
            addCriterion("goodsName not in", values, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsnameBetween(String value1, String value2) {
            addCriterion("goodsName between", value1, value2, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsnameNotBetween(String value1, String value2) {
            addCriterion("goodsName not between", value1, value2, "goodsname");
            return (Criteria) this;
        }

        public Criteria andAlcollagepeopleIsNull() {
            addCriterion("alCollagePeople is null");
            return (Criteria) this;
        }

        public Criteria andAlcollagepeopleIsNotNull() {
            addCriterion("alCollagePeople is not null");
            return (Criteria) this;
        }

        public Criteria andAlcollagepeopleEqualTo(Integer value) {
            addCriterion("alCollagePeople =", value, "alcollagepeople");
            return (Criteria) this;
        }

        public Criteria andAlcollagepeopleNotEqualTo(Integer value) {
            addCriterion("alCollagePeople <>", value, "alcollagepeople");
            return (Criteria) this;
        }

        public Criteria andAlcollagepeopleGreaterThan(Integer value) {
            addCriterion("alCollagePeople >", value, "alcollagepeople");
            return (Criteria) this;
        }

        public Criteria andAlcollagepeopleGreaterThanOrEqualTo(Integer value) {
            addCriterion("alCollagePeople >=", value, "alcollagepeople");
            return (Criteria) this;
        }

        public Criteria andAlcollagepeopleLessThan(Integer value) {
            addCriterion("alCollagePeople <", value, "alcollagepeople");
            return (Criteria) this;
        }

        public Criteria andAlcollagepeopleLessThanOrEqualTo(Integer value) {
            addCriterion("alCollagePeople <=", value, "alcollagepeople");
            return (Criteria) this;
        }

        public Criteria andAlcollagepeopleIn(List<Integer> values) {
            addCriterion("alCollagePeople in", values, "alcollagepeople");
            return (Criteria) this;
        }

        public Criteria andAlcollagepeopleNotIn(List<Integer> values) {
            addCriterion("alCollagePeople not in", values, "alcollagepeople");
            return (Criteria) this;
        }

        public Criteria andAlcollagepeopleBetween(Integer value1, Integer value2) {
            addCriterion("alCollagePeople between", value1, value2, "alcollagepeople");
            return (Criteria) this;
        }

        public Criteria andAlcollagepeopleNotBetween(Integer value1, Integer value2) {
            addCriterion("alCollagePeople not between", value1, value2, "alcollagepeople");
            return (Criteria) this;
        }

        public Criteria andCollagestatusIsNull() {
            addCriterion("collageStatus is null");
            return (Criteria) this;
        }

        public Criteria andCollagestatusIsNotNull() {
            addCriterion("collageStatus is not null");
            return (Criteria) this;
        }

        public Criteria andCollagestatusEqualTo(Integer value) {
            addCriterion("collageStatus =", value, "collagestatus");
            return (Criteria) this;
        }

        public Criteria andCollagestatusNotEqualTo(Integer value) {
            addCriterion("collageStatus <>", value, "collagestatus");
            return (Criteria) this;
        }

        public Criteria andCollagestatusGreaterThan(Integer value) {
            addCriterion("collageStatus >", value, "collagestatus");
            return (Criteria) this;
        }

        public Criteria andCollagestatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("collageStatus >=", value, "collagestatus");
            return (Criteria) this;
        }

        public Criteria andCollagestatusLessThan(Integer value) {
            addCriterion("collageStatus <", value, "collagestatus");
            return (Criteria) this;
        }

        public Criteria andCollagestatusLessThanOrEqualTo(Integer value) {
            addCriterion("collageStatus <=", value, "collagestatus");
            return (Criteria) this;
        }

        public Criteria andCollagestatusIn(List<Integer> values) {
            addCriterion("collageStatus in", values, "collagestatus");
            return (Criteria) this;
        }

        public Criteria andCollagestatusNotIn(List<Integer> values) {
            addCriterion("collageStatus not in", values, "collagestatus");
            return (Criteria) this;
        }

        public Criteria andCollagestatusBetween(Integer value1, Integer value2) {
            addCriterion("collageStatus between", value1, value2, "collagestatus");
            return (Criteria) this;
        }

        public Criteria andCollagestatusNotBetween(Integer value1, Integer value2) {
            addCriterion("collageStatus not between", value1, value2, "collagestatus");
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