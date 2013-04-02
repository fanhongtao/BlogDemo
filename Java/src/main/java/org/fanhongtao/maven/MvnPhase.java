/*
 * Copyright (C) 2013 Fan Hongtao (http://www.fanhongtao.org)
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
package org.fanhongtao.maven;

import java.util.HashMap;
import java.util.Map;

/**
 * Demo of what's happening when call a Maven phase.
 * 
 * @author Fan Hongtao &ltfanhongtao@gmail.com&gt
 */
public class MvnPhase {

    /** Phases in life-cycle clean */
    private static final String[] CLEAN = { "pre-clean", "clean", "post-clean" };

    /** Phases in life-cycle default */
    private static final String[] DEFAULT = { "validate", "initialize", "generate-sources", "process-sources",
            "generate-resources", "process-resources", "compile", "process-classes", "generate-test-sources",
            "process-test-sources", "generate-test-resources", "process-test-resources", "test-compile",
            "process-test-classes", "test", "prepare-package", "package", "pre-integration-test", "integration-test",
            "post-integration-test", "verify", "install", "deploy" };

    /** Phases in life-cycle site */
    private static final String[] SITE = { "pre-site", "site", "post-site", "site-deploy" };

    private static Map<String, String[]> phaseMap = new HashMap<String, String[]>();
    static {
        for (String phase : CLEAN) {
            phaseMap.put(phase, CLEAN);
        }
        for (String phase : DEFAULT) {
            phaseMap.put(phase, DEFAULT);
        }
        for (String phase : SITE) {
            phaseMap.put(phase, SITE);
        }
    }

    /**
     * Call a phase
     * 
     * @param phase
     */
    void call(String phase) {
        String[] lifeCycle = phaseMap.get(phase);
        if (lifeCycle == null) {
            throw new RuntimeException();
        }

        System.out.println("=================");
        for (String p : lifeCycle) {
            System.out.println("Execute phase: " + p);
            if (p.equals(phase)) {
                break;
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MvnPhase mvn = new MvnPhase();
        mvn.call("clean");
        mvn.call("test");
    }
}
