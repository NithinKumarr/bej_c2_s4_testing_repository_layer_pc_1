package org.niit.Course13_S3_PC_1.domain;

public class Customer {
    private int customerId;
    private String customerName;
    private Long customerPhoneNo;
    private Product customerProduct;

    public Customer() {
    }

    public Customer(int customerId, String customerName, Long customerPhoneNo, Product customerProduct) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerPhoneNo = customerPhoneNo;
        this.customerProduct = customerProduct;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Long getCustomerPhoneNo() {
        return customerPhoneNo;
    }

    public void setCustomerPhoneNo(Long customerPhoneNo) {
        this.customerPhoneNo = customerPhoneNo;
    }

    public Product getCustomerProduct() {
        return customerProduct;
    }

    public void setCustomerProduct(Product customerProduct) {
        this.customerProduct = customerProduct;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", customerPhoneNo=" + customerPhoneNo +
                ", customerProduct=" + customerProduct +
                '}';
    }
}
