package slalom

import com.amazonaws.services.lambda.runtime.Context
import com.amazonaws.services.lambda.runtime.RequestHandler
import org.apache.logging.log4j.LogManager

// slalom.Lambda::handleRequest
class Lambda : RequestHandler<String, String> {
    companion object {
        private val LOG = LogManager.getLogger(Lambda::class.java)
    }
    override fun handleRequest(input: String?, context: Context?): String {
        LOG.debug("log message")
        return "Hello $input"
    }
}