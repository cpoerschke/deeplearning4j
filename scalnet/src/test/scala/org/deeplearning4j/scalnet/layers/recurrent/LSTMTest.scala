/*
 * Copyright 2016 Skymind
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.deeplearning4j.scalnet.layers.recurrent

import org.scalatest.{ Matchers, WordSpec }

class LSTMTest extends WordSpec with Matchers {

  "A LSTM layer" should {

    "have an input layer of shape (10, 100)" in {
      val LSTMLayer = LSTM(10, 100)
      LSTMLayer.inputShape shouldBe List(10, 100)
    }

    "have an ouput layer of shape (10, 100)" in {
      val LSTMLayer = LSTM(10, 100)
      LSTMLayer.outputShape shouldBe List(100, 10)
    }

    "compile to a DL4J LSTM" in {
      val LSTMLayer = LSTM(10, 100)
      val compiledLayer = LSTMLayer.compile
      compiledLayer.isInstanceOf[org.deeplearning4j.nn.conf.layers.LSTM] shouldBe true
    }

  }
}
