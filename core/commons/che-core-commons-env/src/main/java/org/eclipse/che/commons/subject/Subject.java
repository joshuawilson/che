/*******************************************************************************
 * Copyright (c) 2012-2016 Codenvy, S.A.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Codenvy, S.A. - initial API and implementation
 *******************************************************************************/
package org.eclipse.che.commons.subject;

import javax.ws.rs.ForbiddenException;

/**
 * Subject represents authenticated user
 *
 * @author andrew00x
 * @author Sergii Leschenko
 */
public interface Subject {
    /** Unidentified subject */
    Subject ANONYMOUS = new Subject() {
        @Override
        public String getUserId() {
            return "0000-00-0000";
        }

        @Override
        public String getUserName() {
            return "Anonymous";
        }

        @Override
        public boolean isMemberOf(String role) {
            return false;
        }

        @Override
        public boolean hasPermission(String domain, String instance, String action) {
            return false;
        }

        @Override
        public void checkPermission(String domain, String instance, String action) throws ForbiddenException {

        }

        @Override
        public String getToken() {
            return null;
        }

        @Override
        public boolean isTemporary() {
            return false;
        }
    };

    /**
     * Get user unique identifier.
     *
     * <p>Note: In comparison with name id never changes for the given user.
     *
     * @return unique identifier of user.
     */
    String getUserId();

    /**
     * @return name of user
     */
    String getUserName();

    /**
     * Checks is subject in specified {@code role}.
     *
     * @param role
     *         role name to check
     * @return {@code true} if subject in role and {@code false} otherwise
     */
    boolean isMemberOf(String role);

    /**
     * Checks does subject have specified permission.
     *
     * @return {@code true} if subject has permission to perform given action and {@code false} otherwise
     */
    boolean hasPermission(String domain, String instance, String action);

    /**
     * Ensures this Subject has specified permission.
     *
     * @throws ForbiddenException
     *         if subject doesn't have specified permission
     */
    void checkPermission(String domain, String instance, String action) throws ForbiddenException;

    /**
     * @return subject auth token to be able to execute request as subject
     */
    String getToken();

    /**
     * @return - true if subject is temporary, false if this is a real persistent subject.
     */
    boolean isTemporary();
}
