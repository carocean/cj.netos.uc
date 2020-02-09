package cj.netos.uc.model;

import java.util.ArrayList;
import java.util.List;

public class UcPropertiesExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    public UcPropertiesExample() {
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

        public Criteria andPropIdIsNull() {
            addCriterion("prop_id is null");
            return (Criteria) this;
        }

        public Criteria andPropIdIsNotNull() {
            addCriterion("prop_id is not null");
            return (Criteria) this;
        }

        public Criteria andPropIdEqualTo(String value) {
            addCriterion("prop_id =", value, "propId");
            return (Criteria) this;
        }

        public Criteria andPropIdNotEqualTo(String value) {
            addCriterion("prop_id <>", value, "propId");
            return (Criteria) this;
        }

        public Criteria andPropIdGreaterThan(String value) {
            addCriterion("prop_id >", value, "propId");
            return (Criteria) this;
        }

        public Criteria andPropIdGreaterThanOrEqualTo(String value) {
            addCriterion("prop_id >=", value, "propId");
            return (Criteria) this;
        }

        public Criteria andPropIdLessThan(String value) {
            addCriterion("prop_id <", value, "propId");
            return (Criteria) this;
        }

        public Criteria andPropIdLessThanOrEqualTo(String value) {
            addCriterion("prop_id <=", value, "propId");
            return (Criteria) this;
        }

        public Criteria andPropIdLike(String value) {
            addCriterion("prop_id like", value, "propId");
            return (Criteria) this;
        }

        public Criteria andPropIdNotLike(String value) {
            addCriterion("prop_id not like", value, "propId");
            return (Criteria) this;
        }

        public Criteria andPropIdIn(List<String> values) {
            addCriterion("prop_id in", values, "propId");
            return (Criteria) this;
        }

        public Criteria andPropIdNotIn(List<String> values) {
            addCriterion("prop_id not in", values, "propId");
            return (Criteria) this;
        }

        public Criteria andPropIdBetween(String value1, String value2) {
            addCriterion("prop_id between", value1, value2, "propId");
            return (Criteria) this;
        }

        public Criteria andPropIdNotBetween(String value1, String value2) {
            addCriterion("prop_id not between", value1, value2, "propId");
            return (Criteria) this;
        }

        public Criteria andPropKeyIsNull() {
            addCriterion("prop_key is null");
            return (Criteria) this;
        }

        public Criteria andPropKeyIsNotNull() {
            addCriterion("prop_key is not null");
            return (Criteria) this;
        }

        public Criteria andPropKeyEqualTo(String value) {
            addCriterion("prop_key =", value, "propKey");
            return (Criteria) this;
        }

        public Criteria andPropKeyNotEqualTo(String value) {
            addCriterion("prop_key <>", value, "propKey");
            return (Criteria) this;
        }

        public Criteria andPropKeyGreaterThan(String value) {
            addCriterion("prop_key >", value, "propKey");
            return (Criteria) this;
        }

        public Criteria andPropKeyGreaterThanOrEqualTo(String value) {
            addCriterion("prop_key >=", value, "propKey");
            return (Criteria) this;
        }

        public Criteria andPropKeyLessThan(String value) {
            addCriterion("prop_key <", value, "propKey");
            return (Criteria) this;
        }

        public Criteria andPropKeyLessThanOrEqualTo(String value) {
            addCriterion("prop_key <=", value, "propKey");
            return (Criteria) this;
        }

        public Criteria andPropKeyLike(String value) {
            addCriterion("prop_key like", value, "propKey");
            return (Criteria) this;
        }

        public Criteria andPropKeyNotLike(String value) {
            addCriterion("prop_key not like", value, "propKey");
            return (Criteria) this;
        }

        public Criteria andPropKeyIn(List<String> values) {
            addCriterion("prop_key in", values, "propKey");
            return (Criteria) this;
        }

        public Criteria andPropKeyNotIn(List<String> values) {
            addCriterion("prop_key not in", values, "propKey");
            return (Criteria) this;
        }

        public Criteria andPropKeyBetween(String value1, String value2) {
            addCriterion("prop_key between", value1, value2, "propKey");
            return (Criteria) this;
        }

