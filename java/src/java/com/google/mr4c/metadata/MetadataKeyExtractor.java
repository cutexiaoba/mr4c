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

package com.google.mr4c.metadata;

import com.google.mr4c.keys.DataKey;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
  * Finds all the keys in a metadata structure
*/
public class MetadataKeyExtractor extends DefaultMetadataVisitor {

	private Set<DataKey> m_keys = Collections.synchronizedSet( new HashSet<DataKey>() );
	
	public static Set<DataKey> findKeys(MetadataList list) {
		return findKeysHelper(list);
	}
		
	public static Set<DataKey> findKeys(MetadataMap map) {
		return findKeysHelper(map);
	}

	private static Set<DataKey> findKeysHelper(MetadataElement element) {
		MetadataKeyExtractor extractor = new MetadataKeyExtractor();
		element.accept(extractor);
		return extractor.getKeys();
	}

	public Set<DataKey> getKeys() {
		return m_keys;
	}

	public void visitKey(MetadataKey key) {
		m_keys.add(key.getKey());
	}

}
