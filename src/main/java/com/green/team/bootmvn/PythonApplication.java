package com.green.team.bootmvn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.green.team.bootmvn.service.PythonService;
import com.green.team.bootmvn.service.PythonVirtualEnvService;

@Component
public class PythonApplication {

    @Autowired
    PythonVirtualEnvService pythonVirtualEnvService;
    @Autowired
    PythonService pythonService;

    public void runPython() {
        System.out.println("RunPython");
        pythonVirtualEnvService.runVirtualEnv();
    }
}
