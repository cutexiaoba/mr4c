/**
  * Copyright 2014 Google Inc. All rights reserved.
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

package com.google.mr4c.serialize.bean;

import com.google.mr4c.dataset.Dataset;
import com.google.mr4c.dataset.DatasetTestUtils;
import com.google.mr4c.serialize.DatasetSerializer;
import com.google.mr4c.serialize.json.JsonDatasetBeanSerializer;

import java.io.StringReader;
import java.io.StringWriter;

import org.junit.*;
import static org.junit.Assert.*;

public class BeanBasedDatasetSerializerTest {

	private Dataset m_dataset;
	private DatasetSerializer m_serializer;

	@Before public void setup() throws Exception {
		m_dataset = DatasetTestUtils.buildDataset1();
		m_dataset.release();
		m_serializer = new BeanBasedDatasetSerializer(
			new JsonDatasetBeanSerializer()
		);
	}

	@Test public void testDataset() throws Exception {
		StringWriter writer = new StringWriter();
		m_serializer.serializeDataset(m_dataset, writer);
		String serialized = writer.toString();
		StringReader reader = new StringReader(serialized);
		Dataset dataset2 = m_serializer.deserializeDataset(reader);
		assertEquals(m_dataset, dataset2);
	}

}

