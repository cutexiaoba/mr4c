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

package com.google.mr4c.hadoop;

import java.io.IOException;

import org.apache.hadoop.mapred.JobConf;

public interface HadoopTestBinding {

	JobConf createTestMRJobConf() throws IOException;

	void runMiniMRJob(String name, MR4CMRJob bbJob) throws IOException;

	void shutdownMRCluster();

	/**
	  * Returns true if deprecated file system property shows up in results of generic argument parsing
	*/
	boolean expectedDeprecatedFileSysProp();

}