        public Criteria andPropKeyNotBetween(String value1, String value2) {
            addCriterion("prop_key not between", value1, value2, "propKey");
            return (Criteria) this;
        }

        public Criteria andPropValueIsNull() {
            addCriterion("prop_value is null");
            return (Criteria) this;
        }

        public Criteria andPropValueIsNotNull() {
            addCriterion("prop_value is not null");
            return (Criteria) this;
        }

        public Criteria andPropValueEqualTo(String value) {
            addCriterion("prop_value =", value, "propValue");
            return (Criteria) this;
        }

        public Criteria andPropValueNotEqualTo(String value) {
            addCriterion("prop_value <>", value, "propValue");
            return (Criteria) this;
        }

        public Criteria andPropValueGreaterThan(String value) {
            addCriterion("prop_value >", value, "propValue");
            return (Criteria) this;
        }

        public Criteria andPropValueGreaterThanOrEqualTo(String value) {
            addCriterion("prop_value >=", value, "propValue");
            return (Criteria) this;
        }

        public Criteria andPropValueLessThan(String value) {
            addCriterion("prop_value <", value, "propValue");
            return (Criteria) this;
        }

        public Criteria andPropValueLessThanOrEqualTo(String value) {
            addCriterion("prop_value <=", value, "propValue");
            return (Criteria) this;
        }

        public Criteria andPropValueLike(String value) {
            addCriterion("prop_value like", value, "propValue");
            return (Criteria) this;
        }

        public Criteria andPropValueNotLike(String value) {
            addCriterion("prop_value not like", value, "propValue");
            return (Criteria) this;
        }

        public Criteria andPropValueIn(List<String> values) {
            addCriterion("prop_value in", values, "propValue");
            return (Criteria) this;
        }

        public Criteria andPropValueNotIn(List<String> values) {
            addCriterion("prop_value not in", values, "propValue");
            return (Criteria) this;
        }

        public Criteria andPropValueBetween(String value1, String value2) {
            addCriterion("prop_value between", value1, value2, "propValue");
            return (Criteria) this;
        }

        public Criteria andPropValueNotBetween(String value1, String value2) {
            addCriterion("prop_value not between", value1, value2, "propValue");
            return (Criteria) this;
        }

        public Criteria andPropDescIsNull() {
            addCriterion("prop_desc is null");
            return (Criteria) this;
        }

        public Criteria andPropDescIsNotNull() {
            addCriterion("prop_desc is not null");
            return (Criteria) this;
        }

        public Criteria andPropDescEqualTo(String value) {
            addCriterion("prop_desc =", value, "propDesc");
            return (Criteria) this;
        }

        public Criteria andPropDescNotEqualTo(String value) {
            addCriterion("prop_desc <>", value, "propDesc");
            return (Criteria) this;
        }

        public Criteria andPropDescGreaterThan(String value) {
            addCriterion("prop_desc >", value, "propDesc");
            return (Criteria) this;
        }

        public Criteria andPropDescGreaterThanOrEqualTo(String value) {
            addCriterion("prop_desc >=", value, "propDesc");
            return (Criteria) this;
        }

        public Criteria andPropDescLessThan(String value) {
            addCriterion("prop_desc <", value, "propDesc");
            return (Criteria) this;
        }

        public Criteria andPropDescLessThanOrEqualTo(String value) {
            addCriterion("prop_desc <=", value, "propDesc");
            return (Criteria) this;
        }

        public Criteria andPropDescLike(String value) {
            addCriterion("prop_desc like", value, "propDesc");
            return (Criteria) this;
        }

        public Criteria andPropDescNotLike(String value) {
            addCriterion("prop_desc not like", value, "propDesc");
            return (Criteria) this;
        }

        public Criteria andPropDescIn(List<String> values) {
            addCriterion("prop_desc in", values, "propDesc");
            return (Criteria) this;
        }

        public Criteria andPropDescNotIn(List<String> values) {
            addCriterion("prop_desc not in", values, "propDesc");
            return (Criteria) this;
        }

        public Criteria andPropDescBetween(String value1, String value2) {
            addCriterion("prop_desc between", value1, value2, "propDesc");
            return (Criteria) this;
        }

        public Criteria andPropDescNotBetween(String value1, String value2) {
            addCriterion("prop_desc not between", value1, value2, "propDesc");
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