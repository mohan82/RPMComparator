/*
 *  Copyright 2003 jRPM Team
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.jguild.jrpm.io.constant;

import java.io.Serializable;


/**
 * Interface for all enum objects
 *
 * @author kuss
 */
public interface EnumIf extends Serializable {
    /**
     * Global unknown id
     */
    public static final int _UNKNOWN = -1;

    /**
     * Get the id of this enum object
     *
     * @return The id
     */
    public abstract long getId();

    /**
     * Get the name of this enum object
     *
     * @return The name
     */
    public abstract String getName();
}
