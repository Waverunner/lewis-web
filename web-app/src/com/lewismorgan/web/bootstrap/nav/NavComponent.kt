package com.lewismorgan.web.bootstrap.nav

import com.lewismorgan.web.misc.getChildren
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.ReactElement
import react.children
import react.cloneElement
import react.dom.ul

interface NavProps : RProps {
  var defaultIndex: Int
}

interface NavState : RState {
  var activeIndex: Int
}

/**
 * Created by lewis on 6/23/18.
 */
class NavComponent : RComponent<NavProps, NavState>() {
  override fun NavState.init() {
    activeIndex = 0
  }

  override fun NavState.init(props: NavProps) {
    activeIndex = props.defaultIndex
  }

  override fun RBuilder.render() {
    ul("navbar-nav mr-auto") {
      val children = getChildren()
      if (children.isNotEmpty()) {
        for (i in 0 until children.size) {
          val activeChild = children[i]
          child(cloneElement<NavItemProps>(activeChild, activeChild.props.children, props = {
            isActive = state.activeIndex == i
          }))
        }
      }
    }
  }
}

fun RBuilder.navComponent(block: RBuilder.() -> Unit): ReactElement {
  return child<NavProps, NavComponent> {
    block()
  }
}