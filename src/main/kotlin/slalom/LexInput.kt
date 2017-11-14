package slalom

/*
http://docs.aws.amazon.com/lex/latest/dg/lambda-input-response-format.html

{
  "currentIntent": {
    "name": "intent-name",
    "slots": {
      "slot name": "value",
      "slot name": "value"
    },
    "slotDetails": {
      "slot name": {
        "resolutions" : [
          { "value": "resolved value" },
          { "value": "resolved value" }
        ],
        "originalValue": "original text"
      },
      "slot name": {
        "resolutions" : [
          { "value": "resolved value" },
          { "value": "resolved value" }
        ],
        "originalValue": "original text"
      }
    },
    "confirmationStatus": "None, Confirmed, or Denied (intent confirmation, if configured)",
  },
  "bot": {
    "name": "bot name",
    "alias": "bot alias",
    "version": "bot version"
  },
  "userId": "User ID specified in the POST request to Amazon Lex.",
  "inputTranscript": "Text used to process the request",
  "invocationSource": "FulfillmentCodeHook or DialogCodeHook",
  "outputDialogMode": "Text or Voice, based on ContentType request header in runtime API request",
  "messageVersion": "1.0",
  "sessionAttributes": {
     "key": "value",
     "key": "value"
  },
  "requestAttributes": {
     "key": "value",
     "key": "value"
  }
}
 */

data class LexInput(
        var currentIntent: CurrentIntent = CurrentIntent(),
        var bot: Bot = Bot(),
        var userId: String = "",
        var inputTranscript: String = "",
        var invocationSource: String = "",
        var outputDialogMode: String = "",
        var messageVersion: String = ""
)

data class CurrentIntent(
        var name: String = "",
        var slots: Slots = Slots(),
        var slotDetails: SlotDetails = SlotDetails(),
        var confirmationStatus: String = ""
)

data class Slots(
        var searchTerms: String = ""
)

data class SlotDetails(
        var searchTerms: Resolutions = Resolutions()
)

data class Resolutions(
        var resolutions: List<Resolution> = listOf(),
        var originalValue: String = ""
)

data class Resolution(var value: String = "")

data class Bot(
        var name: String = "",
        var alias: String = "",
        var version: String = ""
)