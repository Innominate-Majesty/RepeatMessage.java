// package listeners.messages;

// import com.slack.api.app_backend.events.payload.EventsApiPayload;
// import com.slack.api.bolt.App;
// import com.slack.api.bolt.context.builtin.EventContext;
// import com.slack.api.bolt.handler.BoltEventHandler;
// import com.slack.api.bolt.response.Response;
// import com.slack.api.model.event.MessageEvent;
// import java.util.concurrent.Future;
// import java.util.regex.Matcher;
// import java.util.regex.Pattern;
// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

// public class RepeatMessage implements BoltEventHandler<MessageEvent> {

//     private static final Logger logger = LoggerFactory.getLogger(RepeatMessage.class);

//     private final App app;

//     public RepeatMessage(App app) {
//         this.app = app;
//     }

//     @Override
//     public Response apply(EventsApiPayload<MessageEvent> payload, EventContext ctx) {
//         this.applyAsync(payload, ctx);
//         return Response.ok();
//     }

//     public Future<?> applyAsync(EventsApiPayload<MessageEvent> payload, EventContext ctx) {
//         return this.app.executorService().submit(() -> {
//             var event = payload.getEvent();
//             var message = event.getText();
//             String botUserId = ctx.getBotUserId();

//             logger.info("Received message: {}", message); // Log the received message

//             Pattern mentionPattern = Pattern.compile("<@" + botUserId + ">\\s*(.*)"); // mention of bot

//             Matcher mentionMatcher = mentionPattern.matcher(message);

//             if (mentionMatcher.find()) {
//                 String responseMessage = mentionMatcher.group(1).trim(); // some part of the message
//                 logger.info("Sending response: {}", responseMessage); // Log the response message

//                 // run the main logic
//                 try {
//                     var postMessageResponse = ctx.say(responseMessage);
//                     if (!postMessageResponse.isOk()) {
//                         logger.error("Failed to send message: {}", postMessageResponse.toString());
//                     }
//                 } catch (Exception e) {
//                     logger.error("Failed to call chat.postMessage API (error: {})", e.getMessage(), e);
//                 }
//             } else {
//                 logger.warn("No mention found in the message");
//             }

//             return null;
//         });
//     }
// }

// package listeners.messages;

// import com.slack.api.app_backend.events.payload.EventsApiPayload;
// import com.slack.api.bolt.App;
// import com.slack.api.bolt.context.builtin.EventContext;
// import com.slack.api.bolt.handler.BoltEventHandler;
// import com.slack.api.bolt.response.Response;
// import com.slack.api.model.event.MessageEvent;
// import java.util.concurrent.Future;
// import java.util.regex.Matcher;
// import java.util.regex.Pattern;
// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

// public class RepeatMessage implements BoltEventHandler<MessageEvent> {

//     private static final Logger logger = LoggerFactory.getLogger(RepeatMessage.class);

//     private final App app;

//     // private static final Pattern MENTION_PATTERN = Pattern.compile("^<@([A-Z0-9]+)>");
//     // private static final Pattern GREETINGS_PATTERN = Pattern.compile("(?i)\\b(hi|hello|hey)\\b");

//     public RepeatMessage(App app) {
//         this.app = app;
//     }

//     @Override
//     public Response apply(EventsApiPayload<MessageEvent> payload, EventContext ctx) {
//         // throws IOException, SlackApiException {
//         this.applyAsync(payload, ctx);
//         return Response.ok();
//     }

//     public Future<?> applyAsync(EventsApiPayload<MessageEvent> payload, EventContext ctx) {
//         return this.app.executorService().submit(() -> {
//             var event = payload.getEvent();
//             var message = event.getText();

//             logger.info("Received message: {}", message); // Log the received message

//             Pattern mentionPattern = Pattern.compile("<@Vinci>\\s*(.*)"); // mention of bot

//             Matcher mentionMatcher = mentionPattern.matcher(message);

//             if (mentionMatcher.find()) {
//                 String responseMessage = mentionMatcher.group(1).trim(); // some part of the message
//                 logger.info("Sending response: {}", responseMessage); // Log the response message

//                 // run the main logic
//                 try {
//                     var postMessageResponse = ctx.say(responseMessage);
//                     if (!postMessageResponse.isOk()) {
//                         logger.error("Failed to send message: {}", postMessageResponse.toString());
//                     }
//                 } catch (Exception e) {
//                     logger.error("Failed to call chat.postMessage API (error: {})", e.getMessage(), e);
//                 }
//             } else {
//                 logger.warn("No mention found in the message");
//             }

//             return null;
//         });
//     }
// }

//     public Future<?> applyAsync(EventsApiPayload<MessageEvent> payload, EventContext ctx) {
//         return this.app.executorService().submit(() -> {
//             var event = payload.getEvent();
//             var message = event.getText();

//             // Regular expression to match bot mentions //@Vinci
//             Pattern mentionPattern = Pattern.compile("<@Vinci>(.*)"); // mention of bot
//             Matcher mentionMatcher = mentionPattern.matcher(message);

//             if (mentionMatcher.find()) {
//                 String responseMessage = mentionMatcher.group(1).trim(); // some part of the message

//                 // run the main logic
//                 try {
//                     var postMessageResponse = ctx.say(responseMessage);
//                     if (!postMessageResponse.isOk()) {
//                         ctx.logger.error(postMessageResponse.toString());
//                     }
//                 } catch (Exception e) {
//                     ctx.logger.error("Failed to call chat.postMessage API (error: {})", e.getMessage(), e);
//                 }
//             }

//             return Response.ok();
//         });
//     }
// }
//             // String botMention = null;

//             if (mentionMatcher.find()) {
//                 botMention = mentionMatcher.group(); // extract Vinci's mention from the message
//             }

//             // Regular expression to match greetings
//             Pattern greetingsPattern = Pattern.compile("(?i)\\b(hi|hello|hey)\\b");
//             Matcher greetingsMatcher = GREETINGS_PATTERN.matcher(message);

//             if (botMention != null && greetingsMatcher.find()) {

//                 // Respond with the mention and greeting
//                 String responseMessage = botMention + " " + greetingsMatcher.group();

//                 // run the main logic
//                 try {
//                     var postMessageResponse = ctx.say(responseMessage);
//                     if (!postMessageResponse.isOk()) {
//                         ctx.logger.error(postMessageResponse.toString());
//                     }
//                 } catch (Exception e) {
//                     ctx.logger.error("Failed to call chat.postMessage API (error: {})", e.getMessage(), e);
//                 }
//             }

//             // Need to add a return statement to make the lambda a Runnable
//             return null;
//         });
//     }
// }
