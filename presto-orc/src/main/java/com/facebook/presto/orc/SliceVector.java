/*
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
package com.facebook.presto.orc;

import com.google.common.annotations.VisibleForTesting;
import io.airlift.slice.Slice;

public class SliceVector
        implements Vector
{
    public final Slice[] vector = new Slice[MAX_VECTOR_LENGTH];

    @Override
    @VisibleForTesting
    public ObjectVector toObjectVector(int size)
    {
        ObjectVector objectVector = new ObjectVector();
        for (int i = 0; i < size; i++) {
            if (vector[i] != null) {
                objectVector.vector[i] = vector[i].toStringUtf8();
            }
        }
        return objectVector;
    }
}
