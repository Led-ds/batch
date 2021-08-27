package com.poc.batch.spring;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.DefaultBatchConfigurer;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.poc.batch.spring.listener.ListenerStep;
import com.poc.batch.spring.model.ClazzModel;
import com.poc.batch.spring.reader.ClazzReader;
import com.poc.batch.spring.steps.ItemProcessorClazzModel;
import com.poc.batch.spring.util.PropertiesConfig;

@Configuration
@EnableBatchProcessing
@ComponentScan("com.poc.batch")
public class ConfigBatch extends DefaultBatchConfigurer{

	@Autowired
	private JobBuilderFactory jobBuilderFactory;
	
	@Autowired
	public StepBuilderFactory stepBuilderFactory;
	
	@Autowired
	public BeanFactory beanFactory;
	
	@Autowired
	public ListenerStep listener;
	
	@Autowired
	public PropertiesConfig properties;
	
	@Autowired
	private ClazzReader reader;
	
	@Bean(name = "createJobLauncher")
	public SimpleJobLauncher jobLauncher(JobRepository prJobRepository) {
		SimpleJobLauncher launcher = new SimpleJobLauncher();
		launcher.setJobRepository(prJobRepository);
		
		return launcher;
	}
	
	@Bean
	@Profile("processor-name")
	public Job processorClazzModel() {
		return jobBuilderFactory.get("processorName")
				.incrementer(new RunIdIncrementer())
				.listener(listener)
				.flow(null)
				.end()
				.build();
	}
	
	public Step step() {
		return stepBuilderFactory.get("step")
				.<ClazzModel, ClazzModel>chunk(properties.getChunk())
				.reader(reader.readerModel())
				.processor(processor())
				.writer(beanFactory.getWriter())
				.build();
	}
	
	public ItemProcessor<ClazzModel, ClazzModel> processor(){
		return new ItemProcessorClazzModel();
	}
}
