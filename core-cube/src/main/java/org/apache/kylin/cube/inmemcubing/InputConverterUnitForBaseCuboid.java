/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
*/

package org.apache.kylin.cube.inmemcubing;

import org.apache.kylin.common.util.ByteArray;
import org.apache.kylin.gridtable.GTRecord;

public class InputConverterUnitForBaseCuboid implements InputConverterUnit<ByteArray> {

    public static final ByteArray EMPTY_ROW = ByteArray.EMPTY;
    public static final ByteArray CUT_ROW = new ByteArray(0);

    public void convert(ByteArray currentObject, GTRecord record) {
        record.loadColumns(currentObject.asBuffer());
    }

    public boolean ifEnd(ByteArray currentObject) {
        if (currentObject == null) {
            return false;
        }
        return currentObject == EMPTY_ROW;
    }

    public ByteArray getEmptyUnit() {
        return EMPTY_ROW;
    }

    public ByteArray getCutUnit() {
        return CUT_ROW;
    }

    @Override
    public boolean ifCut(ByteArray currentObject) {
        if (currentObject == null) {
            return false;
        }
        return currentObject == CUT_ROW;
    }
}