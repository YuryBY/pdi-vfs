/*!
* Copyright 2010 - 2013 Pentaho Corporation.  All rights reserved.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
* http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*
*/

package org.apache.commons.vfs.operations;

import org.apache.commons.vfs.FileSystemException;

/**
 * FileOperations interface provides API to work with operations.
 *
 * @see FileOperation on what a operation in the context of VFS is.
 *
 * @author Siarhei Baidun
 * @since 0.1
 */
public interface FileOperations
{
    /**
     * @return all operations associated with the fileObject
     * @throws FileSystemException if an error occurs.
     */
    Class[] getOperations() throws FileSystemException;

    /**
     * @param operationClass the operation Class.
     * @return a operation implementing the given <code>operationClass</code>
     * @throws FileSystemException if an error occus.
     */
    FileOperation getOperation(Class operationClass) throws FileSystemException;

    /**
     * @param operationClass the operation Class.
     * @return if a operation <code>operationClass</code> is available
     * @throws FileSystemException if an error ocurs.
     */
    boolean hasOperation(Class operationClass) throws FileSystemException;
}
