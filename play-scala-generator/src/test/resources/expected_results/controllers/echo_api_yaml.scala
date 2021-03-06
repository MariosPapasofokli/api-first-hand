
import play.api.mvc.{Action, Controller}

import play.api.data.validation.Constraint

import play.api.inject.{ApplicationLifecycle,ConfigurationProvider}

import de.zalando.play.controllers._

import PlayBodyParsing._

import PlayValidations._

import scala.util._

import javax.inject._


/**
 * This controller is re-generated after each change in the specification.
 * Please only place your hand-written code between appropriate comments in the body of the controller.
 */

package echo {

    class EchoHandler @Inject() (lifecycle: ApplicationLifecycle, config: ConfigurationProvider) extends EchoHandlerBase {
        // ----- Start of unmanaged code area for constructor EchoHandler

        // ----- End of unmanaged code area for constructor EchoHandler
        val method = methodAction {  _ =>  
            // ----- Start of unmanaged code area for action  EchoHandler.method
            NotImplementedYet
            // ----- End of unmanaged code area for action  EchoHandler.method
        }
    
    }
}
package echo {

    class EchoApiYaml @Inject() (lifecycle: ApplicationLifecycle, config: ConfigurationProvider) extends EchoApiYamlBase {
        // ----- Start of unmanaged code area for constructor EchoApiYaml

        // ----- End of unmanaged code area for constructor EchoApiYaml
        val post = postAction { input: (PostName, PostName) =>
            val (name, year) = input
            // ----- Start of unmanaged code area for action  EchoApiYaml.post
            NotImplementedYet
            // ----- End of unmanaged code area for action  EchoApiYaml.post
        }
        val gettest_pathById = gettest_pathByIdAction { (id: String) =>  
            // ----- Start of unmanaged code area for action  EchoApiYaml.gettest_pathById
            NotImplementedYet
            // ----- End of unmanaged code area for action  EchoApiYaml.gettest_pathById
        }
    
    }
}
