package cj.netos.uc.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UcEmplExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    public UcEmplExample() {
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

        public Criteria andEmplIdIsNull() {
            addCriterion("empl_id is null");
            return (Criteria) this;
        }

        public Criteria andEmplIdIsNotNull() {
            addCriterion("empl_id is not null");
            return (Criteria) this;
        }

        public Criteria andEmplIdEqualTo(String value) {
            addCriterion("empl_id =", value, "emplId");
            return (Criteria) this;
        }

        public Criteria andEmplIdNotEqualTo(String value) {
            addCriterion("empl_id <>", value, "emplId");
            return (Criteria) this;
        }

        public Criteria andEmplIdGreaterThan(String value) {
            addCriterion("empl_id >", value, "emplId");
            return (Criteria) this;
        }

        public Criteria andEmplIdGreaterThanOrEqualTo(String value) {
            addCriterion("empl_id >=", value, "emplId");
            return (Criteria) this;
        }

        public Criteria andEmplIdLessThan(String value) {
            addCriterion("empl_id <", value, "emplId");
            return (Criteria) this;
        }

        public Criteria andEmplIdLessThanOrEqualTo(String value) {
            addCriterion("empl_id <=", value, "emplId");
            return (Criteria) this;
        }

        public Criteria andEmplIdLike(String value) {
            addCriterion("empl_id like", value, "emplId");
            return (Criteria) this;
        }

        public Criteria andEmplIdNotLike(String value) {
            addCriterion("empl_id not like", value, "emplId");
            return (Criteria) this;
        }

        public Criteria andEmplIdIn(List<String> values) {
            addCriterion("empl_id in", values, "emplId");
            return (Criteria) this;
        }

        public Criteria andEmplIdNotIn(List<String> values) {
            addCriterion("empl_id not in", values, "emplId");
            return (Criteria) this;
        }

        public Criteria andEmplIdBetween(String value1, String value2) {
            addCriterion("empl_id between", value1, value2, "emplId");
            return (Criteria) this;
        }

        public Criteria andEmplIdNotBetween(String value1, String value2) {
            addCriterion("empl_id not between", value1, value2, "emplId");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("user_id like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("user_id not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdIsNull() {
            addCriterion("company_id is null");
            return (Criteria) this;
        }

        public Criteria andCompanyIdIsNotNull() {
            addCriterion("company_id is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyIdEqualTo(String value) {
            addCriterion("company_id =", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotEqualTo(String value) {
            addCriterion("company_id <>", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdGreaterThan(String value) {
            addCriterion("company_id >", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdGreaterThanOrEqualTo(String value) {
            addCriterion("company_id >=", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdLessThan(String value) {
            addCriterion("company_id <", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdLessThanOrEqualTo(String value) {
            addCriterion("company_id <=", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdLike(String value) {
            addCriterion("company_id like", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotLike(String value) {
            addCriterion("company_id not like", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdIn(List<String> values) {
            addCriterion("company_id in", values, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotIn(List<String> values) {
            addCriterion("company_id not in", values, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdBetween(String value1, String value2) {
            addCriterion("company_id between", value1, value2, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotBetween(String value1, String value2) {
            addCriterion("company_id not between", value1, value2, "companyId");
            return (Criteria) this;
        }

        public Criteria andDeptIdIsNull() {
            addCriterion("dept_id is null");
            return (Criteria) this;
        }

        public Criteria andDeptIdIsNotNull() {
            addCriterion("dept_id is not null");
            return (Criteria) this;
        }

        public Criteria andDeptIdEqualTo(String value) {
            addCriterion("dept_id =", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdNotEqualTo(String value) {
            addCriterion("dept_id <>", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdGreaterThan(String value) {
            addCriterion("dept_id >", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdGreaterThanOrEqualTo(String value) {
            addCriterion("dept_id >=", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdLessThan(String value) {
            addCriterion("dept_id <", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdLessThanOrEqualTo(String value) {
            addCriterion("dept_id <=", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdLike(String value) {
            addCriterion("dept_id like", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdNotLike(String value) {
            addCriterion("dept_id not like", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdIn(List<String> values) {
            addCriterion("dept_id in", values, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdNotIn(List<String> values) {
            addCriterion("dept_id not in", values, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdBetween(String value1, String value2) {
            addCriterion("dept_id between", value1, value2, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdNotBetween(String value1, String value2) {
            addCriterion("dept_id not between", value1, value2, "deptId");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andEmplCodeIsNull() {
            addCriterion("empl_code is null");
            return (Criteria) this;
        }

        public Criteria andEmplCodeIsNotNull() {
            addCriterion("empl_code is not null");
            return (Criteria) this;
        }

        public Criteria andEmplCodeEqualTo(String value) {
            addCriterion("empl_code =", value, "emplCode");
            return (Criteria) this;
        }

        public Criteria andEmplCodeNotEqualTo(String value) {
            addCriterion("empl_code <>", value, "emplCode");
            return (Criteria) this;
        }

        public Criteria andEmplCodeGreaterThan(String value) {
            addCriterion("empl_code >", value, "emplCode");
            return (Criteria) this;
        }

        public Criteria andEmplCodeGreaterThanOrEqualTo(String value) {
            addCriterion("empl_code >=", value, "emplCode");
            return (Criteria) this;
        }

        public Criteria andEmplCodeLessThan(String value) {
            addCriterion("empl_code <", value, "emplCode");
            return (Criteria) this;
        }

        public Criteria andEmplCodeLessThanOrEqualTo(String value) {
            addCriterion("empl_code <=", value, "emplCode");
            return (Criteria) this;
        }

        public Criteria andEmplCodeLike(String value) {
            addCriterion("empl_code like", value, "emplCode");
            return (Criteria) this;
        }

        public Criteria andEmplCodeNotLike(String value) {
            addCriterion("empl_code not like", value, "emplCode");
            return (Criteria) this;
        }

        public Criteria andEmplCodeIn(List<String> values) {
            addCriterion("empl_code in", values, "emplCode");
            return (Criteria) this;
        }

        public Criteria andEmplCodeNotIn(List<String> values) {
            addCriterion("empl_code not in", values, "emplCode");
            return (Criteria) this;
        }

        public Criteria andEmplCodeBetween(String value1, String value2) {
            addCriterion("empl_code between", value1, value2, "emplCode");
            return (Criteria) this;
        }

        public Criteria andEmplCodeNotBetween(String value1, String value2) {
            addCriterion("empl_code not between", value1, value2, "emplCode");
            return (Criteria) this;
        }

        public Criteria andEmplPositionIsNull() {
            addCriterion("empl_position is null");
            return (Criteria) this;
        }

        public Criteria andEmplPositionIsNotNull() {
            addCriterion("empl_position is not null");
            return (Criteria) this;
        }

        public Criteria andEmplPositionEqualTo(String value) {
            addCriterion("empl_position =", value, "emplPosition");
            return (Criteria) this;
        }

        public Criteria andEmplPositionNotEqualTo(String value) {
            addCriterion("empl_position <>", value, "emplPosition");
            return (Criteria) this;
        }

        public Criteria andEmplPositionGreaterThan(String value) {
            addCriterion("empl_position >", value, "emplPosition");
            return (Criteria) this;
        }

        public Criteria andEmplPositionGreaterThanOrEqualTo(String value) {
            addCriterion("empl_position >=", value, "emplPosition");
            return (Criteria) this;
        }

        public Criteria andEmplPositionLessThan(String value) {
            addCriterion("empl_position <", value, "emplPosition");
            return (Criteria) this;
        }

        public Criteria andEmplPositionLessThanOrEqualTo(String value) {
            addCriterion("empl_position <=", value, "emplPosition");
            return (Criteria) this;
        }

        public Criteria andEmplPositionLike(String value) {
            addCriterion("empl_position like", value, "emplPosition");
            return (Criteria) this;
        }

        public Criteria andEmplPositionNotLike(String value) {
            addCriterion("empl_position not like", value, "emplPosition");
            return (Criteria) this;
        }

        public Criteria andEmplPositionIn(List<String> values) {
            addCriterion("empl_position in", values, "emplPosition");
            return (Criteria) this;
        }

        public Criteria andEmplPositionNotIn(List<String> values) {
            addCriterion("empl_position not in", values, "emplPosition");
            return (Criteria) this;
        }

        public Criteria andEmplPositionBetween(String value1, String value2) {
            addCriterion("empl_position between", value1, value2, "emplPosition");
            return (Criteria) this;
        }

        public Criteria andEmplPositionNotBetween(String value1, String value2) {
            addCriterion("empl_position not between", value1, value2, "emplPosition");
            return (Criteria) this;
        }

        public Criteria andEntryTimeIsNull() {
            addCriterion("entry_time is null");
            return (Criteria) this;
        }

        public Criteria andEntryTimeIsNotNull() {
            addCriterion("entry_time is not null");
            return (Criteria) this;
        }

        public Criteria andEntryTimeEqualTo(Date value) {
            addCriterion("entry_time =", value, "entryTime");
            return (Criteria) this;
        }

        public Criteria andEntryTimeNotEqualTo(Date value) {
            addCriterion("entry_time <>", value, "entryTime");
            return (Criteria) this;
        }

        public Criteria andEntryTimeGreaterThan(Date value) {
            addCriterion("entry_time >", value, "entryTime");
            return (Criteria) this;
        }

        public Criteria andEntryTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("entry_time >=", value, "entryTime");
            return (Criteria) this;
        }

        public Criteria andEntryTimeLessThan(Date value) {
            addCriterion("entry_time <", value, "entryTime");
            return (Criteria) this;
        }

        public Criteria andEntryTimeLessThanOrEqualTo(Date value) {
            addCriterion("entry_time <=", value, "entryTime");
            return (Criteria) this;
        }

        public Criteria andEntryTimeIn(List<Date> values) {
            addCriterion("entry_time in", values, "entryTime");
            return (Criteria) this;
        }

        public Criteria andEntryTimeNotIn(List<Date> values) {
            addCriterion("entry_time not in", values, "entryTime");
            return (Criteria) this;
        }

        public Criteria andEntryTimeBetween(Date value1, Date value2) {
            addCriterion("entry_time between", value1, value2, "entryTime");
            return (Criteria) this;
        }

        public Criteria andEntryTimeNotBetween(Date value1, Date value2) {
            addCriterion("entry_time not between", value1, value2, "entryTime");
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