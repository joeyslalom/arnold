package slalom

/*
http://docs.aws.amazon.com/lex/latest/dg/lambda-input-response-format.html?shortFooter=true

{
  "sessionAttributes": {
    "key1": "value1",
    "key2": "value2"
    ...
  },
  "dialogAction": {
    "type": "ElicitIntent, ElicitSlot, ConfirmIntent, Delegate, or Close",
    Full structure based on the type field. See below for details.
  }
}
 */

data class LexOutput(
        var dialogAction: DialogAction = DialogAction()
)

/*
"dialogAction": {
    "type": "Close",
    "fulfillmentState": "Fulfilled or Failed",
    "message": {
      "contentType": "PlainText or SSML",
      "content": "Message to convey to the user. For example, Thanks, your pizza has been ordered."
    },
   "responseCard": {
      "version": integer-value,
      "contentType": "application/vnd.amazonaws.card.generic",
      "genericAttachments": [
          {
             "title":"card-title",
             "subTitle":"card-sub-title",
             "imageUrl":"URL of the image to be shown",
             "attachmentLinkUrl":"URL of the attachment to be associated with the card",
             "buttons":[
                 {
                    "text":"button-text",
                    "value":"Value sent to server on button click"
                 }
              ]
           }
       ]
     }
  }
 */

data class DialogAction(
        var type: String = "Close",
        var fulfillmentState: String = "Fulfilled",
        var message: Message = Message(),
        var responseCard: ResponseCard? = null
)

data class Message(
        var contentType: String = "PlainText",
        var content: String = ""
)

data class ResponseCard(
        var version: Int = 0,
        var contentType: String = "application/vnd.amazonaws.card.generic",  // only value accepted
        var genericAttachments: List<GenericAttachment> = listOf(GenericAttachment("title", "sub")) // size must be 1..10
)

data class GenericAttachment(
        var title: String = "",
        var subTitle: String = "",
        var imageUrl: String? = null,
        var attachmentLinkUrl: String? = null,
        var buttons: List<Button> = listOf()  // size must be 1..5
)

data class Button(
        var text: String = "",
        var value: String = ""
)