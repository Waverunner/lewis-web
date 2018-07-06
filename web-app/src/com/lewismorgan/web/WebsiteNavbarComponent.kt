package com.lewismorgan.web


import com.lewismorgan.web.bootstrap.nav.navComponent
import com.lewismorgan.web.bootstrap.nav.navbar
import com.lewismorgan.web.bootstrap.nav.navbarBranding
import com.lewismorgan.web.bootstrap.nav.navbarCollapse
import com.lewismorgan.web.bootstrap.nav.navbarToggler
import kotlinx.html.ButtonType
import kotlinx.html.classes
import org.w3c.dom.events.Event
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.button
import react.dom.div
import react.setState

interface WebsiteNavbarProps : RProps {
  var collapsedMenuShown: Boolean
}

interface WebsiteNavbarState : RState {
  var collapsed: Boolean
}

class WebsiteNavbarComponent(props: WebsiteNavbarProps) : RComponent<WebsiteNavbarProps, WebsiteNavbarState>(props) {
  override fun WebsiteNavbarState.init() {
    collapsed = true
  }

  override fun WebsiteNavbarState.init(props: WebsiteNavbarProps) {
    collapsed = props.collapsedMenuShown
  }

  private fun onClickToggler(): (Event) -> Unit = {
    setState {
      collapsed = !collapsed
    }
  }

  override fun RBuilder.render() {
    navbar("navbar-expand-lg navbar-dark fixed-top bg-dark", true) {
      div("container") {
        navbarBranding("/") {
          fontAwesome("map-marked-alt", FontAwesomeStyleType.SOLID)
        }
        navbarToggler(state.collapsed, onClickToggler()) {}
        navbarCollapse(!state.collapsed) {
          navComponent {
            children()
          }
        }
      }
    }
    floatingItem {
      attrs.classes = "d-lg-none"
      attrs.displayScrollOffset = 90
      button(type = ButtonType.button, classes = "btn btn-primary jump-top-nav-btn") {
        +"^"
      }
    }
  }
}