import java.time.LocalDateTime

// Log Levels
enum class LogLevel(val priority: Int) {
    DEBUG(1),
    INFO(2),
    WARN(3),
    ERROR(4)
}

// Log Message Model
data class LogMessage(
    val level: LogLevel,
    val message: String,
    val timestamp: LocalDateTime = LocalDateTime.now()
)

// Appender Interface (Strategy)
interface Appender {
    fun append(log: LogMessage)
}

// Console Appender
class ConsoleAppender : Appender {
    override fun append(log: LogMessage) {
        println("[${log.timestamp}] ${log.level}: ${log.message}")
    }
}

// Logger
class Logger(
    private val minLevel: LogLevel,
    private val appenders: List<Appender>
) {
    fun log(level: LogLevel, message: String) {
        if (level.priority >= minLevel.priority) {
            val logMsg = LogMessage(level, message)
            appenders.forEach { it.append(logMsg) }
        }
    }

    fun debug(msg: String) = log(LogLevel.DEBUG, msg)
    fun info(msg: String) = log(LogLevel.INFO, msg)
    fun warn(msg: String) = log(LogLevel.WARN, msg)
    fun error(msg: String) = log(LogLevel.ERROR, msg)
}

// Usage
fun main() {
    val logger = Logger(
        minLevel = LogLevel.INFO,
        appenders = listOf(ConsoleAppender())
    )

    logger.debug("This will not print")
    logger.info("Application started")
    logger.error("Something went wrong")
}
