package index

import com.lewismorgan.web.WebsiteComponent
import kotlinext.js.require
import kotlinext.js.requireAll
import react.dom.render
import react.dom.script
import kotlin.browser.document

fun main(args: Array<String>) {
  @Suppress("UnsafeCastFromDynamic")
  require("bootstrap/dist/css/bootstrap.css")
  require("@fortawesome/fontawesome-free/css/all.css")
  require("@fortawesome/fontawesome-free/js/all.js")
  requireAll(require.context("src", true, js("/\\.css$/")))
  render(document.getElementById("root")) {
    child(WebsiteComponent::class) {}
    script(src = "jquery/dist/jquery.slim.min.js") {}
    script(src = "popper.js/dist/popper.min.js") {}
    script(src = "bootstrap/dist/js/bootstrap.min.js") {}
  }
}
