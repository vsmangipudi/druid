/*
 * Licensed to Metamarkets Group Inc. (Metamarkets) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. Metamarkets licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package io.druid.query.topn;

import io.druid.query.ColumnSelectorPlus;
import io.druid.query.aggregation.Aggregator;
import io.druid.query.topn.types.TopNColumnSelectorStrategy;
import io.druid.segment.Cursor;

import javax.annotation.Nullable;

/**
 */
public interface TopNAlgorithm<DimValSelector, Parameters extends TopNParams>
{
  Aggregator[] EMPTY_ARRAY = {};
  int INIT_POSITION_VALUE = -1;
  int SKIP_POSITION_VALUE = -2;

  TopNParams makeInitParams(ColumnSelectorPlus<TopNColumnSelectorStrategy> selectorPlus, Cursor cursor);

  void run(
      Parameters params,
      TopNResultBuilder resultBuilder,
      DimValSelector dimValSelector,
      @Nullable TopNQueryMetrics queryMetrics
  );

  void cleanup(Parameters params);
}
