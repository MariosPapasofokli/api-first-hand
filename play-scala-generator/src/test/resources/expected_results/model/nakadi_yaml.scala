package nakadi


    import java.util.UUID

    import de.zalando.play.controllers.PlayPathBindables


//noinspection ScalaStyle
package object yaml {

    type TopicsTopicEventsBatchPostTopic = String
    type TopicsTopicEventsGetStream_timeout = Option[Int]
    type TopicsTopicEventsGetBatch_limit = Int
    type EventEvent_type = Option[String]
    type SimpleStreamEventEventsOpt = Seq[Event]
    type EventMetaDataParent_id = Option[UUID]
    type EventMetadata = Option[EventMetaDataNameClash]
    type TopicsTopicEventsPostResponses201 = Null
    type EventMetaDataScopesOpt = Seq[String]
    type TopicsTopicPartitionsGetResponses200 = Seq[TopicPartition]
    type TopicsTopicEventsBatchPostEvent = Option[Event]
    type SimpleStreamEventEvents = Option[SimpleStreamEventEventsOpt]
    type EventMetaDataScopes = Option[EventMetaDataScopesOpt]
    type TopicsGetResponses200 = Seq[Topic]


import play.api.mvc.{QueryStringBindable, PathBindable}

    implicit val bindable_OptionIntQuery: QueryStringBindable[Option[Int]] = PlayPathBindables.createOptionQueryBindable[Int]

}
//noinspection ScalaStyle
package yaml {


    case class EventMetaDataNameClash(root_id: EventMetaDataParent_id, parent_id: EventMetaDataParent_id, scopes: EventMetaDataScopes, id: EventMetaDataParent_id, created: EventEvent_type) 
    case class Topic(name: String) 
    case class Metrics(name: EventEvent_type) 
    case class Event(event_type: EventEvent_type, partitioning_key: EventEvent_type, metadata: EventMetadata) 
    case class Cursor(partition: String, offset: String) 
    case class Problem(detail: String) 
    case class TopicPartition(partition: String, oldest_available_offset: String, newest_available_offset: String) 
    case class SimpleStreamEvent(cursor: Cursor, events: SimpleStreamEventEvents) 


}
