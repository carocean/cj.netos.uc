package cj.netos.uc.model;

import java.util.ArrayList;
import java.util.List;

public class AppAccountSourceExample {
    /**
     * @mbg.generated generated automatically, do not modify!
     */
    protected String orderByClause;

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    protected boolean distinct;

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    protected List<Criteria> oredCriteria;

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    public AppAccountSourceExample() {
        oredCriteria = new ArrayList<>();
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
            criteria = new ArrayList<>();
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

        public Criteria andAccountIdIsNull() {
            addCriterion("account_id is null");
            return (Criteria) this;
        }

        public Criteria andAccountIdIsNotNull() {
            addCriterion("account_id is not null");
            return (Criteria) this;
        }

        public Criteria andAccountIdEqualTo(String value) {
            addCriterion("account_id =", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdNotEqualTo(String value) {
            addCriterion("account_id <>", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdGreaterThan(String value) {
            addCriterion("account_id >", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdGreaterThanOrEqualTo(String value) {
            addCriterion("account_id >=", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdLessThan(String value) {
            addCriterion("account_id <", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdLessThanOrEqualTo(String value) {
            addCriterion("account_id <=", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdLike(String value) {
            addCriterion("account_id like", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdNotLike(String value) {
            addCriterion("account_id not like", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdIn(List<String> values) {
            addCriterion("account_id in", values, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdNotIn(List<String> values) {
            addCriterion("account_id not in", values, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdBetween(String value1, String value2) {
            addCriterion("account_id between", value1, value2, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdNotBetween(String value1, String value2) {
            addCriterion("account_id not between", value1, value2, "accountId");
            return (Criteria) this;
        }

        public Criteria andSubSystemIsNull() {
            addCriterion("sub_system is null");
            return (Criteria) this;
        }

        public Criteria andSubSystemIsNotNull() {
            addCriterion("sub_system is not null");
            return (Criteria) this;
        }

        public Criteria andSubSystemEqualTo(String value) {
            addCriterion("sub_system =", value, "subSystem");
            return (Criteria) this;
        }

        public Criteria andSubSystemNotEqualTo(String value) {
            addCriterion("sub_system <>", value, "subSystem");
            return (Criteria) this;
        }

        public Criteria andSubSystemGreaterThan(String value) {
            addCriterion("sub_system >", value, "subSystem");
            return (Criteria) this;
        }

        public Criteria andSubSystemGreaterThanOrEqualTo(String value) {
            addCriterion("sub_system >=", value, "subSystem");
            return (Criteria) this;
        }

        public Criteria andSubSystemLessThan(String value) {
            addCriterion("sub_system <", value, "subSystem");
            return (Criteria) this;
        }

        public Criteria andSubSystemLessThanOrEqualTo(String value) {
            addCriterion("sub_system <=", value, "subSystem");
            return (Criteria) this;
        }

        public Criteria andSubSystemLike(String value) {
            addCriterion("sub_system like", value, "subSystem");
            return (Criteria) this;
        }

        public Criteria andSubSystemNotLike(String value) {
            addCriterion("sub_system not like", value, "subSystem");
            return (Criteria) this;
        }

        public Criteria andSubSystemIn(List<String> values) {
            addCriterion("sub_system in", values, "subSystem");
            return (Criteria) this;
        }

        public Criteria andSubSystemNotIn(List<String> values) {
            addCriterion("sub_system not in", values, "subSystem");
            return (Criteria) this;
        }

        public Criteria andSubSystemBetween(String value1, String value2) {
            addCriterion("sub_system between", value1, value2, "subSystem");
            return (Criteria) this;
        }

        public Criteria andSubSystemNotBetween(String value1, String value2) {
            addCriterion("sub_system not between", value1, value2, "subSystem");
            return (Criteria) this;
        }

        public Criteria andSubSysOpenidIsNull() {
            addCriterion("sub_sys_openid is null");
            return (Criteria) this;
        }

        public Criteria andSubSysOpenidIsNotNull() {
            addCriterion("sub_sys_openid is not null");
            return (Criteria) this;
        }

        public Criteria andSubSysOpenidEqualTo(String value) {
            addCriterion("sub_sys_openid =", value, "subSysOpenid");
            return (Criteria) this;
        }

        public Criteria andSubSysOpenidNotEqualTo(String value) {
            addCriterion("sub_sys_openid <>", value, "subSysOpenid");
            return (Criteria) this;
        }

        public Criteria andSubSysOpenidGreaterThan(String value) {
            addCriterion("sub_sys_openid >", value, "subSysOpenid");
            return (Criteria) this;
        }

        public Criteria andSubSysOpenidGreaterThanOrEqualTo(String value) {
            addCriterion("sub_sys_openid >=", value, "subSysOpenid");
            return (Criteria) this;
        }

        public Criteria andSubSysOpenidLessThan(String value) {
            addCriterion("sub_sys_openid <", value, "subSysOpenid");
            return (Criteria) this;
        }

        public Criteria andSubSysOpenidLessThanOrEqualTo(String value) {
            addCriterion("sub_sys_openid <=", value, "subSysOpenid");
            return (Criteria) this;
        }

        public Criteria andSubSysOpenidLike(String value) {
            addCriterion("sub_sys_openid like", value, "subSysOpenid");
            return (Criteria) this;
        }

        public Criteria andSubSysOpenidNotLike(String value) {
            addCriterion("sub_sys_openid not like", value, "subSysOpenid");
            return (Criteria) this;
        }

        public Criteria andSubSysOpenidIn(List<String> values) {
            addCriterion("sub_sys_openid in", values, "subSysOpenid");
            return (Criteria) this;
        }

        public Criteria andSubSysOpenidNotIn(List<String> values) {
            addCriterion("sub_sys_openid not in", values, "subSysOpenid");
            return (Criteria) this;
        }

        public Criteria andSubSysOpenidBetween(String value1, String value2) {
            addCriterion("sub_sys_openid between", value1, value2, "subSysOpenid");
            return (Criteria) this;
        }

        public Criteria andSubSysOpenidNotBetween(String value1, String value2) {
            addCriterion("sub_sys_openid not between", value1, value2, "subSysOpenid");
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