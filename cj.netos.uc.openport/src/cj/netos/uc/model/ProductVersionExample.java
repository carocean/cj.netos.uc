package cj.netos.uc.model;

import java.util.ArrayList;
import java.util.List;

public class ProductVersionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    public ProductVersionExample() {
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

        public Criteria andProductIsNull() {
            addCriterion("product is null");
            return (Criteria) this;
        }

        public Criteria andProductIsNotNull() {
            addCriterion("product is not null");
            return (Criteria) this;
        }

        public Criteria andProductEqualTo(String value) {
            addCriterion("product =", value, "product");
            return (Criteria) this;
        }

        public Criteria andProductNotEqualTo(String value) {
            addCriterion("product <>", value, "product");
            return (Criteria) this;
        }

        public Criteria andProductGreaterThan(String value) {
            addCriterion("product >", value, "product");
            return (Criteria) this;
        }

        public Criteria andProductGreaterThanOrEqualTo(String value) {
            addCriterion("product >=", value, "product");
            return (Criteria) this;
        }

        public Criteria andProductLessThan(String value) {
            addCriterion("product <", value, "product");
            return (Criteria) this;
        }

        public Criteria andProductLessThanOrEqualTo(String value) {
            addCriterion("product <=", value, "product");
            return (Criteria) this;
        }

        public Criteria andProductLike(String value) {
            addCriterion("product like", value, "product");
            return (Criteria) this;
        }

        public Criteria andProductNotLike(String value) {
            addCriterion("product not like", value, "product");
            return (Criteria) this;
        }

        public Criteria andProductIn(List<String> values) {
            addCriterion("product in", values, "product");
            return (Criteria) this;
        }

        public Criteria andProductNotIn(List<String> values) {
            addCriterion("product not in", values, "product");
            return (Criteria) this;
        }

        public Criteria andProductBetween(String value1, String value2) {
            addCriterion("product between", value1, value2, "product");
            return (Criteria) this;
        }

        public Criteria andProductNotBetween(String value1, String value2) {
            addCriterion("product not between", value1, value2, "product");
            return (Criteria) this;
        }

        public Criteria andOsIsNull() {
            addCriterion("os is null");
            return (Criteria) this;
        }

        public Criteria andOsIsNotNull() {
            addCriterion("os is not null");
            return (Criteria) this;
        }

        public Criteria andOsEqualTo(String value) {
            addCriterion("os =", value, "os");
            return (Criteria) this;
        }

        public Criteria andOsNotEqualTo(String value) {
            addCriterion("os <>", value, "os");
            return (Criteria) this;
        }

        public Criteria andOsGreaterThan(String value) {
            addCriterion("os >", value, "os");
            return (Criteria) this;
        }

        public Criteria andOsGreaterThanOrEqualTo(String value) {
            addCriterion("os >=", value, "os");
            return (Criteria) this;
        }

        public Criteria andOsLessThan(String value) {
            addCriterion("os <", value, "os");
            return (Criteria) this;
        }

        public Criteria andOsLessThanOrEqualTo(String value) {
            addCriterion("os <=", value, "os");
            return (Criteria) this;
        }

        public Criteria andOsLike(String value) {
            addCriterion("os like", value, "os");
            return (Criteria) this;
        }

        public Criteria andOsNotLike(String value) {
            addCriterion("os not like", value, "os");
            return (Criteria) this;
        }

        public Criteria andOsIn(List<String> values) {
            addCriterion("os in", values, "os");
            return (Criteria) this;
        }

        public Criteria andOsNotIn(List<String> values) {
            addCriterion("os not in", values, "os");
            return (Criteria) this;
        }

        public Criteria andOsBetween(String value1, String value2) {
            addCriterion("os between", value1, value2, "os");
            return (Criteria) this;
        }

        public Criteria andOsNotBetween(String value1, String value2) {
            addCriterion("os not between", value1, value2, "os");
            return (Criteria) this;
        }

        public Criteria andVersionIsNull() {
            addCriterion("version is null");
            return (Criteria) this;
        }

        public Criteria andVersionIsNotNull() {
            addCriterion("version is not null");
            return (Criteria) this;
        }

