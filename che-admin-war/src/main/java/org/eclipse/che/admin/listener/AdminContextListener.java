/*******************************************************************************
 * Copyright (c) 2012-2015 Codenvy, S.A.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Codenvy, S.A. - initial API and implementation
 *******************************************************************************/
package org.eclipse.che.admin.listener;

import com.google.inject.Module;

import org.eclipse.che.api.core.rest.ApiInfoService;
import org.eclipse.che.plugin.PluginGuiceModule;
import org.everrest.guice.servlet.EverrestGuiceContextListener;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Florent Benoit
 */
public class AdminContextListener extends EverrestGuiceContextListener {

    @Override
    protected List<Module> getModules() {
        List<Module> modules = new ArrayList<>();
        modules.add(binder -> {
            binder.bind(ApiInfoService.class);
            binder.install(new PluginGuiceModule());
        });


        return modules;
    }
}
