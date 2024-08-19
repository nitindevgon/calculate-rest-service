package com.app.cs.ws.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"data"})

@Generated("jsonspojo")

public class Data {

	@JsonProperty("data")
	private Integer[] data = null;
	
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	
	@JsonProperty("data")
	public Integer[] getData() {
		return data;
	}
	
	@JsonProperty("data")
	public void setData(Integer[] data) {
		this.data = data;
	}
	
	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}
	
	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}