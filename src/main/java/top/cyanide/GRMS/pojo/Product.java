package top.cyanide.GRMS.pojo;

public class Product {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column products.product_id
     *
     * @mbg.generated Tue Mar 23 17:42:50 CST 2021
     */
    private Integer productId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column products.product_name
     *
     * @mbg.generated Tue Mar 23 17:42:50 CST 2021
     */
    private String productName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column products.department_id
     *
     * @mbg.generated Tue Mar 23 17:42:50 CST 2021
     */
    private Integer departmentId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column products.department
     *
     * @mbg.generated Tue Mar 23 17:42:50 CST 2021
     */
    private String department;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column products.aisle_id
     *
     * @mbg.generated Tue Mar 23 17:42:50 CST 2021
     */
    private Integer aisleId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column products.aisle
     *
     * @mbg.generated Tue Mar 23 17:42:50 CST 2021
     */
    private String aisle;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column products.product_id
     *
     * @return the value of products.product_id
     *
     * @mbg.generated Tue Mar 23 17:42:50 CST 2021
     */
    public Integer getProductId() {
        return productId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column products.product_id
     *
     * @param productId the value for products.product_id
     *
     * @mbg.generated Tue Mar 23 17:42:50 CST 2021
     */
    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column products.product_name
     *
     * @return the value of products.product_name
     *
     * @mbg.generated Tue Mar 23 17:42:50 CST 2021
     */
    public String getProductName() {
        return productName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column products.product_name
     *
     * @param productName the value for products.product_name
     *
     * @mbg.generated Tue Mar 23 17:42:50 CST 2021
     */
    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column products.department_id
     *
     * @return the value of products.department_id
     *
     * @mbg.generated Tue Mar 23 17:42:50 CST 2021
     */
    public Integer getDepartmentId() {
        return departmentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column products.department_id
     *
     * @param departmentId the value for products.department_id
     *
     * @mbg.generated Tue Mar 23 17:42:50 CST 2021
     */
    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column products.department
     *
     * @return the value of products.department
     *
     * @mbg.generated Tue Mar 23 17:42:50 CST 2021
     */
    public String getDepartment() {
        return department;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column products.department
     *
     * @param department the value for products.department
     *
     * @mbg.generated Tue Mar 23 17:42:50 CST 2021
     */
    public void setDepartment(String department) {
        this.department = department == null ? null : department.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column products.aisle_id
     *
     * @return the value of products.aisle_id
     *
     * @mbg.generated Tue Mar 23 17:42:50 CST 2021
     */
    public Integer getAisleId() {
        return aisleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column products.aisle_id
     *
     * @param aisleId the value for products.aisle_id
     *
     * @mbg.generated Tue Mar 23 17:42:50 CST 2021
     */
    public void setAisleId(Integer aisleId) {
        this.aisleId = aisleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column products.aisle
     *
     * @return the value of products.aisle
     *
     * @mbg.generated Tue Mar 23 17:42:50 CST 2021
     */
    public String getAisle() {
        return aisle;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column products.aisle
     *
     * @param aisle the value for products.aisle
     *
     * @mbg.generated Tue Mar 23 17:42:50 CST 2021
     */
    public void setAisle(String aisle) {
        this.aisle = aisle == null ? null : aisle.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table products
     *
     * @mbg.generated Tue Mar 23 17:42:50 CST 2021
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", productId=").append(productId);
        sb.append(", productName=").append(productName);
        sb.append(", departmentId=").append(departmentId);
        sb.append(", department=").append(department);
        sb.append(", aisleId=").append(aisleId);
        sb.append(", aisle=").append(aisle);
        sb.append("]");
        return sb.toString();
    }
}