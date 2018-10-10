package com.project.fastfood.entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "order_detail", schema = "food_and_drink", catalog = "")
public class OrderDetailEntity {
    private Integer idOrderDetail;
    private Double price;
    private Integer quantity;
    private Timestamp createAt;
    private Timestamp updateAt;
    private Timestamp deleteAt;
    private Integer deleteFlag;
    private OrdersEntity order;
    private ProductsEntity product;

    @Id
    @Column(name = "id_order_detail", nullable = false)
    public Integer getIdOrderDetail() {
        return idOrderDetail;
    }

    public void setIdOrderDetail(Integer idOrderDetail) {
        this.idOrderDetail = idOrderDetail;
    }

    @Basic
    @Column(name = "price", nullable = true, precision = 0)
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Basic
    @Column(name = "quantity", nullable = true)
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Basic
    @Column(name = "create_at", nullable = true)
    public Timestamp getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Timestamp createAt) {
        this.createAt = createAt;
    }

    @Basic
    @Column(name = "update_at", nullable = true)
    public Timestamp getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Timestamp updateAt) {
        this.updateAt = updateAt;
    }

    @Basic
    @Column(name = "delete_at", nullable = true)
    public Timestamp getDeleteAt() {
        return deleteAt;
    }

    public void setDeleteAt(Timestamp deleteAt) {
        this.deleteAt = deleteAt;
    }

    @Basic
    @Column(name = "delete_flag", nullable = true)
    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDetailEntity that = (OrderDetailEntity) o;
        return Objects.equals(idOrderDetail, that.idOrderDetail) &&
                Objects.equals(price, that.price) &&
                Objects.equals(quantity, that.quantity) &&
                Objects.equals(createAt, that.createAt) &&
                Objects.equals(updateAt, that.updateAt) &&
                Objects.equals(deleteAt, that.deleteAt) &&
                Objects.equals(deleteFlag, that.deleteFlag);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idOrderDetail, price, quantity, createAt, updateAt, deleteAt, deleteFlag);
    }

    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "id_order")
    public OrdersEntity getOrder() {
        return order;
    }

    public void setOrder(OrdersEntity order) {
        this.order = order;
    }

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id_product")
    public ProductsEntity getProduct() {
        return product;
    }

    public void setProduct(ProductsEntity product) {
        this.product = product;
    }
}