package com.mastertechsoftware.logging;

import com.mastertechsoftware.logging.timer.ProgressTimer;

/**
 * Class for logging Timing info
 */
public class TimingLog {
	protected static LogFile timingLog;
	protected static ProgressTimer progressTimer = new ProgressTimer();

	public static void setupLog(String directoryName, String logFileName) {
		timingLog = new LogFile();
		timingLog.setDirectoryName(directoryName);
		timingLog.setLogFile(logFileName);
	}

	public static void start() {
		progressTimer.start();
	}

	public static void stop() {
		progressTimer.stop();
		timingLog.write(progressTimer.getResults());
	}

	public static void comment(String comment) {
		timingLog.write(comment);
	}
}
