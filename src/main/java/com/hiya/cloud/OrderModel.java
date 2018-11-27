package com.hiya.cloud;

import java.io.Serializable;

public class OrderModel implements Serializable
{
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String name;
    private String shop;
    private String good;

    public OrderModel()
    {
    }
    
    public OrderModel(Integer id, String name, String shop, String good)
    {
        super();
        this.id = id;
        this.name = name;
        this.shop = shop;
        this.good = good;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getShop()
    {
        return shop;
    }

    public void setShop(String shop)
    {
        this.shop = shop;
    }

    public String getGood()
    {
        return good;
    }

    public void setGood(String good)
    {
        this.good = good;
    }

}
