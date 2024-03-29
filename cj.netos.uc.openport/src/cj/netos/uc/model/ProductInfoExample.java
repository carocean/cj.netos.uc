package cj.netos.uc.model;

import java.util.ArrayList;
import java.util.List;

public class ProductInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    public ProductInfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
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

        public Criteria andRootPathIsNull() {
            addCriterion("root_path is null");
            return (Criteria) this;
        }

        public Criteria andRootPathIsNotNull() {
            addCriterion("root_path is not null");
            return (Criteria) this;
        }

        public Criteria andRootPathEqualTo(String value) {
            addCriterion("root_path =", value, "rootPath");
            return (Criteria) this;
        }

        public Criteria andRootPathNotEqualTo(String value) {
            addCriterion("root_path <>", value, "rootPath");
            return (Criteria) this;
        }

        public Criteria andRootPathGreaterThan(String value) {
            addCriterion("root_path >", value, "rootPath");
            return (Criteria) this;
        }

        public Criteria andRootPathGreaterThanOrEqualTo(String value) {
            addCriterion("root_path >=", value, "rootPath");
            return (Criteria) this;
        }

        public Criteria andRootPathLessThan(String value) {
            addCriterion("root_path <", value, "rootPath");
            return (Criteria) this;
        }

        public Criteria andRootPathLessThanOrEqualTo(String value) {
            addCriterion("root_path <=", value, "rootPath");
            return (Criteria) this;
        }

        public Criteria andRootPathLike(String value) {
            addCriterion("root_path like", value, "rootPath");
            return (Criteria) this;
        }

        public Criteria andRootPathNotLike(String value) {
            addCriterion("root_path not like", value, "rootPath");
            return (Criteria) this;
        }

        public Criteria andRootPathIn(List<String> values) {
            addCriterion("root_path in", values, "rootPath");
            return (Criteria) this;
        }

        public Criteria andRootPathNotIn(List<String> values) {
            addCriterion("root_path not in", values, "rootPath");
            return (Criteria) this;
        }

        public Criteria andRootPathBetween(String value1, String value2) {
            addCriterion("root_path between", value1, value2, "rootPath");
            return (Criteria) this;
        }

        public Criteria andRootPathNotBetween(String value1, String value2) {
            addCriterion("root_path not between", value1, value2, "rootPath");
            return (Criteria) this;
        }

        public Criteria andCurrentVersionIsNull() {
            addCriterion("current_version is null");
            return (Criteria) this;
        }

        public Criteria andCurrentVersionIsNotNull() {
            addCriterion("current_version is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentVersionEqualTo(String value) {
            addCriterion("current_version =", value, "currentVersion");
            return (Criteria) this;
        }

        public Criteria andCurrentVersionNotEqualTo(String value) {
            addCriterion("current_version <>", value, "currentVersion");
            return (Criteria) this;
        }

        public Criteria andCurrentVersionGreaterThan(String value) {
            addCriterion("current_version >", value, "currentVersion");
            return (Criteria) this;
        }

        public Criteria andCurrentVersionGreaterThanOrEqualTo(String value) {
            addCriterion("current_version >=", value, "currentVersion");
            return (Criteria) this;
        }

        public Criteria andCurrentVersionLessThan(String value) {
            addCriterion("current_version <", value, "currentVersion");
            return (Criteria) this;
        }

        public Criteria andCurrentVersionLessThanOrEqualTo(String value) {
            addCriterion("current_version <=", value, "currentVersion");
            return (Criteria) this;
        }

        public Criteria andCurrentVersionLike(String value) {
            addCriterion("current_version like", value, "currentVersion");
            return (Criteria) this;
        }

        public Criteria andCurrentVersionNotLike(String value) {
            addCriterion("current_version not like", value, "currentVersion");
            return (Criteria) this;
        }

        public Criteria andCurrentVersionIn(List<String> values) {
            addCriterion("current_version in", values, "currentVersion");
            return (Criteria) this;
        }

        public Criteria andCurrentVersionNotIn(List<String> values) {
            addCriterion("current_version not in", values, "currentVersion");
            return (Criteria) this;
        }

        public Criteria andCurrentVersionBetween(String value1, String value2) {
            addCriterion("current_version between", value1, value2, "currentVersion");
            return (Criteria) this;
        }

        public Criteria andCurrentVersionNotBetween(String value1, String value2) {
            addCriterion("current_version not between", value1, value2, "currentVersion");
            return (Criteria) this;
        }

        public Criteria andCtimeIsNull() {
            addCriterion("ctime is null");
            return (Criteria) this;
        }

        public Criteria andCtimeIsNotNull() {
            addCriterion("ctime is not null");
            return (Criteria) this;
        }

        public Criteria andCtimeEqualTo(String value) {
            addCriterion("ctime =", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeNotEqualTo(String value) {
            addCriterion("ctime <>", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeGreaterThan(String value) {
            addCriterion("ctime >", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeGreaterThanOrEqualTo(String value) {
            addCriterion("ctime >=", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeLessThan(String value) {
            addCriterion("ctime <", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeLessThanOrEqualTo(String value) {
            addCriterion("ctime <=", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeLike(String value) {
            addCriterion("ctime like", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeNotLike(String value) {
            addCriterion("ctime not like", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeIn(List<String> values) {
            addCriterion("ctime in", values, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeNotIn(List<String> values) {
            addCriterion("ctime not in", values, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeBetween(String value1, String value2) {
            addCriterion("ctime between", value1, value2, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeNotBetween(String value1, String value2) {
            addCriterion("ctime not between", value1, value2, "ctime");
            return (Criteria) this;
        }

        public Criteria andDefaultMarketIsNull() {
            addCriterion("default_market is null");
            return (Criteria) this;
        }

        public Criteria andDefaultMarketIsNotNull() {
            addCriterion("default_market is not null");
            return (Criteria) this;
        }

        public Criteria andDefaultMarketEqualTo(String value) {
            addCriterion("default_market =", value, "defaultMarket");
            return (Criteria) this;
        }

        public Criteria andDefaultMarketNotEqualTo(String value) {
            addCriterion("default_market <>", value, "defaultMarket");
            return (Criteria) this;
        }

        public Criteria andDefaultMarketGreaterThan(String value) {
            addCriterion("default_market >", value, "defaultMarket");
            return (Criteria) this;
        }

        public Criteria andDefaultMarketGreaterThanOrEqualTo(String value) {
            addCriterion("default_market >=", value, "defaultMarket");
            return (Criteria) this;
        }

        public Criteria andDefaultMarketLessThan(String value) {
            addCriterion("default_market <", value, "defaultMarket");
            return (Criteria) this;
        }

        public Criteria andDefaultMarketLessThanOrEqualTo(String value) {
            addCriterion("default_market <=", value, "defaultMarket");
            return (Criteria) this;
        }

        public Criteria andDefaultMarketLike(String value) {
            addCriterion("default_market like", value, "defaultMarket");
            return (Criteria) this;
        }

        public Criteria andDefaultMarketNotLike(String value) {
            addCriterion("default_market not like", value, "defaultMarket");
            return (Criteria) this;
        }

        public Criteria andDefaultMarketIn(List<String> values) {
            addCriterion("default_market in", values, "defaultMarket");
            return (Criteria) this;
        }

        public Criteria andDefaultMarketNotIn(List<String> values) {
            addCriterion("default_market not in", values, "defaultMarket");
            return (Criteria) this;
        }

        public Criteria andDefaultMarketBetween(String value1, String value2) {
            addCriterion("default_market between", value1, value2, "defaultMarket");
            return (Criteria) this;
        }

        public Criteria andDefaultMarketNotBetween(String value1, String value2) {
            addCriterion("default_market not between", value1, value2, "defaultMarket");
            return (Criteria) this;
        }

        public Criteria andNoteIsNull() {
            addCriterion("note is null");
            return (Criteria) this;
        }

        public Criteria andNoteIsNotNull() {
            addCriterion("note is not null");
            return (Criteria) this;
        }

        public Criteria andNoteEqualTo(String value) {
            addCriterion("note =", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotEqualTo(String value) {
            addCriterion("note <>", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteGreaterThan(String value) {
            addCriterion("note >", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteGreaterThanOrEqualTo(String value) {
            addCriterion("note >=", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLessThan(String value) {
            addCriterion("note <", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLessThanOrEqualTo(String value) {
            addCriterion("note <=", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLike(String value) {
            addCriterion("note like", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotLike(String value) {
            addCriterion("note not like", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteIn(List<String> values) {
            addCriterion("note in", values, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotIn(List<String> values) {
            addCriterion("note not in", values, "note");
            return (Criteria) this;
        }

        public Criteria andNoteBetween(String value1, String value2) {
            addCriterion("note between", value1, value2, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotBetween(String value1, String value2) {
            addCriterion("note not between", value1, value2, "note");
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