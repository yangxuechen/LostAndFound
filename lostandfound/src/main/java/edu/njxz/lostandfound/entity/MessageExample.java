package edu.njxz.lostandfound.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class MessageExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MessageExample() {
        oredCriteria = new ArrayList<Criteria>();
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andMessageIdIsNull() {
            addCriterion("message_id is null");
            return (Criteria) this;
        }

        public Criteria andMessageIdIsNotNull() {
            addCriterion("message_id is not null");
            return (Criteria) this;
        }

        public Criteria andMessageIdEqualTo(Integer value) {
            addCriterion("message_id =", value, "messageId");
            return (Criteria) this;
        }

        public Criteria andMessageIdNotEqualTo(Integer value) {
            addCriterion("message_id <>", value, "messageId");
            return (Criteria) this;
        }

        public Criteria andMessageIdGreaterThan(Integer value) {
            addCriterion("message_id >", value, "messageId");
            return (Criteria) this;
        }

        public Criteria andMessageIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("message_id >=", value, "messageId");
            return (Criteria) this;
        }

        public Criteria andMessageIdLessThan(Integer value) {
            addCriterion("message_id <", value, "messageId");
            return (Criteria) this;
        }

        public Criteria andMessageIdLessThanOrEqualTo(Integer value) {
            addCriterion("message_id <=", value, "messageId");
            return (Criteria) this;
        }

        public Criteria andMessageIdIn(List<Integer> values) {
            addCriterion("message_id in", values, "messageId");
            return (Criteria) this;
        }

        public Criteria andMessageIdNotIn(List<Integer> values) {
            addCriterion("message_id not in", values, "messageId");
            return (Criteria) this;
        }

        public Criteria andMessageIdBetween(Integer value1, Integer value2) {
            addCriterion("message_id between", value1, value2, "messageId");
            return (Criteria) this;
        }

        public Criteria andMessageIdNotBetween(Integer value1, Integer value2) {
            addCriterion("message_id not between", value1, value2, "messageId");
            return (Criteria) this;
        }

        public Criteria andMessageDescriptionIsNull() {
            addCriterion("message_description is null");
            return (Criteria) this;
        }

        public Criteria andMessageDescriptionIsNotNull() {
            addCriterion("message_description is not null");
            return (Criteria) this;
        }

        public Criteria andMessageDescriptionEqualTo(String value) {
            addCriterion("message_description =", value, "messageDescription");
            return (Criteria) this;
        }

        public Criteria andMessageDescriptionNotEqualTo(String value) {
            addCriterion("message_description <>", value, "messageDescription");
            return (Criteria) this;
        }

        public Criteria andMessageDescriptionGreaterThan(String value) {
            addCriterion("message_description >", value, "messageDescription");
            return (Criteria) this;
        }

        public Criteria andMessageDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("message_description >=", value, "messageDescription");
            return (Criteria) this;
        }

        public Criteria andMessageDescriptionLessThan(String value) {
            addCriterion("message_description <", value, "messageDescription");
            return (Criteria) this;
        }

        public Criteria andMessageDescriptionLessThanOrEqualTo(String value) {
            addCriterion("message_description <=", value, "messageDescription");
            return (Criteria) this;
        }

        public Criteria andMessageDescriptionLike(String value) {
            addCriterion("message_description like", value, "messageDescription");
            return (Criteria) this;
        }

        public Criteria andMessageDescriptionNotLike(String value) {
            addCriterion("message_description not like", value, "messageDescription");
            return (Criteria) this;
        }

        public Criteria andMessageDescriptionIn(List<String> values) {
            addCriterion("message_description in", values, "messageDescription");
            return (Criteria) this;
        }

        public Criteria andMessageDescriptionNotIn(List<String> values) {
            addCriterion("message_description not in", values, "messageDescription");
            return (Criteria) this;
        }

        public Criteria andMessageDescriptionBetween(String value1, String value2) {
            addCriterion("message_description between", value1, value2, "messageDescription");
            return (Criteria) this;
        }

        public Criteria andMessageDescriptionNotBetween(String value1, String value2) {
            addCriterion("message_description not between", value1, value2, "messageDescription");
            return (Criteria) this;
        }

        public Criteria andMessageUseridIsNull() {
            addCriterion("message_userId is null");
            return (Criteria) this;
        }

        public Criteria andMessageUseridIsNotNull() {
            addCriterion("message_userId is not null");
            return (Criteria) this;
        }

        public Criteria andMessageUseridEqualTo(String value) {
            addCriterion("message_userId =", value, "messageUserid");
            return (Criteria) this;
        }

        public Criteria andMessageUseridNotEqualTo(String value) {
            addCriterion("message_userId <>", value, "messageUserid");
            return (Criteria) this;
        }

        public Criteria andMessageUseridGreaterThan(String value) {
            addCriterion("message_userId >", value, "messageUserid");
            return (Criteria) this;
        }

        public Criteria andMessageUseridGreaterThanOrEqualTo(String value) {
            addCriterion("message_userId >=", value, "messageUserid");
            return (Criteria) this;
        }

        public Criteria andMessageUseridLessThan(String value) {
            addCriterion("message_userId <", value, "messageUserid");
            return (Criteria) this;
        }

        public Criteria andMessageUseridLessThanOrEqualTo(String value) {
            addCriterion("message_userId <=", value, "messageUserid");
            return (Criteria) this;
        }

        public Criteria andMessageUseridLike(String value) {
            addCriterion("message_userId like", value, "messageUserid");
            return (Criteria) this;
        }

        public Criteria andMessageUseridNotLike(String value) {
            addCriterion("message_userId not like", value, "messageUserid");
            return (Criteria) this;
        }

        public Criteria andMessageUseridIn(List<String> values) {
            addCriterion("message_userId in", values, "messageUserid");
            return (Criteria) this;
        }

        public Criteria andMessageUseridNotIn(List<String> values) {
            addCriterion("message_userId not in", values, "messageUserid");
            return (Criteria) this;
        }

        public Criteria andMessageUseridBetween(String value1, String value2) {
            addCriterion("message_userId between", value1, value2, "messageUserid");
            return (Criteria) this;
        }

        public Criteria andMessageUseridNotBetween(String value1, String value2) {
            addCriterion("message_userId not between", value1, value2, "messageUserid");
            return (Criteria) this;
        }

        public Criteria andMessageCategotyidIsNull() {
            addCriterion("message_categotyId is null");
            return (Criteria) this;
        }

        public Criteria andMessageCategotyidIsNotNull() {
            addCriterion("message_categotyId is not null");
            return (Criteria) this;
        }

        public Criteria andMessageCategotyidEqualTo(Integer value) {
            addCriterion("message_categotyId =", value, "messageCategotyid");
            return (Criteria) this;
        }

        public Criteria andMessageCategotyidNotEqualTo(Integer value) {
            addCriterion("message_categotyId <>", value, "messageCategotyid");
            return (Criteria) this;
        }

        public Criteria andMessageCategotyidGreaterThan(Integer value) {
            addCriterion("message_categotyId >", value, "messageCategotyid");
            return (Criteria) this;
        }

        public Criteria andMessageCategotyidGreaterThanOrEqualTo(Integer value) {
            addCriterion("message_categotyId >=", value, "messageCategotyid");
            return (Criteria) this;
        }

        public Criteria andMessageCategotyidLessThan(Integer value) {
            addCriterion("message_categotyId <", value, "messageCategotyid");
            return (Criteria) this;
        }

        public Criteria andMessageCategotyidLessThanOrEqualTo(Integer value) {
            addCriterion("message_categotyId <=", value, "messageCategotyid");
            return (Criteria) this;
        }

        public Criteria andMessageCategotyidIn(List<Integer> values) {
            addCriterion("message_categotyId in", values, "messageCategotyid");
            return (Criteria) this;
        }

        public Criteria andMessageCategotyidNotIn(List<Integer> values) {
            addCriterion("message_categotyId not in", values, "messageCategotyid");
            return (Criteria) this;
        }

        public Criteria andMessageCategotyidBetween(Integer value1, Integer value2) {
            addCriterion("message_categotyId between", value1, value2, "messageCategotyid");
            return (Criteria) this;
        }

        public Criteria andMessageCategotyidNotBetween(Integer value1, Integer value2) {
            addCriterion("message_categotyId not between", value1, value2, "messageCategotyid");
            return (Criteria) this;
        }

        public Criteria andMessageDateIsNull() {
            addCriterion("message_date is null");
            return (Criteria) this;
        }

        public Criteria andMessageDateIsNotNull() {
            addCriterion("message_date is not null");
            return (Criteria) this;
        }

        public Criteria andMessageDateEqualTo(Date value) {
            addCriterionForJDBCDate("message_date =", value, "messageDate");
            return (Criteria) this;
        }

        public Criteria andMessageDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("message_date <>", value, "messageDate");
            return (Criteria) this;
        }

        public Criteria andMessageDateGreaterThan(Date value) {
            addCriterionForJDBCDate("message_date >", value, "messageDate");
            return (Criteria) this;
        }

        public Criteria andMessageDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("message_date >=", value, "messageDate");
            return (Criteria) this;
        }

        public Criteria andMessageDateLessThan(Date value) {
            addCriterionForJDBCDate("message_date <", value, "messageDate");
            return (Criteria) this;
        }

        public Criteria andMessageDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("message_date <=", value, "messageDate");
            return (Criteria) this;
        }

        public Criteria andMessageDateIn(List<Date> values) {
            addCriterionForJDBCDate("message_date in", values, "messageDate");
            return (Criteria) this;
        }

        public Criteria andMessageDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("message_date not in", values, "messageDate");
            return (Criteria) this;
        }

        public Criteria andMessageDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("message_date between", value1, value2, "messageDate");
            return (Criteria) this;
        }

        public Criteria andMessageDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("message_date not between", value1, value2, "messageDate");
            return (Criteria) this;
        }

        public Criteria andMessagePhotoIsNull() {
            addCriterion("message_photo is null");
            return (Criteria) this;
        }

        public Criteria andMessagePhotoIsNotNull() {
            addCriterion("message_photo is not null");
            return (Criteria) this;
        }

        public Criteria andMessagePhotoEqualTo(String value) {
            addCriterion("message_photo =", value, "messagePhoto");
            return (Criteria) this;
        }

        public Criteria andMessagePhotoNotEqualTo(String value) {
            addCriterion("message_photo <>", value, "messagePhoto");
            return (Criteria) this;
        }

        public Criteria andMessagePhotoGreaterThan(String value) {
            addCriterion("message_photo >", value, "messagePhoto");
            return (Criteria) this;
        }

        public Criteria andMessagePhotoGreaterThanOrEqualTo(String value) {
            addCriterion("message_photo >=", value, "messagePhoto");
            return (Criteria) this;
        }

        public Criteria andMessagePhotoLessThan(String value) {
            addCriterion("message_photo <", value, "messagePhoto");
            return (Criteria) this;
        }

        public Criteria andMessagePhotoLessThanOrEqualTo(String value) {
            addCriterion("message_photo <=", value, "messagePhoto");
            return (Criteria) this;
        }

        public Criteria andMessagePhotoLike(String value) {
            addCriterion("message_photo like", value, "messagePhoto");
            return (Criteria) this;
        }

        public Criteria andMessagePhotoNotLike(String value) {
            addCriterion("message_photo not like", value, "messagePhoto");
            return (Criteria) this;
        }

        public Criteria andMessagePhotoIn(List<String> values) {
            addCriterion("message_photo in", values, "messagePhoto");
            return (Criteria) this;
        }

        public Criteria andMessagePhotoNotIn(List<String> values) {
            addCriterion("message_photo not in", values, "messagePhoto");
            return (Criteria) this;
        }

        public Criteria andMessagePhotoBetween(String value1, String value2) {
            addCriterion("message_photo between", value1, value2, "messagePhoto");
            return (Criteria) this;
        }

        public Criteria andMessagePhotoNotBetween(String value1, String value2) {
            addCriterion("message_photo not between", value1, value2, "messagePhoto");
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