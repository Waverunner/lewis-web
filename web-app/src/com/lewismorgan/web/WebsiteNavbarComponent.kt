package com.lewismorgan.web


import com.lewismorgan.web.bootstrap.dsl.container
import com.lewismorgan.web.bootstrap.nav.navComponent
import com.lewismorgan.web.bootstrap.nav.navbar
import com.lewismorgan.web.bootstrap.nav.navbarBrand
import com.lewismorgan.web.bootstrap.nav.navbarCollapse
import com.lewismorgan.web.bootstrap.nav.navbarToggler
import com.lewismorgan.web.misc.getSmoothScrollingHandler
import com.lewismorgan.web.misc.navHashLink
import org.w3c.dom.events.Event
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.i
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

  private fun onSelectNavItem(@Suppress("UNUSED_PARAMETER") itemId: Int): (Event) -> Unit = {
    setState {
      collapsed = true
    }
  }

  override fun RBuilder.render() {
    navbar("navbar-expand-lg navbar-dark fixed-top bg-dark", true) {
      container {
        navbarBrand("#") {
          fontAwesome("map-marked-alt", FontAwesomeStyleType.SOLID)
        }
        navbarToggler(state.collapsed, onClickToggler()) {}
        navbarCollapse(!state.collapsed) {
          navComponent({ i -> onSelectNavItem(i) }) {
            children()
          }
        }
      }
    }
    floatingItem {
      attrs.classes = ""
      attrs.displayScrollOffset = 50
      navHashLink("#home", className = "btn btn-outline-light jump-top-nav-btn text-center", scroll = getSmoothScrollingHandler()) {
        i("swg swg-falcon-2 swg-4x") {}
      }
    }
  }
}
