# Logging System

## Problem

Design a logging system that allows applications to log messages with different severity levels.

The system should support:

* Logging messages with levels like `DEBUG`, `INFO`, `WARN`, `ERROR`
* Filtering logs based on a minimum log level
* Writing logs to different outputs (e.g., console, file)

## Note

* The design should be extensible (easy to add new log outputs)
* Focus on clean structure and separation of concerns
  
## What we will be using (Hint)

* Enum for defining log levels
* Interface for log appenders (e.g., console, file)
* Strategy pattern to support multiple output types
* Basic filtering based on log level
