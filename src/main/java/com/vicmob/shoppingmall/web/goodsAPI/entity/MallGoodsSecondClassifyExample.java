package com.vicmob.shoppingmall.web.goodsAPI.entity;

import java.util.ArrayList;
import java.util.List;

public class MallGoodsSecondClassifyExample {
    protected String pk_name = "secondClassifyId";

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MallGoodsSecondClassifyExample() {
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

        public Criteria andSecondclassifyidIsNull() {
            addCriterion("secondClassifyId is null");
            return (Criteria) this;
        }

        public Criteria andSecondclassifyidIsNotNull() {
            addCriterion("secondClassifyId is not null");
            return (Criteria) this;
        }

        public Criteria andSecondclassifyidEqualTo(Integer value) {
            addCriterion("secondClassifyId =", value, "secondclassifyid");
            return (Criteria) this;
        }

        public Criteria andSecondclassifyidNotEqualTo(Integer value) {
            addCriterion("secondClassifyId <>", value, "secondclassifyid");
            return (Criteria) this;
        }

        public Criteria andSecondclassifyidGreaterThan(Integer value) {
            addCriterion("secondClassifyId >", value, "secondclassifyid");
            return (Criteria) this;
        }

        public Criteria andSecondclassifyidGreaterThanOrEqualTo(Integer value) {
            addCriterion("secondClassifyId >=", value, "secondclassifyid");
            return (Criteria) this;
        }

        public Criteria andSecondclassifyidLessThan(Integer value) {
            addCriterion("secondClassifyId <", value, "secondclassifyid");
            return (Criteria) this;
        }

        public Criteria andSecondclassifyidLessThanOrEqualTo(Integer value) {
            addCriterion("secondClassifyId <=", value, "secondclassifyid");
            return (Criteria) this;
        }

        public Criteria andSecondclassifyidIn(List<Integer> values) {
            addCriterion("secondClassifyId in", values, "secondclassifyid");
            return (Criteria) this;
        }

        public Criteria andSecondclassifyidNotIn(List<Integer> values) {
            addCriterion("secondClassifyId not in", values, "secondclassifyid");
            return (Criteria) this;
        }

        public Criteria andSecondclassifyidBetween(Integer value1, Integer value2) {
            addCriterion("secondClassifyId between", value1, value2, "secondclassifyid");
            return (Criteria) this;
        }

        public Criteria andSecondclassifyidNotBetween(Integer value1, Integer value2) {
            addCriterion("secondClassifyId not between", value1, value2, "secondclassifyid");
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

        public Criteria andSecondclassifynameIsNull() {
            addCriterion("secondClassifyName is null");
            return (Criteria) this;
        }

        public Criteria andSecondclassifynameIsNotNull() {
            addCriterion("secondClassifyName is not null");
            return (Criteria) this;
        }

        public Criteria andSecondclassifynameEqualTo(String value) {
            addCriterion("secondClassifyName =", value, "secondclassifyname");
            return (Criteria) this;
        }

        public Criteria andSecondclassifynameNotEqualTo(String value) {
            addCriterion("secondClassifyName <>", value, "secondclassifyname");
            return (Criteria) this;
        }

        public Criteria andSecondclassifynameGreaterThan(String value) {
            addCriterion("secondClassifyName >", value, "secondclassifyname");
            return (Criteria) this;
        }

        public Criteria andSecondclassifynameGreaterThanOrEqualTo(String value) {
            addCriterion("secondClassifyName >=", value, "secondclassifyname");
            return (Criteria) this;
        }

        public Criteria andSecondclassifynameLessThan(String value) {
            addCriterion("secondClassifyName <", value, "secondclassifyname");
            return (Criteria) this;
        }

        public Criteria andSecondclassifynameLessThanOrEqualTo(String value) {
            addCriterion("secondClassifyName <=", value, "secondclassifyname");
            return (Criteria) this;
        }

        public Criteria andSecondclassifynameLike(String value) {
            addCriterion("secondClassifyName like", value, "secondclassifyname");
            return (Criteria) this;
        }

        public Criteria andSecondclassifynameNotLike(String value) {
            addCriterion("secondClassifyName not like", value, "secondclassifyname");
            return (Criteria) this;
        }

        public Criteria andSecondclassifynameIn(List<String> values) {
            addCriterion("secondClassifyName in", values, "secondclassifyname");
            return (Criteria) this;
        }

        public Criteria andSecondclassifynameNotIn(List<String> values) {
            addCriterion("secondClassifyName not in", values, "secondclassifyname");
            return (Criteria) this;
        }

        public Criteria andSecondclassifynameBetween(String value1, String value2) {
            addCriterion("secondClassifyName between", value1, value2, "secondclassifyname");
            return (Criteria) this;
        }

        public Criteria andSecondclassifynameNotBetween(String value1, String value2) {
            addCriterion("secondClassifyName not between", value1, value2, "secondclassifyname");
            return (Criteria) this;
        }

        public Criteria andClassifypictureurlIsNull() {
            addCriterion("classifyPictureUrl is null");
            return (Criteria) this;
        }

        public Criteria andClassifypictureurlIsNotNull() {
            addCriterion("classifyPictureUrl is not null");
            return (Criteria) this;
        }

        public Criteria andClassifypictureurlEqualTo(String value) {
            addCriterion("classifyPictureUrl =", value, "classifypictureurl");
            return (Criteria) this;
        }

        public Criteria andClassifypictureurlNotEqualTo(String value) {
            addCriterion("classifyPictureUrl <>", value, "classifypictureurl");
            return (Criteria) this;
        }

        public Criteria andClassifypictureurlGreaterThan(String value) {
            addCriterion("classifyPictureUrl >", value, "classifypictureurl");
            return (Criteria) this;
        }

        public Criteria andClassifypictureurlGreaterThanOrEqualTo(String value) {
            addCriterion("classifyPictureUrl >=", value, "classifypictureurl");
            return (Criteria) this;
        }

        public Criteria andClassifypictureurlLessThan(String value) {
            addCriterion("classifyPictureUrl <", value, "classifypictureurl");
            return (Criteria) this;
        }

        public Criteria andClassifypictureurlLessThanOrEqualTo(String value) {
            addCriterion("classifyPictureUrl <=", value, "classifypictureurl");
            return (Criteria) this;
        }

        public Criteria andClassifypictureurlLike(String value) {
            addCriterion("classifyPictureUrl like", value, "classifypictureurl");
            return (Criteria) this;
        }

        public Criteria andClassifypictureurlNotLike(String value) {
            addCriterion("classifyPictureUrl not like", value, "classifypictureurl");
            return (Criteria) this;
        }

        public Criteria andClassifypictureurlIn(List<String> values) {
            addCriterion("classifyPictureUrl in", values, "classifypictureurl");
            return (Criteria) this;
        }

        public Criteria andClassifypictureurlNotIn(List<String> values) {
            addCriterion("classifyPictureUrl not in", values, "classifypictureurl");
            return (Criteria) this;
        }

        public Criteria andClassifypictureurlBetween(String value1, String value2) {
            addCriterion("classifyPictureUrl between", value1, value2, "classifypictureurl");
            return (Criteria) this;
        }

        public Criteria andClassifypictureurlNotBetween(String value1, String value2) {
            addCriterion("classifyPictureUrl not between", value1, value2, "classifypictureurl");
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