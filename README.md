# Loglibrary
This library will make logging easier and add some extra functionality, such as logging errors to files for sending to support.

## Usuage
To start using the library add the following to your build.gradle file (not the root file):  
```
    compile "com.mastertechsoftware.logging:loglibrary:1.0.0"
```
### Initialization
Initialization should happen as soon as possible, usually the Application class. You can call individual static methods or use a json configuration file.
### Individual Initialization
1. SDLogger.setLogFile(String logfileName) - Sets the name of the external log file.
2. setApplicationTag(String tag) - Tag that the application will use. No need use tag in each call.
3. setSDFileSize - Maximum size of log file
4. setApplicationLogLines - maximum number of application lines to print in stack traces
5. setMaxLogLines - Maximum number of log lines to print

### Configuration File
Example:   

```
{
	"setup" : {
		"logFilename" : "DailyPodcastLog.txt",
		"logFilesize" : 20000,
		"apptag" : "DailyPodcast",
		"appLogLines" : 5,
		"maxLogLines" : 10

	},
	"categories" : [
		{
			"name" : "music",
			"logging" : "enabled"
		}
	],
	"classes" : [
		{
			"className": "PodcastApplication",
			"logging" : "disabled"
		},
		{
			"className": "ReflectTable",
			"logging" : "disabled"
		},
		{
			"className": "PodcastPlayer",
			"category" : "music",
			"logging" : "enabled"
		},
		{
			"className": "PodcastPlayerService",
			"category" : "music",
			"logging" : "enabled"
		},
		{
			"className": "PodcastUtils",
			"category" : "podcasts",
			"logging" : "enabled"
		},
		{
			"className": "MusicWearableService",
			"category" : "wear",
			"logging" : "enabled"
		}
	]
}  
```
The classes section allows you to turn on/off logging for specific classes. You can use the categories section to turn on/off sections of code (mark the classes with that category)

### Usage
To use the logging code, just use the following:  
1. Logger.debug() - several variations  
2. Logger.error()  
3. Logger.warn()  
4. setDebugLogging - to turn on/off debugging to SD Card file  
5. setDebug - to turn on/off debugging to the given class  