        public Criteria andVersionEqualTo(String value) {
            addCriterion("version =", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotEqualTo(String value) {
            addCriterion("version <>", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThan(String value) {
            addCriterion("version >", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThanOrEqualTo(String value) {
            addCriterion("version >=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThan(String value) {
            addCriterion("version <", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThanOrEqualTo(String value) {
            addCriterion("version <=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLike(String value) {
            addCriterion("version like", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotLike(String value) {
            addCriterion("version not like", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionIn(List<String> values) {
            addCriterion("version in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotIn(List<String> values) {
            addCriterion("version not in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionBetween(String value1, String value2) {
            addCriterion("version between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotBetween(String value1, String value2) {
            addCriterion("version not between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andReadmeFileIsNull() {
            addCriterion("readme_file is null");
            return (Criteria) this;
        }

        public Criteria andReadmeFileIsNotNull() {
            addCriterion("readme_file is not null");
            return (Criteria) this;
        }

        public Criteria andReadmeFileEqualTo(String value) {
            addCriterion("readme_file =", value, "readmeFile");
            return (Criteria) this;
        }

        public Criteria andReadmeFileNotEqualTo(String value) {
            addCriterion("readme_file <>", value, "readmeFile");
            return (Criteria) this;
        }

        public Criteria andReadmeFileGreaterThan(String value) {
            addCriterion("readme_file >", value, "readmeFile");
            return (Criteria) this;
        }

        public Criteria andReadmeFileGreaterThanOrEqualTo(String value) {
            addCriterion("readme_file >=", value, "readmeFile");
            return (Criteria) this;
        }

        public Criteria andReadmeFileLessThan(String value) {
            addCriterion("readme_file <", value, "readmeFile");
            return (Criteria) this;
        }

        public Criteria andReadmeFileLessThanOrEqualTo(String value) {
            addCriterion("readme_file <=", value, "readmeFile");
            return (Criteria) this;
        }

        public Criteria andReadmeFileLike(String value) {
            addCriterion("readme_file like", value, "readmeFile");
            return (Criteria) this;
        }

        public Criteria andReadmeFileNotLike(String value) {
            addCriterion("readme_file not like", value, "readmeFile");
            return (Criteria) this;
        }

        public Criteria andReadmeFileIn(List<String> values) {
            addCriterion("readme_file in", values, "readmeFile");
            return (Criteria) this;
        }

        public Criteria andReadmeFileNotIn(List<String> values) {
            addCriterion("readme_file not in", values, "readmeFile");
            return (Criteria) this;
        }

        public Criteria andReadmeFileBetween(String value1, String value2) {
            addCriterion("readme_file between", value1, value2, "readmeFile");
            return (Criteria) this;
        }

        public Criteria andReadmeFileNotBetween(String value1, String value2) {
            addCriterion("readme_file not between", value1, value2, "readmeFile");
            return (Criteria) this;
        }

        public Criteria andPubTimeIsNull() {
            addCriterion("pub_time is null");
            return (Criteria) this;
        }

        public Criteria andPubTimeIsNotNull() {
            addCriterion("pub_time is not null");
            return (Criteria) this;
        }

        public Criteria andPubTimeEqualTo(String value) {
            addCriterion("pub_time =", value, "pubTime");
            return (Criteria) this;
        }

        public Criteria andPubTimeNotEqualTo(String value) {
            addCriterion("pub_time <>", value, "pubTime");
            return (Criteria) this;
        }

        public Criteria andPubTimeGreaterThan(String value) {
            addCriterion("pub_time >", value, "pubTime");
            return (Criteria) this;
        }

        public Criteria andPubTimeGreaterThanOrEqualTo(String value) {
            addCriterion("pub_time >=", value, "pubTime");
            return (Criteria) this;
        }

        public Criteria andPubTimeLessThan(String value) {
            addCriterion("pub_time <", value, "pubTime");
            return (Criteria) this;
        }

        public Criteria andPubTimeLessThanOrEqualTo(String value) {
            addCriterion("pub_time <=", value, "pubTime");
            return (Criteria) this;
        }

        public Criteria andPubTimeLike(String value) {
            addCriterion("pub_time like", value, "pubTime");
            return (Criteria) this;
        }

        public Criteria andPubTimeNotLike(String value) {
            addCriterion("pub_time not like", value, "pubTime");
            return (Criteria) this;
        }

        public Criteria andPubTimeIn(List<String> values) {
            addCriterion("pub_time in", values, "pubTime");
            return (Criteria) this;
        }

        public Criteria andPubTimeNotIn(List<String> values) {
            addCriterion("pub_time not in", values, "pubTime");
            return (Criteria) this;
        }

        public Criteria andPubTimeBetween(String value1, String value2) {
            addCriterion("pub_time between", value1, value2, "pubTime");
            return (Criteria) this;
        }

        public Criteria andPubTimeNotBetween(String value1, String value2) {
            addCriterion("pub_time not between", value1, value2, "pubTime");
            return (Criteria) this;
        }

        public Criteria andPubTypeIsNull() {
            addCriterion("pub_type is null");
            return (Criteria) this;
        }

        public Criteria andPubTypeIsNotNull() {
            addCriterion("pub_type is not null");
            return (Criteria) this;
        }

        public Criteria andPubTypeEqualTo(Integer value) {
            addCriterion("pub_type =", value, "pubType");
            return (Criteria) this;
        }

        public Criteria andPubTypeNotEqualTo(Integer value) {
            addCriterion("pub_type <>", value, "pubType");
            return (Criteria) this;
        }

        public Criteria andPubTypeGreaterThan(Integer value) {
            addCriterion("pub_type >", value, "pubType");
            return (Criteria) this;
        }

        public Criteria andPubTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("pub_type >=", value, "pubType");
            return (Criteria) this;
        }

        public Criteria andPubTypeLessThan(Integer value) {
            addCriterion("pub_type <", value, "pubType");
            return (Criteria) this;
        }

        public Criteria andPubTypeLessThanOrEqualTo(Integer value) {
            addCriterion("pub_type <=", value, "pubType");
            return (Criteria) this;
        }

        public Criteria andPubTypeIn(List<Integer> values) {
            addCriterion("pub_type in", values, "pubType");
            return (Criteria) this;
        }

        public Criteria andPubTypeNotIn(List<Integer> values) {
            addCriterion("pub_type not in", values, "pubType");
            return (Criteria) this;
        }

        public Criteria andPubTypeBetween(Integer value1, Integer value2) {
            addCriterion("pub_type between", value1, value2, "pubType");
            return (Criteria) this;
        }

        public Criteria andPubTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("pub_type not between", value1, value2, "pubType");
            return (Criteria) this;
        }

        public Criteria andForceUpgradeIsNull() {
            addCriterion("force_upgrade is null");
            return (Criteria) this;
        }

        public Criteria andForceUpgradeIsNotNull() {
            addCriterion("force_upgrade is not null");
            return (Criteria) this;
        }

        public Criteria andForceUpgradeEqualTo(Integer value) {
            addCriterion("force_upgrade =", value, "forceUpgrade");
            return (Criteria) this;
        }

        public Criteria andForceUpgradeNotEqualTo(Integer value) {
            addCriterion("force_upgrade <>", value, "forceUpgrade");
            return (Criteria) this;
        }

        public Criteria andForceUpgradeGreaterThan(Integer value) {
            addCriterion("force_upgrade >", value, "forceUpgrade");
            return (Criteria) this;
        }

        public Criteria andForceUpgradeGreaterThanOrEqualTo(Integer value) {
            addCriterion("force_upgrade >=", value, "forceUpgrade");
            return (Criteria) this;
        }

        public Criteria andForceUpgradeLessThan(Integer value) {
            addCriterion("force_upgrade <", value, "forceUpgrade");
            return (Criteria) this;
        }

        public Criteria andForceUpgradeLessThanOrEqualTo(Integer value) {
            addCriterion("force_upgrade <=", value, "forceUpgrade");
            return (Criteria) this;
        }

        public Criteria andForceUpgradeIn(List<Integer> values) {
            addCriterion("force_upgrade in", values, "forceUpgrade");
            return (Criteria) this;
        }

        public Criteria andForceUpgradeNotIn(List<Integer> values) {
            addCriterion("force_upgrade not in", values, "forceUpgrade");
            return (Criteria) this;
        }

        public Criteria andForceUpgradeBetween(Integer value1, Integer value2) {
            addCriterion("force_upgrade between", value1, value2, "forceUpgrade");
            return (Criteria) this;
        }

        public Criteria andForceUpgradeNotBetween(Integer value1, Integer value2) {
            addCriterion("force_upgrade not between", value1, value2, "forceUpgrade");
            return (Criteria) this;
        }

        public Criteria andUseLayoutIsNull() {
            addCriterion("use_layout is null");
            return (Criteria) this;
        }

        public Criteria andUseLayoutIsNotNull() {
            addCriterion("use_layout is not null");
            return (Criteria) this;
        }

        public Criteria andUseLayoutEqualTo(String value) {
            addCriterion("use_layout =", value, "useLayout");
            return (Criteria) this;
        }

        public Criteria andUseLayoutNotEqualTo(String value) {
            addCriterion("use_layout <>", value, "useLayout");
            return (Criteria) this;
        }

        public Criteria andUseLayoutGreaterThan(String value) {
            addCriterion("use_layout >", value, "useLayout");
            return (Criteria) this;
        }

        public Criteria andUseLayoutGreaterThanOrEqualTo(String value) {
            addCriterion("use_layout >=", value, "useLayout");
            return (Criteria) this;
        }

        public Criteria andUseLayoutLessThan(String value) {
            addCriterion("use_layout <", value, "useLayout");
            return (Criteria) this;
        }

        public Criteria andUseLayoutLessThanOrEqualTo(String value) {
            addCriterion("use_layout <=", value, "useLayout");
            return (Criteria) this;
        }

        public Criteria andUseLayoutLike(String value) {
            addCriterion("use_layout like", value, "useLayout");
            return (Criteria) this;
        }

        public Criteria andUseLayoutNotLike(String value) {
            addCriterion("use_layout not like", value, "useLayout");
            return (Criteria) this;
        }

        public Criteria andUseLayoutIn(List<String> values) {
            addCriterion("use_layout in", values, "useLayout");
            return (Criteria) this;
        }

        public Criteria andUseLayoutNotIn(List<String> values) {
            addCriterion("use_layout not in", values, "useLayout");
            return (Criteria) this;
        }

        public Criteria andUseLayoutBetween(String value1, String value2) {
            addCriterion("use_layout between", value1, value2, "useLayout");
            return (Criteria) this;
        }

        public Criteria andUseLayoutNotBetween(String value1, String value2) {
            addCriterion("use_layout not between", value1, value2, "useLayout");
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