package com.lewismorgan.web.misc

import org.w3c.dom.Document
import org.w3c.dom.events.Event
import react.RBuilder
import react.RComponent
import react.RHandler
import react.RProps
import react.RState
import react.ReactElement
import react.children

/**
 * Created by lewis on 6/23/18.
 */
@Suppress("NOTHING_TO_INLINE", "UNUSED_PARAMETER")
inline fun jsIsArray(a: Any?) = js("typeof a === 'object' && a.constructor === Array") as Boolean

/**
 * Converts the array of functions into a single function for handlers that take a single function.
 * @param functions Array<out Function1<Event, Unit>>
 * @return (Event) -> Unit
 */
fun <T> chainedFunction(vararg functions: (T) -> Unit): (T) -> Unit {
  return functions.reduce { acc, func ->
    {
      acc.apply { func(it) }
      func.apply { acc(it) }
    }
  }
}

/**
 * Return a list of all the children elements for the receiver. A single element in the children is
 * transformed to an array automatically for type safety.
 * @receiver RComponent<P, S>
 * @return Array<ReactElement>
 */
fun <P : RProps, S : RState> RComponent<P, S>.getChildren(): Array<ReactElement> {
  return if (jsIsArray(props.children)) {
    props.children.unsafeCast<Array<ReactElement>>()
  } else {
    // If there is a single element, it's not known as an array just an object
    arrayOf(props.children.unsafeCast<ReactElement>())
  }
}

fun RBuilder.navHashLink(to: String, onClick: (Event) -> Unit,
                         className: String? = null,
                         activeClassName: String = "active",
                         handler: RHandler<NavHashLinkProps>) = child<NavHashLinkProps, NavHashLinkComponent> {
  attrs {
    this.to = to
    this.className = className
    this.activeClassName = activeClassName
    this.onClick = onClick
    this.smooth = true
  }
  handler.invoke(this)
}

fun getDocHeight(document: Document): Int {
  return listOf(
      document.body!!.clientHeight,
      document.body!!.offsetHeight, document.documentElement!!.clientHeight,
      document.body!!.scrollHeight, document.documentElement!!.scrollHeight).max()!!
}