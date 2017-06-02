/*
 * Copyright 2012-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.aleggeup.inventory;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;

@Entity
public class Product {

    @Id
    // @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column
    private Integer sku;

    @Column
    private String name;

    @Column
    private Double price;

    @Column
    private Double mrp;

    @Column
    private String description;

    @Column
    private String packing;

    @Column
    private String image;

    @Column
    private Integer category;

    @Column
    private Integer stock;

    @Column
    private String status;

    protected Product() {}

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public Integer getSku() {
        return sku;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public Double getMrp() {
        return mrp;
    }

    public String getDescription() {
        return description;
    }

    public String getPacking() {
        return packing;
    }

    public String getImage() {
        return image;
    }

    public Integer getCategory() {
        return category;
    }

    public Integer getStock() {
        return stock;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

    public Product(final Long id, final Integer sku, final String name, final Double price, final Double mrp, final String description,
                   final String packing, final String image, final Integer category, final Integer stock, final String status) {
        this.id = id;
        this.sku = sku;
        this.name = name;
        this.price = price;
        this.mrp = mrp;
        this.description = description;
        this.packing = packing;
        this.image = image;
        this.category = category;
        this.stock = stock;
        this.status = status;
    }

    @Override
    public String toString() {
        return String.format(
            "Product[id=%d, sku=%d, name='%s', price=%.2f, mrp=%.2f, description='%s', packing='%s', image='%s', category=%d, stock=%d, status='%s']",
            this.id, this.sku, this.name, this.price, this.mrp, this.description, this.packing, this.image, this.category, this.stock, this.status);
    }
}
