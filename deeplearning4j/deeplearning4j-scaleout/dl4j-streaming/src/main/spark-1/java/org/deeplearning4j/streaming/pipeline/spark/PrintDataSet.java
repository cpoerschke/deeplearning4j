/*******************************************************************************
 * Copyright (c) 2015-2018 Skymind, Inc.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Apache License, Version 2.0 which is available at
 * https://www.apache.org/licenses/LICENSE-2.0.
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 *
 * SPDX-License-Identifier: Apache-2.0
 ******************************************************************************/

package org.deeplearning4j.streaming.pipeline.spark;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.api.java.function.VoidFunction;
import org.nd4j.linalg.dataset.DataSet;

/**
 * Created by agibsonccc on 6/11/16.
 */
public class PrintDataSet implements Function<JavaRDD<DataSet>, Void> {
    @Override
    public Void call(JavaRDD<DataSet> dataSetJavaRDD) throws Exception {
        dataSetJavaRDD.foreach(new VoidFunction<DataSet>() {
            @Override
            public void call(DataSet dataSet) throws Exception {
                System.out.println(dataSet);
            }
        });

        return null;
    }
}

