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

package org.apache.commons.vfs.operations.vcs;

import org.apache.commons.vfs.operations.FileOperation;

/**
 *
 * @author Siarhei Baidun
 * @since 0.1
 */
public interface VcsCommit extends FileOperation
{

    /**
     *
     * @param isRecursive true if directories should be traversed.
     */
    void setRecursive(final boolean isRecursive);

    /**
     *
     * @param message The message.
     */
    void setMessage(final String message);

    /**
     *
     * @param listener Listener that is given control when a commit occurs.
     */
    void addCommitListener(final VcsCommitListener listener);

    /**
     *
     * @param listener The Listener.
     */
    void removeCommitListener(final VcsCommitListener listener);
}
