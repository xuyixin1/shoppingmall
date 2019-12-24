package com.vicmob.shoppingmall.web.goodsAPI.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class MallSpecificationExample {
    protected String pk_name = "specId";

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MallSpecificationExample() {
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

        public Criteria andAttributeid1IsNull() {
            addCriterion("attributeId1 is null");
            return (Criteria) this;
        }

        public Criteria andAttributeid1IsNotNull() {
            addCriterion("attributeId1 is not null");
            return (Criteria) this;
        }

        public Criteria andAttributeid1EqualTo(Integer value) {
            addCriterion("attributeId1 =", value, "attributeid1");
            return (Criteria) this;
        }

        public Criteria andAttributeid1NotEqualTo(Integer value) {
            addCriterion("attributeId1 <>", value, "attributeid1");
            return (Criteria) this;
        }

        public Criteria andAttributeid1GreaterThan(Integer value) {
            addCriterion("attributeId1 >", value, "attributeid1");
            return (Criteria) this;
        }

        public Criteria andAttributeid1GreaterThanOrEqualTo(Integer value) {
            addCriterion("attributeId1 >=", value, "attributeid1");
            return (Criteria) this;
        }

        public Criteria andAttributeid1LessThan(Integer value) {
            addCriterion("attributeId1 <", value, "attributeid1");
            return (Criteria) this;
        }

        public Criteria andAttributeid1LessThanOrEqualTo(Integer value) {
            addCriterion("attributeId1 <=", value, "attributeid1");
            return (Criteria) this;
        }

        public Criteria andAttributeid1In(List<Integer> values) {
            addCriterion("attributeId1 in", values, "attributeid1");
            return (Criteria) this;
        }

        public Criteria andAttributeid1NotIn(List<Integer> values) {
            addCriterion("attributeId1 not in", values, "attributeid1");
            return (Criteria) this;
        }

        public Criteria andAttributeid1Between(Integer value1, Integer value2) {
            addCriterion("attributeId1 between", value1, value2, "attributeid1");
            return (Criteria) this;
        }

        public Criteria andAttributeid1NotBetween(Integer value1, Integer value2) {
            addCriterion("attributeId1 not between", value1, value2, "attributeid1");
            return (Criteria) this;
        }

        public Criteria andAttributeidname1IsNull() {
            addCriterion("attributeIdName1 is null");
            return (Criteria) this;
        }

        public Criteria andAttributeidname1IsNotNull() {
            addCriterion("attributeIdName1 is not null");
            return (Criteria) this;
        }

        public Criteria andAttributeidname1EqualTo(String value) {
            addCriterion("attributeIdName1 =", value, "attributeidname1");
            return (Criteria) this;
        }

        public Criteria andAttributeidname1NotEqualTo(String value) {
            addCriterion("attributeIdName1 <>", value, "attributeidname1");
            return (Criteria) this;
        }

        public Criteria andAttributeidname1GreaterThan(String value) {
            addCriterion("attributeIdName1 >", value, "attributeidname1");
            return (Criteria) this;
        }

        public Criteria andAttributeidname1GreaterThanOrEqualTo(String value) {
            addCriterion("attributeIdName1 >=", value, "attributeidname1");
            return (Criteria) this;
        }

        public Criteria andAttributeidname1LessThan(String value) {
            addCriterion("attributeIdName1 <", value, "attributeidname1");
            return (Criteria) this;
        }

        public Criteria andAttributeidname1LessThanOrEqualTo(String value) {
            addCriterion("attributeIdName1 <=", value, "attributeidname1");
            return (Criteria) this;
        }

        public Criteria andAttributeidname1Like(String value) {
            addCriterion("attributeIdName1 like", value, "attributeidname1");
            return (Criteria) this;
        }

        public Criteria andAttributeidname1NotLike(String value) {
            addCriterion("attributeIdName1 not like", value, "attributeidname1");
            return (Criteria) this;
        }

        public Criteria andAttributeidname1In(List<String> values) {
            addCriterion("attributeIdName1 in", values, "attributeidname1");
            return (Criteria) this;
        }

        public Criteria andAttributeidname1NotIn(List<String> values) {
            addCriterion("attributeIdName1 not in", values, "attributeidname1");
            return (Criteria) this;
        }

        public Criteria andAttributeidname1Between(String value1, String value2) {
            addCriterion("attributeIdName1 between", value1, value2, "attributeidname1");
            return (Criteria) this;
        }

        public Criteria andAttributeidname1NotBetween(String value1, String value2) {
            addCriterion("attributeIdName1 not between", value1, value2, "attributeidname1");
            return (Criteria) this;
        }

        public Criteria andAttributevaluename1IsNull() {
            addCriterion("attributeValueName1 is null");
            return (Criteria) this;
        }

        public Criteria andAttributevaluename1IsNotNull() {
            addCriterion("attributeValueName1 is not null");
            return (Criteria) this;
        }

        public Criteria andAttributevaluename1EqualTo(String value) {
            addCriterion("attributeValueName1 =", value, "attributevaluename1");
            return (Criteria) this;
        }

        public Criteria andAttributevaluename1NotEqualTo(String value) {
            addCriterion("attributeValueName1 <>", value, "attributevaluename1");
            return (Criteria) this;
        }

        public Criteria andAttributevaluename1GreaterThan(String value) {
            addCriterion("attributeValueName1 >", value, "attributevaluename1");
            return (Criteria) this;
        }

        public Criteria andAttributevaluename1GreaterThanOrEqualTo(String value) {
            addCriterion("attributeValueName1 >=", value, "attributevaluename1");
            return (Criteria) this;
        }

        public Criteria andAttributevaluename1LessThan(String value) {
            addCriterion("attributeValueName1 <", value, "attributevaluename1");
            return (Criteria) this;
        }

        public Criteria andAttributevaluename1LessThanOrEqualTo(String value) {
            addCriterion("attributeValueName1 <=", value, "attributevaluename1");
            return (Criteria) this;
        }

        public Criteria andAttributevaluename1Like(String value) {
            addCriterion("attributeValueName1 like", value, "attributevaluename1");
            return (Criteria) this;
        }

        public Criteria andAttributevaluename1NotLike(String value) {
            addCriterion("attributeValueName1 not like", value, "attributevaluename1");
            return (Criteria) this;
        }

        public Criteria andAttributevaluename1In(List<String> values) {
            addCriterion("attributeValueName1 in", values, "attributevaluename1");
            return (Criteria) this;
        }

        public Criteria andAttributevaluename1NotIn(List<String> values) {
            addCriterion("attributeValueName1 not in", values, "attributevaluename1");
            return (Criteria) this;
        }

        public Criteria andAttributevaluename1Between(String value1, String value2) {
            addCriterion("attributeValueName1 between", value1, value2, "attributevaluename1");
            return (Criteria) this;
        }

        public Criteria andAttributevaluename1NotBetween(String value1, String value2) {
            addCriterion("attributeValueName1 not between", value1, value2, "attributevaluename1");
            return (Criteria) this;
        }

        public Criteria andAttributeid2IsNull() {
            addCriterion("attributeId2 is null");
            return (Criteria) this;
        }

        public Criteria andAttributeid2IsNotNull() {
            addCriterion("attributeId2 is not null");
            return (Criteria) this;
        }

        public Criteria andAttributeid2EqualTo(Integer value) {
            addCriterion("attributeId2 =", value, "attributeid2");
            return (Criteria) this;
        }

        public Criteria andAttributeid2NotEqualTo(Integer value) {
            addCriterion("attributeId2 <>", value, "attributeid2");
            return (Criteria) this;
        }

        public Criteria andAttributeid2GreaterThan(Integer value) {
            addCriterion("attributeId2 >", value, "attributeid2");
            return (Criteria) this;
        }

        public Criteria andAttributeid2GreaterThanOrEqualTo(Integer value) {
            addCriterion("attributeId2 >=", value, "attributeid2");
            return (Criteria) this;
        }

        public Criteria andAttributeid2LessThan(Integer value) {
            addCriterion("attributeId2 <", value, "attributeid2");
            return (Criteria) this;
        }

        public Criteria andAttributeid2LessThanOrEqualTo(Integer value) {
            addCriterion("attributeId2 <=", value, "attributeid2");
            return (Criteria) this;
        }

        public Criteria andAttributeid2In(List<Integer> values) {
            addCriterion("attributeId2 in", values, "attributeid2");
            return (Criteria) this;
        }

        public Criteria andAttributeid2NotIn(List<Integer> values) {
            addCriterion("attributeId2 not in", values, "attributeid2");
            return (Criteria) this;
        }

        public Criteria andAttributeid2Between(Integer value1, Integer value2) {
            addCriterion("attributeId2 between", value1, value2, "attributeid2");
            return (Criteria) this;
        }

        public Criteria andAttributeid2NotBetween(Integer value1, Integer value2) {
            addCriterion("attributeId2 not between", value1, value2, "attributeid2");
            return (Criteria) this;
        }

        public Criteria andAttributeidname2IsNull() {
            addCriterion("attributeIdName2 is null");
            return (Criteria) this;
        }

        public Criteria andAttributeidname2IsNotNull() {
            addCriterion("attributeIdName2 is not null");
            return (Criteria) this;
        }

        public Criteria andAttributeidname2EqualTo(String value) {
            addCriterion("attributeIdName2 =", value, "attributeidname2");
            return (Criteria) this;
        }

        public Criteria andAttributeidname2NotEqualTo(String value) {
            addCriterion("attributeIdName2 <>", value, "attributeidname2");
            return (Criteria) this;
        }

        public Criteria andAttributeidname2GreaterThan(String value) {
            addCriterion("attributeIdName2 >", value, "attributeidname2");
            return (Criteria) this;
        }

        public Criteria andAttributeidname2GreaterThanOrEqualTo(String value) {
            addCriterion("attributeIdName2 >=", value, "attributeidname2");
            return (Criteria) this;
        }

        public Criteria andAttributeidname2LessThan(String value) {
            addCriterion("attributeIdName2 <", value, "attributeidname2");
            return (Criteria) this;
        }

        public Criteria andAttributeidname2LessThanOrEqualTo(String value) {
            addCriterion("attributeIdName2 <=", value, "attributeidname2");
            return (Criteria) this;
        }

        public Criteria andAttributeidname2Like(String value) {
            addCriterion("attributeIdName2 like", value, "attributeidname2");
            return (Criteria) this;
        }

        public Criteria andAttributeidname2NotLike(String value) {
            addCriterion("attributeIdName2 not like", value, "attributeidname2");
            return (Criteria) this;
        }

        public Criteria andAttributeidname2In(List<String> values) {
            addCriterion("attributeIdName2 in", values, "attributeidname2");
            return (Criteria) this;
        }

        public Criteria andAttributeidname2NotIn(List<String> values) {
            addCriterion("attributeIdName2 not in", values, "attributeidname2");
            return (Criteria) this;
        }

        public Criteria andAttributeidname2Between(String value1, String value2) {
            addCriterion("attributeIdName2 between", value1, value2, "attributeidname2");
            return (Criteria) this;
        }

        public Criteria andAttributeidname2NotBetween(String value1, String value2) {
            addCriterion("attributeIdName2 not between", value1, value2, "attributeidname2");
            return (Criteria) this;
        }

        public Criteria andAttributevaluename2IsNull() {
            addCriterion("attributeValueName2 is null");
            return (Criteria) this;
        }

        public Criteria andAttributevaluename2IsNotNull() {
            addCriterion("attributeValueName2 is not null");
            return (Criteria) this;
        }

        public Criteria andAttributevaluename2EqualTo(String value) {
            addCriterion("attributeValueName2 =", value, "attributevaluename2");
            return (Criteria) this;
        }

        public Criteria andAttributevaluename2NotEqualTo(String value) {
            addCriterion("attributeValueName2 <>", value, "attributevaluename2");
            return (Criteria) this;
        }

        public Criteria andAttributevaluename2GreaterThan(String value) {
            addCriterion("attributeValueName2 >", value, "attributevaluename2");
            return (Criteria) this;
        }

        public Criteria andAttributevaluename2GreaterThanOrEqualTo(String value) {
            addCriterion("attributeValueName2 >=", value, "attributevaluename2");
            return (Criteria) this;
        }

        public Criteria andAttributevaluename2LessThan(String value) {
            addCriterion("attributeValueName2 <", value, "attributevaluename2");
            return (Criteria) this;
        }

        public Criteria andAttributevaluename2LessThanOrEqualTo(String value) {
            addCriterion("attributeValueName2 <=", value, "attributevaluename2");
            return (Criteria) this;
        }

        public Criteria andAttributevaluename2Like(String value) {
            addCriterion("attributeValueName2 like", value, "attributevaluename2");
            return (Criteria) this;
        }

        public Criteria andAttributevaluename2NotLike(String value) {
            addCriterion("attributeValueName2 not like", value, "attributevaluename2");
            return (Criteria) this;
        }

        public Criteria andAttributevaluename2In(List<String> values) {
            addCriterion("attributeValueName2 in", values, "attributevaluename2");
            return (Criteria) this;
        }

        public Criteria andAttributevaluename2NotIn(List<String> values) {
            addCriterion("attributeValueName2 not in", values, "attributevaluename2");
            return (Criteria) this;
        }

        public Criteria andAttributevaluename2Between(String value1, String value2) {
            addCriterion("attributeValueName2 between", value1, value2, "attributevaluename2");
            return (Criteria) this;
        }

        public Criteria andAttributevaluename2NotBetween(String value1, String value2) {
            addCriterion("attributeValueName2 not between", value1, value2, "attributevaluename2");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(BigDecimal value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(BigDecimal value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(BigDecimal value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(BigDecimal value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<BigDecimal> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<BigDecimal> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andStockIsNull() {
            addCriterion("stock is null");
            return (Criteria) this;
        }

        public Criteria andStockIsNotNull() {
            addCriterion("stock is not null");
            return (Criteria) this;
        }

        public Criteria andStockEqualTo(Integer value) {
            addCriterion("stock =", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockNotEqualTo(Integer value) {
            addCriterion("stock <>", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockGreaterThan(Integer value) {
            addCriterion("stock >", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockGreaterThanOrEqualTo(Integer value) {
            addCriterion("stock >=", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockLessThan(Integer value) {
            addCriterion("stock <", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockLessThanOrEqualTo(Integer value) {
            addCriterion("stock <=", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockIn(List<Integer> values) {
            addCriterion("stock in", values, "stock");
            return (Criteria) this;
        }

        public Criteria andStockNotIn(List<Integer> values) {
            addCriterion("stock not in", values, "stock");
            return (Criteria) this;
        }

        public Criteria andStockBetween(Integer value1, Integer value2) {
            addCriterion("stock between", value1, value2, "stock");
            return (Criteria) this;
        }

        public Criteria andStockNotBetween(Integer value1, Integer value2) {
            addCriterion("stock not between", value1, value2, "stock");
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