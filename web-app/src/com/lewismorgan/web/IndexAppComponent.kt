package com.lewismorgan.web

import com.lewismorgan.web.carousel.CarouselComponent
import com.lewismorgan.web.carousel.carousel
import com.lewismorgan.web.carousel.carouselItem
import kotlinx.html.BUTTON
import kotlinx.html.MAIN
import kotlinx.html.attributesMapOf
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.ReactElement
import react.dom.RDOMBuilder
import react.dom.a
import react.dom.div
import react.dom.h1
import react.dom.li
import react.dom.nav
import react.dom.p
import react.dom.span
import react.dom.tag
import react.dom.ul

class IndexAppComponent : RComponent<RProps, RState>() {
  override fun RBuilder.render() {
    // TODO Create HeaderComponent
    nav("navbar navbar-expand-md navbar-dark fixed-top bg-dark") {
      a(classes = "navbar-brand", href = "#") { +"Lewis' Temple" }
      navbarToggler("navbar-toggler") {
        span("navbar-toggler-icon") {}
      }
      // TODO Add id to div
      div("collapse navbar-collapse") {
        ul("navbar-nav mr-auto") {
          li("nav-item active") {
            a(classes = "nav-link", href = "#") { +"Home (current)" }
          }
          li("nav-item") {
            a(classes = "nav-link", href = "#") { +"Projects" }
          }
        }
      }
    }
    main("", "main") {
      // TODO Create a Carousel Component, refactor this out
      carousel {
        carouselItem(true) {
          // TODO Carousel Caption Classes
          div("container") {
            div("carousel-caption text-left") {
              h1 { +"Welcome." }
              p { +"// TODO: Insert witty welcoming text here" }
            }
          }
        }
      }
    }
  }
}

inline fun RBuilder.main(classes: String? = null, role: String? = null, block: RDOMBuilder<MAIN>.() -> Unit): ReactElement = tag(block) { MAIN(attributesMapOf("class", classes, "role", role), it) }
inline fun RBuilder.navbarToggler(classes: String? = null, block: RDOMBuilder<BUTTON>.() -> Unit): ReactElement = tag(block) {
  BUTTON(attributesMapOf(
      "class", classes, "type", "button", "data-toggle", "collapse",
      "data-target", "#navbarCollapse", "aria-controls", "navbarCollapse", "aria-expanded", "false",
      "aria-label", "Toggle Nav"), it)
}
