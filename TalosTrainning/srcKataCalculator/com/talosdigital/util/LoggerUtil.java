package com.talosdigital.util;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.RollingFileAppender;

public class LoggerUtil {
	public static final Logger log= Logger.getLogger(LoggerUtil.class);
	
	public static void main(String[] args) {
		startLogger("LogFile.log");
	}
	public static void startLogger(String fileName){
		//this get the root logger and asign the level
		Logger rootLogger = Logger.getRootLogger();
		rootLogger.setLevel(Level.DEBUG);
		//this is the format of the messages
		PatternLayout layout = new 
				PatternLayout("%d{yyyy:MM:dd:HH:mm:ss} %-5p:%m%n");
		rootLogger.addAppender(new ConsoleAppender(layout));
		
		
		try {
		//Define file appender with layout and output log file name
			RollingFileAppender fileAppender = new 
					RollingFileAppender(layout, fileName);
			rootLogger.addAppender(fileAppender);
		} catch (Exception e) {
			System.out.println("Failed to add apender");
		}
	}
	
}
