package edu.njxz.lostandfound.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class CommentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CommentExample() {
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

        public Criteria andCommentIdIsNull() {
            addCriterion("comment_id is null");
            return (Criteria) this;
        }

        public Criteria andCommentIdIsNotNull() {
            addCriterion("comment_id is not null");
            return (Criteria) this;
        }

        public Criteria andCommentIdEqualTo(Integer value) {
            addCriterion("comment_id =", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdNotEqualTo(Integer value) {
            addCriterion("comment_id <>", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdGreaterThan(Integer value) {
            addCriterion("comment_id >", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("comment_id >=", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdLessThan(Integer value) {
            addCriterion("comment_id <", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdLessThanOrEqualTo(Integer value) {
            addCriterion("comment_id <=", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdIn(List<Integer> values) {
            addCriterion("comment_id in", values, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdNotIn(List<Integer> values) {
            addCriterion("comment_id not in", values, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdBetween(Integer value1, Integer value2) {
            addCriterion("comment_id between", value1, value2, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("comment_id not between", value1, value2, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentContentIsNull() {
            addCriterion("comment_content is null");
            return (Criteria) this;
        }

        public Criteria andCommentContentIsNotNull() {
            addCriterion("comment_content is not null");
            return (Criteria) this;
        }

        public Criteria andCommentContentEqualTo(String value) {
            addCriterion("comment_content =", value, "commentContent");
            return (Criteria) this;
        }

        public Criteria andCommentContentNotEqualTo(String value) {
            addCriterion("comment_content <>", value, "commentContent");
            return (Criteria) this;
        }

        public Criteria andCommentContentGreaterThan(String value) {
            addCriterion("comment_content >", value, "commentContent");
            return (Criteria) this;
        }

        public Criteria andCommentContentGreaterThanOrEqualTo(String value) {
            addCriterion("comment_content >=", value, "commentContent");
            return (Criteria) this;
        }

        public Criteria andCommentContentLessThan(String value) {
            addCriterion("comment_content <", value, "commentContent");
            return (Criteria) this;
        }

        public Criteria andCommentContentLessThanOrEqualTo(String value) {
            addCriterion("comment_content <=", value, "commentContent");
            return (Criteria) this;
        }

        public Criteria andCommentContentLike(String value) {
            addCriterion("comment_content like", value, "commentContent");
            return (Criteria) this;
        }

        public Criteria andCommentContentNotLike(String value) {
            addCriterion("comment_content not like", value, "commentContent");
            return (Criteria) this;
        }

        public Criteria andCommentContentIn(List<String> values) {
            addCriterion("comment_content in", values, "commentContent");
            return (Criteria) this;
        }

        public Criteria andCommentContentNotIn(List<String> values) {
            addCriterion("comment_content not in", values, "commentContent");
            return (Criteria) this;
        }

        public Criteria andCommentContentBetween(String value1, String value2) {
            addCriterion("comment_content between", value1, value2, "commentContent");
            return (Criteria) this;
        }

        public Criteria andCommentContentNotBetween(String value1, String value2) {
            addCriterion("comment_content not between", value1, value2, "commentContent");
            return (Criteria) this;
        }

        public Criteria andCommentUseridIsNull() {
            addCriterion("comment_userId is null");
            return (Criteria) this;
        }

        public Criteria andCommentUseridIsNotNull() {
            addCriterion("comment_userId is not null");
            return (Criteria) this;
        }

        public Criteria andCommentUseridEqualTo(String value) {
            addCriterion("comment_userId =", value, "commentUserid");
            return (Criteria) this;
        }

        public Criteria andCommentUseridNotEqualTo(String value) {
            addCriterion("comment_userId <>", value, "commentUserid");
            return (Criteria) this;
        }

        public Criteria andCommentUseridGreaterThan(String value) {
            addCriterion("comment_userId >", value, "commentUserid");
            return (Criteria) this;
        }

        public Criteria andCommentUseridGreaterThanOrEqualTo(String value) {
            addCriterion("comment_userId >=", value, "commentUserid");
            return (Criteria) this;
        }

        public Criteria andCommentUseridLessThan(String value) {
            addCriterion("comment_userId <", value, "commentUserid");
            return (Criteria) this;
        }

        public Criteria andCommentUseridLessThanOrEqualTo(String value) {
            addCriterion("comment_userId <=", value, "commentUserid");
            return (Criteria) this;
        }

        public Criteria andCommentUseridLike(String value) {
            addCriterion("comment_userId like", value, "commentUserid");
            return (Criteria) this;
        }

        public Criteria andCommentUseridNotLike(String value) {
            addCriterion("comment_userId not like", value, "commentUserid");
            return (Criteria) this;
        }

        public Criteria andCommentUseridIn(List<String> values) {
            addCriterion("comment_userId in", values, "commentUserid");
            return (Criteria) this;
        }

        public Criteria andCommentUseridNotIn(List<String> values) {
            addCriterion("comment_userId not in", values, "commentUserid");
            return (Criteria) this;
        }

        public Criteria andCommentUseridBetween(String value1, String value2) {
            addCriterion("comment_userId between", value1, value2, "commentUserid");
            return (Criteria) this;
        }

        public Criteria andCommentUseridNotBetween(String value1, String value2) {
            addCriterion("comment_userId not between", value1, value2, "commentUserid");
            return (Criteria) this;
        }

        public Criteria andCommentMessageidIsNull() {
            addCriterion("comment_messageId is null");
            return (Criteria) this;
        }

        public Criteria andCommentMessageidIsNotNull() {
            addCriterion("comment_messageId is not null");
            return (Criteria) this;
        }

        public Criteria andCommentMessageidEqualTo(Integer value) {
            addCriterion("comment_messageId =", value, "commentMessageid");
            return (Criteria) this;
        }

        public Criteria andCommentMessageidNotEqualTo(Integer value) {
            addCriterion("comment_messageId <>", value, "commentMessageid");
            return (Criteria) this;
        }

        public Criteria andCommentMessageidGreaterThan(Integer value) {
            addCriterion("comment_messageId >", value, "commentMessageid");
            return (Criteria) this;
        }

        public Criteria andCommentMessageidGreaterThanOrEqualTo(Integer value) {
            addCriterion("comment_messageId >=", value, "commentMessageid");
            return (Criteria) this;
        }

        public Criteria andCommentMessageidLessThan(Integer value) {
            addCriterion("comment_messageId <", value, "commentMessageid");
            return (Criteria) this;
        }

        public Criteria andCommentMessageidLessThanOrEqualTo(Integer value) {
            addCriterion("comment_messageId <=", value, "commentMessageid");
            return (Criteria) this;
        }

        public Criteria andCommentMessageidIn(List<Integer> values) {
            addCriterion("comment_messageId in", values, "commentMessageid");
            return (Criteria) this;
        }

        public Criteria andCommentMessageidNotIn(List<Integer> values) {
            addCriterion("comment_messageId not in", values, "commentMessageid");
            return (Criteria) this;
        }

        public Criteria andCommentMessageidBetween(Integer value1, Integer value2) {
            addCriterion("comment_messageId between", value1, value2, "commentMessageid");
            return (Criteria) this;
        }

        public Criteria andCommentMessageidNotBetween(Integer value1, Integer value2) {
            addCriterion("comment_messageId not between", value1, value2, "commentMessageid");
            return (Criteria) this;
        }

        public Criteria andCommentDateIsNull() {
            addCriterion("comment_date is null");
            return (Criteria) this;
        }

        public Criteria andCommentDateIsNotNull() {
            addCriterion("comment_date is not null");
            return (Criteria) this;
        }

        public Criteria andCommentDateEqualTo(Date value) {
            addCriterionForJDBCDate("comment_date =", value, "commentDate");
            return (Criteria) this;
        }

        public Criteria andCommentDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("comment_date <>", value, "commentDate");
            return (Criteria) this;
        }

        public Criteria andCommentDateGreaterThan(Date value) {
            addCriterionForJDBCDate("comment_date >", value, "commentDate");
            return (Criteria) this;
        }

        public Criteria andCommentDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("comment_date >=", value, "commentDate");
            return (Criteria) this;
        }

        public Criteria andCommentDateLessThan(Date value) {
            addCriterionForJDBCDate("comment_date <", value, "commentDate");
            return (Criteria) this;
        }

        public Criteria andCommentDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("comment_date <=", value, "commentDate");
            return (Criteria) this;
        }

        public Criteria andCommentDateIn(List<Date> values) {
            addCriterionForJDBCDate("comment_date in", values, "commentDate");
            return (Criteria) this;
        }

        public Criteria andCommentDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("comment_date not in", values, "commentDate");
            return (Criteria) this;
        }

        public Criteria andCommentDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("comment_date between", value1, value2, "commentDate");
            return (Criteria) this;
        }

        public Criteria andCommentDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("comment_date not between", value1, value2, "commentDate");
            return (Criteria) this;
        }

        public Criteria andCommentSubmitCountIsNull() {
            addCriterion("comment_submit_count is null");
            return (Criteria) this;
        }

        public Criteria andCommentSubmitCountIsNotNull() {
            addCriterion("comment_submit_count is not null");
            return (Criteria) this;
        }

        public Criteria andCommentSubmitCountEqualTo(Integer value) {
            addCriterion("comment_submit_count =", value, "commentSubmitCount");
            return (Criteria) this;
        }

        public Criteria andCommentSubmitCountNotEqualTo(Integer value) {
            addCriterion("comment_submit_count <>", value, "commentSubmitCount");
            return (Criteria) this;
        }

        public Criteria andCommentSubmitCountGreaterThan(Integer value) {
            addCriterion("comment_submit_count >", value, "commentSubmitCount");
            return (Criteria) this;
        }

        public Criteria andCommentSubmitCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("comment_submit_count >=", value, "commentSubmitCount");
            return (Criteria) this;
        }

        public Criteria andCommentSubmitCountLessThan(Integer value) {
            addCriterion("comment_submit_count <", value, "commentSubmitCount");
            return (Criteria) this;
        }

        public Criteria andCommentSubmitCountLessThanOrEqualTo(Integer value) {
            addCriterion("comment_submit_count <=", value, "commentSubmitCount");
            return (Criteria) this;
        }

        public Criteria andCommentSubmitCountIn(List<Integer> values) {
            addCriterion("comment_submit_count in", values, "commentSubmitCount");
            return (Criteria) this;
        }

        public Criteria andCommentSubmitCountNotIn(List<Integer> values) {
            addCriterion("comment_submit_count not in", values, "commentSubmitCount");
            return (Criteria) this;
        }

        public Criteria andCommentSubmitCountBetween(Integer value1, Integer value2) {
            addCriterion("comment_submit_count between", value1, value2, "commentSubmitCount");
            return (Criteria) this;
        }

        public Criteria andCommentSubmitCountNotBetween(Integer value1, Integer value2) {
            addCriterion("comment_submit_count not between", value1, value2, "commentSubmitCount");
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