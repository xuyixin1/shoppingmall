package com.vicmob.shoppingmall.web.goodsAPI.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MallEvaluateExample {
    protected String pk_name = "evaluateId";

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MallEvaluateExample() {
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

        public Criteria andEvaluateidIsNull() {
            addCriterion("evaluateId is null");
            return (Criteria) this;
        }

        public Criteria andEvaluateidIsNotNull() {
            addCriterion("evaluateId is not null");
            return (Criteria) this;
        }

        public Criteria andEvaluateidEqualTo(Integer value) {
            addCriterion("evaluateId =", value, "evaluateid");
            return (Criteria) this;
        }

        public Criteria andEvaluateidNotEqualTo(Integer value) {
            addCriterion("evaluateId <>", value, "evaluateid");
            return (Criteria) this;
        }

        public Criteria andEvaluateidGreaterThan(Integer value) {
            addCriterion("evaluateId >", value, "evaluateid");
            return (Criteria) this;
        }

        public Criteria andEvaluateidGreaterThanOrEqualTo(Integer value) {
            addCriterion("evaluateId >=", value, "evaluateid");
            return (Criteria) this;
        }

        public Criteria andEvaluateidLessThan(Integer value) {
            addCriterion("evaluateId <", value, "evaluateid");
            return (Criteria) this;
        }

        public Criteria andEvaluateidLessThanOrEqualTo(Integer value) {
            addCriterion("evaluateId <=", value, "evaluateid");
            return (Criteria) this;
        }

        public Criteria andEvaluateidIn(List<Integer> values) {
            addCriterion("evaluateId in", values, "evaluateid");
            return (Criteria) this;
        }

        public Criteria andEvaluateidNotIn(List<Integer> values) {
            addCriterion("evaluateId not in", values, "evaluateid");
            return (Criteria) this;
        }

        public Criteria andEvaluateidBetween(Integer value1, Integer value2) {
            addCriterion("evaluateId between", value1, value2, "evaluateid");
            return (Criteria) this;
        }

        public Criteria andEvaluateidNotBetween(Integer value1, Integer value2) {
            addCriterion("evaluateId not between", value1, value2, "evaluateid");
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

        public Criteria andIsanonymousIsNull() {
            addCriterion("isAnonymous is null");
            return (Criteria) this;
        }

        public Criteria andIsanonymousIsNotNull() {
            addCriterion("isAnonymous is not null");
            return (Criteria) this;
        }

        public Criteria andIsanonymousEqualTo(Integer value) {
            addCriterion("isAnonymous =", value, "isanonymous");
            return (Criteria) this;
        }

        public Criteria andIsanonymousNotEqualTo(Integer value) {
            addCriterion("isAnonymous <>", value, "isanonymous");
            return (Criteria) this;
        }

        public Criteria andIsanonymousGreaterThan(Integer value) {
            addCriterion("isAnonymous >", value, "isanonymous");
            return (Criteria) this;
        }

        public Criteria andIsanonymousGreaterThanOrEqualTo(Integer value) {
            addCriterion("isAnonymous >=", value, "isanonymous");
            return (Criteria) this;
        }

        public Criteria andIsanonymousLessThan(Integer value) {
            addCriterion("isAnonymous <", value, "isanonymous");
            return (Criteria) this;
        }

        public Criteria andIsanonymousLessThanOrEqualTo(Integer value) {
            addCriterion("isAnonymous <=", value, "isanonymous");
            return (Criteria) this;
        }

        public Criteria andIsanonymousIn(List<Integer> values) {
            addCriterion("isAnonymous in", values, "isanonymous");
            return (Criteria) this;
        }

        public Criteria andIsanonymousNotIn(List<Integer> values) {
            addCriterion("isAnonymous not in", values, "isanonymous");
            return (Criteria) this;
        }

        public Criteria andIsanonymousBetween(Integer value1, Integer value2) {
            addCriterion("isAnonymous between", value1, value2, "isanonymous");
            return (Criteria) this;
        }

        public Criteria andIsanonymousNotBetween(Integer value1, Integer value2) {
            addCriterion("isAnonymous not between", value1, value2, "isanonymous");
            return (Criteria) this;
        }

        public Criteria andEvallevelIsNull() {
            addCriterion("evalLevel is null");
            return (Criteria) this;
        }

        public Criteria andEvallevelIsNotNull() {
            addCriterion("evalLevel is not null");
            return (Criteria) this;
        }

        public Criteria andEvallevelEqualTo(Integer value) {
            addCriterion("evalLevel =", value, "evallevel");
            return (Criteria) this;
        }

        public Criteria andEvallevelNotEqualTo(Integer value) {
            addCriterion("evalLevel <>", value, "evallevel");
            return (Criteria) this;
        }

        public Criteria andEvallevelGreaterThan(Integer value) {
            addCriterion("evalLevel >", value, "evallevel");
            return (Criteria) this;
        }

        public Criteria andEvallevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("evalLevel >=", value, "evallevel");
            return (Criteria) this;
        }

        public Criteria andEvallevelLessThan(Integer value) {
            addCriterion("evalLevel <", value, "evallevel");
            return (Criteria) this;
        }

        public Criteria andEvallevelLessThanOrEqualTo(Integer value) {
            addCriterion("evalLevel <=", value, "evallevel");
            return (Criteria) this;
        }

        public Criteria andEvallevelIn(List<Integer> values) {
            addCriterion("evalLevel in", values, "evallevel");
            return (Criteria) this;
        }

        public Criteria andEvallevelNotIn(List<Integer> values) {
            addCriterion("evalLevel not in", values, "evallevel");
            return (Criteria) this;
        }

        public Criteria andEvallevelBetween(Integer value1, Integer value2) {
            addCriterion("evalLevel between", value1, value2, "evallevel");
            return (Criteria) this;
        }

        public Criteria andEvallevelNotBetween(Integer value1, Integer value2) {
            addCriterion("evalLevel not between", value1, value2, "evallevel");
            return (Criteria) this;
        }

        public Criteria andEvalcontentIsNull() {
            addCriterion("evalContent is null");
            return (Criteria) this;
        }

        public Criteria andEvalcontentIsNotNull() {
            addCriterion("evalContent is not null");
            return (Criteria) this;
        }

        public Criteria andEvalcontentEqualTo(String value) {
            addCriterion("evalContent =", value, "evalcontent");
            return (Criteria) this;
        }

        public Criteria andEvalcontentNotEqualTo(String value) {
            addCriterion("evalContent <>", value, "evalcontent");
            return (Criteria) this;
        }

        public Criteria andEvalcontentGreaterThan(String value) {
            addCriterion("evalContent >", value, "evalcontent");
            return (Criteria) this;
        }

        public Criteria andEvalcontentGreaterThanOrEqualTo(String value) {
            addCriterion("evalContent >=", value, "evalcontent");
            return (Criteria) this;
        }

        public Criteria andEvalcontentLessThan(String value) {
            addCriterion("evalContent <", value, "evalcontent");
            return (Criteria) this;
        }

        public Criteria andEvalcontentLessThanOrEqualTo(String value) {
            addCriterion("evalContent <=", value, "evalcontent");
            return (Criteria) this;
        }

        public Criteria andEvalcontentLike(String value) {
            addCriterion("evalContent like", value, "evalcontent");
            return (Criteria) this;
        }

        public Criteria andEvalcontentNotLike(String value) {
            addCriterion("evalContent not like", value, "evalcontent");
            return (Criteria) this;
        }

        public Criteria andEvalcontentIn(List<String> values) {
            addCriterion("evalContent in", values, "evalcontent");
            return (Criteria) this;
        }

        public Criteria andEvalcontentNotIn(List<String> values) {
            addCriterion("evalContent not in", values, "evalcontent");
            return (Criteria) this;
        }

        public Criteria andEvalcontentBetween(String value1, String value2) {
            addCriterion("evalContent between", value1, value2, "evalcontent");
            return (Criteria) this;
        }

        public Criteria andEvalcontentNotBetween(String value1, String value2) {
            addCriterion("evalContent not between", value1, value2, "evalcontent");
            return (Criteria) this;
        }

        public Criteria andEvalpicIsNull() {
            addCriterion("evalPic is null");
            return (Criteria) this;
        }

        public Criteria andEvalpicIsNotNull() {
            addCriterion("evalPic is not null");
            return (Criteria) this;
        }

        public Criteria andEvalpicEqualTo(String value) {
            addCriterion("evalPic =", value, "evalpic");
            return (Criteria) this;
        }

        public Criteria andEvalpicNotEqualTo(String value) {
            addCriterion("evalPic <>", value, "evalpic");
            return (Criteria) this;
        }

        public Criteria andEvalpicGreaterThan(String value) {
            addCriterion("evalPic >", value, "evalpic");
            return (Criteria) this;
        }

        public Criteria andEvalpicGreaterThanOrEqualTo(String value) {
            addCriterion("evalPic >=", value, "evalpic");
            return (Criteria) this;
        }

        public Criteria andEvalpicLessThan(String value) {
            addCriterion("evalPic <", value, "evalpic");
            return (Criteria) this;
        }

        public Criteria andEvalpicLessThanOrEqualTo(String value) {
            addCriterion("evalPic <=", value, "evalpic");
            return (Criteria) this;
        }

        public Criteria andEvalpicLike(String value) {
            addCriterion("evalPic like", value, "evalpic");
            return (Criteria) this;
        }

        public Criteria andEvalpicNotLike(String value) {
            addCriterion("evalPic not like", value, "evalpic");
            return (Criteria) this;
        }

        public Criteria andEvalpicIn(List<String> values) {
            addCriterion("evalPic in", values, "evalpic");
            return (Criteria) this;
        }

        public Criteria andEvalpicNotIn(List<String> values) {
            addCriterion("evalPic not in", values, "evalpic");
            return (Criteria) this;
        }

        public Criteria andEvalpicBetween(String value1, String value2) {
            addCriterion("evalPic between", value1, value2, "evalpic");
            return (Criteria) this;
        }

        public Criteria andEvalpicNotBetween(String value1, String value2) {
            addCriterion("evalPic not between", value1, value2, "evalpic");
            return (Criteria) this;
        }

        public Criteria andEvaltimeIsNull() {
            addCriterion("evalTime is null");
            return (Criteria) this;
        }

        public Criteria andEvaltimeIsNotNull() {
            addCriterion("evalTime is not null");
            return (Criteria) this;
        }

        public Criteria andEvaltimeEqualTo(Date value) {
            addCriterion("evalTime =", value, "evaltime");
            return (Criteria) this;
        }

        public Criteria andEvaltimeNotEqualTo(Date value) {
            addCriterion("evalTime <>", value, "evaltime");
            return (Criteria) this;
        }

        public Criteria andEvaltimeGreaterThan(Date value) {
            addCriterion("evalTime >", value, "evaltime");
            return (Criteria) this;
        }

        public Criteria andEvaltimeGreaterThanOrEqualTo(Date value) {
            addCriterion("evalTime >=", value, "evaltime");
            return (Criteria) this;
        }

        public Criteria andEvaltimeLessThan(Date value) {
            addCriterion("evalTime <", value, "evaltime");
            return (Criteria) this;
        }

        public Criteria andEvaltimeLessThanOrEqualTo(Date value) {
            addCriterion("evalTime <=", value, "evaltime");
            return (Criteria) this;
        }

        public Criteria andEvaltimeIn(List<Date> values) {
            addCriterion("evalTime in", values, "evaltime");
            return (Criteria) this;
        }

        public Criteria andEvaltimeNotIn(List<Date> values) {
            addCriterion("evalTime not in", values, "evaltime");
            return (Criteria) this;
        }

        public Criteria andEvaltimeBetween(Date value1, Date value2) {
            addCriterion("evalTime between", value1, value2, "evaltime");
            return (Criteria) this;
        }

        public Criteria andEvaltimeNotBetween(Date value1, Date value2) {
            addCriterion("evalTime not between", value1, value2, "evaltime");
            return (Criteria) this;
        }

        public Criteria andStorereplyIsNull() {
            addCriterion("storeReply is null");
            return (Criteria) this;
        }

        public Criteria andStorereplyIsNotNull() {
            addCriterion("storeReply is not null");
            return (Criteria) this;
        }

        public Criteria andStorereplyEqualTo(String value) {
            addCriterion("storeReply =", value, "storereply");
            return (Criteria) this;
        }

        public Criteria andStorereplyNotEqualTo(String value) {
            addCriterion("storeReply <>", value, "storereply");
            return (Criteria) this;
        }

        public Criteria andStorereplyGreaterThan(String value) {
            addCriterion("storeReply >", value, "storereply");
            return (Criteria) this;
        }

        public Criteria andStorereplyGreaterThanOrEqualTo(String value) {
            addCriterion("storeReply >=", value, "storereply");
            return (Criteria) this;
        }

        public Criteria andStorereplyLessThan(String value) {
            addCriterion("storeReply <", value, "storereply");
            return (Criteria) this;
        }

        public Criteria andStorereplyLessThanOrEqualTo(String value) {
            addCriterion("storeReply <=", value, "storereply");
            return (Criteria) this;
        }

        public Criteria andStorereplyLike(String value) {
            addCriterion("storeReply like", value, "storereply");
            return (Criteria) this;
        }

        public Criteria andStorereplyNotLike(String value) {
            addCriterion("storeReply not like", value, "storereply");
            return (Criteria) this;
        }

        public Criteria andStorereplyIn(List<String> values) {
            addCriterion("storeReply in", values, "storereply");
            return (Criteria) this;
        }

        public Criteria andStorereplyNotIn(List<String> values) {
            addCriterion("storeReply not in", values, "storereply");
            return (Criteria) this;
        }

        public Criteria andStorereplyBetween(String value1, String value2) {
            addCriterion("storeReply between", value1, value2, "storereply");
            return (Criteria) this;
        }

        public Criteria andStorereplyNotBetween(String value1, String value2) {
            addCriterion("storeReply not between", value1, value2, "storereply");
            return (Criteria) this;
        }

        public Criteria andReplytimeIsNull() {
            addCriterion("replyTime is null");
            return (Criteria) this;
        }

        public Criteria andReplytimeIsNotNull() {
            addCriterion("replyTime is not null");
            return (Criteria) this;
        }

        public Criteria andReplytimeEqualTo(Date value) {
            addCriterion("replyTime =", value, "replytime");
            return (Criteria) this;
        }

        public Criteria andReplytimeNotEqualTo(Date value) {
            addCriterion("replyTime <>", value, "replytime");
            return (Criteria) this;
        }

        public Criteria andReplytimeGreaterThan(Date value) {
            addCriterion("replyTime >", value, "replytime");
            return (Criteria) this;
        }

        public Criteria andReplytimeGreaterThanOrEqualTo(Date value) {
            addCriterion("replyTime >=", value, "replytime");
            return (Criteria) this;
        }

        public Criteria andReplytimeLessThan(Date value) {
            addCriterion("replyTime <", value, "replytime");
            return (Criteria) this;
        }

        public Criteria andReplytimeLessThanOrEqualTo(Date value) {
            addCriterion("replyTime <=", value, "replytime");
            return (Criteria) this;
        }

        public Criteria andReplytimeIn(List<Date> values) {
            addCriterion("replyTime in", values, "replytime");
            return (Criteria) this;
        }

        public Criteria andReplytimeNotIn(List<Date> values) {
            addCriterion("replyTime not in", values, "replytime");
            return (Criteria) this;
        }

        public Criteria andReplytimeBetween(Date value1, Date value2) {
            addCriterion("replyTime between", value1, value2, "replytime");
            return (Criteria) this;
        }

        public Criteria andReplytimeNotBetween(Date value1, Date value2) {
            addCriterion("replyTime not between", value1, value2, "replytime");
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