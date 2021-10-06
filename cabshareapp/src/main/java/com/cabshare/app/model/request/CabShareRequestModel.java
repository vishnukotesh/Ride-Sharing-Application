package com.cabshare.app.model.request;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class CabShareRequestModel {
@Id
private long id;
private String name;
private double fromLocationLat;
private double fromLocationLong;
private double toLocationLat;
private double toLocationLong;
//LocalDateTime -	Represents both a date and a time (yyyy-MM-dd-HH-mm)
@Column(name = "time_start", columnDefinition = "TIMESTAMP")
@JsonFormat(pattern="dd-MM-yyyy-HH-mm")
private LocalDateTime timeStart;

@Column(name = "time_end", columnDefinition = "TIMESTAMP")
@JsonFormat(pattern="dd-MM-yyyy-HH-mm")
private LocalDateTime timeEnd;
private String geoHashCode;
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public double getFromLocationLat() {
	return fromLocationLat;
}
public void setFromLocationLat(double fromLocationLat) {
	this.fromLocationLat = fromLocationLat;
}
public double getFromLocationLong() {
	return fromLocationLong;
}
public void setFromLocationLong(double fromLocationLong) {
	this.fromLocationLong = fromLocationLong;
}
public double getToLocationLat() {
	return toLocationLat;
}
public void setToLocationLat(double toLocationLat) {
	this.toLocationLat = toLocationLat;
}
public double getToLocationLong() {
	return toLocationLong;
}
public void setToLocationLong(double toLocationLong) {
	this.toLocationLong = toLocationLong;
}
public LocalDateTime getTimeStart() {
	return timeStart;
}
public void setTimeStart(LocalDateTime timeStart) {
	this.timeStart = timeStart;
}
public LocalDateTime getTimeEnd() {
	return timeEnd;
}
public void setTimeEnd(LocalDateTime timeEnd) {
	this.timeEnd = timeEnd;
}
public String getGeoHashCode() {
	return geoHashCode;
}
public void setGeoHashCode(String geoHashCode) {
	this.geoHashCode = geoHashCode;
}
@Override
public String toString() {
	return "CabShareRequestModel [id=" + id + ", name=" + name + ", fromLocationLat=" + fromLocationLat
			+ ", fromLocationLong=" + fromLocationLong + ", toLocationLat=" + toLocationLat + ", toLocationLong="
			+ toLocationLong + ", timeStart=" + timeStart + ", timeEnd=" + timeEnd + ", geoHashCode=" + geoHashCode
			+ "]";
}

}



