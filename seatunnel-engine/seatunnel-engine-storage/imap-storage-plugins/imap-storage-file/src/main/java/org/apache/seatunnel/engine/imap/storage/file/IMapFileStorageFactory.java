/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 *
 */

package org.apache.seatunnel.engine.imap.storage.file;

import static org.apache.seatunnel.engine.imap.storage.file.common.FileConstants.FileInitProperties.HDFS_CONFIG_KEY;

import org.apache.seatunnel.engine.imap.storage.api.IMapStorage;
import org.apache.seatunnel.engine.imap.storage.api.IMapStorageFactory;
import org.apache.seatunnel.engine.imap.storage.api.exception.IMapStorageException;

import org.apache.hadoop.conf.Configuration;

import java.util.Map;

public class IMapFileStorageFactory implements IMapStorageFactory {
    @Override
    public String factoryIdentifier() {
        return "hdfs";
    }

    @Override
    public IMapStorage create(Map<String, Object> initMap) throws IMapStorageException {
        IMapFileStorage iMapFileStorage = new IMapFileStorage();
        Configuration configuration = new Configuration();
        configuration.set("fs.defaultFS", (String) initMap.get("fs.defaultFS"));
        initMap.put(HDFS_CONFIG_KEY, configuration);
        iMapFileStorage.initialize(initMap);
        return iMapFileStorage;
    }
}
