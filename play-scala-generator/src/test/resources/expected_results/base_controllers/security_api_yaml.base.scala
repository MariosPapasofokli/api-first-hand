package security.api.yaml

import scala.language.existentials
import play.api.mvc._
import play.api.http._
import de.zalando.play.controllers._
import Results.Status
import PlayBodyParsing._
import scala.concurrent.Future

import scala.util._
import de.zalando.play.controllers.ArrayWrapper

import de.zalando.play.controllers.PlayPathBindables





//noinspection ScalaStyle
trait SecurityApiYamlBase extends Controller with PlayBodyParsing  with SecurityApiYamlSecurity {
    import play.api.libs.concurrent.Execution.Implicits.defaultContext
    def success[T](t: => T) = Future.successful(t)
    sealed trait GetPetsByIdType[T] extends ResultWrapper[T]
    def GetPetsById200(resultP: Seq[Pet])(implicit writerP: String => Option[Writeable[Seq[Pet]]]) = success(new GetPetsByIdType[Seq[Pet]] { val statusCode = 200; val result = resultP; val writer = writerP })
    def GetPetsById200(resultF: Future[Seq[Pet]])(implicit writerP: String => Option[Writeable[Seq[Pet]]]) = resultF map { resultP => (new GetPetsByIdType[Seq[Pet]] { val statusCode = 200; val result = resultP; val writer = writerP }) }
    

    private type getPetsByIdActionRequestType       = (PetsIdGetId)
    private type getPetsByIdActionType[T]            = getPetsByIdActionRequestType => Future[GetPetsByIdType[T] forSome { type T }]


    val getPetsByIdActionConstructor  = new getPetsByIdSecureAction("user")

def getPetsByIdAction[T] = (f: getPetsByIdActionType[T]) => (id: PetsIdGetId) => getPetsByIdActionConstructor.async { request =>
        val providedTypes = Seq[String]("application/json", "text/html")

        negotiateContent(request.acceptedTypes, providedTypes).map { getPetsByIdResponseMimeType =>
            
            

                val result =
                        new PetsIdGetValidator(id).errors match {
                            case e if e.isEmpty => processValidgetPetsByIdRequest(f)((id))(getPetsByIdResponseMimeType)
                            case l =>
                                implicit val marshaller: Writeable[Seq[ParsingError]] = parsingErrors2Writable(getPetsByIdResponseMimeType)
                                success(BadRequest(l))
                        }
                result
            
        }.getOrElse(success(Status(406)("The server doesn't support any of the requested mime types")))
    }

    private def processValidgetPetsByIdRequest[T](f: getPetsByIdActionType[T])(request: getPetsByIdActionRequestType)(mimeType: String) = {
        f(request).map(_.toResult(mimeType).getOrElse(Results.NotAcceptable))
    }
    abstract class EmptyReturn(override val statusCode: Int, headers: Seq[(String, String)]) extends ResultWrapper[Result]  with GetPetsByIdType[Result] { val result = Results.Status(statusCode).withHeaders(headers:_*); val writer = (x: String) => Some(new Writeable((_:Any) => emptyByteString, None)); override def toResult(mimeType: String): Option[play.api.mvc.Result] = Some(result) }
    case object NotImplementedYetSync extends ResultWrapper[Results.EmptyContent]  with GetPetsByIdType[Results.EmptyContent] { val statusCode = 501; val result = Results.EmptyContent(); val writer = (x: String) => Some(new DefaultWriteables{}.writeableOf_EmptyContent); override def toResult(mimeType: String): Option[play.api.mvc.Result] = Some(Results.NotImplemented) }
    lazy val NotImplementedYet = Future.successful(NotImplementedYetSync)
}
