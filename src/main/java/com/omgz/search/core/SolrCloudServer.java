/**
 * Copyright 2016 ECCloud Corporation. All rights reserved.
 *
 * --------------------------------------------------------
 * 此技术信息为本公司机密信息，未经本公司书面同意禁止向第三方披露.
 * 版权所有：深圳市慧众云商科技有限公司
 * --------------------------------------------------------
 */

package com.omgz.search.core;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.springframework.beans.factory.annotation.Value;

/**
 * 
 * 文  件  名:SolrCloudServer<br/>  
 * 文件描述:<br/>  
 * 修  改  人: 詹昌高 <br/>
 * 修改日期:2016年12月6日<br/>
 * 修改内容:<br/>
 */
public class SolrCloudServer {
	
    /*** 商品缓存url****/
//	private static String SOLR_SERVER_GOODS_URL="http://192.168.1.147:8089/solr/goods";//本地
	
	private static String SOLR_SERVER_GOODS_URL="http://120.77.64.98:8002/solr/goods";//服务器
	
	private static String SOLR_wm_product_URL="http://120.77.64.98:8002/solr/wm_product";//服务器
	
	private static String SOLR_WM_SUPPLIER_URL="http://120.77.64.98:8002/solr/supplier_usa2016";//服务器
	
	private static String SOLR_WM_BUSINESS_URL="http://120.77.64.98:8002/solr/businesses_usa2016";//服务器
	//提单服务地址
    private static String SOLR_FRANKLY_ORDER="http://120.77.64.98:8002/solr/frankorder_usa2016";
	
	
	public static synchronized SolrServer getSolrServer(ServerTypeEnum type){
		if (type == ServerTypeEnum.GOODS) {
			return new HttpSolrServer(SOLR_SERVER_GOODS_URL);
		}else if(type == ServerTypeEnum.WM_PEODUCT){
			return new HttpSolrServer(SOLR_wm_product_URL);
		}else if(type == ServerTypeEnum.WM_SUPPLIER){
			//其他缓存路径
		    return new HttpSolrServer(SOLR_WM_SUPPLIER_URL);
		}else if(type == ServerTypeEnum.FRANK_ORDER){
            return new HttpSolrServer(SOLR_FRANKLY_ORDER);
        }else{
		    return new HttpSolrServer(SOLR_WM_BUSINESS_URL);
		}
	}
}
