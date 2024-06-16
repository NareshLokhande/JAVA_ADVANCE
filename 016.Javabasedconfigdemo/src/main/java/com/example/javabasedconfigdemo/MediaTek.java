package com.example.javabasedconfigdemo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("mediatek")
public class MediaTek implements Processor {

	@Override
	public void process() {
		System.out.println("MediaTek Processor");
	}
}
