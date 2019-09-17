package cj.netos.uc.domain;

import java.util.ArrayList;
import java.util.List;

public class TenantRoleExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table tenant_role
	 * @mbg.generated  Wed Sep 18 02:11:41 CST 2019
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table tenant_role
	 * @mbg.generated  Wed Sep 18 02:11:41 CST 2019
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table tenant_role
	 * @mbg.generated  Wed Sep 18 02:11:41 CST 2019
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table tenant_role
	 * @mbg.generated  Wed Sep 18 02:11:41 CST 2019
	 */
	public TenantRoleExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table tenant_role
	 * @mbg.generated  Wed Sep 18 02:11:41 CST 2019
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table tenant_role
	 * @mbg.generated  Wed Sep 18 02:11:41 CST 2019
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table tenant_role
	 * @mbg.generated  Wed Sep 18 02:11:41 CST 2019
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table tenant_role
	 * @mbg.generated  Wed Sep 18 02:11:41 CST 2019
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table tenant_role
	 * @mbg.generated  Wed Sep 18 02:11:41 CST 2019
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table tenant_role
	 * @mbg.generated  Wed Sep 18 02:11:41 CST 2019
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table tenant_role
	 * @mbg.generated  Wed Sep 18 02:11:41 CST 2019
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table tenant_role
	 * @mbg.generated  Wed Sep 18 02:11:41 CST 2019
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table tenant_role
	 * @mbg.generated  Wed Sep 18 02:11:41 CST 2019
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table tenant_role
	 * @mbg.generated  Wed Sep 18 02:11:41 CST 2019
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table tenant_role
	 * @mbg.generated  Wed Sep 18 02:11:41 CST 2019
	 */
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

		public Criteria andRoleIdIsNull() {
			addCriterion("role_id is null");
			return (Criteria) this;
		}

		public Criteria andRoleIdIsNotNull() {
			addCriterion("role_id is not null");
			return (Criteria) this;
		}

		public Criteria andRoleIdEqualTo(String value) {
			addCriterion("role_id =", value, "roleId");
			return (Criteria) this;
		}

		public Criteria andRoleIdNotEqualTo(String value) {
			addCriterion("role_id <>", value, "roleId");
			return (Criteria) this;
		}

		public Criteria andRoleIdGreaterThan(String value) {
			addCriterion("role_id >", value, "roleId");
			return (Criteria) this;
		}

		public Criteria andRoleIdGreaterThanOrEqualTo(String value) {
			addCriterion("role_id >=", value, "roleId");
			return (Criteria) this;
		}

		public Criteria andRoleIdLessThan(String value) {
			addCriterion("role_id <", value, "roleId");
			return (Criteria) this;
		}

		public Criteria andRoleIdLessThanOrEqualTo(String value) {
			addCriterion("role_id <=", value, "roleId");
			return (Criteria) this;
		}

		public Criteria andRoleIdLike(String value) {
			addCriterion("role_id like", value, "roleId");
			return (Criteria) this;
		}

		public Criteria andRoleIdNotLike(String value) {
			addCriterion("role_id not like", value, "roleId");
			return (Criteria) this;
		}

		public Criteria andRoleIdIn(List<String> values) {
			addCriterion("role_id in", values, "roleId");
			return (Criteria) this;
		}

		public Criteria andRoleIdNotIn(List<String> values) {
			addCriterion("role_id not in", values, "roleId");
			return (Criteria) this;
		}

		public Criteria andRoleIdBetween(String value1, String value2) {
			addCriterion("role_id between", value1, value2, "roleId");
			return (Criteria) this;
		}

		public Criteria andRoleIdNotBetween(String value1, String value2) {
			addCriterion("role_id not between", value1, value2, "roleId");
			return (Criteria) this;
		}

		public Criteria andExtendIsNull() {
			addCriterion("extend is null");
			return (Criteria) this;
		}

		public Criteria andExtendIsNotNull() {
			addCriterion("extend is not null");
			return (Criteria) this;
		}

		public Criteria andExtendEqualTo(String value) {
			addCriterion("extend =", value, "extend");
			return (Criteria) this;
		}

		public Criteria andExtendNotEqualTo(String value) {
			addCriterion("extend <>", value, "extend");
			return (Criteria) this;
		}

		public Criteria andExtendGreaterThan(String value) {
			addCriterion("extend >", value, "extend");
			return (Criteria) this;
		}

		public Criteria andExtendGreaterThanOrEqualTo(String value) {
			addCriterion("extend >=", value, "extend");
			return (Criteria) this;
		}

		public Criteria andExtendLessThan(String value) {
			addCriterion("extend <", value, "extend");
			return (Criteria) this;
		}

		public Criteria andExtendLessThanOrEqualTo(String value) {
			addCriterion("extend <=", value, "extend");
			return (Criteria) this;
		}

		public Criteria andExtendLike(String value) {
			addCriterion("extend like", value, "extend");
			return (Criteria) this;
		}

		public Criteria andExtendNotLike(String value) {
			addCriterion("extend not like", value, "extend");
			return (Criteria) this;
		}

		public Criteria andExtendIn(List<String> values) {
			addCriterion("extend in", values, "extend");
			return (Criteria) this;
		}

		public Criteria andExtendNotIn(List<String> values) {
			addCriterion("extend not in", values, "extend");
			return (Criteria) this;
		}

		public Criteria andExtendBetween(String value1, String value2) {
			addCriterion("extend between", value1, value2, "extend");
			return (Criteria) this;
		}

		public Criteria andExtendNotBetween(String value1, String value2) {
			addCriterion("extend not between", value1, value2, "extend");
			return (Criteria) this;
		}

		public Criteria andTenantIdIsNull() {
			addCriterion("tenant_id is null");
			return (Criteria) this;
		}

		public Criteria andTenantIdIsNotNull() {
			addCriterion("tenant_id is not null");
			return (Criteria) this;
		}

		public Criteria andTenantIdEqualTo(String value) {
			addCriterion("tenant_id =", value, "tenantId");
			return (Criteria) this;
		}

		public Criteria andTenantIdNotEqualTo(String value) {
			addCriterion("tenant_id <>", value, "tenantId");
			return (Criteria) this;
		}

		public Criteria andTenantIdGreaterThan(String value) {
			addCriterion("tenant_id >", value, "tenantId");
			return (Criteria) this;
		}

		public Criteria andTenantIdGreaterThanOrEqualTo(String value) {
			addCriterion("tenant_id >=", value, "tenantId");
			return (Criteria) this;
		}

		public Criteria andTenantIdLessThan(String value) {
			addCriterion("tenant_id <", value, "tenantId");
			return (Criteria) this;
		}

		public Criteria andTenantIdLessThanOrEqualTo(String value) {
			addCriterion("tenant_id <=", value, "tenantId");
			return (Criteria) this;
		}

		public Criteria andTenantIdLike(String value) {
			addCriterion("tenant_id like", value, "tenantId");
			return (Criteria) this;
		}

		public Criteria andTenantIdNotLike(String value) {
			addCriterion("tenant_id not like", value, "tenantId");
			return (Criteria) this;
		}

		public Criteria andTenantIdIn(List<String> values) {
			addCriterion("tenant_id in", values, "tenantId");
			return (Criteria) this;
		}

		public Criteria andTenantIdNotIn(List<String> values) {
			addCriterion("tenant_id not in", values, "tenantId");
			return (Criteria) this;
		}

		public Criteria andTenantIdBetween(String value1, String value2) {
			addCriterion("tenant_id between", value1, value2, "tenantId");
			return (Criteria) this;
		}

		public Criteria andTenantIdNotBetween(String value1, String value2) {
			addCriterion("tenant_id not between", value1, value2, "tenantId");
			return (Criteria) this;
		}

		public Criteria andRoleNameIsNull() {
			addCriterion("role_name is null");
			return (Criteria) this;
		}

		public Criteria andRoleNameIsNotNull() {
			addCriterion("role_name is not null");
			return (Criteria) this;
		}

		public Criteria andRoleNameEqualTo(String value) {
			addCriterion("role_name =", value, "roleName");
			return (Criteria) this;
		}

		public Criteria andRoleNameNotEqualTo(String value) {
			addCriterion("role_name <>", value, "roleName");
			return (Criteria) this;
		}

		public Criteria andRoleNameGreaterThan(String value) {
			addCriterion("role_name >", value, "roleName");
			return (Criteria) this;
		}

		public Criteria andRoleNameGreaterThanOrEqualTo(String value) {
			addCriterion("role_name >=", value, "roleName");
			return (Criteria) this;
		}

		public Criteria andRoleNameLessThan(String value) {
			addCriterion("role_name <", value, "roleName");
			return (Criteria) this;
		}

		public Criteria andRoleNameLessThanOrEqualTo(String value) {
			addCriterion("role_name <=", value, "roleName");
			return (Criteria) this;
		}

		public Criteria andRoleNameLike(String value) {
			addCriterion("role_name like", value, "roleName");
			return (Criteria) this;
		}

		public Criteria andRoleNameNotLike(String value) {
			addCriterion("role_name not like", value, "roleName");
			return (Criteria) this;
		}

		public Criteria andRoleNameIn(List<String> values) {
			addCriterion("role_name in", values, "roleName");
			return (Criteria) this;
		}

		public Criteria andRoleNameNotIn(List<String> values) {
			addCriterion("role_name not in", values, "roleName");
			return (Criteria) this;
		}

		public Criteria andRoleNameBetween(String value1, String value2) {
			addCriterion("role_name between", value1, value2, "roleName");
			return (Criteria) this;
		}

		public Criteria andRoleNameNotBetween(String value1, String value2) {
			addCriterion("role_name not between", value1, value2, "roleName");
			return (Criteria) this;
		}

		public Criteria andIsInheritableIsNull() {
			addCriterion("is_Inheritable is null");
			return (Criteria) this;
		}

		public Criteria andIsInheritableIsNotNull() {
			addCriterion("is_Inheritable is not null");
			return (Criteria) this;
		}

		public Criteria andIsInheritableEqualTo(Boolean value) {
			addCriterion("is_Inheritable =", value, "isInheritable");
			return (Criteria) this;
		}

		public Criteria andIsInheritableNotEqualTo(Boolean value) {
			addCriterion("is_Inheritable <>", value, "isInheritable");
			return (Criteria) this;
		}

		public Criteria andIsInheritableGreaterThan(Boolean value) {
			addCriterion("is_Inheritable >", value, "isInheritable");
			return (Criteria) this;
		}

		public Criteria andIsInheritableGreaterThanOrEqualTo(Boolean value) {
			addCriterion("is_Inheritable >=", value, "isInheritable");
			return (Criteria) this;
		}

		public Criteria andIsInheritableLessThan(Boolean value) {
			addCriterion("is_Inheritable <", value, "isInheritable");
			return (Criteria) this;
		}

		public Criteria andIsInheritableLessThanOrEqualTo(Boolean value) {
			addCriterion("is_Inheritable <=", value, "isInheritable");
			return (Criteria) this;
		}

		public Criteria andIsInheritableIn(List<Boolean> values) {
			addCriterion("is_Inheritable in", values, "isInheritable");
			return (Criteria) this;
		}

		public Criteria andIsInheritableNotIn(List<Boolean> values) {
			addCriterion("is_Inheritable not in", values, "isInheritable");
			return (Criteria) this;
		}

		public Criteria andIsInheritableBetween(Boolean value1, Boolean value2) {
			addCriterion("is_Inheritable between", value1, value2, "isInheritable");
			return (Criteria) this;
		}

		public Criteria andIsInheritableNotBetween(Boolean value1, Boolean value2) {
			addCriterion("is_Inheritable not between", value1, value2, "isInheritable");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table tenant_role
	 * @mbg.generated  Wed Sep 18 02:11:41 CST 2019
	 */
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

	/**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table tenant_role
     *
     * @mbg.generated do_not_delete_during_merge Mon Sep 16 16:08:22 PHT 2019
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}