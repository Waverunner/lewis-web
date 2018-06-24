package com.lewismorgan.web.bootstrap.carousel

import com.lewismorgan.web.misc.getChildren
import kotlinx.html.A
import kotlinx.html.attributesMapOf
import kotlinx.html.js.onClickFunction
import org.w3c.dom.events.Event
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.ReactElement
import react.children
import react.cloneElement
import react.dom.RDOMBuilder
import react.dom.div
import react.dom.li
import react.dom.ol
import react.dom.span
import react.dom.tag
import react.setState

interface CarouselProps : RProps {
  var defaultActiveIndex: Int
}

interface CarouselState : RState {
  var activeIndex: Int
}

class CarouselComponent(props: CarouselProps) : RComponent<CarouselProps, CarouselState>(props) {
  override fun CarouselState.init(props: CarouselProps) {
    activeIndex = props.defaultActiveIndex
  }

  override fun shouldComponentUpdate(nextProps: CarouselProps, nextState: CarouselState): Boolean {
    return (nextState.activeIndex != state.activeIndex || nextProps.defaultActiveIndex != state.activeIndex)
  }

  override fun componentWillUpdate(nextProps: CarouselProps, nextState: CarouselState) {
    // TODO Use animations for transitions
  }

  override fun RBuilder.render() {
    val children = this@CarouselComponent.getChildren()
    div("carousel slide") {
      if (children.isNotEmpty()) {
        ol("carousel-indicators") {
          for (i in 0 until children.size) {
            li(if (i == state.activeIndex) "active" else "") { }
          }
        }
      }
      if (children.isNotEmpty()) {
        div("carousel-inner") {
          for (i in 0 until children.size) {
            // ReactElements are immutable, so gotta clone
            val toClone = children[i]
            child(cloneElement<CarouselItemProps>(toClone, toClone.props.children, props = {
              this.isActive = (state.activeIndex == i)
            }))
          }
        }
      }

      carouselButton("carousel-control-prev") {
        attrs.onClickFunction = activateItem(state.activeIndex - 1)
        span("carousel-control-prev-icon") {}
      }

      carouselButton("carousel-control-next") {
        attrs.onClickFunction = activateItem(state.activeIndex + 1)
        span("carousel-control-next-icon") {}
      }
    }
  }

  private fun activateItem(index: Int): (Event) -> Unit = {
    if (index >= 0 && index < getChildren().size) {
      setState {
        activeIndex = index
      }
    }
  }
}

private inline fun RBuilder.carouselButton(classes: String? = null, block: RDOMBuilder<A>.() -> Unit): ReactElement = tag(block) {
  A(attributesMapOf("class", classes,
      "role", "button"
  ), it)
}

fun RBuilder.carousel(defaultActiveIndex: Int, block: RBuilder.() -> Unit): ReactElement {
  return child<CarouselProps, CarouselComponent> {
    attrs.defaultActiveIndex = defaultActiveIndex
    block()
  }
}
