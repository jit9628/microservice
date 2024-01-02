package com.order.orderservice.pojo;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class Data{
    public int pid;
    public String productname;
    public int quantity;
    public Date createddate;
    private int categoryid;

}
