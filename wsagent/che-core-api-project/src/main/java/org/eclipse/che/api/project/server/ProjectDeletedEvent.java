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
package org.eclipse.che.api.project.server;

import org.eclipse.che.api.core.notification.EventOrigin;

/**
 * Publish when project deleted.
 *
 * @author Evgen Vidolob
 */
@EventOrigin("project")
public class ProjectDeletedEvent {

    private String projectPath;

    public ProjectDeletedEvent(String projectPath) {
        this.projectPath = projectPath;
    }

    public String getProjectPath() {
        return projectPath;
    }

    @Override
    public String toString() {
        return "ProjectDeletedEvent{" +
               "projectPath='" + projectPath + '\'' +
               '}';
    }
}
