package top.cyanide.GRMS.pojo;

public class Order {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column orders.order_id
     *
     * @mbg.generated Tue Mar 23 17:42:50 CST 2021
     */
    private Integer orderId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column orders.user_id
     *
     * @mbg.generated Tue Mar 23 17:42:50 CST 2021
     */
    private Integer userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column orders.product_id
     *
     * @mbg.generated Tue Mar 23 17:42:50 CST 2021
     */
    private Integer productId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column orders.product_name
     *
     * @mbg.generated Tue Mar 23 17:42:50 CST 2021
     */
    private String productName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column orders.add_to_cart_order
     *
     * @mbg.generated Tue Mar 23 17:42:50 CST 2021
     */
    private Integer addToCartOrder;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column orders.reordered
     *
     * @mbg.generated Tue Mar 23 17:42:50 CST 2021
     */
    private Integer reordered;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column orders.order_number
     *
     * @mbg.generated Tue Mar 23 17:42:50 CST 2021
     */
    private Integer orderNumber;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column orders.order_dow
     *
     * @mbg.generated Tue Mar 23 17:42:50 CST 2021
     */
    private Integer orderDow;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column orders.order_hour_of_day
     *
     * @mbg.generated Tue Mar 23 17:42:50 CST 2021
     */
    private Integer orderHourOfDay;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column orders.days_since_prior_order
     *
     * @mbg.generated Tue Mar 23 17:42:50 CST 2021
     */
    private Float daysSincePriorOrder;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column orders.order_id
     *
     * @return the value of orders.order_id
     *
     * @mbg.generated Tue Mar 23 17:42:50 CST 2021
     */
    public Integer getOrderId() {
        return orderId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column orders.order_id
     *
     * @param orderId the value for orders.order_id
     *
     * @mbg.generated Tue Mar 23 17:42:50 CST 2021
     */
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column orders.user_id
     *
     * @return the value of orders.user_id
     *
     * @mbg.generated Tue Mar 23 17:42:50 CST 2021
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column orders.user_id
     *
     * @param userId the value for orders.user_id
     *
     * @mbg.generated Tue Mar 23 17:42:50 CST 2021
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column orders.product_id
     *
     * @return the value of orders.product_id
     *
     * @mbg.generated Tue Mar 23 17:42:50 CST 2021
     */
    public Integer getProductId() {
        return productId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column orders.product_id
     *
     * @param productId the value for orders.product_id
     *
     * @mbg.generated Tue Mar 23 17:42:50 CST 2021
     */
    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column orders.product_name
     *
     * @return the value of orders.product_name
     *
     * @mbg.generated Tue Mar 23 17:42:50 CST 2021
     */
    public String getProductName() {
        return productName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column orders.product_name
     *
     * @param productName the value for orders.product_name
     *
     * @mbg.generated Tue Mar 23 17:42:50 CST 2021
     */
    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column orders.add_to_cart_order
     *
     * @return the value of orders.add_to_cart_order
     *
     * @mbg.generated Tue Mar 23 17:42:50 CST 2021
     */
    public Integer getAddToCartOrder() {
        return addToCartOrder;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column orders.add_to_cart_order
     *
     * @param addToCartOrder the value for orders.add_to_cart_order
     *
     * @mbg.generated Tue Mar 23 17:42:50 CST 2021
     */
    public void setAddToCartOrder(Integer addToCartOrder) {
        this.addToCartOrder = addToCartOrder;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column orders.reordered
     *
     * @return the value of orders.reordered
     *
     * @mbg.generated Tue Mar 23 17:42:50 CST 2021
     */
    public Integer getReordered() {
        return reordered;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column orders.reordered
     *
     * @param reordered the value for orders.reordered
     *
     * @mbg.generated Tue Mar 23 17:42:50 CST 2021
     */
    public void setReordered(Integer reordered) {
        this.reordered = reordered;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column orders.order_number
     *
     * @return the value of orders.order_number
     *
     * @mbg.generated Tue Mar 23 17:42:50 CST 2021
     */
    public Integer getOrderNumber() {
        return orderNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column orders.order_number
     *
     * @param orderNumber the value for orders.order_number
     *
     * @mbg.generated Tue Mar 23 17:42:50 CST 2021
     */
    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column orders.order_dow
     *
     * @return the value of orders.order_dow
     *
     * @mbg.generated Tue Mar 23 17:42:50 CST 2021
     */
    public Integer getOrderDow() {
        return orderDow;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column orders.order_dow
     *
     * @param orderDow the value for orders.order_dow
     *
     * @mbg.generated Tue Mar 23 17:42:50 CST 2021
     */
    public void setOrderDow(Integer orderDow) {
        this.orderDow = orderDow;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column orders.order_hour_of_day
     *
     * @return the value of orders.order_hour_of_day
     *
     * @mbg.generated Tue Mar 23 17:42:50 CST 2021
     */
    public Integer getOrderHourOfDay() {
        return orderHourOfDay;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column orders.order_hour_of_day
     *
     * @param orderHourOfDay the value for orders.order_hour_of_day
     *
     * @mbg.generated Tue Mar 23 17:42:50 CST 2021
     */
    public void setOrderHourOfDay(Integer orderHourOfDay) {
        this.orderHourOfDay = orderHourOfDay;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column orders.days_since_prior_order
     *
     * @return the value of orders.days_since_prior_order
     *
     * @mbg.generated Tue Mar 23 17:42:50 CST 2021
     */
    public Float getDaysSincePriorOrder() {
        return daysSincePriorOrder;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column orders.days_since_prior_order
     *
     * @param daysSincePriorOrder the value for orders.days_since_prior_order
     *
     * @mbg.generated Tue Mar 23 17:42:50 CST 2021
     */
    public void setDaysSincePriorOrder(Float daysSincePriorOrder) {
        this.daysSincePriorOrder = daysSincePriorOrder;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orders
     *
     * @mbg.generated Tue Mar 23 17:42:50 CST 2021
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", orderId=").append(orderId);
        sb.append(", userId=").append(userId);
        sb.append(", productId=").append(productId);
        sb.append(", productName=").append(productName);
        sb.append(", addToCartOrder=").append(addToCartOrder);
        sb.append(", reordered=").append(reordered);
        sb.append(", orderNumber=").append(orderNumber);
        sb.append(", orderDow=").append(orderDow);
        sb.append(", orderHourOfDay=").append(orderHourOfDay);
        sb.append(", daysSincePriorOrder=").append(daysSincePriorOrder);
        sb.append("]");
        return sb.toString();
    }
}