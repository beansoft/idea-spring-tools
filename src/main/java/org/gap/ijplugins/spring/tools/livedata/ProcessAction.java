/*
 *  Copyright (c) 2020 Gayan Perera
 *
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
 * Contributors:
 *     Gayan Perera <gayanper@gmail.com> - initial API and implementation
 */

package org.gap.ijplugins.spring.tools.livedata;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import org.jetbrains.annotations.NotNull;

public class ProcessAction extends AnAction {
    private final StsApplicationManager manager;
    private final ProcessCommandInfo info;

    public ProcessAction(StsApplicationManager manager, ProcessCommandInfo info) {
        this.manager = manager;
        this.info = info;
    }

    @Override
    public void update(@NotNull AnActionEvent e) {
        e.getPresentation().setText(String.format("%s [%s]", info.getLabel(), info.getAction()));
    }

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        manager.sendCommand(e.getProject(), info);
    }

    @Override
    public boolean isDumbAware() {
        return false;
    }
}
