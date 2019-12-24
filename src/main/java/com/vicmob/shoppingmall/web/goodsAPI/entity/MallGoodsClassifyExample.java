package com.vicmob.shoppingmall.web.goodsAPI.entity;

import java.util.ArrayList;
import java.util.List;

public class MallGoodsClassifyExample {
    protected String pk_name = "classifyId";

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MallGoodsClassifyExample() {
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

        public Criteria andClassifyidIsNull() {
            addCriterion("classifyId is null");
            return (Criteria) this;
        }

        public Criteria andClassifyidIsNotNull() {
            addCriterion("classifyId is not null");
            return (Criteria) this;
        }

        public Criteria andClassifyidEqualTo(Integer value) {
            addCriterion("classifyId =", value, "classifyid");
            return (Criteria) this;
        }

        public Criteria andClassifyidNotEqualTo(Integer value) {
            addCriterion("classifyId <>", value, "classifyid");
            return (Criteria) this;
        }

        public Criteria andClassifyidGreaterThan(Integer value) {
            addCriterion("classifyId >", value, "classifyid");
            return (Criteria) this;
        }

        public Criteria andClassifyidGreaterThanOrEqualTo(Integer value) {
            addCriterion("classifyId >=", value, "classifyid");
            return (Criteria) this;
        }

        public Criteria andClassifyidLessThan(Integer value) {
            addCriterion("classifyId <", value, "classifyid");
            return (Criteria) this;
        }

        public Criteria andClassifyidLessThanOrEqualTo(Integer value) {
            addCriterion("classifyId <=", value, "classifyid");
            return (Criteria) this;
        }

        public Criteria andClassifyidIn(List<Integer> values) {
            addCriterion("classifyId in", values, "classifyid");
            return (Criteria) this;
        }

        public Criteria andClassifyidNotIn(List<Integer> values) {
            addCriterion("classifyId not in", values, "classifyid");
            return (Criteria) this;
        }

        public Criteria andClassifyidBetween(Integer value1, Integer value2) {
            addCriterion("classifyId between", value1, value2, "classifyid");
            return (Criteria) this;
        }

        public Criteria andClassifyidNotBetween(Integer value1, Integer value2) {
            addCriterion("classifyId not between", value1, value2, "classifyid");
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

        public Criteria andClassifynameIsNull() {
            addCriterion("classifyName is null");
            return (Criteria) this;
        }

        public Criteria andClassifynameIsNotNull() {
            addCriterion("classifyName is not null");
            return (Criteria) this;
        }

        public Criteria andClassifynameEqualTo(String value) {
            addCriterion("classifyName =", value, "classifyname");
            return (Criteria) this;
        }

        public Criteria andClassifynameNotEqualTo(String value) {
            addCriterion("classifyName <>", value, "classifyname");
            return (Criteria) this;
        }

        public Criteria andClassifynameGreaterThan(String value) {
            addCriterion("classifyName >", value, "classifyname");
            return (Criteria) this;
        }

        public Criteria andClassifynameGreaterThanOrEqualTo(String value) {
            addCriterion("classifyName >=", value, "classifyname");
            return (Criteria) this;
        }

        public Criteria andClassifynameLessThan(String value) {
            addCriterion("classifyName <", value, "classifyname");
            return (Criteria) this;
        }

        public Criteria andClassifynameLessThanOrEqualTo(String value) {
            addCriterion("classifyName <=", value, "classifyname");
            return (Criteria) this;
        }

        public Criteria andClassifynameLike(String value) {
            addCriterion("classifyName like", value, "classifyname");
            return (Criteria) this;
        }

        public Criteria andClassifynameNotLike(String value) {
            addCriterion("classifyName not like", value, "classifyname");
            return (Criteria) this;
        }

        public Criteria andClassifynameIn(List<String> values) {
            addCriterion("classifyName in", values, "classifyname");
            return (Criteria) this;
        }

        public Criteria andClassifynameNotIn(List<String> values) {
            addCriterion("classifyName not in", values, "classifyname");
            return (Criteria) this;
        }

        public Criteria andClassifynameBetween(String value1, String value2) {
            addCriterion("classifyName between", value1, value2, "classifyname");
            return (Criteria) this;
        }

        public Criteria andClassifynameNotBetween(String value1, String value2) {
            addCriterion("classifyName not between", value1, value2, "classifyname");
            return (Criteria) this;
        }

        public Criteria andSortIsNull() {
            addCriterion("sort is null");
            return (Criteria) this;
        }

        public Criteria andSortIsNotNull() {
            addCriterion("sort is not null");
            return (Criteria) this;
        }

        public Criteria andSortEqualTo(Integer value) {
            addCriterion("sort =", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotEqualTo(Integer value) {
            addCriterion("sort <>", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThan(Integer value) {
            addCriterion("sort >", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThanOrEqualTo(Integer value) {
            addCriterion("sort >=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThan(Integer value) {
            addCriterion("sort <", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThanOrEqualTo(Integer value) {
            addCriterion("sort <=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortIn(List<Integer> values) {
            addCriterion("sort in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotIn(List<Integer> values) {
            addCriterion("sort not in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortBetween(Integer value1, Integer value2) {
            addCriterion("sort between", value1, value2, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotBetween(Integer value1, Integer value2) {
            addCriterion("sort not between", value1, value2, "sort");
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