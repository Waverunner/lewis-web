package com.lewismorgan.web.bootstrap.carousel

import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.ReactElement
import react.dom.div

interface CarouselItemProps : RProps {
  var isActive: Boolean
}

/**
 * Created by lewis on 6/16/18.
 */
class CarouselItemComponent : RComponent<CarouselItemProps, RState>() {
  override fun RBuilder.render() {
    div("carousel-item${if (props.isActive) " active" else ""}") {
      div("container") {
        children()
      }
    }
  }
}

fun RBuilder.carouselItem(block: RBuilder.() -> Unit): ReactElement {
  return child<CarouselItemProps, CarouselItemComponent> {
    block()
  }
}

fun RBuilder.carouselCaption(classes: String, block: RBuilder.() -> Unit): ReactElement {
  return div("carousel-caption $classes") { block() }
}