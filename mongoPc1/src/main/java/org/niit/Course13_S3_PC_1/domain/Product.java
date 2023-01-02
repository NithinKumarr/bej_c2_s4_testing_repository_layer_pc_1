package org.niit.Course13_S3_PC_1.domain;

public class Product {
    private int productId;
    private String ProductName;
    private String productDescription;

    public Product() {
    }

    public Product(int productId, String productName, String productDescription) {
        this.productId = productId;
        ProductName = productName;
        this.productDescription = productDescription;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", ProductName='" + ProductName + '\'' +
                ", productDescription='" + productDescription + '\'' +
                '}';
    }
}
