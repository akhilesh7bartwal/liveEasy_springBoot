package com.springrest.liveEasy_springBoot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "payload")
public class PayLoad {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long shipperId;
	
	@Column(name = "noOfTrucks")
	private long noOfTrucks;
	
	@Column(name = "weight")
	private long weight;
	
	@Column(name = "loadingPoint")
	private String loadingPoint;
	
	@Column(name = "unloadingPoint")
	private String unloadingPoint;
	
	@Column(name = "productType")
	private String productType;
	
	@Column(name = "truckType")
	private String truckType;
	
	@Column(name = "comment")
	private String comment;
	
	@Column(name = "date")
	private String date;
	
		
	public PayLoad() {
		super();
	}


	public PayLoad(long noOfTrucks, long weight, String loadingPoint, String unloadingPoint, String productType,
			String truckType, String comment, String date) {
		super();
		this.noOfTrucks = noOfTrucks;
		this.weight = weight;
		this.loadingPoint = loadingPoint;
		this.unloadingPoint = unloadingPoint;
		this.productType = productType;
		this.truckType = truckType;
		this.comment = comment;
		this.date = date;
	}
	
	
	public long getShipperId() {
		return shipperId;
	}
	public void setShipperId(long shipperId) {
		this.shipperId = shipperId;
	}
	public long getNoOfTrucks() {
		return noOfTrucks;
	}
	public void setNoOfTrucks(long noOfTrucks) {
		this.noOfTrucks = noOfTrucks;
	}
	public long getWeight() {
		return weight;
	}
	public void setWeight(long weight) {
		this.weight = weight;
	}
	public String getLoadingPoint() {
		return loadingPoint;
	}
	public void setLoadingPoint(String loadingPoint) {
		this.loadingPoint = loadingPoint;
	}
	public String getUnloadingPoint() {
		return unloadingPoint;
	}
	public void setUnloadingPoint(String unloadingPoint) {
		this.unloadingPoint = unloadingPoint;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public String getTruckType() {
		return truckType;
	}
	public void setTruckType(String truckType) {
		this.truckType = truckType;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

	

}
