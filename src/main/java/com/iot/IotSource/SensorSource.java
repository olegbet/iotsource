package com.iot.IotSource;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.annotation.InboundChannelAdapter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.iot.common.Sensor;
import com.iot.common.*;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@EnableBinding(Source.class)
public class SensorSource {
private static final int N_SENSORS = 10+1;
private static final int MIN_DATA = -100;
private static final int MAX_DATA = 100;
ObjectMapper mapper=new ObjectMapper();

@InboundChannelAdapter(Source.OUTPUT)
public String sendSensorData() throws JsonProcessingException{

	long time=System.currentTimeMillis();
	int type=getRandomNumber(0,2);

	Sensor sensor;
	switch(type) {
		case 0: sensor=new SensorTemp(0, time, getRandomNumber(Constants.TEMP_MIN,Constants.TEMP_MAX)); break;
		case 1: sensor=new SensorHeartRate(1, time, getRandomNumber(Constants.HEART_RATE_MIN,Constants.HEART_RATE_MAX)); break;
		default:sensor=new SensorCarFuel(2, time, getRandomNumber(Constants.FUEL_MIN,Constants.FUEL_MAX)); break;
	}
	
	return mapper.writeValueAsString(sensor);
}
private int getRandomNumber(int min, int max) {
	return (int) (min+Math.random()*(max-min+1));
}
}
