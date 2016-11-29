package com.acme.care.features.hooks;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.SimpleTransactionStatus;

import com.acme.care.features.CucumberConfig;

import cucumber.api.java.After;
import cucumber.api.java.Before;

@CucumberConfig
public class SpringTransactionHooks { //implements BeanFactoryAware {
	
	private BeanFactory beanFactory;

	private String txnManagerBeanName;

   // @Override
	@Autowired
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
    	this.beanFactory = beanFactory;
    }
   
    public String getTxnManagerBeanName() {
        return txnManagerBeanName;
    }
 
    public void setTxnManagerBeanName(String txnManagerBeanName) {
        this.txnManagerBeanName = txnManagerBeanName;
    }

    private TransactionStatus transactionStatus;

    @Before(value = {"@txn"}, order = 100)
    public void startTransaction() {
        transactionStatus = obtainPlatformTransactionManager().getTransaction(new DefaultTransactionDefinition());
    }

    @After(value = {"@txn"}, order = 100)
    public void rollBackTransaction() {
    	
    	//obtainPlatformTransactionManager().rollback(transactionStatus);
    	
    	//if (! transactionStatus.isCompleted()) {
    	if (transactionStatus.isRollbackOnly()) {
    		obtainPlatformTransactionManager().rollback(transactionStatus);
    	}
    }

    public PlatformTransactionManager obtainPlatformTransactionManager() {
    	if (getTxnManagerBeanName() == null) {
            return beanFactory.getBean(PlatformTransactionManager.class);
        } else {
            return beanFactory.getBean(txnManagerBeanName, PlatformTransactionManager.class);
        }
    }

    public TransactionStatus getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(SimpleTransactionStatus transactionStatus) {
        this.transactionStatus = transactionStatus;
    }
}
