package com.nt.test;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CSVToXMLBatchTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		JobLauncher launcher=null;
		Job job=null;
		JobExecution execution=null;
		//create IOC container
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get Job Launcher
		launcher=ctx.getBean("jobLauncher",JobLauncher.class);
		//get Job
		job=ctx.getBean("job",Job.class);
		try {
			 execution=launcher.run(job,new JobParameters());
			 System.out.println("Job Exit status::"+execution.getExitStatus());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		//close Container
		((AbstractApplicationContext) ctx).close();

	}
}
