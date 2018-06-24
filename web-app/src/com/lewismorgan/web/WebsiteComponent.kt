package com.lewismorgan.web

import com.lewismorgan.web.bootstrap.carousel.carousel
import com.lewismorgan.web.bootstrap.carousel.carouselCaption
import com.lewismorgan.web.bootstrap.carousel.carouselItem
import com.lewismorgan.web.bootstrap.nav.navComponent
import com.lewismorgan.web.bootstrap.nav.navbar
import com.lewismorgan.web.bootstrap.nav.navbarBranding
import com.lewismorgan.web.bootstrap.nav.navbarCollapsible
import com.lewismorgan.web.bootstrap.nav.navbarToggler
import com.lewismorgan.web.bootstrap.nav.navigationItem
import kotlinx.html.DIV
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.RDOMBuilder
import react.dom.a
import react.dom.div
import react.dom.footer
import react.dom.h1
import react.dom.h2
import react.dom.h3
import react.dom.h4
import react.dom.hr
import react.dom.header
import react.dom.li
import react.dom.p
import react.dom.section
import react.dom.small
import react.dom.span
import react.dom.ul

class WebsiteComponent : RComponent<RProps, RState>() {
  override fun RBuilder.render() {
    // Navigation
    renderNavbar()
    renderHeader()
    // the main contents for website
    renderSections()
    renderFooter()
    renderCopyright()
  }

  private fun RBuilder.renderNavbar() {
    navbar("navbar-expand-lg navbar-dark fixed-top bg-dark", true) {
      div("container") {
        navbarBranding("#Home") { +"Don't Get Lost -->" }
        navbarToggler { span("navbar-toggler-icon") {} }
        navbarCollapsible {
          navComponent {
            navigationItem("#Home", "Home") {
              // TODO Navigate to top of page
            }
            navigationItem("#Projects", "Projects") {
              // TODO Navigate to Projects
            }
            navigationItem("#Education", "Education") {
              // TODO Navigate to Education
            }
            navigationItem("#Contact", "Contact") {
              // TODO Navigate to Contact
            }
          }
        }
      }
    }
  }

  private fun RBuilder.renderCopyright() {
    div("copyright text-center py-4 bg-dark text-white") {
      div("container") {
        small("footer-notes") {
          span {
            +"Copyright "
          }
          fontAwesome("copyright", FontAwesomeStyleType.REGULAR, FontAwesomeSize.XS)
          span {
            +" Lewis Morgan 2018. Source code is available on "
          }
          a("https://github.com/lewismorgan/lewisjmorgan") {
            +"GitHub"
          }
          span { +" " }
          fontAwesome("github", FontAwesomeStyleType.BRAND, FontAwesomeSize.DEFAULT, "fa-fw") {}
        }
      }
    }
  }

  private fun RBuilder.renderSections() {
    renderWelcomeSection()
    renderProjectsSection()
    renderEduSection()
    renderContactSection()
  }

  private fun RBuilder.renderHeader() {
    header("masthead bg-primary text-center") {
      div("container") {
        h1 { +"Lewis Morgan" }
        div("container m-2") {
          div("m-2") {
            fontAwesome("laptop", FontAwesomeStyleType.SOLID, FontAwesomeSize.X3)
          }
          h3 {
            fontAwesome("terminal", FontAwesomeStyleType.SOLID)
            span {
              +" sudo rm -rf /"
            }
          }
        }
        h4 {
          +"Student - Developer - Star Wars Fanatic"
        }
      }
    }
  }

  private fun RBuilder.renderWelcomeSection() {
    section {
      attrs["id"] = "welcome-carousel"
      carousel(1) {
        carouselItem {
          carouselCaption("text-left") {
            h1 { +"Welcome." }
            p { +"// TODO: Insert some welcoming text." }
          }
        }
        carouselItem {
          carouselCaption("") {
            h1 { +""""Do. Or do not. There is no try."""" }
            p { +"- Master Yoda (The Empire Strikes Back)" }
          }
        }
      }
    }
  }

  private fun RBuilder.renderProjectsSection() {
    section {
      attrs["id"] = "projects"
      div("container") {
        // TODO Add Projects grid / github component
      }
    }
  }

  private fun RBuilder.renderEduSection() {
    section {
      attrs["id"] = "education"
      div("container") {
        // TODO Add education component
      }
    }
  }

  private fun RBuilder.renderContactSection() {
    section {
      attrs["id"] = "contact"
      div("container") {
        // TODO Add contact component
      }
    }
  }

  private fun RBuilder.renderFooter() {
    footer("footer text-center") {
      div("container") {
        div("row justify-content-md-center") {
          div("col-md-6") {
            h4 { +"Location" }
            p { +"Tampa, Florida" }
          }
          div("col-md-6") {
            renderSocial()
          }
        }
      }
    }
  }

  private fun RDOMBuilder<DIV>.renderSocial() {
    h4 { +"Social" }
    ul("list-inline") {
      li("list-inline-item") {
        fontAwesome("facebook-square", FontAwesomeStyleType.BRAND, FontAwesomeSize.X2)
      }
      li("list-inline-item") {
        fontAwesome("twitter-square", FontAwesomeStyleType.BRAND, FontAwesomeSize.X2)
      }
      li("list-inline-item") {
        fontAwesome("linkedin", FontAwesomeStyleType.BRAND, FontAwesomeSize.X2)
      }
    }
  }
}
