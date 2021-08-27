package com.poc.batch.spring.steps;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.item.ItemProcessor;

import com.poc.batch.spring.model.ClazzModel;

public class ItemProcessorClazzModel implements ItemProcessor<ClazzModel, ClazzModel>, StepExecutionListener{

	protected static final Log logger = LogFactory.getLog(ItemProcessorClazzModel.class);
	
	@Override
	public void beforeStep(StepExecution stepExecution) {
		logger.info("Starting Processor Batch...");
		
	}
	
	@Override
	public ClazzModel process(ClazzModel item) throws Exception {
		// TODO Auto-generated method stub
		//Item, é a informação que vem da leitura da tabela da base de dados.
		//realizamos processos para o step de Escrita atualizar a tabela da base da dados (bem, essa é a proposta do exemplo em questão)
		
		return item;
	}

	@Override
	public ExitStatus afterStep(StepExecution stepExecution) {
		logger.info("End Processor Batch...");
		return ExitStatus.COMPLETED;
	}

}
