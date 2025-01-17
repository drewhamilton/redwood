/*
 * Copyright (C) 2024 Square, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package app.cash.redwood.lazylayout.view

import android.view.View
import app.cash.paparazzi.DeviceConfig
import app.cash.paparazzi.Paparazzi
import app.cash.redwood.lazylayout.AbstractLazyListTest
import app.cash.redwood.lazylayout.widget.LazyList
import app.cash.redwood.snapshot.testing.Snapshotter
import app.cash.redwood.snapshot.testing.TestWidgetFactory
import app.cash.redwood.snapshot.testing.ViewSnapshotter
import app.cash.redwood.snapshot.testing.ViewTestWidgetFactory
import org.junit.Rule

class ViewLazyListTest : AbstractLazyListTest<View>() {

  @get:Rule
  val paparazzi = Paparazzi(
    deviceConfig = DeviceConfig.PIXEL_6,
    theme = "android:Theme.Material.Light.NoActionBar",
    supportsRtl = true,
  )

  override val widgetFactory: TestWidgetFactory<View>
    get() = ViewTestWidgetFactory(paparazzi.context)

  override fun lazyList(backgroundColor: Int): LazyList<View> {
    return ViewLazyList(paparazzi.context).apply {
      value.setBackgroundColor(backgroundColor)
    }
  }

  override fun snapshotter(widget: View): Snapshotter = ViewSnapshotter(paparazzi, widget)
}
