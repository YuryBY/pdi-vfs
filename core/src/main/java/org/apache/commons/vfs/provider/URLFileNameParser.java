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

package org.apache.commons.vfs.provider;

import org.apache.commons.vfs.FileName;
import org.apache.commons.vfs.FileSystemException;
import org.apache.commons.vfs.FileType;

/**
 * Implementation for any url based filesystem.<br />
 * Parses the url into user/password/host/port/path/queryString<br />
 *
 * @author imario@apache.org
 * @version $Revision: 804548 $ $Date: 2009-08-15 22:12:32 -0400 (Sat, 15 Aug 2009) $
 */
public class URLFileNameParser extends HostFileNameParser
{
    public URLFileNameParser(final int defaultPort)
    {
        super(defaultPort);
    }

    public boolean encodeCharacter(char ch)
    {
        return super.encodeCharacter(ch) || ch == '?';
    }

    public FileName parseUri(final VfsComponentContext context, FileName base, final String filename)
            throws FileSystemException
    {
        // FTP URI are generic URI (as per RFC 2396)
        final StringBuffer name = new StringBuffer();

        // Extract the scheme and authority parts
        final Authority auth = extractToPath(filename, name);

        // Extract the queryString
        String queryString = UriParser.extractQueryString(name);

        // Decode and normalise the file name
        UriParser.canonicalizePath(name, 0, name.length(), this);
        UriParser.fixSeparators(name);
        FileType fileType = UriParser.normalisePath(name);
        final String path = name.toString();

        return new URLFileName(
            auth.getScheme(),
            auth.getHostName(),
            auth.getPort(),
            getDefaultPort(),
            auth.getUserName(),
            auth.getPassword(),
            path,
            fileType,
            queryString);
    }
}
