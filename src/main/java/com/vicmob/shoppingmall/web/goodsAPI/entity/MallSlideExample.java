package com.vicmob.shoppingmall.web.goodsAPI.entity;

import java.util.ArrayList;
import java.util.List;

public class MallSlideExample {
    protected String pk_name = "slideId";

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MallSlideExample() {
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

        public Criteria andSlideidIsNull() {
            addCriterion("slideId is null");
            return (Criteria) this;
        }

        public Criteria andSlideidIsNotNull() {
            addCriterion("slideId is not null");
            return (Criteria) this;
        }

        public Criteria andSlideidEqualTo(Integer value) {
            addCriterion("slideId =", value, "slideid");
            return (Criteria) this;
        }

        public Criteria andSlideidNotEqualTo(Integer value) {
            addCriterion("slideId <>", value, "slideid");
            return (Criteria) this;
        }

        public Criteria andSlideidGreaterThan(Integer value) {
            addCriterion("slideId >", value, "slideid");
            return (Criteria) this;
        }

        public Criteria andSlideidGreaterThanOrEqualTo(Integer value) {
            addCriterion("slideId >=", value, "slideid");
            return (Criteria) this;
        }

        public Criteria andSlideidLessThan(Integer value) {
            addCriterion("slideId <", value, "slideid");
            return (Criteria) this;
        }

        public Criteria andSlideidLessThanOrEqualTo(Integer value) {
            addCriterion("slideId <=", value, "slideid");
            return (Criteria) this;
        }

        public Criteria andSlideidIn(List<Integer> values) {
            addCriterion("slideId in", values, "slideid");
            return (Criteria) this;
        }

        public Criteria andSlideidNotIn(List<Integer> values) {
            addCriterion("slideId not in", values, "slideid");
            return (Criteria) this;
        }

        public Criteria andSlideidBetween(Integer value1, Integer value2) {
            addCriterion("slideId between", value1, value2, "slideid");
            return (Criteria) this;
        }

        public Criteria andSlideidNotBetween(Integer value1, Integer value2) {
            addCriterion("slideId not between", value1, value2, "slideid");
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

        public Criteria andSlidenameIsNull() {
            addCriterion("slideName is null");
            return (Criteria) this;
        }

        public Criteria andSlidenameIsNotNull() {
            addCriterion("slideName is not null");
            return (Criteria) this;
        }

        public Criteria andSlidenameEqualTo(String value) {
            addCriterion("slideName =", value, "slidename");
            return (Criteria) this;
        }

        public Criteria andSlidenameNotEqualTo(String value) {
            addCriterion("slideName <>", value, "slidename");
            return (Criteria) this;
        }

        public Criteria andSlidenameGreaterThan(String value) {
            addCriterion("slideName >", value, "slidename");
            return (Criteria) this;
        }

        public Criteria andSlidenameGreaterThanOrEqualTo(String value) {
            addCriterion("slideName >=", value, "slidename");
            return (Criteria) this;
        }

        public Criteria andSlidenameLessThan(String value) {
            addCriterion("slideName <", value, "slidename");
            return (Criteria) this;
        }

        public Criteria andSlidenameLessThanOrEqualTo(String value) {
            addCriterion("slideName <=", value, "slidename");
            return (Criteria) this;
        }

        public Criteria andSlidenameLike(String value) {
            addCriterion("slideName like", value, "slidename");
            return (Criteria) this;
        }

        public Criteria andSlidenameNotLike(String value) {
            addCriterion("slideName not like", value, "slidename");
            return (Criteria) this;
        }

        public Criteria andSlidenameIn(List<String> values) {
            addCriterion("slideName in", values, "slidename");
            return (Criteria) this;
        }

        public Criteria andSlidenameNotIn(List<String> values) {
            addCriterion("slideName not in", values, "slidename");
            return (Criteria) this;
        }

        public Criteria andSlidenameBetween(String value1, String value2) {
            addCriterion("slideName between", value1, value2, "slidename");
            return (Criteria) this;
        }

        public Criteria andSlidenameNotBetween(String value1, String value2) {
            addCriterion("slideName not between", value1, value2, "slidename");
            return (Criteria) this;
        }

        public Criteria andPicurlIsNull() {
            addCriterion("picUrl is null");
            return (Criteria) this;
        }

        public Criteria andPicurlIsNotNull() {
            addCriterion("picUrl is not null");
            return (Criteria) this;
        }

        public Criteria andPicurlEqualTo(String value) {
            addCriterion("picUrl =", value, "picurl");
            return (Criteria) this;
        }

        public Criteria andPicurlNotEqualTo(String value) {
            addCriterion("picUrl <>", value, "picurl");
            return (Criteria) this;
        }

        public Criteria andPicurlGreaterThan(String value) {
            addCriterion("picUrl >", value, "picurl");
            return (Criteria) this;
        }

        public Criteria andPicurlGreaterThanOrEqualTo(String value) {
            addCriterion("picUrl >=", value, "picurl");
            return (Criteria) this;
        }

        public Criteria andPicurlLessThan(String value) {
            addCriterion("picUrl <", value, "picurl");
            return (Criteria) this;
        }

        public Criteria andPicurlLessThanOrEqualTo(String value) {
            addCriterion("picUrl <=", value, "picurl");
            return (Criteria) this;
        }

        public Criteria andPicurlLike(String value) {
            addCriterion("picUrl like", value, "picurl");
            return (Criteria) this;
        }

        public Criteria andPicurlNotLike(String value) {
            addCriterion("picUrl not like", value, "picurl");
            return (Criteria) this;
        }

        public Criteria andPicurlIn(List<String> values) {
            addCriterion("picUrl in", values, "picurl");
            return (Criteria) this;
        }

        public Criteria andPicurlNotIn(List<String> values) {
            addCriterion("picUrl not in", values, "picurl");
            return (Criteria) this;
        }

        public Criteria andPicurlBetween(String value1, String value2) {
            addCriterion("picUrl between", value1, value2, "picurl");
            return (Criteria) this;
        }

        public Criteria andPicurlNotBetween(String value1, String value2) {
            addCriterion("picUrl not between", value1, value2, "picurl");
            return (Criteria) this;
        }

        public Criteria andUseflagIsNull() {
            addCriterion("useFlag is null");
            return (Criteria) this;
        }

        public Criteria andUseflagIsNotNull() {
            addCriterion("useFlag is not null");
            return (Criteria) this;
        }

        public Criteria andUseflagEqualTo(Integer value) {
            addCriterion("useFlag =", value, "useflag");
            return (Criteria) this;
        }

        public Criteria andUseflagNotEqualTo(Integer value) {
            addCriterion("useFlag <>", value, "useflag");
            return (Criteria) this;
        }

        public Criteria andUseflagGreaterThan(Integer value) {
            addCriterion("useFlag >", value, "useflag");
            return (Criteria) this;
        }

        public Criteria andUseflagGreaterThanOrEqualTo(Integer value) {
            addCriterion("useFlag >=", value, "useflag");
            return (Criteria) this;
        }

        public Criteria andUseflagLessThan(Integer value) {
            addCriterion("useFlag <", value, "useflag");
            return (Criteria) this;
        }

        public Criteria andUseflagLessThanOrEqualTo(Integer value) {
            addCriterion("useFlag <=", value, "useflag");
            return (Criteria) this;
        }

        public Criteria andUseflagIn(List<Integer> values) {
            addCriterion("useFlag in", values, "useflag");
            return (Criteria) this;
        }

        public Criteria andUseflagNotIn(List<Integer> values) {
            addCriterion("useFlag not in", values, "useflag");
            return (Criteria) this;
        }

        public Criteria andUseflagBetween(Integer value1, Integer value2) {
            addCriterion("useFlag between", value1, value2, "useflag");
            return (Criteria) this;
        }

        public Criteria andUseflagNotBetween(Integer value1, Integer value2) {
            addCriterion("useFlag not between", value1, value2, "useflag");
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