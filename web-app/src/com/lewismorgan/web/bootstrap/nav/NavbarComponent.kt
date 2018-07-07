package com.lewismorgan.web.bootstrap.nav

import kotlinx.html.classes
import kotlinx.html.role
import org.w3c.dom.events.Event
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.ReactElement
import react.dom.nav
import react.setState
import kotlin.browser.window

interface NavbarProps : RProps {
  var defaultActiveIndex: Int
  var navbarStyle: String
  var shrink: Boolean
}

interface NavbarState : RState {
  var minimized: Boolean
}

/**
 * Created by lewis on 6/23/18.
 */
class NavbarComponent(props: NavbarProps) : RComponent<NavbarProps, NavbarState>(props) {
  private val scrollHandler: (Event) -> Unit = {
    if (window.scrollY > 100) {
      setState {
        minimized = true
      }
    } else {
      setState {
        minimized = false
      }
    }
  }

  override fun NavbarState.init(props: NavbarProps) {
    minimized = false
  }

  override fun componentDidMount() {
    if (props.shrink) {
      window.addEventListener("scroll", scrollHandler)
    }
  }

  override fun componentWillUnmount() {
    window.removeEventListener("scroll", scrollHandler)
  }

  override fun RBuilder.render() {
    nav("navbar ${props.navbarStyle}") {
      attrs.role = "navigation"
      if (props.shrink && state.minimized) {
        attrs.classes += "navbar-shrink"
      }
      children()
    }
  }
}

fun RBuilder.navbar(navbarStyle: String, shrink: Boolean, block: RBuilder.() -> Unit): ReactElement {
  return child<NavbarProps, NavbarComponent> {
    attrs.navbarStyle = navbarStyle
    attrs.shrink = shrink
    attrs.defaultActiveIndex = 0
    block()
  }
}