/**
 * Copyright 2016 ECCloud Corporation. All rights reserved.
 *
 * --------------------------------------------------------
 * 此技术信息为本公司机密信息，未经本公司书面同意禁止向第三方披露.
 * 版权所有：贝恩国际
 * --------------------------------------------------------
 */

package com.omgz.search.entity;

import com.omgz.search.core.SolrEnum;
import com.omgz.search.core.SolrField;

public class FrankOrderEntity {
    
    private Integer id; //主键id
    @SolrField(key=SolrEnum.KEY,field=SolrEnum.FIELD)
    private Integer orderId;//提单id 
    @SolrField(field=SolrEnum.FIELD)
    private String orderNo;//提单编号
    @SolrField(field=SolrEnum.FIELD)
    private String proDesc;//提单描述
    @SolrField(field=SolrEnum.FIELD)
    private String buniess;//采购商
    @SolrField(field=SolrEnum.FIELD)
    private String supplier;//供应商 
    @SolrField(field=SolrEnum.FIELD)
    private String tongzhiren;//通知人
    @SolrField(field=SolrEnum.FIELD)
    private String startDate;//起始日期
    @SolrField(field=SolrEnum.FIELD)
    private String endDate;//截止日期
    @SolrField(field=SolrEnum.FIELD)
    private String orginierCountry;//原产国
    @SolrField(field=SolrEnum.FIELD)
    private String mudiPort;//目的港
    @SolrField(field=SolrEnum.FIELD)
    private String arrideDate;//到岗日期
    @SolrField(field=SolrEnum.FIELD)
    private String qiyunPort;//起运港
    @SolrField(field=SolrEnum.FIELD)
    private String orderWeight;//提单重量
    @SolrField(field=SolrEnum.FIELD)
    private String countryName;
    
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getOrderId() {
        return orderId;
    }
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }
    public String getOrderNo() {
        return orderNo;
    }
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }
    
    public String getBuniess() {
        return buniess;
    }
    public void setBuniess(String buniess) {
        this.buniess = buniess;
    }
    public String getSupplier() {
        return supplier;
    }
    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }
    public String getTongzhiren() {
        return tongzhiren;
    }
    public void setTongzhiren(String tongzhiren) {
        this.tongzhiren = tongzhiren;
    }
    public String getStartDate() {
        return startDate;
    }
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
    public String getEndDate() {
        return endDate;
    }
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
    public String getOrginierCountry() {
        return orginierCountry;
    }
    public void setOrginierCountry(String orginierCountry) {
        this.orginierCountry = orginierCountry;
    }
    public String getMudiPort() {
        return mudiPort;
    }
    public void setMudiPort(String mudiPort) {
        this.mudiPort = mudiPort;
    }
    public String getArrideDate() {
        return arrideDate;
    }
    public void setArrideDate(String arrideDate) {
        this.arrideDate = arrideDate;
    }
    public String getQiyunPort() {
        return qiyunPort;
    }
    public void setQiyunPort(String qiyunPort) {
        this.qiyunPort = qiyunPort;
    }
    public String getOrderWeight() {
        return orderWeight;
    }
    public void setOrderWeight(String orderWeight) {
        this.orderWeight = orderWeight;
    }
    public String getCountryName() {
        return countryName;
    }
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
    public String getProDesc() {
        return proDesc;
    }
    public void setProDesc(String proDesc) {
        this.proDesc = proDesc;
    }
    
    
    
    
}
