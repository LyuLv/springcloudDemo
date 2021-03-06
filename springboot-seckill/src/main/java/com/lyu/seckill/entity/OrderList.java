package com.lyu.seckill.entity;

import java.io.Serializable;

public class OrderList  implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_order_list.id
     *
     * @mbggenerated
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_order_list.stock_id
     *
     * @mbggenerated
     */
    private String stockId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_order_list.user_name
     *
     * @mbggenerated
     */
    private String userName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_order_list.stock_number
     *
     * @mbggenerated
     */
    private Long stockNumber;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_order_list.id
     *
     * @return the value of t_order_list.id
     *
     * @mbggenerated
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_order_list.id
     *
     * @param id the value for t_order_list.id
     *
     * @mbggenerated
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_order_list.stock_id
     *
     * @return the value of t_order_list.stock_id
     *
     * @mbggenerated
     */
    public String getStockId() {
        return stockId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_order_list.stock_id
     *
     * @param stockId the value for t_order_list.stock_id
     *
     * @mbggenerated
     */
    public void setStockId(String stockId) {
        this.stockId = stockId == null ? null : stockId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_order_list.user_name
     *
     * @return the value of t_order_list.user_name
     *
     * @mbggenerated
     */
    public String getUserName() {
        return userName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_order_list.user_name
     *
     * @param userName the value for t_order_list.user_name
     *
     * @mbggenerated
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_order_list.stock_number
     *
     * @return the value of t_order_list.stock_number
     *
     * @mbggenerated
     */
    public Long getStockNumber() {
        return stockNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_order_list.stock_number
     *
     * @param stockNumber the value for t_order_list.stock_number
     *
     * @mbggenerated
     */
    public void setStockNumber(Long stockNumber) {
        this.stockNumber = stockNumber;
    }
}