package com.poc.batch.spring.listener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;


public class ListenerStep extends JobExecutionListenerSupport{

	protected static final Log logger = LogFactory.getLog(ListenerStep.class);
	
	@Override
	public void afterJob(JobExecution jobExecution) {
		if(jobExecution.getStatus() == BatchStatus.COMPLETED) {
			logger.info("COMPLETED SUCCESSFULLY");
		}
	}
}
