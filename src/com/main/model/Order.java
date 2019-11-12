package com.main.model;

public class Order {
   private String id;
   private String name;
   private String address;
   private String orderStatus;
   private Integer noOfBricks;
   
   public Order(String id, String name, String address,  String orderStatus, Integer noOfBricks){
    this.id = id;
    this.name = name;
    this.address = address;
    this.orderStatus = orderStatus;
    this.noOfBricks = noOfBricks;
   }

   public String getId() {
      return id;
   }
   public void setId(String id) {
      this.id = id;
   }
   public String getName() {
      return name;
   }
   public void setName(String name) {
      this.name = name;
   }
    public String getAddress() {
      return address;
   }
   public void setAddress(String address) {
      this.address = address;
   }
    public String getOrderStatus() {
      return orderStatus;
   }
   public void setOrderStatus(String orderStatus) {
      this.orderStatus = orderStatus;
   }
    public String getNoOfBricks() {
      return noOfBricks;
   }
   public void setNoOfBricks(Integer noOfBricks) {
      this.noOfBricks = noOfBricks;
   }
}
