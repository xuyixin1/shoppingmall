package com.vicmob.shoppingmall.web.goodsAPI.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class MallGoodsExample {
    protected String pk_name = "goodsId";

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MallGoodsExample() {
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

        public Criteria andDetailpicurlIsNull() {
            addCriterion("detailPicUrl is null");
            return (Criteria) this;
        }

        public Criteria andDetailpicurlIsNotNull() {
            addCriterion("detailPicUrl is not null");
            return (Criteria) this;
        }

        public Criteria andDetailpicurlEqualTo(String value) {
            addCriterion("detailPicUrl =", value, "detailpicurl");
            return (Criteria) this;
        }

        public Criteria andDetailpicurlNotEqualTo(String value) {
            addCriterion("detailPicUrl <>", value, "detailpicurl");
            return (Criteria) this;
        }

        public Criteria andDetailpicurlGreaterThan(String value) {
            addCriterion("detailPicUrl >", value, "detailpicurl");
            return (Criteria) this;
        }

        public Criteria andDetailpicurlGreaterThanOrEqualTo(String value) {
            addCriterion("detailPicUrl >=", value, "detailpicurl");
            return (Criteria) this;
        }

        public Criteria andDetailpicurlLessThan(String value) {
            addCriterion("detailPicUrl <", value, "detailpicurl");
            return (Criteria) this;
        }

        public Criteria andDetailpicurlLessThanOrEqualTo(String value) {
            addCriterion("detailPicUrl <=", value, "detailpicurl");
            return (Criteria) this;
        }

        public Criteria andDetailpicurlLike(String value) {
            addCriterion("detailPicUrl like", value, "detailpicurl");
            return (Criteria) this;
        }

        public Criteria andDetailpicurlNotLike(String value) {
            addCriterion("detailPicUrl not like", value, "detailpicurl");
            return (Criteria) this;
        }

        public Criteria andDetailpicurlIn(List<String> values) {
            addCriterion("detailPicUrl in", values, "detailpicurl");
            return (Criteria) this;
        }

        public Criteria andDetailpicurlNotIn(List<String> values) {
            addCriterion("detailPicUrl not in", values, "detailpicurl");
            return (Criteria) this;
        }

        public Criteria andDetailpicurlBetween(String value1, String value2) {
            addCriterion("detailPicUrl between", value1, value2, "detailpicurl");
            return (Criteria) this;
        }

        public Criteria andDetailpicurlNotBetween(String value1, String value2) {
            addCriterion("detailPicUrl not between", value1, value2, "detailpicurl");
            return (Criteria) this;
        }

        public Criteria andSailedIsNull() {
            addCriterion("sailed is null");
            return (Criteria) this;
        }

        public Criteria andSailedIsNotNull() {
            addCriterion("sailed is not null");
            return (Criteria) this;
        }

        public Criteria andSailedEqualTo(Integer value) {
            addCriterion("sailed =", value, "sailed");
            return (Criteria) this;
        }

        public Criteria andSailedNotEqualTo(Integer value) {
            addCriterion("sailed <>", value, "sailed");
            return (Criteria) this;
        }

        public Criteria andSailedGreaterThan(Integer value) {
            addCriterion("sailed >", value, "sailed");
            return (Criteria) this;
        }

        public Criteria andSailedGreaterThanOrEqualTo(Integer value) {
            addCriterion("sailed >=", value, "sailed");
            return (Criteria) this;
        }

        public Criteria andSailedLessThan(Integer value) {
            addCriterion("sailed <", value, "sailed");
            return (Criteria) this;
        }

        public Criteria andSailedLessThanOrEqualTo(Integer value) {
            addCriterion("sailed <=", value, "sailed");
            return (Criteria) this;
        }

        public Criteria andSailedIn(List<Integer> values) {
            addCriterion("sailed in", values, "sailed");
            return (Criteria) this;
        }

        public Criteria andSailedNotIn(List<Integer> values) {
            addCriterion("sailed not in", values, "sailed");
            return (Criteria) this;
        }

        public Criteria andSailedBetween(Integer value1, Integer value2) {
            addCriterion("sailed between", value1, value2, "sailed");
            return (Criteria) this;
        }

        public Criteria andSailedNotBetween(Integer value1, Integer value2) {
            addCriterion("sailed not between", value1, value2, "sailed");
            return (Criteria) this;
        }

        public Criteria andLabelIsNull() {
            addCriterion("`label` is null");
            return (Criteria) this;
        }

        public Criteria andLabelIsNotNull() {
            addCriterion("`label` is not null");
            return (Criteria) this;
        }

        public Criteria andLabelEqualTo(String value) {
            addCriterion("`label` =", value, "label");
            return (Criteria) this;
        }

        public Criteria andLabelNotEqualTo(String value) {
            addCriterion("`label` <>", value, "label");
            return (Criteria) this;
        }

        public Criteria andLabelGreaterThan(String value) {
            addCriterion("`label` >", value, "label");
            return (Criteria) this;
        }

        public Criteria andLabelGreaterThanOrEqualTo(String value) {
            addCriterion("`label` >=", value, "label");
            return (Criteria) this;
        }

        public Criteria andLabelLessThan(String value) {
            addCriterion("`label` <", value, "label");
            return (Criteria) this;
        }

        public Criteria andLabelLessThanOrEqualTo(String value) {
            addCriterion("`label` <=", value, "label");
            return (Criteria) this;
        }

        public Criteria andLabelLike(String value) {
            addCriterion("`label` like", value, "label");
            return (Criteria) this;
        }

        public Criteria andLabelNotLike(String value) {
            addCriterion("`label` not like", value, "label");
            return (Criteria) this;
        }

        public Criteria andLabelIn(List<String> values) {
            addCriterion("`label` in", values, "label");
            return (Criteria) this;
        }

        public Criteria andLabelNotIn(List<String> values) {
            addCriterion("`label` not in", values, "label");
            return (Criteria) this;
        }

        public Criteria andLabelBetween(String value1, String value2) {
            addCriterion("`label` between", value1, value2, "label");
            return (Criteria) this;
        }

        public Criteria andLabelNotBetween(String value1, String value2) {
            addCriterion("`label` not between", value1, value2, "label");
            return (Criteria) this;
        }

        public Criteria andSaleflagIsNull() {
            addCriterion("saleFlag is null");
            return (Criteria) this;
        }

        public Criteria andSaleflagIsNotNull() {
            addCriterion("saleFlag is not null");
            return (Criteria) this;
        }

        public Criteria andSaleflagEqualTo(Integer value) {
            addCriterion("saleFlag =", value, "saleflag");
            return (Criteria) this;
        }

        public Criteria andSaleflagNotEqualTo(Integer value) {
            addCriterion("saleFlag <>", value, "saleflag");
            return (Criteria) this;
        }

        public Criteria andSaleflagGreaterThan(Integer value) {
            addCriterion("saleFlag >", value, "saleflag");
            return (Criteria) this;
        }

        public Criteria andSaleflagGreaterThanOrEqualTo(Integer value) {
            addCriterion("saleFlag >=", value, "saleflag");
            return (Criteria) this;
        }

        public Criteria andSaleflagLessThan(Integer value) {
            addCriterion("saleFlag <", value, "saleflag");
            return (Criteria) this;
        }

        public Criteria andSaleflagLessThanOrEqualTo(Integer value) {
            addCriterion("saleFlag <=", value, "saleflag");
            return (Criteria) this;
        }

        public Criteria andSaleflagIn(List<Integer> values) {
            addCriterion("saleFlag in", values, "saleflag");
            return (Criteria) this;
        }

        public Criteria andSaleflagNotIn(List<Integer> values) {
            addCriterion("saleFlag not in", values, "saleflag");
            return (Criteria) this;
        }

        public Criteria andSaleflagBetween(Integer value1, Integer value2) {
            addCriterion("saleFlag between", value1, value2, "saleflag");
            return (Criteria) this;
        }

        public Criteria andSaleflagNotBetween(Integer value1, Integer value2) {
            addCriterion("saleFlag not between", value1, value2, "saleflag");
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

        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
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

        public Criteria andShowpriceIsNull() {
            addCriterion("showPrice is null");
            return (Criteria) this;
        }

        public Criteria andShowpriceIsNotNull() {
            addCriterion("showPrice is not null");
            return (Criteria) this;
        }

        public Criteria andShowpriceEqualTo(BigDecimal value) {
            addCriterion("showPrice =", value, "showprice");
            return (Criteria) this;
        }

        public Criteria andShowpriceNotEqualTo(BigDecimal value) {
            addCriterion("showPrice <>", value, "showprice");
            return (Criteria) this;
        }

        public Criteria andShowpriceGreaterThan(BigDecimal value) {
            addCriterion("showPrice >", value, "showprice");
            return (Criteria) this;
        }

        public Criteria andShowpriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("showPrice >=", value, "showprice");
            return (Criteria) this;
        }

        public Criteria andShowpriceLessThan(BigDecimal value) {
            addCriterion("showPrice <", value, "showprice");
            return (Criteria) this;
        }

        public Criteria andShowpriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("showPrice <=", value, "showprice");
            return (Criteria) this;
        }

        public Criteria andShowpriceIn(List<BigDecimal> values) {
            addCriterion("showPrice in", values, "showprice");
            return (Criteria) this;
        }

        public Criteria andShowpriceNotIn(List<BigDecimal> values) {
            addCriterion("showPrice not in", values, "showprice");
            return (Criteria) this;
        }

        public Criteria andShowpriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("showPrice between", value1, value2, "showprice");
            return (Criteria) this;
        }

        public Criteria andShowpriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("showPrice not between", value1, value2, "showprice");
            return (Criteria) this;
        }

        public Criteria andShowflagIsNull() {
            addCriterion("showFlag is null");
            return (Criteria) this;
        }

        public Criteria andShowflagIsNotNull() {
            addCriterion("showFlag is not null");
            return (Criteria) this;
        }

        public Criteria andShowflagEqualTo(Integer value) {
            addCriterion("showFlag =", value, "showflag");
            return (Criteria) this;
        }

        public Criteria andShowflagNotEqualTo(Integer value) {
            addCriterion("showFlag <>", value, "showflag");
            return (Criteria) this;
        }

        public Criteria andShowflagGreaterThan(Integer value) {
            addCriterion("showFlag >", value, "showflag");
            return (Criteria) this;
        }

        public Criteria andShowflagGreaterThanOrEqualTo(Integer value) {
            addCriterion("showFlag >=", value, "showflag");
            return (Criteria) this;
        }

        public Criteria andShowflagLessThan(Integer value) {
            addCriterion("showFlag <", value, "showflag");
            return (Criteria) this;
        }

        public Criteria andShowflagLessThanOrEqualTo(Integer value) {
            addCriterion("showFlag <=", value, "showflag");
            return (Criteria) this;
        }

        public Criteria andShowflagIn(List<Integer> values) {
            addCriterion("showFlag in", values, "showflag");
            return (Criteria) this;
        }

        public Criteria andShowflagNotIn(List<Integer> values) {
            addCriterion("showFlag not in", values, "showflag");
            return (Criteria) this;
        }

        public Criteria andShowflagBetween(Integer value1, Integer value2) {
            addCriterion("showFlag between", value1, value2, "showflag");
            return (Criteria) this;
        }

        public Criteria andShowflagNotBetween(Integer value1, Integer value2) {
            addCriterion("showFlag not between", value1, value2, "showflag");
            return (Criteria) this;
        }

        public Criteria andDistributionflagIsNull() {
            addCriterion("distributionFlag is null");
            return (Criteria) this;
        }

        public Criteria andDistributionflagIsNotNull() {
            addCriterion("distributionFlag is not null");
            return (Criteria) this;
        }

        public Criteria andDistributionflagEqualTo(Integer value) {
            addCriterion("distributionFlag =", value, "distributionflag");
            return (Criteria) this;
        }

        public Criteria andDistributionflagNotEqualTo(Integer value) {
            addCriterion("distributionFlag <>", value, "distributionflag");
            return (Criteria) this;
        }

        public Criteria andDistributionflagGreaterThan(Integer value) {
            addCriterion("distributionFlag >", value, "distributionflag");
            return (Criteria) this;
        }

        public Criteria andDistributionflagGreaterThanOrEqualTo(Integer value) {
            addCriterion("distributionFlag >=", value, "distributionflag");
            return (Criteria) this;
        }

        public Criteria andDistributionflagLessThan(Integer value) {
            addCriterion("distributionFlag <", value, "distributionflag");
            return (Criteria) this;
        }

        public Criteria andDistributionflagLessThanOrEqualTo(Integer value) {
            addCriterion("distributionFlag <=", value, "distributionflag");
            return (Criteria) this;
        }

        public Criteria andDistributionflagIn(List<Integer> values) {
            addCriterion("distributionFlag in", values, "distributionflag");
            return (Criteria) this;
        }

        public Criteria andDistributionflagNotIn(List<Integer> values) {
            addCriterion("distributionFlag not in", values, "distributionflag");
            return (Criteria) this;
        }

        public Criteria andDistributionflagBetween(Integer value1, Integer value2) {
            addCriterion("distributionFlag between", value1, value2, "distributionflag");
            return (Criteria) this;
        }

        public Criteria andDistributionflagNotBetween(Integer value1, Integer value2) {
            addCriterion("distributionFlag not between", value1, value2, "distributionflag");
            return (Criteria) this;
        }

        public Criteria andCollagesailedIsNull() {
            addCriterion("collageSailed is null");
            return (Criteria) this;
        }

        public Criteria andCollagesailedIsNotNull() {
            addCriterion("collageSailed is not null");
            return (Criteria) this;
        }

        public Criteria andCollagesailedEqualTo(Integer value) {
            addCriterion("collageSailed =", value, "collagesailed");
            return (Criteria) this;
        }

        public Criteria andCollagesailedNotEqualTo(Integer value) {
            addCriterion("collageSailed <>", value, "collagesailed");
            return (Criteria) this;
        }

        public Criteria andCollagesailedGreaterThan(Integer value) {
            addCriterion("collageSailed >", value, "collagesailed");
            return (Criteria) this;
        }

        public Criteria andCollagesailedGreaterThanOrEqualTo(Integer value) {
            addCriterion("collageSailed >=", value, "collagesailed");
            return (Criteria) this;
        }

        public Criteria andCollagesailedLessThan(Integer value) {
            addCriterion("collageSailed <", value, "collagesailed");
            return (Criteria) this;
        }

        public Criteria andCollagesailedLessThanOrEqualTo(Integer value) {
            addCriterion("collageSailed <=", value, "collagesailed");
            return (Criteria) this;
        }

        public Criteria andCollagesailedIn(List<Integer> values) {
            addCriterion("collageSailed in", values, "collagesailed");
            return (Criteria) this;
        }

        public Criteria andCollagesailedNotIn(List<Integer> values) {
            addCriterion("collageSailed not in", values, "collagesailed");
            return (Criteria) this;
        }

        public Criteria andCollagesailedBetween(Integer value1, Integer value2) {
            addCriterion("collageSailed between", value1, value2, "collagesailed");
            return (Criteria) this;
        }

        public Criteria andCollagesailedNotBetween(Integer value1, Integer value2) {
            addCriterion("collageSailed not between", value1, value2, "collagesailed");
            return (Criteria) this;
        }

        public Criteria andCollageflagIsNull() {
            addCriterion("collageFlag is null");
            return (Criteria) this;
        }

        public Criteria andCollageflagIsNotNull() {
            addCriterion("collageFlag is not null");
            return (Criteria) this;
        }

        public Criteria andCollageflagEqualTo(Integer value) {
            addCriterion("collageFlag =", value, "collageflag");
            return (Criteria) this;
        }

        public Criteria andCollageflagNotEqualTo(Integer value) {
            addCriterion("collageFlag <>", value, "collageflag");
            return (Criteria) this;
        }

        public Criteria andCollageflagGreaterThan(Integer value) {
            addCriterion("collageFlag >", value, "collageflag");
            return (Criteria) this;
        }

        public Criteria andCollageflagGreaterThanOrEqualTo(Integer value) {
            addCriterion("collageFlag >=", value, "collageflag");
            return (Criteria) this;
        }

        public Criteria andCollageflagLessThan(Integer value) {
            addCriterion("collageFlag <", value, "collageflag");
            return (Criteria) this;
        }

        public Criteria andCollageflagLessThanOrEqualTo(Integer value) {
            addCriterion("collageFlag <=", value, "collageflag");
            return (Criteria) this;
        }

        public Criteria andCollageflagIn(List<Integer> values) {
            addCriterion("collageFlag in", values, "collageflag");
            return (Criteria) this;
        }

        public Criteria andCollageflagNotIn(List<Integer> values) {
            addCriterion("collageFlag not in", values, "collageflag");
            return (Criteria) this;
        }

        public Criteria andCollageflagBetween(Integer value1, Integer value2) {
            addCriterion("collageFlag between", value1, value2, "collageflag");
            return (Criteria) this;
        }

        public Criteria andCollageflagNotBetween(Integer value1, Integer value2) {
            addCriterion("collageFlag not between", value1, value2, "collageflag");
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