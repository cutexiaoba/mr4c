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

package com.google.mr4c.config.execution;

import java.net.URI;

import org.junit.*;
import static org.junit.Assert.*;

public class DirectoryConfigTest {

	private DirectoryConfig m_config1a;
	private DirectoryConfig m_config1b;
	private DirectoryConfig m_config2;

	@Before public void setup() throws Exception {
		m_config1a = ConfigTestUtils.buildDirectoryConfig1();
		m_config1b = ConfigTestUtils.buildDirectoryConfig1();
		m_config2 = ConfigTestUtils.buildDirectoryConfig2();
	}

	@Test public void testEquals() {
		assertEquals(m_config1a, m_config1b);
	}

	@Test public void testNotEqual() {
		assertFalse(m_config1a.equals(m_config2));
	}

}
