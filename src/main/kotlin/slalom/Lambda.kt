package slalom

import com.amazonaws.services.lambda.runtime.Context
import com.amazonaws.services.lambda.runtime.RequestHandler
import org.apache.logging.log4j.LogManager

// slalom.Lambda::handleRequest
class Lambda : RequestHandler<LexInput, LexOutput> {
    companion object {
        private val LOG = LogManager.getLogger(Lambda::class.java)
    }

    override fun handleRequest(input: LexInput, context: Context?): LexOutput {
        LOG.debug("Hello input=$input")
        val searchTerms = input.currentIntent.slots.searchTerms
        LOG.debug("You searched for searchTerms=$searchTerms")
        val message = Message(content = "Joey is the best term=$searchTerms")
        return LexOutput(dialogAction = DialogAction(message = message))
    }
}